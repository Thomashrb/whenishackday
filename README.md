# whenishackday

A micro api to discover when hackday is.

```
❯ curl localhost:8000/
When is the hackday?

# Give me the date
❯ curl localhost:8000/date
2021-07-30

# How many days till next hackday
❯ curl localhost:8000/count/days
0

# oh it is today! :)
```


NOTE:
Be aware that currently whenishackday does not account for
holydays. In the future I intend to add a POST api and a (sqlite?) database
such that certain dates can be "flagged" as not eligible  for hackdays.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running


```
# To start a web server for the application:
lein ring server

# run tests
lein test

# build standalone jarfile
lein uberjar

# run uberjar
java -jar whenishackday-<VERSION>-standalone.jar
```
