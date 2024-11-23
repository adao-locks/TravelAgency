package com.example.agenciaViagens.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destinyName;

    private String location;

    private static Double notaMedia = 0.0;

    private static Integer totalAvaliations = 0;

    public static Double getNotaMedia() {
        return notaMedia;
    }

    public static void setNotaMedia(Double notaMedia) {
        Task.notaMedia = notaMedia;
    }

    public static Integer getTotalAvaliation() {
        return totalAvaliations;
    }

    public static void setTotalAvaliation(Integer totalAvaliation) {
        Task.totalAvaliations = totalAvaliation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinyName() {
        return destinyName;
    }

    public void setDestinyName(String destinyName) {
        this.destinyName = destinyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
