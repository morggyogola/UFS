package com.example.CVMParams.cvm;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "CARD_CONFIGURATION")
@Data

public class CardConfiguration {
    //
//    @GenericGenerator(
//            name = "CARD_CONFIGURATION_SEQ",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TMS_APP_SEQ"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
//
//    @GeneratedValue(generator = "CARD_CONFIGURATION_SEQ")
    @Id
    @Column(name = "CARD_CONFIGURATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cardConfigurationId;

    @Column(name = "CARD_LIMIT_ID")
    private Long cardLimitId;

    @ManyToOne
    @JoinColumn(name = "CARD_LIMIT_ID", insertable = false, updatable = false, referencedColumnName = "CARD_LIMIT_ID")
    private CardLimit cardLimit;

    @Column(name = "CARD_TYPE_ID")
    private Long cardTypeId;

    @ManyToOne
    @JoinColumn(name = "CARD_TYPE_ID", insertable = false, updatable = false, referencedColumnName = "CARD_TYPE_ID")
    private CardType cardType;

    @Column(name = "MCC_ID")
    private Long mccId;

    @Column(name = "BIN_RANGE_MINIMUM", length = 100)
    private Integer binRangeMinimum;

    @Column(name = "BIN_RANGE_MAXIMUM", length = 100)
    private Integer binRangeMaximum;

    @Column(name = "AID", length = 100)
    private String AID;

    @Column(name = "AID_NAME", length = 100)
    private String AIDName;

    @Column(name = "FLOOR_LIMIT", length = 100)
    private BigDecimal floorLimit;

    @Column(name = "TRANSACTION_LIMIT", length = 100)
    private BigDecimal transactionLimit;

    @Column(name = "CVM_LIMIT", length = 100)
    private BigDecimal CVMLimit;

    @ManyToMany(mappedBy = "configurations")
    private List<CardProfile> profiles;

    @ManyToOne
    @JoinColumn(name = "MCC_ID", insertable = false, updatable = false, referencedColumnName = "MCC_ID")
    private MCC  mcc;


    public MCC getMcc() {
        return mcc;
    }

    public void setMcc(MCC mcc) {
        this.mcc = mcc;
    }

    public Long getCardConfigurationId() {
        return cardConfigurationId;
    }

    public void setCardConfigurationId(Long cardConfigurationId) {
        this.cardConfigurationId = cardConfigurationId;
    }

    public Long getCardLimitId() {
        return cardLimitId;
    }

    public void setCardLimitId(Long cardLimitId) {
        this.cardLimitId = cardLimitId;
    }

    public Long getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Long cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public Long getMccId() {
        return mccId;
    }

    public void setMccId(Long mccId) {
        this.mccId = mccId;
    }

    public Integer getBinRangeMinimum() {
        return binRangeMinimum;
    }

    public void setBinRangeMinimum(Integer binRangeMinimum) {
        this.binRangeMinimum = binRangeMinimum;
    }

    public Integer getBinRangeMaximum() {
        return binRangeMaximum;
    }

    public void setBinRangeMaximum(Integer binRangeMaximum) {
        this.binRangeMaximum = binRangeMaximum;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public String getAIDName() {
        return AIDName;
    }

    public void setAIDName(String AIDName) {
        this.AIDName = AIDName;
    }

    public BigDecimal getFloorLimit() {
        return floorLimit;
    }

    public void setFloorLimit(BigDecimal floorLimit) {
        this.floorLimit = floorLimit;
    }

    public BigDecimal getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(BigDecimal transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public BigDecimal getCVMLimit() {
        return CVMLimit;
    }

    public void setCVMLimit(BigDecimal CVMLimit) {
        this.CVMLimit = CVMLimit;
    }

    public List<CardProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<CardProfile> profiles) {
        this.profiles = profiles;
    }

    public CardLimit getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(CardLimit cardLimit) {
        this.cardLimit = cardLimit;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
