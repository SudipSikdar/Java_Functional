package com.sudip.java.functional.model;

import java.util.List;

public record User(String name, String phone, List<String> emails) {}
