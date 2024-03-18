# KJS: Reserved keywords not escaped when `-Xir-generate-inline-anonymous-functions` is enabled (KT-66898)

# Issue

- Running `./gradlew jsBrowserDevelopmentWebpack` gives the error:
  ```
  > Task :jsBrowserDevelopmentWebpack FAILED
  Module parse failed: Unexpected token (31:24)
  File was processed with these loaders:
  * ../../node_modules/source-map-loader/dist/cjs.js
  You may need an additional loader to handle the result of these loaders.
  |     } else {
  |       tmp = function (x) {
  >         return x + void * 2;
  |       };
  |     }
  ```
    due to the following invalid js code generated:
  ```
  function Test_init_$Init$(void_0, $this) {
    var tmp;
    if (void_0 === 0.0) {
      tmp = Test$_init_$lambda_849v7d;
    } else {
      tmp = function (x) {
        return x + void * 2;
      };
    }
    Test.call($this, tmp, void_0);
    return $this;
  }
  ```
  where the original `void` parameter has been transformed to `void_0` everywhere except the inlined anonymous function.
- `./gradlew jsBrowserProductionWebpack` gives the same error