<!DOCTYPE html>
<html lang="en">

<head>
    <title>Action Tracker :: Update Project</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
</head>

<body>

<section class="update-project-section-banner"></section>

<main class="main-container">
    <section class="project-section-wrapper mt-negative">
        <div class="container">
            <div class="col-md-8 offset-md-2 project-details-inner card">
                <div class="header">
                    <h3 class="header-title">Update Project Header..</h3>
                </div>
                <div class="project-group">
                    <form>
                        <div class="form-group">
                            <label for="NameInput">Project Name:</label>
                            <input type="Text" class="form-control" id="NameInput" placeholder="Nothernlight">

                        </div>
                        <div class="form-group">
                            <label for="descriptionTextarea">Peoject Description:</label>
                            <textarea class="form-control" id="descriptionTextarea" placeholder="Outsourching project with AkzoNobel" rows="5"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="NameInput">Department:</label>
                            <input type="Text" class="form-control" id="NameInput" placeholder="Europe Sale">
                        </div>
                        <div class="form-group fieldGroup">
                            <label for="categoryInput">Category:</label>
                            <div class="input-group">
                                <input type="text" name="category" id="categoryInput" class="form-control"
                                       placeholder="Category" />
                                <div class="input-group-addon custom-add-addon">
                                    <a href="javascript:void(0)" class="btn custom-add-icon addMore"><span><i
                                            class="fa fa-plus" aria-hidden="true"></i></span></a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group fieldGroupCopy" style="display: none;">
                            <label for="categoryInput">Category:</label>
                            <div class="input-group">
                                <input type="text" name="category" id="categoryInput" class="form-control"
                                       placeholder="Category" />
                                <div class="input-group-addon custom-remove-addon">
                                    <a href="javascript:void(0)" class="btn custom-remove-icon remove"><span><i
                                            class="fa fa-minus" aria-hidden="true"></i></span></a>
                                </div>
                            </div>
                        </div>

                    </form>
                    <div class="add-category">
                        <button class="btn btn-primary add-category">Add Category..</button>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn btn-warning custom-warning-btn text-white float-right">Finished</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
</body>

</html>