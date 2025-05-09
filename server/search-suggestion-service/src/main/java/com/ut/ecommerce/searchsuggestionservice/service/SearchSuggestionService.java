package com.ut.ecommerce.searchsuggestionservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class SearchSuggestionService {

    @Value("${common.data.service.url}")
    private String commonDataServiceUrl;

}
