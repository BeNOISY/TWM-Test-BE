package com.docker.compose.products.persistance.dump;

import com.docker.compose.products.persistance.entities.Product;

public class NIC extends Product {

    //NIC
    private String nicPorts;
    private long maxSpeed;
    private String os;

    public String getNicPorts() {
        return nicPorts;
    }

    public void setNicPorts(String nicPorts) {
        this.nicPorts = nicPorts;
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
