package api.tests;

import static useConfig.ConfigProvider.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Base Url = " + BASE_URL);
        System.out.println("Admin Pass = " + config.getString("usersParams.admin.password"));
    }
}