/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uvsq.gl.exo1.Filtres.FiltreParMotCle;
import uvsq.gl.exo1.Filtres.FiltreParTaille;
import uvsq.gl.exo1.Filtres.FiltreParType;

/**
 *
 * @author mccstan
 */
public class FilteringTests {
    Message m1;
    Message m2;
    Message m3;
    Message m4;
    Message m5;
    GestionMessages gestionMessages;
    public FilteringTests() {
        gestionMessages=new GestionMessages();
        m1=new Message(MessageType.TEXT, "Un message TEXTE");
        m2=new Message(MessageType.XML, "Un message XML");
        m3=new Message(MessageType.BYTE, "Un message BYTE");
        m4=new Message(MessageType.XML, "Un message XML de longue taille");
        m5=new Message(MessageType.TEXT, "Un message TEXTE de longue taille");
        gestionMessages.addMessage(m1, m2, m3, m4, m5);
        
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
        // public void hello() {}

    /**
     *  Teste si le filtre par taille marche
     */
    @Test
    public void TestFiltreParTaille(){
        FiltreParTaille filtreParTaille=new FiltreParTaille(15, 50);
        gestionMessages.supprimerMessages(filtreParTaille);
        assertFalse(gestionMessages.getMessagesEntrant().contains(m4));
        assertFalse(gestionMessages.getMessagesEntrant().contains(m5));
    }

    /**
     *  Teste si le filtre par type marche
     */
    @Test
    public void TestFiltreParType(){
        FiltreParType filtreParType=new FiltreParType(MessageType.TEXT);
        gestionMessages.supprimerMessages(filtreParType);
        assertFalse(gestionMessages.getMessagesEntrant().contains(m1));
        assertFalse(gestionMessages.getMessagesEntrant().contains(m5));
    }
    
    /**
     *  Teste si le filtre par mot clé marche
     */
    @Test
    public void TestParMotCle(){
        FiltreParMotCle filtreParMotCle=new FiltreParMotCle("BYTE");
        gestionMessages.supprimerMessages(filtreParMotCle);
        assertFalse(gestionMessages.getMessagesEntrant().contains(m3));
    }
}
