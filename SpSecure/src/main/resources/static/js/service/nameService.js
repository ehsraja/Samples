 myapp.service('NameService',function($http){
    var config2 = null ;
    
	  this.list = function (){
	  	return config2 ;
	  }


      this.configList = function (){
      	return  $http.get('/config')
        .then(function(response) {
            config2 = response.data;
			console.log("data is " + response.data);
			return config2 ;
        }) 
    }
      
      this.addConfig = function (config) {
    	  return  $http.post('/addConfig', config)
              .then( function (response) {
            	  console.log("success");
            	  return response ;
              }
          );
         
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