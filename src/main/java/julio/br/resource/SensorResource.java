package julio.br.resource;

// import jakarta.annotation.security.RolesAllowed;
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
import julio.br.dto.SensorDTO;
import julio.br.service.SensorService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Sensor")
public class SensorResource {

    @Inject
    public SensorService sensorService;

    @GET
    // @RolesAllowed("Funcionario")
    public Response findAll() {
        return Response.ok(sensorService.findAll()).build();
    }

    @GET
    @Path("/count")
    // @RolesAllowed("Funcionario")
    public Response count() {
        return Response.ok(sensorService.count()).build();
    }

    @POST
    // @RolesAllowed("Funcionario")
    @Transactional
    public Response create(SensorDTO dto) {
        return Response.status(Status.CREATED).entity(sensorService.create(dto)).build();
    }

    @PUT
    // @RolesAllowed("Funcionario")
    @Transactional
    @Path("/{id}")
    public Response update(SensorDTO dto, @PathParam("id") Long id) {
        sensorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    // @RolesAllowed("Funcionario")
    @Transactional
    @Path("/{id}")
    public Response delet(@PathParam("id") Long id) {
        sensorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
