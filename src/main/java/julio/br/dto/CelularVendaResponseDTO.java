package julio.br.dto;

import julio.br.model.CelularVenda;

public record CelularVendaResponseDTO(
        Long idCelular,
        int quantidade) {

    public static CelularVendaResponseDTO valueOff(CelularVenda celularVenda) {
        return new CelularVendaResponseDTO(
                celularVenda.getCelular().getId(),
                celularVenda.getQuantidade());
    }

}