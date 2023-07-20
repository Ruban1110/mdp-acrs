package com.marriott.eeh.srss.service;

import com.marriott.eeh.srss.dto.OfferPlansSearRequest;
import com.marriott.eeh.srss.dto.OfferPlansSearchResponse;

public interface OfferPlansService {

    OfferPlansSearchResponse searchOfferPlans(OfferPlansSearRequest offerPlansSearRequest, String chainCode);

    OfferPlansSearchResponse searchOfferPlansWithPagination(OfferPlansSearRequest offerPlansSearRequest, String chainCode);

}
