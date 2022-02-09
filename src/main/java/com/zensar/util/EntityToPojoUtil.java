package com.zensar.util;



import org.modelmapper.ModelMapper;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerJSONDto;
import com.zensar.entity.ConsumeJSONEntity;
import com.zensar.entity.FulfillmentOrderEntity;

public class EntityToPojoUtil {

	public static ProducerJSONDto jsonEntityToPojo(ModelMapper modelMapper,
			ConsumeJSONEntity consumeJSONEntity) {
		return modelMapper.map(consumeJSONEntity, ProducerJSONDto.class);
	}

	public static ConsumeJSONEntity jsonPojoToEntity(ModelMapper modelMapper, ProducerJSONDto orderMessageJson) {
		return modelMapper.map(orderMessageJson, ConsumeJSONEntity.class);
	}

	public static FulfillmentOrderEntity xmlPojoToEntity(ModelMapper modelMapper, FulfillmentOrder fulfillmentOrder) {
		return modelMapper.map(fulfillmentOrder, FulfillmentOrderEntity.class);
	}

	public static FulfillmentOrder xmlEntityToPojo(ModelMapper modelMapper,
			FulfillmentOrderEntity fulfillmentOrderEntity) {
		return modelMapper.map(fulfillmentOrderEntity, FulfillmentOrder.class);
	}
}
