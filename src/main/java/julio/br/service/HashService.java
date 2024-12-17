package julio.br.service;

public interface HashService {
    String getHashSenha(String senha);
    boolean verificandoHash(String senha, String hash);
}
