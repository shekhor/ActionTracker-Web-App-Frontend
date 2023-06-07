<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Action Tracker :: Registration</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="blockAndAlert.jsp"/>
    <script>
        $(document).on('click', '#newSignUpid', function () {
            if(signupEmailAndPassValidate()){
                $('#initialSignUp').hide(500);
                $('#finalSignUp').show();
            }
        });

        $(document).on('click', '#backButtonId', function () {
            $('#finalSignUp').hide(500);
            $('#initialSignUp').show(500);

        });

        $(document).ready(function () {
            alertify.dismissAll();
            if (${!empty error}) {
                var errorMsg = '${error}';
                showErrorMessage(errorMsg);
            }

        });
    </script>
</head>

<body>

<section class="sign-up-section-banner">

</section>
<main class="main-container">
    <section class="signIn-section-wrapper mt-negative">
        <div class="container">
            <c:url var="action" value='/registration'/>
            <form method="post" name="signupForm" action="${action}" onsubmit="return signupFormValidate()">
                <div id="initialSignUp" class="col-md-8 offset-md-2 signin-form-content card">
                    <h3 class="steps-header">Sign up new User..</h3>
                    <div class="row">
                        <div class="col-sm-2">
                            <p>Steps</p>
                        </div>
                        <div class="col-sm-10">
                            <ul class="progressbar">
                                <li class="active"></li>
                                <li></li>
                            </ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="emailId">Email address*</label>
                        <input type="text" class="form-control" id="emailId" name="email" aria-describedby="emailHelp">
                        <small id="emailHelp" class="form-text text-muted">*buisness email address to enable colobration with team.</small>
                    </div>
                    <div class="form-group">
                        <label for="passwordId">Password</label>
                        <input type="password" class="form-control" id="passwordId" name="encryptedPassword">
                        <small class="form-text text-muted">*Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters.</small>
                    </div>
                    <div class="form-group">
                        <label for="conformPassId">Reenter Password</label>
                        <input type="password" class="form-control" id="conformPassId" name="confirmEncryptedPassword">
                    </div>

                    <div class="input-group-btn mb-3 group-end">
                        <button id="newSignUpid" type="button" class="btn btn-warning custom-warning text-white btnNext">Next</button>
                    </div>
                </div>
                <div id="finalSignUp" style="display: none" class="col-md-8 offset-md-2 signin-form-content card">
                    <h3 class="steps-header">Sign up new User..</h3>
                    <div class="row">
                        <div class="col-sm-2">
                            <p>Steps</p>
                        </div>
                        <div class="col-sm-10">
                            <ul class="progressbar-two">
                                <li></li>
                                <li class="active"></li>
                            </ul>
                        </div>
                    </div>

<%--                    <div class="form-group">--%>
<%--                        <label class="control-label">Confirmation code</label>--%>
<%--                        <input maxlength="200" type="text" class="form-control" placeholder="code">--%>
<%--                    </div>--%>

                    <div class="form-group">
                        <label class="control-label">First Name</label>
                        <input name="firstName" maxlength="200" type="text" class="form-control" placeholder="Enter firstname">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Last Name</label>
                        <input name="lastName" maxlength="200" type="text" class="form-control" placeholder="Enter lastname">
                    </div>
<%--                    <div class="avatar-upload">--%>
<%--                        <div class="avatar-edit">--%>
<%--                            <input type='file' id="imageUpload" accept=".png, .jpg, .jpeg" />--%>
<%--                            <label for="imageUpload"></label>--%>
<%--                        </div>--%>
<%--                        <div class="avatar-preview">--%>
<%--                            <div id="imagePreview" style="background-image: url(http://i.pravatar.cc/500?img=7);">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                    <div class="input-group-btn mt-3 group-end">
                        <button id="backButtonId" type="button" class="btn btn-warning custom-warning text-white btnNext">Back</button>
                        <button id="submitButtonId" type="submit" class="btn btn-warning custom-warning pull-right btnNext text-white">Finish</button>
<%--                        <a class="btn btn-warning custom-warning pull-right btnNext text-white">Finish</a>--%>
                    </div>
                </div>
            </form>
        </div>
    </section>
</main>

</body>

</html>