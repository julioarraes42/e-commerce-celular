package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.VendaDTO;
import julio.br.dto.VendaResponseDTO;

public interface VendaService {
    public VendaResponseDTO create(@Valid VendaDTO dto);

    public List<VendaResponseDTO> findAll();

    public List<VendaResponseDTO> findByCliente(Long idCliente);
}
