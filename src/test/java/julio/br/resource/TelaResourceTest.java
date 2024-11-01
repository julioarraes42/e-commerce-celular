package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.inject.Inject;
import julio.br.service.TelaService;

@QuarkusTest
public class TelaResourceTest {

    @Inject
    public TelaService telaService;

    @Test
    @TestSecurity(user = "user", roles = { "Funcionario" })
    public void findAllTest() {
        given()
                .when()
                .get("/Tela")
                .then()
                .statusCode(200)
                .body("tamanho", hasItem(is(6.5f)))
                .body("resolucao", hasItem(is(1920f)));
    }

}
