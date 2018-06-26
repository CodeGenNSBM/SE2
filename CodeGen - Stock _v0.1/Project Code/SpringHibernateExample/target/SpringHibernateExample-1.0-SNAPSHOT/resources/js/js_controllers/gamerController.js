/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    var tim;       
        var min = '${sessionScope.min}';
        var sec = '${sessionScope.sec}';
        var f = new Date();
         $('#signoff').click(function(){
        localStorage.clear();
    })
    
        
        
     var x = readCookie('time')
     if (x) {
	   min=x;
       }
        var xx = readCookie('timeSec')
     if (xx) {
	   sec=xx;
       }
   
   
    
    //time count
    function startTimer() {
        var presentTime =01 + ":" + 00;
        var timeArray = presentTime.split(/[:]+/);
        var m = timeArray[0];
        var s = checkSecond((timeArray[1] - 1));
        if (s == 59) {
            m = m - 1
        }
        if(m<0){alert('timer completed')
        ajaxPost();
        }

        
        if(m>-1){
       // document.getElementById('timer').innerHTML =
            //    m + ":" + s;
        console.log(m + ":" + s);
        setTimeout(startTimer, 1000);}
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
    
   $('#start').click(function () {

        console.log("game starts");
        ajaxPost();

    });  
    
    function ajaxPost() {
        //console.log("fired");
        // DO POST 
        $.ajax({
            type: "POST",
            url: "/SpringHibernateExample/makeRounder",
            success: function (data) {
                // clear customer body
                //$('#customerTable tbody').empty();
                //$('#customerTable').hide();

                // re-set customer table list
                console.log(data);
                 var result = $.trim(data);
                if(result==="Go"){
                    examTimer();
                alert("available");
                }
                 // fill successfully message on view
               
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }
    
   
    /////new functions
    

        function customSubmit(someValue){  
        	// document.questionForm.minute.value = min;   
        	// document.questionForm.second.value = sec; 
        	// document.questionForm.submit();  
        	 }  

        function examTimer() {
             var min = '${sessionScope.min}';
             var sec = '${sessionScope.sec}';
             console.log(min);
            if (parseInt(sec) >0) {

            document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minutes ," + sec+" Seconds";
                sec = parseInt(sec) - 1; 
                localStorage.setItem("time",document.getElementById("showtime").innerHTML);
               
                tim = setTimeout("examTimer()", 1000);
            }
            else {

			    if (parseInt(min)==0 && parseInt(sec)==0){
			    	document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minutes ," + sec+" Seconds";
				     alert("Time Up");
                                     eraseCookie('time');
                                     eraseCookie('timeSec');
				     ajaxPost();

			     }

                if (parseInt(sec) == 0) {				
                document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minutes ," + sec+" Seconds";					
                min = parseInt(min) - 1;
					sec=59;
                createCookie('time',min,1);
                createCookie('timeSec',sec,1);
                tim = setTimeout("examTimer()", 1000);
                }

            }
        }
    
  ///setting cookies
  function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}
  

///
$('#check').click(function () {

        console.log("game starts");
       ajaxGet();
    });  
    



function ajaxGet() {
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/graphsup1",

            success: function (data) {
                console.log(data);
                

            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }




    
})