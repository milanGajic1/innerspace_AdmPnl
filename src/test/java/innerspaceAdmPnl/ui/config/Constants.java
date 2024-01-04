package innerspaceAdmPnl.ui.config;

import java.time.Duration;

public class Constants {
    // Timeout for explicit waits
    public static final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(10); // Adjust the duration as needed

    // URL of the Innerspace Admin Panel
    public static final String INNERSPACE_ADMIN_PANEL_URL = "https://adminpanel-staging.innerspace.at/home/";

    // Expected title for the Innerspace Admin Panel
    public static final String INNERSPACE_ADMIN_PANEL_TITLE = "Innerspace AdminPanel";
}
