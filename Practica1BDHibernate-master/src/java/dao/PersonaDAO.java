/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO { //se crea la variable session en Session
    Session session;
    
    public PersonaDAO(){
        session=HibernateUtil.getLocalSession(); //la variable session se depositara en la clase HibernateUtil y se obtendran los variables de LocalSession en la variable session
    }
    
    public  Persona getPersonaById(int id){
        return (Persona)session.load(Persona.class, id); //en la variable session se cargaran los datos de la clase Persona y los id de la misma
    }
    
    public List<Persona>  getPersonaByName(String nombre){
        List<Persona> listaDePersonas=(List<Persona>) //Se inicializa la arraylist de Persona en el objeto de ListaDePersonas
                session.createCriteria(Persona.class) //la variable session crea un criterio en la clase Persona si se inicia
                .add(Restrictions.eq("Nombre", nombre)); //se inicializan las restricciones y se insertan los datos de Nombre en el nombre
        return listaDePersonas; //se retornan los valores a la listaDePersonas
    }
    
    public boolean updateById(int id,Persona persona){
        Persona personaAModificar=getPersonaById(id); //se crea el objeto personaAModificar de Persona y se obtienen el id de la persona
        try{ //se inicializa el try catch
            Transaction transaccion=session.beginTransaction(); //se inicializa el objeto transaccion en la instancia Transaction
            personaAModificar.setNombre(persona.getNombre()); //personaAModificar enviara la informacion modificada al Nombre
            session.update(personaAModificar); //la variable session actualizara los datos modificados en el objeto personaAModificar
            transaccion.commit(); //actualizara con la inicializacion commit la transaccion
            return true; //si es verdadero retornara valores
        }catch(Exception e){ //se cierra el catch
            return false; //no retornara si no son validos los datos
        }
    }
    
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){ //se crea el motodo de savePersona donde guardara la informacion en el Nombre, apeido Materno, apeido Paterno, telefono e idTipoPersona
        Persona personaDeTanque=new Persona(); //Se inicializa un nuevo objeto personaDeTanque en Persona
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona); //se inicializa tipoDeTanque en TipoPersona, donde cargaran los datos de TipoPersona a idTipoPersona
        personaDeTanque.setNombre(nombre); //enviara informacion de nombre al objeto personaDeTanque
        personaDeTanque.setMaterno(materno); //enviara informacion de materno al objeto personaDeTanque
        personaDeTanque.setPaterno(paterno); //enviara informacion de paterno al objeto personaDeTanque
        personaDeTanque.setTelefono(telefono); //enviara informacion de telofono al objeto personaDeTanque
        personaDeTanque.setTipoPersona(tipoDeTanque); //enviara informacion de tipoDeTanque al objeto personaDeTanque
        try{ //se inicializa el try-catch
            Transaction transaccion=session.beginTransaction(); //la variable session comienza la transaccion
            session.save(personaDeTanque); //guarda los valores de personadeTanque
            transaccion.commit(); //actualiza con commit los valores en la transaccion
            return true; //retorna true
        }catch(Exception e){ //finaliza try-catch
            
        }finally{ //termina el ciclo
            
        }
        return true; //retorna true
    }
    
}
