package innerspaceAdmPnl.ui.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsUtil {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream in = new FileInputStream("env.properties");
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getEmail() {
        return properties.getProperty("email");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getTenant() {
        return properties.getProperty("tenant");
    }

    public static String getClientId() {
        return properties.getProperty("clientId");
    }

    public static String getClientSecret() {
        return properties.getProperty("clientSecret");
    }

    public static String getScope() {
        return properties.getProperty("scope");
    }
}
