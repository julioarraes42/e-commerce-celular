package julio.br.resource;

import org.jboss.logging.Logger;

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
import julio.br.dto.CameraDTO;
import julio.br.service.CameraService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cameras")
public class CameraResource {

    @Inject
    public CameraService cameraService;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @GET
    public Response findAll(
        @QueryParam("page") @DefaultValue ("0") int page,
        @QueryParam("pageSize") @DefaultValue ("100") int pageSize
    ) {
        return Response.ok(cameraService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(cameraService.count()).build();
    }

    @POST
    @Transactional
    public Response create(CameraDTO dto) {
        LOG.info("Registrando uma camera");
        return Response.status(Status.CREATED).entity(cameraService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CameraDTO dto) {
        LOG.info("buscando um camera por id");
        cameraService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.info("deletando Camera");
        cameraService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
