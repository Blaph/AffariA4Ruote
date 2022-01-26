/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Acquisto;
import A4R.Concessionario;
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

/**
 *
 * @author phili
 */
public class AcquistoIT {
    
    public AcquistoIT() {
    }
    
    @Test
    public void testCostoFinale(){       
    Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
    Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
    Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
    VeicoloPersonalizzato VP = new VeicoloPersonalizzato(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto());
    Acquisto A = new Acquisto(U, VP);
    MetodoPagamentoAdapter MP = new  MetodoPagamentoAdapter("payPal",1,10);
    // test riga vuota non aggiunta
    A.impostaOrdine(MP); 
    A.aggiornaTasseDogane(C.getLuogo());
     //prezzoBase + ((prezzoBase * IVA) / 100) + tasseDogane + commissioneA4R + commissionePagamento + costoSpedizione - ((prezzoBase * scontoPremium) / 100) - ((prezzoBase * scontoA4R) / 100) - ((prezzoBase * scontoConcessionario) / 100)
    float prezzo = A.getPrezzoBase() + ((A.getPrezzoBase() * 22) / 100) + A.getTasseDogane() + A.getCommissioneA4R() + MP.getCommissioniPagamento() + A.getCostoSpedizione() - ((A.getPrezzoBase() * A.getScontoA4R()) / 100) - ((A.getPrezzoBase() * 0) / 100) - ((A.getPrezzoBase()* 0) / 100);
 //calcoloTotaleAcquisto(int prezzoBase, int IVA, float tasseDogane, int commissioneA4R, float commissionePagamento, float costoSpedizione, int scontoPremium, int scontoA4R, int scontoconcessionario, int prezzoOptional)
    float totale = A.calcoloTotaleAcquisto( A.getPrezzoBase(), A.getIva(), A.getTasseDogane(), A.getCommissioneA4R(), A.getCommissionePagamento(), A.getCostoSpedizione(), A.getScontoPremium(), A.getScontoA4R(), A.getScontoConcessionario(), A.getPrezzoOptional());
    Assert.assertEquals(prezzo,totale);
    }
    
    @Test
    public void testAcquisto(){
    Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
    Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
    Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
    VeicoloPersonalizzato VP = new VeicoloPersonalizzato(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto());
    Acquisto A = new Acquisto(U, VP);

    // test riga vuota non aggiunta
    A.aggiornaTasseDogane(C.getLuogo());
    Assert.assertEquals(0,A.getTasseDogane());
    }
    
}
