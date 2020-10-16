package br.com.fcoromoto.estudo.quarkus.bitcoins.resources;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BitcoinResourceTest {


    @Test
    public void deve_retornar_sucesso_quando_get_retornar_200(){
        RestAssured.given()
                .get("bitcoins")
                .then()
                .statusCode(200);
    }
}