# 01 - Setup the Mod Lab

## Mission

Launch Minecraft with Luke's mod loaded, join a world, and change the message that appears in chat.

## New Idea

Java catches many mistakes before Minecraft starts. Python lets a name point at a new type later; Java asks you to choose the type up front.

```java
String message = "Lab is loaded.";
int uses = 3;
boolean enabled = true;
```

## Step 1: Clone the Repo

Open PowerShell:

```powershell
cd Documents
mkdir game-dev
cd game-dev
git clone https://github.com/bebekim/learn-to-mod-minecraft-java
cd learn-to-mod-minecraft-java
```

## Step 2: Open the Mod

First prove the build works.

```powershell
cd Documents\game-dev\learn-to-mod-minecraft-java\active-mod
.\gradlew.bat build
```

Open IntelliJ IDEA.

Choose `Open`, then select:

```text
Documents\game-dev\learn-to-mod-minecraft-java\active-mod
```

Wait for Gradle to finish importing.

## Step 3: Run Minecraft

Run:

```powershell
.\gradlew.bat runClient
```

Or in IntelliJ's Gradle panel, run:

```text
Tasks -> fabric -> runClient
```

Minecraft should open with the mod loaded.

## Step 4: Create the Lab World

Create a creative superflat world named:

```text
Luke Lab
```

Suggested world settings:

- Creative
- Peaceful
- Cheats on
- Superflat

## Step 5: Prove the Loop

You should see:

```text
Lab is loaded. Change this message, rebuild, run again.
```

## Exercise 1.1 - Change a String

Open:

```text
active-mod/src/main/java/dev/luke/lab/LukeLabMod.java
```

Find:

```java
private static final String LAB_MESSAGE = "Lab is loaded. Change this message, rebuild, run again.";
```

Change the words inside the quotation marks.

Run `runClient` again and type:
Join the world again and check the chat message.

## Design Check

Information:

```text
The lab has a status message.
```

Representation:

```java
String LAB_MESSAGE
```

Example:

```text
Joining the world prints the current lab message.
```

Prediction:

```text
If I change LAB_MESSAGE, the chat message changes after I rebuild.
```

## Checkpoint

Commit the working setup:

```powershell
git status
git add .
git commit -m "week 01: setup mod lab"
```
