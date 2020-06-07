/**
 * 
 */
$(document).ready(function(){
	$("#customer-Form").submit(function (event) {
		event.preventDefault();
		var customerObj = new Object();
		customerObj["firstName"] = $("#firstName").val();
		customerObj["lastName"] = $("#lastName").val();
		customerObj["address"] = $("#address").val();
		customerObj["accountType"] = $("#selAccType").val();
		customerObj["customerId"] = $("#id").val();
		$("#btnCreateCustomer").prop("disabled", true);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "createCustomer",
			data: JSON.stringify(customerObj),
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				showCustomerView(data)
				$("#btnCreateCustomer").prop("disabled", false);
			},
			error: function (e) {
				console.log("ERROR : ", e);
				$("#btnCreateCustomer").prop("disabled", false);

			}
		});
	});
});


function showCustomerView(data){debugger;
	$.ajax({
	type: "GET",
	url: "customerView",
	success: function (data) {},
	error: function (e) {}
});}