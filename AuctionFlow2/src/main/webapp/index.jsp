<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bid Submitted</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ffdd00; /* Yellow background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        text-align: center;
    }
    .container {
        background-color: #000; /* Black background */
        color: #ffdd00; /* Yellow text */
        padding: 20px;
        border-radius: 5px;
        display: inline-block;
    }
    h1 {
        color: #000; /* Black text */
    }
    .details {
        border: 2px solid #ffdd00; /* Yellow border */
        padding: 10px;
        margin-top: 15px;
        display: inline-block;
        text-align: left;
    }
    .details p {
        margin: 10px 0;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Bid Submitted</h1>
    <p>Your bid is now active. If your bid is successful, you will be notified within 24 hours of the close of bidding.</p>
    <div class="details">
        <p><strong>Item:</strong> <%= request.getParameter("itemName") %></p>
        <p><strong>Item ID:</strong> <%= request.getParameter("itemID") %></p>
        <p><strong>Name:</strong> <%= request.getParameter("yourName") %></p>
        <p><strong>Email address:</strong> <%= request.getParameter("email") %></p>
        <p><strong>Bid price:</strong> Rs<%= request.getParameter("amountBid") %></p>
        <p><strong>Auto-increment price:</strong> <%= request.getParameter("autoIncrement") != null ? "true" : "false" %></p>
    </div>
</div>
</body>
</html>