package urlNavigator;

import io.restassured.*;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import static useConfig.ConfigProvider.*;

public class Specifications {
    public static RequestSpecification requestSpec(String url, ContentType type){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .setContentType(type)
                .setRelaxedHTTPSValidation()
                .build();
    }

    public static ResponseSpecification responseSpec(int code){
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .expectResponseTime(lessThan(MAX_RESPONSE_TIME), TimeUnit.SECONDS)
                .build();
    }

    public static void initSpecifications(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }


}