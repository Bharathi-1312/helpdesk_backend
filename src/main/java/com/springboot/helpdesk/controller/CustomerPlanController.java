package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.dto.response.CustomerPlanInfoDto;
import com.springboot.helpdesk.dto.response.TicketInfoDto;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.service.CustomerPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerPlanController {

    private final CustomerPlanService customerPlanService;

    @PostMapping("api/customerplan/add/{customerId}/{planId}")
    public void addCustomerPlan(@Valid @PathVariable Long customerId,
                                @PathVariable Long planId,
                                @RequestBody CustomerPlanDto customerPlanDto)
    {
        customerPlanService.addCustomerPlan(customerId,planId,customerPlanDto);
    }

    @GetMapping("/api/customerplan/get")
    public List<CustomerPlanInfoDto> getCustomerPlanByCustomerUsername(@RequestParam("username") String customerUsername,
                                                                       @RequestParam(name = "page" , required = false, defaultValue = "0") Integer page,
                                                                       @RequestParam(name = "size", required = false, defaultValue = "20") Integer size){
        return customerPlanService.getCustomerPlanByCustomerUsername(customerUsername,page,size);

    }
}
