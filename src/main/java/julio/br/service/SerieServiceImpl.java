package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import julio.br.dto.SerieResponseDTO;
import julio.br.dto.SerieResponseDTO;
import julio.br.model.Serie;
import julio.br.repository.SerieRepository;

@ApplicationScoped
public class SerieServiceImpl implements SerieService {

    @Inject
    public SerieRepository serieRepository;

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

}
