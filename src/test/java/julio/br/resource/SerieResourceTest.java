package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.inject.Inject;
import julio.br.service.SerieService;

import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class SerieResourceTest {

    @Inject
    public SerieService serieService;

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void findAllTest() {

        given()
                .when()
                .get("/Serie")
                .then()
                .statusCode(200)
                .body("nome", hasItem(is("Série X")))
                .body("anoLancamento", hasItem(is("2021-03-20")));
    }

}
