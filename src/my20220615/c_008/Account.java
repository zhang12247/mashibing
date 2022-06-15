package my20220615.c_008;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjb
 * @date 2022/6/15
 * @description
 */
public class Account {
    double balance;

    String name;

    public synchronized void setBalance(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public synchronized double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();

        new Thread(() -> a.setBalance("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(a.getBalance("zhangsan"));
    }
}
