package com.ut.ecommerce.searchsuggestionservice.controller;

import com.ut.ecommerce.searchsuggestionservice.service.SearchSuggestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SearchSuggestionController {
    private final SearchSuggestionService searchSuggestionService;

    public SearchSuggestionController(SearchSuggestionService searchSuggestionService) {
        this.searchSuggestionService = searchSuggestionService;
    }

    @GetMapping("/search-suggestion")
    public ResponseEntity<String> getSuggestions(@RequestParam("q") String prefix) {
        return ResponseEntity.ok("test");
    }
}
