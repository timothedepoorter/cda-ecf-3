package com.ut.ecommerce.searchsuggestionservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class SearchSuggestionDto {
    private String search;
    private String linkToProduct;
}
