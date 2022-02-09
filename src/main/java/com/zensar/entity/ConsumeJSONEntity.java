package com.zensar.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zensar.dto.OrderStatus;

@Entity
@Table(name = "ConsumerJSON")
public class ConsumeJSONEntity {
	@Id
	@GeneratedValue
	private int id;
	private String messageName;
	private	String command;
	private String itemName;
	private String itemDescription;
	private int itemLength;
	private int itemWidth;
	private int itemHeight;
	private int itemWeight;
	private String imagePathname;
	private String rfidTagged;
	private int storageAttribute;
	private String pickType;
	private String upcList;
	@Enumerated(EnumType.STRING)
	public OrderStatus orderStatus;
	public ConsumeJSONEntity(int id, String messageName, String command, String itemName, String itemDescription,
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
	public ConsumeJSONEntity(String messageName, String command, String itemName, String itemDescription,
			int itemLength, int itemWidth, int itemHeight, int itemWeight, String imagePathname, String rfidTagged,
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
	public ConsumeJSONEntity() {
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
		ConsumeJSONEntity other = (ConsumeJSONEntity) obj;
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
