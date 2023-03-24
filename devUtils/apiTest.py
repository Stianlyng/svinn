import requests
import json
import random

randInt = random.randint(0, 100000)

# BODIES ;)

registerBody = {
    "firstname": "user",
    "lastname": "name",
    "email": f"mail{randInt}@mail.no",
    "password": "password456"
}

addCatBody = {
    "name": "Fisk",
    "description": "yeyeye"
}

## REQUESTS

token = requests.post("http://localhost:8080/api/v1/auth/register", json=registerBody).json()["token"]

def GET(url, body=None, header={"Authorization": f"Bearer {token}"}):
    return requests.get(url,headers=header,json=body).json()

def POST(url, body=None, header={"Authorization": f"Bearer {token}"}):
    return requests.post(url,headers=header,json=body).json()

def DEL(url, body=None, header={"Authorization": f"Bearer {token}"}):
    return requests.delete(url,headers=header).json()

categories = GET("http://localhost:8080/api/v1/categories")
addCategory = POST("http://localhost:8080/api/v1/categories",body=addCatBody)

print(f"Token:\n{token}\n")
print(f"Categories:\n{categories}\n")
print(f"Add category:\n{addCategory}\n")

