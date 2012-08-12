package persistence;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class HibernateUtil {
  private static SessionFactory sessionFactory;
  static {
    try {
       sessionFactory=new Configuration().configure().buildSessionFactory();
    	//sessionFactory=new Configuration().configure().addAnnotatedClass(ch2.hello.Message.class).buildSessionFactory();//Adding annotated classes programmatically
       sessionFactory=new Configuration().configure().addPackage("ch2.hello").buildSessionFactory();//Adding package name that has package-info.java file which contains the global annotation metadata info.
    } catch (Throwable ex) {
        throw new ExceptionInInitializerError(ex);
     }
   }
  
   public static SessionFactory getSessionFactory() {
       // Alternatively, you could look up in JNDI here
       return sessionFactory;
   }
  
   public static void shutdown() {
       // Close caches and connection pools
       getSessionFactory().close();
   }
   
 }