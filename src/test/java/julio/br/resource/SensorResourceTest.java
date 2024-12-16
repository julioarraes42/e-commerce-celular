package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import julio.br.dto.SensorDTO;
import julio.br.dto.SensorResponseDTO;
import julio.br.service.SensorService;

@QuarkusTest
public class SensorResourceTest {

    // @Inject
    // public SensorService sensorService;

    // @Test
    // @TestSecurity(user = "user", roles = { "Funcionario" })
    // public void findAllTest() {
    //     given()
    //             .when()
    //             .get("/Sensor")
    //             .then()
    //             .statusCode(200)
    //             .body("tipo", hasItem(is("luz")));
    // }

    // @Test
    // @TestSecurity(user = "user", roles = { "Funcionario" })
    // public void createTest() {
    //     SensorDTO dtoSensor = new SensorDTO("radio");

    //     given()
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .body(dtoSensor)
    //             .when()
    //             .post("Sensor")
    //             .then()
    //             .statusCode(201)
    //             .body("tipo", is("radio"));
    // }

    // @Test
    // @TestSecurity(user = "user", roles = { "Funcionario" })
    // public void updateTest() {
    //     SensorDTO dtoSensor = new SensorDTO("radio");

    //     given()
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .body(dtoSensor)
    //             .when()
    //             .pathParam("id", 3)
    //             .put("/Sensor/{id}")
    //             .then()
    //             .statusCode(204);
    // }

    // @Test
    // @TestSecurity(user = "user", roles = { "Funcionario" })
    // public void deleteTest() {
    //     SensorResponseDTO response = sensorService.create(new SensorDTO("radio"));

    //     given()
    //             .when()
    //             .pathParam("id", response.id())
    //             .delete("/Sensor/{id}")
    //             .then()
    //             .statusCode(204);

    //     sensorService.delete(response.id());
    // }

}
