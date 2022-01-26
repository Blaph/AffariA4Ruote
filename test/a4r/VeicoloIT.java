/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.DescrizioneOptional;
import A4R.Foto;
import A4R.Noleggio;
import A4R.Veicolo;
import A4R.VeicoloPersonalizzato;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phili
 */
public class VeicoloIT {
    
    public VeicoloIT() {
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

    /**
     * Test of creaVeicoloPersonalizzato method, of class Veicolo.
     */
    
    @Test
    public void Veicolo(){
       Concessionario C =  new Concessionario(1, "VirAuto", "Catania", 0);
       Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile");
       Assert.assertEquals("FIAT", V.getProduttore());
       
    }
    
    @Test
    public void testVeicoloPersonalizzato(){
        Concessionario C =  new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V =  new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile");
        VeicoloPersonalizzato VP = V.creaVeicoloPersonalizzato();
        Assert.assertNull(VP.getCodice());
    }
    
    @Test
    public void testFotoVeicolo(){
        Concessionario C =  new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V =  new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile");
         Foto f1 = new Foto("Avanti");
        V.getListaFoto().add(f1);
        Assert.assertEquals(1,V.getListaFoto().size());

        
    }
   
    
}
