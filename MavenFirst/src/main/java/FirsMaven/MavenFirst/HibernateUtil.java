package FirsMaven.MavenFirst;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;

//import com.demo.hbm.entity.Address;
//import com.demo.hbm.entity.Employee;

public class HibernateUtil {
	   private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {
	            StandardServiceRegistryBuilder registryBuilder = 
	                  new StandardServiceRegistryBuilder();

	            Map<String, String> settings = new HashMap<String,String>();
	            settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	            settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/testdb");
	            settings.put("hibernate.connection.username", "manu");
	            settings.put("hibernate.connection.password", "nikonD3200");
	            settings.put("hibernate.show_sql", "true");
	            settings.put("hibernate.hbm2ddl.auto", "create-drop");

	            registry = registryBuilder.applySettings(settings).build();

	            MetadataSources sources = new MetadataSources(registry)
	                  .addAnnotatedClass(Student.class)
	                  .addAnnotatedClass(Registration.class);

	            Metadata metadata = sources.getMetadataBuilder().build();

	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	         } catch (Exception e) {
	            System.out.println("SessionFactory creation failed"+e.getMessage());
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
	}