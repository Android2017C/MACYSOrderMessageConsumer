package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.api.client.util.Value;
import com.google.pubsub.v1.PubsubMessage;
import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerJSONDto;
import com.zensar.entity.ConsumeJSONEntity;
import com.zensar.entity.FulfillmentOrderEntity;
import com.zensar.rabbitmqconfig.RabbitMQConfigFile;
import com.zensar.repo.ConsumerJsonDataRepo;
import com.zensar.repo.ConsumerXMLDataRepo;
import com.zensar.util.EntityToPojoUtil;

@Service
public class ConsumerJSONServiceImpl implements ConsumerJSONService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ConsumerJsonDataRepo consumerJsonDataRepo;
	@Autowired
	ConsumerXMLDataRepo consumerXMLDataRepo;
	@Autowired
	RabbitAdmin rabbitAdmin;
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	RabbitTemplate rabbitTemplateXml;
	Integer nMessages = 0;
	Integer nMessagesXML = 0;
//	@Value("${spring.cloud.gcp.project-id}")
//	String projectId;
	
	@Autowired
	PubSubTemplate pubSubTemplate;

	@Override
	public List<ProducerJSONDto> getAllConsumerJSONData() {
		Properties properties = rabbitAdmin.getQueueProperties(RabbitMQConfigFile.QUEUE);
		// int reqcount=(Integer)(properties !=null &&
		// properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT) = 0);
		// Properties properties = rabbitAdmin.getQueueProperties(queueName);

		if (properties != null) {

			nMessages = Integer.valueOf(properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT).toString());
			System.out.println(nMessages);
		}

		for (int i = 0; i < nMessages; i++) {
			ProducerJSONDto out = (ProducerJSONDto) rabbitTemplate.receiveAndConvert(RabbitMQConfigFile.QUEUE);

			// System.out.println(i+" = count : "+nMessages +out.getMessageName());

			// ProducerJSONDto jsonDto=new ProducerJSONDto();
			// jsonDto.setCommand(out.getCommand());
			// jsonDto.setMessageName(out.getMessageName());
			System.out.println(i + " = count : " + nMessages + out);
			// System.out.println(i+" = count : "+"=========" +out);
			// ArrayList<ProducerJSONDto> list=new ArrayList<ProducerJSONDto>();
			// list.add(jsonDto);
			// System.out.println(i+" = count : "+"list count :" +list.size() +" ====
			// "+list.get(i).getMessageName());

			ConsumeJSONEntity producerJSONEntity = getConsumerEntityFromDTO(out);
			producerJSONEntity = consumerJsonDataRepo.save(producerJSONEntity);

		}
		return null;
	}

	@Override
	public List<FulfillmentOrder> getAllConsumerXMLData() {
		Properties properties = rabbitAdmin.getQueueProperties(RabbitMQConfigFile.QUEUE_XML);

		if (properties != null) {

			nMessagesXML = Integer.valueOf(properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT).toString());
			System.out.println(nMessagesXML);
		}
		//FulfillmentOrderEntity fulfillmentOrderEntity = null;
		for (int i = 0; i < nMessagesXML; i++) {
			FulfillmentOrder out = (FulfillmentOrder) rabbitTemplateXml.receiveAndConvert(RabbitMQConfigFile.QUEUE_XML);
			System.out.println(i + " = count : " + nMessagesXML + out);
			FulfillmentOrderEntity fulfillmentOrderEntity = getFulfillmentOrderEntityFromDTO(out);
			fulfillmentOrderEntity = consumerXMLDataRepo.save(fulfillmentOrderEntity);
		}

		return null;	
	}

	// json

	private ConsumeJSONEntity getConsumerEntityFromDTO(ProducerJSONDto consumerJSONDto) {
		ConsumeJSONEntity consumerjsonEntity = this.modelMapper.map(consumerJSONDto, ConsumeJSONEntity.class);
		return consumerjsonEntity;
	}

	private ProducerJSONDto getconsumerJSONDTOFromEntity(ConsumeJSONEntity consumerJSONEntity) {
		ProducerJSONDto consumerJSONDto = this.modelMapper.map(consumerJSONEntity, ProducerJSONDto.class);
		return consumerJSONDto;
	}

	private List<ProducerJSONDto> getconsumerJSONDTOListFromEntityList(List<ConsumeJSONEntity> consumerEntityList) {
		List<ProducerJSONDto> producerDTOList = new ArrayList<ProducerJSONDto>();
		for (ConsumeJSONEntity consumerEntity : consumerEntityList) {
			producerDTOList.add(getconsumerJSONDTOFromEntity(consumerEntity));
		}
		return producerDTOList;
	}

	// xml

	private FulfillmentOrderEntity getFulfillmentOrderEntityFromDTO(FulfillmentOrder fulfillmentOrder) {
		FulfillmentOrderEntity fulfillmentOrderEntity = this.modelMapper.map(fulfillmentOrder,
				FulfillmentOrderEntity.class);
		return fulfillmentOrderEntity;
	}

	private FulfillmentOrder getFulfillmentOrderDTOFromEntity(FulfillmentOrderEntity fulfillmentOrderEntity) {
		FulfillmentOrder fulfillmentOrder = this.modelMapper.map(fulfillmentOrderEntity, FulfillmentOrder.class);
		return fulfillmentOrder;
	}

	private List<FulfillmentOrder> getFulfillmentOrderDTOListFromEntityList(
			List<FulfillmentOrderEntity> fulfillmentOrderEntitiesList) {
		List<FulfillmentOrder> fulfillmentOrdersList = new ArrayList<FulfillmentOrder>();
		for (FulfillmentOrderEntity producerEntity : fulfillmentOrderEntitiesList) {
			fulfillmentOrdersList.add(getFulfillmentOrderDTOFromEntity(producerEntity));
		}
		return fulfillmentOrdersList;
	}

	@Override
	public List<ProducerJSONDto> getAllConsumerGCPJSONData() {
		List<ProducerJSONDto> producerJSONDtoList = new ArrayList<>();
		PubsubMessage message;
		while ((message = pubSubTemplate.pullNext(RabbitMQConfigFile.SUB_GCP_JSON)) != null) {
			String jsonMessage = message.getData().toStringUtf8();
			ProducerJSONDto producerJSONDto = saveGcpJsonMessageToDb(jsonMessage);
			if (producerJSONDto != null) {
				producerJSONDtoList.add(producerJSONDto);
			}
		}
		return producerJSONDtoList;
	}

	@Override
	public List<FulfillmentOrder> getAllConsumerGCPXMLData() {
		List<FulfillmentOrder> fulfillmentOrderList = new ArrayList<>();

		PubsubMessage message;
		while ((message = pubSubTemplate.pullNext(RabbitMQConfigFile.SUB_GCP_XML)) != null) {
			String xmlMessage = message.getData().toStringUtf8();
			FulfillmentOrder fulfillmentOrder = saveGcpXmlMessageToDb(xmlMessage);
			if (fulfillmentOrder != null) {
				fulfillmentOrderList.add(fulfillmentOrder);
			}
		}
		return fulfillmentOrderList;
	}
	
	
	private ProducerJSONDto saveGcpJsonMessageToDb(String jsonMessage) {
		try {
			ProducerJSONDto orderMessageJson = new ObjectMapper().readValue(jsonMessage, ProducerJSONDto.class);
			ConsumeJSONEntity entity = EntityToPojoUtil.jsonPojoToEntity(modelMapper, orderMessageJson);
			ConsumeJSONEntity entity1 = null;
			try {
				entity1 = consumerJsonDataRepo.save(entity);
				return orderMessageJson;
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return null;
			} finally {
				if (entity1 == null) {
				//exception handle
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private FulfillmentOrder saveGcpXmlMessageToDb(String xmlMessage) {
		try {
			FulfillmentOrder fulfillmentOrder = new XmlMapper().readValue(xmlMessage, FulfillmentOrder.class);
			FulfillmentOrderEntity entity = EntityToPojoUtil.xmlPojoToEntity(modelMapper, fulfillmentOrder);
			FulfillmentOrderEntity entity1 = null;
			try {
				entity1 = consumerXMLDataRepo.save(entity);
				return fulfillmentOrder;
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return null;
			} finally {
				if (entity1 == null) {
					//exception handler 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
