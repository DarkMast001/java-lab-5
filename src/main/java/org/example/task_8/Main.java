package org.example.task_8;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static AutoCloseable withLock(ReentrantLock lock) {
        lock.lock();

        return () -> {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        };
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        try (AutoCloseable lockResource = withLock(lock)) {
            // ...
        } catch (Exception e) {
            System.err.println("Ошибка при закрытии блокировки: " + e.getMessage());
        }
    }
}
