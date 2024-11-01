package julio.br.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import julio.br.dto.CameraDTO;
import julio.br.dto.CelularDTO;
import julio.br.dto.CelularResponseDTO;
import julio.br.dto.LinhaDTO;
import julio.br.dto.ProcessadorDTO;
import julio.br.dto.SerieDTO;
import julio.br.dto.TelaDTO;
import julio.br.service.CelularService;

@QuarkusTest
public class CelularResourceTest {

        @Inject
        public CelularService celularService;

        @Test
        public void findAllTest() {
                given()
                                .when()
                                .get("/Celular")
                                .then()
                                .statusCode(200)
                                .body("nome", hasItem(is("OnePlus 9 Pro")));
        }

        @Test
        public void findByMarcaTest() {
                given()
                                .when()
                                .get("/Celular/busca/marca/Samsung")
                                .then()
                                .statusCode(200)
                                .body("marca", everyItem(is("Samsung")));
        }

        @Test
        public void findByNomeTest() {
                given()
                                .when()
                                .get("/Celular/busca/nome/OnePlus 9 Pro")
                                .then()
                                .statusCode(200)
                                .body("nome", everyItem(is("OnePlus 9 Pro")));
        }

        @Test
        public void findByArmazenamentoTest() {
                given()
                                .when()
                                .get("/Celular/busca/armazenamento/128")
                                .then()
                                .statusCode(200)
                                .body("armazenamento", everyItem(is(128f)));
        }

        @Test
        public void findByRamTest() {
                given()
                                .when()
                                .get("/Celular/busca/ram/8")
                                .then()
                                .statusCode(200)
                                .body("ram", everyItem(is(8f)));
        }

        @Test
        public void findByPrecoTest() {
                given()
                                .when()
                                .get("/Celular/busca/preco/999.99")
                                .then()
                                .statusCode(200)
                                .body("preco", everyItem(is(999.99f)));
        }

        @Test
        public void findByAnoLancamentoTest() {
                given()
                                .when()
                                .get("/Celular/busca/lancamento/2020-11-02")
                                .then()
                                .statusCode(200)
                                .body("anoLancamento", everyItem(is("2020-11-02")));
        }

