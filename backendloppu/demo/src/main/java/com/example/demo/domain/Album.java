package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String desc;
    private String artist;
    private String recordLabel;

    @Column(name="publishing_year")
    private int publYear;
    private int price;

    @ManyToOne
    @JoinColumn(name="categoryid")
    @JsonIgnoreProperties("albums")
    private Category category;

    public Album(){}

    public Album(String title, String desc, String artist, String recordLabel, int publYear, int price, Category category){
        this.title = title;
        this.desc = desc;
        this.artist = artist;
        this.recordLabel = recordLabel;
        this.publYear = publYear;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public int getPublYear() {
        return this.publYear;
    }

    public void setPublYear(int publYear) {
        this.publYear = publYear;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
    
}
