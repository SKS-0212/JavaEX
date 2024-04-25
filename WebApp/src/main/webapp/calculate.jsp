<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculation Result</title>
<style>
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: lightpurple; /* Change to desired color */
    }

    .box {
        border: 2px solid #ccc; /* Border style */
        padding: 20px; /* Padding around the centered content */
        border-radius: 10px; /* Border radius for rounded corners */
    }
</style>
</head>
<body>
    <div class="container">
        <div class="box">
            <h2>Calculation Result</h2>
            <hr>
            <%
                double num1 = Double.parseDouble(request.getParameter("num1"));
                double num2 = Double.parseDouble(request.getParameter("num2"));

                if (request.getParameter("add") != null) {
                    out.println("Addition Result: " + (num1 + num2) + "<br>");
                }
                if (request.getParameter("subtract") != null) {
                    out.println("Subtraction Result: " + (num1 - num2) + "<br>");
                }
                if (request.getParameter("multiply") != null) {
                    out.println("Multiplication Result: " + (num1 * num2) + "<br>");
                }
                if (request.getParameter("divide") != null) {
                    if (num2 != 0) {
                        out.println("Division Result: " + (num1 / num2) + "<br>");
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                }
            %>
        </div>
    </div>
</body>
</html>
