package ru.yamoney.apollo.services.notifier;

import com.sun.net.ssl.internal.ssl.Provider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PreDestroy;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * NotifierConnector
 * <p>
 *     Connector to Notifier servcie
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 12.11.15
 */
@Component
public class NotifierConnector {

    /*TODO: Change to interface in common service*/
    @Autowired
    private NotifierSettings settings;


    public static final String NOTIFY_URI = "http://localhost:8080/apollo/webservice/sms-inform/notify";
    //private clientHttpRequestFactory

    //Сертификат сервера или ключиница с наименованием сертификата сервера
    // количество коннектов, таймауты,
    //Адрес сервера, неймспейс, команды

    <RQ, RS> RS postJson(RQ request, Class<RS> responseType) {
//        /*TODO: Server option with default value ssl if not set*/
//        final String serverSecureProtocolOption = "SSL";
//
//        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
//        final KeyStore clientKeyStory = KeyStore.getInstance("JKS");
//        final FileInputStream fileInputStream = new FileInputStream("/Users/platonov/Documents/Projects/apollo/apollo-conf/config/default");
//
//        String pass = "1234";
//
//        clientKeyStory.load(fileInputStream, pass.toCharArray());
//        final String privateKeyPassword = "1233334";
//
//        keyManagerFactory.init(clientKeyStory, privateKeyPassword.toCharArray());
//        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
//
//        trustManagerFactory.init(clientKeyStory);
//
//
//        final SSLContext sslContext = SSLContext.getInstance(serverSecureProtocolOption);
//        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
//
//
//
//        //TODO: should be param
//        final boolean allowAllHostname = true;
//
//        final SSLConnectionSocketFactory sslSocketFactory =
//                new SSLConnectionSocketFactory(sslContext, null, null,
//                        allowAllHostname
//                                ? NoopHostnameVerifier.INSTANCE
//                                : new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault()));
//        HttpClient httpClient =
//                HttpClientBuilder.create().setSSLSocketFactory(sslSocketFactory).build();
//
//        HttpClients.custom().setSSLSocketFactory(sslSocketFactory);
//
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
//                new HttpComponentsClientHttpRequestFactory(httpClient);
//
//        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//        MappingJacksonValue value = new MappingJacksonValue(request);
//        HttpEntity<MappingJacksonValue> entity = new HttpEntity<>(value);
//
//        //TODO: should be closed on shutdown
//        //clientHttpRequestFactory.destroy();
//
//        final RS rs = restTemplate.postForObject(NOTIFY_URI, entity, responseType);
//
//        return rs;
        return (RS) new Object();
    }

    @PreDestroy
    public void shutDown() {

    }
}
