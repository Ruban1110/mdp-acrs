package com.marriott.eeh.srss.controller;

import com.marriott.eeh.srss.dto.RetrieveBrandResponse;
import com.marriott.eeh.srss.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin()
@RestController
@RequestMapping("/api/v1/brand")
@Slf4j
@Api(tags = "Brand Controller APIs")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/retrieve-all/{chainCode}")
    @ApiOperation("API with operations to retrieve all the Brands of a Chain.")
    ResponseEntity<RetrieveBrandResponse> getAllBrands(@PathVariable String chainCode) {
        log.info("REST request to retrieve all brands for chainCode: {} ", chainCode);
        return new ResponseEntity<>(brandService.getAllBrands(chainCode), HttpStatus.OK);
    }
}
