# Jason Web Token Security

## Securing endpoints with JWT

### Problem
All the endpoints are available for the users, even the ones that contain sensible information
like the user's info, or the admin dashboard, etc.

### Solution
Secure the endpoints with the built-in support for JWTs using oAuth2 Resource Server. 

With this method we can verify if the JWT client generated is valid and authorize the following requests.

## JWT - Username and password

### Problem 
Using the HttpBasic might have some limitations, for example:

We want just send a username and a password in the request body to the Token generator, authenticate against that, 
and just  get back the token.
Until now, with the httpBasic we needed 2 steps to validate and get the JWT: 
1. We log in with the basic authentication headers, and then we get a JWT
2. After receiving the JWT, we would use it by putting it in the header of the following requests

### Solution

Defining our own authentication manager to manage the client request with the credentials within it. 
We want to send the username and password to the Token Generator Service and verify in the same request if the 
credentials are valid, if so, we send in the response the token

