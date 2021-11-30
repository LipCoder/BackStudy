package ObjectCreateDestory.item2.practice;

import java.util.Objects;

public class Child extends Parent {
    private final int needVal;
    private final int choiceChildVal;

    public static class Builder extends Parent.Builder<Builder> {
        private final int needVal;
        private int choiceChildVal = 0;

        public Builder(int needVal) {
            this.needVal = needVal;
        }

        public Builder choiceChildVal(int val) {
            choiceChildVal = val;       return this;    
        }

        @Override public Child build() {
            return new Child(this);
        }

        @Override protected Builder self() { return this; }
    }

    private Child(Builder builder) {
        super(builder);
        needVal = builder.needVal;
        choiceChildVal = builder.choiceChildVal;
    }
}
