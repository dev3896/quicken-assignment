# Quicken Assignment - Devesh

## How to Run

Make sure you have Java installed.

To start the application, run:

```sh
./gradlew bootRun
```

Or on Windows:

```sh
gradlew.bat bootRun
```

The application will start on [http://localhost:8080](http://localhost:8080).

## Sample API Usage

### Create a Product

**POST** `/products`

**Request Body:**
```json
{
  "name": "Sample Product",
  "price": 19.99
}
```

**Curl:**
```sh
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Sample Product","price":19.99}'
```

---

### Create an Order

**POST** `/orders`

**Request Body:**
```json
{
  "productId": 1
}
```

**Curl:**
```sh
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"productId":1}'
```

---

### Get Order

**GET** `/orders/{id}`

**Curl:**
```sh
curl http://localhost:8080/orders/1
```

---

## Using Postman

1. Import the above endpoints into Postman.
2. Set the request type (GET/POST).
3. For POST requests, set the body to `raw` and select `JSON`.
4. Use the sample JSON payloads above.
