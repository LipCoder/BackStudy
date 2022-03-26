import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector v = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");
        print(v);

        v.trimToSize(); // 빈 공간을 없앤다.
        System.out.println("=== After trimToSize () ===");
        print(v);
        // (재할당)

        v.ensureCapacity(6);
        System.out.println("=== After ensureCapacity () ===");
        print(v);
        // (재할당)

        v.setSize(7);
        System.out.println("=== After setSize () ===");
        print(v);
        // size가 capacity보다 커지는 경우
        // capacity는 자동으로 2배 늘어난다.(재할당)

        v.clear();
        System.out.println("=== After clear () ===");
        print(v);

    }    

    public static void print(Vector v) {
        System.out.println(v);
        System.out.println("size :" + v.size());
        System.out.println("capacity :" + v.capacity());
    }
}
