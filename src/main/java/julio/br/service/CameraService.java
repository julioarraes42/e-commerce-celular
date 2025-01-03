package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.CameraDTO;
import julio.br.dto.CameraResponseDTO;

public interface CameraService {

    public CameraResponseDTO findById(Long id);

    public List<CameraResponseDTO> findAll(int page, int pageSize);

    public Long count();

    public CameraResponseDTO create(@Valid CameraDTO dto);

    public void update(Long id, CameraDTO dto);

    public void delete(Long id);

}
