package com.atmecs.qa.dto;

import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.List;
@Builder
@Getter
public class TestBuild {
    private String name;
    private String mobile;
    private boolean Boolean;
    private List pets;
    private Address address;


}
