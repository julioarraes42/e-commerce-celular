package julio.br.service;

import java.util.List;

import julio.br.dto.PortaSlotDTO;
import julio.br.dto.PortaSlotResponseDTO;

public interface PortaSlotService {
    public List<PortaSlotResponseDTO> findAll(int page, int pageSize);

    public PortaSlotResponseDTO create(PortaSlotDTO dto);

    public void update(Long id, PortaSlotDTO dto);

    public void delete(Long id);

}
