package ObjectCreateDestory.item2;

public class Calzone extends Pizza {
    private final boolean sauceInside;
    
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // 기본값

        // 소스를 넣을지 말지를 선택적으로 받음
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        // 해당 구체의 하위 클래스를 반환한다.
        // Calzone 반환
        @Override public Calzone build() {
            return new Calzone(this);
        }

        @Override protected Builder self() { return this; }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}

// Calzone calzone = new Calzone.Builder()
//          .addTopping(HAM).sauceInside().build();