package tw.pet.dao_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.pet.model.PetMembers;
@Repository
public class MemberDao_impl {

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session session;

//	public MemberDao_impl(Session session) {
//		this.session = sessionFactory.getCurrentSession();
//	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public MemberDao_impl() {

	}

	public PetMembers saveMember(PetMembers mb) {
	
		Query<PetMembers> query = getSession().createQuery("From PetMembers WHERE email=:email", PetMembers.class);
		query.setParameter("email", mb.getEmail());
		PetMembers bean = (PetMembers) query.uniqueResult();
		if (bean == null) {
			getSession().save(mb);
			return mb;
		}
		return null;
	}

	public PetMembers checkIDPassword(String email, String password) {
		Query<PetMembers> check = getSession().createQuery("from PetMembers where email=?1 and password=?2",
				PetMembers.class);
		check.setParameter(1, email);
		check.setParameter(2, password);

		List<PetMembers> list = check.list();

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public PetMembers queryMember(int memberId) {
		PetMembers bean = getSession().get(PetMembers.class, memberId);
		return bean;
	}

	public List<PetMembers> queryAllMember() {
		Query<PetMembers> query = getSession().createQuery("from PetMembers", PetMembers.class);
		List<PetMembers> list = query.list();
		return list;
	}

	public PetMembers update(PetMembers mb) {
		PetMembers bean = getSession().get(PetMembers.class, mb.getMemberId());
		if (bean != null) {
			bean.setMemberId(mb.getMemberId());
			bean.setEmail(mb.getEmail());
			bean.setPassword(mb.getPassword());
			bean.setGender(mb.getGender());
			bean.setAge(mb.getAge());
			getSession().update(bean);
		}
		return bean;
	}

	public boolean delete(int memberId) {
		PetMembers bean = getSession().get(PetMembers.class, memberId);
		if (bean != null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}

}