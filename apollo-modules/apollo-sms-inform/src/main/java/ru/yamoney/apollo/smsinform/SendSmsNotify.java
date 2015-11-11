package ru.yamoney.apollo.smsinform;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.yamoney.apollo.smsinform.gen.ResultData;
import ru.yamoney.apollo.smsinform.gen.SendSmsNotifyRequest;
import ru.yamoney.apollo.smsinform.gen.SendSmsNotifyResponse;

/**
 * ru.yamoney.apollo.smsinform.SendSmsNotify
 * <p>
 *      Send sms notify to user using notifier
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 07.11.15
 */
@Component
//@Qualifier(value = "sendSmsNotify")
public class SendSmsNotify implements IApolloCommand<SendSmsNotifyRequest, SendSmsNotifyResponse> {

//    @Autowired
//    @Qualifier(value = "Notifier")
//    IService service;

    public SendSmsNotifyResponse execute(SendSmsNotifyRequest request) {
        final SendSmsNotifyResponse sendSmsNotifyResponse = new SendSmsNotifyResponse();
        final ResultData value = new ResultData();

        value.setCode(0);
        value.setDescription("Success");
        sendSmsNotifyResponse.setResultData(value);
        return sendSmsNotifyResponse;
    }

}
