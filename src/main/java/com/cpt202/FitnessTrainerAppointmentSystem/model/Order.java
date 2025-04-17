package com.cpt202.FitnessTrainerAppointmentSystem.model;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "price")
    private Double price;

    @Column(name = "subscribing_date")
    @Temporal(TemporalType.DATE)
    private Date subscribingDate;

    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "final_price")
    private Double finalPrice;

    @Column(name = "name_on_card")
    private String name_on_card;

    @Column(name = "card_number")
    private Long card_number;

    @Column(name = "card_expire_date")
    @Temporal(TemporalType.DATE)
    private Date cardExpireDate;

    @Column(name = "cvv_number")
    private Integer cvv_number;

    @Column(name = "postcode")
    private Integer postcode;

    // Getters
    public int getId() {
        return id;
    }


    public String getPlanName() {
        return planName;
    }

    public Double getPrice() {
        return price;
    }

    public Date getSubscribingDate() {
        return subscribingDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public String getName_on_card(){ return name_on_card; }

    public Long getCard_number() { return card_number; }

    public Date getCardExpireDate() { return cardExpireDate; }

    public Integer getCvv_number() { return cvv_number; }

    public Integer getPostcode() { return postcode; }

    // Setters
    public void setId(int id) {
        this.id = id;
    }


    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSubscribingDate(Date subscribingDate) {
        this.subscribingDate = subscribingDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setName_on_card(String name_on_card) { this.name_on_card = name_on_card; }

    public void setCard_number(Long card_number) { this.card_number = card_number; }

    public void setCardExpireDate(Date cardExpireDate) { this.cardExpireDate = cardExpireDate; }

    public void setCvv_number(Integer cvv_number) { this.cvv_number = cvv_number; }

    public void setPostcode(Integer postcode) { this.postcode = postcode; }

}