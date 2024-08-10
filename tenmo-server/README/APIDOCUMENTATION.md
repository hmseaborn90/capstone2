# APIDocs

## API BASE_URL 
** BASE_URL is the URL that will prefix all endpoints**

http://localhost/8080

## Open Endpoints

Open endpoints require no Authentication.

* [Login](login.md) : `POST /login`
* 
* [Register](register.md) : `POST /register`

## Endpoints that require Authentication

Closed endpoints require a valid Token to be included in the header of the
request `Authorization: Bearer {token}` A Token can be acquired from the Login view above.

### User Account Related

Each endpoint manipulates or displays information related to the User whose
Token is provided with the request:

* [Get account Balance](account/getBalance) : `GET /account/balance`

### Transfer related

Endpoints for viewing and manipulating the Transfers that the Authenticated User has permissions to access.

* [Send TE Bucks](transfer/sendTEBucks.md) : `POST /transfer/send`
* [Create Account](accounts/post.md) : `POST /accounts/`
* [Show An Account](accounts/pk/get.md) : `GET /api/accounts/:pk/`
* [Update An Account](accounts/pk/put.md) : `PUT /api/accounts/:pk/`
* [Delete An Account](accounts/pk/delete.md) : `DELETE /api/accounts/:pk/`