        @Test
        @TestSecurity(user = "user", roles = { "Funcionario" })
        public void createTest() {
                LocalDate data = LocalDate.of(2021, 04, 25);

                LinhaDTO dtoLinha = new LinhaDTO(4L, "tri", data);

                TelaDTO dtoTela = new TelaDTO(50f, 64f);
                ProcessadorDTO dtoProcessador = new ProcessadorDTO(4L, "avengers", "tablet");
                SerieDTO dtoSerie = new SerieDTO(4L, "tributo", data, dtoLinha);

                CameraDTO dtoCamera = new CameraDTO(64f, true);
                List<CameraDTO> cameras = new ArrayList<CameraDTO>();
                cameras.add(dtoCamera);

                CelularDTO dtoCelular = new CelularDTO(
                                dtoTela,
                                cameras,
                                new ArrayList<Long>(),
                                new ArrayList<Long>(),
                                dtoProcessador,
                                dtoSerie,
                                "caruso",
                                "tributario",
                                data,
                                1000f,
                                12f,
                                999f);

                dtoCelular.idPortaSlot().add(1l);
                dtoCelular.idSensor().add(1l);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dtoCelular)
                                .when()
                                .post("/Celular")
                                .then()
                                .statusCode(201)
                                .body("tela.tamanho", is(dtoTela.tamanho()))
                                .body("tela.resolucao", is(dtoTela.resolucao()))
                                .body("camera[0].resolucao", is((cameras.get(0).resolucao())))
                                .body("camera[0].frontal", is(cameras.get(0).frontal()))
                                .body("portaSlot[0].id", is(dtoCelular.idPortaSlot().get(0).intValue()))
                                .body("sensor[0].id", is(dtoCelular.idSensor().get(0).intValue()))
                                .body("processador.id", is(dtoProcessador.id().intValue()))
                                .body("serie.id", is(dtoSerie.id().intValue()))
                                .body("marca", is("caruso"))
                                .body("nome", is("tributario"))
                                .body("armazenamento", is(1000f))
                                .body("ram", is(12f))
                                .body("preco", is(999f));

        }

        @Test
        @TestSecurity(user = "user", roles = { "Funcionario" })
        public void validacaoPortaSlotTest() {
                LocalDate data = LocalDate.of(2021, 04, 25);

                LinhaDTO dtoLinha = new LinhaDTO(4L, "tri", data);

                TelaDTO dtoTela = new TelaDTO(50f, 64f);
                ProcessadorDTO dtoProcessador = new ProcessadorDTO(4L, "avengers", "tablet");
                SerieDTO dtoSerie = new SerieDTO(4L, "tributo", data, dtoLinha);

                CameraDTO dtoCamera = new CameraDTO(64f, true);
                List<CameraDTO> cameras = new ArrayList<CameraDTO>();
                cameras.add(dtoCamera);

                CelularDTO dtoCelular = new CelularDTO(
                                dtoTela,
                                cameras,
                                new ArrayList<Long>(),
                                new ArrayList<Long>(),
                                dtoProcessador,
                                dtoSerie,
                                "caruso",
                                "tributario",
                                data,
                                1000f,
                                12f,
                                999f);

                dtoCelular.idPortaSlot().add(0l);
                dtoCelular.idSensor().add(1l);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dtoCelular)
                                .when()
                                .post("/Celular")
                                .then()
                                .statusCode(400);

        }

        @Test
        @TestSecurity(user = "user", roles = { "Funcionario" })
        public void validacaoSensorTest() {
                LocalDate data = LocalDate.of(2021, 04, 25);

                LinhaDTO dtoLinha = new LinhaDTO(4L, "tri", data);

                TelaDTO dtoTela = new TelaDTO(50f, 64f);
                ProcessadorDTO dtoProcessador = new ProcessadorDTO(4L, "avengers", "tablet");
                SerieDTO dtoSerie = new SerieDTO(4L, "tributo", data, dtoLinha);

                CameraDTO dtoCamera = new CameraDTO(64f, true);
                List<CameraDTO> cameras = new ArrayList<CameraDTO>();
                cameras.add(dtoCamera);

                CelularDTO dtoCelular = new CelularDTO(
                                dtoTela,
                                cameras,
                                new ArrayList<Long>(),
                                new ArrayList<Long>(),
                                dtoProcessador,
                                dtoSerie,
                                "caruso",
                                "tributario",
                                data,
                                1000f,
                                12f,
                                999f);

                dtoCelular.idPortaSlot().add(1l);
                dtoCelular.idSensor().add(0l);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dtoCelular)
                                .when()
                                .post("/Celular")
                                .then()
                                .statusCode(400);

        }

        @Test
        @TestSecurity(user = "user", roles = { "Funcionario" })
        public void validacaoNomeTest() {
                LocalDate data = LocalDate.of(2021, 04, 25);

                LinhaDTO dtoLinha = new LinhaDTO(5L, "tri", data);

                TelaDTO dtoTela = new TelaDTO(50f, 64f);
                ProcessadorDTO dtoProcessador = new ProcessadorDTO(5L, "avengers", "tablet");
                SerieDTO dtoSerie = new SerieDTO(5L, "tributo", data, dtoLinha);

                CameraDTO dtoCamera = new CameraDTO(64f, true);
                List<CameraDTO> cameras = new ArrayList<CameraDTO>();
                cameras.add(dtoCamera);

                CelularDTO dtoCelular = new CelularDTO(
                                dtoTela,
                                cameras,
                                new ArrayList<Long>(),
                                new ArrayList<Long>(),
                                dtoProcessador,
                                dtoSerie,
                                "1111",
                                "1111",
                                data,
                                1000f,
                                12f,
                                999f);

                dtoCelular.idPortaSlot().add(1l);
                dtoCelular.idSensor().add(1l);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dtoCelular)
                                .when()
                                .post("/Celular")
                                .then()
                                .statusCode(400);

        }

        @Test
        @TestSecurity(user = "user", roles = { "Funcionario" })
        public void updateTest() {

                LocalDate data = LocalDate.of(2021, 04, 25);

                LinhaDTO dtoLinha = new LinhaDTO(3L, "tri", data);

                TelaDTO dtoTela = new TelaDTO(50f, 64f);
                ProcessadorDTO dtoProcessador = new ProcessadorDTO(3L, "avengers", "tablet");
                SerieDTO dtoSerie = new SerieDTO(3L, "tributo", data, dtoLinha);

                CameraDTO dtoCamera = new CameraDTO(64f, true);
                List<CameraDTO> cameras = new ArrayList<CameraDTO>();
                cameras.add(dtoCamera);

                CelularDTO dtoCelular = new CelularDTO(
                                dtoTela,
                                cameras,
                                List.of(2l),
                                List.of(2l),
                                dtoProcessador,
                                dtoSerie,
                                "caruso",
                                "tributario",
                                data,
                                1000f,
                                12f,
                                999f);
                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dtoCelular)
                                .when()
                                .pathParam("id", 1)
                                .put("/Celular/{id}")
                                .then()
                                .statusCode(204);

        }

        @Test
        @TestSecurity(user = "user", roles = { "Funcionario" })
        public void deleteTest() {

                LocalDate data = LocalDate.of(2021, 04, 25);

                LinhaDTO dtoLinha = new LinhaDTO(4L, "tri", data);

                TelaDTO dtoTela = new TelaDTO(50f, 64f);
                ProcessadorDTO dtoProcessador = new ProcessadorDTO(4L, "avengers", "tablet");
                SerieDTO dtoSerie = new SerieDTO(4L, "tributo", data, dtoLinha);

                CameraDTO dtoCamera = new CameraDTO(64f, true);
                List<CameraDTO> cameras = new ArrayList<CameraDTO>();
                cameras.add(dtoCamera);

                CelularResponseDTO response = celularService.create(new CelularDTO(
                                dtoTela,
                                cameras,
                                new ArrayList<Long>(),
                                new ArrayList<Long>(),
                                dtoProcessador,
                                dtoSerie,
                                "caruso",
                                "tributario",
                                data,
                                1000f,
                                12f,
                                999f));

                given()
                                .when()
                                .pathParam("id", response.id())
                                .delete("/Celular/{id}")
                                .then()
                                .statusCode(204);
        }

}
