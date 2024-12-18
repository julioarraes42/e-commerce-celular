package julio.br.dto;

public record EnderecoDTO(
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf) {
}