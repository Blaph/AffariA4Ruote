/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Acquisto;
import A4R.Concessionario;
import A4R.DescrizioneOptional;
import A4R.Foto;
import A4R.MetodoPagamento;
import A4R.MetodoPagamentoAdapter;
import A4R.Utente;
import A4R.Veicolo;
import A4R.VeicoloPersonalizzato;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author phili
 */
public class AcquistoIT {
    
    public AcquistoIT() {
    }
    
    
    @Test  
    public void testScegliLuogoRitiro(){
        System.out.println("testScegliLuogoRitiro");
        Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        VeicoloPersonalizzato VP = new VeicoloPersonalizzato(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto());

        
        //scegli luogo eistente
        Acquisto A = new Acquisto(U, VP);
        A.scegliLuogoRitiro("Catania");
        Assert.assertEquals(0,A.getTasseDogane(), 0.1);
        Assert.assertEquals(0,A.getCostoSpedizione(), 0.1);

      
        //scegli luogo eistente
        Acquisto A1 = new Acquisto(U, VP);
        A1.scegliLuogoRitiro("London");
        Assert.assertEquals(150,A1.getTasseDogane(), 0.1);
        Assert.assertEquals(500,A1.getCostoSpedizione(), 0.1);
        
        //scegli luogo NON eistente
        Acquisto A2 = new Acquisto(U, VP);
        A2.scegliLuogoRitiro("Roma");
        Assert.assertEquals(30,A2.getTasseDogane(), 0.1);
        Assert.assertEquals(50,A2.getCostoSpedizione(), 0.1);
         
    }
    
    
    @Test
    public void testCostoFinale(){    
        System.out.println("testCostoFinale");
        Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        VeicoloPersonalizzato VP = new VeicoloPersonalizzato(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto());
        Acquisto A = new Acquisto(U, VP);
        MetodoPagamentoAdapter MP = new  MetodoPagamentoAdapter("payPal",1,10);
        
        A.impostaOrdine(MP); 
        A.aggiornaTasseDogane(C.getLuogo());

        //Controllo calcolo totale dell'acquisto
        float prezzo = 1700 + ((1700*22)/100) + 0 + 3 + 10 + 0 - ((1700*0)/100) - ((1700*0)/100) - ((1700*0)/100);
        float totale = A.calcoloTotaleAcquisto( A.getPrezzoBase(), A.getIva(), A.getTasseDogane(), A.getCommissioneA4R(), A.getCommissionePagamento(), A.getCostoSpedizione(), A.getScontoPremium(), A.getScontoA4R(), A.getScontoConcessionario(), A.getPrezzoOptional());
        Assert.assertEquals(prezzo,totale, 0.1);
        
    }
    

    
    
    
    
}
