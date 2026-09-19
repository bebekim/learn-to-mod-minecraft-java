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

It should say version `21`.

Java 17 is not enough, and the failure is not subtle. Gradle itself must *run* on Java 21, because the Fabric Loom plugin refuses to load on anything older. On a Java 17 JVM the build dies during configuration, before a single line of Luke's code is compiled:

```text
> Dependency requires at least JVM runtime version 21. This build uses a Java 17 JVM.
```

Note what this means: a Gradle `toolchain` block in `build.gradle` would not fix it. A toolchain only chooses the compiler for your own source; it cannot change the JVM Gradle is already running on. The only fix is to point Gradle at a Java 21 JDK.

## Windows: Pointing Gradle at Java 21

Having Java 21 installed is not the same as Gradle using it. Two places must agree.

**1. `JAVA_HOME` for command-line builds.** The Adoptium Temurin installer can set this, but the option is not always enabled by default — during install, turn on `Set JAVA_HOME variable`. Verify in a *new* PowerShell window:

```powershell
$env:JAVA_HOME
java -version
```

`JAVA_HOME` must point at the JDK 21 folder (no trailing `\bin`), and `java -version` must say 21. If Windows has several JDKs, `java -version` reports whichever is first on `PATH` — that is a common way to have 21 installed and still build with 17.

**2. IntelliJ's Gradle JVM.** IntelliJ does not read `JAVA_HOME`; it has its own setting and ships its own bundled runtime. Set it explicitly:

```text
File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Gradle JVM
```

Choose the Temurin 21 JDK. A build that works in PowerShell can still fail in IntelliJ if this is left on a different JDK.

## Other Windows Setup Notes

- **Cloning needs authentication.** The course repo is private, so the bare `git clone` in lesson 01 will prompt for credentials. Sign in to GitHub Desktop first, or run `gh auth login`, before the cloning step.
- **First `runClient` is slow and touches the network.** It downloads Minecraft's assets, and Windows Firewall will likely prompt to allow Java. Allow it on private networks. Budget real time for this step rather than doing it in front of an impatient kid.
- **The dev client is not the Minecraft launcher.** `runClient` launches its own Minecraft instance and does not ask for a Microsoft sign-in for singleplayer. Luke's normal launcher and worlds are untouched, and the lab world lives only inside the dev environment.
- **Long paths.** Gradle and Loom create deeply nested cache folders that can exceed Windows' old 260-character limit. If a build fails with a path-too-long error, enable long paths:

  ```powershell
  git config --global core.longpaths true
  ```

  and enable the Windows long-path setting (Group Policy, or the `LongPathsEnabled` registry value).
- **Antivirus slows builds.** Windows Defender scanning `%USERPROFILE%\.gradle` and the project's `build` folder measurably slows rebuilds. Excluding those two folders is safe and helps the edit-rebuild-observe loop stay fast.
- **Out of memory on a clean build.** `active-mod/gradle.properties` sets `org.gradle.jvmargs=-Xmx1G`. Remapping Minecraft is memory hungry; if the first Windows build fails with a heap error, raise it to `-Xmx2G`.

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
