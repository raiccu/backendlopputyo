package com.example.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long categoryid;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Album> albums;

    
    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
    public Long getCategoryid() {
        return categoryid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public List<Album> getMovies(){
        return albums;
    }

    public void setMovies(List<Album> albums) {
        this.albums = albums;
    }
}