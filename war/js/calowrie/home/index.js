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