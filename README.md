# K/JS Incrememntal OutOfMemoryError

- Run `./gradlew :compileDevelopmentExecutableKotlinJs`
- Comment out lines 14-16 in `src/jsMain/kotlin/main.kt`
- Run `./gradlew :compileDevelopmentExecutableKotlinJs` again. This either hangs, or throws an out of memory error:
  ```
  java.lang.OutOfMemoryError: Java heap space
    at java.base/java.io.InputStream.readNBytes(InputStream.java:448)
    at java.base/java.io.InputStream.readAllBytes(InputStream.java:349)
    at jdk.zipfs/jdk.nio.zipfs.ZipFileSystem.newByteChannel(ZipFileSystem.java:977)
    at jdk.zipfs/jdk.nio.zipfs.ZipPath.newByteChannel(ZipPath.java:870)
    at jdk.zipfs/jdk.nio.zipfs.ZipFileSystemProvider.newByteChannel(ZipFileSystemProvider.java:247)
    at java.base/java.nio.file.Files.newByteChannel(Files.java:380)
    at java.base/java.nio.file.Files.newByteChannel(Files.java:432)
    at java.base/java.nio.file.Files.readAllBytes(Files.java:3281)
    at org.jetbrains.kotlin.konan.file.File.readBytes(File.kt:140)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt$IrMultiArrayReader$1$1.invoke(lowLevelReaders.kt:46)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt$IrMultiArrayReader$1$1.invoke(lowLevelReaders.kt:46)
    at org.jetbrains.kotlin.library.impl.BaseLibraryAccess$inPlace$1.invoke(KotlinLibraryLayoutImpl.kt:46)
    at org.jetbrains.kotlin.library.impl.BaseLibraryAccess$inPlace$1.invoke(KotlinLibraryLayoutImpl.kt:45)
    at org.jetbrains.kotlin.konan.file.ZipFileSystemCacheableAccessor.withZipFileSystem(ZipFileSystemAccessor.kt:36)
    at org.jetbrains.kotlin.cli.common.DisposableZipFileSystemAccessor.withZipFileSystem(klibArguments.kt)
    at org.jetbrains.kotlin.library.impl.BaseLibraryAccess.inPlace(KotlinLibraryLayoutImpl.kt:45)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt$IrMultiArrayReader$1.invoke(lowLevelReaders.kt:46)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt$IrMultiArrayReader$1.invoke(lowLevelReaders.kt:46)
    at org.jetbrains.kotlin.library.impl.ReadBuffer$OnDemandMemoryBuffer.ensureBuffer(ReadBuffer.kt:100)
    at org.jetbrains.kotlin.library.impl.ReadBuffer$OnDemandMemoryBuffer.setPosition(ReadBuffer.kt:78)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt.readTableItemBytes(lowLevelReaders.kt:206)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt.readTableItemBytes(lowLevelReaders.kt:185)
    at org.jetbrains.kotlin.library.impl.LowLevelReadersKt.access$readTableItemBytes(lowLevelReaders.kt:1)
    at org.jetbrains.kotlin.library.impl.IrMultiArrayReader.tableItemBytes(lowLevelReaders.kt:54)
    at org.jetbrains.kotlin.library.impl.IrLibraryImpl$IrDirectory.body(KotlinLibraryImpl.kt:119)
    at org.jetbrains.kotlin.backend.common.serialization.IrKlibBytesSource.body(IrFileDeserializer.kt:244)
    at org.jetbrains.kotlin.backend.common.serialization.IrLibraryFileFromBytes.expressionBody(IrFileDeserializer.kt:224)
    at org.jetbrains.kotlin.backend.common.serialization.IrDeclarationDeserializer.loadExpressionBodyProto(IrDeclarationDeserializer.kt:482)
    at org.jetbrains.kotlin.backend.common.serialization.IrDeclarationDeserializer.deserializeExpressionBody(IrDeclarationDeserializer.kt:487)
    at org.jetbrains.kotlin.backend.common.serialization.IrDeclarationDeserializer.deserializeIrField$lambda$0$2$0(IrDeclarationDeserializer.kt:681)
    at org.jetbrains.kotlin.backend.common.serialization.IrDeclarationDeserializer$$Lambda/0x0000019ace87d8a0.invoke(Unknown Source)
    at org.jetbrains.kotlin.backend.common.serialization.IrDeclarationDeserializer.withInitializerGuard(IrDeclarationDeserializer.kt:471)
    ```
- If there was no error, un-comment the lines and run again
- Using `kotlin.incremental.js.ir=false` resolves the issue