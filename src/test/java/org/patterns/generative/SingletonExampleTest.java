package org.patterns.generative;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class SingletonWorker implements Runnable {

    private final int threadNumber;

    public SingletonWorker(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        singleton.greetOurselves(threadNumber);
    }
}


class SingletonExampleTest {

    @Test
    void testGetInstance() throws InterruptedException {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SingletonWorker(i));
            threads.add(thread);
        }

        threads.forEach(Thread::run);
        for (Thread thread: threads) {

            thread.join();
        }
    }
}