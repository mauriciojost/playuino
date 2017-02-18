# Play Framework RESTful API written in Scala

## Start the application

To start the application:

```
./activator run
```

And then:

```
http://localhost:9000
```

To use the REST API:

```
curl -X POST -H "Content-Type: application/json" http://localhost:9000/dev/device/actor/body/status -d '{"prop" : "val", "prop1" : "val3"}'
curl -X GET -H "Content-Type: application/json" http://localhost:9000/dev/device/actor/body/status

```
