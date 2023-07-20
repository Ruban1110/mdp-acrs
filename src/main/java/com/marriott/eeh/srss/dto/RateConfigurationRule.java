package com.marriott.eeh.srss.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "period",
        "isRateMatch",
        "performAutoBuild",
        "isCommissionable",
        "allowTierSetup",
        "hasExtraPersonCharge",
        "reference",
        "pricePlan"
})
@Data
@Getter
@Setter
@NoArgsConstructor
public class RateConfigurationRule {

    @JsonProperty("period")
    private Period period;
    @JsonProperty("isRateMatch")
    private Boolean isRateMatch;
    @JsonProperty("performAutoBuild")
    private Boolean performAutoBuild;
    @JsonProperty("isCommissionable")
    private Boolean isCommissionable;
    @JsonProperty("allowTierSetup")
    private Boolean allowTierSetup;
    @JsonProperty("hasExtraPersonCharge")
    private Boolean hasExtraPersonCharge;
    @JsonProperty("reference")
    private Reference reference;
    @JsonProperty("pricePlan")
    private PricePlan pricePlan;
}
