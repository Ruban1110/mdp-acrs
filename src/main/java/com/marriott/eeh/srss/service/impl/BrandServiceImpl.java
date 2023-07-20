package com.marriott.eeh.srss.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marriott.eeh.srss.dto.RetrieveBrandResponse;
import com.marriott.eeh.srss.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {

    /**
     * @param chainCode: chainCode
     * @return Object
     */
    @Override
    public RetrieveBrandResponse getAllBrands(String chainCode) {

        if (!chainCode.equals("CHN001"))
            throw new NoSuchElementException("No content found for given chainCode: " + chainCode);

        // Amaedeus API call
        return retrieveBrandMockResponse();
    }

    private RetrieveBrandResponse retrieveBrandMockResponse() {
        RetrieveBrandResponse retrieveBrandResponse;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("json/BrandRetrieve.json")).getFile());
        String json = null;
        try {
            json = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
            retrieveBrandResponse = new ObjectMapper().readValue(json, RetrieveBrandResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return retrieveBrandResponse;
    }

    private RetrieveBrandResponse mockApiCall(String chainCode) {

        String jsonString = "[\n" +
                "  {\n" +
                "    \"chainCode\": \"CHN\",\n" +
                "    \"code\": \"B1\",\n" +
                "    \"name\": \"An empty Brand\",\n" +
                "    \"version\": 0,\n" +
                "    \"currencies\": [\n" +
                "      {\n" +
                "        \"currencyCode\": \"USD\",\n" +
                "        \"isDefault\": true,\n" +
                "        \"roundingLimit\": 0,\n" +
                "        \"roundToClosest0\": true,\n" +
                "        \"roundToClosest5\": true,\n" +
                "        \"roundToClosest9\": true\n" +
                "      }\n" +
                "    ],\n" +
                "    \"creditCardAndPaymentSecurities\": [\n" +
                "      {\n" +
                "        \"cardType\": \"VI\",\n" +
                "        \"cvvForGuarantee\": true,\n" +
                "        \"cvvForDeposit\": true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"chainCode\": \"CHN\",\n" +
                "    \"code\": \"B2\",\n" +
                "    \"name\": \"Another Brand\",\n" +
                "    \"version\": 2,\n" +
                "    \"currencies\": [\n" +
                "      {\n" +
                "        \"currencyCode\": \"MYR\",\n" +
                "        \"isDefault\": true,\n" +
                "        \"roundingLimit\": 0,\n" +
                "        \"roundToClosest0\": true,\n" +
                "        \"roundToClosest5\": true,\n" +
                "        \"roundToClosest9\": true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        log.info("JsonString before conversion: {}", jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        RetrieveBrandResponse retrieveBrandResponse = new RetrieveBrandResponse();
        List<RetrieveBrandResponse.Datum> datumList = new ArrayList<>();
        try {
            datumList = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, RetrieveBrandResponse.Datum.class));
            //objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            retrieveBrandResponse.setData(datumList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        log.info("Java Object after conversion: {}", jsonString);
        return retrieveBrandResponse;
    }
}
