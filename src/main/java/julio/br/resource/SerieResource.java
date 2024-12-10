package julio.br.resource;

// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import julio.br.service.SerieService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/Serie")
public class SerieResource {

    @Inject
    public SerieService serieService;

    @GET
    // @RolesAllowed("Funcionario")
    public Response findAll() {
        return Response.ok(serieService.findAll()).build();
    }

    @GET
    @Path("/count")
    // @RolesAllowed("Funcionario")
    public Response count() {
        return Response.ok(serieService.count()).build();
    }

}
