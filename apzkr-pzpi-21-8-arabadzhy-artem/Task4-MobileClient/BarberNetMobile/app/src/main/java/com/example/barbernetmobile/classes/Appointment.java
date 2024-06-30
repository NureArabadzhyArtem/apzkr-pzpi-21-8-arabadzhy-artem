package com.example.barbernetmobile.classes;

/// Appointment.java
public class Appointment {
    private String _id;
    private String date;
    private String worker;
    private String service;
    // Getters and setters
    public String getId() {
        return _id;
    }
    public void setId(String id) {
        this._id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getWorker() {
        return worker;
    }
    public void setWorker(String worker) {
        this.worker = worker;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
}
