$(document).ready(
		function() {

			// SUBMIT FORM
			$("#accept").click(function(event) {
				// Prevent the form from submitting via the browser.
				$("#accept").html("accepted");
				$("#accept").prop("disabled",true);
				$("#reject").prop("disabled",true);
				event.preventDefault();
				ajaxPostaccept();
			});

            $("#reject").click(function(event) {
				// Prevent the form from submitting via the browser.
				$("#reject").html("rejected");
				$("#accept").prop("disabled",true);
				$("#reject").prop("disabled",true);
				event.preventDefault();
				ajaxPostaccept();
			});
			
            function ajaxPostreject() {

				// PREPARE FORM DATA
				var formData = {
					id:$("#requestid").text(),
					book_id : $("#bookid").text(),
					user_id : $("#userid").text(),
					status  : 0
				}
				
				let j=formData.id.toString();
				console.log(formData);

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/updaterequest/"+j,
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						console.log("request updated !!!")
					},
					error : function(e) {
						console.log("ERROR !!!")
					}
				});

			}
			function ajaxPostaccept() {

				// PREPARE FORM DATA
				var formData = {
					id:$("#requestid").text(),
					book_id : $("#bookid").text(),
					user_id : $("#userid").text(),
					status  : 1
				}
				
				let j=formData.id.toString();
				console.log(formData);

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/updaterequest/"+j,
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						console.log("request updated !!!")
					},
					error : function(e) {
						console.log("ERROR !!!")
					}
				});

			}

})