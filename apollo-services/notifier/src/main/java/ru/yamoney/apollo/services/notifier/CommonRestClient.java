package ru.yamoney.apollo.services.notifier;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.client.RestTemplate;


/**
 * CommonClient
 * <p>
 *     Client to external services based on RestTemplate client
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 12.11.15
 */
public class CommonRestClient {
    public static final String NOTIFY_URI = "http://localhost:8080/apollo/webservice/sms-inform/notify";

    <RQ, RS> RS postJson(RQ request, Class<RS> responseType) {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        MappingJacksonValue value = new MappingJacksonValue(request);
        HttpEntity<MappingJacksonValue> entity = new HttpEntity<>(value);

        //TODO: should be closed on shutdown
        //clientHttpRequestFactory.destroy();

        final RS rs = restTemplate.postForObject(NOTIFY_URI, entity, responseType);

        return rs;
    }

}
