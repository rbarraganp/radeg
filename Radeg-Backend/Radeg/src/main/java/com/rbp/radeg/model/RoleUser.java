
package com.rbp.radeg.model;

import jakarta.persistence.*;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;

import java.io.Serializable;
import java.util.List;


@Entity
@Table (name = "ROLE_USER")
public class RoleUser implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROLE")
    private short idRoleUser;

    @Column(name= "NAME", nullable = false, unique = true)
    private String name;


    //RELATIONS

    //*** USER ***
    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "role")
    private List<User> userList;

    //BUILDER
    public RoleUser() {}
    public RoleUser(String name) { this.name = name;}

    //GETTER AND SETTER

    public short getIdRoleUser() { return idRoleUser;}
    public void setIdRoleUser(short idRoleUser) { this.idRoleUser = idRoleUser;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name.toUpperCase();}

    public List<User> getUserList() { return userList;}
    public void setUserList(List<User> userList) { this.userList = userList;}


    //METHODS

}


