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
        "code"
})
@Data
@Getter
@Setter
@NoArgsConstructor
public class RatePlan {

    @JsonProperty("code")
    public String code;
}
