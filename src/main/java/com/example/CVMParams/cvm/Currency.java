package com.example.CVMParams.cvm;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "CARD_CURRENCY")
public class Currency {

    /*@GenericGenerator(
            name = "CURRENCY_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TMS_APP_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @GeneratedValue(generator = "CURRENCY_SEQ")*/
    @Id
    @Column(name = "CURRENCY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;

    @Column(name = "CURRENCY_SYMBOL", length = 100)
    private String symbol;

    @Column(name = "CURRENCY_CODE", length = 4)
    private Long code;

    @Column(name = "COUNTRY_CODE", length = 100)
    private String countryCode;

    @OneToMany(mappedBy = "currency")
    private List<CardLimit> cardLimitList;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<CardLimit> getCardLimitList() {
        return cardLimitList;
    }

    public void setCardLimitList(List<CardLimit> cardLimitList) {
        this.cardLimitList = cardLimitList;
    }
}
