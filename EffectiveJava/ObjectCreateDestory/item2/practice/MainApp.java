package ObjectCreateDestory.item2.practice;

public class MainApp {
    Practice p = new Practice.Builder(1)
        .choiceValue(2).choiceValueTwo(3).choiceValueThree(4).build();

    Child c = new Child.Builder(100, 200).choiceChildVal(100).build();
}
