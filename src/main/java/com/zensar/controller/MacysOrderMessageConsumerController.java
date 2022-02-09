package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerJSONDto;
import com.zensar.service.ConsumerJSONService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("Macys/OrderMessageConsumer")

public class MacysOrderMessageConsumerController {
	
	@Autowired
	ConsumerJSONService consumerJSONService;
	
	@GetMapping(value = "/consume", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	//@ApiOperation(value = "Get All OrderMessageConsumer Data")
	public String consume() {
		
		return "Data consume";
	}
	
	@GetMapping(value = "/JSON", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get All consumerJSONData")
	public List<ProducerJSONDto> getAllConsumerJSONData() {

		return consumerJSONService.getAllConsumerJSONData();
	}
	@GetMapping(value = "/XML", produces = MediaType.APPLICATION_XML_VALUE)
	@ApiOperation(value = "Get All consumerXMLData")
	public List<FulfillmentOrder> getAllConsumerXMLData() {

		return consumerJSONService.getAllConsumerXMLData();
	}
	
	
	@GetMapping(value = "GCP/XML",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<FulfillmentOrder> getAllConsumerGCPXMLData() {
        return consumerJSONService.getAllConsumerGCPXMLData();
    }
    
    
    @GetMapping(value = "GCP/JSON",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<ProducerJSONDto> getAllConsumerGCPJSONData(){
        return consumerJSONService.getAllConsumerGCPJSONData();
    }
	
	
	
}
