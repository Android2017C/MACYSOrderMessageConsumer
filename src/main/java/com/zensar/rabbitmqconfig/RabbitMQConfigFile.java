package com.zensar.rabbitmqconfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigFile {

	public static final String QUEUE = "message_queue";
	public static final String QUEUE_XML = "message_queue_xml";
	public static final String EXCHANGE = "ProducerMessage_exchange";
	public static final String EXCHANGE_XML = "ProducerMessage_exchange_xml";
	public static final String ROUTING_KEY = "ProducerMessage_routingKey";
	public static final String ROUTING_KEY_XML = "ProducerMessage_routingKey_xml";
	
	public static final String SUB_GCP_JSON = "gcp_json_topic-sub";
	public static final String SUB_GCP_XML = "gcp_xml_topic-sub";

	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}

	@Bean
	public Queue queuexml() {
		return new Queue(QUEUE_XML);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public DirectExchange exchangeXML() {
		return new DirectExchange(EXCHANGE_XML);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	public Binding bindingxml(Queue queuexml, DirectExchange exchangeXML) {
		return BindingBuilder.bind(queuexml()).to(exchangeXML()).with(ROUTING_KEY_XML);
	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public MessageConverter messageConverterXML() {
		return new Jackson2XmlMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}

	@Bean
	public AmqpTemplate templateXML(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverterXML());
		return template;
	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
}
