<!DOCTYPE html><%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Action Tracker :: Dashboard</title>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../blockAndAlert.jsp"/>
</head>
<body>
<main class="main-container bg-white">
    <section class="bredcrumber-wrapper ">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="float-left">
                        <a class="small" href="<c:url value="/logout" />">Logout</a>
                    </div>
                    <div class="edit-cart float-right" style="display: none">
                        <label data-toggle="collapse" data-target="#ViewMeuList">
                            <a type="button" class="custom-btn">Edit</a>
                        </label>
                        <div class="edit-items-list collapse" id="ViewMeuList">
                            <div class="custom-edit-card card">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <a href="${contextPath}/milestone/view">
													<span class="icon-space">
														<i class="fa fa-calendar text-danger" aria-hidden="true"></i>
													</span>Dates And Milestons

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">
													<span class="icon-space">
														<i class="fa fa-list-ul text-secondary" aria-hidden="true"></i>
													</span>Add Category

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">
													<span class="icon-space">
														<i class="fa fa-file-excel-o text-success" aria-hidden="true"></i>
													</span>Export to excel

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="Tags.html">
													<span class="icon-space">
														<i class="fa fa-tag text-secondary" aria-hidden="true"></i>
													</span>Modify tags

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="update-project.html">
													<span class="icon-space">
														<i class="fa fa-file-text-o text-info" aria-hidden="true"></i>
													</span>Modify Project Header

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">
													<span class="icon-space">
														<i class="fa fa-clock-o text-secondary" aria-hidden="true"></i>
													</span>Schudule Metting

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="Team-member.html">
													<span class="icon-space">
														<i class="fa fa-users text-warning" aria-hidden="true"></i>
													</span>Invite Team Member

                                        </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">
													<span class="icon-space">
														<i class="fa fa-cog text-primary" aria-hidden="true"></i>
													</span>Profile Setting

                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="search-box-section-wrapper">
        <div class="container">
            <div class="row justify-content-end">
                <div class="col-12 col-md-10 col-lg-8">
                    <form class="search-card card-sm">
                        <div class="row no-gutters align-items-center">
                            <div class="col-auto search-icon">
                                <i class="fa fa-search" aria-hidden="true"></i>
                            </div>
                            <!--end of col-->
                            <div class="col">
                                <input class="form-control form-control-lg form-control-borderless" type="search" placeholder="Search">
                            </div>
                            <!--end of col-->
                            <div class="col-auto microphone-icon">
                                <i class="fa fa-microphone" aria-hidden="true"></i>
                            </div>
                            <!--end of col-->
                        </div>
                    </form>
                </div>
                <!--end of col-->
            </div>
        </div>
    </section>
    <section class="schudle-section-wrapper">
        <div class="container">
            <div class="counter_for_product">
                    <div class="leftbox mobile-device-card">
                        <div class="card-counter">
                            <i class="fa fa-calendar text-primary" aria-hidden="true"></i>
                            <span class="count-numbers">12</span>
                            <span class="count-name">Today</span>
                        </div>
                    </div>
                    <div class= "rightbox mobile-device-card">
                        <div class="card-counter">
                            <i class="fa fa-clock-o text-warning" aria-hidden="true"></i>
                            <span class="count-numbers">599</span>
                            <span class="count-name">Scheduled</span>
                        </div>
                    </div>
                    <div class= "full-grid-box mobile-device-card">
                        <div class="card-counter">
                            <i class="fa fa-hdd-o text-dark" aria-hidden="true"></i>
                            <span class="count-numbers">6875</span>
                            <span class="count-name">All</span>
                        </div>
                    </div>
            </div>
        </div>
    </section>
    <section class="project-section-wrapper">
        <div class="container">
            <div class="section-header">
                <h3>Project</h3>
            </div>
            <div class="card-box">
                <div class="card-body-custom">
                    <div class="list-group-item">
                        <div class="project-content-description">
                            <div class="row">
                                <div class="col-sm-8">
                                    <a href="${contextPath}/projects">
                                        <h6 class="card-title custom-card-title">NorthrnLight</h6>
                                    </a>
                                    <p class="card-text">Oursourchinf project for AkzoNobel.</p>
                                </div>
                                <div class="col-sm-4">
                                    <div class="battery">
                                        <div class="progress progress-lg">
                                            <div class="progress-bar" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100">1</div>
                                            <div class="progress-bar bg-success" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">4</div>
                                            <div class="progress-bar bg-danger" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">10</div>
                                            <div class="progress-bar bg-warning" role="progressbar" style="width: 35%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">30</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="project-content-description">
                            <div class="row">
                                <div class="col-sm-8">
                                    <a href="${contextPath}/projects">
                                        <h6 class="card-title custom-card-title">Somokey Bear</h6>
                                    </a>
                                    <p class="card-text">Oursourchinf project for AkzoNobel.</p>
                                </div>
                                <div class="col-sm-4">
                                    <div class="battery">
                                        <div class="progress progress-lg">
                                            <div class="progress-bar" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100">1</div>
                                            <div class="progress-bar bg-success" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">4</div>
                                            <div class="progress-bar bg-danger" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">10</div>
                                            <div class="progress-bar bg-warning" role="progressbar" style="width: 35%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">30</div>
                                        </div>
                                    </div>
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
            <div class="section-header">
                <h3>Action</h3>
            </div>
            <div class="row-block card">
                <div class="content-news">
                    <ul>
                        <li>
                            <div class="media">
                                <div class="media-left align-self-center">
                                    <img class="rounded-circle" src="https://randomuser.me/api/portraits/women/50.jpg">
                                </div>
                                <div class="media-body">
                                    <h4>khaled khondaker</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
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
                                    <img class="rounded-circle" src="https://randomuser.me/api/portraits/women/50.jpg">
                                </div>
                                <div class="media-body">
                                    <h4>khaled khondaker</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet..</p>
                                </div>
                                <div class="media-right align-self-center text-right">
                                    <button href="#"
                                            class="schudule-item btn btn-primary">Closed</button>
                                    <button href="#" class="schudule-item btn btn1">Today</button>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</main>
<jsp:include page="../footer.jsp"/>
</body>
</html>