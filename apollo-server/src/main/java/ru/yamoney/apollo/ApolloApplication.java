package ru.yamoney.apollo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yamoney.apollo.conf.ApolloConfig;

@SpringBootApplication
@RestController
@RequestMapping(value = "/test")
public class ApolloApplication {

    Logger logger = LoggerFactory.getLogger(ApolloApplication.class);

    @RequestMapping("/testCmd")
    public String home() {
        logger.debug(config.getName());
        return config.getName();
    }

    @RequestMapping("/outer")
    public String outer() {
        return config.getOuter();
    }

    @Autowired
    private ApolloConfig config;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApolloApplication.class)
                .run(args);
    }
}
