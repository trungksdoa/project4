/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.Controller;

import com.project.mavenproject1.MultipartUtility;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author trung
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class MultipartServlet extends HttpServlet {

    public static final String SAVE_DIRECTORY = "uploadDir";

    public MultipartServlet() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                // Đường dẫn tuyệt đối tới thư mục gốc của web app.
                String appPath = request.getServletContext().getRealPath("");
                appPath = appPath.replace('\\', '/');

                // Thư mục để save file tải lên.
                String fullSavePath = null;
                if (appPath.endsWith("/")) {
                    fullSavePath = appPath + SAVE_DIRECTORY;
                } else {
                    fullSavePath = appPath + "/" + SAVE_DIRECTORY;
                }
//                Tạo thư mục nếu nó không tồn tại.
                File fileSaveDir = new File(fullSavePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
               
                // Danh mục các phần đã upload lên (Có thể là nhiều file).
                for (Part part : request.getParts()) {
                    String fileName = extractFileName(part);
                    System.out.println(getExtensionByApacheCommonLib(fileName));
                    if (getExtensionByApacheCommonLib(fileName).equals("jpg") || getExtensionByApacheCommonLib(fileName).equals("png")) {
                        if (fileName != null && fileName.length() > 0) {
                            String filePath = fullSavePath + File.separator + fileName;

//                        System.out.println("Write attachment to file: " + );
                            // Ghi vào file.
                            part.write(filePath);

                            //After save sucess to client folder
                            String charset = "UTF-8";
                            File uploadFile1 = new File(filePath);
                            String requestURL = "http://localhost:9999/api/upload";
                            try {
                                MultipartUtility multipart = new MultipartUtility(requestURL, charset);

                                multipart.addHeaderField("User-Agent", "CodeJava");
                                multipart.addHeaderField("Test-Header", "Header-Value");

                                multipart.addFilePart("file", uploadFile1);
                                List<String> responses = multipart.finish();

                                out.println("SERVER REPLIED:");

                                for (String line : responses) {
                                    out.println(line);
                                }
                            } catch (IOException ex) {
                                out.print(ex);
                            }

                        }
                    } else {
                        out.print("Error file:" + fileName);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error: " + e.getMessage());
                out.println("Error");
            }
        }
    }

    public String getExtensionByApacheCommonLib(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
