package com.example.CVMParams.cvm;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "CARD_TYPE")
public class CardType {

    /*@GenericGenerator(
            name = "CARD_TYPE_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TMS_APP_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @GeneratedValue(generator = "CARD_TYPE_SEQ")*/
    @Id
    @Column(name = "CARD_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cardTypeId;

    @Column(name = "CARD_NAME", length = 100)
    @Size(min = 1, max = 100)
    private String cardName;

    @OneToMany(mappedBy = "cardType")
    private List<CardConfiguration> cardConfigurations;

    public Long getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Long cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public List<CardConfiguration> getCardConfigurations() {
        return cardConfigurations;
    }

    public void setCardConfigurations(List<CardConfiguration> cardConfigurations) {
        this.cardConfigurations = cardConfigurations;
    }
}
