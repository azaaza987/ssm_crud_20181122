package com.atguigu.crud.test;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MapperTest2 {
	
	DataSource pooledDataSource = null;
	
	SqlSessionFactory sqlSessionFactory;
	
	@Before 
    public void init() {
        ApplicationContext   context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");//这里路径之前没有配对于是一直出错
        pooledDataSource = (ComboPooledDataSource) context.getBean("pooledDataSource");
        sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        System.out.println("ini....");
    }
	
	@Test
	public void  testConnect() {
		System.out.println("testconnect....");
		System.out.println(pooledDataSource);
		System.out.println(sqlSessionFactory);
		
		
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);//跟上述sql区别
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
	    for (int i = 0; i < 500; i++) {
	    	String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid, "M", uid+"@Shawn.com", 1));
	    }
	    sqlSession.commit();
	    long end = System.currentTimeMillis();
		
	}
	

}
