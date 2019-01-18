package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TicketDetailsDTO implements Serializable {
	private String psgName;
	private String source;
	private String dest;
	private int age;
}
