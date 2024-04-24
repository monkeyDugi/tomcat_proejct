public class Main {

    static ThreadLocal<Member> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set(new Member("id1", "name1"));

            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Member value = threadLocal.get();
            System.out.println(value);
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(new Member("id2", "name2"));

            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Member value = threadLocal.get();
            System.out.println(value);
        });

        thread1.start();
        thread2.start();
    }
}

class Member {

    private String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}