package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerUpdateDto(
        // @Pattern(regexp = "[a-zA-Z ]+")
        @NotBlank(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,
        @NotBlank(message = "City is required")
        @NotNull(message = "City is required")
        String city
) {
}