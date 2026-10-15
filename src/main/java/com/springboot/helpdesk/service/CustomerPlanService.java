package com.springboot.helpdesk.service;

import com.springboot.helpdesk.Repository.CustomerPlanRepository;
import com.springboot.helpdesk.Repository.CustomerRepository;
import com.springboot.helpdesk.Repository.PlanRepository;
import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.dto.response.CustomerPlanInfoDto;
import com.springboot.helpdesk.dto.response.TicketInfoDto;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.CustomerPlanMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.CustomerPlan;
import com.springboot.helpdesk.model.Plan;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerPlanService {

    private final CustomerPlanRepository customerPlanRepository;
    private final CustomerRepository customerRepository;
    private final PlanRepository planRepository;

    public void addCustomerPlan(@Valid Long customerId,
                                @Valid Long planId,
                                CustomerPlanDto customerPlanDto) {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()->new ResourceNotFoundException("Customer id not found"));

        // Fetch the Plan
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new ResourceNotFoundException("Plan id not found"));

        CustomerPlan customerPlan= CustomerPlanMapper.covertDtoToMapper(customerPlanDto);

        customerPlan.setCustomer(customer);
        customerPlan.setPlan(plan);

        customerPlanRepository.save(customerPlan);

    }

    public List<CustomerPlanInfoDto> getCustomerPlanByCustomerUsername(String customerUsername, Integer page, Integer size) {
            Pageable pageable =  PageRequest.of(page,size);
            return customerPlanRepository.getCustomerPlanByCustomerUsername(customerUsername,pageable);
    }
}
