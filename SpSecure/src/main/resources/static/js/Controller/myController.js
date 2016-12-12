	myapp.controller("mainCntrl", function (NameService){
	  var m = this ;

      
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
	  	

     m.list();
    

     m.creat =  function(){
    	 var newProfile = {'profile':m.config.profile, 'key':m.config.key, 'value':m.config.value};
    	 console.log("Adding new Config " + newProfile)
    	 NameService.addConfig(newProfile)
    	 .then (m.list(),function (errResponse){
	 		 	console.error('Error while adding config');
	 		 }
 	 	     ); 
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

 
    
    m.remove = function (profile,key){
    	NameService.removeConfig(profile,key)
    	 .then (m.list(),function (errResponse){
	 		 	console.error('Error while adding config');
	 		 }
	 	     ); 	
    }
  }

 );
