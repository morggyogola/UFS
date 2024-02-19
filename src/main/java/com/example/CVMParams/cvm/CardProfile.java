package com.example.CVMParams.cvm;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "CARD_PROFILE")
@Data
public class CardProfile {

    @Id
    @Column(name = "CARD_PROFILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cardProfileId;

    @Column(name = "CARD_NAME", length = 100)
    @Size(min = 1,max = 100)
    private String name;

    @Column(name = "DESCRIPTION", length = 100)
    @Size(min = 1,max = 100)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "PROFILE_CONFIGURATION",
            joinColumns = @JoinColumn(name = "PROFILE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONFIGURATION_ID")
    )
    private List<CardConfiguration> configurations;

    public Long getCardProfileId() {
        return cardProfileId;
    }

    public void setCardProfileId(Long cardProfileId) {
        this.cardProfileId = cardProfileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CardConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<CardConfiguration> configurations) {
        this.configurations = configurations;
    }
}
