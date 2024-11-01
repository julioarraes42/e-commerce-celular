package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import julio.br.dto.SerieResponseDTO;
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

}
