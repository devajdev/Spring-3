package com.nt.beans;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Configuration("agCounter")
@Component("agCounter")
public class AmoghaBillCounter {
	@Value("#{dt}")
	private Date date;
	@Value("#{'${ag.clerk}'}")
	private String billClerk;
	@Value("#{T(java.lang.Math).random()*100}")
	private int orderId;
	@Value("#{T(java.util.Arrays).asList(agMenu.items[0],agMenu.items[2],agMenu.todaysSpecial)}")
	private List<String> orderItems;
	@Value("#{agMenu.itemPrices['dosa']+agMenu.itemPrices['wada']+agMenu.todaysSepcialItemPrice}")
	public int billAmount;
	@Value("#{agMenu.todaysSpecial.length()!=0}")
	private boolean isSpecialItemAvailable;
	
     

}
