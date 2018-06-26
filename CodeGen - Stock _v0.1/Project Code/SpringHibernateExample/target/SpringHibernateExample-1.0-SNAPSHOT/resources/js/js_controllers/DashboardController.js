
$(document).ready(function () {
    var isplay = '';
    var playerAmount = 'stop';
    var machine = 'No';
    var path = '';

    if (localStorage.times > 00 || localStorage.timem > 0) {
        document.getElementById('timer').innerHTML = localStorage.timem + ":" + localStorage.times;
        isplay = 'play';
       //  setTimeout(startTimer, 10000);
        counter();
       

    }


    $('#joinGame').click(function () {

        console.log("fired");
        ajaxPost();
        //$('#SettingformBreaker').hide();
        //showHides();
        document.getElementById('timer').innerHTML = 01 + ":" + 00;

    });

      function counter() {
        //$('#play').hide();
       
       
        var presentTime = 02 + ":" + 00;
        var timeArray = presentTime.split(/[:]+/);
        var m = timeArray[0];
        var s = checkSecond((timeArray[1] - 1));
        if (s == 59) {
            m = m - 1
        }
        if (m < 0) {
            
            startTimer();  

        }


        if (m > -1) {

            setTimeout(startTimer, 1000);
        }
    }


    function startTimer() {
        //$('#play').hide();
       
        $('#play').show();
        $('#play2').show();
        isplay = 'play';
        var presentTime = document.getElementById('timer').innerHTML;
        var timeArray = presentTime.split(/[:]+/);
        var m = timeArray[0];
        var s = checkSecond((timeArray[1] - 1));
        if (s == 59) {
            m = m - 1
        }
        if (m < 0) {
            isplay = 'stop';
            alert('Round Complete!');
            window.location.href = "dashboard";
            //$('#play').hide();
            //$('#play2').hide();
            //window.location.href="home"
            ajaxPost();


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

    function ajaxGet() {
        $.ajax({
            type: "POST",
            accept: 'text/plain',
            url: "/SpringHibernateExample/makeRounder",
            dataType: 'text',

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
                //playerAmount=result;
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("Wait For Game Server");
            }
        });
    }

    function disable()
    {
        $('#start').prop('disabled', true);
        $('#radios-1').prop('disabled', true);
        $('#radios-0').prop('disabled', true);
    }


    $('#start').click(function () {
        if (isplay == 'play')
        {
            alert("Game Proceed! Can not start new one..");
        } else {
            console.log("game starts");
            if ($('#radios-0').prop("checked") || $('#radios-1').prop("checked")) {

                if ($('#radios-1').prop("checked"))
                {
                    //navigate to automatic user page
                    console.log("radio fired.......");
                    localStorage.setItem("auto", 0);
                    window.location.href = "machineplayer";
                    ajaxPost();
                    //path="machineplayer";
                    //start the process

                } else
                {
                    document.getElementById('timer').innerHTML = 01 + ":" + 00;
                    //ajaxPost();
                    ajaxPost();
                }
            }
            // window.location.href="machineplayer"; 
            else
            {
                alert("Please select player type!");
            }
        }
    });

    $('#play1').click(function () {

        if (isplay == 'play')
        {
            window.location.href = "buy";

        } else
        {
            alert("Wait till Timer starts!")
        }
    });

    $('#play2').click(function () {
        if (isplay == 'play')
        {
            window.location.href = "sell";
        } else
        {
            alert("Wait till Timer starts!")
        }
    });



    function ajaxPost() {
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
                     counter();
                    
                    //alert("available");
                } else
                {
                    ajaxGetREsult();
                    alert("Game End!!!");
                    localStorage.clear();
                }
                // fill successfully message on view

            },
            error: function (e) {
                alert("Error!")
                console.log("Game Server Processing......");
            }
        });
    }

    $('#signoff').click(function () {
        console.log("signoff");
        localStorage.clear();
    })

/////
//test

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