package ObjectCreateDestory.item2.practice;

public class Practice {
    private final int needValue;
    private final int choiceValue;
    private final int choiceValueTwo;
    private final int choiceValueThree;

    public static class Builder {
        public final int needValue;
        public int choiceValue = 0;
        public int choiceValueTwo = 0;
        public int choiceValueThree = 0;

        public Builder(int needValue) {
            this.needValue = needValue;
        }

        public Builder choiceValue(int val) {
            choiceValue = val;      return this;
        }

        public Builder choiceValueTwo(int val) {
            choiceValueTwo = val;      return this;
        }

        public Builder choiceValueThree(int val) {
            choiceValueThree = val;      return this;
        }

        public Practice build() {
            return new Practice(this);
        }
    } 

    private Practice(Builder builder) {
        needValue = builder.needValue;
        choiceValue = builder.choiceValue;
        choiceValueTwo = builder.choiceValueTwo;
        choiceValueThree = builder.choiceValueThree;
    }
}
