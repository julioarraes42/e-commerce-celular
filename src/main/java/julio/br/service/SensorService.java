package julio.br.service;

import java.util.List;

import julio.br.dto.SensorDTO;
import julio.br.dto.SensorResponseDTO;

public interface SensorService {

    public List<SensorResponseDTO> findAll();

    public SensorResponseDTO create(SensorDTO dto);

    public void update(Long id, SensorDTO dto);

    public void delete(Long id);

}
