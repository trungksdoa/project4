/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.controller;

import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author trung
 */
@Controller
@RequestMapping(value = "/api/")
public class UploadController {

    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute Staff staff) throws IOException {

        File convertFile = new File("D:\\luutam\\eproject4_restfulAPI\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        System.out.println(staff);
        fout.close();
        return new ResponseEntity<>("File upload sucess", HttpStatus.OK);
    }

    @RequestMapping(value = "deletefile")
    public ResponseEntity<Object> DeleteFile() {
        try {
            File file = new File("D:\\luutam\\eproject4_restfulAPI\\src\\main\\resources\\static\\images\\2.jpg");
            if (file.delete()) {
                return new ResponseEntity<>("File upload sucess", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("File upload fails", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("File upload fails", HttpStatus.NO_CONTENT);
        }
    }

}
