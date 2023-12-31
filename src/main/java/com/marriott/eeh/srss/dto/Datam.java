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
        "ratePlan",
        "rateConfigurationRules"
})
@Data
@Getter
@Setter
@NoArgsConstructor
public class Datam {

    @JsonProperty("ratePlan")
    private RatePlan ratePlan;

    @JsonProperty("rateConfigurationRules")
    private List<RateConfigurationRule> rateConfigurationRules;
}
