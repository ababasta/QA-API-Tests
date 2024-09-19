package useConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface ConfigProvider {
    Config config = ConfigFactory.load("application.conf");

    String BASE_URL = config.getString("baseUrl");
}
