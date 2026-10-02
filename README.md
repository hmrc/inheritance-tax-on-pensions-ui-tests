# Inheritance Tax on Pensions UI Journey Tests

## Pre-requisites

### Services

If you haven't got mongo running already, start Mongo Docker container as follows:

```bash
colima start
```

Start IHTP services as follows:

```bash
sm2 --start IHTP_ALL
```

## Tests

Run tests as follows:

* Argument `<browser>` must be `chrome`, `edge`, or `firefox`.
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.

```bash
sbt clean -Dbrowser="<browser>" -Denvironment="<environment>" test testReport
```
### Other ways to run the Tests

Go to [run-tests.sh](run-tests.sh) and click on the play button to run the tests.

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
