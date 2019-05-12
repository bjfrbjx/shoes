package com.shoes.until;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public interface DAO{
    public <T> List<T> gets(T o);
	public <T> List<T> page(int index,int rows,T t);
    public  <T> List<T> getall(Class<T> c);
	public <T> T getone(T o);
	public <T> Boolean save(T o);
	public <T> Boolean delete(T o);
	public <T> Boolean update(T o);
	
}
