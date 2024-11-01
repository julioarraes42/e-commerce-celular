package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import julio.br.service.LinhaService;

@QuarkusTest
public class LinhaResourceTest {

    @Inject
    public LinhaService linhaService;

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void findAllTest() {
        given()
                .when()
                .get("/Linha")
                .then()
                .statusCode(200)
                .body("nome", hasItem(is("Linha A")))
                .body("anoLancamento", hasItem(is("2020-01-01")));

    }

}
