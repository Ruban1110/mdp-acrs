package com.marriott.eeh.srss.service;

import com.marriott.eeh.srss.dto.RegionAndCountryResponse;

public interface RegionAndCountryService {
    RegionAndCountryResponse getAllRegionAndCountry(String chainCode, String include);
}
