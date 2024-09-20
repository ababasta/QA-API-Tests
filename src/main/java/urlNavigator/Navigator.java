package urlNavigator;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.commons.lang3.ObjectUtils;

import static io.restassured.RestAssured.given;

public class Navigator {
    public void reset() {
        RestAssured.reset();
    }

    public Response sendRequest(String url, ContentType type, Method method, Object object) {
        this.reset();

        Specifications.initSpecifications(Specifications.requestSpec(url, type), Specifications.responseSpec(200));

        Response response = given()
                    .body(object)
                    .when()
                    .request(method);

        response.then()
                .log().all();
        return response;
    }

    public Response sendRequestAuth(String url, ContentType type, Method method, Object object, String token) {
        this.reset();

        Specifications.initSpecifications(Specifications.requestSpec(url, type), Specifications.responseSpec(200));

        Response response = given()
                .body(object)
                .header("Authorization", "Bearer " + token)
                .when()
                .request(method);

        response.then()
                .log().all();
        return response;
    }
}
