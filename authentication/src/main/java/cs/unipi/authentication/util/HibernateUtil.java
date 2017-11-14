package cs.unipi.authentication.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            String hibernatePropsFilePath = "/opt/sourcecode/config/authentication/hibernate.cfg.xml";
            File hibernatePropsFile = new File(hibernatePropsFilePath);

            Configuration configuration = new Configuration();
            configuration.configure(hibernatePropsFile);
            System.out.println("Hibernate Configuration loaded");

            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure(hibernatePropsFile).build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();


        }
        catch (Throwable ex) {
            // Make sure you log the exceptions, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public static Session getSession() {
        Session currentSession = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        if(!currentSession.getTransaction().isActive()) {
            currentSession.beginTransaction();
        }
        return currentSession;
    }

    public static void closeSession() {
        Session sess = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        if(sess.getTransaction().isActive()) {
            sess.getTransaction().commit();
        }
        sess.flush();
        sess.close();
    }

}
