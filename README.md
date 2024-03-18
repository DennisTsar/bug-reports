# Compose Compilation Bug

- Run `./gradlew app:compileDevelopmentExecutableKotlinJs` - SUCCESS
- Uncomment Line 7 in `app/src/jsMain/kotlin/main.kt` 
- Run `./gradlew app:compileDevelopmentExecutableKotlinJs` - ERROR
  ```
  > Task :app:compileDevelopmentExecutableKotlinJs FAILED
  e: java.lang.IllegalStateException: Internal error: cannot find external signature '[ /CssStyle$stableprop|6600469269559747436[0] <- Local[<BF>|FIELD name:CssStyle$stable type:kotlin.Int visibility:public [final,static]] ]' for name 'CssStyle$stable' in module kotlin_com_example_app
          at org.jetbrains.kotlin.ir.backend.js.transformers.irToJs.CrossModuleDependenciesResolver.resolveCrossModuleDependencies(JsIrProgramFragment.kt:137)
          at org.jetbrains.kotlin.ir.backend.js.ic.JsExecutableProducer.buildMultiArtifactExecutable(JsExecutableProducer.kt:63)
          at org.jetbrains.kotlin.ir.backend.js.ic.JsExecutableProducer.buildExecutable(JsExecutableProducer.kt:36)
          at org.jetbrains.kotlin.cli.js.K2JsIrCompiler.doExecute(K2JsIrCompiler.kt:358)
          at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:109)
          at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:72)
          at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:104)
          at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:48)
          at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
          at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1556)
          at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
          at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
          at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
          at java.base/java.lang.reflect.Method.invoke(Method.java:566)
          at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
          at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
          at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
          at java.base/java.security.AccessController.doPrivileged(Native Method)
          at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
          at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
          at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
          at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
          at java.base/java.security.AccessController.doPrivileged(Native Method)
          at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
          at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
          at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
          at java.base/java.lang.Thread.run(Thread.java:829)
  
  ```
- Run `./gradlew app:compileDevelopmentExecutableKotlinJs` again without any changes - SUCCESS