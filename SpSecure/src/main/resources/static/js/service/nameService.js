 myapp.service('NameService',function($http,$q){
    var config2 = null ;
    
	  this.list = function (){
	  	return config2 ;
	  }


      this.configList = function (){
    	  var deferred = $q.defer();
      	  $http.get('/config')
        .then(function(response) {
            config2 = response.data;
			console.log("data is " + response.data);
			deferred.resolve(response.data);
			 config2 ;
        },
        function(errResponse){
            console.error('Error while fetching Users');
            deferred.reject(errResponse);
        });
       return deferred.promise;
    }
      
      this.addConfig = function (config) {
    	  var deferred = $q.defer();
    	    $http.post('/addConfig', config)
              .then( function (response) {
            	  console.log("success");
            	  deferred.resolve(response);
            	//  return response ;
              },
              function(errResponse){
                  console.error('Error while fetching Users');
                  deferred.reject(errResponse);
              });
         
    	    return deferred.promise;
      }
      
      
      this.removeConfig = function (profile, key){
    	  return $http.delete('/deletConfig/'+profile+'/'+key)
    	  .then( function (response) {
           console.log("success");
            return response ;
      });
    }
  }
);