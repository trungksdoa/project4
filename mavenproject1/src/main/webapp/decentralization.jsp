<%-- 
    Document   : index.jsp
    Created on : Jul 31, 2021, 10:12:10 AM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .selected-content {
        text-align: center;
        border-radius: 3px;
        box-shadow: 0 2px 4px 0 rgb(219 215 215 / 0%);
        border: solid 2px transparent;
        background: #fff;
        max-width: 500px;
        height: 48px;
        width: 466px;
        padding: 15px;
        display: grid;
        grid-gap: 15px;
        place-content: center;
        transition: .3s ease-in-out all;
    }

    .selected-content img {
        width: 100%;
        margin: 0 auto;
    }

    .selected-content h4 {
        font-size: 16px;
        letter-spacing: -0.24px;
        text-align: center;
        color: #1f2949;
    }

    .selected-content h5 {
        font-size: 14px;
        line-height: 1.4;
        text-align: center;
        color: #686d73;
    }

    .selected-label {
        position: relative;
    }

    .selected-label input {
        display: none;
    }

    .selected-label .icon {
        width: 20px;
        height: 20px;
        border: solid 2px #e3e3e3;
        border-radius: 50%;
        position: absolute;
        top: 15px;
        left: 15px;
        transition: .3s ease-in-out all;
        transform: scale(1);
        z-index: 1;
    }

    .selected-label .icon:before {
        content: "\f00c";
        position: absolute;
        width: 100%;
        height: 100%;
        font-family: "Font Awesome 5 Free";
        font-weight: 900;
        font-size: 12px;
        color: #000;
        text-align: center;
        opacity: 0;
        transition: .2s ease-in-out all;
        transform: scale(2);
    }

    .selected-label input:checked+.icon {
        background: #3057d5;
        border-color: #3057d5;
        transform: scale(1.2);
    }

    .selected-label input:checked+.icon:before {
        color: #fff;
        opacity: 1;
        transform: scale(.8);
    }

    .selected-label input:checked~.selected-content {
        box-shadow: 0 2px 4px 0 rgba(219, 215, 215, 0.5);
        border: solid 2px #3bff86;
    }
    input[type="checkbox"] {
        width: 20px;
        height: 20px;
    }
</style>
<script>
    $(document).ready(function () {
        $("#btnSubmits").click(function (e) {
            $('input[type=checkbox]').removeAttr("disabled");
            //1
            //
            if (document.getElementById("CancleOrder1").checked) {
                document.getElementById('CancleOrderHidden1').disabled = true;
            }
            if (document.getElementById("CancleOrder3").checked) {
                document.getElementById('CancleOrderHidden3').disabled = true;
            }
//                    
//                    //2
//                  //getCrudPrintInvoice
            if (document.getElementById("getCrudPrintInvoice1").checked) {
                document.getElementById('getCrudPrintInvoiceHidden1').disabled = true;
            }
            if (document.getElementById("getCrudPrintInvoice3").checked) {
                document.getElementById('getCrudPrintInvoiceHidden3').disabled = true;
            }

            //3
            //getManagerCustomer
            if (document.getElementById("getManagerCustomer1").checked) {
                document.getElementById('getManagerCustomerHidden1').disabled = true;
            }
            if (document.getElementById("getManagerCustomer3").checked) {
                document.getElementById('getManagerCustomerHidden3').disabled = true;
            }

            //4
            //getCrudPrintInvoiceHidden
            if (document.getElementById("getManagerEmploy1").checked) {
                document.getElementById('getManagerEmployHidden1').disabled = true;
            }
            if (document.getElementById("getManagerEmploy3").checked) {
                document.getElementById('getManagerEmployHidden3').disabled = true;
            }

            //5
            //getViewReportHidden
            if (document.getElementById("getViewReport1").checked) {
                document.getElementById('getViewReportHidden1').disabled = true;
            }
            if (document.getElementById("getViewReport3").checked) {
                document.getElementById('getViewReportHidden3').disabled = true;
            }

            //6
            //getManagerRevenueandexpenditureHiden
            if (document.getElementById("getManagerRevenueandexpenditure1").checked) {
                document.getElementById('getManagerRevenueandexpenditureHiden1').disabled = true;
            }
            if (document.getElementById("getManagerRevenueandexpenditure3").checked) {
                document.getElementById('getManagerRevenueandexpenditureHiden3').disabled = true;
            }
            return true;
        });
        $('input[type=checkbox]').change(function () {
            cb = $(this);
            cb.val(cb.prop('checked'));
        });
    });
