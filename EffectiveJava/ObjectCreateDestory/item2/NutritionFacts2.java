package ObjectCreateDestory.item2;

public class NutritionFacts2 {
    private int servingSize   = -1;      // 필수
    private int servings      = -1;      // 필수
    private int calories      = 0;   
    private int fat           = 0;
    private int sodium        = 0;
    private int carbohydrate  = 0;

    public NutritionFacts2() { }
    
    public void setServingSize(int val)         { servingSize = val; }
    public void setServings(int val)            { servings = val; }
    public void setCalories(int val)            { calories = val; }
    public void setFat(int val)                 { fat = val; }
    public void setSodium(int val)              { sodium = val; }
    public void carbohydrate(int val)           { carbohydrate = val; }
}

// NutritionFacts cocaCola = new NutritionFacts();
// cocaCola.setServingSize(240);
// cocaCola.setServings(8);
// cocaCola.setCalories(100);
// cocaCola.setCarbohydrate(27);