<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%
    String destination = "/assets/images";
    String destinationRealPath = application.getRealPath(destination);
    out.write(destinationRealPath + "<br>");
    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    factory.setRepository(new File(destinationRealPath));
    ServletFileUpload uploader = new ServletFileUpload(factory);
    try {
        List items = uploader.parseRequest(request);
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            FileItem item = (FileItem) iterator.next();
            File file = new File(destinationRealPath, item.getName());
            item.write(file);
            out.write("<p>" + file.getName() + "was uploaded success" + "</p>");
        }
    } catch (FileUploadException e) {
        out.write("FileUpload has error:" + e.getMessage());
    }
%>