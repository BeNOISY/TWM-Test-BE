package com.docker.compose.products.persistance.dump;

import com.docker.compose.products.persistance.entities.Product;

public class Motherboard extends Product {

    //MotherBoard
    private String mbSocket;
    private String mbPorts;
    private boolean backlight;


    public String getMbSocket() {
        return mbSocket;
    }

    public void setMbSocket(String mbSocket) {
        this.mbSocket = mbSocket;
    }

    public String getMbPorts() {
        return mbPorts;
    }

    public void setMbPorts(String mbPorts) {
        this.mbPorts = mbPorts;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public void setBacklight(boolean backlight) {
        this.backlight = backlight;
    }
}
