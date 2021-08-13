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
    //@OneToMany(cascade = CascadeType.ALL, targetEntity = Account.class)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "net_worth")
    private float net_worth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public float getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(float net_worth) {
        this.net_worth = net_worth;
    }


}
