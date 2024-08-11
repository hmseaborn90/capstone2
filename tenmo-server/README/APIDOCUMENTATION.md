# APIDocs

---
## API BASE_URL 
** BASE_URL is the URL that will prefix all endpoints**

http://localhost/8080

---

## Open Endpoints

Open endpoints require no Authentication.

* [Login](authorization/login.md) : `POST /login`

* [Register](authorization/register.md) : `POST /register`

---

## Endpoints that require Authentication

Closed endpoints require a valid Token to be included in the header of the
request `Authorization: Bearer {token}` A Token can be acquired from the Login view above.

### User Account Related

Each endpoint manipulates or displays information related to the User whose
Token is provided with the request:

* [Get account Balance](account/getBalance.md) : `GET /account/balance`

---

### Transfer related

Endpoints for viewing and manipulating the Transfers that the Authenticated User has permissions to access.

* [Send TE Bucks](transferDetail/sendTEBucks.md) : `POST /transferDetail/send`
* [Get List of user Transfers](transferDetail/getTransfers.md) : `GET /transferDetail`
* [Get Transfer Details by ID](transferDetail/getTransferById.md) : `GET /transferDetail/{id}`
* [Request TE Bucks](transferDetail/requestTEBucks.md) : `POST /transferDetail/request`
* [Get List of pending Transfer Requests](transferDetail/getPendingTransfers.md) : `GET /transferDetail/pending/`
* [Approve or Reject Transfer Requests](transferDetail/putRejectOrApprove.md) : `PUT /transferDetail/{transfer_id}/status/`