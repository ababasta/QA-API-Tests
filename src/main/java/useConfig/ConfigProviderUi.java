package useConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface ConfigProviderUi {
    Config config = ConfigFactory.load("ui.conf");

    static final String START_URL = config.getString("url");
    static final String FIRST_NAME = config.getString("testUser.demo.firstName");
    static final String LAST_NAME = config.getString("testUser.demo.lastName");
    static final String LOGIN = config.getString("testUser.demo.login");
    static final String PASSWORD = config.getString("testUser.demo.password");
}