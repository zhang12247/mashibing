package my20220615.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjb
 * @date 2022/6/15
 * @description
 */
public class T {
    volatile boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;

    }
}
