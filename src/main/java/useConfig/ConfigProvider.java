package useConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.hamcrest.Matcher;


public interface ConfigProvider {
    Config config = ConfigFactory.load("application.conf");

    static final String BASE_URL = config.getString("baseUrl");
    static final long MAX_RESPONSE_TIME = config.getLong("maxResponseTime");
}
