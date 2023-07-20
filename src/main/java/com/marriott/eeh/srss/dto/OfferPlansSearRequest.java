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
        "data"
})
@Getter
@Data
@Setter
@NoArgsConstructor
public class OfferPlansSearRequest {

    @JsonProperty("data")
    private Data data;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "page",
            "type",
            "name"
    })
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Data {

        @JsonProperty("page")
        private Page page;
        @JsonProperty("type")
        private String type;
        @JsonProperty("name")
        private String name;
    }
}
