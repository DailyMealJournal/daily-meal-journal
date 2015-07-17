//sets title page
var page_title = $('pagetitle').attr('name')
$('title').html('Calowrie -' + page_title);
$('.page-title').html(page_title);
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
 var app = angular.module('Calowrie', ['sidebar', 'myMeals']);

 $(document).ready(function() {
    if(page_title == 'Home') {
	//sidebar
        $('.side-nav').addClass('hide');
    }
	//end of sidebar


    $('.pushable').removeClass('hide');
});

 var sidebar = angular.module("sidebar", []);

sidebar.controller('SidebarController', ['$scope', function($scope) {
        $scope.sidebarProfile = {
                                    image: base_url + 'assets/img/team-1.jpg',
                                    firstName: 'John',
                                    lastName: 'Doe'
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