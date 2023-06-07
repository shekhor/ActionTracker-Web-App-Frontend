<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Action Tracker</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
    <script src="${contextPath}/resources/asset/js/bootstrap-swipe-carousel.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700&display=swap" rel="stylesheet">

    <script type="text/javascript">
        $(function (){
            $('.my-carousel').carousel().swipeCarousel({
                // low, medium or high 
                sensitivity: 'high'
            });
        });

    </script>
</head>

<body>

<section class="project-create-section-banner">

</section>
<main class="main-container">
    <section class="col-md-8 offset-md-2 project-create-section-wrapper card mt-negative">
        <div id="carouselExampleIndicators" class="carousel slide my-carousel" data-ride="carousel" data-interval="false">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
            </ol>
            <form action="">
                <div class="carousel-inner">
                    <!- ------------- Steps One ------------- -->
                    <div class="carousel-item active">
                        <div class="container">
                            <div class="header">
                                <h3 class="header-title">Create New Project..</h3>
                            </div>
                            <div class="update-project-group">
                                <form>
                                    <div class="form-group">
                                        <label for="projectNameId">Project Name:</label>
                                        <input type="Text" class="form-control" id="projectNameId" name="projectName" placeholder="Nothernlight">

                                    </div>
                                    <div class="form-group">
                                        <label for="projectDescriptionId">Project Description:</label>
                                        <textarea class="form-control" id="projectDescriptionId" rows="5" name="projectDescription"></textarea>
                                    </div>

                                    <div class="form-group new_project_fieldGroup">
                                        <label for="departmentId">Department:</label>
                                        <div class="input-group">
                                            <input type="text" name="projectDepartment" id="departmentId" class="form-control" placeholder="Department"/>
                                        </div>
                                    </div>
                                    <div class="form-group new_project_field_group_copy" style="display: none;">
                                        <label for="categoryInput">Department:</label>
                                        <div class="input-group">
                                            <input type="text" name="department" id="categoryInput"
                                                   class="form-control" placeholder="Department"/>
                                            <div class="input-group-addon custom-remove-addon">
                                                <a href="javascript:void(0)"
                                                   class="btn custom-remove-icon remove-new-deparment"><span><i
                                                        class="fa fa-minus"
                                                        aria-hidden="true"></i></span></a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!- ------------- Steps two ------------- -->
                    <div class="carousel-item">
                        <div class="container">
                            <div class="header">
                                <h3 class="header-title">User Defined..</h3>
                                <p>Category define option..</p>
                            </div>
                            <div class="update-project-group">
                                <form>

                                    <div class="form-group new_category_fieldGroup">
                                        <label for="project-category-id">Category:</label>
                                        <div class="input-group">
                                            <input type="text" name="projectCategory" id="project-category-id"
                                                   class="form-control" name="projectCategory" placeholder="Category"/>
                                            <div class="input-group-addon custom-add-addon">
                                                <a href="javascript:void(0)"
                                                   class="btn custom-add-icon addMore_new_tag_category"><span><i
                                                        class="fa fa-plus"
                                                        aria-hidden="true"></i></span></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group new_category_field_group_copy" style="display: none;">
                                        <label for="tagCategoryInput">Category:</label>
                                        <div class="input-group">
                                            <input type="text" name="tagCategoryInput" id="tagCategoryInput"
                                                   class="form-control" placeholder="Category"/>
                                            <div class="input-group-addon custom-remove-addon">
                                                <a href="javascript:void(0)"
                                                   class="btn custom-remove-icon remove-new-tagCategoryInput"><span><i
                                                        class="fa fa-minus"
                                                        aria-hidden="true"></i></span></a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!- ------------- Steps three ------------- -->
                    <div class="carousel-item">
                        <div class="container">

                            <div class="header">
                                <h3 class="header-title">Create New Project..</h3>
                                <p>Define status option..</p>
                            </div>
                            <div class="tags-list-group">
                                <div class="tags-group-card">
                                    <!-- Default panel contents -->
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item custom-list-group-item">
                                            OPEN
                                            <label class="switch">
                                                <input type="checkbox" class="success" value="OPEN">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Closed
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Delayed
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            At Risk
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Not Ready
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Draft Ready
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Completed
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Canceled
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            User Defined
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider user-defined-check round"></span>
                                            </label>
                                        </li>
                                    </ul>
                                </div>
                                <div class="list-group-item show-content">
                                    <div class="form-group">
                                        <label>Define Status</label>
                                        <input type="text" name="userDefinedStatus[0]" class="form-control" placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Status</label>
                                        <input type="text" name="userDefinedStatus[1]" class="form-control" placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Status</label>
                                        <input type="text" name="userDefinedStatus[2]" class="form-control" placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Status</label>
                                        <input type="text" name="userDefinedStatus[3]" class="form-control" placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Status</label>
                                        <input type="text" name="userDefinedStatus[4]" class="form-control" placeholder="Enter status">

                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>

                    <!- ------------- Steps four ------------- -->
                    <div class="carousel-item">
                        <div class="container">

                            <div class="header">
                                <h3 class="header-title">Create New Project..</h3>
                                <p>Define Risk option..</p>
                            </div>
                            <div class="tags-list-group">
                                <div class="tags-group-card">
                                    <!-- Default panel contents -->
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item custom-list-group-item">
                                            Description
                                            <label class="switch">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Owner
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Cause
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Effect
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Probability
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Impact
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Level
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Mitigation
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            Cost
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span
                                                        class="slider round"></span>
                                            </label>
                                        </li>
                                        <li class="list-group-item custom-list-group-item">
                                            User Define
                                            <label class="switch ">
                                                <input type="checkbox" class="success">
                                                <span
                                                        class="slider user-defined-risk-check round"></span>
                                            </label>
                                        </li>
                                    </ul>
                                </div>
                                <div class="list-group-item show-risk-content">
                                    <div class="form-group">
                                        <label>Define Risk</label>
                                        <input type="text" class="form-control"
                                               placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Risk</label>
                                        <input type="text" class="form-control"
                                               placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Risk</label>
                                        <input type="text" class="form-control"
                                               placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Risk</label>
                                        <input type="text" class="form-control"
                                               placeholder="Enter status">

                                    </div>
                                    <div class="form-group">
                                        <label>Define Risk</label>
                                        <input type="text" class="form-control"
                                               placeholder="Enter status">

                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>

                    <!- ------------- Steps five ------------- -->
                    <div class="carousel-item">
                        <div class="container">
                            <div class="group-details-add-modify-member">
                                <div class="header">
                                    <h3 class="header-title">Create New Project</h3>
                                    <p>Add-Modify Team Members..</p>
                                </div>
                                <div class="new-project-owner">
                                    <h6 class="owner-header">Project owner:</h6>
                                    <div class="form-group owner_field_group">
                                        <div class="input-group">
                                            <input type="text" name="Name"
                                                   class="form-control custom-form-control"
                                                   placeholder="Name"/>
