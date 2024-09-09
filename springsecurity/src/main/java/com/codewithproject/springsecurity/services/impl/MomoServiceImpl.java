package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.dto.ResponseDto;
import com.codewithproject.springsecurity.dto.response.MomoTransactionReportResponse;
import com.codewithproject.springsecurity.util.ApiUtil;
import com.codewithproject.springsecurity.util.ArrayUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class MomoServiceImpl {

    public String login() {
        String token = "";

        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Set the request URL and create the request body
        String url = "https://business.momo.vn/api/authentication/login?language=vi";
        String reqBody = "{\"username\": \"1m1kme\", \"password\": \"Momo4789!\"}";

        try {
            // Make the POST request
            String jsonString = restTemplate.postForObject(url, reqBody, String.class);

            // Convert the JSON string to a Map<String, Object>
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseDto dataDto = objectMapper.readValue(jsonString, new TypeReference<ResponseDto>() {});
            Map<String,Object> dataMap = dataDto.getData();
            token = dataMap.get("token").toString();

        } catch (HttpClientErrorException.Unauthorized ex) {
            // Handle 401 Unauthorized error
            System.err.println("Unauthorized: Wrong username or password");
        } catch (Exception ex) {
            // Handle other exceptions
            ex.printStackTrace();
        }
        return token;
    }

    public MomoTransactionReportResponse transactionReport(String bearerToken) {
        MomoTransactionReportResponse momoResponse = new MomoTransactionReportResponse();
        String url = "https://business.momo.vn/api/transaction/v2/transactions?pageSize=10&pageNumber=0&fromDate=2024-05-15T00%3A00%3A00.00&toDate=2024-05-15T23%3A59%3A59.00&status=ALL&merchantId=63168&language=vi";
        ResponseEntity<String> responseEntity = ApiUtil.callPostApiBearerToken(bearerToken, url);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Get data
            Gson gson = new GsonBuilder()
                    .serializeNulls() // Include null values during serialization
                    .create();
            ResponseDto dataDto = ApiUtil.mapToDTO(responseEntity, ResponseDto.class);
            Map<String,Object> dataMap = dataDto.getData();
            List<Object> list = ArrayUtil.convertMapValuesToList(dataMap);
            if (!list.isEmpty()) {
                // Convert to Momo response
                String strObj = gson.toJson(dataMap.get("content"));
                List<MomoTransactionReportResponse> momo = convertJsonToList(strObj);
                assert momo != null;
                if (!momo.isEmpty()) {
                    momoResponse = momo.get(0);
                }
            }
        }
        return momoResponse;
    }

    private static List<MomoTransactionReportResponse> convertJsonToList(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, new TypeReference<List<MomoTransactionReportResponse>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
