package com.koreait.mvc2.dto;

import java.sql.Timestamp;

public class MessageDTO {
    private int messageID;
    private String senderID;
    private String receiverID;
    private String content;
    private Timestamp sendDate;
    private boolean deletedBySender;
    private boolean deletedByReceiver;

    public MessageDTO() {
    }

    public MessageDTO(int messageID, String senderID, String receiverID, String content, Timestamp sendDate, boolean deletedBySender, boolean deletedByReceiver) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
        this.sendDate = sendDate;
        this.deletedBySender = deletedBySender;
        this.deletedByReceiver = deletedByReceiver;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isDeletedBySender() {
        return deletedBySender;
    }

    public void setDeletedBySender(boolean deletedBySender) {
        this.deletedBySender = deletedBySender;
    }

    public boolean isDeletedByReceiver() {
        return deletedByReceiver;
    }

    public void setDeletedByReceiver(boolean deletedByReceiver) {
        this.deletedByReceiver = deletedByReceiver;
    }
} // CLASS
