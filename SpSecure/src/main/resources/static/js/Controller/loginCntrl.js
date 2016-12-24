
myapp.controller("loginCntrl", function ($rootScope,$scope,$location,AuthSharedService){
	
		 
		 $scope.login = function (){
			 AuthSharedService.login(
		                $scope.user,
		                $scope.password,
		                $scope.rememberMe
		            );
			 }
	      
	 
	 });
   