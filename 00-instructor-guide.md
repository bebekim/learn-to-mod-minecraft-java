# Instructor Guide

This document is for the adult. Luke works from the lesson READMEs.

## Teaching Shape

This is not a bottom-up Java course. The order is:

1. Make Minecraft do something visible.
2. Name the Java concept that made it possible.
3. Write or keep one tiny check when logic becomes non-trivial.
4. Refactor only after the feature works.

## Course Influences

- HTDC gives the design recipe: information, representation, examples, method purpose, implementation.
- MIT 6.005 gives the engineering habits: safe from bugs, easy to understand, ready for change.
- Java by Comparison gives the cleanup move: compare working code to better Java and improve it in small steps.

## Feedback Loops

Minecraft has several loops. Teach the fastest one that fits the change.

```text
Resource change -> F3+T -> inspect
Data change -> restart world or run command -> inspect
Java rule change -> Gradle runClient -> lab command -> inspect
Plain Java logic -> unit test -> then connect to Minecraft
```

The course should bias toward the lab command loop. Do not let a lesson become a scavenger hunt through survival Minecraft.

## Week 1 Adult Checkpoint

Luke is ready to continue when he can show:

- Java 21 on Windows.
- The repo cloned under `Documents\game-dev`.
- `active-mod` opened in IntelliJ.
- `gradlew.bat build` finishes successfully.
- Minecraft launched from the Gradle `runClient` task.
- Joining the world prints the mod message in chat.
- One visible text edit was made, built, and observed.

## Basic Build Commands

Windows:

```powershell
cd Documents\game-dev\learn-to-mod-minecraft-java\active-mod
.\gradlew.bat build
.\gradlew.bat runClient
```

Mac:

```bash
cd ~/repositories/game/learn-to-mod-minecraft-java/active-mod
export JAVA_HOME=/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home
./gradlew build
./gradlew runClient
```

Use command-line Gradle first when diagnosing setup. IntelliJ is friendlier once the formal build works.

## What To Leave Alone

- Do not teach every Gradle file yet.
- Do not explain Fabric registries before Luke needs an item.
- Do not introduce mixins in setup.
- Do not add lab commands until there are two commands worth sharing.

Skipped complexity is intentional. Add it when a visible mechanic needs it.
