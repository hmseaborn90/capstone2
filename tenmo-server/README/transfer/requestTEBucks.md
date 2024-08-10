# RequestTEBucks

**Description** : Used to request TE Bucks from another user

**URL** : `/transfer/request`

**Method** : `POST`

**Auth required** : YES

**Data constraints**

```json
{
  "fromUserId": "integer",
  "amount": "numeric"
}
```

**Data example**

```json
{
  "fromUserId": 1002,
  "amount": 399.44
}
```

## Success Response

**Code** : `200 OK`

**No Content Returned**


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

