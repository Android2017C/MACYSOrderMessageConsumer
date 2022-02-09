package com.zensar.service;

import java.util.List;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerJSONDto;

public interface ConsumerJSONService {

	public List<ProducerJSONDto> getAllConsumerJSONData();

	public List<FulfillmentOrder> getAllConsumerXMLData();
	
	public List<ProducerJSONDto> getAllConsumerGCPJSONData();

	public List<FulfillmentOrder> getAllConsumerGCPXMLData();
}
