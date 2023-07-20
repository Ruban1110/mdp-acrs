package com.marriott.eeh.srss.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "currencyCode",
        "isDefault",
        "roundingLimit",
        "roundToClosest0",
        "roundToClosest5",
        "roundToClosest9"
})
public class Currency {

    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("isDefault")
    private Boolean isDefault;
    @JsonProperty("roundingLimit")
    private Integer roundingLimit;
    @JsonProperty("roundToClosest0")
    private Boolean roundToClosest0;
    @JsonProperty("roundToClosest5")
    private Boolean roundToClosest5;
    @JsonProperty("roundToClosest9")
    private Boolean roundToClosest9;
}
