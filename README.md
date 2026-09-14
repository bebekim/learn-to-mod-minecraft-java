# Learn to Mod Minecraft with Java

A game-first Java course for Luke, who has already finished Replit's 100 Days of Python.

The bait is Minecraft. Java, objects, tests, specs, and refactoring are introduced only when a mod feature needs them.

## Course Rules

- Build one Fabric mod across the course.
- Start every lesson from a running Minecraft world.
- Change one rule, rebuild, run, observe, then explain the Java idea.
- Use a fixed lab world so testing a mechanic takes seconds, not wandering.
- Predict before running: describe one concrete situation and what should happen.
- Keep Git simple: one branch, one working checkpoint per lesson.
- No AI-generated code for Luke's exercises.

## Learning Loop

```text
DESCRIBE -> EXAMPLE -> CODE -> BUILD -> PLAY -> OBSERVE -> REFACTOR
```

This is the Minecraft version of the DragonRuby loop:

```text
Change one rule -> run the lab -> see the mechanic
```

Minecraft is slower than DragonRuby, so the course grows toward a permanent lab world:

```text
Join world -> see mod message -> change one rule -> rebuild -> join again
```

Later lessons add:

```text
/lab reset
/lab state
/lab item lightning_wand
/lab spawn test_zombie
/lab run knockback
```

## Sources Woven In

- HTDC: represent information as classes, write examples first, then methods.
- MIT 6.005: specs, tests, immutability, abstraction, equality, debugging, concurrency, and changeable design.
- Java by Comparison: refactor working code into idiomatic Java after the mechanic works.

## Repository Layout

```text
active-mod/          Fabric mod Luke opens in IntelliJ
01-setup/           first setup lesson
00-prerequisites.md tools to install before lesson 1
00-instructor-guide.md parent notes
CURRICULUM.md        20,000-ft view of the units after setup
LESSON-TEMPLATE.md  shape for later lessons
```

Start with [00-prerequisites.md](00-prerequisites.md), then [01 - Setup](01-setup/README.md).

## Version Choice

The course starts on Minecraft `1.21.1` and Java `21`. Java 17 is only enough if the course targets an older Minecraft version such as `1.20.1`.
