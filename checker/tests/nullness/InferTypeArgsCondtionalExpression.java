// Use to cause crash similar to the one reported in #579
// https://github.com/typetools/checker-framework/issues/579
// Issue 579 tests case is in checker/tests/nullness/java8/Issue579.java
// A similar test case appears in /Users/smillst/jsr308/checker-framework/framework/tests/all-systems/InferTypeArgsCondtionalExpression.java


import org.checkerframework.checker.nullness.qual.NonNull;

class InferTypeArgsCondtionalExpression {

    public <T>  void foo(Generic<T> real, Generic<? super T> other, boolean flag) {
        //:: error: (type.argument.type.incompatible)
        bar(flag ? real : other);
    }

    <@NonNull Q extends @NonNull Object> void bar(Generic<? extends Q> parm) {
    }

    interface Generic<F> {
    }
}
