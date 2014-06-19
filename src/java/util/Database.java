package util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Database {
    
    private static Database singleton = new Database();
    private SessionFactory sf;
    
    private Database(){    
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = 
                new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        sf = cfg.buildSessionFactory(serviceRegistry);
    }
    
    public static Database getInstance(){
        return singleton;
    }
    
    public Session getSession(){
        return sf.openSession();
    }
}
