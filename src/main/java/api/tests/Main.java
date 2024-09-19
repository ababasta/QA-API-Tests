package api.tests;



import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import urlNavigator.Navigator;

import static useConfig.ConfigProvider.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Base Url = " + BASE_URL);
        //System.out.println("Admin Pass = " + config.getString("usersParams.admin.password"));

        Navigator navigator = new Navigator();
        Response response = navigator.sendRequest("/v2/api-docs", ContentType.JSON, Method.GET);

    }
}