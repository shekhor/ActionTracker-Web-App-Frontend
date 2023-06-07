<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Action Tracker: Team Members</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
</head>

<body>

<section class="team-section-banner"></section>

<main class="main-container">
    <section class="team-member-section-wrapper mt-negative">
        <div class="container">
            <div class="col-md-8 offset-md-2 group-details-add-modify-member card">
                <div class="header">
                    <h3 class="header-title">Nothernlight Project</h3>
                    <p>Add-Modify Team Members..</p>
                </div>
                <div class="project-manager-list ">
                    <div class="input-group custom-input-group fieldGroup">
                        <label class="project-user-header">Project Owner:</label>
                        <input type="text" name="Name" class="form-control custom-form-control"
                               placeholder="Name" />
                        <div class="input-group-addon custom-input-group-remove-addon">
                            <a href="javascript:void(0)" class="btn custom-remove-icon remove"><span><i
                                    class="fa fa-minus" aria-hidden="true"></i></span></a>
                        </div>
                    </div>
                    <div class="input-group custom-input-group fieldGroup">
                        <label class="project-user-header">Project Manager:</label>
                        <input type="text" name="Name" class="form-control custom-form-control"
                               placeholder="Name" />
                        <div class="input-group-addon custom-input-group-remove-addon">
                            <a href="javascript:void(0)" class="btn custom-remove-icon remove"><span><i
                                    class="fa fa-minus" aria-hidden="true"></i></span></a>
                        </div>
                    </div>
                </div>

                <div class="team-member-list">
                    <h6 class="team-header">Team Members:</h6>
                    <form method="post">
                        <div class="form-group fieldGroup">
                            <div class="input-group">
                                <input type="text" name="Role" class="form-control custom-form-control"
                                       placeholder="Role" />
                                <input type="text" name="Name" class="form-control custom-form-control"
                                       placeholder="Name" />
                                <div class="input-group-addon custom-input-group-add-addon">
                                    <a href="javascript:void(0)" class="btn custom-add-icon addMore"><span><i
                                            class="fa fa-plus" aria-hidden="true"></i></span></a>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div class="form-group fieldGroupCopy" style="display: none;">
                        <div class="input-group">
                            <input type="text" name="Role" class="form-control custom-form-control"
                                   placeholder="Role" />
                            <input type="text" name="Name" class="form-control custom-form-control"
                                   placeholder="Name" />
                            <div class="input-group-addon custom-input-group-remove-addon">
                                <a href="javascript:void(0)" class="btn custom-remove-icon remove"><span><i
                                        class="fa fa-minus" aria-hidden="true"></i></span></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="add-member">
                    <button class="btn btn-primary add-member">Add member..</button>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <button class="btn btn-warning custom-warning-btn text-white float-right">Finished</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
</body>

</html>