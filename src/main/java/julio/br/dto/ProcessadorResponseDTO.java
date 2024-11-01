package julio.br.dto;

import julio.br.model.Processador;

public record ProcessadorResponseDTO(
        Long id,
        String marca,
        String modelo) {
    public static ProcessadorResponseDTO valuesOf(Processador processador) {
        return new ProcessadorResponseDTO(
                processador.getId(),
                processador.getMarca(),
                processador.getModelo());
    }
}
