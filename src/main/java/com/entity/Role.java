package com.entity;


import javax.persistence.*;

/**
 * Created by user on 15.03.2016.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonProperty("id")
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_name", nullable = false)
//    @JsonProperty("roleName")
    private String roleName = RoleTypes.USER.getUserProfileType();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}