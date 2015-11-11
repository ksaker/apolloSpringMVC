package ru.yamoney.apollo.smsinform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yamoney.apollo.smsinform.gen.SendSmsNotifyRequest;
import ru.yamoney.apollo.smsinform.gen.SendSmsNotifyResponse;

import javax.validation.Valid;

/**
 * ru.yamoney.apollo.smsinform.SmsInformController
 * <p>
 *      Sms inform module controller
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 07.11.15
 */
@RestController
@RequestMapping(value = "/sms-inform")
public class SmsInformController {

    @Autowired
    @Qualifier(value = "sendSmsNotify")
    IApolloCommand<SendSmsNotifyRequest, SendSmsNotifyResponse> command;

    @RequestMapping(value = "/notify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SendSmsNotifyResponse sendSmsNotify(@Valid @RequestBody SendSmsNotifyRequest request){
        System.out.println("Notify send");
        return command.execute(request);
    }
}
