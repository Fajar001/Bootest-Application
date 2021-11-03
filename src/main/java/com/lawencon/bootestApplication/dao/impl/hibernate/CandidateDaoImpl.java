package com.lawencon.bootestApplication.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.lawencon.bootestApplication.dao.CandidateDao;
import com.lawencon.bootestApplication.model.Candidate;

@Repository
public class CandidateDaoImpl extends BaseHibernate implements CandidateDao {

	@Override
	public void createCandidate(Candidate create) throws Exception {
		Candidate in = new Candidate(create.getUsername(), create.getEmail(), create.getPassword());
		em.persist(in);
		
	}

	@Override
	public Candidate updateCandidate(Candidate user) throws Exception {
		Candidate upsert = findByIdCandidate(user.getIdCandidate());
		if(upsert == null) {
			throw new Exception();
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
		q = query("from Candidate");
		return q.getResultList();
	}

	@Override
	public Candidate findByUsernameCandidate(String username) throws Exception {
		try {
			q = query("from Candidate where username = :userParam").setParameter("userParam", username);
			return (Candidate) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return new Candidate();
	}

	@Override
	public Candidate checkDataExists(Candidate check) throws Exception {
		try {
			q = query("from Admin where username = :userParam and email = :emailParam")
					.setParameter("userParam", check.getUsername()).setParameter("emailParam", check.getEmail());
			return (Candidate) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteCandidate(String username) throws Exception {
		em.remove(findByUsernameCandidate(username));
	}

	@Override
	public Candidate findByIdCandidate(String id) throws Exception {
		try {
			q = query("from Candidate where idCandidate = :idParam").setParameter("idParam", id);
			return (Candidate) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

}
