package RESTAPITesting;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class APIKeyExtraction {
    public static String key = "x-api-key";
        private static final Config config = ConfigFactory.load(); //searching for application.conf

        public static String getValue() {
            return config.getString("apiKey");
        }
        public static String getTokenID(){
            return config.getString("tokenID");
        }

        public static String getAPIAuthKey(){
            return config.getString("apiKeyAuthentication");
        }

        public static String getOAuth2ClientID(){
            return config.getString("clientID");
        }

        public static String getOAuth2SecretID(){
            return config.getString("clientSecret");
        }
    }
