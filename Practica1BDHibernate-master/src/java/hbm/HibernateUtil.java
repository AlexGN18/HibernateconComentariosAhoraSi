/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //se crea variable tipo final que no es modificada
    private static final ThreadLocal localSession; //se crea variable hilo final de la sesion actual
    
    static {
        try { //inicializa el try
           Configuration config = new Configuration(); //crea objeto config
            config.configure("hibernate.cfg.xml"); //se le ingresa a config el valor de hinernate.cfg.xml
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(). //se inicializa objeto builder de StandardServiceRegistryBuilder
            applySettings(config.getProperties()); //se generan las propiedades generales en las configuraciones
            sessionFactory = config.buildSessionFactory(builder.build()); //la variable global se le añaden las propiedades de la configuracion del builder
        } catch (Throwable ex) { //finaliza el catch
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex); //imprime en consola si ocurre un error
            throw new ExceptionInInitializerError(ex); //genera un hilo en la exception si inicializa un error
        }
        localSession = new ThreadLocal(); //asigna a la variable global de localSession un hilo Local
    }
    
    public static SessionFactory getSessionFactory() { //inicializa getter de SessionFactory
        return sessionFactory;
    }
    
     public static Session getLocalSession() { //inicializa getter de LocalSession
        Session session = (Session) localSession.get(); //asigna objeto session en instancia Session y lo guarda en LocalSession
        if (session == null) { //inicializa el if donde el objeto session es null
            session = sessionFactory.openSession(); //hasta que sessionFactory abre una sesion en el servidor
            localSession.set(session); //y localSession envia los datos del inicio de sesion
            System.out.println("\nsesion iniciada"); //imprime en pantalla que inicio sesion el usuario
        }
        return session; //retorna el inicio de sesion
    }
     
     public static void closeLocalSession() {
        Session session = (Session) localSession.get(); //asigna objeto session de la instancia Session y obtiene la sesion 
        if (session != null) session.close(); //inicializa un if donde el objeto no es igual y lo hace null y cierra sesion
        localSession.set(null); //localSession envia null y termina proceso
        System.out.println("sesion cerrada\n"); //imprime en pantalla que cerro sesion
    }
}
