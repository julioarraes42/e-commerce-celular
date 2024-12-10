package julio.br.service;

import java.util.List;

import julio.br.dto.TelaDTO;
import julio.br.dto.TelaResponseDTO;

public interface TelaService {

    public TelaResponseDTO findById(Long id);

    public List<TelaResponseDTO> findAll(int page, int pageSize);

    public List<TelaResponseDTO> findByTamanho(Float tamanho, int page, int pageSize);

    public Long count();

    public TelaResponseDTO create(TelaDTO dto);

    public void update(Long id, TelaDTO dto);

    public void delete(Long id);

}