</script>
<form id='authenform' action="DesServlet" method="POST">
    <div class="container" style='box-shadow: 0 7px 5px 0 rgb(219 215 215 / 50%);
         border: solid 2px #f1d3ff;'>
        <input type="hidden" id="hiddenId" name="hiddenId" value="" />
        <div class="row">
            <div class="col-md-12 col-sm-12 col-lg-12 col-xl-12">
                <div class="row">
                    <div class="col-md-11 col-sm-11 col-sm-11 col-xl-11">
                        <h4>Decentralization 
                        </h4>
                    </div>
                    <div class="col-sm-1 col-md-1 col-lg-1 col-xl-1">
                        <button type="submit" id='btnSubmits' class="btn btn-success">Save</button>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th style="text-align: center">Cancel order</th>
                                <th style="text-align: center">Print invoice</th>
                                <th style="text-align: center">View report</th>
                                <th style="text-align: center">MG revenu...</th>
                                <th style="text-align: center">MG Employ</th>
                                <th style="text-align: center">MG Customer</th>
                                <th style="text-align: center">Role</th>
                            </tr>
                        </thead>
                        <tbody id='fucntions'>
                            <% int coutnumber = 1;%>
                            <c:forEach items="${listdate}" var="des">
                                <tr>
                                    <td>${des.getDecentralizationid()}</td>
                                    <td style="display: none"><input type="number" name="getDecentralizationid" value="${des.getDecentralizationid()}"/></td>     
                                    <td style="display: block"><input type="number" name="roleId" value="${des.getRoleid()}"/></td>
                                        <c:choose>
                                            <c:when test = "${des.getCancelOrder() == true}">
                                                <c:choose>
                                                    <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input disabled="" type="checkbox" checked="" name="CancleOrder" value="true" id="CancleOrder"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" checked="" name="CancleOrder" value="true" id="CancleOrder${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="CancleOrder" value="false" id="CancleOrderHidden${des.getDecentralizationid()}">
                                                    </td>                                                            </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input  disabled="" type="checkbox"  name="CancleOrder" value="false" id="CancleOrder"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" name="CancleOrder" value="false" id="CancleOrder${des.getDecentralizationid()}">
                                                        <input type="hidden" name="CancleOrder" value="true" id="CancleOrderHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                    <!--2-->
                                    <c:choose>
                                        <c:when test = "${des.getCrudPrintInvoice() == true}">
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input disabled="" type="checkbox" checked="" value="true" name="getCrudPrintInvoice" id="getCrudPrintInvoice"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" checked="" name="getCrudPrintInvoice" value="true" id="getCrudPrintInvoice${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getCrudPrintInvoice" value="false" id="getCrudPrintInvoiceHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input disabled="" type="checkbox" name="getCrudPrintInvoice" value="false" id="getCrudPrintInvoice"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" name="getCrudPrintInvoice" value="false" id="getCrudPrintInvoice${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getCrudPrintInvoice" value="false" id="getCrudPrintInvoiceHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                    <!--3-->
                                    <c:choose>
                                        <c:when test = "${des.getViewReport() == true}">
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" checked="" name="getViewReport" value="true" id="getViewReport"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" checked="" name="getViewReport" value="true" id="getViewReport${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getViewReport" value="false" id="getViewReportHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input disabled="" type="checkbox" name="getViewReport" value="false" id="getViewReport"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" name="getViewReport" value="false" id="getViewReport${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getViewReport" value="false" id="getViewReportHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                    <!--4-->
                                    <c:choose>
                                        <c:when test = "${des.getManagerRevenueandexpenditure() == true}">
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" checked="" value="true" name="getManagerRevenueandexpenditure" id="getManagerRevenueandexpenditure"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox"  checked="" value="true" name="getManagerRevenueandexpenditure" id="getManagerRevenueandexpenditure${des.getDecentralizationid()}">
                                                        <input type="hidden"  checked="" value="false" name="getManagerRevenueandexpenditure" id="getManagerRevenueandexpenditureHiden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" value="false" name="getManagerRevenueandexpenditure" id="getManagerRevenueandexpenditure"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" name="getManagerRevenueandexpenditure" value="false" id="getManagerRevenueandexpenditure${des.getDecentralizationid()}">
                                                        <input type="hidden"  checked="" value="false" name="getManagerRevenueandexpenditure" id="getManagerRevenueandexpenditureHiden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                    <!--5-->
                                    <c:choose>
                                        <c:when test = "${des.getManagerEmploy() == true}">
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" checked="" value="true" name="getManagerEmploy" id="getManagerEmploy"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" checked="" name="getManagerEmploy" value="true" id="getManagerEmploy${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getManagerEmploy" value="false" id="getManagerEmployHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" name="getManagerEmploy" value="false" id="getManagerEmploy"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" name="getManagerEmploy" value="false" id="getManagerEmploy${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getManagerEmploy" value="false" id="getManagerEmployHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                    <!--6-->
                                    <c:choose>
                                        <c:when test = "${des.getManagerCustomer() == true}">
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" checked="" value="true" name="getManagerCustomer" id="getManagerCustomer"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" checked="" name="getManagerCustomer" value="true" id="getManagerCustomer${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getManagerCustomer" value="false" id="getManagerCustomerHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test = "${des.getName() == 'Manager'}">
                                                    <td style="text-align: center;"><input type="checkbox" disabled="" name="getManagerCustomer" value="false" id="getManagerCustomer"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;">
                                                        <input type="checkbox" name="getManagerCustomer" value="false" id="getManagerCustomer${des.getDecentralizationid()}">
                                                        <input type="hidden" checked="" name="getManagerCustomer" value="false" id="getManagerCustomerHidden${des.getDecentralizationid()}">
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:otherwise>
                                    </c:choose>
                                    <!--7-->
                                    <td style="background-color: gray;color:aliceblue;text-align: center">${des.getName()}</td>
                                </tr>
                                <%coutnumber++;%>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</form>
