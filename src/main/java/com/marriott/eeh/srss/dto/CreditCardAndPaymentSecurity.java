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
        "cardType",
        "cvvForGuarantee",
        "cvvForDeposit"
})
public class CreditCardAndPaymentSecurity {

    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("cvvForGuarantee")
    private Boolean cvvForGuarantee;
    @JsonProperty("cvvForDeposit")
    private Boolean cvvForDeposit;
}
