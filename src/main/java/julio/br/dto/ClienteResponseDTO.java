package julio.br.dto;

import julio.br.model.Cliente;

public record ClienteResponseDTO(
        String nome,
        String cep,
        String cpf,
        String login,
        String Senha) {

    public static ClienteResponseDTO valueOff(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getNome(),
                cliente.getCep(),
                cliente.getCpf(),
                cliente.getUsuario().getLogin(),
                cliente.getUsuario().getSenha());
    }

}
