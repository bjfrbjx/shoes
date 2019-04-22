package cn;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Test {

	public Test() {
		// TODO 自动生成的构造函数存根
	}
public static void main(String srg[]) {
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    //创建会话工厂对象
    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    //会话对象
    Session session = sessionFactory.openSession();
    //开启事物
    Transaction transaction = session.beginTransaction();
	Users m=null;
	m=new Users();
	m.setEmail("1er2345345d@12.com");
	m.setName("气吞山河");
	m.setPassword("232cgwer234e");
	m.setSex("天");
	session.save(m);
	transaction.commit();	
	System.out.println("ok");
}
}
