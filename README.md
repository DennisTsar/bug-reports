# KJS Dependenent Gradle Composite Build Unable to Build

# Structure

- root build contains `library` composite build and `sandbox` composite build 
- both projects target JVM and JS
- `sandbox` depends on `library` (JS target only), but does not declare a composite build dependency on `library`
- Kotlin 1.9.23 & 2.0.0-Beta4, Gradle 8.6

# Issue

- Running `./gradlew sandbox:build` gives the error:
  ```
  FAILURE: Build failed with an exception.
  
  * What went wrong:
    Could not determine the dependencies of task ':sandbox:jsPackageJson'.
  > Included build 'library' not found in build 'sandbox'.
  ```
- If `sandbox` instead depends on only the JVM target of `library`, building `sandbox` from the root project now works (`./gradlew sandbox:build`).