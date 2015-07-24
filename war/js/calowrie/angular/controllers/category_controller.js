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