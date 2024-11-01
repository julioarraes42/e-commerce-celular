package julio.br.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.dto.UsuarioResponseDTO;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwtCliente(UsuarioResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        roles.add("Cliente");

        return Jwt.issuer("unitins-jwt")
                .subject(dto.login())
                .groups(roles)
                .expiresAt(expiryDate)
                .sign();
    }

    @Override
    public String generateJwtFuncionario(UsuarioResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        roles.add("Funcionario");

        return Jwt.issuer("unitins-jwt")
                .subject(dto.login())
                .groups(roles)
                .expiresAt(expiryDate)
                .sign();
    }

}
