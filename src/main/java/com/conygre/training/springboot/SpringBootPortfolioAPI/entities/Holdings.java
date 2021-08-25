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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "account_id")
    private int accountId;
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Column(name = "type")
    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "symbol")
    private String symbol;
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    @Column(name = "buy_price")
    private float buyPrice;
    public float getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Column(name = "amount")
    private int amount;
    public float getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Column(name = "cur_price")
    private float curPrice;
    public float getCurPrice() {
        return curPrice;
    }
    public void setCurPrice(float curPrice) {
        this.curPrice = curPrice;
    }

    @Column(name = "buy_date")
    private Date buyDate;
    public Date getBuyDate() {
        return buyDate;
    }
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }


    @Column(name = "percent_change")
    private float percentChange;
    public float getPercentChange() {
        return percentChange;
    }
    public void setPercentChange(float percentChange) {
        this.percentChange = percentChange;
    }


}
