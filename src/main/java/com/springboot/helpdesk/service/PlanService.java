package com.springboot.helpdesk.service;

import com.springboot.helpdesk.mapper.PlanMapper;
import com.springboot.helpdesk.Repository.PlanRepository;
import com.springboot.helpdesk.dto.request.PlanDto;
import com.springboot.helpdesk.model.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {
    private  final PlanRepository planRepository;

    public void add(PlanDto planDto) {
        Plan plan= PlanMapper.mapDtoToEntity(planDto);
        planRepository.save(plan);
    }
}
