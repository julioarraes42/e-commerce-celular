package julio.br.service;

import java.util.List;

import julio.br.dto.SerieResponseDTO;

public interface SerieService {

    public SerieResponseDTO findById(Long id);
    
    public List<SerieResponseDTO> findAll();

    public Long count();
}
