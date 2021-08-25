package com.conygre.training.springboot.SpringBootPortfolioAPI.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Column(name = "first_name")
    private String firstName;
    public String getFirst_name() {
        return firstName;
    }
    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    private String lastName;
    public String getLast_name() {
        return lastName;
    }
    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "net_worth")
    private float netWorth;
    public float getNet_worth() {
        return netWorth;
    }
    public void setNet_worth(float netWorth) {
        this.netWorth = netWorth;
    }

    public User(){}

    public User(String fn, String ln, float nw){
        firstName = fn;
        lastName = ln;
        netWorth = nw;
    }










}
