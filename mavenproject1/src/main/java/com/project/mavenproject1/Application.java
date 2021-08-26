/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1;

import com.project.mavenproject1.model.Staff;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.project.mavenproject1.Controller.LoginServlet;
import com.project.mavenproject1.model.Decentralization;
import com.project.mavenproject1.model.Role;
import com.project.mavenproject1.model.Roles;
import com.project.mavenproject1.service.VwRoleDAO;
import java.io.File;
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Application {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {

        Application obj = new Application();
        VwRoleDAO dao = new VwRoleDAO();
        try {
            System.out.println("Testing 1 - Send Http GET request");
            obj.Upload();

//            Roles roles = dao.findByRoleId(4);
//            Decentralization decentralization = new Decentralization();
//
//            if (roles != null) {
//                decentralization.setId(roles.getDecentralizationid());
//                decentralization.setCancelOrder(true);
//                decentralization.setCrudPrintInvoice(true);
//                decentralization.setManagerCustomer(false);
//                decentralization.setManagerEmploy(false);
//                decentralization.setViewReport(false);
//                decentralization.setManagerRevenueandexpenditure(false);
//                Role role = new Role();
//                role.setId(roles.getRoleid());
//                decentralization.setRoleId(role);
//                Decentralization decentralization1 = dao.Update(decentralization);
//                System.out.println(decentralization1);
//            }

            System.out.println("Testing 2 - Send Http POST request");

        } finally {
            obj.close();
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private void sendGet() throws Exception {

        HttpGet request = new HttpGet("http://localhost:9999/api/roles/");

        // add request headers
//        request.addHeader("custom-key", "mkyong");
//        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
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
                List<Decentralization> participantJsonList = mapper.readValue(result, new TypeReference<List<Decentralization>>() {
                });
//                Staff participantJsonList = mapper.readValue(result, new TypeReference<Staff>() {
//                });
                for (Decentralization staff : participantJsonList) {
                    Role dataRole = staff.getRoleId();
                    System.out.println(dataRole);
                    System.out.println(staff.getRoleId());
                }

                System.out.println(result);
            }

        }

    }

    private void sendPost() throws Exception {

        HttpPost post = new HttpPost("http://localhost:9999/api/staff/login");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("staffCode", "T020721-0002"));
        urlParameters.add(new BasicNameValuePair("password", "123"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {
            if (response.getEntity() != null) {
                System.out.println("Login sucess");
            }
        }
    }

    private void update(Decentralization dewDecentralization) {

        try {
            String postUrl = "http://localhost:9999/api/roles/update/";// put in your url
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(dewDecentralization));//gson.tojson() converts your pojo to json
            System.out.println(postingString);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            String result = EntityUtils.toString(response.getEntity());

            System.out.println(result);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Upload() {
      
    }

}
