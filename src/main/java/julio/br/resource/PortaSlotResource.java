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
import julio.br.dto.PortaSlotDTO;
import julio.br.service.PortaSlotService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/portaSlots")
public class PortaSlotResource {

    @Inject
    public PortaSlotService portaSlotService;

    @GET
    public Response findAll(
        @QueryParam("page") @DefaultValue ("0") int page,
        @QueryParam("pageSize") @DefaultValue ("100") int pageSize
    ) {
        return Response.ok(portaSlotService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(portaSlotService.findById(id)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(portaSlotService.count()).build();
    }

    @POST
    @Transactional
    public Response create(PortaSlotDTO dto) {
        return Response.status(Status.CREATED).entity(portaSlotService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(PortaSlotDTO dto, @PathParam("id") Long id) {
        portaSlotService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        portaSlotService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
