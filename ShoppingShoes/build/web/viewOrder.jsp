<%-- 
    Document   : viewOrder
    Created on : Oct 28, 2018, 11:07:51 PM
    Author     : vtkth
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order page</title>
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
            table {
                margin-left: 50px;
            }
            table#tb1 td {
                padding-bottom: 10px;
                width: 200px;
                border: 2px solid black;
            }
            th{
                border: 2px solid black;
                height: 30px;
                color: darkblue;
            }
            table#tb2 td {
                padding-left: 100px;
                padding-right: 250px;
                padding-bottom: 20px;
            }
        </style>
    </head>
    <script>
        function check() {
            var valid = true;
            var error = "";
            var address = document.getElementById("address");
            if (address.value.trim() === "") {
                error += "Address must be not blank!\n";
                valid = false;
            }

            var receiver = document.getElementById("reciever");
            if (receiver.value.trim() === "") {
                error += "Reciever must be not blank!\n";
                valid = false;
            }

            var phone = document.getElementById("phone");
            if (!phone.value.trim().match("^0\\d{8,}$")) {
                error += "Phone is 9 to 11 digits and begin 0!\n";
                valid = false;
            }
            if (phone.value.trim().length > 11) {
                error += "Phone is 9 to 11 digits!\n";
                valid = false;
            }
            if (error === "") {
            } else {
                alert(error);
            }
            return valid;
        }

        function confirmExit() {
            var r = confirm("All your cart will be removed. Are you sure?");
            return r;
        }

    </script>
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
        <br/><h1>Finishing Your Order</h1>
        <c:if test="${sessionScope.LASTNAME != null}">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <table border="2" id="tb1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="listProduct" value="${cart.items}"/>
                    <c:forEach var="entry" items="${listProduct}" varStatus="counter">
                        <c:set var="total" value="${total + entry.key.total}"/>
                        <tr>
                            <td>${counter.count}</td>
                            <td>${entry.key.description}</td>
                            <td>${entry.value}</td>
                            <td>${entry.key.price}</td>
                            <td>${entry.key.total}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4" id="total">Total</td>
                        <td><span style="font-weight: 800">${total}</span></td>
                    </tr>
                </tbody>
            </table><!--Detail item-->

            <!--Detail order-->
            <br/><font color="blue" style="font-size: 20px; margin-left: 150px;">Customer Information</font>
            <form action="orderDetail" method="POST" onsubmit="return check()">
                <c:set var="orderDTO" value="${sessionScope.ORDER}"/>
                <c:set var="customer" value="${sessionScope.CUSTOMER_INFOR}"/>
                <br/><table border="0" id="tb2">
                    <tbody>
                        <tr>
                            <td><span style="font-weight: 800">OrderId:</span> ${orderDTO.orderID} </td>
                            <td><span style="font-weight: 800">Date:</span> ${orderDTO.orderDate}</td>

                        </tr>
                        <tr>
                            <td><span style="font-weight: 800">Customer:</span>  ${customer.firstname} ${customer.middleName} ${customer.lastName}</td>
                            <td><span style="font-weight: 800">Phone:</span>   ${customer.phone}</td>
                        </tr>
                    </tbody>
                </table>
                <span style="font-weight: 800; margin-left: 150px;">Address*:</span> <input type="text" name="txtAddress" value="" size="105" id="address" /><br/><br/>
                <span style="font-weight: 800; margin-left: 150px;">Receiver*:</span> <input type="text" name="txtReceiver" value="" id="reciever"/>
                <span style="font-weight: 800; margin-left: 30px;">Receiver's Phone*:</span> <input type="text" name="txtRvPhone" value="" size="50" id="phone"/><br/><br/>
                <input type="submit" value="Confirm" style="margin-left: 150px; float: left"/>
                <input type="button" value="Back" style="width: 150px; margin-left: 230px; float: left" onclick="history.back()"/>
            </form>
            <form action="exitOrder" method="POST" onsubmit="return confirmExit()">
                <input type="submit" value="Exit" style="margin-right: 450px; float: right"/>
            </form>

            <br/><br/><a href="search">Back to continue shopping</a>
        </c:if> 

    </body>
</html>
