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

catBody = { "name": "newname", "description": "yihaa!" }
locBody = { "name": "Molde", "description": "Fin plass!", "latitude": "2.2", "longtitude": "4.4" }
locUpdBody = { "name": "Finland", "description": "heavy metal", "latitude": "2.2", "longtitude": "4.4" }

## REQUESTS

token = requests.post("http://localhost:8080/api/v1/auth/register", json=registerBody).json()["token"]

authHeader={"Authorization": f"Bearer {token}"}


def categories(): return requests.get("http://localhost:8080/api/v1/categories", headers=authHeader).json()
def addCategory(): return requests.post("http://localhost:8080/api/v1/categories", headers=authHeader, json=catBody).json()
def deleteCategory(id): return requests.delete(f"http://localhost:8080/api/v1/categories/{id}", headers=authHeader)
def updateCategory(id): return requests.put(f"http://localhost:8080/api/v1/categories/{id}", headers=authHeader, json=catBody).json()

def locations(): return requests.get("http://localhost:8080/api/v1/locations", headers=authHeader).json()
def addLocation(): return requests.post("http://localhost:8080/api/v1/locations", headers=authHeader, json=locBody).json()
def deleteLocation(id): return requests.delete(f"http://localhost:8080/api/v1/locations/{id}", headers=authHeader)
def updateLocation(id): return requests.put(f"http://localhost:8080/api/v1/locations/{id}", headers=authHeader, json=locUpdBody).json()


print(f"Token:\n{token}\n")
print(f"{'x'*50}\nx\nx   CATEGORY\nx\n{'x'*50}\n")
print(f"Categories:\n{categories()}\n")
print(f"Add category:\n{addCategory()}\n")
print(f"Delete category 1:\n{deleteCategory(categories()[0]['id'])}\n")
print(f"The first category:\n{categories()[0]}\n")
print(f"Update category:\n{updateCategory(int(categories()[0]['id']))}\n")


print(f"{'x'*50}\nx\nx   LOCATION\nx\n{'x'*50}\n")
print(f"Locations:\n{locations()}\n")
print(f"Add location:\n{addLocation()}\n")
print(f"Delete location:\n{deleteLocation(locations()[0]['id'])}\n")
print(f"The first location:\n{locations()[0]}\n")
print(f"Update location:\n{updateLocation(int(locations()[0]['id']))}\n")
