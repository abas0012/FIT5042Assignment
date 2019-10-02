/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * Main 
 * @author Adhi Baskoro
 */
@Entity //Declaring the Entity class
@NamedQueries({
@NamedQuery(name = ClassSession.GET_ALL_QUERY_NAME, query = "SELECT c FROM ClassSession c order by c.classSessionId desc")})
public class ClassSession implements Serializable{

    public static final String GET_ALL_QUERY_NAME = "ClassSession.getAll";

    private int classSessionId;
    private int sessionDuration;
    private String sessionDescription;
    private String sessionSchedule;

    private Location sessionLocation;
    private User user;

    private Set<String> tags;

    public ClassSession() {
        this.tags = new HashSet<>();
    }

    public ClassSession(int classSessionId, int sessionDuration, String sessionDescription, String sessionSchedule, Location sessionLocation, User user, Set<String> tags) {
        this.classSessionId = classSessionId;
        this.sessionDuration = sessionDuration;
        this.sessionDescription = sessionDescription;
        this.sessionSchedule = sessionSchedule;
        this.sessionLocation = sessionLocation;
        this.user = user;
        this.tags = tags;
    }

    /**
    * Get the value of classSessionId
    *
    * @return the value of classSessionId
    */
    @Id     
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//generate Id in a sequenced order
    @Column(name = "class_session_id")
    public int getClassSessionId() {
        return classSessionId;
    }

    public void setClassSessionId(int classSessionId) {
        this.classSessionId = classSessionId;
    }
    
    @Embedded
    public Location getSessionLocation() {
        return sessionLocation;
    }

    public void setSessionLocation(Location sessionLocation) {
        this.sessionLocation = sessionLocation;
    }

        public int getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(int sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    @Column(name = "description")
    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    @Column(name = "schedule")
    public String getSessionSchedule() {
        return sessionSchedule;
    }

    public void setSessionSchedule(String sessionSchedule) {
        this.sessionSchedule = sessionSchedule;
    }
    
    @ManyToOne //Many Class Session to One user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ElementCollection
    @CollectionTable(name = "tag")
    @Column(name = "value")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ClassSession{" + "classSessionId=" + classSessionId + ", sessionLocation=" + sessionLocation + ", sessionDuration=" + sessionDuration + ", sessionDescription=" + sessionDescription + ", sessionSchedule=" + sessionSchedule + '}';
    }
    
}
