package julio.br.resource;

import org.jboss.logging.Logger;

import jakarta.annotation.security.RolesAllowed;
// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.AlterarEmailDTO;
import julio.br.dto.AlterarSenhaDTO;
import julio.br.dto.AlterarUsernameDTO;
import julio.br.dto.FuncionarioDTO;
import julio.br.service.FuncionarioService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    public FuncionarioService funcionarioService;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @GET
    public Response findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        LOG.info("Procurando todos os funcionarios");
        return Response.ok(funcionarioService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.info("buscando um funcionario por id");
        return Response.ok(funcionarioService.findById(id)).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        LOG.info("Procurando funcionario por nome");
        return Response.ok(funcionarioService.findByNome(nome, page, pageSize)).build();
    }

    @POST
    @Transactional
    public Response create(FuncionarioDTO dto) {
        return Response.status(Status.CREATED).entity(funcionarioService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        funcionarioService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        funcionarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/alterar/senha/{senhaAntiga}/{novaSenha}")
    public Response alterarSenha(@PathParam("novaSenha") String senhaNova,
            @PathParam("senhaAntiga") String senhaAntiga) {
        LOG.info("mudar senha");
        funcionarioService.alterarSenha(senhaAntiga, senhaNova);
        return Response.noContent().build();
    }

    @GET
    @Path("/count")
    public long count() {
        return funcionarioService.count();
    }

        @PATCH
    @Path("/search/alterar-senha")
    @RolesAllowed({ "Funcionario" })
    public Response alterarSenha(AlterarSenhaDTO dto) {
        try {
            LOG.info("Senha alterada com sucesso");
            funcionarioService.alterarSenha(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao tentar alterar senha");
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar senha").build();
        }
    }

    @PATCH
    @Path("/search/alterar-email")
    @RolesAllowed({ "Funcionario" })
    public Response alterarEmail(AlterarEmailDTO dto) {
        try {
            LOG.info("Email alterado com sucesso.");
            funcionarioService.alterarEmail(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao alterar email, cliente.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar Email").build();
        }
    }

    @PATCH
    @Path("/search/alterar-username")
    @RolesAllowed({ "Funcionario" })
    public Response alterarUsername(AlterarUsernameDTO dto) {
        try {
            LOG.info("Username alterado com sucesso.");
            funcionarioService.alterarUsername(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao tentar alterar Username.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar Username").build();
        }
    }

    @GET
    @Path("/search/meu-perfil")
    @RolesAllowed({ "Funcionario" })
    public Response meuPerfil() {
        try {
            LOG.info("Buscando perfil do funcionario logado");
            return Response.ok(funcionarioService.findMeuPerfil()).build();
        } catch (Exception e) {
            LOG.error("Erro ao buscar perfil do funcionario.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao buscar perfil do funcionario.").build();
        }
    }

}
