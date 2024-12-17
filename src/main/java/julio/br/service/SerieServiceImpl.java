package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import julio.br.dto.SerieDTO;
import julio.br.dto.SerieResponseDTO;
import julio.br.dto.SerieResponseDTO;
import julio.br.model.Serie;
import julio.br.repository.LinhaRepository;
import julio.br.repository.SerieRepository;

@ApplicationScoped
public class SerieServiceImpl implements SerieService {

    @Inject
    public SerieRepository serieRepository;

    @Inject
    public LinhaRepository linhaRepository;

    @Override
    public List<SerieResponseDTO> findAll() {
        return serieRepository
                .findAll()
                .stream()
                .map(e -> SerieResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public Long count() {
        return serieRepository.count();
    }

    @Override
    public SerieResponseDTO findById(Long id) {
        Serie serie = serieRepository.findById(id);
        return SerieResponseDTO.valuesOf(serie);
    }

    @Override
    public SerieResponseDTO create(SerieDTO dto) {
        Serie serie = new Serie();
        serie.setNome(dto.nome());
        serie.setAnoLancamento(dto.anoLancamento());
        serieRepository.persist(serie);

        serie.setLinha(linhaRepository.findById(dto.linha()));
        linhaRepository.persist(linhaRepository.findById(dto.linha()));

        return SerieResponseDTO.valuesOf(serie);
    }

    @Override
    public void update(Long id, SerieDTO dto) {
        Serie serie = serieRepository.findById(id);
        serie.setNome(dto.nome());
        serie.setAnoLancamento(dto.anoLancamento());
        serieRepository.persist(serie);
    }

    @Override
    public void delete(Long id) {
        Serie serie = serieRepository.findById(id);
        serieRepository.delete(serie);
    }

    

}
