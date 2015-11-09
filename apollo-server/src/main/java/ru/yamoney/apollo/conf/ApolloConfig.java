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
    private String outer;

    public String getName() {
        return name;
    }

    public String getOuter() {
        return outer;
    }

    public void setOuter(String outer) {
        this.outer = outer;
    }

    public void setName(String name) {
        this.name = name;
    }
}
