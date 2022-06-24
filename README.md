# SLIIT AF 2019 PAPER SPRING VERSION

Education purpose only

## Authors

- [@isurukavinda99](https://www.github.com/isurukavinda99)

<br>

## Tech Stack

**Server:** Spring boot, MongoDB

<br>

## Environment Variables

you need to change spring property file acoding to your database credential

Examples

`spring.data.mongodb.uri=mongodb+srv://<username>:<usi>.oycib.mongodb.net/?retryWrites=true&w=majority`
<br>

`spring.data.mongodb.database=<database name>`

<br>

## API Reference

#### Get all categories

```http
  GET /api/v2/category/
```

#### Post categoriy

```http
  POST /api/v2/category/
```


#### Get All Rooms

```http
  GET /api/v2/room/
```

#### Post Room

```http
  POST /api/v2/category/
```

#### Get Get Room By Category

```http
  POST /api/v2/room/{categoryId}
```

#### Get Get Room By Category

```http
  POST /api/v2/room/calculate-total
```

