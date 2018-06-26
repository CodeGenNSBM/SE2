/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    ajaxGetTransaction();
    ajaxGetDepositBalance();
    ajaxGetWithdrawBalance();
    var bankTransaction = {};
    
    
    
    
    
    if (localStorage.times > 00 || localStorage.timem > 0) {
        document.getElementById('timer').innerHTML = localStorage.timem + ":" + localStorage.times;
        isplay = 'play';
       //  setTimeout(startTimer, 10000);
       counter();
       

    }
    
    $('#refresh').click(function(){
	// Submit List of Customer to Back-End server
              console.log("fired");    			
    			ajaxGetTransaction();
                        ajaxGetDepositBalance();
                        ajaxGetWithdrawBalance();
	});
    
    function ajaxGetTransaction() {
        bankTransaction = {
            id : 4,
            playerId : 11,
            amount: null,
            transferDate : null,
            type : null,
            isActive : null,
            isSuccess : null,
            receiverOrSender : null,
            activeDate : null
            }; 
       $.ajax({
            type: "POST",
            contentType : "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/transaction/getBankTransaction",
            data: JSON.stringify(bankTransaction),
            //dataType: 'text',
            
            success: function (data) {
                console.log(data);
                //data = data.surrey;
                    var html = '';
                    $.each(data, function(key,value){
                        html += '<tbody>';
                            html += '<tr>';
                                html+='<td>'+value.receiverOrSender+'</td>';
                                html+='<td>'+value.type+'</td>';
                                var date = new Date(value.transferDate);
                                var month = date.getMonth() + 1;
                                html+= '<td>'+(month.length > 1 ? month : "0" + month) + "/" + date.getDate() + "/" + date.getFullYear()+'</td>';
                                //html+='<td>'+value.transferDate+'</td>';
                                html+='<td>'+"Rs: "+ parseFloat(value.amount).toFixed(2)+'</td>';
                                html+='<td>'+value.isSuccess+'</td>';
                            html += '</tr>';
                        html += '</tbody>';
                    });
                    $('#dataTable tbody').remove();
                    $('#dataTable').append(html);   
                },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
    
    function ajaxGetDepositBalance() {
        bankTransaction = {
            id : 4,
            playerId : 11,
            amount: null,
            transferDate : null,
            type : 1,
            isActive : null,
            isSuccess : null,
            receiverOrSender : null,
            activeDate : null
            }; 
       $.ajax({
            type: "POST",
            contentType : "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/transaction/getBankTransaction",
            data: JSON.stringify(bankTransaction),
            //dataType: 'text',
            
            success: function (data) {
                console.log(data);
                    var html = '0';
                    $.each(data, function(key,value){
                        var x =  parseFloat(html);
                        var y =  parseFloat(value.amount);
                        html = x + y;
                    });
                    $("#txtDepositBalance").val("Rs: "+ parseFloat(html).toFixed(2));   
                },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
    
    function ajaxGetWithdrawBalance() {
        bankTransaction = {
            id : 4,
            playerId : 11,
            amount: null,
            transferDate : null,
            type : 2,
            isActive : null,
            isSuccess : null,
            receiverOrSender : null,
            activeDate : null
            }; 
       $.ajax({
            type: "POST",
            contentType : "application/json",
            accept: 'text/plain',
            url: "/SpringHibernateExample/transaction/getBankTransaction",
            data: JSON.stringify(bankTransaction),
            //dataType: 'text',
            
            success: function (data) {
                console.log(data);
                    var html = '0';
                    $.each(data, function(key,value){
                        var x =  parseFloat(html);
                        var y =  parseFloat(value.amount);
                        html = x + y;
                    });
                    $("#txtWithdrawBalance").val("Rs: "+ parseFloat(html).toFixed(2));   
                },
            error: function (e) {
                //$("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }

    // onload event of body element
    function bodyOnLoad() {
    }

// window.onload
    window.onload = function () {
    };
    
    
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
    
    
});


