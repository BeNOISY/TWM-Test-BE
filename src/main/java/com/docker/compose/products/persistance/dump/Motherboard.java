package com.docker.compose.products.persistance.dump;

import com.docker.compose.products.persistance.entities.Product;

public class Motherboard extends Product {

    //MotherBoard
    private String socket;
    private String ports;
    private boolean backlight;


    public String getSocket() {return socket;}

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public void setBacklight(boolean backlight) {
        this.backlight = backlight;
    }
}
