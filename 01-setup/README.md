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

## Step 0: Check Java First

Everything below fails in confusing ways if this is wrong, so check it before anything else. Open a **new** PowerShell window and run:

```powershell
$env:JAVA_HOME
java -version
```

Two things must be true:

- `java -version` says `21`.
- `JAVA_HOME` points at the JDK 21 folder, with no trailing `\bin`.

Either one can be wrong even though JDK 21 is installed - the installer does not always set them. If `JAVA_HOME` prints nothing, or `java -version` reports anything other than 21, stop here and fix it first: see **Fixing Java on Windows** in [SETUP.md](SETUP.md). Java 17 is not close enough - the build will not even reach Luke's code.

Note: installing Fabric into the Minecraft launcher is not part of this course. That is for playing published mods. Here, Fabric arrives automatically as a Gradle dependency, and `runClient` builds its own Minecraft.

## Step 1: Clone the Repo

The repo is public, so this needs no sign-in.

```powershell
cd Documents
mkdir game-dev
cd game-dev
git clone https://github.com/bebekim/learn-to-mod-minecraft-java
cd learn-to-mod-minecraft-java
```

Using GitHub Desktop instead is fine. Choose `File -> Clone repository`, pick `bebekim/learn-to-mod-minecraft-java`, and change the local path from the default `Documents\GitHub` to `Documents\game-dev` so it matches the layout above.

## Step 2: Prove the Build from PowerShell

Do this *before* opening IntelliJ. If something is broken, you want to know it is Java or the network - not IntelliJ's settings.

```powershell
cd Documents\game-dev\learn-to-mod-minecraft-java\active-mod
.\gradlew.bat build
```

The first run is slow. It downloads Gradle, then Minecraft, then remaps it, and Windows Firewall will probably ask to allow Java - allow it. Wait for:

```text
BUILD SUCCESSFUL
```

## Step 3: Open the Mod in IntelliJ

Open IntelliJ IDEA, choose `Open`, and select the **`active-mod`** folder, not the repo root:

```text
Documents\game-dev\learn-to-mod-minecraft-java\active-mod
```

Then point IntelliJ at Java 21. It does not read `JAVA_HOME` and ships its own runtime, so Step 0 passing does not mean this is already right:

```text
File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Gradle JVM
```

Set it to the Temurin 21 JDK. Then wait for Gradle to finish importing before doing anything else.

## Step 4: Run Minecraft

```powershell
.\gradlew.bat runClient
```

Or in IntelliJ's Gradle panel:

```text
Tasks -> fabric -> runClient
```

Minecraft should open with the mod loaded. It will not ask for a Microsoft sign-in - that is normal for a dev client, and it does not touch Luke's usual Minecraft or his existing worlds.

## Step 5: Create the Lab World

Create a creative superflat world named:

```text
Luke Lab
```

Suggested world settings:

- Creative
- Peaceful
- Cheats on
- Superflat

## Step 6: Prove the Loop

Join the world. The mod prints its message in chat as soon as you are in:

```text
Hello, Luke. Welcome to the Luke's Lab World
```

Seeing that means the whole chain works: your Java code compiled, Gradle packaged it as a mod, Fabric loaded it, and Minecraft ran it.

## Exercise 1.1 - Change a String

Open:

```text
active-mod/src/main/java/dev/luke/lab/LukeLabMod.java
```

Find the line that starts like this - the words inside the quotes are whatever the message currently says:

```java
private static final String LAB_MESSAGE = "...";
```

Change the words inside the quotation marks. Leave the quotes themselves alone.

Then, in this order:

1. **Quit Minecraft.** This matters. A running game keeps the code it was launched with, so editing the file changes nothing until you relaunch.
2. Run `.\gradlew.bat runClient` again.
3. Join the world and read the chat message.

Before you run it, say out loud what you expect to see. Then check whether you were right.

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

This saves the checkpoint on Luke's own machine. There is no need to push it anywhere - the course never depends on uploading, and every later lesson works from local commits.
