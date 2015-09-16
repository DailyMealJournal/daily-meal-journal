//sets title page
var page_title = $('pagetitle').attr('name')
$('title').html('Calowrie - ' + page_title);
$('.page-title').html(page_title);
$('pagetitle').remove();

var base_url = window.location.origin + '/';
if(typeof $('#session_data') != 'undefined')
{
    var session_data = {};
    var idx = 0;
    $('#session_data').children().each(function(){
        var index = (typeof $(this).attr('index-val') != 'undefined' && $(this).attr('index-val') != '') ? $(this).attr('index-val') : idx++;
        if($(this).attr('value') != '') {
            session_data[index] = $(this).attr('value');
        }
    })

    //remove to prevent data from being seen.
    $('#session_data').empty().remove();
}
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
 var a_modules = [];
 $('[ng-module]').each(function() {
    a_modules.push($(this).attr('ng-module'));
 });
 

 $.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};


 var app = angular.module('Calowrie', a_modules);

 $(document).ready(function() {
    if(page_title == 'Home') {
	//sidebar
        $('.side-nav').addClass('hide');
        $('.top-nav').addClass('hide');
    }else{
        $('.button-collapse').sideNav({
            menuWidth: 300, // Default is 240
            edge: 'left', // Choose the horizontal origin
            closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
        });
    }
	//end of sidebar


    $('.pushable').removeClass('hide');
});

 var sidebar = angular.module("sidebar", []);

 var global_user_id = session_data['id'];

sidebar.controller('SidebarController', ['$scope', function($scope) {
        session_data['image_url'] = (typeof session_data['image_url'] != 'undefined') ? session_data['image_url']: 'img/team-1.jpg';

        $scope.sidebarProfile = {
                                    id: session_data['id'],
                                    image: base_url + 'assets/' + session_data['image_url'],
                                    firstName: session_data['first_name'],
                                    lastName: session_data['last_name']
                                }

}]);

/**
app.directive('backImg', function(){
    return function(scope, element, attrs){
        attrs.$observe('backImg', function(value) {
            element.css({
                'background-image': 'url(' + value +')',
                'background-size' : 'cover'
            });
        });
    };
});
**/