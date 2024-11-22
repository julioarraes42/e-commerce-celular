package julio.br.resource;

import org.jboss.logging.Logger;

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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.ClienteDTO;
import julio.br.service.ClienteService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/clientes")
public class ClienteResource {

    @Inject
    public ClienteService clienteService;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @GET
    public Response findAll(
            @PathParam("page") @DefaultValue("0") int page,
            @PathParam("pageSize") @DefaultValue("100") int pageSize
    ) {
        LOG.info("Procurando todos os clientes");
        return Response.ok(clienteService.findAll(page, pageSize)).build();
    }

    @GET
    public Response findByNome(
            @PathParam("nome") String nome,
            @PathParam("page") @DefaultValue("0") int page,
            @PathParam("pageSize") @DefaultValue("100") int pageSize
    ) {
        LOG.info("Procurando cliente por nome");
        return Response.ok(clienteService.findByNome(nome, page, pageSize)).build();
    }

    @POST
    @Transactional
    public Response create(ClienteDTO dto) {
        LOG.info("Registrando um cliente");
        return Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        LOG.info("buscando um cliente por id");
        clienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.info("deletando funcionarios");
        clienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/dados")
    public Response dadosCliente() {
        LOG.info("dados cliente");
        return Response.ok(clienteService.dadosCliente()).build();
    }

    @GET
    @Path("/dados/compras")
    public Response dadosClienteCompras() {
        LOG.info("dados cliente");
        return Response.ok(clienteService.dadosClienteVenda()).build();
    }

    @PATCH
    @Path("/alterar/senha/{senhaAntiga}/{novaSenha}")
    public Response alterarSenha(@PathParam("novaSenha") String senhaNova,
            @PathParam("senhaAntiga") String senhaAntiga) {
        LOG.info("mudar senha");
        clienteService.alterarSenha(senhaAntiga, senhaNova);
        return Response.noContent().build();
    }

}
