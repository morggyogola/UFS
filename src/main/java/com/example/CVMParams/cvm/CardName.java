package com.example.CVMParams.cvm;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "CARD_NAMES")
@Data
public class CardName {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cardId;

    @Column(name = "CARD_NAME", length = 100)
    private String name;

    @Column(name = "AID_NAME", length = 100)
    private String AIDName;

    @Column(name = "AID", length = 100)
    private String AID;

    @OneToMany(mappedBy = "cardName")
    private List<CardLimit> cardLimits;

    public List<CardLimit> getCardLimitList() {
        return cardLimits;
    }

    public void setCardLimitList(List<CardLimit> cardLimitList) {
        this.cardLimits = cardLimitList;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAIDName() {
        return AIDName;
    }

    public void setAIDName(String AIDName) {
        this.AIDName = AIDName;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }
}
