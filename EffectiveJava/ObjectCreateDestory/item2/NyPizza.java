package ObjectCreateDestory.item2;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        // size를 필수로 받음
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        // 해당 구체의 하위 클래스를 반환한다.
        // NyPizza 반환
        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() { return this; }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

// NyPizza pizza = new NyPizza.Builder(SMALL)
//          .addTopping(SAUSAGE).addTopping(ONION).build();
