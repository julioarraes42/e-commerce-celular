package julio.br.service;

import java.util.List;

import julio.br.dto.TelaDTO;
import julio.br.dto.TelaResponseDTO;

public interface TelaService {

    public List<TelaResponseDTO> findAll();

    public TelaResponseDTO create(TelaDTO dto);

    public void update(Long id, TelaDTO dto);

    public void delete(Long id);

}
