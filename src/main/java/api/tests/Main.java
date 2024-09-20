package api.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import org.apache.commons.lang3.ObjectUtils;


import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import urlNavigator.Navigator;

import java.util.HashMap;
import java.util.Map;

import static useConfig.ConfigProvider.*;

public class Main {

    //System.out.println("Base Url = " + BASE_URL);
    //System.out.println("Admin Pass = " + config.getString("usersParams.admin.password"));

    static Navigator navigator = new Navigator();

    private static String url;
    private static ContentType type;
    private static Method method;
    private static String token;

    @BeforeAll
    public static void getAuthToken() {
        url = "/api/login";
        type = ContentType.JSON;
        method = Method.POST;
        Map<String, Object> postData = new HashMap<>();
        postData.put(USER_LOGIN_FIELD, USER_LOGIN_VALUE);
        postData.put(USER_PASS_FIELD, USER_PASS_VALUE);

        Response response = navigator.sendRequest(url, type, method, postData);

        // Извлекаем токен из ответа
        token = response.jsonPath().getString("token");
//        System.out.println("got token: " + token);
    }

    @Test
    public void checkLast100Users() {

        url = "/api/users";
        type = ContentType.JSON;
        method = Method.GET;
        Map<String, Object> postData = new HashMap<>();

        Response response = navigator.sendRequest(url, type, method, postData);
    }

    @Test
    public void checkUserInfo() {

        url = "/api/user";
        type = ContentType.JSON;
        method = Method.GET;
        Map<String, Object> postData = new HashMap<>();

        Response response = navigator.sendRequestAuth(url, type, method, postData, token);

        String login = response.jsonPath().getString("login");

        Assertions.assertEquals(login, USER_LOGIN_VALUE);

    }
}