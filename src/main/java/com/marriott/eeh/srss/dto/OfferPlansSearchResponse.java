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
        "meta",
        "data"
})
@Getter
@Data
@Setter
@NoArgsConstructor
public class OfferPlansSearchResponse {

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("data")
    private List<Datum> data;

    @Getter
    @Data
    @Setter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "count",
            "page"
    })
    public static class Meta {
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("page")
        private Page page;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "type",
            "id",
            "isActive",
            "code",
            "promoGroupCode",
            "qualifiers",
            "overrides",
            "segmentation",
            "ratePlans"
    })
    @Getter
    @Data
    @Setter
    @NoArgsConstructor
    private static class Datum {
        @JsonProperty("type")
        private String type;
        @JsonProperty("id")
        private String id;
        @JsonProperty("isActive")
        private Boolean isActive;
        @JsonProperty("code")
        private String code;
        @JsonProperty("promoGroupCode")
        private String promoGroupCode;
        @JsonProperty("qualifiers")
        private Qualifiers qualifiers;
        @JsonProperty("overrides")
        private Overrides overrides;
        @JsonProperty("segmentation")
        private Segmentation segmentation;
        @JsonProperty("ratePlans")
        private List<RatePlan> ratePlans;


        @Getter
        @Data
        @Setter
        @NoArgsConstructor
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "bookingPeriod",
                "stayPeriod"
        })
        private static class Qualifiers {
            @JsonProperty("bookingPeriod")
            private BookingPeriod bookingPeriod;
            @JsonProperty("stayPeriod")
            private StayPeriod stayPeriod;

            @Getter
            @Data
            @Setter
            @NoArgsConstructor
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "start",
                    "end"
            })
            private static class BookingPeriod {
                @JsonProperty("start")
                private String start;
                @JsonProperty("end")
                private String end;
            }

            @Getter
            @Data
            @Setter
            @NoArgsConstructor
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "start",
                    "end"
            })
            private static class StayPeriod {
                @JsonProperty("start")
                private String start;
                @JsonProperty("end")
                private String end;
            }
        }

        @Getter
        @Data
        @Setter
        @NoArgsConstructor
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "name",
                "description"
        })
        private static class Overrides {
            @JsonProperty("name")
            private String name;
            @JsonProperty("description")
            private String description;
        }

        @Getter
        @Data
        @Setter
        @NoArgsConstructor
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "brands",
                "regions"
        })
        private static class Segmentation {
            @JsonProperty("brands")
            private List<String> brands;
            @JsonProperty("regions")
            private List<String> regions;
        }
    }
}
