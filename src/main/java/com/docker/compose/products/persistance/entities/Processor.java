package com.docker.compose.products.persistance.entities;

public class Processor extends Product{

    private String serie;
    private long cores;
    private long threads;
    private String prcSocket;


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
}
