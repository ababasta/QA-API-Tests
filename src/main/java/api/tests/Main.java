package api.tests;

import apiTestData.Info;
import apiTestData.RegisterData;
import apiTestData.UserRegistration;


import apiTestData.UserRegistrationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import urlNavigator.Navigator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
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

        Response response = navigator.sendRequestWithoutAuth(url, type, method, 200, postData);

        token = response.jsonPath().getString("token");
//        System.out.println("got token: " + token);
    }

    //    user-controller-new
    @Test
    public void checkUserRegistration() throws JsonProcessingException {

        url = "/api/signup";
        type = ContentType.JSON;
        method = Method.POST;
        UserRegistration postData = new UserRegistration();

        Response response = navigator.sendRequestWithoutAuth(url, type, method, 201, postData);

        ObjectMapper objectMapper = new ObjectMapper();
        UserRegistrationResponse registerResponse = objectMapper.readValue(response.getBody().asString(), UserRegistrationResponse.class);

        System.out.println("Login: " + registerResponse.getRegister_data().getLogin());
        System.out.println("Status: " + registerResponse.getInfo().getStatus());

        assertEquals(postData.getLogin(), registerResponse.getRegister_data().getLogin());
        assertEquals(registerResponse.getInfo().getStatus(), "success");

    }

    @Test
    public void checkUserInfo() throws JsonProcessingException {

        url = "/api/user";
        type = ContentType.JSON;
        method = Method.GET;
        Map<String, Object> postData = new HashMap<>();

        Response response = navigator.sendRequest(url, type, method, 200, postData, token);

        ObjectMapper objectMapper = new ObjectMapper();
        RegisterData userInfo = objectMapper.readValue(response.getBody().asString(), RegisterData.class);

        assertEquals(userInfo.getLogin(), USER_LOGIN_VALUE);

    }

    @Test
    public void checkPassUpdate() {

        url = "/api/user";
        type = ContentType.JSON;
        method = Method.PUT;
        Map<String, Object> postData;
        postData = new HashMap<>();

        UserRegistration newUserData = new UserRegistration();
        postData.put(USER_PASS_FIELD, newUserData.getPass());

        System.out.println("New password: " + newUserData.getPass());

        Response response = navigator.sendRequest(url, type, method, 200, postData, token);

        Info responseInfo = response.jsonPath().getObject("info", Info.class);

        assertEquals(responseInfo.getStatus(), "success");

//      Rollback password update
        postData = new HashMap<>();
        postData.put(USER_PASS_FIELD, USER_PASS_VALUE);

        navigator.sendRequest(url, type, method, 200, postData, token);

    }

    @Test
    public void checkUserDelete() {

        url = "/api/user";
        type = ContentType.JSON;
        method = Method.DELETE;
        Map<String, Object> postData;
        postData = new HashMap<>();

        Response response = navigator.sendRequest(url, type, method, 200, postData, token);

        Info responseInfo = response.jsonPath().getObject("info", Info.class);

        assertEquals(responseInfo.getStatus(), "success");

    }

    @Test
    public void checkLast100Users() {

        url = "/api/users";
        type = ContentType.JSON;
        method = Method.GET;
        Map<String, Object> postData = new HashMap<>();

        Response response = navigator.sendRequestWithoutAuth(url, type, method, 200, postData);
    }


}