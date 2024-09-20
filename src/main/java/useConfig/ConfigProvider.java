package useConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.hamcrest.Matcher;


public interface ConfigProvider {
    Config config = ConfigFactory.load("application.conf");

    static final String BASE_URL = config.getString("baseUrl");
    static final long MAX_RESPONSE_TIME = config.getLong("maxResponseTime");
    static final String USER_PASS_FIELD = config.getString("testUser.passwordField");
    static final String USER_PASS_VALUE = config.getString("testUser.passwordValue");
    static final String USER_LOGIN_FIELD = config.getString("testUser.loginField");
    static final String USER_LOGIN_VALUE = config.getString("testUser.loginValue");
}
