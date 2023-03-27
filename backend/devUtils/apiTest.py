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

itemBody = {
    "briefDescription": "Example Item",
    "fullDescription": "This is an example item.",
    "price": 100,
    "createdAt": "2023-03-26T10:00:00",
    "updatedAt": "2023-03-26T10:00:00",
    "category": {
        "id": 1
    },
    "location": {
        "id": 1
    },
    "user": {
        "id": 1
    }
}

bookmarkBody = {
    "userId": 1,
    "itemId": 1
}

messageBody = {
    "content": "Hey, is the bike still available?",
    "itemId": 1,
    "senderId": 1,
    "receiverId": 2
}





## REQUESTS

token = requests.post("http://localhost:8080/api/auth/register", json=registerBody).json()["token"]

authHeader={"Authorization": f"Bearer {token}"}

# Categories
def categories(): return requests.get("http://localhost:8080/api/categories", headers=authHeader).json()
def addCategory(): return requests.post("http://localhost:8080/api/categories", headers=authHeader, json=catBody).json()
def deleteCategory(id): return requests.delete(f"http://localhost:8080/api/categories/{id}", headers=authHeader)
def updateCategory(id): return requests.put(f"http://localhost:8080/api/categories/{id}", headers=authHeader, json=catBody).json()

# Locations
def locations(): return requests.get("http://localhost:8080/api/locations", headers=authHeader).json()
def addLocation(): return requests.post("http://localhost:8080/api/locations", headers=authHeader, json=locBody).json()
def deleteLocation(id): return requests.delete(f"http://localhost:8080/api/locations/{id}", headers=authHeader)
def updateLocation(id): return requests.put(f"http://localhost:8080/api/locations/{id}", headers=authHeader, json=locUpdBody).json()

# Items
def items(): return requests.get("http://localhost:8080/api/items", headers=authHeader).json()
def addItem(): return requests.post("http://localhost:8080/api/items", headers=authHeader, json=itemBody).json()

# Bookmarks
def bookmarks(): return requests.get("http://localhost:8080/api/bookmarks", headers=authHeader).json()
def addBookmark(): return requests.post("http://localhost:8080/api/bookmarks", headers=authHeader, json=bookmarkBody).json()

# Messages
def messages(): return requests.get("http://localhost:8080/api/messages", headers=authHeader).json()
def addMessage(): return requests.post("http://localhost:8080/api/messages", headers=authHeader, json=messageBody).json()


# Token
print(f"Token:\n{token}\n")

## Categories
#print(f"{'x'*50}\nx\nx   CATEGORY\nx\n{'x'*50}\n")
#print(f"Categories:\n{categories()}\n")
#print(f"Add category:\n{addCategory()}\n")
#print(f"Delete category 1:\n{deleteCategory(categories()[0]['id'])}\n")
#print(f"The first category:\n{categories()[0]}\n")
#print(f"Update category:\n{updateCategory(int(categories()[0]['id']))}\n")
#
## Locations
#print(f"{'x'*50}\nx\nx   LOCATION\nx\n{'x'*50}\n")
#print(f"Locations:\n{locations()}\n")
#print(f"Add location:\n{addLocation()}\n")
#print(f"Delete location:\n{deleteLocation(locations()[0]['id'])}\n")
#print(f"The first location:\n{locations()[0]}\n")
#print(f"Update location:\n{updateLocation(int(locations()[0]['id']))}\n")

# Items
print(f"{'x'*50}\nx\nx   ITEM\nx\n{'x'*50}\n")
print(f"Items:\n{items()[-1]}\n")
print(f"Add item:\n{addItem()}\n")
## Bookmarks
#print(f"{'x'*50}\nx\nx   BOOKMARK\nx\n{'x'*50}\n")
#print(f"Bookmarks:\n{bookmarks()}\n")
#print(f"Add bookmark:\n{addBookmark()}\n")
#
## Messages
#print(f"{'x'*50}\nx\nx   MESSAGE\nx\n{'x'*50}\n")
#print(f"Messages:\n{messages()}\n")
#print(f"Add message:\n{addMessage()}\n")