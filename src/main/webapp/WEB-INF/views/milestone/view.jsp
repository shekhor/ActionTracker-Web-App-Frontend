<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Action Tracker :: Milestone</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
    <script>
        function showMilestones(successMsg) {
            alertify.dismissAll();
            blockView();
            $.ajax({
                type:'GET',
                url: contextPath + '/milestone/get-data',
                dataType:'json',
                success:function(data){
                    unblockView();
                    if (successMsg) {
                        showSuccessMessage(successMsg);
                    }
                    var templateResponse = Handlebars.compile($("#milestone-response-template").html());
                    if(data.length > 0){
                        jQuery.each(data, function(index, itemData) {
                            var date = itemData.milestoneDate;
                            date = date.substring(0,10);
                            var contextResponse = {
                                description: itemData.description,
                                date: date
                            };
                            setTimeout(function(){
                                $('#milestoneView').prepend(templateResponse(contextResponse))
                            },780);
                        })
                        $('#milestoneViewId').show();
                    }
                },
                error: function(responseData) {
                    showErrorMessage("Failed to process action");
                    dismissAllAlert();
                    $('#milestoneViewId').hide();
                    unblockView();
                }

            });
        }

        $(document).ready(function () {
            showMilestones('')
        });

        function addMileStone(){
            alertify.dismissAll();
            blockView();
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: contextPath + '/milestone/create-milestone',
                data: $('#milestoneFormId').serialize(),
                success: function(responseData) {
                    unblockView();
                    if (responseData['status'] == "SUCCESS") {
                        $('#milestoneDescriptionId').val('');
                        $('#milestoneDate').val('');
                        showMilestones(responseData['message']);
                    }else if (responseData['status'] == "ERROR") {
                        showErrorMessage(responseData['message']);
                    }
                },
                error: function(responseData) {
                    showErrorMessage("Failed to process action");
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
            <div class="project-milestone">

                <div id="milestoneViewId" style="display: none">
                    <div class="header">
                        <h3 class="header-title">Dates and Milestones..</h3>
                    </div>
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

                    <div id="milestoneView">
                    </div>
                </div>

                <div class="header">
                    <h3 class="header-title">Add Dates and Milestones..</h3>
                </div>

                <form:form action="" id="milestoneFormId" method="post">
                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" id="milestoneDescriptionId" name="description" placeholder="Description">
                        <span class="input-group-addon"></span>
                        <input readonly="readonly" class="icon datepicker form-control form-spacing" name="milestoneDate" id="milestoneDate" data-date-format="mm/dd/yyyy" />
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

<script id="milestone-response-template" type="text/x-handlebars-template">
    <div class="input-group custom-input-group">
        <input type="text" class="form-control form-spacing" placeholder="Description" value="{{description}}">
        <span class="input-group-addon"></span>
        <input id="icon" class="datepicker form-control form-spacing"
               data-date-format="mm/dd/yyyy" value="{{date}}"/>
    </div>
</script>
<jsp:include page="../footer.jsp"/>
</body>

</html>