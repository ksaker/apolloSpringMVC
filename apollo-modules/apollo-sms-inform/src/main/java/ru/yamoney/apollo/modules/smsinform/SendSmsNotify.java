package ru.yamoney.apollo.modules.smsinform;

import org.springframework.stereotype.Component;
import ru.yamoney.apollo.modules.smsinform.gen.SendSmsNotifyRequest;
import ru.yamoney.apollo.modules.smsinform.gen.ResultData;
import ru.yamoney.apollo.modules.smsinform.gen.SendSmsNotifyResponse;

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
