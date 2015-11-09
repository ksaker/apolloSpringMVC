package ru.yamoney.apollo.smsinform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ru.yamoney.apollo.smsinform.SmsInformController
 * <p>
 *  Sms inform module controller
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 07.11.15
 */
//TODO: Annotation ApolloController: @Restcontroller + @RequestMapping(value="appollo/webserivice/")
//@ApolloController(value="/sms-inform")

@RestController
@RequestMapping(value = "/sms-inform")
public class SmsInformController {

    @RequestMapping(value = "/notify", method = RequestMethod.GET)
    public void sendSmsNotify(){
        System.out.println("Notify send");
    }
}
