package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import julio.br.dto.PortaSlotDTO;
import julio.br.dto.PortaSlotResponseDTO;
import julio.br.service.PortaSlotService;

@QuarkusTest
public class PortaSlotResourceTest {

    @Inject
    public PortaSlotService portaSlotService;

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void findAllTest() {
        given()
                .when()
                .get("/PortaSlot")
                .then()
                .statusCode(200)
                .body("tipo", hasItem(is("PINCHER")));
    }

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void createTest() {
        PortaSlotDTO dtoPortaSlot = new PortaSlotDTO("chipSim");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dtoPortaSlot)
                .when()
                .post("/PortaSlot")
                .then()
                .statusCode(201)
                .body("tipo", is("chipSim"));
    }

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void updateTest() {
        PortaSlotDTO dtoPortaSlot = new PortaSlotDTO("ChipSim");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dtoPortaSlot)
                .when()
                .pathParam("id", 3)
                .put("/PortaSlot/{id}")
                .then()
                .statusCode(204);
    }

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void deleteTest() {
        PortaSlotResponseDTO response = portaSlotService.create(new PortaSlotDTO("ChipSim"));

        given()
                .when()
                .pathParam("id", response.id())
                .delete("/PortaSlot/{id}")
                .then()
                .statusCode(204);

        portaSlotService.delete(response.id());
    }

}
