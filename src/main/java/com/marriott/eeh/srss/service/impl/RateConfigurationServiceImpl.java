package com.marriott.eeh.srss.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marriott.eeh.srss.dto.RateConfigSearchResponse;
import com.marriott.eeh.srss.service.RateConfigurationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RateConfigurationServiceImpl implements RateConfigurationService {

    /**
     * @param ratePlanCode : ratePlanCode
     * @param fromDate: fromDate
     * @param toDate: toDate
     * @return Object
     */
    @Override
    public RateConfigSearchResponse searchRateRule(String ratePlanCode, String fromDate, String toDate) {
        log.info("Request to search RateRuleConfiguration for ratePlanCode:{},  from: {} and toDate: {}", ratePlanCode, fromDate, toDate);
        RateConfigSearchResponse rateConfigSearchResponse = new RateConfigSearchResponse();
        return getMockApiCall(rateConfigSearchResponse);
    }

    private RateConfigSearchResponse getMockApiCall(RateConfigSearchResponse rateConfigSearchResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString =  "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"ratePlan\": {\n" +
                "        \"code\": \"RT007\"\n" +
                "      },\n" +
                "      \"rateConfigurationRules\": [\n" +
                "        {\n" +
                "          \"period\": {\n" +
                "            \"start\": \"2022-09-01\",\n" +
                "            \"end\": \"2022-12-31\",\n" +
                "            \"dow\": \"M-WT-SS\"\n" +
                "          },\n" +
                "          \"isRateMatch\": true,\n" +
                "          \"performAutoBuild\": true,\n" +
                "          \"isCommissionable\": true,\n" +
                "          \"allowTierSetup\": false,\n" +
                "          \"hasExtraPersonCharge\": true,\n" +
                "          \"reference\": {\n" +
                "            \"codeType\": \"PriceGrid\",\n" +
                "            \"code\": \"AA5\"\n" +
                "          },\n" +
                "          \"pricePlan\": {\n" +
                "            \"type\": \"AmountOff\",\n" +
                "            \"taxInclusion\": \"IncludedInRate\",\n" +
                "            \"isApplicableToAllRoomTypes\": true,\n" +
                "            \"extraPersonCharge\": \"100.00\",\n" +
                "            \"yieldManagementType\": \"AtBestFlexibleRate\",\n" +
                "            \"amountRules\": [\n" +
                "              {\n" +
                "                \"inventoryTypes\": {\n" +
                "                  \"ABSN\": [\n" +
                "                    {\n" +
                "                      \"computationType\": \"AmountOff\",\n" +
                "                      \"min\": \"20.00\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"computationType\": \"Flat\",\n" +
                "                      \"max\": \"250.00\",\n" +
                "                      \"subType\": \"Ceiling\"\n" +
                "                    }\n" +
                "                  ],\n" +
                "                  \"KNGN\": [\n" +
                "                    {\n" +
                "                      \"computationType\": \"AmountOff\",\n" +
                "                      \"min\": \"20.00\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"computationType\": \"Flat\",\n" +
                "                      \"max\": \"210.00\",\n" +
                "                      \"subType\": \"Ceiling\"\n" +
                "                    }\n" +
                "                  ],\n" +
                "                  \"KNGS\": [\n" +
                "                    {\n" +
                "                      \"computationType\": \"AmountOff\",\n" +
                "                      \"min\": \"20.00\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"computationType\": \"Flat\",\n" +
                "                      \"max\": \"300.00\",\n" +
                "                      \"subType\": \"Ceiling\"\n" +
                "                    }\n" +
                "                  ]\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        try {
            rateConfigSearchResponse = objectMapper.readValue(jsonString, RateConfigSearchResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return rateConfigSearchResponse;
    }
}
