<%-- 
    Document   : confirmPage
    Created on : Oct 30, 2018, 12:31:45 AM
    Author     : vtkth
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm page</title>
        <style>
            #welcome {
                width: 50%;
                float: left;
                text-align: left;
                height: 10%;
            }
            #logOut {
                width: 50%;
                float: right;
                height: 10%;
                text-align: right;
            }
            table, td {
                border: none;
                padding-bottom: 30px;
                padding-right: 250px;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.LASTNAME != null}">
            <div id="welcome">
                <font color="blue">Welcome, ${sessionScope.LASTNAME}</font>
            </div>

        </c:if>

        <form action="logOut">
            <div id="logOut">
                <input type="submit" value="LOG OUT" id="btn"/>
            </div>
        </form>
        <br/><h1>Your Information</h1>

        <br/><form action="confirmOrder" method="POST">
            <c:set var="customer" value="${sessionScope.CUSTOMER_INFOR}"/>
            <c:set var="orderDTO" value="${sessionScope.ORDER}"/>
            <table border="1">
                <tbody>
                    <tr>
                        <td>
                            <b>Customer ID: </b> ${customer.custID}
                        </td>
                        <td>
                            <b>OrderID : </b> ${orderDTO.orderID}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Customer : </b> ${customer.firstname} ${customer.middleName} ${customer.lastName}
                        </td>
                        <td>
                            <b>Phone : </b> ${customer.phone}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <b>Address : </b> ${requestScope.ADDRESS}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Receiver : </b> ${requestScope.RECEIVER}
                        </td>
                        <td>
                            <b>Receiver's Phone : </b> ${requestScope.PHONE}
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" style="margin-left: 100px; width: 100px;" value="OK" />
            <input type="button" value="CANCEL" style="margin-left: 200px; width: 100px;" onclick="history.back()"/>
        </form>

        <br/><br/><a href="search">Back to continue shopping</a>
        <br/><br/><a href="viewCart">Back to view cart</a>
    </body>
</html>
