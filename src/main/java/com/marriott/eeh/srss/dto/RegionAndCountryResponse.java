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
public class RegionAndCountryResponse {

    @JsonProperty("warnings")
    public List<Object> warnings;
    @JsonProperty("data")
    private List<Datum> data;

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "code", "name", "version", "countries"
    })
    public static class Datum {

        @JsonProperty("code")
        private String code;
        @JsonProperty("name")
        private String name;
        @JsonProperty("version")
        private int version;
        @JsonProperty("countries")
        private List<Country> countries;


        @Data
        @Getter
        @Setter
        @NoArgsConstructor
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({"code", "name"})
        public static class Country {
            @JsonProperty("code")
            private String code;
            @JsonProperty("name")
            private String name;
        }
    }
}
