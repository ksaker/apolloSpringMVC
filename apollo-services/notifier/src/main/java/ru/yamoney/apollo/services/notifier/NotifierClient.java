package ru.yamoney.apollo.services.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yamoney.apollo.services.notifier.gen.NotifyRequest;
import ru.yamoney.apollo.services.notifier.gen.NotifyResponse;
import ru.yamoney.apollo.services.notifier.gen.smsinform.SendSmsNotifyRequest;
import ru.yamoney.apollo.services.notifier.gen.smsinform.SmsNotify;

/**
 * NotifierClient
 * <p>
 *     Client to notifier service
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 12.11.15
 */
@Service
public class NotifierClient implements INotifierAPI {

    /*TODO: Change to interface in common service*/
    @Autowired
    NotifierConnector connector;

    @Override
    public NotifyResponse notify(NotifyRequest request) {
        SendSmsNotifyRequest serviceRequest = new SendSmsNotifyRequest();
        final SmsNotify value = new SmsNotify();

        value.setPhone("795223490534");
        value.setRequestId("123332123");
        value.setText("Text");

        serviceRequest.setSmsNotify(value);
        return connector.postJson(serviceRequest, NotifyResponse.class);
    }
}
