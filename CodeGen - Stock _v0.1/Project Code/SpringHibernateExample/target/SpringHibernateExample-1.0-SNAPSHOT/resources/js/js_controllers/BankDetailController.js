/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    ajaxGetBankDetails();
    var List;
    var bankDetail = {};
    
    
    if (localStorage.times > 00 || localStorage.timem > 0) {
        document.getElementById('timer').innerHTML = localStorage.timem + ":" + localStorage.times;
        isplay = 'play';
       //  setTimeout(startTimer, 10000);
        window.setTimeout(function(){
                 startTimer();    
                  }, 10000);
       

    }
    
    $('#refresh').click(function(){
	// Submit List of Customer to Back-End server
              console.log("fired");    			
    			ajaxGetBankDetails();
	});
        
         $('#signoff').click(function(){
        localStorage.clear();
    })
    
    
    function ajaxGetBankDetails() {
        console.log("aaa22222");
        bankDetail = {
            id : null,
            playerId : 11,
            bankName : null,
            availableBalance : null,
            isActive : null,
            activeDate : null
            };
       $.ajax({
            type: "POST",
            contentType : "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/bankDetail/getPlayerBankDetail",
            data: JSON.stringify(bankDetail),
            //dataType: 'text',
              
            success: function (data) {
                console.log(data);
                    
                    $.each(data, function(key,value){
                        $("#txtAvailableBalance").val("Rs: "+ value.availableBalance.toFixed(2));                            
                    });   
                },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
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
    
    
    
});

