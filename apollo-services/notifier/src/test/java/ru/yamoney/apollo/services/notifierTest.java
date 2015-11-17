package ru.yamoney.apollo.services;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.client.RestTemplate;
import ru.yamoney.apollo.services.notifier.gen.NotifyResponse;
import ru.yamoney.apollo.services.notifier.gen.smsinform.SendSmsNotifyRequest;
import ru.yamoney.apollo.services.notifier.gen.smsinform.SmsNotify;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * notifier
 * <p></p>
 *
 * @author Platonov Alexey
 * @version 1.0 16.11.15
 */
public class notifierTest {
    public static final String NOTIFY_URI = "https://localhost:8080/apollo/webservice/sms-inform/notify";
    //public static final String NOTIFY_URI = "https://77.75.152.138:9001/api/hello/";


    @Test
    public void keyStoreLoad()
            throws Exception {
        final String serverSecureProtocolOption = "SSL";

        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
        final KeyStore clientKeyStory = KeyStore.getInstance("JKS");
        final FileInputStream fileInputStream =
                new FileInputStream("/Users/platonov/Documents/Projects/apollo/apollo-conf/config/default/apollo.jks");

        String pass = "1234567812345678";

        clientKeyStory.load(fileInputStream, pass.toCharArray());
        final String privateKeyPassword = "1234567812345678";

        keyManagerFactory.init(clientKeyStory, privateKeyPassword.toCharArray());
        final KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX");

        trustManagerFactory.init(clientKeyStory);


        final SSLContext sslContext = SSLContext.getInstance(serverSecureProtocolOption);
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        //TODO: should be param
        final boolean allowAllHostname = true;

        final SSLConnectionSocketFactory sslSocketFactory =
                new SSLConnectionSocketFactory(sslContext, null, null,
                        allowAllHostname
                                ? NoopHostnameVerifier.INSTANCE
                                : new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault()));
        HttpClient httpClient =
                HttpClientBuilder.create().setSSLSocketFactory(sslSocketFactory).build();

        HttpClients.custom().setSSLSocketFactory(sslSocketFactory);

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        SendSmsNotifyRequest serviceRequest = new SendSmsNotifyRequest();
        final SmsNotify value = new SmsNotify();

        value.setPhone("795223490534");
        value.setRequestId("123332123");
        value.setText("Text");

        serviceRequest.setSmsNotify(value);

        MappingJacksonValue request = new MappingJacksonValue(serviceRequest);
        HttpEntity<MappingJacksonValue> entity = new HttpEntity<>(request);

        restTemplate.postForObject(NOTIFY_URI, entity, NotifyResponse.class);

        //TODO: should be closed on shutdown
        clientHttpRequestFactory.destroy();

//        final RS rs = restTemplate.postForObject(NOTIFY_URI, entity, responseType);

    }
}
