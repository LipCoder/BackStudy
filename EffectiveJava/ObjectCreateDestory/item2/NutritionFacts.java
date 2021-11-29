package ObjectCreateDestory.item2;

public class NutritionFacts {
    private final int servingSize;      // 1회 제공량       필수
    private final int servings;         // 총 n회 제공량     필수
    private final int calories;         // 1회 제공량당      선택
    private final int fat;              // 1회 제공량(g)    선택
    private final int sodium;           // 1회 제공량(mg)   선택
    private final int carbohydrate;     // 1회 제공량(g)    선택

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, 
                          int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, 
                          int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, 
                          int fat, int sodium, int carbohydrate) {
        this.servingSize    = servingSize;
        this.servings       = servings;
        this.calories       = calories;
        this.fat            = fat;
        this.sodium         = sodium;
        this.carbohydrate   = carbohydrate;
    }
} 

// NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);