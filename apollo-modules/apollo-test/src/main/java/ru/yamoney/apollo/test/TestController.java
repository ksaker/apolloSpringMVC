package ru.yamoney.apollo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yamoney.apollo.services.notifier.INotifierAPI;
import ru.yamoney.apollo.services.notifier.gen.NotifyRequest;

/**
 * ru.yamoney.apollo.test.TestController
 * <p></p>
 *
 * @author Platonov Alexey
 * @version 1.0 12.11.15
 */
@RestController
@RequestMapping("/test-controller")
public class TestController {

    @Autowired
    INotifierAPI notifierAPI;

    @RequestMapping("testClient")
    public void testClient(){
        notifierAPI.notify(new NotifyRequest());
    }
}
