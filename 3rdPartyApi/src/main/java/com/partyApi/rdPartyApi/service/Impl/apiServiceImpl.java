package com.partyApi.rdPartyApi.service.Impl;

import com.partyApi.rdPartyApi.dto.formdataDTO;
import com.partyApi.rdPartyApi.service.apiService;
import lombok.val;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class apiServiceImpl implements apiService {



    String POST  = "/posts";


    @Override
    public Map<String,Object> getPosts(formdataDTO dto) {
        String baseUrl = "https://b2b-et-test.ceyentra.lk/b2b-api/oauth/token";

        try {

            String username = dto.getUsername();
            String password = dto.getPassword();
            String Grant_type = dto.getGrant_type();


            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("username", username);
            formData.add("password", password);
            formData.add("grant_type", Grant_type);

            System.out.println(formData);


//            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
            HttpEntity <Map> requestEntity  = new HttpEntity<>(formData,gethttpHeaders());

            System.out.println(baseUrl);
            System.out.println(requestEntity);

            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<List<Map<String,Object>>> responseEntity = restTemplate.exchange(
//                    baseUrl,
//                    HttpMethod.POST,
//                    requestEntity,
//                    new ParameterizedTypeReference<List<Map<String, Object>>>() {}
//            );

            val response  =  restTemplate.exchange(baseUrl , HttpMethod.POST ,requestEntity,Map.class); ;

//            System.out.println("-----------------------");
//            System.out.println(response.getStatusCode());
////            System.out.println(response.getHeaders());
//            System.out.println(response.getStatusCodeValue());
            System.out.println("--------------------");

            System.out.println(response.getBody().get("user"));

            return (Map<String, Object>) response.getBody().get("user");
            
           
//            val response  =  restTemplate.exchange(baseUrl , HttpMethod.POST ,requestEntity,Map.class); ;
//            return  response.getBody();
//

//            return responseEntity.getBody();
//            HttpStatus statusCode = responseEntity.getStatusCode();
//            HttpHeaders responseHeaders = responseEntity.getHeaders();
//            String responseBody = responseEntity.getBody();

//            System.out.println("Status Code: " + statusCode);
//            System.out.println("Response Headers: " + responseHeaders);
//            System.out.println("Response Body: " + responseBody);



//            System.out.println(responseEntity);
//             List<String> sort = Collections.singletonList(responseEntity.getBody());

//            System.out.println(statusCode.value());
//            System.out.println(responseHeaders.getContentType());
//
//            final val access_token = responseBody.indexOf("access_token");
//            System.out.println("Response Body: " + access_token);

//            System.out.println(statusCode.value());


        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
        }


    private HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        headers.setBasicAuth("B2B_USER", "");
        System.out.println(headers);
        return headers;
    }
}
