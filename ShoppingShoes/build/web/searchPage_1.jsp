<%-- 
    Document   : searchPage
    Created on : Oct 26, 2018, 11:08:02 PM
    Author     : vtkth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            #btn{
                text-transform: uppercase;
                color:black;
                font-weight: 800;
                padding: 10px 20px;
            }
            #searchBtn{
                margin-left: 100px;
            }
            table,th, td {
                border: 2px solid black;
                width: 600px;
                height: 35px;
            }
            #btnAdd {
                background: white;
                border: none;
                border-bottom: 1px solid black;
                font-size: 15px;
                cursor: pointer;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <script>
        function changeSize(object, count) {
            var price = document.getElementById(count);
            var value = object.value;
            var split = value.split("-", 2);
            price.innerHTML = split[0];
            v = value;
        }
        
        function noticeQuanity(message) {
            var a = message;
            if (a.length>0) {
                alert(a);
            }
        }
    </script>
    <body onload="noticeQuanity('${sessionScope.MESSAGE_QUANTITY}')">
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

        <h1>Search Shoes</h1>
        <form action="search" method="POST">
            Description :  <input type="text" name="txtSearch" value="${param.txtSearch}" size="40" /><br/><br/>
            <input type="submit" value="Search" id="searchBtn"/>
            <input type="reset" value="Reset" id="searchBtn"/><br><br/>
        </form>

        <c:if test="${sessionScope.LASTNAME != null}">
            <c:set var="searchValue" value="${param.txtSearch.trim()}"/>
            <c:if test="${not empty searchValue}">
                <c:set var="listResult" value="${requestScope.LIST_RESULT}"/>
                <c:if test="${listResult != null}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Sizes</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${listResult}" varStatus="counter">
                            <form action="addToCart">

                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.description}
                                    </td>
                                    <td id="${counter.count}">
                                        <c:forEach var="entry" items="${dto.listPriceSizes}" end="0">
                                            ${entry.value}
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <select name="cbSize" id="cmbSize" onchange="changeSize(this, ${counter.count})">
                                            <c:forEach var="entry" items="${dto.listPriceSizes}" varStatus="count">
                                                <option value="${entry.value}-${entry.key}">${entry.key}</option>
                                            </c:forEach>
                                        </select> 

                                    </td>
                                    <td>
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                        <input type="hidden" name="pk" value="${dto.shoesID}" />
                                        <input type="submit" value="Add to cart" id="btnAdd"/>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if> <!--list result != null-->

            <c:if test="${listResult == null}">
                <h1>
                    <font color="red">No record is matches!</font>
                </h1>
            </c:if>
        </c:if> <!--search value != null-->
        <a href="viewCart">View Cart</a>
    </c:if> <!--check logout-->
</body>
</html>
