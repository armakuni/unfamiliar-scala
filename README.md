# Unfamiliar Scala Features

If you are coming to Scala from other languages, there are a few things that might not be familiar.
This repository contains some examples to introduce you.

Note: Examples are using Scala 2

## Recommended Order

1. [Placeholders](./src/main/scala/Placeholders.scala)
2. [Currying](./src/main/scala/Currying.scala)
3. [InfixNotation](./src/main/scala/InfixNotation.scala)
4. [OOPStuff](./src/main/scala/OOPStuff.scala)
5. [CaseClasses](./src/main/scala/CaseClasses.scala)
6. [Implicits](./src/main/scala/Implicits.scala)
7. [ForComprehensions](./src/main/scala/ForComprehensions.scala)

## Running

Scala project typically use the [sbt](https://www.scala-sbt.org/) tool to maintain dependencies and build configurations.
It's primary configuration lives in [build.sbt](./build.sbt) in your project root.

You can run `sbt run` to run your project (since there are multiple `main` functions in this project, you will be given an option on which to run).

### sbt shell
You can also just run `sbt` to start up the *sbt shell*.

Here you can execute `run` to re-run the code without waiting for sbt to restart.

You can also use the `reload` command to load any changes.

You can also use `runMain Placeholders` to specifically run the `main` function in the `Placeholders` object.

If you prefix any command with a `~` (e.g. `~runMain Impicits`) then *sbt* will watch for file changes and automatically re-run the command.

There are plenty of other *sbt* commands and you can define build targets, for example `test` would run tests if there were any.
