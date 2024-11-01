package julio.br.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.TelaDTO;
import julio.br.service.TelaService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/telas")
public class TelaResource {

    @Inject
    public TelaService telaService;

    @GET
    public Response findAll() {
        return Response.ok(telaService.findAll()).build();
    }

    @POST
    @Transactional
    public Response create(TelaDTO dto) {
        return Response.status(Status.CREATED).entity(telaService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(TelaDTO dto, @PathParam("id") Long id) {
        telaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        telaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}