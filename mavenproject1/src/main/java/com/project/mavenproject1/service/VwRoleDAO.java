/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.project.mavenproject1.Application;
import com.project.mavenproject1.model.Decentralization;
import com.project.mavenproject1.model.Roles;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
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
public class VwRoleDAO implements VwRoleService {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @Override
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

    @Override
    public Roles findByRoleId(int id) {
        HttpGet request = new HttpGet("http://localhost:9999/api/vwRoles/" + id);
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
//            System.out.println(response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
//            System.out.println(headers);

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

    @Override
    public Decentralization Update(Decentralization decentralization) {
        try {
            System.out.println(decentralization.getRoleId());
            String postUrl = "http://localhost:9999/api/roles/update/";// put in your url
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPut post = new HttpPut(postUrl);
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
//           
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
