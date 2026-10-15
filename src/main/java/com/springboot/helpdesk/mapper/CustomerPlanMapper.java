package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.model.CustomerPlan;
import org.springframework.stereotype.Component;

@Component
public class CustomerPlanMapper {

    public static CustomerPlan covertDtoToMapper(CustomerPlanDto customerPlanDto) {
        CustomerPlan customerPlan=new CustomerPlan();
        customerPlan.setActivationDate(customerPlanDto.activationDate());
        customerPlan.setAmountPaid(customerPlanDto.amountPaid());
        customerPlan.setCoupon(customerPlanDto.coupon());
        customerPlan.setEndDate(customerPlanDto.endDate());

        return customerPlan;
    }
}
