package julio.br.dto;

public record ClienteDTO(
        String nome,
        String cpf,
        String login,
        String senha,
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf) {

}
