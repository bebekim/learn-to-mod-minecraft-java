# 00 - Prerequisites

Install these before Luke starts lesson 1.

## Windows Computer

- Minecraft: Java Edition
- IntelliJ IDEA Community Edition
- Git
- Java 21 JDK from Adoptium Temurin
- A GitHub account

Optional but useful:

- GitHub Desktop
- 7-Zip

## Mac Computer

- IntelliJ IDEA Community Edition
- Git
- Java 21 JDK

Check Java:

```powershell
java -version
```

It should say version `21`. Java 17 is not enough for this course target because Minecraft `1.21.1` uses Java 21-era tooling.

Check the build:

Windows:

```powershell
cd Documents\game-dev\learn-to-mod-minecraft-java\active-mod
.\gradlew.bat build
```

Mac:

```bash
cd ~/repositories/game/learn-to-mod-minecraft-java/active-mod
export JAVA_HOME=/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home
./gradlew build
```

## Folder Layout

Use the same shape on both machines:

```text
Documents
└── game-dev
    └── learn-to-mod-minecraft-java
        └── active-mod
```

Luke works in `active-mod`. The lesson folders are instructions and rescue copies, not separate projects.
