package com.qlsv.ptit.tinhdiemptit.dao;

import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

import java.util.List;

public interface ThongKeDAO {
	public List<SinhVien_Diem> findbytbdiem(String maMH, Integer nhomMH);


}
