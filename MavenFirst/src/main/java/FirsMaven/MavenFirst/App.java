package FirsMaven.MavenFirst;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import com.demo.hbm.HibernateUtil;

//import com.marlabs.hbm.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    
    {
    	Session session = null;
        Transaction transaction = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           transaction = session.getTransaction();
           transaction.begin();
		Student studentdetail= new Student((long) 50509703,"Manu","Manudeep@gmail.com","ComputerScience");
		Registration registration = new Registration((long) 50509704,"Sai","sai@gmail.com","Engineering","Fitness","Monday");
		session.save(studentdetail);
		session.save(registration);
        //session.save(employee2);
        transaction.commit();

        System.out.println("Records saved successfully");

     } catch (Exception e) {
        if (transaction != null) {
           System.out.println("Transaction is being rolled back.");
           transaction.rollback();
        }
        e.printStackTrace();
     } finally {
        if (session != null) {
           session.close();
        }
     }
     HibernateUtil.shutdown();
    }
}
