package julio.br.resource;

// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import julio.br.service.LinhaService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Linha")
public class LinhaResponse {

    @Inject
    public LinhaService linhaService;

    @GET
    // @RolesAllowed("Funcionario")
    public Response findAll() {
        return Response.ok(linhaService.findAll()).build();
    }

    @GET
    @Path("/count")
    // @RolesAllowed("Funcionario")
    public Response count() {
        return Response.ok(linhaService.count()).build();
    }

}
