<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/8/2020
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Action Tracker</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>

    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700&display=swap" rel="stylesheet">
    <script type="text/javascript">
        function addMileStone(){
            blockView();
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: 'create-milestone',
                data: $('#milestoneFormId').serialize(),
                success: function(responseData) {
                    unblockView();
                    if (responseData['status'] == "SUCCESS") {
                        showSuccessMessage(responseData['message']);
                        $('#milestoneDescriptionId').val('');
                        $('#icon').val('');
                    }else if (responseData['status'] == "ERROR") {
                        showErrorMessage(responseData['message']);
                    }
                },
                error: function(responseData) {
                    showAlert("Failed to process action");
                    unblockView();
                },
                complete: function(e) {

                }
            });
        }
    </script>
</head>

<body>

<section class="calendar-section-banner">

</section>
<main class="main-container">
    <section class="col-md-8 offset-md-2 calendar-section-wrapper card mt-negative">
        <div class="container">
            <div class="header">
                <h3 class="header-title">Dates and Milestones..</h3>
            </div>

            <div class="project-milestone">
                <div class="milestone-box">
                    <div class="box-row">
                        <div class="box-cell box1">
                            <p class="font-weight-bold">Description</p>
                        </div>
                        <div class="box-cell box2">
                            <p class="font-weight-bold">Dates..</p>
                        </div>
                    </div>
                </div>

                <form:form action="" id="milestoneFormId" method="post">
                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" id="milestoneDescriptionId" name="description" placeholder="Description">
                        <span class="input-group-addon"></span>
                        <input readonly="readonly" class="icon datepicker form-control form-spacing" name="milestoneDate" data-date-format="mm/dd/yyyy" />
                    </div>

                </form:form>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="float-left">
                                <input type="button" class="btn btn-primary text-white" onclick="addMileStone();" value="Add Date.."/>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<jsp:include page="../footer.jsp"/>
</body>

</html>
