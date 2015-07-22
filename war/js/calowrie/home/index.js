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

	$('#btn_submit').click(function(e){
		e.preventDefault();
		$('#login').submit();
	});
	
	$("#register_password, #conf_password").keyup(function(){
		var password = $('#register_password');
		var confirm = $('#conf_password');
		
		password.addClass("invalid");
		confirm.addClass("invalid");
		
		if((password.val() == confirm.val()) && (password.val().length != 0)){
			password.removeClass("invalid");
			confirm.removeClass("invalid");
			
			password.addClass("valid");
			confirm.addClass("valid");
		}
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