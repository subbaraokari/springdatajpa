package org.simplilearn.app.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.app.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("empDaoImpl")
@Transactional
public class EmpDaoImpl implements EmpDao{
	private SessionFactory sessionFactory;
	
	@Autowired
	public EmpDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Emp e) {
		Session session=sessionFactory.getCurrentSession();
		session.save(e);
	}

	@Override
	public List<Emp> getAll() {
		Session session=sessionFactory.getCurrentSession();
		Query<Emp> query=session.createQuery("select e from org.simplilearn.app.entities.Emp e");
		return query.list();
	}

	@Override
	public void delete(int eno) {
		Session session=sessionFactory.getCurrentSession();
		Query<Emp> query=session.createQuery("delete from org.simplilearn.app.entities.Emp e where e.eno=?1");
		query.setParameter(1, eno);
		query.executeUpdate();
	}

	@Override
	public Optional<Emp> get(int eno) {
		Session session=sessionFactory.getCurrentSession();
		Emp e=session.get(Emp.class, eno);
		return Optional.of(e);
	}

	@Override
	public void update(int eno, Emp e) {
		Session session=sessionFactory.getCurrentSession();
		Query<Emp> query=session.
				createQuery("update org.simplilearn.app.entities.Emp e set e.name=?1,e.address=?2 where e.eno=?3");
		query.setParameter(1, e.getName());
		query.setParameter(2, e.getAddress());
		query.setParameter(3, e.getEno());
		query.executeUpdate();
	}

}
