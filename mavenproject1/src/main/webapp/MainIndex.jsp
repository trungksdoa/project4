<%-- 
    Document   : MainIndex
    Created on : Aug 11, 2021, 10:18:13 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e48bce3864.js" crossorigin="anonymous"></script>

        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
        <link rel="stylesheet" type="text/css" href="https://unpkg.com/slick-loader@1.1.20/slick-loader.min.css">
        <script src="https://unpkg.com/slick-loader@1.1.20/slick-loader.min.js"></script>
        <title>Decentralization</title>

       
        <script>
            $(document).ready(function () {
                $('#loadArea').load("DesServlet");
            });
//            (function ($)
//            {
//                $(document).ready(function ()
//                {
//                    $.ajaxSetup(
//                            {
//                                cache: false,
//                                beforeSend: function () {
//                                    console.log("Before")
//                                    $('#loadArea').hide();
//                                    SlickLoader.enable();
//                                },
//                                complete: function () {
//                                    console.log(SlickLoader.disable())
//                                    SlickLoader.disable();
//                                    $('#loadArea').show();
//                                },
//                                success: function () {
//                                    console.log("success:")
//                                    SlickLoader.disable();
//                                    $('#loadArea').show();
//                                }
//                            });
//                    var $container = $("#loadArea");
//                    $container.load("DesServlet");
//                });
//            })(jQuery);
        </script>
    </head>
    <body>
        <div id="loadArea">

        </div>
       
    </body>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</html>
