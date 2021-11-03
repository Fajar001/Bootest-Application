package com.lawencon.bootestApplication.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.lawencon.bootestApplication.dao.ReviewersDao;
import com.lawencon.bootestApplication.model.Reviewers;

@Repository
public class ReviewersDaoImpl extends BaseHibernate implements ReviewersDao{

	@Override
	public void createReviewers(Reviewers create) throws Exception {
		Reviewers in = new Reviewers(create.getUsername(), create.getEmail(), create.getPassword());
		em.persist(in);
	}

	@Override
	public Reviewers updateReviewers(Reviewers user) throws Exception {
		Reviewers upsert = findByIdReviewers(user.getIdReviewers());
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
		q = query("from Reviewers");
		return q.getResultList();
	}

	@Override
	public Reviewers findByUsernameReviewers(String username) throws Exception {
		try {
			q = query("from Reviewers where username = :userParam").setParameter("userParam", username);
			return (Reviewers) q.getSingleResult();
		} catch (NoResultException e) {
			
		}
		return new Reviewers();
	}

	@Override
	public Reviewers checkDataExists(Reviewers check) throws Exception {
		try {
			q = query("from Reviewers where username = :userParam and email = :emailParam")
					.setParameter("userParam", check.getUsername()).setParameter("emailParam", check.getEmail());
			return (Reviewers) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteReviewers(String username) throws Exception {
		em.remove(findByIdReviewers(username));
	}

	@Override
	public Reviewers findByIdReviewers(String id) throws Exception {
		try {
			q = query("from Reviewers where idReviewers = :idParam").setParameter("idParam", id);
			return (Reviewers) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
