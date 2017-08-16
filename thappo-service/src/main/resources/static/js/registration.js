$(document).ready(function() {
	$("#btn-register").click(function() {
		var firstName = $("#register-first-name").val();
		var lastName = $("#register-last-name").val();
		var email = $("#register-email").val();
		var password = $("#register-password").val();
		var dob = $("#register-dob").val();
		var telephone = $("#register-telephone").val();

		if (firstName == '' || email == '' || password == '' ) {
			$('#signupalert').html('ERROR: Falta ingresar algun nombre o correo o clave').show();

		} else if ((password.length) < 8) {
			$('#signupalert').html('ERROR: longitud de la contraseña').show();

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
                    alert('Registration succesfull');
                    location.href = "index.html";
                },
                error: function(jqXHR, textStatus, errorThrown) {
                	if( "DataIntegrityViolationException" == JSON.parse(jqXHR.responseText).exception ){                		
                		$('#signupalert').html('ERROR: El correo se encuentra registrado').show();
                	}else {                		
                		$('#signupalert').html('ERROR: error inesperado').show();
                	}

               } });   

        }
	 });
    });