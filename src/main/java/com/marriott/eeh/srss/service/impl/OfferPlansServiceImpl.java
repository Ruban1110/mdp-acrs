package com.marriott.eeh.srss.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marriott.eeh.srss.common.util.JsonToJavaConversion;
import com.marriott.eeh.srss.dto.OfferPlansSearRequest;
import com.marriott.eeh.srss.dto.OfferPlansSearchResponse;
import com.marriott.eeh.srss.exception.InvalidDataException;
import com.marriott.eeh.srss.service.OfferPlansService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


@Service
@Slf4j
public class OfferPlansServiceImpl implements OfferPlansService {


    public static final List<String> offerPlanTypes = List.of("Promotion", "GameTierPlan", "UpsellRule");

    /**
     * @param offerPlansSearRequest : OfferPlansSearRequest
     * @param chainCode             : chainCode
     * @return : Object
     */
    @Override
    public OfferPlansSearchResponse searchOfferPlans(OfferPlansSearRequest offerPlansSearRequest, String chainCode) {
        log.info("request to search offerOPlans for : {}", offerPlansSearRequest);

        if (!chainCode.equals("CHN001"))
            throw new NoSuchElementException("No content found for given chainCode: " + chainCode);
        validateOfferPlansSearRequest(offerPlansSearRequest);

        // Amaedeus API call
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("json/OfferPlanMockData.json")).getFile());
        String json = null;
        try {
            json = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
            return new ObjectMapper().readValue(json, OfferPlansSearchResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param offerPlansSearRequest : offerPlansSearRequest
     * @param chainCode             : chainCode
     * @return OfferPlansSearchResponse
     */
    @Override
    public OfferPlansSearchResponse searchOfferPlansWithPagination(OfferPlansSearRequest offerPlansSearRequest, String chainCode) {
        Integer size = offerPlansSearRequest.getData().getPage().getLimit();
        Integer page = offerPlansSearRequest.getData().getPage().getOffset();
        OfferPlansSearchResponse offerPlansSearchResponse;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (offerPlansSearRequest.getData().getName() != null && offerPlansSearRequest.getData().getType().equals("Promotion") && offerPlansSearRequest.getData().getName().equals("Summer")) {
                File file = new File(Objects.requireNonNull(classLoader.getResource("json/OfferPlanWithSummerMockResponse.json")).getFile());
                String json = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
                offerPlansSearchResponse = new ObjectMapper().readValue(json, OfferPlansSearchResponse.class);
            } else {
                File file = new File(Objects.requireNonNull(classLoader.getResource("json/OfferPlanMockData.json")).getFile());
                String json = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
                offerPlansSearchResponse = new ObjectMapper().readValue(json, OfferPlansSearchResponse.class);
            }
            log.info("Object Converted : {}", offerPlansSearchResponse);
            doPagination(offerPlansSearchResponse, page, size);
            return offerPlansSearchResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doPagination(OfferPlansSearchResponse offerPlansSearchResponse, Integer page, Integer size) {
        log.info("Pagination on offerPlansSearchResponse for page: {}, size: {}", page, size);
        int max = page + size;
        offerPlansSearchResponse.setData(offerPlansSearchResponse.getData().subList(page, max));

        offerPlansSearchResponse.getMeta().getPage().setLimit(size);
        offerPlansSearchResponse.getMeta().getPage().setOffset(page);
    }

    private void validateOfferPlansSearRequest(OfferPlansSearRequest offerPlansSearRequest) {
        String type = offerPlansSearRequest.getData().getType();
        if (type == null || !offerPlanTypes.contains(type))
            throw new InvalidDataException("Un-Supported or Missing offerPlan type: " + type);
    }

    private OfferPlansSearchResponse mockApiCall(String chainCode) {

        String jsonString = "{\n" +
                "    \"meta\": {\n" +
                "      \"count\": 1\n" +
                "    },\n" +
                "    \"data\": [\n" +
                "      {\n" +
                "        \"type\": \"Promotion\",\n" +
                "        \"id\": \"678912\",\n" +
                "        \"isActive\": true,\n" +
                "        \"code\": \"1NFREE\",\n" +
                "        \"promoGroupCode\": \"SUMMER21\",\n" +
                "        \"qualifiers\": {\n" +
                "          \"bookingPeriod\": {\n" +
                "            \"start\": \"2020-08-12T08:00:000\",\n" +
                "            \"end\": \"2020-08-20T08:00:000\"\n" +
                "          },\n" +
                "          \"stayPeriod\": {\n" +
                "            \"start\": \"2020-08-12\",\n" +
                "            \"end\": \"2020-08-30\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"overrides\": {\n" +
                "          \"name\": \"Summer Offers for 2021\",\n" +
                "          \"description\": \"Promotional Offers for summer season, 1N Free for loyalty Guests\"\n" +
                "        },\n" +
                "        \"ratePlans\": [\n" +
                "          {\n" +
                "            \"code\": \"RP01\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"code\": \"RP02\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"code\": \"RP03\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"code\": \"RP04\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"code\": \"RP05\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }";
        log.info("JsonString before conversion: {}", jsonString);
        try {
            return JsonToJavaConversion.getGeneric(OfferPlansSearchResponse.class, jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
