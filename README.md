# thappo
Simple example on how to use the restfull api

URL: localhost:8090
Headers: {"key":"Content-Type","value":"application/json","description":""}

Mapped=/v3/users; methods=GET; params=order_by_criteria, order_by_direction, limit, offset
Mapped=/v3/{userId}/user; methods=[GET] 
Mapped=/v3/user; methods=[POST]
Mapped=/v3/{userId}/user; methods=[PUT]
Mapped=/v3/{userId}/user; methods=[DELETE]


Ejemplos
/v3/{userId}/user ,methods=PUT
{
    "user_id": 2,
    "first_name": "Luciano",
    "last_name": "Charlier",
    "email": "lcharlier2@mail.com",
    "password": "1234abcd",
    "dob": 0,
    "profile": "CLIENT",
    "telephone": "1586598654"
}

Mapped=/v3/user ,methods=POST
{
    "first_name": "Luciano",
    "last_name": "Charlier",
    "email": "lcharlier2@mail.com",
    "password": "1234abcd",
    "dob": 0,
    "profile": "CLIENT",
    "state": "ACTIVE",
    "telephone": "1586598654"
}
