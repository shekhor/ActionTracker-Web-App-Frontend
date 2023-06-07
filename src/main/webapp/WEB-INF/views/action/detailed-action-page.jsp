<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Action Tracker :: Action Details</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/asset/css/nice-select.css">
</head>

<body>

<main class="main-container">
    <section class="bredcrumber-wrapper">
        <div class="container">

            <div class="row">
                <div class="col-6">
                    <a href="dashboard.html" class="custom-btn">&#8249; Dashboard</a>
                </div>
                <div class="col-6">
                    <div class="edit-cart float-right">
                        <label data-toggle="collapse" data-target="#ViewMeuList">
                            <a href="#" class="custom-btn">Edit</a>
                        </label>
                        <div class="edit-items-list collapse" id="ViewMeuList">
                            <div class="custom-edit-card card">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-calendar text-danger"
                                            aria-hidden="true"></i></span>Dates And Milestons</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-list-ul text-secondary"
                                            aria-hidden="true"></i></span>Add Category</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-file-excel-o text-success"
                                            aria-hidden="true"></i></span>Export to excel</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-tag text-secondary"
                                            aria-hidden="true"></i></span>Modify tags</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-file-text-o text-info"
                                            aria-hidden="true"></i></span>Modify Project Header</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-clock-o text-secondary"
                                            aria-hidden="true"></i></span>Schudule Metting</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-users text-warning"
                                            aria-hidden="true"></i></span>Invite Team Member</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-cog text-primary"
                                            aria-hidden="true"></i></span>Profile Setting</a></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="chat-section-wrapper">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12 col-xl-12 chat">
                    <div class="card custom-chat-card">
                        <div class="chat-card-header msg_head">
                            <div class="d-flex bd-highlight">
                                <div class="img_cont">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img">
                                    <span class="online_icon"></span>
                                </div>
                                <div class="chat_user_info">
                                    <span>Neil Coomber</span>
                                    <h6>Solution Software</h6>
                                    <p>Email:example@gmail.com</p>
                                </div>

                            </div>
                            <span id="action_menu_btn">Email</span>

                        </div>
                        <div class="card-body msg_card_body mb-65">
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    Hi, how are you samim?
                                    <span class="msg_time">8:40 AM, Today</span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mb-4">
                                <div class="msg_cotainer_send">
                                    Hi Khalid i am good tnx how about you?
                                    <span class="msg_time_send">8:55 AM, Today</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                            </div>
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    I am good too, thank you for your chat template
                                    <span class="msg_time">9:00 AM, Today</span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mb-4">
                                <div class="msg_cotainer_send">
                                    You are welcome
                                    <span class="msg_time_send">9:05 AM, Today</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                            </div>
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    I am looking for your next templates
                                    <span class="msg_time">9:07 AM, Today</span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mb-4">
                                <div class="msg_cotainer_send">
                                    Ok, thank you have a good day
                                    <span class="msg_time_send">9:10 AM, Today</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                            </div>
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    Bye, see you
                                    <span class="msg_time">9:12 AM, Today</span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mb-4">
                                <div class="msg_cotainer_send">
                                    Ok, thank you have a good day
                                    <span class="msg_time_send">9:10 AM, Today</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                            </div>
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    Bye, see you
                                    <span class="msg_time">9:12 AM, Today</span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mb-4">
                                <div class="msg_cotainer_send">
                                    Ok, thank you have a good day
                                    <span class="msg_time_send">9:10 AM, Today</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                            </div>
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    Bye, see you
                                    <span class="msg_time">9:12 AM, Today</span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mb-4">
                                <div class="msg_cotainer_send">
                                    Ok, thank you have a good day
                                    <span class="msg_time_send">9:10 AM, Today</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                            </div>
                            <div class="d-flex justify-content-start mb-4">
                                <div class="img_cont_msg">
                                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                         class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    Bye, see you
                                    <span class="msg_time">9:12 AM, Today</span>
                                </div>
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
            <input name="" class="form-control type_msg" placeholder="Type your message...">

            <div class="input-group-append">
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
</body>

</html>