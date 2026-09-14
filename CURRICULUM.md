# Curriculum Overview

A 20,000-ft view of the course, unit by unit. This is a map, not a lock: `00-instructor-guide.md`'s rule still holds — skipped complexity is intentional, add it only when a visible mechanic needs it. Lesson folders are created only when a unit is actually starting, per `LESSON-TEMPLATE.md`. Units can reorder or absorb a lesson if a mechanic turns out easier or harder in practice than expected here.

Ordering is mod-led: each unit starts from a real mod feature (from the Fabric Wiki's own tutorial order and from real Minecraft-modding job postings), and the Java or CS idea is whatever that feature drags in. It does not start from a Java topic looking for a Minecraft excuse.

## Unit 0 - Foundations (done)

- Outcome: running mod, chat message on join, edit-rebuild-observe loop working.
- Concepts: static typing, `String` / constants, `src/` vs `build/`.
- Sources: intro-Java typing basics.

## Unit 1 - Items & Crafting

- Outcome: a real item (lightning wand) with behavior, craftable via a custom recipe, remembers something via NBT.
- Concepts: scoping (`public` vs `private`), registration pattern, method overriding (first taste of polymorphism), objects holding state, JSON/datapack literacy.
- Sources: HTDC (Information -> Representation); job posting's "custom crafting systems" and JSON bonus qualifications.
- Scoping note: this is the first lesson with a second class (`LabItems`, registering the wand) that needs to reach into `LukeLabMod`. It only compiles because `MOD_ID` is `public`; `LAB_MESSAGE` is `private` and genuinely cannot be seen from outside. Both modifiers were already present unexplained since lesson 01 - this is where they get a felt consequence instead of a definition. Scope this to `public`/`private` only; `protected` and package-private can wait for a unit that actually needs them.

## Unit 2 - Blocks & State

- Outcome: a custom block, with states (on/off) and a block entity that stores real data - likely the backing store for `/lab state`.
- Concepts: `enum`, first full HTDC design recipe (this is the first class Luke designs, not just registers), abstraction - "why does this look like the item lesson?"
- Sources: MIT 6.005 abstraction; Fabric Wiki's Blocks & Storage tutorial arc.

## Unit 3 - Commands & Events

- Outcome: `/lab` command with arguments, a second custom event registration (made explicit this time, unlike lesson 1's implicit one).
- Concepts: input parsing, conditionals/branching, "libraries and clients" vocabulary.
- Sources: job posting's commands requirement and "programming logic" bonus (scoreboard loops, execute commands). Vanilla `/execute`/scoreboard syntax gets a mention here, without a lesson of its own.

## Unit 4 - Entities & Behavior

- Outcome: a custom mob with one simple AI goal.
- Concepts: subclassing, overriding real behavior methods, first place where a bug is behavioral rather than a typo - first honest use of "predict, then test" as a debugging habit.
- Sources: MIT 6.005 (safe from bugs). Hardest item on both job postings reviewed; sequenced last of the core units deliberately so registration mechanics are already familiar and only AI logic is new.

## Unit 5 - Polish & Refactor

- Outcome: data generation replacing hand-written JSON from Units 1-2; optional stretch: a simple lab UI screen.
- Concepts: removing duplication once it is visible across four units of registration code.
- Sources: Java by Comparison (compare working code to cleaner code, after it works); job posting's data-generation and UI bonus items.

## Threads Through Every Unit

These are not their own lesson - they run through all of them:

- One Git checkpoint per lesson.
- Predict-before-run, every time.
- The HTDC "Design Check" as the constant ritual - the same move a senior Minecraft-modding job posting called "translate creative requests into technical plans," just at a different scale.
- The "no AI-generated code for Luke's exercises" course rule holds throughout. Judging AI-generated output is a Unit 5-or-later idea at the earliest, not sooner - you cannot judge what you cannot yet build yourself.

## References Consulted

- Fabric Wiki tutorial structure (wiki.fabricmc.net) - real dependency order for items, blocks, commands, entities.
- Job posting: Java Game Developer, Minecraft (Spawnpoint Media) - entry-level mod skill list: blocks, items, mobs/entities, UI, commands, crafting, JSON/loot tables/tags, datapacks, NBT.
- Job posting: Lead Java Engineer, Game Tools, Minecraft (CatFace) - senior trajectory reference: maintainable systems, translating stakeholder requests, AI-assisted development fluency as a later-stage skill, not a starting one.
- introcs.cs.princeton.edu Java curriculum - considered as a straight CS-topic ordering; chapters 1-4 (elements, functions, OOP, data structures) partially map onto units above, chapters 5-9 (theory of computing, circuits, systems, scientific computing) are out of scope for this course.
