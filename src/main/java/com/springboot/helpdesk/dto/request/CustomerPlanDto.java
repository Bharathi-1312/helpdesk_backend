package com.springboot.helpdesk.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CustomerPlanDto(
        @NotNull(message = "Activation date cannot be null")
        LocalDate activationDate,

        @NotNull(message = "End date cannot be null")
        LocalDate endDate,

        @NotNull(message ="Coupen required")
        @NotBlank(message="Coupen required")
        String coupon,

        @Positive(message = "Amount paid cannot be negative")
        double amountPaid

) {
}
