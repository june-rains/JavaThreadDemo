package com.changhao.demo07;

public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        Producer producer = new Producer(synContainer);
        Consumer consumer = new Consumer(synContainer);

        producer.start();
        consumer.start();
    }
}


class Producer extends Thread {
    private SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("producer produce the " + i + " chicken");
        }
    }
}

class Consumer extends Thread {
    private SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = synContainer.pop();
            System.out.println("consumer consume the " + chicken.id + " chicken");
        }
    }
}

class Chicken {
    int id;
    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    private Chicken[] chickens = new Chicken[10];
    private int count = 0;

    // producer produce
    public synchronized void push(Chicken chicken) {
        if(count == 10) {
            // exceed the container's size, producer wait
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // produce and push the chicken
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if(count == 0) {
            // the count is zero, consumer wait
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}