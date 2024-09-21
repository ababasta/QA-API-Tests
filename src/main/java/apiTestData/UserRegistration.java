package apiTestData;

import com.github.javafaker.Faker;

public class UserRegistration {
    private String login;
    private String pass;

    public UserRegistration() {
        Faker faker = new Faker();
        this.login = faker.name().username();
        this.pass = faker.internet().password(8, 16);
    }

    public UserRegistration(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
