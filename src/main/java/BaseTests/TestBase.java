package BaseTests;

import Utils.DataClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBase extends DataClass {
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;

    @BeforeAll
    public static void setUpUrlRestcountries(){
        buildRequestSpec();
        buildResponseSpec();
    }

    private static void buildRequestSpec(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(basePath)
                .build();
    }

    private static void buildResponseSpec(){
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.HTML)
                .build();
    }

}
