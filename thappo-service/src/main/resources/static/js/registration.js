$(document).ready(function() {
	$("#btnSave").click(function() {
		var firstName = $("#txtFirstName").val();
		var lastName = $("#txtLastName").val();
		var email = $("#txtEmail").val();
		var confEmail  = $("#txtConfEmail").val();
		var password = $("#txtPassword").val();
		var confPassword = $("#txtConPassword").val();
		var dob = $("#txtDob").val();
		var telephone = $("#txtTelephone").val();
		var password = $("#txtPassword").val();
		var cpassword = $("#txtConPassword").val();

		if (firstName == '' || email == '' || password == '' || confPassword == '') {
			alert("Please fill all fields...!!!!!!");
		} else if ((password.length) < 8) {
			alert("Password should atleast 8 character in length...!!!!!!");
		} else if (!(password).match(confPassword)) {
			alert("Your passwords don't match. Try again?");
		} else {

            $.ajax({  
                type: "POST", //HTTP POST Method  
                url: "/v3/users/", // Controller/View   
                data: JSON.stringify({ //Passing data  
                	first_name: firstName,
                	last_name: lastName,
                	email: email,
                	password: password,
                	dob: dob,
                	profile: "MANAGER",
                	state: "INACTIVE",
                	telephone: telephone
                }),           
                dataType: "json",
                contentType : "application/json",
                success: function(data) {
                    alert('Hello ' + firstName + ' ' + lastName);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert('jqXHR: ' +jqXHR+ ',errorThrown: ' + errorThrown + ',testStatus: ' +textStatus);
               } });   

        }
    });

    $("#btton").click(function(){
        $.get("http://dolar.wilkinsonpc.com.co/divisas/dolar-diario.html", function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    });
});
/*

    $(document).ready(function () {  
//function will be called on button click having id btnsave
        $("#btnSave").click(function () {  
            $.ajax(  
            {  
                type: "POST", //HTTP POST Method  
                url: "Home/AddEmployee", // Controller/View   
                data: { //Passing data  
                    Name: $("#txtName").val(), //Reading text box values using Jquery   
                    City: $("#txtAddress").val(),  
                    Address: $("#txtcity").val()  
                } 







*/