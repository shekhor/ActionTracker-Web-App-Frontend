(function ($) {
    "use strict";
    $(document).ready(function () {
        //group add limit
        var maxGroup = 10;
        //add more fields group
        $(".addMore").click(function () {
            if ($('body').find('.fieldGroup').length < maxGroup) {
                var fieldHTML = '<div class="form-group fieldGroup">' + $(".fieldGroupCopy").html() + '</div>';
                $('body').find('.fieldGroup:last').before(fieldHTML);
            } else {
                alert('Maximum ' + maxGroup + ' groups are allowed.');
            }
        });

        //remove fields group
        $("body").on("click", ".remove", function () {
            $(this).parents(".fieldGroup").remove();
        });

        //add more action fields group
        $(".addMoreAction").click(function () {
            if ($('body').find('.ActionfieldGroup').length < maxGroup) {
                var fieldHTML = '<div class="form-group ActionfieldGroup">' + $(".ActionfieldGroupCopy").html() + '</div>';
                $('body').find('.ActionfieldGroup:last').before(fieldHTML);
            } else {
                alert('Maximum ' + maxGroup + ' groups are allowed.');
            }
        });

        //remove fields group
        $("body").on("click", ".removeAction", function () {
            $(this).parents(".ActionfieldGroup").remove();
        });

        //chat
        $(document).ready(function () {
            $('#action_menu_btn').click(function () {
                $('.action_menu').toggle();
            });
        });



        //add more action fields group
        $(".addMore_new_project_department").click(function () {
            if ($('body').find('.new_project_fieldGroup').length < maxGroup) {
                var fieldHTML = '<div class="form-group new_project_fieldGroup">' + $(".new_project_field_group_copy").html() + '</div>';
                $('body').find('.new_project_fieldGroup:last').before(fieldHTML);
            } else {
                alert('Maximum ' + maxGroup + ' groups are allowed.');
            }
        });

        //remove fields group
        $("body").on("click", ".remove-new-deparment", function () {
            $(this).parents(".new_project_fieldGroup").remove();
        });

        //add more category-tag fields group
        $(".addMore_new_tag_category").click(function () {
            if ($('body').find('.new_category_fieldGroup').length < maxGroup) {
                var fieldHTML = '<div class="form-group new_category_fieldGroup">' + $(".new_category_field_group_copy").html() + '</div>';
                $('body').find('.new_category_fieldGroup:last').before(fieldHTML);
            } else {
                alert('Maximum ' + maxGroup + ' groups are allowed.');
            }
        });
        //remove fields group
        $("body").on("click", ".remove-new-tagCategoryInput", function () {
            $(this).parents(".new_category_fieldGroup").remove();
        });



        //add owner fields group
        $(".add_more_owner").click(function () {
            if ($('body').find('.owner_field_group').length < maxGroup) {
                var fieldHTML = '<div class="form-group owner_field_group">' + $(".owner_field_group_copy").html() + '</div>';
                $('body').find('.owner_field_group:last').before(fieldHTML);
            } else {
                alert('Maximum ' + maxGroup + ' groups are allowed.');
            }
        });

        //remove fields group
        $("body").on("click", ".remove-owner", function () {
            $(this).parents(".owner_field_group").remove();
        });

        //add owner fields group
        $(".add_more_manager").click(function () {
            if ($('body').find('.manager_field_group').length < maxGroup) {
                var fieldHTML = '<div class="form-group manager_field_group">' + $(".manager_field_group_copy").html() + '</div>';
                $('body').find('.manager_field_group:last').before(fieldHTML);
            } else {
                alert('Maximum ' + maxGroup + ' groups are allowed.');
            }
        });

        //remove fields group
        $("body").on("click", ".remove-manager", function () {
            $(this).parents(".manager_field_group").remove();
        });


        //image upload
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
                    $('#imagePreview').hide();
                    $('#imagePreview').fadeIn(650);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
        $("#imageUpload").change(function () {
            readURL(this);
        });


        //div show checkbox switch 
        $(document).ready(function () {
            $('.show-content').hide();
            $('.user-defined-check').click(function (e) {
                $('.show-content').toggle(1000);
            })
        });

        //div show checkbox switch 
        $(document).ready(function () {
            $('.show-risk-content').hide();
            $('.user-defined-risk-check').click(function (e) {
                $('.show-risk-content').toggle(1000);
            })
        });

        //tooltip
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })

        //open close risk action
        $(".open").on("click", function () {
            $(".popup-overlay, .popup-content").addClass("active");
        });

        //removes the "active" class to .popup and .popup-content when the "Close" button is clicked 
        $(".close-popup, .popup-overlay").on("click", function () {
            $(".popup-overlay, .popup-content").removeClass("active");
        });


        $('.datepicker').datepicker({
            format: 'MM dd ,yyyy',

        });

        $(document).ready(function () {
            $('select').niceSelect();
        });


        $(".open-chat-menu").on("click", function () {
            $(".chat-popup-menu, .chat-popup-content").addClass("active");
        });

        //removes the "active" class to .popup and .popup-content when the "Close" button is clicked 
        $(".close-chat-menu, .popup-overlay").on("click", function () {
            $(".chat-popup-menu, .chat-popup-content").removeClass("active");
        });
        $('.count').each(function () {
            $(this).prop('Counter',0).animate({
                Counter: $(this).text()
            }, {
                duration: 4000,
                easing: 'swing',
                step: function (now) {
                    $(this).text(Math.ceil(now));
                }
            });
        });

        //Stop carousel
        /*
        $('.carousel').carousel({
            interval: false,
            wrap: false

        });*/


    });
})
(jQuery);