package com.example.CVMParams.cvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CardProfileService {
    @Autowired
    private CardProfileRepository cardProfileRepository;
    @Autowired
    private CardConfigurationRepository cardConfigurationRepository;
    @Autowired
    private CardLimitRepository cardLimitRepository;
    @Autowired
    private CardNameRepository cardNameRepository;

    public void generateSimulatedData(Long profileId) {
        generateFileFromRepositories(profileId);
    }

    private void generateFileFromRepositories(Long profileId) {
//        try (FileWriter fileWriter = new FileWriter("output.csv")) {
        Optional<CardProfile> cardProfiles = cardProfileRepository.findById(profileId);
        if (cardProfiles.isPresent()) {
            CardProfile cardProfile = cardProfiles.get();

            List<CardConfiguration> configurations = cardProfile.getConfigurations();

            Set<Long> customizedLimitsIds = new HashSet<>();

            int configSize = configurations.size();
            for (int c = 0; c < configSize; c++) {
                CardConfiguration configuration = configurations.get(c);
                CardLimit cardLimit = configuration.getCardLimit();
                customizedLimitsIds.add(cardLimit.getCardLimitId());
            }

            List<CardLimit> otherCardLimits = cardLimitRepository.findAllByCardLimitIdNotIn(customizedLimitsIds);
            List<CardLimit> cardLimitList = cardLimitRepository.findAllByCardLimitIdIsIn(customizedLimitsIds);


            StringBuilder defaultCardParams = new StringBuilder();
            for (CardLimit cardLimit : cardLimitList) {

                Currency currency = cardLimit.getCurrency();

                CardName cardName = cardLimit.getCardName();

                //default config
                StringBuilder defaultParams = new StringBuilder();
                defaultParams.append(currency.getCode()).append(";")
                        .append(cardName.getAID()).append(";")
                        .append(cardLimit.getCVMLimit().multiply(BigDecimal.valueOf(100)).longValue()).append(";")
                        .append(cardLimit.getTransactionLimit().multiply(BigDecimal.valueOf(100)).longValue()).append(";")
                        .append("NULL").append("|");


                //Loop custom configs
                List<CardConfiguration> cardConfigurations = cardLimit.getCardConfigurations();

                StringBuilder customCardParams = new StringBuilder();
                int configurationSize = cardConfigurations.size();
                for (int c = 0; c < configurationSize; c++) {
                    CardConfiguration configuration = configurations.get(c);
                    //conf params
                    StringBuilder customParams = new StringBuilder();
                    StringBuilder customBinParams = new StringBuilder();

                    customParams.append(configuration.getAID()).append(";");

                    for (int b = configuration.getBinRangeMinimum(); b <= configuration.getBinRangeMaximum(); b++) {
                        if (b != configuration.getBinRangeMaximum()) {
                            customBinParams.append(b).append("-");
                        } else {
                            customBinParams.append(b);
                        }
                    }
                    customParams.append(customBinParams).append(";")
                            .append(cardLimit.getCVMLimit().multiply(BigDecimal.valueOf(100)).longValue()).append(";")
                            .append(configuration.getTransactionLimit().multiply(BigDecimal.valueOf(100)).longValue()).append(";")
                            .append("NULL");

                    //end of config
                    if (c != configurationSize - 1) {
                        customCardParams.append(customParams).append(",");
                    } else {
                        customCardParams.append(customParams).append(":\n");
                    }

                }
                defaultParams.append(customCardParams);
                defaultCardParams.append(defaultParams);
            }

            for (CardLimit cardLimit : otherCardLimits) {
                Currency currency = cardLimit.getCurrency();

                CardName cardName = cardLimit.getCardName();

                StringBuilder defaultParams = new StringBuilder();
                defaultParams.append(currency.getCode()).append(";")
                        .append(cardName.getAID()).append(";")
                        .append(cardLimit.getCVMLimit().multiply(BigDecimal.valueOf(100)).longValue()).append(";")
                        .append(cardLimit.getTransactionLimit().multiply(BigDecimal.valueOf(100)).longValue()).append(";")
                        .append("NULL").append(":\n");

                defaultCardParams.append(defaultParams);
            }

            String string = defaultCardParams.toString();
            System.err.println("__________________________________________________________");
            System.err.println(string);
            System.err.println("___________________________________________________________");
            System.out.println("File generated successfully!");
        }else{
            System.err.println("Profile not found!");
        }
    }
}
