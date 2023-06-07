<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Action Tracker: Decision Log</title>
    <script type='text/javascript' >
        let user = "1";
        let topicName = "decision-log";
    </script>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
    <jsp:include page="../msgAndNotif.jsp"/>

    <script type="text/javascript">

        $(function(){
            init();
            requestNotification(); // this is for notification request.
            $('#sendBtn').click(function () {
                var message = $('#message-to-send').val();
                var username = "1";
                addMessage(username, message);
            });
            document.getElementById('message-to-send').addEventListener('keyup',function (event) {
                if (event.keyCode === 13) {
                    event.preventDefault();
                    document.getElementById("sendBtn").click();
                }
            })
        })
        $(document).ready(function () {
            for(var i=0;i<20;i++){
                $('.chat-history-data').prepend('<div class="d-flex justify-content-start mb-4"> <div class="img_cont_msg"> <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img_msg"> </div> <div class="msg_cotainer"> Hi, how are you samim? <span class="msg_time">8:40 AM, Today</span> </div> </div>');
            }
            $("#chat-history").scrollTop($("#chat-history")[0].scrollHeight);
            $('#chat-history').scroll(function(){
                if ($('#chat-history').scrollTop() == 0){
                    blockView();
                    $.ajax({
                        type:'GET',
                        url: contextPath + '/decision-log/get-data',
                        dataType:'json',
                        success:function(data){
                            var templateResponse = Handlebars.compile($("#message-response-template").html());
                            jQuery.each(data, function(index, itemData) {
                                var contextResponse = {
                                    response: itemData.decision,
                                    time: getCurrentTime(),
                                    userName: "hhhhhh"
                                };
                                setTimeout(function(){
                                    $('.chat-history-data').prepend(templateResponse(contextResponse))
                                    unblockView();
                                    $('#chatBox').scrollTop(50);
                                },780);
                            })

                        }
                    });
                }
            });
        });
    </script>
</head>

<body>

<section class="notes-section-banner">

</section>
<main class="main-container">
    <section class="chat-section-wrapper mt-negative">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12 col-xl-12 chat">
                    <div class="card custom-chat-card">
                        <div class="header">
                            <h3 class="header-title mt-3 mb-2">Decision Log..</h3>
                        </div>
                        <div id="chat-history" class="card-body msg_card_body mb-65" style="height:400px;overflow:scroll">
                            <div class='chat-history-data'>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="custom-card-footer fixed-bottom card-footer">
        <div class="input-group">
            <div class="input-group-append">
                <span class="input-group-text custom-input-group-text attach_btn"><i class="fa fa-lock"
                                                                                     aria-hidden="true"></i></span>
            </div>
            <input name="" class="form-control type_msg" type="text" id="message-to-send" placeholder="Type your message...">

            <div class="input-group-append">
                <input type="button" value="Send" class="button btn-success btn-sm" id="sendBtn"/>
                <span class="input-group-text custom-input-group-text attach_btn open-chat-menu"><i
                        class="fa fa-plus-circle" aria-hidden="true"></i></span>
            </div>
            <div class="chat-popup-menu">
                <!--Creates the popup content-->
                <div class="chat-popup-content">
                    <div class="edit-items-list" id="ViewMeuList">
                        <div class="custom-edit-card card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-times text-dark"
                                        aria-hidden="true"></i></span>Close</a></li>
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-exclamation-triangle text-warning"
                                        aria-hidden="true"></i></span>Delete</a></li>
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-exclamation-triangle text-danger"
                                        aria-hidden="true"></i></span>At Risk</a></li>
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-folder-open " aria-hidden="true"></i></span>Reopen</a>
                                </li>
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-calendar text-info"
                                        aria-hidden="true"></i></span>Schudule Meeting</a></li>
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-check text-success"
                                        aria-hidden="true"></i></span>Create New Action</a></li>
                                <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                        class="fa fa-key text-dark" aria-hidden="true"></i></span>Reassign
                                    Action to new owner</a></li>
                            </ul>
                        </div>

                    </div>
                    <button class="close-chat-menu">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</main>

<script id="message-template" type="text/x-handlebars-template">
    <div class="d-flex justify-content-end mb-4">
        <div class="msg_cotainer_send">
            {{messageOutput}}
            <span class="msg_time_send" style="width:80px; right:-15px;color:darkred;">{{time}}, Today</span>
        </div>
        <div class="img_cont_msg">
            <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img_msg">
        </div>
    </div>
</script>

<script id="message-response-template" type="text/x-handlebars-template">
    <div class="d-flex justify-content-start mb-4">
        <div class="img_cont_msg">
            <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img_msg">
        </div>
        <div class="msg_cotainer">
            {{response}}
            <span class="msg_time" style="width:80px;">{{time}}, Today</span>
        </div>
    </div>
</script>
</body>

</html>