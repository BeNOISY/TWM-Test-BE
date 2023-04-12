package com.docker.compose.products.persistance.dump;


import com.docker.compose.products.persistance.entities.Product;

public class PSU extends Product {

    private String plug;
    private long pins;
    private long watts;
    private boolean modular;


    public String getPlug() {
        return plug;
    }

    public void setPlug(String plug) {
        this.plug = plug;
    }

    public long getPins() {
        return pins;
    }

    public void setPins(long pins) {
        this.pins = pins;
    }

    public long getWatts() {
        return watts;
    }

    public void setWatts(long watts) {
        this.watts = watts;
    }

    public boolean isModular() {
        return modular;
    }

    public void setModular(boolean modular) {
        this.modular = modular;
    }
}
