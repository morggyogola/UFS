package com.example.CVMParams.cvm;

import javax.persistence.*;

@Entity
@Table(name = "PROFILE_CONFIGURATION")
public class CardProfileConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "CONFIGURATION_ID")
    private Long cardConfigurationId;

    @ManyToOne
    @JoinColumn(name = "CONFIGURATION_ID", referencedColumnName = "CARD_CONFIGURATION_ID", insertable = false, updatable = false)
    private CardConfiguration configuration;

    @Column(name = "PROFILE_ID")
    private Long cardProfileId;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "CARD_PROFILE_ID", insertable = false, updatable = false)
    private CardProfile cardProfile;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getCardConfigurationId() {
        return cardConfigurationId;
    }

    public void setCardConfigurationId(Long cardConfigurationId) {
        this.cardConfigurationId = cardConfigurationId;
    }

    public CardConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CardConfiguration configuration) {
        this.configuration = configuration;
    }

    public Long getCardProfileId() {
        return cardProfileId;
    }

    public void setCardProfileId(Long cardProfileId) {
        this.cardProfileId = cardProfileId;
    }

    public CardProfile getCardProfile() {
        return cardProfile;
    }

    public void setCardProfile(CardProfile cardProfile) {
        this.cardProfile = cardProfile;
    }
}
