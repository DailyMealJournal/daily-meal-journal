meal_management.controller('MealsController', ['$scope', '$http', function($scope, $http) {
	$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8'
    
	$scope.addMealModel = {name:"", category:"", def_quantity:"", 
					 	   unit:"", calories:"", description:"", picture:"", 
					 	   error:""}; 
		
	$scope.displayAddMealModel = function(){
		$scope.addMealModel.picture = $("#meal_picture").val();
		
		alert($scope.addMealModel.picture);
	}
	
	$scope.addMeal = function(){
		$scope.addMealModel.picture = $("#meal_picture").val();
		
		var addMealRequest = $http.post("create", $.param($scope.addMealModel));
		
		addMealRequest.success(function(data, status, headers, config){
			if(data.errors.length == 0){
				$(".add-field").attr("value","");
				
				$scope.getAllMeals();
				$("#modal_add_new_meal").closeModal();
			} else{
				$scope.addMealModel.error = data.errors;
			}
		});
		
		addMealRequest.error(function(data, status, headers, config){

		});
	}
	
	$scope.init = function(){
		this.getAllMeals();
	}
	
	$scope.displayEditMealModel = function(){
//		$scope.addMealModel.picture = $("#meal_picture").val();
		
		var text = $scope.editMealModel.id + 
			$scope.editMealModel.name +
			$scope.editMealModel.category + 
			$scope.editMealModel.def_quantity + 
			$scope.editMealModel.unit +
			$scope.editMealModel.calories +
			$scope.editMealModel.description + 
			$scope.editMealModel.picture;
		
		alert(text);
	}
	
	$scope.id = null;
	
	/*$scope.preDelete = function(id){
		$("#btn_delete_meal").attr("ng-click", "deleteMeal(" + id + ")");
	}*/
    
	
	$scope.editMealModel = {id:"", name:"", category:"", def_quantity:"",
						    unit:"", calories:"", description:"", picture:"",
		 					errors:""};

	$scope.preEdit = function(id){
		var jsonData = {
				selection : "single",
				id: id
		}
		
		var mealRequest = $http.get("read", {params:jsonData});
	    
		mealRequest.success(function(data, status, headers, config) {
			if(data.meal[0] != null){
				$scope.editMealModel = data.meal[0];
			}
			
			$(".label_edit").addClass("active");
			var selectOptions = $("#form_edit_meal .editSelectOption");
			
			for(var i = 0; i < 8; i++){
				console.log(selectOptions[i]);
				if(selectOptions[i].value != $scope.editMealModel.category){
					selectOptions[i].selected = "false";
				} else{
					selectOptions[i].selected = "selected";
				}
			}
			
			$("#modal_edit_meal").openModal();
		});
		mealRequest.error(function(data, status, headers, config) {

		});	
	}
	
	$scope.editMeal = function(){				
		var editMealRequest = $http.post("update", $.param($scope.editMealModel));
		
		editMealRequest.success(function(data, status, headers, config){
			if($.isEmptyObject(data.errors) || data.errors.length == 0){
				$scope.getAllMeals();
				$("#modal_edit_meal").closeModal();
				$scope.editMealModel = [];
			} else{
				$scope.editMealModel.errors = {};
				if(typeof(data.errors) == 'string') {
					$scope.editMealModel.errors = data.errors;
				} else {
					$scope.editMealModel.errors = data.errors[0];
				}
			}
		});
		
		editMealRequest.error(function(data, status, headers, config){
			
		});
	}
	
	$scope.deleteMealModel = {id:""}
	
	$scope.preDelete = function(id){
		$scope.deleteMealModel.id = id;
		$("#modal_delete_meal").openModal();
	}
	
    $scope.deleteMeal = function(){
    	var jsonData = {
    		id:$scope.deleteMealModel.id
    	};
    	
    	var mealDelete = $http.post("delete", $.param(jsonData));
        
        mealDelete.success(function(data, status, headers, config) {
        	$scope.getAllMeals();
        	$("#modal_delete_meal").closeModal();        	
        	
		});
        
        mealDelete.error(function(data, status, headers, config) {

		});	
    }
	
    $scope.meals = [];
	$scope.getAllMeals = function(){
		var jsonData = {
				selection: "all"
        };
		
		var mealsRequest = $http.get("read", {params: {selection: "all"}});
	    
		mealsRequest.success(function(data, status, headers, config) {
            var meal_list = data.mealList;
            for(var i in meal_list){
                if(meal_list[i].picture == ""){
                    meal_list[i].picture = "/assets/img/food/pic10.jpg";
                }
            }
            
			$scope.meals = meal_list;
			/*if(data.errorList.length == 0) {
				$scope.meals = data.mealList;
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				$scope.errorDisplay = msg;
			}*/
		});
		mealsRequest.error(function(data, status, headers, config) {

		});	
	}

					/*{
						Picture: base_url + 'assets/img/food/k8.jpg',
						MealName: 'Sushi',
						CalorieCount: 40,
						Unit: 'per piece',
						Description: 'Classic Japanese Cuisine. Raw and unsavory flavor, tread carefully or else.'
					},

					{
						Picture: base_url + 'assets/img/food/g4.jpg',
						MealName: 'Skewered Pork Salad',
						CalorieCount: 200,
						Unit: 'per serving',
						Description: 'This dish is carefully constructed salad that provides plenty of nutrients by the day.'
					},

					{
						Picture: base_url + 'assets/img/food/g1.jpg',
						MealName: 'Roasted Chicken Salad',
						CalorieCount: 110,
						Unit: 'per serving',
						Description: 'This dish is carefully constructed salad that provides plenty of nutrients by the day.'
					},

					{
						Picture: base_url + 'assets/img/food/pic10.jpg',
						MealName: 'Assorted Fruit Salad',
						CalorieCount: 110,
						Unit: 'per serving',
						Description: 'Cleanse your body with fruit diet. Perfectly sustainable nutrients for short term diet cleansing.'
					},

*/
				  

}]);

meal_management.controller('MealCategoryController', ['$scope', function($scope) {
	$scope.categories = [
							{
								image: base_url + 'assets/img/icons/32px/61.png',
								name: 'Poultry',
								filters: ['Chicken', 'Duck']
							},
                            {
								image: base_url + 'assets/img/icons/32px/66.png',
								name: 'Meat',
								filters: ['Beef', 'Pork']
							},
                            {
								image: base_url + 'assets/img/icons/32px/127.png',
								name: 'Seafood',
								filters: ['Fish', 'Crab']
							},
                            {
								image: base_url + 'assets/img/icons/32px/51.png',
								name: 'Fruits & Vegetables',
								filters: ['Apples', 'Mangoes', 'Carrots', 'Potatoes']
							},
                            {
								image: base_url + 'assets/img/icons/32px/57.png',
								name: 'Dairy',
								filters: ['Milk', 'Yogurt', 'Cheese']
							},
                            {
								image: base_url + 'assets/img/icons/32px/122.png',
								name: 'Dessert',
								filters: ['Chocolate', 'Ice Cream']
							},
                            {
								image: base_url + 'assets/img/icons/32px/100.png',
								name: 'Beverage',
								filters: ['Protein Shake', 'Fruit Shake', 'Wine', 'Soda']
							},
                            {
								image: base_url + 'assets/img/icons/32px/143.png',
								name: 'Snacks',
								filters: ['Chips', 'Fries']
                            }
						];
}]);

meal_management.directive('backImg', function(){
    return function(scope, element, attrs){
        attrs.$observe('backImg', function(value) {
            element.css({
                'background-image': 'url(' + value +')',
                'background-size' : 'cover'
            });
        });
    };
});