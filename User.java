/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Adhi Baskoro
 */
@Entity
@Table(name = "USER")
@NamedQueries({@NamedQuery(name = User.GET_ALL_QUERY_NAME, query = "SELECT u FROM User u")})
public class User implements Serializable{

    public User() {
    }

    public User(int userId, String name, String email, String password, Set<ClassSession> classSession) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.classSession = new HashSet<>();
    }

    
    public static final String GET_ALL_QUERY_NAME = "User.getAll";
    
    private int userId;
    private String name;
    private String email;
    private String password;
    
    private Set<ClassSession> classSession;
    
    @Id
    @GeneratedValue
    @Column(name = "user_Id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    public Set<ClassSession> getClassSession() {
        return classSession;
    }

    public void setClassSession(Set<ClassSession> classSession) {
        this.classSession = classSession;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.userId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.userId + " - " + name + " - " + email;
    }
    
    
    
}
