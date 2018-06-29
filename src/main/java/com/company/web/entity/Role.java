package com.company.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
/**
 * 
 */
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name")
    private String name;
/**
 * Getter for id.
 * @return got id of role from database.
 */
    public Integer getId() {
        return id;
    }
/**
 * Setter for id.
 * @param id id of role.
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 * Getter for name.
 * @return got name of role from database.
 */
    public String getName() {
        return name;
    }
/**
 * Setter for name.
 * @param name name of role.
 */
    public void setName(String name) {
        this.name = name;
    }

}
