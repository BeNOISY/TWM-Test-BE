package com.docker.compose.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductDB")
public class Product {

    @Id
    private long _id;

    @NotBlank
    @Size(max = 100)
    private String name;
    private String type;
    private float price;
    private long count;
    private String description;

    //    Disky
    private long capacity;
    private long lifetime;
    private String disctype;

    //    Procesory
    private String series;
    private long cores;
    private long threads;
    private String socket;

    //    Grafika
    private long memory;
    private String ports;

    //    Materská doska
    private String backlight;

    //    Sieťová karta
    private long speed;
    private String os;

    //    Zdroj
    private String plug;
    private long watts;
    private boolean modular;
    private long pins;

    //    Chladenie
    private String coolingtype;


    public long getId() {
        return _id;
    }
    public void setId(long id) {
        this._id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
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
    public String getDisctype() {
        return disctype;
    }
    public void setDisctype(String disctype) {
        this.disctype = disctype;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public long getCores() {
        return cores;
    }
    public void setCores(long cores) {
        this.cores = cores;
    }
    public long getThreads() {
        return threads;
    }
    public void setThreads(long threads) {
        this.threads = threads;
    }
    public String getSocket() {
        return socket;
    }
    public void setSocket(String socket) {
        this.socket = socket;
    }
    public long getMemory() {
        return memory;
    }
    public void setMemory(long memory) {
        this.memory = memory;
    }
    public String getPorts() {
        return ports;
    }
    public void setPorts(String ports) {
        this.ports = ports;
    }
    public String getBacklight() {
        return backlight;
    }
    public void setBacklight(String backlight) {
        this.backlight = backlight;
    }
    public long getSpeed() {
        return speed;
    }
    public void setSpeed(long speed) {
        this.speed = speed;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getPlug() {
        return plug;
    }
    public void setPlug(String plug) {
        this.plug = plug;
    }
    public long getWatts() {
        return watts;
    }
    public void setWatts(long watts) {
        this.watts = watts;
    }
    public boolean getModular() {
        return modular;
    }
    public void setModular(boolean modular) {
        this.modular = modular;
    }
    public long getPins() {
        return pins;
    }
    public void setPins(long pins) {
        this.pins = pins;
    }
    public String getCoolingtype() {
        return coolingtype;
    }
    public void setCoolingtype(String coolingtype) {
        this.coolingtype = coolingtype;
    }
}
