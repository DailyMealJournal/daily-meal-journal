//sets title page
var page_title = $('pagetitle').attr('name')
$('title').html(page_title);
$('pagetitle').remove();

var base_url = window.location.origin + '/';

//handles adding of css
$('styleurl').each(function(){
    var style_element = '<link rel="stylesheet" type="text/css" href="'+ base_url +'css/'+ $(this).attr('url') +'"></link>';
    $('sheetsstyler').append(style_element);
    $(this).remove();
});

//handles adding of javascripts
$('jsscript').each(function(){
    var js_element = '<script type="text/javascript" src="'+ base_url +'js/'+ $(this).attr('src') +'"></script>';
    $('scripts').append(js_element);
    $(this).remove();
});


 $(document).ready(function() {
    if(page_title != 'Home') {
	//sidebar
	$('.sidebar.menu')
        .addClass('visible')
        .sidebar('setting', { dimPage:  false, 
                              closable: false
                            })
	 ;
    }
	//end of sidebar

    $('.pushable').removeClass('hide');

});