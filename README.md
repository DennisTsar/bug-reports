# Gradle issue reproducer

## Repro Steps

- `./gradlew demoTask --configuration-cache -t`
- Edit `config.txt`
- Edit `input.txt`

```
org.gradle.internal.cc.impl.ConfigurationCacheProblemsException: Configuration cache problems found in this build.	
1 problem was found storing the configuration cache.	
- Task `:demoTask` of type `org.gradle.api.DefaultTask`: Class 'Build_gradle$$$result$1$1' cannot be encoded because class loader 'VisitableURLClassLoader(ClassLoaderScopeIdentifier.Id{coreAndPlugins:settings[:]:buildSrc[:]:root-project[:]:kotlin-dsl:/home/runner/work/bug-reports/bug-reports/build.gradle.kts:Project/TopLevel/stage2(local)})' of type 'org.gradle.internal.classloader.VisitableURLClassLoader' could not be encoded and the class is not available through the default class loader.	
These are the known class loaders:	
	- ScriptClassLoader(groovy-script-/home/runner/.gradle/init.d/gradle-actions.inject-develocity.init.gradle-loader)	
	- ScriptClassLoader(groovy-script-/home/runner/.gradle/init.d/gradle-actions.github-dependency-graph.init.gradle-loader)	
	- ScriptClassLoader(groovy-script-/home/runner/.gradle/init.d/gradle-actions.build-result-capture.init.gradle-loader)	
	- ScriptClassLoader(groovy-script-/home/runner/.gradle/init.d/gradle-actions.build-result-capture-service.plugin.groovy-loader)	
	- ScriptClassLoader(groovy-script-/home/runner/.gradle/init.d/gradle-actions.inject-develocity.init.gradle-loader)	
	- InstrumentingVisitableURLClassLoader(ClassLoaderScopeIdentifier.Id{coreAndPlugins:init-file:/home/runner/.gradle/init.d/gradle-actions.inject-develocity.init.gradle(export)})	
Please report this error, run './gradlew --stop' and try again.
```
