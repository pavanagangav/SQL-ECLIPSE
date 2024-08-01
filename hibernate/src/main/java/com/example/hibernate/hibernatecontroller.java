package com.example.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernatecontroller {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		hibernate h = new hibernate();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name");
		h.setName(sc.next());
		System.out.println("enter the email");
		h.setEmail(sc.next());
		System.out.println("enter the password");
		h.setPassword(sc.next());
		System.out.println("enter the phonenumber");
		h.setPhonenumber(sc.nextLong());
//       h.setName("pavani");
//       h.setEmail("pavani@email.com");
//       h.setPassword("pavani");
//       h.setPhonenumber(234567890);
		s.save(h);
		t.commit();
		System.out.println("successfully inserted");
		s.close();
		sf.close();
	}

}
