package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.MedicineDetailsBO;
import com.nt.dao.MedicineDAO;
import com.nt.dto.MedicineDetailsDTO;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
	private MedicineDAO dao;
  

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<MedicineDetailsDTO> fetchAllMedicines() {
		List<MedicineDetailsDTO> listDTO=new ArrayList();
		List<MedicineDetailsBO> listBO=null;
		//use DAO
		listBO=dao.getAllMedicines();
		//Convert ListBO to ListDTO
		
		listBO.forEach(bo->{
			MedicineDetailsDTO dto=new MedicineDetailsDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

}
