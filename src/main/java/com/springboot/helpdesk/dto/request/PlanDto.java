package com.springboot.helpdesk.dto.request;


import com.springboot.helpdesk.enums.PlanType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PlanDto(

@NotNull (message = "PlanType should not to be null")
        PlanType planType,
        @Positive(message="Price should not to be blank")

        double price

) {


}
