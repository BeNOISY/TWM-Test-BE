package com.docker.compose.products.persistance.entity;

import org.springframework.data.mongodb.core.mapping.Document;


public class Specifics {


    //PSU
    public String plug;
    public long pins;
    public long watts;
    public boolean modular;


    //NIC
    public String nicPorts;
    public long maxSpeed;
    public String os;


    //MotherBoard
    public String mbSocket;
    public String mbPorts;
    public boolean backlight;


    //Processors
    public String serie;
    public long cores;
    public long threads;
    public String prcSocket;

    //Disks
    public long capacity;
    public long lifetime;
    public String diskType;



    //PSU ------------
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

    // ---------------------

    //NIC ------------
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

    // -----------------

    //Motherboards

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
    //------------

    //Processors
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    public String getPrcSocket() {
        return prcSocket;
    }

    public void setPrcSocket(String prcSocket) {
        this.prcSocket = prcSocket;
    }
    //----------------

    //Disks
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
    //------------
}
