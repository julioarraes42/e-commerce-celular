package julio.br.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import julio.br.dto.CameraDTO;
import julio.br.dto.CelularDTO;
import julio.br.dto.CelularResponseDTO;
import julio.br.model.Camera;
import julio.br.model.Celular;
import julio.br.model.Linha;
import julio.br.model.PortaSlot;
import julio.br.model.Processador;
import julio.br.model.Sensor;
import julio.br.model.Serie;
import julio.br.model.Tela;
import julio.br.repository.CameraRepository;
import julio.br.repository.CelularRepository;
import julio.br.repository.EnderecoRepository;
import julio.br.repository.LinhaRepository;
import julio.br.repository.PortaSlotRepository;
import julio.br.repository.ProcessadorRepository;
import julio.br.repository.SensorRepository;
import julio.br.repository.SerieRepository;
import julio.br.repository.TelaRepository;
import julio.br.validation.ValidationException;
import io.quarkus.panache.common.Page;

@ApplicationScoped
public class CelularServiceImpl implements CelularService {

    @Inject
    public CelularRepository celularRepository;

    @Inject
    public TelaRepository telaRepository;

    @Inject
    public ProcessadorRepository processadorRepository;

    @Inject
    public SerieRepository serieRepository;

    @Inject
    public CameraRepository cameraRepository;

    @Inject
    public PortaSlotRepository portaSlotRepository;

    @Inject
    public SensorRepository sensorRepository;

    @Inject
    public LinhaRepository linhaRepository;

    @Override
    @Transactional
    public CelularResponseDTO create(@Valid CelularDTO dto) {
        validarNomeEstado(dto.nome());
        validarPortaSlot(dto.idPortaSlot());
        validarSensor(dto.idSensor());

        Celular celular = new Celular();
        celular.setMarca(dto.marca());
        celular.setNome(dto.nome());
        celular.setAnoLancamento(dto.anoLancamento());
        celular.setArmazenamento(dto.armazenamento());
        celular.setRam(dto.ram());
        celular.setPreco(dto.preco());
        celular.setEstoque(0);

        celular.setPortaSlot(new ArrayList<PortaSlot>());
        celular.setCamera(new ArrayList<Camera>());
        celular.setSensor(new ArrayList<Sensor>());

        celularRepository.persist(celular);

        serieRepository.persist(serieRepository.findById(dto.idSerie()));
        celular.setSerie(serieRepository.findById(dto.idSerie()));

        celular.setProcessador(processadorRepository.findById(dto.idProcessador()));
        processadorRepository.persist(processadorRepository.findById(dto.idProcessador()));

        System.out.println(dto.toString());
        celular.setTela(telaRepository.findById(dto.idTela()));
        telaRepository.persist(telaRepository.findById(dto.idTela()));

        for (Long camera : dto.idCamera()) {
            if (camera != null && camera != 0) {
                celular.getCamera().add(cameraRepository.findById(camera));
            }
        }

        for (Long porta : dto.idPortaSlot()) {
            if (porta != null && porta != 0) {
                celular.getPortaSlot().add(portaSlotRepository.findById(porta));
            }
        }

        for (Long sensor : dto.idSensor()) {
            if (sensor != null && sensor != 0) {
                celular.getSensor().add(sensorRepository.findById(sensor));
            }
        }

        return CelularResponseDTO.valuesOff(celular);
    }

    @Override
    public List<CelularResponseDTO> findAll(int page, int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("Page size must be greater than 0");
        }

        List<Celular> celulares = celularRepository
                .findAll()
                .page(Page.of(page, pageSize))
                .list();

        return celulares
                .stream()
                .map(CelularResponseDTO::valuesOff)
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByNome(String nome, int page, int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("Page size must be greater than 0");
        }

        List<Celular> celulares = celularRepository
                .findByNome(nome)
                .page(Page.of(page, pageSize))
                .list();

