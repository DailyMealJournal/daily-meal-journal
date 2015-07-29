setTimeout(function(){
	$('.phone').addClass('phone-app');
},2500);

function globalFunction() {
	var x = 0;
	$('.team-member').each(function(){
		x = 200 + x;
		$(this).delay(x).fadeIn(300);

	});
}

$(document).ready(function(){
	$('#btn_signup').click(function(e) {
		e.preventDefault();
		$('#login').addClass('hide');
		$('#register').removeClass('hide');
		$('#register').hide().fadeIn(700);
	});

	$('#btn_back').click(function(e) {
		e.preventDefault();
		$('#register').addClass('hide');
		$('#login').removeClass('hide');
		$('#login').hide().fadeIn(700)
	});

	$('#btn_register').click(function(e){
		var password = $('#register_password').val();
		var confirm = $('#conf_password').val();
		
		if(password != confirm){
			e.preventDefault();
			$('#register_form_errors').show(600);
		}
		else{
			$('#register_form_errors').hide(600);
		}
	});

	
	$("#register_password, #conf_password").keyup(function(){
		var password = $('#register_password');
		var confirm = $('#conf_password');
		
		password.addClass("invalid");
		confirm.addClass("invalid");
		
		if((password.val() == confirm.val()) && (password.val().length >= 8)){
			password.removeClass("invalid");
			confirm.removeClass("invalid");
			
			$("register_form_errors").removeClass("register-error");
			
			password.addClass("valid");
			confirm.addClass("valid");
		}
	});

	$("#btn_submit").click(function(e){
		e.preventDefault();
		$('#login_form_errors').fadeOut(100);
		var form = $('#login');
		$.ajax({
			method: form.attr('method'),
			url: form.data('post-url'),
			data: {
					username: $('#login_username').val(),
					password: $('#login_password').val()

			},
			success: function(o_response, s_status, s_xhr) {
				console.log(o_response)
				if(typeof o_response != 'undefined') {
					console.log(o_response)
					if(typeof o_response.errors != 'undefined' && o_response.errors.length == 0) {
						$('#login_username, #login_password')
							.removeClass('valid')
							.addClass('invalid');
					} else {
						window.location.href = base_url + 'meal_journal';
					}
				}
			},
			error: function(o_response, status, error) {
				if(typeof o_response.responseJSON != 'undefined') {
					$('#login_username, #login_password')
						.removeClass('valid')
						.addClass('invalid');
					$('#login_form_errors').fadeIn(200);
					$('#login_form_errors').text(o_response.responseJSON.message);
				} 
			}
		});
	});	
	
	$('.parallax').parallax();
	$(window).scrollTop();
	$('.team-member').each(function(){
		$(this).hide()
	});
	var options = [
		{selector: '.team-member', offset: 300, callback: 'globalFunction()' }
	];
	setInterval(Materialize.scrollFire(options),1000);
});