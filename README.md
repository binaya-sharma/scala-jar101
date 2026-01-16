## Project Structure

```
.
├── build.sbt
├── project/
│   └── plugins.sbt
└── src/
    └── main/
        └── scala/
            └── MainApp.scala
```

## Create JAR (Scala + sbt)

```bash
sbt clean assembly
```

This generates the JAR at:

```
target/scala-2.13/basic-spark-jar.jar
```
