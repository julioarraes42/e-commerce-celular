package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import julio.br.dto.LinhaResponseDTO;
import julio.br.dto.LinhaResponseDTO;
import julio.br.model.Linha;
import julio.br.repository.LinhaRepository;

@ApplicationScoped
public class LinhaServiceImpl implements LinhaService {

    @Inject
    public LinhaRepository linhaRepository;

    @Override
    public List<LinhaResponseDTO> findAll() {
        return linhaRepository
                .findAll()
                .stream()
                .map(e -> LinhaResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public Long count() {
        return linhaRepository.count();
    }

    @Override
    public LinhaResponseDTO findById(Long id) {
        Linha linha = linhaRepository.findById(id);
        return LinhaResponseDTO.valuesOf(linha);
    }

    @Override
    public LinhaResponseDTO create(LinhaResponseDTO dto) {
        Linha linha = new Linha();
        linha.setNome(dto.nome());
        linha.setAnoLancamento(dto.anoLancamento());
        linhaRepository.persist(linha);
        return LinhaResponseDTO.valuesOf(linha);
    }

    @Override
    public void update(Long id, LinhaResponseDTO dto) {
        Linha linha = linhaRepository.findById(id);
        linha.setNome(dto.nome());
        linha.setAnoLancamento(dto.anoLancamento());
        linhaRepository.persist(linha);
    }

    @Override
    public void delete(Long id) {
        Linha linha = linhaRepository.findById(id);
        linhaRepository.delete(linha);
    }

}
