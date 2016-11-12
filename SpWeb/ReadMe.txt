The issue with this example was resolving view
Unless I did not add the dependency below, it was not able to resolve the view 

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
            <version>1.3.3.RELEASE</version>
        </dependency>

2 Also do not forgt to add tomcat jasper , otherwise no web-page wil be seen , it will be just html.