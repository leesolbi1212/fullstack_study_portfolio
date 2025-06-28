package com.koreait.mvc2.dao;

import com.koreait.mvc2.dto.MessageDTO;
import com.koreait.mvc2.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    public boolean insertMessage(MessageDTO dto){
        String sql = "insert into message(sender_id,content,receiver_id,send_date) values(?,?,?,NOW())";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getSenderID());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getReceiverID());
            return pstmt.executeUpdate()== 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MessageDTO> getAllmessage(String senderId, String receiverId, String content){
        List<MessageDTO> messagelist = new ArrayList<>();
        String sql = "select * from message where sender_id=? and receiver_id=? and content=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, senderId);
            pstmt.setString(2, receiverId);
            pstmt.setString(3, content);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MessageDTO dto = new MessageDTO();
                    dto.setSenderID(rs.getString("sender_id"));
                    dto.setReceiverID(rs.getString("receiver_id"));
                    dto.setContent(rs.getString("content"));
                    dto.setDeletedBySender(rs.getBoolean("deleted_by_sender"));
                    dto.setDeletedByReceiver(rs.getBoolean("deleted_by_receiver"));
                    messagelist.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return messagelist;
    }

    public MessageDTO getOnemessageByID(int messageID){
        String sql = "select * from message where message_id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, messageID);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                MessageDTO dto = new MessageDTO();
                dto.setSenderID(rs.getString("sender_id"));
                dto.setReceiverID(rs.getString("receiver_id"));
                dto.setContent(rs.getString("content"));
                dto.setSendDate(rs.getTimestamp("send_date"));
                dto.setDeletedBySender(rs.getBoolean("deleted_by_sender"));
                dto.setDeletedByReceiver(rs.getBoolean("deleted_by_receiver"));
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }
    public boolean deletemassage(int messageID,String userType){
        String sql = "";
        if ("sender".equals(userType)) {
            sql = "UPDATE message SET deleted_by_sender = TRUE WHERE msg_id = ?";
        } else if ("receiver".equals(userType)) {
            sql = "UPDATE message SET deleted_by_receiver = TRUE WHERE msg_id = ?";
        } else {
            return false;
        }
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, messageID);
            return pstmt.executeUpdate() == 1;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<MessageDTO> getReceivedMessages(String receiverId) {
        List<MessageDTO> messageList = new ArrayList<>();
        String sql = "SELECT * FROM message WHERE receiver_id = ? ORDER BY send_date DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, receiverId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MessageDTO dto = new MessageDTO();
                dto.setMessageID(rs.getInt("msg_id"));
                dto.setSenderID(rs.getString("sender_id"));
                dto.setReceiverID(rs.getString("receiver_id"));
                dto.setContent(rs.getString("content"));
                dto.setSendDate(rs.getTimestamp("send_date"));
                dto.setDeletedBySender(rs.getBoolean("deleted_by_sender"));
                dto.setDeletedByReceiver(rs.getBoolean("deleted_by_receiver"));
                messageList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messageList;
    }

    public List<MessageDTO> getSendMessages(String senderId) {
        List<MessageDTO> messageList = new ArrayList<>();
        String sql = "SELECT * FROM message WHERE sender_id = ? ORDER BY send_date DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, senderId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MessageDTO dto = new MessageDTO();
                dto.setMessageID(rs.getInt("msg_id"));
                dto.setSenderID(rs.getString("sender_id"));
                dto.setReceiverID(rs.getString("receiver_id"));
                dto.setContent(rs.getString("content"));
                dto.setSendDate(rs.getTimestamp("send_date"));
                dto.setDeletedBySender(rs.getBoolean("deleted_by_sender"));
                dto.setDeletedByReceiver(rs.getBoolean("deleted_by_receiver"));
                messageList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messageList;
    }
}
