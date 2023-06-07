function signupFormValidate(){
    var firstName = document.forms["signupForm"]["firstName"].value;

    var lastName = document.forms["signupForm"]["lastName"].value;

    dismissAllAlert();

    if(signupEmailAndPassValidate()){
        if(firstName.length<1 || lastName.length<1){
            var msg = alertify.error('Firstname or lastname should not be empty',0);
            dismissAlertSetTimeout(msg);
            return false;
        }
        return true;
    }

    return false;
}

function signupEmailAndPassValidate(){

    dismissAllAlert();

    var password = document.forms["signupForm"]["encryptedPassword"].value;

    var confirmPass = document.forms["signupForm"]["confirmEncryptedPassword"].value;

    var emailVarify = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    var email = document.forms["signupForm"]["email"].value;
    if (!emailVarify.test(email))
    {
        var msg = alertify.error('You have entered an invalid email address!',0);
        dismissAlertSetTimeout(msg);
        return false;
    }

    var lowerCaseLetters = /[a-z]/g;
    if(!password.match(lowerCaseLetters)) {
        var msg = alertify.error('Password must contain at least one lowercase letter',0);
        dismissAlertSetTimeout(msg);
        return false;
    }

    var upperCaseLetters = /[A-Z]/g;
    if(!password.match(upperCaseLetters)) {
        var msg = alertify.error('Password must contain at least one uppercase letter',0);
        dismissAlertSetTimeout(msg);
        return false;
    }

    var numbers = /[0-9]/g;
    if(!password.match(numbers)) {
        var msg = alertify.error('Password must contain at least one number',0);
        dismissAlertSetTimeout(msg);
        return false;
    }

    if(password.length<8) {
        var msg = alertify.error('Password must contain at least 8 or more characters',0);
        dismissAlertSetTimeout(msg);
        return false;
    }

    if(password != confirmPass){
        var msg = alertify.error('Confirm password doesn\'t match password',0);
        dismissAlertSetTimeout(msg);
        return false;
    }
    return true;
}

function dismissAllAlert() {
    alertify.dismissAll();
}

function dismissAlertSetTimeout(msg) {
    window.timeout = setTimeout(function(){
        msg.dismiss();
    },2000);
}