package julio.br.resource;

// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.ProcessadorDTO;
import julio.br.service.ProcessadorService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/processadores")
public class ProcessadorResource {

    @Inject
    public ProcessadorService processadorService;

    @GET
    public Response findAll(
        @QueryParam("page") @DefaultValue ("0") int page,
        @QueryParam("pageSize") @DefaultValue ("100") int pageSize
    ) {
        return Response.ok(processadorService.findAll(page, pageSize)).build();
    }

    @GET
    public Response findByMarca(
        @QueryParam("marca") String marca,
        @QueryParam("page") @DefaultValue ("0") int page,
        @QueryParam("pageSize") @DefaultValue ("100") int pageSize
    ) {
        return Response.ok(processadorService.findByMarca(marca, page, pageSize)).build();
    }

    @POST
    @Transactional
    public Response create(ProcessadorDTO dto) {
        return Response.status(Status.CREATED).entity(processadorService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(ProcessadorDTO dto, @PathParam("id") Long id) {
        processadorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        processadorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}