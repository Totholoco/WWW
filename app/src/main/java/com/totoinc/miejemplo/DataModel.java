package com.totoinc.miejemplo;

public class DataModel {
    String name;
    String empresa;
    int id_;
    int image;

    public DataModel(String name, String empresa , int id_, int image) {
        this.name = name;
        this.empresa = empresa;
        this.id_ = id_;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getEmpresa() {
        return empresa;
    }
    public int getImage() {
        return image;
    }
    public int getId() {
        return id_;
    }
}