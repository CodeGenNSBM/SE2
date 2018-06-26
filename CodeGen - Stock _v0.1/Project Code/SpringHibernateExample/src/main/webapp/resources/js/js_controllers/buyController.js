/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var List;
    var stockList;
    var sectID;
    var sellDetails = {};
    var sellSector = {};
    var stockDet = {};
    var stockID;
     $('#signoff').click(function(){
        localStorage.clear();
    })
    
    if (localStorage.times > 00 || localStorage.timem > 0 ) {
    document.getElementById('timer').innerHTML=localStorage.timem+":"+localStorage.times;    
    startTimer();
    }
    
    ajaxGet();
    
    $("#buyBroker").submit(function (event) {
        // Prevent the form from submitting via the
        //  browser.
        event.preventDefault();
        if( $('#stk_id').val()=="" ||  $('#sct_id').val()=="" ||  $('#st_amount').val()=='0'||  $('#st_amount').val()=="" )
        {
            if( $('#stk_id').val()=="")
            {
                alert("Please select a stock!");
            }
            else if( $('#sct_id').val()=="")
            {
                alert("Please select a sector!");
            }
            else 
            {
                alert("Please check Stock amount!");
            }
        }
        else{
        // get data from submit form
        var sellDetails = {
 

  /*  userId_fk
    sectorID_fk
   stockID_fk
    stockAmount
isBuy */
    
            userId_fk : '1',
            sectorID_fk : $("#sct_id").val().trim(),
            stockID_fk:  $("#stk_id").val().trim(),
            stockAmount: $("#st_amount").val().trim(),
            isBuy:'1'
        }
        ajaxPost();
        //ajaxUpdatePrice();
        }
    });

    $('#sct_id').click(function () {

        console.log("fired");
        $('#stk_id').empty();
        if($('#sct_id').val()=='')
        {
           $('#stk_id').val("");
    
     $('#rate').val(' ');
     $('#profit').val('');
     $('#st_amount').val(' ');
        }
        else{
        for (i in List) {
            console.log(List[i].sectorId);
            console.log($('#sct_id').val());
            if ($('#sct_id').val() == List[i].sectorId)
            {
                sectID = List[i].sectorId;
                console.log(sectID);
            }
        }
        sellSector = {sectorId: sectID, sectorName: $('#sct_id').val()};
        // ajaxGetStocksNew();
         ajaxGetStocks();
         
          for (ii in stockList) {

            if ($('#stk_id').val() == stockList[ii].stockName)
            {
                stockID = stockList[ii].id;
                    console.log(stockList[ii].id);
            }
        }
    }
        //ajaxGet();
    });
    $('#stk_id').click(function () {

        console.log("fired stock");
      /*  for (i in List) {
            console.log(List[i].sectorId);
            console.log($('#sct_id').val());
            if ($('#sct_id').val() == List[i].sectorId)
            {
                sectID = List[i].sectorId;
                console.log(sectID);
            }
        }
        sellSector = {sectorId: sectID, sectorName: $('#sct_id').val()};
        // ajaxGetStocksNew();
         ajaxGetStocks();
         
          for (ii in stockList) {

            if ($('#stk_id').val() == stockList[ii].stockName)
            {
                stockID = stockList[ii].id;
                    console.log(stockList[ii].id);
            }
        }  */
        ajaxGetPrices();
    });

    function ajaxPost() {
        console.log(sellDetails);
         var sellDetails = {
            userId_fk : 1,
            sectorID_fk : parseInt($('#sct_id').val().trim()),
            stockID_fk:  parseInt($('#stk_id').val().trim()),
            stockAmount: parseInt($('#st_amount').val().trim()),
            isBuy:1
        }
        // DO POST 
        $.ajax({
            type: "POST",
            contentType: "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/broker/addTbltemp_buy_sell",
            data: JSON.stringify(sellDetails),
            dataType: 'text',
            success: function (result) {
                // clear customer body
                //$('#customerTable tbody').empty();
                //$('#customerTable').hide();

                // re-set customer table list
                ajaxUpdatePrice();
                clearForm();
               alert("Successfully Added!")
                console.log(result);

                // fill successfully message on view
                window.location.href="transaction";
                // fill successfully message on view
                
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    //get all sectors
    function ajaxGet() {
        $.ajax({
            headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    contentType : "application/json",
            type: "POST",
            url: "/SpringHibernateExample/broker/getAllSectors",

            success: function (data) {
                console.log(data);
                List = data;
                $('#sct_id').empty();
                     $('#sct_id').append('<option value=""></option>');
                     
                for (i in List) {
                    $('#sct_id').append('<option value="' + List[i].sectorId + '">' + List[i].sectorName + '</option>');

                }


            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

    function ajaxGetStocks() {

        $.ajax({
            type: "POST",
            contentType: "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/broker/getStockAccordingSector",
            data: JSON.stringify(sellSector),

            success: function (data) {

                console.log(data);
                stockList = data;
                $('#stk_id').empty();

                for (ii in stockList) {
                    $('#stk_id').append('<option value="' + stockList[ii].id + '">' + stockList[ii].stockName + '</option>');

                }
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

   document.getElementById('st_amount').onkeydown= function(e) {
      
      $('#profit').val($('#rate').val()*$('#st_amount').val());
        
 }
 





// getPrices etc

    function ajaxGetPrices() {
        console.log("xxxxxxxxxxxxxxxxxx");
        for (i in stockList) {

            if ($('#stk_id').val() == stockList[i].stockName)
            {
                stockID = stockList[i].id;
                    console.log(stockList[i].id);
            }
        }
         console.log(stockID);
        stockDet = {sectorId_fk: sectID, stockID_fk:$('#stk_id').val()};
        $.ajax({
            type: "POST",
            contentType: "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/broker/getStockPrices",
            data: JSON.stringify(stockDet),

            success: function (data) {
               // document.getElementById('stkAmount').innerHTML = "New Text";
                for (i in data) {
                  $('#stkAmount').val(data[i].stockAmount);
                   $('#rate').val(data[i].currentRate);
                   $('#sellRate').val(data[i].currentRate- data[i].currentRate*0.2);
                   $('#profit').val($('#rate').val()*$('#st_amount').val());
                console.log(data);
                }

                

            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

///////////////////////////////////////new

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
                $('#sct_id').empty();

                for (i in List) {
                    $('#sct_id').append('<option value="' + List[i].sectorId + '">' + List[i].sectorName + '</option>');

                }


            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
//////////////second new 
 function ajaxGetStocksNew() {

        $.ajax({
            type: "POST",
            contentType: "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/broker/getAllStockssBuy",
            data: JSON.stringify(sellSector),


            success: function (data) {

                console.log(data);
                stockList = data;
                $('#stk_id').empty();

                for (ii in stockList) {
                    $('#stk_id').append('<option value="' + stockList[ii].id + '">' + stockList[ii].stockName + '</option>');

                }
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

function clearForm() {
    
     $('#sct_id').html("");
     $('#stk_id').val("");
    
     $('#rate').val(' ');
     $('#profit').val('');
     $('#st_amount').val(' ');
     
}

function ajaxUpdatePrice() {

        $.ajax({
            type: "POST",
           // contentType: "application/json",
           // accept: 'text/plain',
            url: "/SpringHibernateExample/updatePricesRealm",
           // data: JSON.stringify(sellSector),


            success: function (data) {

                console.log(data);
              
            },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

// timer stuff
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
         //ajaxPost();

        
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


