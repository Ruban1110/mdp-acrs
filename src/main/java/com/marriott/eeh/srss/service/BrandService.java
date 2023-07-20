package com.marriott.eeh.srss.service;

import com.marriott.eeh.srss.dto.RetrieveBrandResponse;

public interface BrandService {
    RetrieveBrandResponse getAllBrands(String chainCode);
}
