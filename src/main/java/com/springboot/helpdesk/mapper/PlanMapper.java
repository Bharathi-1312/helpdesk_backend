package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.PlanDto;
import com.springboot.helpdesk.model.Plan;
import org.springframework.stereotype.Component;

@Component
public class PlanMapper {
    public static Plan mapDtoToEntity(PlanDto planDto) {
        Plan plan = new Plan();
        plan.setPlanType(planDto.planType());
        plan.setPrice(planDto.price());
        return plan;
    }
}
