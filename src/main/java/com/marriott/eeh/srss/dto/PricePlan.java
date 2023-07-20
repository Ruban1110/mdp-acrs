package com.marriott.eeh.srss.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "taxInclusion",
        "isApplicableToAllRoomTypes",
        "extraPersonCharge",
        "yieldManagementType",
        "amountRules"
})
@Data
@Getter
@Setter
@NoArgsConstructor
public class PricePlan {

    @JsonProperty("type")
    private String type;
    @JsonProperty("taxInclusion")
    private String taxInclusion;
    @JsonProperty("isApplicableToAllRoomTypes")
    private Boolean isApplicableToAllRoomTypes;
    @JsonProperty("extraPersonCharge")
    private String extraPersonCharge;
    @JsonProperty("yieldManagementType")
    private String yieldManagementType;
    @JsonProperty("amountRules")
    private List<AmountRule> amountRules;
}
