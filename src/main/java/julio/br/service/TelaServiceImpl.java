package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import julio.br.dto.TelaDTO;
import julio.br.dto.TelaResponseDTO;
import julio.br.model.Celular;
import julio.br.model.Tela;
import julio.br.repository.CelularRepository;
import julio.br.repository.TelaRepository;

@ApplicationScoped
public class TelaServiceImpl implements TelaService {

    @Inject
    public TelaRepository telaRepository;

    @Inject
    public CelularRepository celularRepository;

    @Override
    public List<TelaResponseDTO> findAll(int page, int pageSize) {
        List<Tela> telas = telaRepository
                            .findAll()
                            .page(page, pageSize)
                            .list();
        
        return telas
                .stream()
                .map(e -> TelaResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public List<TelaResponseDTO> findByTamanho(Float tamanho, int page, int pageSize) {
        List<Tela> telas = telaRepository
                            .findByTamanho(tamanho)
                            .page(page, pageSize)
                            .list();
        
        return telas
                .stream()
                .map(e -> TelaResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public TelaResponseDTO create(TelaDTO dto) {
        Tela tela = new Tela();

        tela.setResolucao(dto.resolucao());
        tela.setTamanho(dto.tamanho());

        telaRepository.persist(tela);
        return TelaResponseDTO.valuesOf(tela);
    }

    @Override
    public void update(Long id, TelaDTO dto) {
        Tela telaBanco = telaRepository.findById(id);

        telaBanco.setResolucao(dto.resolucao());
        telaBanco.setTamanho(dto.tamanho());
    }

    @Transactional
    public void delete(Long id) {
        Tela tela = telaRepository.findById(id);

        List<Celular> celulares = celularRepository.findByTela(tela);

        for (Celular celular : celulares) {
            celular.setTela(null);
            celularRepository.persist(celular);
        }

        telaRepository.delete(tela);
    }

}