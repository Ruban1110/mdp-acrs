package com.marriott.eeh.srss.service;

import com.marriott.eeh.srss.dto.RateConfigSearchResponse;

public interface RateConfigurationService {

    RateConfigSearchResponse searchRateRule(String ratePlanCode, String fromDate, String toDate);
}
