package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.TicketDetialsBO;
import com.nt.dao.TravelAgentDAO;
import com.nt.dto.TicketDetailsDTO;
@Service("TAService")
public class TravelMgmtServiceImpl implements TravelMgmtService {
	@Autowired
  private TravelAgentDAO dao;
	public String groupReservation(List<TicketDetailsDTO> listDTO) {
	    List<TicketDetialsBO> listBO=new ArrayList();
	    int result[]=null;
		//convert listDTO to listBO;
	    listDTO.forEach(dto->{
	    	TicketDetialsBO bo=new TicketDetialsBO();
	    	BeanUtils.copyProperties(dto,bo);
	    	listBO.add(bo);
	    });
	    //use dAO
	    result=dao.insert(listBO);
	    if(result!=null)
	    	return "Group Reservation is done";
	    else
	    	return "Group Reservation is failed";
	}//method
}//class
