/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * onload
 */

    
    
function dograph(){
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/graphsup1",

            success: function (data) {
        
        var finals = [];
        for(var i = 0; i < data.length; i++)
        {
            
           
            finals.push({ 'y':data[i].prcnt, 'label':data[i].name });
        }
                
                
                console.log(finals);
                var chart1 = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	
	data: [{
		type: "doughnut",
		startAngle: 60,
		//innerRadius: 60,
		indexLabelFontSize: 17,
		indexLabel: "{label} - #percent%",
		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		dataPoints: finals
		
	}]
});
        chart1.render();
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    
    }
    
    ///
    
    
    function dograph2(){
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/graphsup3",

            success: function (data) {
        
        var finals2 = [];
        for(var i = 0; i < data.length; i++)
        {
            
           
            finals2.push({ 'y':data[i].prcnt, 'label':data[i].name });
        }
                
                
                console.log(finals2);
           var chart2 = new CanvasJS.Chart("chartContainer1", {
	animationEnabled: true,
	
	data: [{
		type: "doughnut",
		startAngle: 60,
		//innerRadius: 60,
		indexLabelFontSize: 17,
		indexLabel: "{label} - #percent%",
		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		dataPoints: finals2
			
		
	}]
});
            chart2.render();
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    
    }
 ////////
 
 function dograph3(){
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/graphsup4",

            success: function (data) {
        
        var finals3 = [];
        for(var i = 0; i < data.length; i++)
        {
            
           //data[i].prcnt
            finals3.push({ 'y':data[i].prcnt, 'label':data[i].name });
        }
                
                
                console.log(finals3);
              var chart3 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	
	data: [{
		type: "doughnut",
		startAngle: 60,
		//innerRadius: 60,
		indexLabelFontSize: 17,
		indexLabel: "{label} - #percent%",
		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		dataPoints: finals3
			
		
	}]
});         chart3.render();

            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    
    }
    
    ///
    
    function dograph4(){
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/graphsup5",

            success: function (data) {
                 console.log(data);
                var finals4 = [];
        for(var i = 0; i < data.length; i++)
        {
            
           //data[i].prcnt
            finals4.push({ 'y':data[i].amount, 'label':data[i].content });
        }
                
                var chart5 = new CanvasJS.Chart("barchartContainer", {
	animationEnabled: true,
	
	
	axisX:{
		interval: 1
	},
	axisY2:{
		interlacedColor: "rgba(1,77,101,.2)",
		gridColor: "rgba(1,77,101,.1)",
		title: "Amount"
	},
	data: [{
		type: "bar",
		name: "companies",
		axisYType: "secondary",
		color: "#014D65",
		dataPoints:finals4
	}]
});
                
                
             chart5.render();

            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    
    }
    
  //graphsup5 
  
   function dograph5(){
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/graphsup6",

            success: function (data) {
                 console.log(data);
                var finals5 = [];
        for(var i = 0; i < data.length; i++)
        {
            
           //data[i].prcnt
            finals5.push({ 'y':data[i].amount, 'label':data[i].content });
        }
                var chart4 = new CanvasJS.Chart("columnchartContainer", {
	theme: "light1", // "light2", "dark1", "dark2"
	animationEnabled: true, // change to true false		
	
	data: [
	{
		// Change type to "bar", "area", "spline", "pie",etc.
		type: "column",
		dataPoints:finals5
			
	}
	]
});
             chart4.render();

            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    
    }
 
    
    function startTimer() {
         //$('#play').hide();
         $('#play').show();
         $('#play2').show();
         isplay='play';
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
        // ajaxPost();

        
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

    
    

window.onload = function () {

if (localStorage.times > 00 || localStorage.timem > 0 ) {
    document.getElementById('timer').innerHTML=localStorage.timem+":"+localStorage.times;
        //isplay='play';
        startTimer();
        
    }
     $('#signoff').click(function(){
        localStorage.clear();
    })
    
dograph();
dograph2();
dograph3();
dograph4();
dograph5();

/*
//pie chart 1
var chart1 = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	
	data: [{
		type: "doughnut",
		startAngle: 60,
		//innerRadius: 60,
		indexLabelFontSize: 17,
		indexLabel: "{label} - #percent%",
		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		dataPoints: [
			{ y: 67, label: "Inbox" },
			{ y: 28, label: "Archives" },
			{ y: 10, label: "Labels" },
			{ y: 7, label: "Drafts"},
			{ y: 15, label: "Trash"},
			{ y: 6, label: "Spam"}
		]
	}]
});

//pie chart 2
var chart2 = new CanvasJS.Chart("chartContainer1", {
	animationEnabled: true,
	
	data: [{
		type: "doughnut",
		startAngle: 60,
		//innerRadius: 60,
		indexLabelFontSize: 17,
		indexLabel: "{label} - #percent%",
		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		dataPoints: [
			{ y: 67, label: "Inbox" },
			{ y: 28, label: "Archives" },
			{ y: 10, label: "Labels" },
			{ y: 7, label: "Drafts"},
			{ y: 15, label: "Trash"},
			{ y: 6, label: "Spam"}
		]
	}]
});



//pie chart 3
var chart3 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	
	data: [{
		type: "doughnut",
		startAngle: 60,
		//innerRadius: 60,
		indexLabelFontSize: 17,
		indexLabel: "{label} - #percent%",
		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		dataPoints: [
			{ y: 67, label: "Inbox" },
			{ y: 28, label: "Archives" },
			{ y: 10, label: "Labels" },
			{ y: 7, label: "Drafts"},
			{ y: 15, label: "Trash"},
			{ y: 0, label: "Spammm"}
		]
	}]
});




//column chart
var chart4 = new CanvasJS.Chart("columnchartContainer", {
	theme: "light1", // "light2", "dark1", "dark2"
	animationEnabled: true, // change to true false		
	
	data: [
	{
		// Change type to "bar", "area", "spline", "pie",etc.
		type: "column",
		dataPoints: [
			{ label: "Player 1",  y: 100  },
			{ label: "Player 2", y: 150  },
			{ label: "Player 3", y: 250  },
			{ label: "Player 4",  y: 300  },
			{ label: "Player 5",  y: 280  }
		]
	}
	]
});


//bar chart
var chart5 = new CanvasJS.Chart("barchartContainer", {
	animationEnabled: true,
	
	
	axisX:{
		interval: 1
	},
	axisY2:{
		interlacedColor: "rgba(1,77,101,.2)",
		gridColor: "rgba(1,77,101,.1)",
		title: "Amount"
	},
	data: [{
		type: "bar",
		name: "companies",
		axisYType: "secondary",
		color: "#014D65",
		dataPoints: [
			{ y: 300, label: "ex" },
			{ y: 700, label: "ex" },
			{ y: 500, label: "ex" },
			{ y: 900, label: "Current Bank Amount" }
		]
	}]
});
*/
//chart1.render();
//chart2.render();
//chart3.render();
//chart4.render();
//chart5.render();

}