        return celulares
                .stream()
                .map(CelularResponseDTO::valuesOff)
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByMarca(String marca, int page, int pageSize) {
        List<Celular> celulares = celularRepository
                .findByMarca(marca)
                .page(page, pageSize)
                .list();

        return celulares
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    @Override
    public Long count() {
        return celularRepository.count();
    }

    @Override
    @Transactional
    public void update(Long id, @Valid CelularDTO dto) {
        validarNomeEstado(dto.nome());
        validarPortaSlot(dto.idPortaSlot());
        validarSensor(dto.idSensor());

        Celular celularBanco = celularRepository.findById(id);

        celularBanco.setMarca(dto.marca());
        celularBanco.setNome(dto.nome());
        celularBanco.setAnoLancamento(dto.anoLancamento());
        celularBanco.setArmazenamento(dto.armazenamento());
        celularBanco.setRam(dto.ram());
        celularBanco.setPreco(dto.preco());

        celularBanco.setProcessador(processadorRepository.findById(dto.idProcessador()));
        celularBanco.setSerie(serieRepository.findById(dto.idSerie()));

        celularBanco.getTela().setResolucao(telaRepository.findById(dto.idTela()).getResolucao());
        celularBanco.getTela().setTamanho(telaRepository.findById(dto.idTela()).getTamanho());

        for (int i = 0; i < dto.idCamera().size(); i++) {
            celularBanco.getCamera().get(i)
                    .setResolucao(cameraRepository.findById(dto.idCamera().get(i)).getResolucao());
            celularBanco.getCamera().get(i).setFrontal(cameraRepository.findById(dto.idCamera().get(i)).getFrontal());
        }

    }

    @Override
    public void delete(Long id) {
        celularRepository.deleteById(id);
    }

    @Override
    public List<CelularResponseDTO> findByMarca(String marca) {
        return celularRepository.findByMarca(marca)
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByNome(String nome) {
        return celularRepository.findByNome(nome)
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByAnoLancamento(LocalDate anoLancamento) {
        return celularRepository.findByAnoLancamento(anoLancamento)
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByArmazenamento(Float armazenamento) {
        return celularRepository.findByArmazenamento(armazenamento)
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByRam(Float ram) {
        return celularRepository.findByRam(ram)
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    @Override
    public List<CelularResponseDTO> findByPreco(Float preco) {
        return celularRepository.findByPreco(preco)
                .stream()
                .map(e -> CelularResponseDTO.valuesOff(e))
                .toList();
    }

    public void validarNomeEstado(String nome) {
        if (nome.matches(".*\\d.*"))
            throw new ValidationException("nome", "O nome '" + nome + "' não deve possuir apenas numeros.");
    }

    public void validarPortaSlot(List<Long> idPortaSlot) {
        for (int i = 0; i < idPortaSlot.size(); i++) {
            PortaSlot portaSlot = portaSlotRepository.findById(idPortaSlot.get(i));

            if (portaSlot == null) {
                throw new ValidationException("portaSlot",
                        "foi informado uma Porta ou Slot que nao existe ou nao foi registrada");
            }
        }
    }

    public void validarSensor(List<Long> idSensor) {
        for (int i = 0; i < idSensor.size(); i++) {
            PortaSlot portaSlot = portaSlotRepository.findById(idSensor.get(i));

            if (portaSlot == null) {
                throw new ValidationException("sensor",
                        "foi informado um sensor que nao existe ou nao foi registrada");
            }
        }
    }

    @Override
    @Transactional
    public void definirEstoque(Long id, int quantidade) {
        Celular celular = celularRepository.findById(id);
        celular.setEstoque(quantidade);
    }

    @Override
    public void adicionarEstoque(Long id, int quantidade) {
        Celular celular = celularRepository.findById(id);
        celular.setEstoque(celularRepository.findById(id).getEstoque() + quantidade);
    }

    @Override
    public void diminuirEstoque(Long id, int quantidade) {
        Celular celular = celularRepository.findById(id);
        celular.setEstoque(celularRepository.findById(id).getEstoque() - quantidade);
    }

    @Override
    public CelularResponseDTO findById(Long id) {
        Celular celular = celularRepository.findById(id);
        return CelularResponseDTO.valuesOff(celular);
    }

}