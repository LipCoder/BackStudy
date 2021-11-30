package ObjectCreateDestory.item2.practice;

public abstract class Parent {
    final int choiceValue;

    abstract static class Builder<T extends Builder<T>> {
        int choiceValue = 0;

        public T choiceValue(int val) {
            choiceValue = val;      return self();
        }        

        abstract Parent build();

        protected abstract T self();
    }

    Parent(Builder<?> builder) {
        choiceValue = builder.choiceValue;
    }
}
