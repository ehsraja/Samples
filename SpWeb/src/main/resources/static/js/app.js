
    var app = angular.module('myApp',[]);

    app.service('NameService',function($http){
    	var config2 = null ;
    /*	var config2 = [{"profile":"common","key":"name","value":"rhl"},{"profile":"common","key":"region","value":"NY"},
	  {"profile":"common","key":"lan","value":"EN"}];
*/
	  this.list = function (){
	  	return config2 ;
	  }


      this.configList = function (){
      	return  $http.get('http://localhost:8080/config').
        then(function(response) {
            config2 = response.data;
			console.log("data is " + response.data);
			return config2 ;
        })
		
        
    }   

  }
);
	
	app.controller("myCtrl", function (NameService){
	  var m = this ;

	 /* m.config = [{"profile":"common","key":"name","value":"rhl"},{"profile":"common","key":"region","value":"NY"},
	  {"profile":"common","key":"lan","value":"EN"}];
*/
      
      m.list = function(){
      	 NameService.configList()
      	 .then ( function(data) {
      	 	      m.config = data ;
      	 		}, 
      	 		 function (errResponse){
      	 		 	console.error('Error while fetching config');
      	 		 }

      	 );
      }
	  
	//  m.config = NameService.configList();

     m.list();
     
     console.log(m.config);


	  m.creat = function (){
     	var newProfile = {'profile':m.config.profile, 'key':m.config.key, 'value':m.config.value};
     	 var  isNew = true ; 
     	 for (var i = 0; i < m.config.length ; i++) {
                 if(m.config[i].profile == newProfile.profile && m.config[i].key == newProfile.key){
                 	isNew = false ;
                     m.config[i].value = newProfile.value ;
                     break ;
                 }
     	  	 }	
     	if(isNew){
     	 	m.config.push(newProfile);
     	}
     	 m.config.profile = ""; 	
     	 m.config.key = "";
     	 m.config.value = "";  
    }


    m.edit = function(id,keyid){
	   for (var i = 0; i < m.config.length; i++) {
	   	if(m.config[i].profile == id && m.config[i].key == keyid){
	   		m.config.profile = m.config[i].profile ; 	
     	    m.config.key = m.config[i].key;
     	    m.config.value = m.config[i].value; 
	   	}
	  } 
   }

    m.remove = function(id,keyid){
	   for (var i = 0; i < m.config.length; i++) {
	   	if(m.config[i].profile==id && m.config[i].key==keyid){
	   		console.log("IN");
	   		m.config.splice(i,1);
	   		console.log(m.config);
	   	}
	   }
	  } 	

  }  
 );
