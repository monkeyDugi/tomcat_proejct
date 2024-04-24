import java.lang.reflect.Member;

public class Main1 {

    static ThreadLocal<Integer> price = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            price.set(100);
            System.out.println("thread1 price 변경");
            System.out.println("thread1 price 조회 = " + price.get());
        });

        Thread thread2 = new Thread(() -> {
            price.set(200);
            System.out.println("thread2 price 변경");
            System.out.println("thread2 price 조회 = " + price.get());
        });

        thread1.start();
        thread2.start();
    }
}