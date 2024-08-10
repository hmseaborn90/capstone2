# GetTransferById

---

**Description** : Used to retrieve transfer details by transfer_id

**URL** : `/transfer/{id}`

**Method** : `GET`

**Auth required** : YES

**No Body Required**

**URL Params Required** : id (integer): Id of transfer to retrieve

---

## Success Response

**Code** : `200 OK`

**Content example**
```json
{
  "transferId": "2001 (integer)",
  "fromUser": "Harrison (string)",
  "toUser": "Anya (string)",
  "type": "Send (string)",
  "status": "Approved (string)",
  "amount": "543.33 (numberic)"
}
```
---
## Error Response
TODO Figure out error Response possibilities
[//]: # ()


[//]: # (**Condition** : User does not have sufficient funds to complete transfer)

[//]: # ()
[//]: # (**Code** : `400 BAD REQUEST`)

[//]: # ()
[//]: # (**Content** :)

[//]: # ()
[//]: # (```json)

[//]: # ({)

[//]: # (  "timestamp": "2024-08-10T00:30:19.725+00:00",)

[//]: # (  "status": 400,)

[//]: # (  "error": "Insufficient Funds",)

[//]: # (  "message": "Account does not have sufficient funds to complete this transfer",)

[//]: # (  "path": "/transfer/send")

[//]: # (})

[//]: # (```)
