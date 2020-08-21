package com.example.jwtdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<Credential> credentials;

    public Long getId() {
        return id;
    }

    public void setId(Long courseid) {
        this.id = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }
}