package com.shoes.until;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import java.lang.reflect.Field;
public class DAOimpl implements DAO {

	/*ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    //创建会话工厂对象
    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();*/
	SessionFactory sessionFactory =null;
	public SessionFactory getSessionFactory() {
		System.out.println("daoimpl get sessionfactory"+sessionFactory);
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("daoimpl set sessionfactory"+sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	public DAOimpl() {
	}
	@Override
 	public <T> List<T> getall(Class<T> c) {
		Session session=null;
		List<T> list=null;
		Transaction transaction=null;
		try {
			session = sessionFactory.openSession();
			transaction= session.beginTransaction();
			list = session.createCriteria(c).list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
		return list;
	}
	public <T> List<T> page(int index,int rows,T t){
		Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    Criteria cr= session.createCriteria(t.getClass());//设置查询
	    Field[] fs=t.getClass().getDeclaredFields();
	    try {
	    for(Field f:fs) {
	    	f.setAccessible(true);
			if(f.get(t)!=null) {
			cr.add(Restrictions.eq(f.getName(), f.get(t)));
					}	
	    	}
	    } catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    Long count= (Long) cr.setProjection(Projections.rowCount()).uniqueResult();//1先获取总记录数
	    cr.setProjection(null);//清空操作
	    int totalPage=(int) ((count%rows==0)?(count/rows):(count/rows+1));//2获取最大页数
	    index=index>totalPage?totalPage:(index<1?1:index);//保证index不超过最大页码和1
//	    
//	    for(Field f:fs) {
//	    	f.setAccessible(true);
//				if(f.get(t)!=null) {
//				cr.add(Restrictions.eq(f.getName(), f.get(t)));
//				}			
//	    	}
	    cr.setFirstResult((index-1)*rows);//页码
	    cr.setMaxResults(rows);//记录数
	    List<T> list=cr.list();
		transaction.commit();
		session.close();
		return list;
	}
	@Override
	public <T> List<T> gets(T o) {
		Session session = getSessionFactory().openSession();
	    Transaction transaction = session.beginTransaction();
	    @SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(o.getClass());
	    Field[] fs=o.getClass().getDeclaredFields();
	    List<T> l=null;
	    try {
	    for(Field f:fs) {
	    	f.setAccessible(true);
				if(f.get(o)!=null) {
				cr.add(Restrictions.eq(f.getName(), f.get(o)));
				}			
	    	}
	    transaction.commit();
		l =cr.list(); 
	    } catch (IllegalArgumentException e) {
			e.printStackTrace();
			transaction.rollback();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		
		return l;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getone(T o) {
		Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    @SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(o.getClass());
	    Field[] fs=o.getClass().getDeclaredFields();
	    try {
	    for(Field f:fs) {
	    	
	    	f.setAccessible(true);
				if(f.get(o)!=null) {
				cr.add(Restrictions.eq(f.getName(), f.get(o)));
				}			
	    	}
	    } catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		transaction.commit();
		List l =cr.list(); 
		session.close();
		if(l==null || l.size()<1)
			return null;
		return (T) l.get(0);
	}
	public <T> Boolean delete(T o){
		Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	    	System.out.println("del "+o);
	    	List<T> l=gets(o);
	    	System.out.println("del size "+l.size());
	    	if (l!=null){
	    	for (T obj:l){
	    		session.delete(obj);
	    	}
			transaction.commit();	
	    	}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	    finally {
	    	session.close();
	    }
		return true;
	
	}
	@Override
	public <T> Boolean save(T o) {
		Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	    	System.out.println("save ord "+o);
			session.save(o);
			transaction.commit();	
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			System.out.println("faile save: "+o);
			return false;
		}
	    finally {
	    	session.close();
	    }
		return true;
	}
	@Override
	public <T> Boolean update(T o) {
		Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	    	//o=this.getone(o);
			session.update(o);
			transaction.commit();	
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	    finally {
	    	session.close();
	    }
		return true;
	}

	
	
}
