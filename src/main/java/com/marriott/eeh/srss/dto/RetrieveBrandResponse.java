package com.marriott.eeh.srss.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "warnings",
        "data"
})
public class RetrieveBrandResponse {

    @JsonProperty("warnings")
    public List<Object> warnings;
    @JsonProperty("data")
    public List<Datum> data;

    @JsonPropertyOrder({
            "chainCode",
            "code",
            "name",
            "version",
            "checkInWindow",
            "maxLengthOfStay",
            "maxOccupancy",
            "systemRange",
            "confirmReservationByEmail",
            "confirmReservationByFax",
            "isHouseFlowSellThroughRequired",
            "bookingHorizon",
            "groupBookingHorizon",
            "isForceOverrideAllowed",
            "isTraining",
            "currencies",
            "creditCardAndPaymentSecurities"
    })
    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Datum {
        @JsonProperty("chainCode")
        private String chainCode;
        @JsonProperty("code")
        private String code;
        @JsonProperty("name")
        private String name;
        @JsonProperty("version")
        private Integer version;
        @JsonProperty("checkInWindow")
        private Integer checkInWindow;
        @JsonProperty("maxLengthOfStay")
        private Integer maxLengthOfStay;
        @JsonProperty("maxOccupancy")
        private Integer maxOccupancy;
        @JsonProperty("systemRange")
        private Integer systemRange;
        @JsonProperty("confirmReservationByEmail")
        private Boolean confirmReservationByEmail;
        @JsonProperty("confirmReservationByFax")
        private Boolean confirmReservationByFax;
        @JsonProperty("isHouseFlowSellThroughRequired")
        private Boolean isHouseFlowSellThroughRequired;
        @JsonProperty("bookingHorizon")
        private Integer bookingHorizon;
        @JsonProperty("groupBookingHorizon")
        private Integer groupBookingHorizon;
        @JsonProperty("isForceOverrideAllowed")
        private Boolean isForceOverrideAllowed;
        @JsonProperty("isTraining")
        private Boolean isTraining;
        @JsonProperty("currencies")
        private List<Currency> currencies;
        @JsonProperty("creditCardAndPaymentSecurities")
        private List<CreditCardAndPaymentSecurity> creditCardAndPaymentSecurities;
    }
}
