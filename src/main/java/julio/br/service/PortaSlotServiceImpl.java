package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import julio.br.dto.PortaSlotDTO;
import julio.br.dto.PortaSlotResponseDTO;
import julio.br.model.PortaSlot;
import julio.br.model.Celular;
import julio.br.repository.CelularRepository;
import julio.br.repository.PortaSlotRepository;

@ApplicationScoped
public class PortaSlotServiceImpl implements PortaSlotService {

    @Inject
    public PortaSlotRepository portaSlotRepository;

    @Inject
    public CelularRepository celularRepository;

    @Override
    public List<PortaSlotResponseDTO> findAll() {
        return portaSlotRepository
                .listAll()
                .stream()
                .map(e -> PortaSlotResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    @Transactional
    public PortaSlotResponseDTO create(PortaSlotDTO dto) {
        PortaSlot portaSlot = new PortaSlot();

        portaSlot.setTipo(dto.tipo());

        portaSlotRepository.persist(portaSlot);
        return PortaSlotResponseDTO.valuesOf(portaSlot);
    }

    @Override
    @Transactional
    public void update(Long id, PortaSlotDTO dto) {
        PortaSlot portaSlot = portaSlotRepository.findById(id);

        portaSlot.setTipo(dto.tipo());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        PortaSlot portaSlot = portaSlotRepository.findById(id);

        List<Celular> celulares = celularRepository.findByPortaSlot(portaSlot);
        for (Celular celular : celulares) {
            celular.getPortaSlot().remove(portaSlot);
            celularRepository.persist(celular);
        }
        portaSlotRepository.deleteById(id);
    }

}
