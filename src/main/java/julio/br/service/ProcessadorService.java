package julio.br.service;

import java.util.List;

import julio.br.dto.ProcessadorDTO;
import julio.br.dto.ProcessadorResponseDTO;

public interface ProcessadorService {
    public List<ProcessadorResponseDTO> findAll();

    public ProcessadorResponseDTO create(ProcessadorDTO dto);

    public void update(Long id, ProcessadorDTO dto);

    public void delete(Long id);
}
