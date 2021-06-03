package com.qlsv.ptit.tinhdiemptit.service;

import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

import java.util.List;

public interface ThongKeService {
	public List<SinhVien_Diem> findbytbdiem(String maMH, Integer nhomMH);
}
