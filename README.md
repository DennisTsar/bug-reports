# Compose Compilation Bug

- Run `./gradlew app:jsBrowserProductionWebpack` on a Windows machine
  ```
  > Task :app:jsBrowserProductionWebpack FAILED
  export 'Color1ydj1kwjfmcwv' (imported as 'Color') was not found in '../html-html-core/org/jetbrains/compose/web/css/Color.mjs' (possible exports: color39nf3u6d3kgwr)
  
  export 'Color1ydj1kwjfmcwv' (imported as 'Color') was not found in '../html-html-core/org/jetbrains/compose/web/css/Color.mjs' (possible exports: color39nf3u6d3kgwr)
  
  There are multiple modules with names that only differ in casing.
  This can lead to unexpected behavior when compiling on a filesystem with other case-semantic.
  Use equal casing. Compare these module identifiers:
  * javascript/esm|D:\a\bug-reports\bug-reports\build\js\node_modules\source-map-loader\dist\cjs.js!D:\a\bug-reports\bug-reports\build\js\packages\example-app\kotlin\html-html-core\org\jetbrains\compose\web\css\Color.mjs
    Used by 1 module(s), i. e.
    javascript/esm|D:\a\bug-reports\bug-reports\build\js\node_modules\source-map-loader\dist\cjs.js!D:\a\bug-reports\bug-reports\build\js\packages\example-app\kotlin\example-app\main.mjs
  * javascript/esm|D:\a\bug-reports\bug-reports\build\js\node_modules\source-map-loader\dist\cjs.js!D:\a\bug-reports\bug-reports\build\js\packages\example-app\kotlin\html-html-core\org\jetbrains\compose\web\css\color.mjs
    Used by 1 module(s), i. e.
    javascript/esm|D:\a\bug-reports\bug-reports\build\js\node_modules\source-map-loader\dist\cjs.js!D:\a\bug-reports\bug-reports\build\js\packages\example-app\kotlin\example-lib-a\com\example\ColorModifier.mjs
    ```
- Remove `kotlin.js.ir.output.granularity=per-file` from `gradle.properties`, then `./gradlew app:jsBrowserProductionWebpack` succeeds