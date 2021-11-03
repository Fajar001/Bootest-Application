package com.lawencon.bootestApplication.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.lawencon.bootestApplication.dao.AdminDao;
import com.lawencon.bootestApplication.model.Admin;

@Repository
public class AdminDaoImpl extends BaseHibernate implements AdminDao {

//	@Autowired
//	private PasswordEncoder encoder;

	@Override
	public void createAdmin(Admin insert) throws Exception {
		Admin in = new Admin(insert.getUsername(), insert.getEmail(), insert.getPassword());
		em.persist(in);
	}

	@Override
	public List<?> findAll() throws Exception {
		q = query("from Admin");
		return q.getResultList();
	}

	@Override
	public Admin findByUsernameAdmin(String username) throws Exception {
		try {
			q = query("from Admin where username = :userParam").setParameter("userParam", username);
			return (Admin) q.getSingleResult();
		} catch (NoResultException e) {
			e.getMessage();
		}
		return new Admin();
	}

	@Override
	public Admin update(Admin user) throws Exception {
		Admin upsert = findByIdAdmin(user.getIdAdmin());
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
	public void delete(String id) throws Exception {
		em.remove(findByIdAdmin(id));
	}

	@Override
	public Admin checkDataExists(Admin check) throws Exception {
		try {
			q = query("from Admin where username = :userParam and email = :emailParam")
					.setParameter("userParam", check.getUsername()).setParameter("emailParam", check.getEmail());
			return (Admin) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Admin findByIdAdmin(String id) throws Exception {
		try {
			q = query("from Admin where idAdmin = :idParam").setParameter("idParam", id);
			return (Admin) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

}
