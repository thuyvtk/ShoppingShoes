<%-- 
    Document   : register
    Created on : Oct 27, 2018, 1:22:18 AM
    Author     : vtkth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <style>
            table, td {
                border: none;
                border-collapse: collapse;

            }
            #btn{
                display: block;
                text-align: center;
                text-transform: uppercase;
                color:black;
                font-weight: 800;
                padding: 10px 20px;
                margin: 0 auto;
                box-shadow: 0 5px 15px rgba(0,0,0,0.20);
            }
            .fontTd {
                font-weight: 800;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center"><font color="blue">Create new account</font></h1>
        <form action="register" method="POST">
            <c:set var="errors" value="${requestScope.REGISTER_ERROR}"/>
            <c:set var="customer" value="${requestScope.CUSTOMER}"/>
            <c:set var="account" value="${requestScope.ACCOUNT}"/>
            <table border="1" Cellpadding= "10">
                <tbody>
                    <tr>
                        <td class="fontTd">Username : </td>
                        <td>
                            <input type="text" name="txtUsername" value="${account.username}" size="50" /> (6 - 20 characters)
                        </td>
                        <c:if test="${not empty errors.usernameLengthErr}">
                            <td>
                                <font color="red">${errors.usernameLengthErr}</font>
                            </td>
                        </c:if>
                        <c:if test="${not empty errors.dupplcateUsername}">
                            <td>
                                <font color="red">${errors.dupplcateUsername}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">Password :  </td>
                        <td>
                            <input type="password" name="txtPassword" value="${account.password}" size="50"/> (6 - 30 characters)
                        </td>
                        <c:if test="${not empty errors.passwordLengthErr}">
                            <td>
                                <font color="red">${errors.passwordLengthErr}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">Confirm password : </td> 
                        <td>
                            <input type="password" name="txtConfirm" value="${requestScope.CONFIRM}" size="50"/> (6 - 30 characters)
                        </td>
                        <c:if test="${not empty errors.confirmNotMatch}">
                            <td>
                                <font color="red">${errors.confirmNotMatch}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">Last Name : </td>
                        <td>
                            <input type="text" name="txtLastname" value="${customer.lastName}" size="50"/> (Max length is 15 characters)
                        </td>
                        <c:if test="${not empty errors.lastnameLenghtErr}">
                            <td>
                                <font color="red">${errors.lastnameLenghtErr}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">Middle name : </td>
                        <td>
                            <input type="text" name="txtMiddleName" value="${customer.middleName}" size="50"/> (Max length is 30 characters)
                        </td>
                        <c:if test="${not empty errors.middleNameLenghtErr}">
                            <td>
                                <font color="red">${errors.middleNameLenghtErr}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">First name : </td>
                        <td>
                            <input type="text" name="txtFirstName" value="${customer.firstname}" size="50"/> (Max length is 15 characters)
                        </td>
                        <c:if test="${not empty errors.firstnameLenghtErr}">
                            <td>
                                <font color="red">${errors.firstnameLenghtErr}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">Address : </td>
                        <td>
                            <input type="text" name="txtAddress" value="${customer.address}" size="50"/> (Max length is 250 characters)
                        </td>
                        <c:if test="${not empty errors.addressLenghtErr}">
                            <td>
                                <font color="red">${errors.addressLenghtErr}</font>
                            </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="fontTd">Phone : </td>
                        <td>
                            <input type="text" name="txtPhone" value="${customer.phone}" size="50"/> (9 - 11 characters)
                        </td>
                        <c:if test="${not empty errors.phoneErr}">
                            <td>
                                <font color="red">${errors.phoneErr}</font>
                            </td>
                        </c:if>
                    </tr>

                </tbody>
            </table>
            <br/>

            <input type="submit" value="Register" id="btn"/>
        </form>
        
        <a href="login.html">CLICK HERE TO LOGIN</a>
    </body>
</html>
