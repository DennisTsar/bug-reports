# Repro Steps

- Run `./gradlew build`, it should complete successfully with the following output:

  ```
  > Task :app:kspKotlinJs
  w: [ksp] [TestFile.kt, main.kt]
  w: [ksp] [TestFile.kt, main.kt, Foo.kt]
  
  > Task :app:kspKotlinJvm
  w: [ksp] [TestFile.kt, main.kt]
  w: [ksp] [TestFile.kt, main.kt, Foo.kt]
  ```

- Edit the string in `lib/src/commonMain/kotlin/lib/lib.kt`, for example changing `"hello"` to `"hello2"`
- Run `./gradlew build` again, it fails:

  ```
  > Task :app:kspKotlinJs
  w: [ksp] []
  w: [ksp] [Foo.kt]
  
  > Task :app:kspKotlinJvm
  w: [ksp] []
  w: [ksp] [Foo.kt]
  
  > Task :app:compileKotlinJs FAILED
  e: file:/app/src/jsMain/kotlin/main.kt:1:20 Unresolved reference 'file_TestFile'.
  e: /app/src/jsMain/kotlin/main.kt:4:13 Unresolved reference 'file_TestFile'.
  
  > Task :app:compileKotlinJvm FAILED
  e: /app/src/jvmMain/kotlin/main.kt:1:20 Unresolved reference 'file_TestFile'.
  e: /app/src/jvmMain/kotlin/main.kt:4:13 Unresolved reference 'file_TestFile'.
  ```
  No input files are passed to the KSP processor, and thus the functions are generated.

- Run `./gradlew clean` and then `./gradlew build` again, it succeeds

## Notes

- Disabling KSP incremental processing with `ksp.incremental=false` fixes the issue
- The issue began for the JS target with Kotlin 2.1.0 + KSP 2.1.0-1.0.28, but has been present for the JVM target for
  longer
- Enabling KSP2 resolves the issue for the JS target but not for the JVM target
- Similarly, disabling non packed Klibs with the flag `kotlin.internal.klibs.non-packed=false` resolves the issue for
  the JS target but not for the JVM target