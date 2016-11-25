package com.example.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Train")
public class Train {
	
	@Id
    private String id;
	
    private String name;
    private Integer speed;
    private Boolean diesel;

    public Train() { }

    public Train(String id, String name, Integer speed, Boolean diesel) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.diesel = diesel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Boolean getDiesel() {
        return diesel;
    }

    public void setDiesel(Boolean diesel) {
        this.diesel = diesel;
    }
}