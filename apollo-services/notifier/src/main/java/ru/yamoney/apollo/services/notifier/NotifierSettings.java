package ru.yamoney.apollo.services.notifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * NotifierSettings
 * <p></p>
 *
 * @author Platonov Alexey
 * @version 1.0 16.11.15
 */
@Component
@ConfigurationProperties(prefix = "apollo.notifier")
public class NotifierSettings /*implement RestServerProviederSettings*/{

}
