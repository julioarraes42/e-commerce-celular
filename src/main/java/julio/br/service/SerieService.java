package julio.br.service;

import java.util.List;

import julio.br.dto.SerieDTO;
import julio.br.dto.SerieResponseDTO;

public interface SerieService {

    public SerieResponseDTO findById(Long id);
    
    public List<SerieResponseDTO> findAll();

    public SerieResponseDTO create(SerieDTO dto);

    public void update(Long id, SerieDTO dto);

    public void delete(Long id);

    public Long count();
}
