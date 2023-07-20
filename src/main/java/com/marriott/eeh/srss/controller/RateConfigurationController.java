package com.marriott.eeh.srss.controller;


import com.marriott.eeh.srss.dto.RateConfigSearchResponse;
import com.marriott.eeh.srss.service.RateConfigurationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/rate-configuration")
@Slf4j
@ApiIgnore
public class RateConfigurationController {

    private final RateConfigurationService rateConfigurationService;

    public RateConfigurationController(RateConfigurationService rateConfigurationService) {
        this.rateConfigurationService = rateConfigurationService;
    }

    @GetMapping("/search")
    ResponseEntity<RateConfigSearchResponse> searchRateRuleConfiguration(@RequestParam String ratePlanCode,
                                                                         @RequestParam String fromDate, @RequestParam String toDate) {
        log.info("REST request to search RateRuleConfiguration for ratePlanCode:{},  from: {} and toDate: {}", ratePlanCode, fromDate, toDate);
        return ResponseEntity.ok(rateConfigurationService.searchRateRule(ratePlanCode, fromDate, toDate));
    }
}
