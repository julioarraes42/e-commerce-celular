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
    @Path("/{id}")
    // @RolesAllowed("Funcionario")
    public Response findById(Long id) {
        return Response.ok(linhaService.findById(id)).build();
    }

    @GET
    @Path("/count")
    // @RolesAllowed("Funcionario")
    public Response count() {
        return Response.ok(linhaService.count()).build();
    }

    // @POST
    // @RolesAllowed("Funcionario") 
    // public Response create(LinhaDTO dto) {
    //     return Response.ok(linhaService.create(dto)).build();
    // }

    // @PUT
    // @Path("/{id}")
    // @RolesAllowed("Funcionario")
    // public Response update(Long id, LinhaDTO dto) {
    //     linhaService.update(id, dto);
    //     return Response.ok().build();
    // }

    // @DELETE
    // @Path("/{id}")
    // @RolesAllowed("Funcionario")
    // public Response delete(Long id) {
    //     linhaService.delete(id);
    //     return Response.ok().build();
    // }
    

}
