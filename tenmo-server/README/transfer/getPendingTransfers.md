# GetPendingTransfers

---

**Description** : Used to retrieve a list of pending transfers requests for user

**URL** : `/transfers/pending`

**Method** : `GET`

**Auth required** : YES

**No Body Required**

---

## Success Response

**Code** : `200 OK`

**Content example**
```json
[
  {
    "transferId": "2001 (integer)",
    "toUser": "Anya (string)",
    "amount": "100.00 (numeric)"
  },
  {
    "transferId": "2003 (integer)",
    "toUser": "George (string)",
    "amount": "333.33 (numeric)" 
  }
]
```

---

## Error Response
[//]: # ()
[//]: # (TODO Figure out error Response possibilities)

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
