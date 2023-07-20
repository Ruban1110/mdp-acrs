package com.marriott.eeh.srss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class RateConfigSearchResponse {

    @JsonProperty("data")
    private List<Datam> data;
}
