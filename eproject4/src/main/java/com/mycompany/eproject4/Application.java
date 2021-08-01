/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eproject4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {

        Application obj = new Application();

        try {
            System.out.println("Testing 1 - Send Http GET request");
            obj.sendGet();

            System.out.println("Testing 2 - Send Http POST request");
            obj.sendPost();
        } finally {
            obj.close();
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private void sendGet() throws Exception {
        String param = "m0004";
        HttpGet request = new HttpGet("http://localhost:9999/api/menu/" + param);
        // add request headers
//        request.addHeader("custom-key", "mkyong");
//        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
//            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
//            Header headers = entity.getContentType();
//            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                ObjectMapper mapper = new ObjectMapper();
//                List<Meni> participantJsonList = mapper.readValue(result, new TypeReference<List<Meni>>() {
//                });
    
                Menu participantJsonList = mapper.readValue(result, new TypeReference<Menu>() {
                });
                System.out.println(participantJsonList.getName());
                System.out.println(result);
            }

        }
    }
    private void sendPost() throws Exception {
        HttpPost post = new HttpPost("http://localhost:9999/api/menu/update");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        String paramid = "m0001";
        urlParameters.add(new BasicNameValuePair("menuCode", paramid));
        urlParameters.add(new BasicNameValuePair("name", "suatenthanhcoca"));
        urlParameters.add(new BasicNameValuePair("unit", "chai"));
//        urlParameters.add(new BasicNameValuePair("menuCode", "m0003"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
