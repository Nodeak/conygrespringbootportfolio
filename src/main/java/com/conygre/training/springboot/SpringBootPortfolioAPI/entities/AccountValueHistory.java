package com.conygre.training.springboot.SpringBootPortfolioAPI.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="accountvaluehistory")
public class AccountValueHistory {

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

    @Column(name = "net_worth")
    private float netWorth;
    public float getNetWorth() { return netWorth; }
    public void setNetWorth(float netWorth) { this.netWorth = netWorth; }

    @Column(name = "closing_date")
    private Date closingDate;
    public Date getClosingDate() { return closingDate; }
    public void setClosingDate(Date closingDate) { this.closingDate = closingDate; }
}
