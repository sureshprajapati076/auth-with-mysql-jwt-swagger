package com.example.jwtdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="credentials")
public class Credential {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)

    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
    @JsonIgnoreProperties("credentials")

    private List<Role> roles;


    @OneToOne(
            mappedBy = "credential",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("credential")
   // @JsonIgnore
    @ApiModelProperty(hidden = true)
    private User user;

    public Credential() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
