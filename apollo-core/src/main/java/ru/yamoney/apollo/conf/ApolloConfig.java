package ru.yamoney.apollo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ApolloConfig
 * <p>
 *     Application application configuration
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 05.11.15
 */
@Component
@ConfigurationProperties(prefix = "apollo")
public class ApolloConfig
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
