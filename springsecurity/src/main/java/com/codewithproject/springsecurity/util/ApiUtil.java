package com.codewithproject.springsecurity.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class ApiUtil {

    public static final String CUSTOMER_ID = "custId";
    public static final String API_KEY = "apikey";
    public static final String PRODUCT_NO = "productNo";
    public static final String TRAVEL_DATE = "travelDate";
    public static final String END_TRAVEL_DATE = "endTravelDate";
    public static final String ORDER_ID = "orderId";
    public static final String ORDER_AMOUNT = "orderMoney";
    public static final String ORDER_STATE = "orderState";
    public static final String VOUCHER = "voucher";

    public static final int USER_ID_JTR = 8888888;
    public static final String SPEC_CODE_API = "API";
    public static final int LIMIT_INSERT_UPDATE_NUM = 500;

    public static final int AGE_TO_DEFAULT = 100;
    public static final int AGE_FROM_DEFAULT = 1;
    public static final String HTTP_CONSTANT = "http";
    public static final String TYPE_PDF_CONSTANT = ".pdf";
    public static final String HTTP_CONNECT_FAIL = "failed";
    public static final int HTTP_JTR_CONNECT_TIME_OUT = 15000; //milliseconds

    public static <T> T callGetApi(String url, Class<T> clazz) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, clazz);
        } catch (Exception e) {
            System.out.println("Cannot get response");
        }
        return null;
    }

    public static <T> T callPostApi(String url, Object requestObject, Class<T> clazz) {
        // Create RestTemplate with custom request factory to support HTTPS
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(requestObject, headers);

        return restTemplate.postForObject(url, requestEntity, clazz);
    }

    public static ResponseEntity<String> callPostApiBearerToken(String bearerToken, String url) {
        // Create RestTemplate with custom request factory to support HTTPS
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);

        RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            System.out.println(responseBody);
        } else {
            System.out.println("Request failed with status: " + responseEntity.getStatusCode());
        }

        return responseEntity;
    }

    public static ResponseEntity<String> callPostApiHaveBodyAuthor(String authorizationHeader, String requestBody, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }






    public static <T> T mapToDTO(ResponseEntity<String> responseEntity, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(responseEntity.getBody(), clazz);
    }

    public static <T> T jsonToDTO(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder()
                .serializeNulls() // Include null values during serialization
                .create();
        return gson.fromJson(json, clazz);
    }

//    public static <T> T callGetApiJtr(Map<String, String> map, String fullUrl, Class<T> clazz) {
//        try {
//            RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
//
//            return restTemplate.getForObject(fullUrl, clazz);
//        } catch (Exception e) {
//            log.info("Can not get response from JTR : {}", e.getMessage());
//        }
//        return null;
//    }

//    private static ClientHttpRequestFactory getClientHttpRequestFactory() {
//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(HTTP_JTR_CONNECT_TIME_OUT)
//                .setConnectionRequestTimeout(HTTP_JTR_CONNECT_TIME_OUT)
//                .setSocketTimeout(HTTP_JTR_CONNECT_TIME_OUT)
//                .build();
//        CloseableHttpClient client = HttpClientBuilder
//                .create()
//                .setDefaultRequestConfig(config)
//                .build();
//        return new HttpComponentsClientHttpRequestFactory(client);
//    }
}
