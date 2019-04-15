<%-- 
    Document   : viewCart
    Created on : Oct 28, 2018, 2:15:48 PM
    Author     : vtkth
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View your cart</title>

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
            #total{
                text-align: right;
                font-weight: 800;
            }
            table,th, td {
                border: 2px solid black;
                width: 600px;
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

        <h1>Your Cart Detail</h1>

        <c:if test="${sessionScope.LASTNAME != null}">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${not empty cart}">
                <c:set var="listProduct" value="${cart.items}"/>
                <c:if test="${not empty listProduct}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Description</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Sizes</th>
                                <th>Total</th>
                                <th>Action</th>
                            </tr> 
                        </thead>
                        <tbody>
                        <form action="removeItem" method="POST">
                            <c:forEach var="entry" items="${listProduct}" varStatus="counter">
                                <c:set var="total" value="${total + entry.key.total}"/>
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${entry.key.description}</td>
                                    <td>${entry.value}</td>
                                    <th>${entry.key.price}</th>
                                    <th>${entry.key.size}</th>
                                    <th>${entry.key.total}</th>
                                    <th>
                                        <input type="checkbox" name="cbRemove" value="${entry.key.shoesID}-${entry.key.size}" />
                                    </th>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="5" id="total">TOTAL</td>
                                <td>${total}</td>
                                <td>
                                    <input type="submit" value="Remove" />
                                </td>
                            </tr>
                        </form>
                    </tbody>
                </table>

                <br/><a href="viewOrder">Checkout</a>
            </c:if>
            <c:if test="${empty listProduct}">
                <font>Your cart is empty!</font>
            </c:if>
        </c:if>
        <c:if test="${empty cart}">
            <font>Your cart is empty!</font>
        </c:if>
            <br/><br/><a href="search">Back to continue shopping</a>
    </c:if> <!--check logout-->


</body>
</html>
