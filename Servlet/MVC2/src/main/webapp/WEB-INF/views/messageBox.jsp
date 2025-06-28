
<!-- /WEB-INF/views/messageBox.jsp -->
<div id="messageBox" style="display:none; position:absolute; border:1px solid #ccc; padding:10px; background:white;">
    <form method="post" action="sendMessage.msg">
        <input type="hidden" name="receiver_id" id="receiverIdInput">
        <input type="hidden" name="sender_id" id="senderIdInput">
        <p><textarea name="content" placeholder="쪽지를 입력하세요"></textarea></p>
        <button type="submit">보내기</button>
        <button type="button" onclick="document.getElementById('messageBox').style.display='none'">닫기</button>
    </form>
</div>

