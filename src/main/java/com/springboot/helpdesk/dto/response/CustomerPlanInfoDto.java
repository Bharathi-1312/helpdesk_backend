package com.springboot.helpdesk.dto.response;

import com.springboot.helpdesk.enums.PlanType;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.Plan;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record CustomerPlanInfoDto( Long customerPlanId,
                                   LocalDate activationDate,
                                   LocalDate endDate,
                                   String coupon,
                                   double amountPaid,
                                   PlanType planType,
                                   Long customerId,
                                   String customername,
                                   Long planId) {

}
