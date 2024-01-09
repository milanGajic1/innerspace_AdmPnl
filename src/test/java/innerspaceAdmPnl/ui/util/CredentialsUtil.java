package innerspaceAdmPnl.ui.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsUtil {
    private static Properties properties = new Properties();

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
}
