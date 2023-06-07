<!DOCTYPE html>
<html lang="en">

<head>
    <title>Action Tracker :: Create Project Action</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
</head>

<body>

<section class="action-section-banner">

</section>
<main class="main-container">
    <section class="project-section-wrapper mt-negative">
        <div class="container">
            <div class="col-md-8 offset-md-2 signin-form-content card">
                <div class="header">
                    <h3 class="header-title">Create New Action..</h3>
                </div>
                <div class="project-group">
                    <form action="">
                        <div class="form-group">
                            <label for="descriptionTextarea">Action Description:</label>
                            <textarea class="form-control" id="descriptionTextarea" rows="5"></textarea>
                        </div>
                        <div class="group-of-action-owner">
                            <div class="form-group fieldGroup">
                                <label for="ActionOwnerInput">Action Owner:</label>
                                <div class="input-group">
                                    <input type="text" name="action-owner" id="ActionOwnerInput"
                                           class="form-control" placeholder="Owner" />
                                    <div class="input-group-addon custom-add-addon">
                                        <a href="javascript:void(0)" class="btn custom-add-icon addMore"><span><i
                                                class="fa fa-plus" aria-hidden="true"></i></span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group fieldGroupCopy" style="display: none;">
                                <label for="ActionOwnerInput">Action Owner:</label>
                                <div class="input-group">
                                    <input type="text" name="action-owner" id="ActionOwnerInput"
                                           class="form-control" placeholder="Owner" />
                                    <div class="input-group-addon custom-remove-addon">
                                        <a href="javascript:void(0)" class="btn custom-remove-icon remove"><span><i
                                                class="fa fa-minus" aria-hidden="true"></i></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="group-of-action-date">
                            <div class="form-group ActionfieldGroup">
                                <label for="ActionDateInput">Action Date:</label>
                                <div class="input-group">
                                    <input type="text" name="action-date" id="ActionDateInput"
                                           class="form-control datepicker" placeholder="Date" />
                                    <div class="input-group-addon custom-add-addon">
                                        <a href="javascript:void(0)"
                                           class="btn custom-add-icon addMoreAction"><span><i class="fa fa-plus"
                                                                                              aria-hidden="true"></i></span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group ActionfieldGroupCopy" style="display: none;">
                                <label for="ActionDateInput">Action Date:</label>
                                <div class="input-group">
                                    <input type="text" name="action-date" id="ActionDateInput"
                                           class="form-control datepicker" placeholder="Date" />
                                    <div class="input-group-addon custom-remove-addon">
                                        <a href="javascript:void(0)"
                                           class="btn custom-remove-icon removeAction"><span><i class="fa fa-minus"
                                                                                                aria-hidden="true"></i></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="PriorityInput">Priority:</label>
                            <input type="Text" class="form-control" id="PriorityInput" placeholder="Priority">
                        </div>

                    </form>
                    <div class="choose-category">
                        <div class="row">
                            <div class="col-12">
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" id="customRadioInline1" name="customRadioInline"
                                           class="custom-control-input">
                                    <label class="custom-control-label" for="customRadioInline1">public</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" id="customRadioInline2" name="customRadioInline"
                                           class="custom-control-input">
                                    <label class="custom-control-label"
                                           for="customRadioInline2">inter-company</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" id="customRadioInline3" name="customRadioInline"
                                           class="custom-control-input">
                                    <label class="custom-control-label" for="customRadioInline3">private</label>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
</main>
</body>

</html>