# Adult Wiring Note

The setup target is simple:

```text
Edit Java -> run Gradle runClient -> open lab world -> /lab state
```

Use IntelliJ on both Windows and Mac. Open the `active-mod` folder, not the repo root, if IntelliJ asks which project to import.

Fabric setup changes often. If the Gradle import fails because versions are stale, regenerate a plain Fabric Java project from the official Fabric template or generator, then keep this course's package name and lesson docs.

Current pinned course target:

```text
Minecraft 1.21.1
Java 21
Fabric Loader 0.19.5
Fabric API 0.116.17+1.21.1
Fabric Loom 1.17.21
```

Loom is pinned to an exact version on purpose. It used to read `1.17-SNAPSHOT`, which is a moving target: the same line resolved to Loom `1.17.20` one week and `1.17.21` the next. For a course repo that has to behave the same on the Mac and the Windows machine, and the same next month as today, a snapshot is a liability - a lesson should never fail because an upstream build changed overnight.

Gradle must *run* on Java 21, not merely compile to it. Loom will not load on an older JVM. See `00-prerequisites.md` for the Windows specifics.

Java 17 is a valid choice only if the whole course is pinned to an older Minecraft version such as `1.20.1`.

## Fixing Java on Windows

Installing JDK 21 does not reliably set `JAVA_HOME` or `PATH`. In the Adoptium Temurin installer both are optional features that are off by default, so "Java 21 is installed" and "Gradle can find Java 21" are different claims. Expect to check this rather than assume it.

Which one actually matters: **`JAVA_HOME`**. `gradlew.bat` uses `%JAVA_HOME%\bin\java.exe` when `JAVA_HOME` is set, and only searches `PATH` when it is not. So a correct `JAVA_HOME` builds fine even with a stale `java` on `PATH`. `PATH` matters for `java -version` telling you the truth, and for other tools.

### Diagnose

```powershell
where.exe java
java -version
$env:JAVA_HOME
```

Use `where.exe`, not bare `where` - in PowerShell `where` is an alias for `Where-Object` and will not do this. `where.exe java` lists every `java` on `PATH` in priority order, and the first line wins. This is the one command that explains "I installed 21 but it reports 17." Entries that commonly jump ahead: `C:\Program Files\Common Files\Oracle\Java\javapath` and leftover JRE installs.

### Fix, the easy way

Re-run the Temurin installer and turn on the two features it skipped:

1. `Settings -> Apps`, find **Eclipse Temurin JDK 21**, choose `Modify`.
2. Enable **Set JAVA_HOME variable** and **Add to PATH**.
3. Finish, then open a **new** PowerShell window.

### Fix, by hand

1. `Win+R`, run `sysdm.cpl`, then `Advanced -> Environment Variables`.
2. Under **System variables**, `New`. Name `JAVA_HOME`. Value is the JDK root, for example `C:\Program Files\Eclipse Adoptium\jdk-21.0.x.x-hotspot`. No trailing `\bin`.
3. Select `Path`, `Edit`, `New`, add `%JAVA_HOME%\bin`, then `Move Up` until it sits above any other Java entry. The ordering is what fixes a wrong reported version.
4. OK out of every dialog, then open a **new** PowerShell window.

Environment changes only reach newly opened terminals. Editing the variables and re-checking in an already-open window shows the old values and looks like the fix failed.

### Test a path before committing to it

This changes one PowerShell session only and disappears when the window closes - useful for confirming a path is right before writing it into the system variables:

```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.x.x-hotspot"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
java -version
```
