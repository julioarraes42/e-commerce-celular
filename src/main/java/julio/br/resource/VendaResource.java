package julio.br.resource;

import jakarta.annotation.security.RolesAllowed;
// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.VendaDTO;
import julio.br.service.ClienteService;
import julio.br.service.VendaService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Venda")
public class VendaResource {

    @Inject
    public ClienteService clienteService;

    @Inject
    public VendaService vendaService;

    @GET
    @RolesAllowed("Funcionario")
    public Response findAll() {
        return Response.ok(vendaService.findAll()).build();
    }

    @GET
    @Path("/busca/cliente/{idCliente}")
    public Response findByCliente(@PathParam("idCliente") Long idCliente) {
        return Response.ok(vendaService.findByCliente(idCliente)).build();
    }

    @POST
    @Transactional
    @RolesAllowed("Cliente")
    public Response create(VendaDTO dto) {
        return Response.status(Status.CREATED).entity(vendaService.create(dto)).build();
    }
}
