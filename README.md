# cljs-3162-sample-project

This is a tiny project to demonstrate the difference in behavior when
a `clojure.test/is` expression is evaluated, and the expression inside
throws an exception.  See ticket
[CLJS-3162](https://clojure.atlassian.net/browse/CLJS-3162) for any
progress that is made on improving this behavior.

Clojure 1.10.1 shows the expected result, and actual result, including
a stack trace for the exception.

ClojureScript 1.10.520 shows the expected result, and actual result as
an exception object, but with no stack trace.

## Usage

Current output can be seen below by running the indicated commands.

Clojure/Java 1.10.1 behavior:

```bash
$ clj -A:test:clj-runner

Running tests in #{"test"}

Testing cljs-3162-sample-project.sample-test

ERROR in (a-test) (sample_test.clj:6)
expected: (= 5 (throw (Exception. "my custom exception")))
  actual: java.lang.Exception: my custom exception
 at cljs_3162_sample_project.sample_test$fn__990.invokeStatic (sample_test.clj:6)
    cljs_3162_sample_project.sample_test/fn (sample_test.clj:5)
    clojure.test$test_var$fn__9737.invoke (test.clj:717)
    clojure.test$test_var.invokeStatic (test.clj:717)
    clojure.test$test_var.invoke (test.clj:708)
    clojure.test$test_vars$fn__9763$fn__9768.invoke (test.clj:735)
    clojure.test$default_fixture.invokeStatic (test.clj:687)
    clojure.test$default_fixture.invoke (test.clj:683)
    clojure.test$test_vars$fn__9763.invoke (test.clj:735)
    clojure.test$default_fixture.invokeStatic (test.clj:687)
    clojure.test$default_fixture.invoke (test.clj:683)
    clojure.test$test_vars.invokeStatic (test.clj:731)
    clojure.test$test_all_vars.invokeStatic (test.clj:737)
    clojure.test$test_ns.invokeStatic (test.clj:758)
    clojure.test$test_ns.invoke (test.clj:743)
    clojure.core$map$fn__5866.invoke (core.clj:2755)
    clojure.lang.LazySeq.sval (LazySeq.java:42)
    clojure.lang.LazySeq.seq (LazySeq.java:51)
    clojure.lang.Cons.next (Cons.java:39)
    clojure.lang.RT.boundedLength (RT.java:1792)
    clojure.lang.RestFn.applyTo (RestFn.java:130)
    clojure.core$apply.invokeStatic (core.clj:667)
    clojure.test$run_tests.invokeStatic (test.clj:768)
    clojure.test$run_tests.doInvoke (test.clj:768)
    clojure.lang.RestFn.applyTo (RestFn.java:137)
    clojure.core$apply.invokeStatic (core.clj:665)
    clojure.core$apply.invoke (core.clj:660)
    cognitect.test_runner$test.invokeStatic (test_runner.clj:63)
    cognitect.test_runner$test.invoke (test_runner.clj:51)
    cognitect.test_runner$_main.invokeStatic (test_runner.clj:114)
    cognitect.test_runner$_main.doInvoke (test_runner.clj:103)
    clojure.lang.RestFn.applyTo (RestFn.java:137)
    clojure.lang.Var.applyTo (Var.java:705)
    clojure.core$apply.invokeStatic (core.clj:665)
    clojure.main$main_opt.invokeStatic (main.clj:514)
    clojure.main$main_opt.invoke (main.clj:510)
    clojure.main$main.invokeStatic (main.clj:664)
    clojure.main$main.doInvoke (main.clj:616)
    clojure.lang.RestFn.applyTo (RestFn.java:137)
    clojure.lang.Var.applyTo (Var.java:705)
    clojure.main.main (main.java:40)

Ran 2 tests containing 2 assertions.
0 failures, 1 errors.
```

ClojureScript 1.10.520 behavior with a Node.js runtime (version
10.16.0 on macOS 10.13.6, but likely the result is the same for many
other versions of Node.js):

```bash
$ clj -A:cljs:test:cljs-node-test

Testing cljs-3162-sample-project.another-test

ERROR in (a-test) (Error:NaN:NaN)
expected: (= 5 (throw (js/Error. "my custom exception")))
  actual: #object[Error Error: my custom exception]

Ran 2 tests containing 2 assertions.
0 failures, 1 errors.
```


## License

Copyright © 2019 Andy Fingerhut

Distributed under the Eclipse Public License either version 1.0.
