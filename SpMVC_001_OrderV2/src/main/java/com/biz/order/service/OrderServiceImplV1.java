package com.biz.order.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.order.dao.OrderDao;
import com.biz.order.model.OrderVO;

@Service
public class OrderServiceImplV1 implements OrderService{

	@Autowired
	private SqlSession sqlSession;
	private OrderDao orderDao;
	
	/*
	 * OrderServiceImpl 클래스를 객체로 생성하는 과정에서
	 * getMapper() method를 자동으로 호출하고 orderDao를 초기화 하라
	 * 
	 * ServiceImpl 클래스를 객체로 생성할 때 호출되는 생성자는
	 * 최초에 한번 Container에 등록될 때 호출된다.
	 * 
	 * 이후에 다른 객체, 변수 등을 초기화 하려면
	 * 별도의 method를 만든 후 @Autowired를 설정해 주어야 한다.
	 */
	@Autowired
	public void getMapper() {
		this.orderDao = sqlSession.getMapper(OrderDao.class);
	}
	
	@Override
	public List<OrderVO> selectAll() {
		List<OrderVO> orderList = orderDao.selectAll();
		
		// Dao에서 받은 데이터가 있는(정확한)지 확인하는 코드(Debugging)
		System.out.println(orderList);
		return orderList;
	}

	/*
	 * seq값을 파라메터로 받아서
	 * OrderDao.findBySeq(seq) 호출하고 DB로부터 전달되어온
	 * 주문서 1개 레코드를 orderVO에 받고
	 * 호출한 곳으로 그대로 return 구조
	 */
	@Override
	public OrderVO findBySeq(long seq) {
		// 7
		OrderVO orderVO = orderDao.findBySeq(seq);
		return orderVO;
	}

	@Override
	public int insert(OrderVO orderVO) {
		
		int ret = orderDao.insert(orderVO);
		return ret;
	}

	@Override
	public int update(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		
		int ret = orderDao.delete(seq);
		return ret;
	}
	

}
