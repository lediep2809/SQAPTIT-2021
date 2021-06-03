package com.qlsv.ptit.tinhdiemptit.service;

import com.qlsv.ptit.tinhdiemptit.dao.ThongKeDAO;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThongKeServiceImpl implements ThongKeService{

	@Autowired
	private ThongKeDAO thongKeDAO;
	@Override
	@Transactional
	public List<SinhVien_Diem> findbytbdiem(String maMH, Integer nhomMH) {

		return thongKeDAO.findbytbdiem(maMH, nhomMH);
	}
}
