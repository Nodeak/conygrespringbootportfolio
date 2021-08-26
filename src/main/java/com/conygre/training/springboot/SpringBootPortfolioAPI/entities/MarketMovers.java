package com.conygre.training.springboot.SpringBootPortfolioAPI.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="marketmovers")
public class MarketMovers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "current_price")
    private float currentPrice;

    @Column(name = "percent_change")
    private float percentChange;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(float percentChange) {
        this.percentChange = percentChange;
    }
}
