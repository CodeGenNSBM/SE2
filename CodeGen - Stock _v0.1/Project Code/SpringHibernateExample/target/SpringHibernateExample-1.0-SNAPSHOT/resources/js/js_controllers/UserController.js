/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$( document ).ready(function() {
    
var  user={};   
$('#login').click(function(){
	// Submit List of Cu1stomer to Back-End server
        if($("#uname").val()!='' && $("#password").val()!='')
        {      console.log("fired");
            user = {
    			uname : $("#uname").val(),
    			password : $("#password").val()
    			
    	}
		ajaxPost();
            }
            else
            {
                if($("#password").val()=='')
                {
                    alert("Bad password or empty password!");
                }
                else
                {
                 alert("Username can not be empty!");   
                }
            }
	});
        
	

        
    function ajaxPost(){
    	//console.log("fired");
    	// DO POST 
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			accept: 'text/plain',
			url :  "/SpringHibernateExample/login" ,
			data : JSON.stringify(user),
			dataType: 'text',
			success : function(result) {
                            console.log(result);
                            if(result=='success'){
                                
                            window.location.href="successlog";
                        
                            }
                        else
                        {
                            alert("Something went wrong! Try Again with valid Username Password");
                        }
                            
				// clear customer body
				//$('#customerTable tbody').empty();
				//$('#customerTable').hide();
				
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }    
    
    //
    
    $('#signoff').click(function(){
        localStorage.clear();
    })
    
    
    
})

