package com.qlsv.ptit.tinhdiemptit.dao;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;

@Repository
public class CauHinhDiemDAOImpl implements CauHinhDiemDAO {

	@Autowired
	private EntityManager entityManager;



	@Override
	public String findById(String maMH) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("Select c.cauHinh" + " from CauHinhDiem c join c.monHoc m" + " where m.maMonHoc = :maMH");
		query.setParameter("maMH", maMH);
		String cauHinh = "";
		try {
			cauHinh = (String) query.getSingleResult();
		} catch (NoResultException e) {
		}
		return cauHinh;
	}



}
