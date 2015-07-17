setTimeout(function(){
	$('.phone').addClass('phone-app');
},2500);

$(document).ready(function(){
  $('.parallax').parallax();

  $('#btn_signup').click(function(e) {
  	e.preventDefault();
  	$('#login').addClass('hide');
  	$('#register').removeClass('hide');
  	$('#register').hide().fadeIn(700);
  });
});