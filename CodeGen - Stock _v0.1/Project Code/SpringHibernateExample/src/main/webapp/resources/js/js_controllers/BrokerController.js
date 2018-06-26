/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    ajaxGetStockSectorDetails();
    var List;
    var sectID;
    var stckID;
    var sector = {};
    var stock = {};
    var eTable;
    
    if (localStorage.times > 00 || localStorage.timem > 0) {
        document.getElementById('timer').innerHTML = localStorage.timem + ":" + localStorage.times;
        //isplay = 'play';
       //  setTimeout(startTimer, 10000);
       startTimer();
       

    }

    $('#refreshStock').click(function(){
              console.log("fired");    			
    			//ajaxGetAllSectors();
                        ajaxGetStockSectorDetails();
                        //ajaxSetGroupings();
	});
    
    function ajaxGetAllSectors() {
       
       $.ajax({
            type: "POST",
            contentType : "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/broker/getAllSectors",
            //data: JSON.stringify(sector),
            //dataType: 'text',
            
            success: function (data) {
                console.log(data);
                $.each(data, function(key,value){
                       
                    sectID = value.sectorId;
                    sector = {sectorId: sectID, sectorName : null};
                    console.log("aaaaaaaaaabb" + sector); 
                    
                    ajaxGetStockSectorDetails();
                   
                    //console.log("bbbbbccccccccccccccccca" +eTable); 
 
                });
                    
                },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
    
    function ajaxGetStockSectorDetails() {
          sector = {sectorId : 0, sectorName : null};
       $.ajax({
            type: "POST",
            contentType : "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/broker/getSSDSWithJoin",
            data: JSON.stringify(sector),
            //dataType: 'text',
            
            success: function (data) {
                
                console.log(data);
                var last=null;
   
    eTable="<table class='table table-bordered' id='dataTable' width='100%' cellspacing='0'><thead><tr><th>SECTOR NAME</th><th>STOCK NAME</th><th>CURRENT RATE</th></tr></thead><tbody>";                
  $.each(data,function(index, row){
        console.log("bbbbbbbbbbbbbbbbbaa"); 
        console.log(row); 
     /*eTable += "<tr>";
     eTable += "<td>"+value['name']+"</td>";
     eTable += "<td>"+value['title']+"</td>";
     eTable += "<td>"+value['salary']+"</td>";
     eTable += "</tr>";*/
 
    eTable += "<tr>";
     var i = '0';
    $.each(row,function(key,value){
        if(i=='0')
        {            
            console.log("cccccccccccc");
            if(last!=value)
            {
                last = value;
                eTable += '<tr class="group"><td colspan="5">'+value+'</td></tr>';
            }
        }
        if(i=='0')
        {
           value =''; 
        } 
      eTable += "<td>"+value+"</td>";
      var j =  parseInt(i);
     
      i=j+1;
       console.log("ccccccccccccaaaa" + i);
    });
    eTable += "</tr>";
       
        
  });
      eTable +="</tbody></table>";        
   $('#eachTable').html(eTable);
                },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
    
    function ajaxSetGroupings() {
         var groupColumn = 2;
    var table = $('#dataTable').DataTable({
        "columnDefs": [
            { "visible": false, "targets": groupColumn }
        ],
        "order": [[ groupColumn, 'asc' ]],
        "displayLength": 25,
        "drawCallback": function ( settings ) {
            var api = this.api();
            var rows = api.rows( {page:'current'} ).nodes();
            var last=null;
 
            api.column(groupColumn, {page:'current'} ).data().each( function ( group, i ) {
                if ( last !== group ) {
                    $(rows).eq( i ).before(
                        '<tr class="group"><td colspan="5">'+group+'</td></tr>'
                    );
 
                    last = group;
                }
            } );
        }
    } );
    };
    
    // Order by the grouping
    $('#dataTable tbody').on( 'click', 'tr.group', function () {
        var currentOrder = table.order()[0];
        if ( currentOrder[0] === groupColumn && currentOrder[1] === 'asc' ) {
            table.order( [ groupColumn, 'desc' ] ).draw();
        }
        else {
            table.order( [ groupColumn, 'asc' ] ).draw();
        }
    } );
    
    
    
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
    

});


