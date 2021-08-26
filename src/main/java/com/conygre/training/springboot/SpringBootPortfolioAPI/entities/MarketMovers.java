package com.conygre.training.springboot.SpringBootPortfolioAPI.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="marketMovers")
public class MarketMovers implements Serializable {

    @Id
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "currentPrice")
    private float currentPrice;

    @Column(name = "percentChange")
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