<%--                                            <div class="input-group-addon custom-input-group-add-addon">--%>
<%--                                                <a href="javascript:void(0)" class="btn custom-add-icon add_more_owner">--%>
<%--                                                    <span>--%>
<%--                                                        <i class="fa fa-plus" aria-hidden="true"></i>--%>
<%--                                                    </span>--%>
<%--                                                </a>--%>
<%--                                            </div>--%>
                                        </div>
                                    </div>

                                    <!-- copy of input fields group -->

                                    <div class="form-group owner_field_group_copy"
                                         style="display: none;">
                                        <div class="input-group">
                                            <input type="text" name="Name"
                                                   class="form-control custom-form-control"
                                                   placeholder="Name"/>
                                            <div
                                                    class="input-group-addon custom-input-group-remove-addon">
                                                <a href="javascript:void(0)"
                                                   class="btn custom-remove-icon remove-owner"><span><i
                                                        class="fa fa-minus"
                                                        aria-hidden="true"></i></span></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="new-project-manager">
                                    <h6 class="manager-header">Project Manager:</h6>
                                    <div class="form-group manager_field_group">
                                        <div class="input-group">
                                            <input type="text" name="Name"
                                                   class="form-control custom-form-control"
                                                   placeholder="Name"/>
<%--                                            <div class="input-group-addon custom-input-group-add-addon">--%>
<%--                                                <a href="javascript:void(0)" class="btn custom-add-icon add_more_manager">--%>
<%--                                                    <span>--%>
<%--                                                        <i class="fa fa-plus" aria-hidden="true"></i>--%>
<%--                                                    </span>--%>
<%--                                                </a>--%>
<%--                                            </div>--%>
                                        </div>
                                    </div>

                                    <!-- copy of input fields group -->

                                    <div class="form-group manager_field_group_copy"
                                         style="display: none;">
                                        <div class="input-group">

                                            <input type="text" name="Name"
                                                   class="form-control custom-form-control"
                                                   placeholder="Name"/>
                                            <div
                                                    class="input-group-addon custom-input-group-remove-addon">
                                                <a href="javascript:void(0)"
                                                   class="btn custom-remove-icon remove-manager"><span><i
                                                        class="fa fa-minus"
                                                        aria-hidden="true"></i></span></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="team-member-list">
                                    <h6 class="team-header">Team Members:</h6>
                                    <form method="post">
                                        <div class="form-group fieldGroup">
                                            <div class="input-group">
                                                <input type="text" name="Role"
                                                       class="form-control custom-form-control"
                                                       placeholder="Role"/>
                                                <input type="text" name="Name"
                                                       class="form-control custom-form-control"
                                                       placeholder="Name"/>
                                                <div
                                                        class="input-group-addon custom-input-group-add-addon">
                                                    <a href="javascript:void(0)"
                                                       class="btn custom-add-icon addMore"><span><i
                                                            class="fa fa-plus"
                                                            aria-hidden="true"></i></span></a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                    <!-- copy of input fields group -->

                                    <div class="form-group fieldGroupCopy" style="display: none;">
                                        <div class="input-group">
                                            <input type="text" name="Role"
                                                   class="form-control custom-form-control"
                                                   placeholder="Role"/>
                                            <input type="text" name="Name"
                                                   class="form-control custom-form-control"
                                                   placeholder="Name"/>
                                            <div
                                                    class="input-group-addon custom-input-group-remove-addon">
                                                <a href="javascript:void(0)"
                                                   class="btn custom-remove-icon remove"><span><i
                                                        class="fa fa-minus"
                                                        aria-hidden="true"></i></span></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="add-member">
                                    <button class="btn btn-primary add-member">Add
                                        member..
                                    </button>
                                </div>
                                <button
                                        class="btn btn-warning custom-warning-btn text-white float-right">Finish
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>

            </form>
        </div>
    </section>
</main>
<jsp:include page="../footer.jsp"/>
</body>

</html>