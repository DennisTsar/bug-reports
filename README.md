# Compose 1.6.0+ Recomposition Issue

- Run `./gradlew app:jvmRun -DmainClass=MainKt` or `./gradlew app:jsBrowserDevelopmentRun` and enter text into the
  textfield. Observe that the first `CustomRow` does not recompose on button click, but the second does.
- If contents of `lib` are moved to `app`, the issue goes away
- JVM behavior has occurred since at least Compose 1.5.12/Kotlin 1.9.22
- JS behavior began with Compose 1.6.0/Kotlin 1.9.22
- Still present on both targets with Compose 1.6.11 & Kotlin 2.0.0