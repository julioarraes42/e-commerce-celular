package julio.br.dto;

import julio.br.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf) {

    public static EnderecoResponseDTO valueOff(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                endereco.getUf());
    }

}
