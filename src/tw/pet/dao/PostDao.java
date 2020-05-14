package tw.pet.dao;

import java.sql.SQLException;
import java.util.List;

import tw.pet.model.Post;



public interface PostDao {
	
	public Post insert(Post pb);
	
	public Post getPost(int postno);
	
	public List<Post> getAll();
	
//	public int update(postBean PBean) throws SQLException;
//	
//	public String delete(int postno) throws SQLException;
	
//	public void createConn() throws SQLException,Exception;
//	
//	public void closeConn() throws SQLException;
}
