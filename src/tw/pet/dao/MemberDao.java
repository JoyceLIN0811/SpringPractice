package tw.pet.dao;

import java.util.List;

import tw.pet.model.*;

public interface MemberDao {

	public PetMembers saveMember(PetMembers mb);
	public PetMembers checkIDPassword(String email, String password);
	public PetMembers queryMember(int memberId);
	public List<PetMembers> queryAllMember();
	public PetMembers update(PetMembers mb);
	public boolean delete(int memberId);

}