<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Action Tracker :: Dates & Milestone</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
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

                <form action="">
                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" placeholder="contract signature">
                        <span class="input-group-addon"></span>
                        <input class="icon datepicker form-control form-spacing"
                               data-date-format="mm/dd/yyyy" />

                    </div>
                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" placeholder="contract signature">
                        <span class="input-group-addon"></span>
                        <input class="icon datepicker form-control form-spacing"
                               data-date-format="mm/dd/yyyy" />

                    </div>
                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" placeholder="contract signature">
                        <span class="input-group-addon"></span>
                        <input class="icon datepicker form-control form-spacing"
                               data-date-format="mm/dd/yyyy" />

                    </div>

                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" placeholder="contract signature">
                        <span class="input-group-addon"></span>
                        <input class="icon datepicker form-control form-spacing"
                               data-date-format="mm/dd/yyyy" />

                    </div>

                    <div class="input-group custom-input-group">
                        <input type="text" class="form-control form-spacing" placeholder="contract signature">
                        <span class="input-group-addon"></span>
                        <input class="icon datepicker form-control form-spacing"
                               data-date-format="mm/dd/yyyy" />

                    </div>
                </form>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="float-left">
                            <button class="btn btn-primary text-white">Add Date..</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
</body>

</html>