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
		// TODO �Զ����ɵĹ��캯�����
	}
public static void main(String srg[]) {
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    //�����Ự��������
    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    //�Ự����
    Session session = sessionFactory.openSession();
    //��������
    Transaction transaction = session.beginTransaction();
	Users m=null;
	m=new Users();
	m.setEmail("1er2345345d@12.com");
	m.setName("����ɽ��");
	m.setPassword("232cgwer234e");
	m.setSex("��");
	session.save(m);
	transaction.commit();	
	System.out.println("ok");
}
}
