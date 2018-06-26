/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var listCustomers = [];
    var formCustomer = {};
    var custList = {};
    var round = 1;
    if (localStorage.times > 00 || localStorage.timem > 0) {

        document.getElementById('timer').innerHTML = localStorage.timem + ":" + localStorage.times;
         //setTimeout(startTimer, 10000);
         window.setTimeout(function(){
                 startTimer();    
                  }, 10000);

    }
    if (localStorage.auto < 10)
    {
        ajaxPost();

    }




    function startTimer() {
        //$('#play').hide();


        var presentTime = document.getElementById('timer').innerHTML;
        var timeArray = presentTime.split(/[:]+/);
        var m = timeArray[0];
        var s = checkSecond((timeArray[1] - 1));
        if (s == 59) {
            m = m - 1
        }
        if (m < 0) {
            isplay = 'stop';
           // alert('timer completed');
            $('#play').hide();
            $('#play2').hide();
            //window.location.href="home"
            localStorage.setItem("auto", round);
            //ajaxPostAutomate();
            ajaxPost();

            round = round + 1;


        }


        if (m > -1) {

            document.getElementById('timer').innerHTML =
                    m + ":" + s;
            localStorage.setItem("timem", m);
            localStorage.setItem("times", s);
            setTimeout(startTimer, 1000);
            
        }
    }

    function checkSecond(sec) {
        if (sec < 10 && sec >= 0) {
            sec = "0" + sec
        }
        ; // add zero in front of numbers < 10
        if (sec < 0) {
            sec = "59"
        }
        ;
        return sec;
    }




    /**
     * Using JQuery for hiding some elements in view when bootstrap app
     */
    // Hide customer table when starting
    // we just show it if having any adding-customer
    $('#customerTable').hide();
    $('#postCustomersBtn').hide();

    // Customer-Form submit
    $("#customerForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

        // get data from submit form
        var formCustomer = {
            name: $("#name").val(),
            age: $("#age").val()

        }


        // store customer
        /*	listCustomers.push(formCustomer);
         
         // re-render customer table by append new customer to table
         
         var customerRow = '<tr>' +
         '<td>' + listCustomers.length + '</td>' +
         '<td>' + formCustomer.name.toUpperCase() + '</td>' +
         '<td>' + formCustomer.age + '</td>' +
         '<td>' + formCustomer.address.street + '</td>' +
         '<td>' + formCustomer.address.postcode + '</td>' +
         '<td class="text-center">' +
         '<input type="hidden" value=' + (listCustomers.length - 1) + '>' +
         '<a>' +
         '<span class="glyphicon glyphicon-remove"></span>' +
         '</a>' +
         '</td>' +
         '</tr>';
         
         $('#customerTable tbody').append(customerRow);
         
         // just how customer table and POST button
         $('#customerTable').show();
         $('#postCustomersBtn').show();
         
         // Reset FormData after Posting
         resetData();*/
    });

    $('#abcd').click(function () {

        console.log("fired");
        ajaxGet();
    });


    $('#abc').click(function () {
        // Submit List of Customer to Back-End server
        console.log("fired");
        formCustomer = {
            name: $("#name").val(),
            age: $("#age").val()

        }
        ajaxPost();
    });

    function ajaxPost() {
        //console.log("fired");
        // DO POST 
        $.ajax({
            type: "POST",
            contentType: "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/makeRounderAuto",
            //data : JSON.stringify(formCustomer),
            //dataType: 'text',
            success: function (result) {
                // $('#sct_id').append('<option value="' + List[i].sectorId + '">' + List[i].sectorName + '</option>');
                $('#contentx').append('<p>' + result.trim()
                        + '</p><script type="text/javascript">' + sleep(500) + '</script>');
                ajaxPostAutomate();
            },
            error: function (e) {
                alert("Processing........")
                console.log("ERROR: ", e);
            }
        });
    }

    function resetData() {
        $("#name").val("");
        $("#age").val("");

    }

    ///get method
    function ajaxGet() {
        $.ajax({
            type: "POST",
            url: "/SpringHibernateExample/get",
            success: function (result) {
                //$('#resultGetAllCustomerDiv ul').empty();
                /*     Console.log(result);
                 custList = "";
                 $.each(result, function(i, customer){
                 var customer = "{name: " + customer.name + 
                 ", age: " + customer.age +
                 "}";
                 
                 });*/
                console.log(result);
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

    ///test get

    function ajaxPostAutomate() {
        //console.log("fired");
        // DO POST 

        $.ajax({
            type: "POST",
            url: "/SpringHibernateExample/roundertest",
            success: function (data) {
                var result = $.trim(data);
                // clear customer body
                //$('#customerTable tbody').empty();
                //$('#customerTable').hide();

                // re-set customer table list
                /* console.log(data);
                 alert("available");
                 
                 document.getElementById('timer').innerHTML = 01 + ":" + 00; 
                 startTimer();*/
                if (result === "Go") {
                    document.getElementById('timer').innerHTML = 01 + ":" + 00;
                   // setTimeout(startTimer, 10000);
                    window.setTimeout(function(){
                 startTimer();    
                  }, 10000);
                   // alert("available");
                } else
                {

                    alert("Game End!");
                    ajaxGetREsult();
                }
                // fill successfully message on view

            },
            error: function (e) {
                alert("Wait For Game Server!")
                console.log("ERROR: ", e);
            }
        });
    }
    $('#signoff').click(function () {
        localStorage.clear();
    })

    function ajaxGetREsult() {
        //console.log("fired");
        // DO POST 
        $.ajax({
            type: "POST",
            url: "/SpringHibernateExample/result",
            success: function (data) {
                //var result = $.trim(data);
                // clear customer body
                //$('#customerTable tbody').empty();
                //$('#customerTable').hide();

                // re-set customer table list
                /* console.log(data);
                 alert("available");
                 
                 document.getElementById('timer').innerHTML = 01 + ":" + 00; 
                 startTimer();*/
                if (result === "win") {
                    window.location.href = "win";
                    alert("You Win....Visit Bank For Money Transfer Details.. Visit Analyzer for More Details...");
                } else
                {
                    window.location.href = "loss";
                    alert("You Loss !!! Try Again");
                }
                // fill successfully message on view

            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


})

