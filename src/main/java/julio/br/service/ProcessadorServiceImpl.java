package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import julio.br.dto.ProcessadorDTO;
import julio.br.dto.ProcessadorResponseDTO;
import julio.br.model.Celular;
import julio.br.model.Processador;
import julio.br.repository.CelularRepository;
import julio.br.repository.ProcessadorRepository;

@ApplicationScoped
public class ProcessadorServiceImpl implements ProcessadorService {

    @Inject
    public ProcessadorRepository processadorRepository;

    @Inject
    public CelularRepository celularRepository;

    @Override
    public List<ProcessadorResponseDTO> findAll(int page, int pageSize) {
        List<Processador> processadores = processadorRepository
                                                    .findAll()
                                                    .page(page, pageSize)
                                                    .list();

        return processadores
                .stream()
                .map(e -> ProcessadorResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public List<ProcessadorResponseDTO> findByMarca(String marca, int page, int pageSize) {
        List<Processador> processadores = processadorRepository
                .findByMarca(marca)
                .page(page, pageSize)
                .list();

        return processadores
                .stream()
                .map(e -> ProcessadorResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    @Transactional
    public ProcessadorResponseDTO create(ProcessadorDTO dto) {
        Processador processador = new Processador();

        processador.setMarca(dto.marca());
        processador.setModelo(dto.modelo());

        processadorRepository.persist(processador);
        return ProcessadorResponseDTO.valuesOf(processador);
    }

    @Override
    @Transactional
    public void update(Long id, ProcessadorDTO dto) {
        Processador processador = processadorRepository.findById(id);

        processador.setMarca(dto.marca());
        processador.setModelo(dto.modelo());
    }

    @Transactional
    public void delete(Long id) {
        Processador processador = processadorRepository.findById(id);

        List<Celular> celulares = celularRepository.findByProcessador(processador);

        for (Celular celular : celulares) {
            celular.setProcessador(null);
            celularRepository.persist(celular);
        }

        processadorRepository.delete(processador);
    }

}
