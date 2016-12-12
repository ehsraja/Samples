
myapp.controller("loginCntrl", function ($rootScope,$scope,$location){
	
	 $scope.login = function () {
		 
		 $scope.login = function (){
			 if($scope.user == 'test' && $scope.password == 'test'){
				 $rootScope.authenticated = true;
				 $location.path('/home');
			 }
		 }
	 }       
	 
	 });
   