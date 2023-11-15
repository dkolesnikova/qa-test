package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:locale.properties"
})
public interface WebDriverConfig extends Config{
    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("119.00")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("file:///Users/daria.k/Downloads/Telegram%20Desktop/qa-test.html")
    String getBaseUrl();
}
