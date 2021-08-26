/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.project.mavenproject1.model.Decentralization;
import com.project.mavenproject1.model.Roles;
import com.project.mavenproject1.service.VwRoleDAO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author trung
 */
public class APicall {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    //Get method FindALl
    public List<Roles> findAll() {
        HttpGet request = new HttpGet("http://localhost:9999/api/vwRoles/");
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                ObjectMapper mapper = new ObjectMapper();
                List<Roles> participantJsonList = mapper.readValue(result, new TypeReference<List<Roles>>() {
                });
                return participantJsonList;
            } else {
                return null;
            }

        } catch (IOException ex) {
            Logger.getLogger(VwRoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VwRoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Get method FindWhere
    public Roles findByRoleId(int id) {
        HttpGet request = new HttpGet("http://localhost:9999/api/vwRoles/" + id);
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                ObjectMapper mapper = new ObjectMapper();
                Roles objct = mapper.readValue(result, new TypeReference<Roles>() {
                });
                return objct;
            } else {
                return null;
            }

        } catch (IOException ex) {
            Logger.getLogger(VwRoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VwRoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //Update method 

    public Decentralization Update(Decentralization decentralization) {
        try {
            String postUrl = "http://localhost:9999/api/roles/update/";// put in your url
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPut post = new HttpPut(postUrl);
//            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(decentralization));//gson.tojson() converts your pojo to json
//            System.out.println(postingString);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            String result = EntityUtils.toString(response.getEntity());

            ObjectMapper mapper = new ObjectMapper();
            Decentralization decentralization1 = mapper.readValue(result, new TypeReference<Decentralization>() {
            });
            return decentralization1;
//            System.out.println(result);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Decentralization Save(Decentralization decentralization) {
        try {
            String postUrl = "http://localhost:9999/api/roles/update/";// put in your url
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(postUrl);
//            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(decentralization));//gson.tojson() converts your pojo to json
//            System.out.println(postingString);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            String result = EntityUtils.toString(response.getEntity());

            ObjectMapper mapper = new ObjectMapper();
            Decentralization decentralization1 = mapper.readValue(result, new TypeReference<Decentralization>() {
            });
            return decentralization1;
//            System.out.println(result);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    public Decentralization Delete(String id) {
//        try {
//            String postUrl = "http://localhost:9999/api/roles/update/";// put in your url
//            Gson gson = new Gson();
//            HttpClient httpClient = HttpClientBuilder.create().build();
//            HttpDelete post = new HttpPut(postUrl);
////            HttpPost post = new HttpPost(postUrl);
//            StringEntity postingString = new StringEntity(gson.toJson(decentralization));//gson.tojson() converts your pojo to json
////            System.out.println(postingString);
//            post.setEntity(postingString);
//            post.setHeader("Content-type", "application/json");
//            HttpResponse response = httpClient.execute(post);
//            String result = EntityUtils.toString(response.getEntity());
//
//            ObjectMapper mapper = new ObjectMapper();
//            Decentralization decentralization1 = mapper.readValue(result, new TypeReference<Decentralization>() {
//            });
//            return decentralization1;
////            System.out.println(result);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    //login
    private static String postLogin(String username, String password) {
        List<String> list = null;
        try {
            HttpPost post = new HttpPost("http://localhost:9999/login");

            // add request parameter, form parameters
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("username", username));
            urlParameters.add(new BasicNameValuePair("password", password));
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpClient.execute(post)) {
                for (Header header : response.getHeaders("Authorization")) {
                    list = Arrays.asList(header.toString());
                }
            } catch (IOException ex) {
                Logger.getLogger(APicall.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(APicall.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list == null || list.isEmpty() ? null : list.get(0).replace("Authorization:", "");
    }

    private void callRESTApi(String restUrl, String authorizationString) {
        // HttpHeaders
        HttpGet request = new HttpGet("http://localhost:9999/employees");
        request.setHeader("Authorization", authorizationString);

        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        } catch (IOException ex) {
            Logger.getLogger(VwRoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VwRoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        APicall call = new APicall();

        String username = "tom";
        String password = "123";

        String authorizationString = call.postLogin(username, password);
        System.out.println(authorizationString);

        call.callRESTApi("http://localhost:9999/employees", authorizationString);
    }
}
