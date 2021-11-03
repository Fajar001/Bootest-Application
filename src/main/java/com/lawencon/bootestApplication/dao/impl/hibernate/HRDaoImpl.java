package com.lawencon.bootestApplication.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.lawencon.bootestApplication.dao.HrDao;
import com.lawencon.bootestApplication.model.HR;

@Repository
public class HRDaoImpl extends BaseHibernate implements HrDao{

	@Override
	public void createHr(HR create) throws Exception {
		HR in = new HR(create.getUsername(), create.getEmail(), create.getPassword());
		em.persist(in);
	}

	@Override
	public HR updateHr(HR user) throws Exception {
		HR upsert = findByIdHR(user.getIdHr());
		if(upsert == null) {
			throw new NoResultException();
		}
		else {
			upsert.setUsername(user.getUsername());
			upsert.setEmail(user.getEmail());
			upsert.setPassword(user.getPassword());
			em.merge(upsert);
		}
		return upsert;
	}

	@Override
	public List<?> findAll() throws Exception {
		q = query("from HR");
		return q.getResultList();
	}

	@Override
	public HR findByUsernameHR(String username) throws Exception {
		try {
			q = query("from HR where username = :userParam").setParameter("userParam", username);
			return (HR) q.getSingleResult();
		} catch (NoResultException e) {
			
		}
		return new HR();
	}

	@Override
	public HR checkDataExists(HR check) throws Exception {
		try {
			q = query("from HR where username = :userParam and email = :emailParam")
					.setParameter("userParam", check.getUsername()).setParameter("emailParam", check.getEmail());
			return (HR) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteHr(String username) throws Exception {
		em.remove(findByIdHR(username));
	}

	@Override
	public HR findByIdHR(String id) throws Exception {
		try {
			q = query("from HR where idHr = :idParam").setParameter("idParam", id);
			return (HR) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

}
