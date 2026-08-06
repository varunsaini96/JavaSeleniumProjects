package RESTAPITesting;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class APIKeyExtraction {
    public static String key = "x-api-key";
        private static final Config config = ConfigFactory.load(); //searching for application.conf

        public static String getValue() {
            return config.getString("apiKey");
        }
    }
