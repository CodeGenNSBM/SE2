
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$( document ).ready(function() {
    
var  user={}; 
var  valid="";

        
	
$('#signin').click(function(){
	// Submit List of Customer to Back-End server
              console.log("xxxxxxxxxx");
            user = {
                        name: $("#exampleInputName").val(),
    			uname : $("#exampleInputUserName").val(),
    			password : $("#exampleConfirmPassword").val() 			
    	}
                verification();
                if(valid=="success")
		{
                    ajaxPostSign();
                    
                }
	});        
        
        
   
    function verification()
    {
        if($("#exampleInputName").val()!='' && $("#exampleInputUserName").val()!='' && $("#exampleInputPassword1").val()!='' && $("#exampleConfirmPassword").val()!='' )
        {
             if($("#exampleConfirmPassword").val()!=$("#exampleInputPassword1").val())
             {
               alert("Error! Password not match") ; 
             }
             else
             {
                 valid="success"
             }
        }
        else
        {
            alert("Error! Empty Values are not eligible") ;
        }
    }
    
    //
    
     function ajaxPostSign(){
    	//console.log("fired");
    	// DO POST 
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			accept: 'text/plain',
			url :  "/SpringHibernateExample/signin" ,
			data : JSON.stringify(user),
			dataType: 'text',
			success : function(data) {
                            clearcontent();	
                             var result = $.trim(data);
                        if(result==="exists"){
                        
                        alert("Username Exists....Try Another");
                        }
                            if(result==="success"){
                        
                        alert("User Added Successfully!");
                        }
                            else
                            {
                            
                        
                        alert("Something went wrong....!");
                        }   
                            
				// clear customer body
				//$('#customerTable tbody').empty();
				//$('#customerTable').hide();
			
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
                                clearcontent();
			}
		});
                valid="";
    }    
    
    
    function  clearcontent()
    {
        $("#exampleInputName").val(''); 
        $("#exampleInputUserName").val('');
        $("#exampleInputPassword1").val('');
        $("#exampleConfirmPassword").val('');
       
    }
    
     $('#signoff').click(function(){
        localStorage.clear();
    })
    
    
})
