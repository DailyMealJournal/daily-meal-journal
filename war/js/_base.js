//sets title page
var page_title = $('page-title').attr('name')
$('title').html(page_title);
$('page-title').remove()

//handles adding of css
$('style-url').each(function(){
    var style_element = '<link rel="stylesheet" type="text/css" href="../css/'+ $(this).attr('url') +'"></link>';
    $('stylesheet').append(style_element);
    $(this).remove();
});

//handles adding of javascripts
$('js-script').each(function(){
    var js_element = '<script type="text/javascript" src="../js/'+ $(this).attr('src') +'"></script>';
    $('scripts').append(js_element);
    $(this).remove();
});


 $(document).ready(function() {
	//sidebar
	$('.sidebar.menu').first()
	.sidebar('toggle')
  	.sidebar('attach events', '.toggle.button')
	 ;

	//end of sidebar

});