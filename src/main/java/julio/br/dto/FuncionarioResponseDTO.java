package julio.br.dto;

import julio.br.model.Funcionario;

public record FuncionarioResponseDTO(
        Long id,
        String nome,
        String cep,
        String cpf,
        String cnpj,
        String login,
        String senha) {

    public static FuncionarioResponseDTO valueOff(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCep(),
                funcionario.getCpf(),
                funcionario.getCnpj(),
                funcionario.getUsuario().getLogin(),
                funcionario.getUsuario().getSenha());
    }

}
