package com.conygre.training.springboot.SpringBootPortfolioAPI.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Account")
public class Account implements Serializable{
    //TEMP
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "cash_value")
    private Float cash_value;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCash_value() {
        return cash_value;
    }

    public void setCash_value(Float cash_value) {
        this.cash_value = cash_value;
    }

}
