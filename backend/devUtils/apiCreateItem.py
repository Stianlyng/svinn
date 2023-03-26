
import json
import requests

url = "http://localhost:8080/api/v1/items" 
headers = {"Content-Type": "application/json"}

item_data = {
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

response = requests.post(url, headers=headers, data=json.dumps(item_data))

if response.status_code == 200:
    print("Item created successfully:")
    print(json.dumps(response.json(), indent=2))
else:
    print(f"Error creating item: {response.status_code}")
    print(response.text)