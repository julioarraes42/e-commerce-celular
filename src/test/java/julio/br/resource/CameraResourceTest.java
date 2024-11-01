package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import julio.br.service.CameraService;

@QuarkusTest
public class CameraResourceTest {

    @Inject
    public CameraService cameraService;

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void findAllTest() {
        given()
                .when()
                .get("/Camera")
                .then()
                .log().all()
                .statusCode(200)
                .body("resolucao", hasItem(is(12f)))
                .body("frontal", hasItem(is(true)));
    }

}
