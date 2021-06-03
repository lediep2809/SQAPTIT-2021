package com.qlsv.ptit.tinhdiemptit.dao;

import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ThongKeDAOImpl implements ThongKeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<SinhVien_Diem> findbytbdiem(String maMH, Integer nhomMH) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("Select new"
				+ " com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem"
				+ "(svmh.sinhVien.maSV, svmh.sinhVien.hoLot, svmh.sinhVien.ten, svmh.sinhVien.tenLop, " +
				"diem.diemCC, diem.diemGK, diem.diemBTL, diem.diemThi, diem.diemTB)"
				+ " from DiemSo diem"
				+ " right outer join diem.sinhVienMonHoc svmh"
				+ " right outer join svmh.nhomMonHoc nmh"
				+ " where nmh.monHoc.maMonHoc = :maMH and nmh.nhomMonHoc = :nhomMH"
				+ " and diem.diemCC >= 0.5 and diem.diemGK >=0.5 and diem.diemBTL >= 0.5" );
		query.setParameter("maMH", maMH);
		query.setParameter("nhomMH", nhomMH);
		List<SinhVien_Diem> listSinhVienDiem = query.getResultList();
		return listSinhVienDiem;
	}

}
