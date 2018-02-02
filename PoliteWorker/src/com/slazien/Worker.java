package com.slazien;

public class Worker {

    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker) {
        // only completes when the thread owns the resource and the other thread is not active
        while (active) {
            // check if thread owns the shared resource
            if (sharedResource.getOwner() != this) {
                // if not, wait 10ms and check again
                try {
                    wait(10);
                } catch (InterruptedException e) {

                }
                continue;
            }

            // thread checks if the other thread is active
            if (otherWorker.isActive()) {
                // if yes, give the shared resource to the other thread and loop back
                System.out.println(getName() + " : give the resource to the worker " + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            // if other thread not active, uses the shared resource and loops back
            System.out.println(getName() + " working on the common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}
