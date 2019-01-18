package com.nt.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter	
@Getter
@ToString
//@Configuration("agMenu")
@Component("agMenu")
@PropertySource(value="classpath:com/nt/commons/info.properties")
public class AmoghaMenu {
	@Autowired
	private Date date;
	@Value("#{'${ag.menuType}'}")
	private String type;
	@Value("#{'${ag.items}'.split(',')}")
	private List<String>items;
	@Value("#{${ag.itemPrices}}")
	private Map<String,Integer> itemPrices;
	@Value("#{'${ag.specialItem}'}")
	private String todaysSpecial;
	@Value("#{'${ag.specialItemPrice}'}")
	private  int   todaysSepcialItemPrice;
	@Value("#{'${ag.offerDiscount}'}")
	private float todaysOffer;

}
