$('title').html($('page-title').attr('name'));

$('style-url').each(function(){
    var style_element = '<link rel="stylesheet" type="text/css" href="../css/'+ $(this).attr('url') +'" />';
    $('style').append(style_element);
    $(this).remove();
});


$('js-script').each(function(){
    var js_element = '<script type="text/javascript" src="../js/'+ $(this).attr('src') +'"></script>';
    $('scripts').append(js_element);
    $(this).remove();
});