package com.example.CVMParams.cvm;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "MCC")
public class MCC {
    /*@GenericGenerator(
            name = "MCC_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TMS_APP_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @GeneratedValue(generator = "MCC_SEQ")*/
    @Id
    @Column(name = "MCC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long mccId;

    @Column(name = "MCC_NAME", length = 100)
    @Size(min = 1,max = 100)
    private  String mccName;

    @Column(name = "MCC_DESCRIPTION", length = 100)
    @Size(min = 1,max = 100)
    private  String mccDescription;

    @OneToMany(mappedBy = "mcc")
    private List<CardConfiguration> cardConfigurations;

    public List<CardConfiguration> getCardConfigurations() {
        return cardConfigurations;
    }

    public void setCardConfigurations(List<CardConfiguration> cardConfigurations) {
        this.cardConfigurations = cardConfigurations;
    }

    public Long getMccId() {
        return mccId;
    }

    public void setMccId(Long mccId) {
        this.mccId = mccId;
    }

    public String getMccName() {
        return mccName;
    }

    public void setMccName(String mccName) {
        this.mccName = mccName;
    }

    public String getMccDescription() {
        return mccDescription;
    }

    public void setMccDescription(String mccDescription) {
        this.mccDescription = mccDescription;
    }
}
