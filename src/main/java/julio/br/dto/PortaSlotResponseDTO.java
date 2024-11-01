package julio.br.dto;

import julio.br.model.PortaSlot;

public record PortaSlotResponseDTO(
        Long id,
        String tipo) {

    public static PortaSlotResponseDTO valuesOf(PortaSlot portaSlot) {
        return new PortaSlotResponseDTO(
                portaSlot.getId(),
                portaSlot.getTipo());
    }
}
