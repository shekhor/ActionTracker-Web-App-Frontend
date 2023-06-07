<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Action Tracker :: Login</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="blockAndAlert.jsp"/>

    <meta name="google-signin-client_id" content="138279268322-kgtanfs5uta524rcd22movdms7v9md4h.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script>
        $(document).ready(function () {
            alertify.dismissAll();

            if (${!empty(error)}) {
                var errorMsg = '${error}';
                showErrorMessage(errorMsg);
            }
            if (${!empty(success)}) {
                var successMsg = '${success}';
                showSuccessMessage(successMsg);

            }
            var gError = '${gerror}';
            if(gError != ''){
                showAlert(gError,function () {
                    //location.href = '${contextPath}'+'/login?gsso=true';
                })
            }
        });
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
            console.log('Name: ' + profile.getName());
            console.log('Image URL: ' + profile.getImageUrl());
            console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
        }


        function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
                console.log('User signed out.');
            });
        }
    </script>
</head>

<body>

<section class="login-section-wrapper">
    <div class="container-fluid">
        <div class="row no-gutter">
            <div class="d-block d-sm-none welcome-bg"></div>
            <div class="d-none d-md-flex col-md-6 col-lg-6 bg-image"></div>
            <div class="col-md-6 col-lg-6">
                <div class="login d-flex align-items-center py-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-9 col-lg-8 mx-auto">
                                <h3 class="login-heading mb-4">Welcome back!</h3>
                                <form:form id="authForm" action="${pageContext.servletContext.contextPath}/login/process"
                                           modelAttribute="authRequest" method="post" class="form-signin">

                                    <div class="form-label-group">
                                        <label for="login-username">Email address</label>
                                        <input type="email" id="login-username" name="username" class="form-control" placeholder="Email address" required
                                               autofocus>
                                    </div>

                                    <div class="form-label-group">
                                        <label for="login-password">Password</label>
                                        <input type="password" id="login-password" name="password" class="form-control" placeholder="Password" required>
                                    </div>

                                    <div class="custom-control custom-checkbox mb-3">
                                        <input type="checkbox" class="custom-control-input" id="customCheck1">
                                        <label class="custom-control-label" for="customCheck1">Remember password</label>
                                    </div>

                                    <input type="submit" class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" value="Submit"/>
<%--                                    <a href="${contextPath}/g-login">--%>
<%--                                        <div class="google-btn">--%>
<%--                                            <div class="google-icon-wrapper">--%>
<%--                                                <img class="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"/>--%>
<%--                                            </div>--%>
<%--                                            <p class="btn-text"><b>Sign in</b></p>--%>
<%--                                        </div>--%>

<%--                                    </a>--%>
                                    <div class="g-signin2" data-onsuccess="onSignIn"></div>
                                    <c:forEach items="${urls}" var="item">

                                        <a text="${item.value}" href="${item.value}" class="list-group-item active">Client</a>
                                    </c:forEach>
                                    <hr style="border: 1px solid #007bff;">

<%--                                    <a href="${contextPath}/g-reg">--%>
<%--                                        <div class="google-btn">--%>
<%--                                            <div class="google-icon-wrapper">--%>
<%--                                                <img class="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"/>--%>
<%--                                            </div>--%>
<%--                                            <p class="btn-text"><b>Sign up</b></p>--%>
<%--                                        </div>--%>
<%--                                    </a>--%>

                                    <div class="form-group row">
                                        <div class="col-md-8">
                                            Don't have an account? <a class="small" href="${contextPath}/registration">Signup here </a>
                                        </div>
                                        <div class="col-md-4">
                                            <a class="small" href="#">Forgot password?</a>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</body>

</html>