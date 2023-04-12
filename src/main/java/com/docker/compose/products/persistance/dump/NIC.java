package com.docker.compose.products.persistance.dump;

import com.docker.compose.products.persistance.entities.Product;

public class NIC extends Product {

    //NIC
    private String ports;
    private long maxSpeed;
    private String os;

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
