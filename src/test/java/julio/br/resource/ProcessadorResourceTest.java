package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.inject.Inject;
import julio.br.service.ProcessadorService;

@QuarkusTest
public class ProcessadorResourceTest {

    @Inject
    public ProcessadorService processadorService;

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void findAllTest() {
        given()
                .when()
                .get("/Processador")
                .then()
                .statusCode(200)
                .body("marca", hasItem(is("INTEL")))
                .body("modelo", hasItem(is("CORE")));

    }

}
