package com.example.CVMParams.cvm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CARD_LIMITS")
public class CardLimit {

    /*@GenericGenerator(
            name = "CARD_LIMITS_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TMS_APP_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @GeneratedValue(generator = "CARD_LIMITS_SEQ")*/
    @Id
    @Column(name = "CARD_LIMIT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cardLimitId;

    @Column(name = "CARD_ID")
    private Long CardId;


    @Column(name = "CVM_LIMIT", length = 100)
    private BigDecimal CVMLimit;

    @Column(name = "FLOOR_LIMIT", length = 100)
    private BigDecimal floorLimit;

    @Column(name = "TRANSACTION_LIMIT", length = 100)
    private BigDecimal transactionLimit;

    @Column(name = "CURRENCY_ID")
    private Long currencyId;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "CURRENCY_ID", insertable = false, updatable = false)
    private Currency currency;

    @OneToMany(mappedBy = "cardLimit")
    private List<CardConfiguration> cardConfigurations;
    @ManyToOne
    @JoinColumn(name = "CARD_ID",insertable = false, updatable = false, referencedColumnName = "CARD_ID")
    private  CardName cardName;

    public CardName getCardName() {
        return cardName;
    }

    public void setCardName(CardName cardName) {
        this.cardName = cardName;
    }

    public Long getCardLimitId() {
        return cardLimitId;
    }

    public void setCardLimitId(Long cardLimitId) {
        this.cardLimitId = cardLimitId;
    }

    public Long getCardId() {
        return CardId;
    }

    public void setCardId(Long cardId) {
        CardId = cardId;
    }

    public BigDecimal getCVMLimit() {
        return CVMLimit;
    }

    public void setCVMLimit(BigDecimal CVMLimit) {
        this.CVMLimit = CVMLimit;
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

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<CardConfiguration> getCardConfigurations() {
        return cardConfigurations;
    }

    public void setCardConfigurations(List<CardConfiguration> cardConfigurations) {
        this.cardConfigurations = cardConfigurations;
    }
}
