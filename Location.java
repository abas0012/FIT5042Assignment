/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Adhi Baskoro
 */
@Embeddable //Embeddable to Class Session class
@Access(AccessType.PROPERTY)//Access through ClassSession class' property
public class Location implements Serializable{

    private String suburb;
    private String postcode;
    private String state;
    
    public Location(String streetNumber, String streetAddress, String suburb, String postcode, String state) {
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    @Column(name = "suburb")
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return  suburb + ", " + postcode + ", " + state;
    }
}
