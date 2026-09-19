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
