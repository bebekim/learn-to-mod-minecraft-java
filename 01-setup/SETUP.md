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
```

Java 17 is a valid choice only if the whole course is pinned to an older Minecraft version such as `1.20.1`.
