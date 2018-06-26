/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
     var List; 
     var chart1=[
			{ y: 51.08, label: "Chrome" },
			{ y: 27.34, label: "Internet Explorer" },
			{ y: 10.62, label: "Firefox" },
			{ y: 5.02, label: "Microsoft Edge" }
			
		];
                
                
                
                 $('#signoff').click(function(){
        localStorage.clear();
    })
    
    function ajaxGetSectors() {
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/broker/getAllSectorsBuy",

            success: function (data) {
                console.log(data);
                List = data;
                

                for (i in List) {
                    $('#sct_id').append('<option value="' + List[i].sectorId + '">' + List[i].sectorName + '</option>');
                   // chart1[i].y=List[i].
                }


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
        if(m<0){
            isplay='stop';
            alert('timer completed');
            $('#play').hide();
            $('#play2').hide();
            //window.location.href="home"
            localStorage.setItem("auto",round);
            ajaxPostAutomate();
            
            
             round=round+1; 

        
        }

        
        if(m>-1){
            
        document.getElementById('timer').innerHTML =
                m + ":" + s;
         localStorage.setItem("timem",m);
         localStorage.setItem("times",s);
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
    
    
    
    
})

