package julio.br.dto;

import julio.br.model.Tela;

public record TelaResponseDTO(
        Long id,
        Float tamanho,
        Float resolucao) {

    public static TelaResponseDTO valuesOf(Tela tela) {
        return new TelaResponseDTO(
                tela.getId(),
                tela.getTamanho(),
                tela.getResolucao());
    }

}
