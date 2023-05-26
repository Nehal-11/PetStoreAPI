package com.atmecs.qa.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {
    private String permanentAddress;
    private String currentAddress;
}
