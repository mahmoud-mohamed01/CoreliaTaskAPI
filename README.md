# Corelia Task 
Java Spring Boot back-end app for user registration and contact management. Users can sign up, sign in, and manage their address book


# How to run the app
install the app and open it on the intellj ide and make sure to but your localhost databse connection url to on the application.properties file <br>

# Api Doc

● All endpoint are private except 2 endpoints login nad registeration

- <h2>auth</h2> <br>
● Register
POST api/register
json body ex:{
"email": "booking.hr@booking.com",
"password":"123456",
"country":"uk"
}
<br>
● Login
PUT api/login
json body ex:{
"email": "booking.hr@booking.com",
"password":"123456"}


- <h2>Contact</h2> <br>
● Add Contact <br>
 POST api/accounts/contacts 
json body ex :{
"firstName":"omar",
"lastName":"amir",
"phoneNumber":"123456",
"email":"omar@booking.com",
"birthdate":"1997-04-01"
}
<br>


● update contact <br>
 PUT api/accounts/contacts/{contactid}
<br>

● get all contacts <br>
 GET api/accounts/contacts
optional params{
sortOrder,
pageSize,
sortBy,
pageNumber    
}
<br>

● get contact by id <br>
 GET api/accounts/contacts/{contactid}

<br>
● get contacts by accountId <br>
 GET api/accounts/{accountId}/contacts
<br> 
<br>


● delete contact by id <br>
 DELETE api/accounts/contacts/{contactId}

# Technologies used
- Java <br>
- Spring boot <br>
- PostgreSQL <br>
- spring data jpa <br>
- spring security <br>
- JWT <br>
- spring validation <br>
