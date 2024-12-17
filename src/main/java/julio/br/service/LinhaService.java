package julio.br.service;

import java.util.List;

import julio.br.dto.LinhaResponseDTO;

public interface LinhaService {

    public LinhaResponseDTO findById(Long id);

    public List<LinhaResponseDTO> findAll();

    public Long count();

    public LinhaResponseDTO create(LinhaResponseDTO dto);

    public void update(Long id, LinhaResponseDTO dto);

    public void delete(Long id);

}
