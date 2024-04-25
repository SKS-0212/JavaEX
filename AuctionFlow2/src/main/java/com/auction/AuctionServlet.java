package com.auction;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/AuctionServlet")
public class AuctionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuctionItem item = new AuctionItem();
        item.setItemId(request.getParameter("itemID"));
        item.setItemName(request.getParameter("itemName"));
        item.setBidderName(request.getParameter("yourName"));
        item.setBidderEmail(request.getParameter("email"));
        item.setBidAmount(Double.parseDouble(request.getParameter("amountBid")));
        item.setAutoIncrement(request.getParameter("autoIncrement") != null);

        request.setAttribute("auctionItem", item);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
