<!DOCTYPE html>
<html lang="en">

<head>
    <title>Action Tracker :: Projects</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
</head>

<body>

<main class="main-container bg-white">
    <section class="bredcrumber-wrapper">
        <div class="container">

            <div class="row">
                <div class="col-6">
                    <a href="dashboard.html" class="custom-btn">&#8249; Dashboard</a>
                </div>
                <div class="col-6">
                    <div class="edit-cart float-right">
                        <label data-toggle="collapse" data-target="#ViewMeuList">
                            <a type="button" class="custom-btn">Edit</a>
                        </label>
                        <div class="edit-items-list collapse" id="ViewMeuList">
                            <div class="custom-edit-card card">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-calendar text-danger"
                                            aria-hidden="true"></i></span>Dates And Milestons</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-list-ul text-secondary"
                                            aria-hidden="true"></i></span>Add Category</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-file-excel-o text-success"
                                            aria-hidden="true"></i></span>Export to excel</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-tag text-secondary"
                                            aria-hidden="true"></i></span>Modify tags</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-file-text-o text-info"
                                            aria-hidden="true"></i></span>Modify Project Header</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-clock-o text-secondary"
                                            aria-hidden="true"></i></span>Schudule Metting</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-users text-warning"
                                            aria-hidden="true"></i></span>Invite Team Member</a></li>
                                    <li class="list-group-item"><a href="#"><span class="icon-space"><i
                                            class="fa fa-cog text-primary"
                                            aria-hidden="true"></i></span>Profile Setting</a></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="title-content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="content-section">
                        <div class="content-title">
                            <h3 class="content-header">Nothernlight</h3>
                            <p>Outsourching project for Akzonobel</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="contentent-filter">
                        <h3 class="filter-header">Filter By..</h3>
                        <div class="filter-item-group">

                            <div class="filter-item">
                                <h4 class="filter-item-number bg-dark">1</h4>
                                <p>All</p>
                            </div>
                            <div class="filter-item">
                                <h4 class="filter-item-number bg-primary">2</h4>
                                <p>Open</p>
                            </div>
                            <div class="filter-item">
                                <h4 class="filter-item-number bg-danger">3</h4>
                                <p>At Risk</p>
                            </div>
                            <div class="filter-item">
                                <h4 class="filter-item-number bg-success">4</h4>
                                <p>Closed</p>
                            </div>
                            <div class="filter-item">
                                <h4 class="filter-item-number bg-warning">5</h4>
                                <p>Delayed</p>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="row-section-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12 row-block">
                    <div id="accordion" class="accordion">
                        <div class="mb-0">
                            <div class="custom-card-icon mb-2 collapsed" data-toggle="collapse" href="#collapseOne">
                                <a class="filter-header text-secondary"> News </a>
                            </div>
                            <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                <div class="content-news">
                                    <ul>
                                        <li>
                                            <div class="media">
                                                <div class="media-left align-self-center">
                                                    <img class="rounded-circle"
                                                         src="https://randomuser.me/api/portraits/women/50.jpg">
                                                </div>
                                                <div class="media-body">
                                                    <h4>khaled khondaker</h4>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem
                                                        ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum
                                                        dolor sit amet, consectetur
                                                        adipiscing eliLorem ipsum dolor sit amet, consectetur
                                                        adipiscing.</p>

                                                </div>
                                                <div class="media-right align-self-center text-right">
                                                    <button href="#"
                                                            class="schudule-item btn btn-primary">Closed</button>
                                                    <button href="#" class="schudule-item btn btn1">Today</button>
                                                </div>

                                            </div>
                                        </li>
                                        <li>
                                            <div class="media">
                                                <div class="media-left align-self-center">
                                                    <img class="rounded-circle"
                                                         src="https://randomuser.me/api/portraits/women/50.jpg">
                                                </div>
                                                <div class="media-body">
                                                    <h4>khaled khondaker</h4>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem
                                                        ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum
                                                        dolor sit amet, consectetur
                                                        adipiscing eliLorem ipsum dolor sit amet, consectetur
                                                        adipiscing elitLorem ipsum dolor
                                                        sit amet, consectetur adipiscing elitLorem ipsum dolor sit
                                                        amet, consectetur adipiscing
                                                        eliLorem ipsum dolor sit amet, consectetur adipiscing
                                                        elitLorem ipsum dolor sit amet,
                                                        consectetur adipiscing elitLorem ipsum dolor sit amet,
                                                        consectetur adipiscing elit..</p>

                                                </div>
                                                <div class="media-right align-self-center text-right">
                                                    <button href="#"
                                                            class="schudule-item btn btn-primary">Risk</button>
                                                    <button href="#" class="schudule-item btn btn1">Open</button>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="media">
                                                <div class="media-left align-self-center">
                                                    <img class="rounded-circle"
                                                         src="https://randomuser.me/api/portraits/women/50.jpg">
                                                </div>
                                                <div class="media-body">
                                                    <h4>khaled khondaker</h4>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem
                                                        ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum
                                                        dolor sit amet, consectetur
                                                        adipiscing eliLorem ipsum dolor sit amet, consectetur
                                                        adipiscing elitLorem ipsum dolor
                                                        sit amet, consectetur adipiscing elitLorem ipsum dolor sit
                                                        amet, consectetur adipiscing
                                                        eliLorem ipsum dolor sit amet, consectetur adipiscing
                                                        elitLorem ipsum dolor sit amet,
                                                        consectetur adipiscing elitLorem ipsum dolor sit amet,
                                                        consectetur adipiscing elit..</p>

                                                </div>
                                                <div class="media-right align-self-center text-right">
                                                    <button href="#"
                                                            class="schudule-item btn btn-primary">Open</button>
                                                    <button href="#"
                                                            class="schudule-item btn btn1">Yesterday</button>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="row-section-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12 row-block">
                    <div class="header-content">
                        <ul class="filter-category">
                            <li class="filter-header">Action</li>
                            <li class="filter-category-list btn1"><a href="#" class="text-white">by owner</a></li>
                            <li class="filter-category-list btn2"><a href="#" class="text-white">by due date</a>
                            </li>
                            <li class="filter-category-list btn3"><a href="#" class="text-white">by category</a>
                            </li>
                        </ul>
                    </div>
                    <div class="content-news">
                        <ul>
                            <li>
                                <div class="media">
                                    <div class="media-left align-self-center">
                                        <img class="rounded-circle"
                                             src="https://randomuser.me/api/portraits/women/50.jpg">
                                    </div>
                                    <div class="media-body">
                                        <h4>khaled khondaker</h4>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor
                                            sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet,
                                            consectetur
                                            adipiscing eliLorem ipsum dolor sit amet..</p>

                                    </div>
                                    <div class="media-right align-self-center text-right">
                                        <button href="#" class="schudule-item btn btn-primary">Closed</button>
                                        <button href="#" class="schudule-item btn btn1">Today</button>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="media">
                                    <div class="media-left align-self-center">
                                        <img class="rounded-circle"
                                             src="https://randomuser.me/api/portraits/women/50.jpg">
                                    </div>
                                    <div class="media-body">
                                        <h4>khaled khondaker</h4>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor
                                            sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet,
                                            consectetur
                                            adipiscing eliLorem ipsum dolor sit amet, consectetur adipiscing
                                            elitLorem ipsum dolor
                                            sit amet, consectetur adipiscing elitLorem .</p>

                                    </div>
                                    <div class="media-right align-self-center text-right">
                                        <button href="#" class="schudule-item btn btn-primary">Risk</button>
                                        <button href="#" class="schudule-item btn btn1">Today</button>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="media">
                                    <div class="media-left align-self-center">
                                        <img class="rounded-circle"
                                             src="https://randomuser.me/api/portraits/women/50.jpg">
                                    </div>
                                    <div class="media-body">
                                        <h4>khaled khondaker</h4>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor
                                            sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet,
                                            consectetur
                                            adipiscing eliLorem ipsum dolor sit amet..</p>

                                    </div>
                                    <div class="media-right align-self-center text-right">
                                        <button href="#" class="schudule-item btn btn-primary">Open</button>
                                        <button href="#" class="schudule-item btn btn1">Yesterday</button>
                                    </div>
                                </div>
                            </li>


                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

</main>
<jsp:include page="../footer.jsp"/>
</body>

</html>