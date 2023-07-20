package com.marriott.eeh.srss.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
@NoArgsConstructor
public class InventoryTypes {

    @JsonProperty("ABSN")
    private List<Absn> absn;
    @JsonProperty("KNGN")
    private List<Kngn> kngn;

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class Absn {
        @JsonProperty("computationType")
        private String computationType;
        @JsonProperty("min")
        private String min;
        @JsonProperty("max")
        private String max;
        @JsonProperty("subType")
        private String subType;
    }

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class Kngn {
        @JsonProperty("computationType")
        private String computationType;
        @JsonProperty("min")
        private String min;
        @JsonProperty("max")
        private String max;
        @JsonProperty("subType")
        private String subType;
    }
}
