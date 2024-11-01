package julio.br.resource;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.AutorizacaoUsuarioDTO;
import julio.br.dto.ClienteDTO;
import julio.br.dto.UsuarioResponseDTO;
import julio.br.service.ClienteService;
import julio.br.service.FuncionarioService;
import julio.br.service.HashService;
import julio.br.service.JwtService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Autorizacao")
public class AutorizacaoResource {

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @Inject
    public ClienteService clienteService;

    @Inject
    public FuncionarioService funcionarioService;

    @Inject
    public HashService hashService;

    @Inject
    public JwtService jwtService;

    @POST
    @Transactional
    @Path("/login")
    public Response login(AutorizacaoUsuarioDTO dto) {
        UsuarioResponseDTO usuario = null;
        if (dto.perfil() == 1) {
            usuario = clienteService.login(dto);
            return Response.ok(usuario)
                    .header("Authorization", jwtService.generateJwtCliente(usuario))
                    .build();
        } else if (dto.perfil() == 2) {
            usuario = funcionarioService.login(dto);
            return Response.ok(usuario)
                    .header("Authorization", jwtService.generateJwtFuncionario(usuario))
                    .build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Transactional
    @Path("/registrar")
    public Response create(ClienteDTO dto) {
        LOG.info("INFO");
        return Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
    }

}
