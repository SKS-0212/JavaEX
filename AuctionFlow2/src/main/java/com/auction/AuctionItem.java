package com.auction;

public class AuctionItem {
    private String itemId;
    private String itemName;
    private String bidderName;
    private String bidderEmail;
    private double bidAmount;
    private boolean autoIncrement;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }


    public String getBidderEmail() {
        return bidderEmail;
    }

    public void setBidderEmail(String bidderEmail) {
        this.bidderEmail = bidderEmail;
    }

    // Getters and Setters for bidAmount
    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    // Getters and Setters for autoIncrement
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }
}