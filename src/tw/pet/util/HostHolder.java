//package tw.pet.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import tw.pet.dao_impl.MemberDao_impl;
//import tw.pet.model.PetMembers;
//
//@Component
//public class HostHolder {
//
//	private PetMembers member;
//
//	@Autowired
//	MemberDao_impl mDao;
//
//	public PetMembers getUser() {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		user = userDao.getUserByUsername(((UserDetails) principal).getUsername());
//		return user;
//	}
//}
