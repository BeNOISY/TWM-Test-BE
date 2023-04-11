package com.docker.compose.products.persistance.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductPSU")
public class PSU {
    private long watts;
    private boolean modular;

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
