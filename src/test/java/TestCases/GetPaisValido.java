package TestCases;

import BaseTests.TestBase;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class GetPaisValido extends TestBase {

    @Description("Validação do País")
    @DisplayName("Consulta País Válido")
    @Test
    public void consultarPaisValido(){
        Response response =
                given()
                        .spec(requestSpecification)
                .when()
                        .get()
                .then()
                        .log().body()
                        .assertThat()
                        .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema.json"))
                        .extract().response();

        String name = response.then().extract().path("name[0]");
        Assertions.assertEquals("Brazil", name);
    }

    @Description("Validação da capital")
    @DisplayName("Consulta capital")
    @Test
    public void validarCapitalDoPaisConsultado(){
        Response response =
                given()
                        .spec(requestSpecification)
                .when()
                        .get()
                .then()
                        .log().body()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        String capital = response.then().extract().path("capital[0]");
        Assertions.assertEquals("Brasília", capital);
    }

}
