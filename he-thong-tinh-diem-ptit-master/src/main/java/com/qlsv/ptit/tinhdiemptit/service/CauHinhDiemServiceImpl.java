package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.dao.CauHinhDiemDAO;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;

@Service
public class CauHinhDiemServiceImpl implements CauHinhDiemService {

	@Autowired
	private CauHinhDiemDAO cauHinhDiemDAO;

	@Override
	@Transactional
	public String findById(String maMH) {
		return cauHinhDiemDAO.findById(maMH);
	}

}
