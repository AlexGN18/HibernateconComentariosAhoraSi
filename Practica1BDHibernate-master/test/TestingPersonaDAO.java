/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.PersonaDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Persona;

/**
 *
 * @author RigoBono
 */
public class TestingPersonaDAO {
    
    public TestingPersonaDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void hello() {
         PersonaDAO personita=new PersonaDAO(); //Se inicializa el objeto personita de PersonaDao
         Persona personaProNuevoPablo=new Persona(); //se inicializa un nuevi objeto personaProNuevoPablo en Persona
         personaProNuevoPablo.setNombre("Ilich"); //el objeto personaProNuevoPablo envia el nombre "Ilich"
         personita.updateById(4, personaProNuevoPablo); //personita da de alta la id en el arreglo 4 en el objeto de personaProNuevoPablo
     }
}
