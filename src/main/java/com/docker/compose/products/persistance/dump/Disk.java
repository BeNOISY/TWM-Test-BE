package com.docker.compose.products.persistance.dump;

import com.docker.compose.products.persistance.entities.Product;

public class Disk extends Product {

    private long capacity;
    private long lifetime;
    private String diskType;


    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getLifetime() {
        return lifetime;
    }

    public void setLifetime(long lifetime) {
        this.lifetime = lifetime;
    }

    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }
}
