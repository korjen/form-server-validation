package org.apache.maven.formServerValidation;

import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppProperties {
    private final Properties properties;
    private final static Logger LOGGER = LoggerFactory.getLogger(AppProperties.class);

    public AppProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        }
        catch (IOException exception) {
            LOGGER.error("Can't read properties from app.properties");
        }
    }

    public String getOnlyLettersRegEx() {
        return properties.getProperty("ONLY_LETTERS");
    }

    public String getOnlyLatinLettersRegEx() {
        return properties.getProperty("ONLY_LATIN_LETTERS");
    }

    public String getStrongPasswordRegEx() {
        return properties.getProperty("STRONG_PASSWORD");
    }

    public String getEmailRegEx() {
        return properties.getProperty("EMAIL");
    }
}
