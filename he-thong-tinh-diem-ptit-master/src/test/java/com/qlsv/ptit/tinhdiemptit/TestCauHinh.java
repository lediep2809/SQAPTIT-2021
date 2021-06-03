package com.qlsv.ptit.tinhdiemptit;


import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;
import com.qlsv.ptit.tinhdiemptit.service.CauHinhDiemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestCauHinh {

	@Autowired
	private CauHinhDiemService cauHinhService;


	@Test
	public void testTimCauHinhDiemTheoMonHoc() {
		assertEquals("10/10/10/70", cauHinhService.findById("INT1427"));
	}

	@Test
	public void testKhongTimThayCauHinh() {
		String cauHinh = cauHinhService.findById("INT");
		assertEquals("", cauHinh);
	}

}
