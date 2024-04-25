<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Math Operations</title>
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
            <form action="calculate.jsp" method="post">
                <h2>Math Operations</h2>
                <hr>

                <input type="checkbox" name="add" checked> Addition<br>
                <input type="checkbox" name="subtract"> Subtraction<br>
                <input type="checkbox" name="multiply"> Multiplication<br>
                <input type="checkbox" name="divide"> Division<br><br>

                Enter Number 1: <input type="number" name="num1"><br>
                Enter Number 2: <input type="number" name="num2"><br><br>

                <input type="submit" value="Calculate">
            </form>
        </div>
    </div>
</body>
</html>
