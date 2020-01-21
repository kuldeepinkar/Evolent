# Evolent

Download the project from " https://github.com/kuldeepinkar/Evolent  " repository and import it in eclipse IDE and Go to ContactInfoApplication.java file and  run as a java application.

For UI Testing:

Go to URL : http://localhost:9090/index.html

Note: In Application.properties I have changed the port to 9090.

For REST API Testing

Download or add Postman pluggin.

1)Fot creating contact :

URI: http://localhost:9090/contacts/
Method : POST

Body : 
{
"firstName":"Kuldeep",
"lastName":"Inkar",
"email":"kuldeep@gmail.com",
"phoneNumber":9970724641,
"active":true
}

2)For getting all contacts :

URI: http://localhost:9090/contacts/{id}
Method : GET

3)For getting particular contact:
 
 URI: http://localhost:9090/contacts/{id}
Method : GET

4) For updating particulat contact :

URI: http://localhost:9090/contacts/{id}
Method : PUT

Body : 
{
"firstName":"Kuldeep",
"lastName":"Inkar",
"email":"kuldeep@yahoo.com",
"phoneNumber":9970724641,
"active":true
}

5) For Deleting particular contact :

URI: http://localhost:9090/contacts/{id}
Method : DELETE

