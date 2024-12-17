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
    @Path("/{id}")
    // @RolesAllowed("Funcionario")
    public Response findById(Long id) {
        return Response.ok(serieService.findById(id)).build();
    }

    @GET
    @Path("/count")
    // @RolesAllowed("Funcionario")
    public Response count() {
        return Response.ok(serieService.count()).build();
    }

    // @POST
    // @RolesAllowed("Funcionario")
    // public Response create(SerieDTO dto) {
    //     return Response.ok(serieService.create(dto)).build();
    // }

    // @PUT
    // @Path("/{id}")
    // @RolesAllowed("Funcionario")
    // public Response update(Long id, SerieDTO dto) {
    //     serieService.update(id, dto);
    //     return Response.ok().build();
    // }

    // @DELETE
    // @Path("/{id}")
    // @RolesAllowed("Funcionario")
    // public Response delete(Long id) {
    //     serieService.delete(id);
    //     return Response.ok().build();
    // }

    

}
