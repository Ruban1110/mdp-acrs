package com.marriott.eeh.srss.controller;


import com.marriott.eeh.srss.dto.RegionAndCountryResponse;
import com.marriott.eeh.srss.service.RegionAndCountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/regions-countries")
@Slf4j
@Api(tags = "Region And Country Controller APIs")
public class RegionAndCountryController {

    private final RegionAndCountryService regionAndCountryService;

    public RegionAndCountryController(RegionAndCountryService regionAndCountryService) {
        this.regionAndCountryService = regionAndCountryService;
    }

    @GetMapping("/retrieve-all/{chainCode}/regions")
    @ApiOperation("API with operations to retrieve all the regions and countries of a Chain.")
    @ApiIgnore
    ResponseEntity<RegionAndCountryResponse> getAllRegionAndCountry(@PathVariable String chainCode, @RequestParam(required = false) String include ) {
        log.info("REST request to retrieve all regions and countries for chainCode: {} and include: {}, ", chainCode, include);
        return new ResponseEntity<>(regionAndCountryService.getAllRegionAndCountry(chainCode, include), HttpStatus.OK);
    }
}
