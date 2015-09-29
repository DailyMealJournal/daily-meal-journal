var user_management = angular.module("myProfile", []);
user_management.controller('editAccount', ['$scope','$http', function($scope, $http){
		$scope.field = true;
		$scope.editField = false;
		$scope.editButton = true;
		$scope.saveButton = false;
		$scope.cancelButton = false;
		
		$scope.userProfile = {
	            id: session_data['id'],
	            username: session_data['user_name'],
	            firstName: session_data['first_name'],
	            lastName: session_data['last_name'],
	    		password: session_data['password']
	        }

		$scope.userId = {id: session_data['id']};
		$scope.toggleFields = function(){
	    	var readAccount = $http.post('read', $.param($scope.userId),
		    		{
						headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		    		}		
		    	);
		    	readAccount.success(function(data, status, headers, config) {
					$scope.userData  =  {id: data.user, username: data.username, password: data.password, firstName: data.firstName, lastName: data.lastName}

		    	});

		    	readAccount.error(function(data, status, headers, config) {
				});
	    	
			$scope.field = !($scope.field);
			$scope.editField = !($scope.editField);
			$scope.editButton = !($scope.editButton);
			$scope.saveButton = !($scope.saveButton);
			$scope.cancelButton = !($scope.cancelButton);
		}

		
	    $scope.editAccountModel = {id:$scope.userProfile.id, username:$scope.userProfile.username, password:$scope.userProfile.password,
				   firstname: $scope.userProfile.firstName, lastname:$scope.userProfile.lastName}

	    $scope.updateClick = function() {
	    	alert($scope.editAccountModel.id);
	
	//    	alert(document.getElementById(username+id).value);
	//    	$httpParamSerializer
	    	
	    	
	    	var updateAccount = $http.post('update', $.param($scope.editAccountModel),
	
	    			{
	    				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	    			}
	    		);
	
	    	
	//    	alert("after");
	//    	
	    	updateAccount.success(function(data, status, headers, config) {
	    		alert(data.errors);
	    		
	//    		alert("lalal inside");
	//    		if(data.errorList.length == 0) {
	//    			alert('Entry updated successfully!');
	//    		} else {
	//    			var msg = "";
	//    			for (var i = 0; i < data.errorList.length; i++)
	//    				msg += data.errorList[i] + "\n";
	//    			$scope.errorDisplay = msg;
	//    		}
	    	});
	    	updateAccount.error(function(data, status, headers, config) {
	    		
	    	});
	    };    
	    


}]);

