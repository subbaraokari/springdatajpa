package org.simplilearn.jpaex1.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.simplilearn.jpaex1.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("employeeRepository")
@Transactional
public class EmpRepository {
	@Autowired
	private EntityManager entityManager;
	
	public void insert(Emp e)
	{
		entityManager.persist(e);
	}
	public List<Emp> getAll()
	{
		Query query=entityManager.createQuery("select e from org.simplilearn.jpaex1.entities.Emp e");
		return query.getResultList();
	}
	public Optional<Emp> get(int eno)
	{
		Emp e=entityManager.find(Emp.class, eno);
		return Optional.ofNullable(e);
	}
	public void update(int eno,Emp e)
	{
		Query query=entityManager.createQuery("update org.simplilearn.jpaex1.entities.Emp e set e.name=?1,e.address=?2 where e.eno=?3");
		query.setParameter(1, e.getName());
		query.setParameter(2, e.getAddress());
		query.setParameter(3, eno);
		query.executeUpdate();
		
	}
}
