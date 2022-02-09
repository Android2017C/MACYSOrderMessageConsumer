package com.zensar.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ConsumeJSON Model")
public class ProducerJSONDto {
	
	@ApiModelProperty("Unique identifier of the ProducerJSON")
	private int id;
	@ApiModelProperty("messageName of the ProducerJSON")
	private String messageName;
	@ApiModelProperty("command of the ProducerJSON")
	private	String command;
	@ApiModelProperty("itemName of the ProducerJSON")
	private String itemName;
	@ApiModelProperty("itemDescription of the ProducerJSON")
	private String itemDescription;
	@ApiModelProperty("itemLength of the ProducerJSON")
	private int itemLength;
	@ApiModelProperty("itemWidth of the ProducerJSON")
	private int itemWidth;
	@ApiModelProperty("itemHeight of the ProducerJSON")
	private int itemHeight;
	@ApiModelProperty("itemWeight of the ProducerJSON")
	private int itemWeight;
	@ApiModelProperty("imagePathname of the ProducerJSON")
	private String imagePathname;
	@ApiModelProperty("rfidTagged of the ProducerJSON")
	private String rfidTagged;
	@ApiModelProperty("storageAttribute of the ProducerJSON")
	private int storageAttribute;
	@ApiModelProperty("pickType of the ProducerJSON")
	private String pickType;
	@ApiModelProperty("upcList of the ProducerJSON")
	private String upcList;
	@ApiModelProperty("orderStatus of the ProducerJSON")
	private OrderStatus orderStatus = OrderStatus.CREATED;
	
	
	
	public ProducerJSONDto(int id, String messageName, String command, String itemName, String itemDescription,
			int itemLength, int itemWidth, int itemHeight, int itemWeight, String imagePathname, String rfidTagged,
			int storageAttribute, String pickType, String upcList, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.messageName = messageName;
		this.command = command;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemLength = itemLength;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.imagePathname = imagePathname;
		this.rfidTagged = rfidTagged;
		this.storageAttribute = storageAttribute;
		this.pickType = pickType;
		this.upcList = upcList;
		this.orderStatus = orderStatus;
	}
	
	
	public ProducerJSONDto(String messageName, String command, String itemName, String itemDescription, int itemLength,
			int itemWidth, int itemHeight, int itemWeight, String imagePathname, String rfidTagged,
			int storageAttribute, String pickType, String upcList, OrderStatus orderStatus) {
		super();
		this.messageName = messageName;
		this.command = command;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemLength = itemLength;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.imagePathname = imagePathname;
		this.rfidTagged = rfidTagged;
		this.storageAttribute = storageAttribute;
		this.pickType = pickType;
		this.upcList = upcList;
		this.orderStatus = orderStatus;
	}



	public ProducerJSONDto() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageName() {
		return messageName;
	}
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getItemLength() {
		return itemLength;
	}
	public void setItemLength(int itemLength) {
		this.itemLength = itemLength;
	}
	public int getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(int itemWidth) {
		this.itemWidth = itemWidth;
	}
	public int getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(int itemHeight) {
		this.itemHeight = itemHeight;
	}
	public int getItemWeight() {
		return itemWeight;
	}
	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}
	public String getImagePathname() {
		return imagePathname;
	}
	public void setImagePathname(String imagePathname) {
		this.imagePathname = imagePathname;
	}
	public String getRfidTagged() {
		return rfidTagged;
	}
	public void setRfidTagged(String rfidTagged) {
		this.rfidTagged = rfidTagged;
	}
	public int getStorageAttribute() {
		return storageAttribute;
	}
	public void setStorageAttribute(int storageAttribute) {
		this.storageAttribute = storageAttribute;
	}
	public String getPickType() {
		return pickType;
	}
	public void setPickType(String pickType) {
		this.pickType = pickType;
	}
	public String getUpcList() {
		return upcList;
	}
	public void setUpcList(String upcList) {
		this.upcList = upcList;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Override
	public int hashCode() {
		return Objects.hash(command, id, imagePathname, itemDescription, itemHeight, itemLength, itemName, itemWeight,
				itemWidth, messageName, orderStatus, pickType, rfidTagged, storageAttribute, upcList);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducerJSONDto other = (ProducerJSONDto) obj;
		return Objects.equals(command, other.command) && id == other.id
				&& Objects.equals(imagePathname, other.imagePathname)
				&& Objects.equals(itemDescription, other.itemDescription) && itemHeight == other.itemHeight
				&& itemLength == other.itemLength && Objects.equals(itemName, other.itemName)
				&& itemWeight == other.itemWeight && itemWidth == other.itemWidth
				&& Objects.equals(messageName, other.messageName) && orderStatus == other.orderStatus
				&& Objects.equals(pickType, other.pickType) && Objects.equals(rfidTagged, other.rfidTagged)
				&& storageAttribute == other.storageAttribute && Objects.equals(upcList, other.upcList);
	}
	
	
	
	

}
