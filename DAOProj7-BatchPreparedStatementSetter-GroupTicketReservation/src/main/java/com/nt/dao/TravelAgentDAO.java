package com.nt.dao;

import java.util.List;

import com.nt.bo.TicketDetialsBO;

public interface TravelAgentDAO {
	public int[] insert(List<TicketDetialsBO> listBO);

}
