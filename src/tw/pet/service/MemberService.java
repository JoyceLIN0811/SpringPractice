package tw.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.pet.dao_impl.MemberDao_impl;
import tw.pet.model.PetMembers;

@Service
public class MemberService {

	@Autowired
	private MemberDao_impl mDao;
	
	public PetMembers saveMember(PetMembers mb) {
		return mDao.saveMember(mb);
	}
	public PetMembers checkIDPassword(String email, String password) {
		return mDao.checkIDPassword(email, password);
	}
	public PetMembers queryMember(int memberId) {
		return mDao.queryMember(memberId);
	}
	public List<PetMembers> queryAllMember(){
		return mDao.queryAllMember();
	}
	public PetMembers update(PetMembers mb) {
		return mDao.update(mb);
	}
	public boolean delete(int memberId) {
		return mDao.delete(memberId);
	}

}
