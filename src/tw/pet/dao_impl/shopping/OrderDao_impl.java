package tw.pet.dao_impl.shopping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import tw.pet.model.shopping.OrderBean;

//本類別
//1.新增一筆訂單到orders表格
//2.查詢orders表格內的單筆訂單
//3.查詢orders表格內的所有訂單

@Repository
public class OrderDao_impl {
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Session s() {
		return sessionFactory.getCurrentSession();
	}

	// 查詢訂單 利用訂單編號OrderId
	public OrderBean selectOrder(int OrderId) {
		OrderBean select = getSession().get(OrderBean.class, OrderId);

		return select;
	}
	
	//查詢所有訂單
	public List<OrderBean> selectAllOrder(){
		Query<OrderBean> selectAllOrder = getSession().createQuery("from OrderBean",OrderBean.class);
				
		return selectAllOrder.list();
	}
	
	
	//查詢訂單 依照單一時間
	public List<OrderBean> selectOrderByTime(String time){
		String hql="from OrderBean where orderDate:=time";
		Query<OrderBean> createQuery = s().createQuery(hql,OrderBean.class);
		return createQuery.list();
	}
	
	

	// 取消訂單
	public String cancel(int orderId) {
		String hql = "from OrderBean where state = 成立  and orderId:=orderId";
		Query<OrderBean> createQuery = getSession().createQuery(hql, OrderBean.class);
		OrderBean singleResult = createQuery.getSingleResult();
		OrderBean odBean = (OrderBean) singleResult;
		if (odBean != null) {
			odBean.setState("取消");
			getSession().save(odBean);
			return ("取消成功");
		}
		return "取消失敗";
	}

	// 更新訂單狀態→完成
	public String complete(int orderId) {
		String hql = "from OrderBean where state = 成立  and orderId:=orderId";
		Query<OrderBean> createQuery = getSession().createQuery(hql, OrderBean.class);
		OrderBean singleResult = createQuery.getSingleResult();
		OrderBean odBean = (OrderBean) singleResult;
		if (odBean != null) {
			odBean.setState("完成");
			getSession().save(odBean);
			return ("訂單已送出");
		}
		return "找不到訂單";
	}

	// 更新訂單狀態→逾時
	public String overtime(int orderId) {
		String hql = "from OrderBean where state = 成立  and orderId:=orderId";
		Query<OrderBean> createQuery = getSession().createQuery(hql, OrderBean.class);
		OrderBean singleResult = createQuery.getSingleResult();
		OrderBean odBean = (OrderBean) singleResult;
		if (odBean != null) {
			odBean.setState("逾時");
			getSession().save(odBean);
			return ("訂單逾時");
		}
		return "找不到訂單";
	}
	
	//新增訂單
	public String NewOrder(OrderBean ob) {
		OrderBean orderBean = getSession().get(OrderBean.class, ob.getOrderId());
		if(orderBean==null) {
			getSession().save(orderBean);
			return "訂單新增成功";
		}else {
			return "訂單新增失敗";
		}
	}
	
	//取得訂單總數
	public long selectOrderByCount(Integer memberId) {
		long count=0;
		String hql ="select count(*) from OrderBean where memberId:=memberId";
		Query<?> createQuery = s().createQuery(hql,OrderBean.class);
		Object singleResult = createQuery.getSingleResult();
		count= (long)singleResult;
		
		if(count==0) {
			return 0 ;
		}
		return count;
	}
	
	@SuppressWarnings("unchecked") //使用 @SuppressWarnings 來排除警告
	public List<OrderBean> getAllOrderJson()  {
		List<OrderBean> list = new ArrayList<>();
		String hql = "FROM OrderBean";
		
		list = s().createQuery(hql).getResultList();
		return list;
	}
	
}
