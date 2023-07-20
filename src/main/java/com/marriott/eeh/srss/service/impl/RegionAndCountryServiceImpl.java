package com.marriott.eeh.srss.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marriott.eeh.srss.dto.RegionAndCountryResponse;
import com.marriott.eeh.srss.service.RegionAndCountryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


@Slf4j
@Service
public class RegionAndCountryServiceImpl implements RegionAndCountryService {

    /**
     * @param chainCode : chainCode
     * @param include   : include
     * @return : RegionAndCountryResponse
     */
    @Override
    public RegionAndCountryResponse getAllRegionAndCountry(String chainCode, String include) {
        log.info("Request to retrieve all regions and countries for chainCode: {} and include: {}, ", chainCode, include);
        File file = null;
        String json = null;
        RegionAndCountryResponse regionAndCountryResponse;
        ClassLoader classLoader = getClass().getClassLoader();
        if (StringUtils.isNotBlank(include)) {
            file = new File(Objects.requireNonNull(classLoader.getResource("json/RegionAndCountryResponse.json")).getFile());
        } else {
            file = new File(Objects.requireNonNull(classLoader.getResource("json/RegionWithoutCountryResponse.json")).getFile());
        }
        try {
            json = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
            regionAndCountryResponse = new ObjectMapper().readValue(json, RegionAndCountryResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return regionAndCountryResponse;
    }
}
