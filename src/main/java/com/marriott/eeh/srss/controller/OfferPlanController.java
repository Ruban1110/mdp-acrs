package com.marriott.eeh.srss.controller;

import com.marriott.eeh.srss.dto.OfferPlansSearRequest;
import com.marriott.eeh.srss.dto.OfferPlansSearchResponse;
import com.marriott.eeh.srss.dto.RetrieveBrandResponse;
import com.marriott.eeh.srss.service.OfferPlansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin()
@RestController
@RequestMapping("/api/v1/offer-plans")
@Slf4j
@Api(tags = "Offer-Plans Controller APIs")
public class OfferPlanController {

    private final OfferPlansService offerPlansService;

    public OfferPlanController(OfferPlansService offerPlansService) {
        this.offerPlansService = offerPlansService;
    }


    @PostMapping("/search/{chainCode}")
    @ApiOperation("API with operations to search all offer-Plans.")
    ResponseEntity<OfferPlansSearchResponse> searchOfferPlans(@PathVariable String chainCode, @RequestBody OfferPlansSearRequest offerPlansSearRequest) {
        log.info("REST request to search offer-plans for chainCode: {} and for: {} ",chainCode, offerPlansSearRequest);
        return ResponseEntity.ok(offerPlansService.searchOfferPlans(offerPlansSearRequest, chainCode));
    }

    @PostMapping("/search/{chainCode}/page")
    @ApiOperation("API with operations to search all offer-Plans.")
    ResponseEntity<OfferPlansSearchResponse> searchOfferPlansWithPagination(@PathVariable String chainCode, @RequestBody OfferPlansSearRequest offerPlansSearRequest) {
        log.info("REST request to search offer-plans for chainCode: {} and for: {} ",chainCode, offerPlansSearRequest);
        return ResponseEntity.ok(offerPlansService.searchOfferPlansWithPagination(offerPlansSearRequest, chainCode));
    }
}
