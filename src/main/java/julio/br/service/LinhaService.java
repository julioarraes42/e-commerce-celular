package julio.br.service;

import java.util.List;

import julio.br.dto.LinhaResponseDTO;

public interface LinhaService {

    public List<LinhaResponseDTO> findAll();

    public Long count();

}
