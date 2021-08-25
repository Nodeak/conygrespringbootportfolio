package com.conygre.training.springboot.SpringBootPortfolioAPI.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="Holdings")
public class Holdings implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "buy_price")
    private float buyPrice;

    @Column(name = "cur_price")
    private float curPrice;

    @Column(name = "buy_date")
    private Date buyDate;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(float curPrice) {
        this.curPrice = curPrice;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getBuy_price() {
        return buyPrice;
    }

    public void setBuy_price(float buyPrice) {
        this.buyPrice = buyPrice;
    }
}
