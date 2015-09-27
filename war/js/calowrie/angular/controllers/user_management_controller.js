var user_management = angular.module("myProfile", []);
user_management.controller('editAccount', ['$scope','$http', function($scope, $http){
	$scope.field = true;
	$scope.editField = false;
	$scope.editButton = true;
	$scope.saveButton = false;
	$scope.cancelButton = false;
	
	$scope.toggleFields = function(){
		$scope.field = !($scope.field);
		$scope.editField = !($scope.editField);
		$scope.editButton = !($scope.editButton);
		$scope.saveButton = !($scope.saveButton);
		$scope.cancelButton = !($scope.cancelButton);
	}

    $scope.preupdateClick = function() {
    	var readAccount = $http.get('read',
    			{
			params: { 
					selection: 'all' 
				}
		}
    	readAccount.success(function(data, status, headers, config) {
			$scope.userData  =  data.user;
			
		});

    	readAccount.error(function(data, status, headers, config) {

		});

	);
    	
    };

    $scope.userProfile = {
            id: session_data['id'],
            image: $scope.userData['username'],
            firstName: $scope.userData['firstname'],
            lastName: session_data['last_name'],
    		username: session_data['user_name']
        }
    
    
    $scope.editAccountModel = {id:$scope.userProfile.id, username:"", password:"",
    						   firstname: "", lastname:""}
    
    
    
    $scope.updateClick = function() {
    	alert($scope.editAccountModel.id);
//    	$scope.errorDisplay = "";
//    	alert("inside update click"+username);
//    	var jsonData = {
//    			id: id,
//    			username: document.getElementById(username+id).value,
//    			password: document.getElementById(password+id).value,
//    			firstname: document.getElementById(firstname+id).value,
//    			lastname: document.getElementById(lastname+id).value
//    	};
//
//    	alert(document.getElementById(username+id).value);
//    	$httpParamSerializer
    	
    	
//    	var updateAccount = $http.post('update', $.param($scope.editAccountModel),
//
//    			{
//    				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
//    			}
//    		);

//    	
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

