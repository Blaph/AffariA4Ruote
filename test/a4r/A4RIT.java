/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.Parco;
import A4R.A4R;
import A4R.Acquisto;
import A4R.Noleggio;
import A4R.Foto;
import A4R.Veicolo;
import A4R.VeicoloNoleggiabile;
import A4R.DescrizioneOptional;
import A4R.MetodoPagamentoAdapter;
import A4R.Utente;
import A4R.VeicoloPersonalizzato;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phili
 */
public class A4RIT {
    
    public A4RIT() {
    }
    
    
    
    @Test
    public void testScegliVeicoloAcquisto() {
        System.out.println("testScegliVeicoloAcquisto");
        A4R a4r = A4R.getInstance();
        Parco P = Parco.getInstance();
        
        //con starup vengono creati 10 veioli base 
        a4r.startup(P);

       //scegli Veicolo per l'acquisto con il codice corretto (da 1 a 26)
        VeicoloPersonalizzato VP1 = a4r.scegliVeicoloAcquisto(1);
        org.junit.Assert.assertNotNull(VP1);
        
        //scegli Veicolo per l'acquisto con il codice uguale a 11, NON corretto 
        VeicoloPersonalizzato VP11 = a4r.scegliVeicoloAcquisto(27);
        org.junit.Assert.assertNull(VP11);
        
        //scegli Veicolo per l'acquisto con il codice uguale a 0, NON corretto 
        VeicoloPersonalizzato VP1000 = a4r.scegliVeicoloAcquisto(0);
        org.junit.Assert.assertNull(VP1000);
        
        //scegli Veicolo per l'acquisto con il codice uguale a -1, NON corretto 
        VeicoloPersonalizzato VPnegativo = a4r.scegliVeicoloAcquisto(-1);
        org.junit.Assert.assertNull(VPnegativo);
        System.out.println("\n");

    }
    
    @Test
    public void testScegliPagamento() {
        System.out.println("testScegliPagamento");
        A4R a4r = A4R.getInstance();
        Parco P = Parco.getInstance();
        
        a4r.startup(P);

        a4r.scegliVeicoloAcquisto(1);
        
        //passo un metodo di pagamento corretto
        a4r.scegliPagamento(1);
        
        //se metodoPagamentto con codice 1 è uguale al MetodoPagamentoAdapter attuale allora è stato impostato correttamente
        assertEquals(a4r.getMappaMetodoPagamento().get(1),a4r.getMetodoPagamentoAdapter());
        
       //Passo un metodo pagamento NON corretto
       a4r.scegliPagamento(-1);
       assertNull(a4r.getMetodoPagamentoAdapter());
       
       //Passo un metodo pagamento NON corretto
       a4r.scegliPagamento(0);
       assertNull(a4r.getMetodoPagamentoAdapter());

       System.out.println("\n");
    }
    
    /*
    
    @Test
    public void testEffettuaPagamentoAcquisto() {
        System.out.println("testEffettuaPagamentoAcquisto");
        A4R a4r = A4R.getInstance();
        Parco P = Parco.getInstance();

        a4r.startup(P);
        a4r.scegliVeicoloAcquisto(1);
        a4r.scegliPagamento(1);
       
        a4r.effettuaPagamentoAcquisto(a4r.getPrezzoFinale());
        Acquisto acquisto = a4r.getRicevutaAcquisto();
        
      
        System.out.println("a4r.getPrezzoFinale()" + a4r.getPrezzoFinale());
        System.out.println("a4r.getRicevutaAcquisto())" + a4r.getRicevutaAcquisto());
        //problema nell'inserimento della data in effettua pagamento
        System.out.println("a4r.getRicevutaAcquisto().getDataAcquisto());" + a4r.getRicevutaAcquisto().getDataAcquisto());
        System.out.println("a4r.getOrdiniErogati()" + a4r.getOrdiniErogati());
                
        assertEquals(2, a4r.getOrdiniErogati().size());
        assertEquals(acquisto, a4r.getOrdiniErogati().get(1));
        
        a4r.effettuaPagamentoAcquisto(0);
        assertEquals(2, a4r.getOrdiniErogati().size());
       System.out.println("\n");
    }
    */
    /*
        @Test
    public void testScegliVeicoloNoleggio() {
        System.out.println("testScegliVeicoloNoleggio");
        A4R a4r = A4R.getInstance();
        Parco P = Parco.getInstance();
        
        //con starup vengono creati 10 veioli base, 8 personalizzati e 6 noleggiabili
        a4r.startup(P);
        
        System.out.println("VEICOLI NOLEGGIABILI:   --->" + P.getMappaVeicoliNoleggiabili());
        
       //scegli Veicolo per l'acquisto con il codice corretto (da 1 a 10)
        VeicoloPersonalizzato VP1 = a4r.scegliVeicoloNoleggio(1);
        org.junit.Assert.assertNotNull(VP1);
        
        //scegli Veicolo per il noleggio con il codice corretto (da 1 a 6)
        VeicoloPersonalizzato VP6 = a4r.scegliVeicoloNoleggio(6);
        System.out.println( VP6);
        org.junit.Assert.assertNotNull(VP6);
       
        //scegli Veicolo per il noleggio con il codice uguale a 7, NON corretto 
        VeicoloPersonalizzato VP7 = P.getMappaVeicoliNoleggiabili().get(7);
        org.junit.Assert.assertNull(VP7);
     
        //scegli Veicolo per  il noleggio con il codice uguale a 0, NON corretto 
        VeicoloPersonalizzato VP1000 =P.getMappaVeicoliNoleggiabili().get(0);
        org.junit.Assert.assertNull(VP1000);
        
        //scegli Veicolo per  il noleggio con il codice uguale a -1, NON corretto 
        VeicoloPersonalizzato VPnegativo = P.getMappaVeicoliNoleggiabili().get(-1);
        org.junit.Assert.assertNull(VPnegativo);
        System.out.println("\n");
    }
    */
        @Test
    public void testEffettuaPagamentoNoleggio() {
        System.out.println("testEffettuaPagamentoNoleggio");
        A4R a4r = A4R.getInstance();
        Parco P = Parco.getInstance();

        a4r.startup(P);

       // VN.setPrezzoGiornaliero(100);
      // LocalDate dataInizio =  LocalDate.of(2023, 3, 12);
      // LocalDate dataFine =  LocalDate.of(2023, 4, 16);

        VeicoloNoleggiabile VN = a4r.scegliVeicoloNoleggio(1);
         System.out.println(VN);
         
        Noleggio N =  a4r.getRicevutaNoleggio();
        System.out.println(N);
   
        
        
       // N.calcolaDurata(dataInizio, dataFine);
        
       VN.setNoleggio(N);
       VN.getNoleggio().setDurataNoleggio(30);
        
        System.out.println("VN.getPrezzoGiornaliero()" + VN.getPrezzoGiornaliero());
        System.out.println("VN.getNoleggio()" + VN.getNoleggio());
        System.out.println("VN.getInNoleggio()" + VN.getInNoleggio());
       System.out.println("VN.getConcessionario()" + VN.getConcessionario());
       System.out.println("VN.getConcessionario()" + VN.getConcessionario().getScontoConcessionario());
       
        a4r.scegliPagamento(1);
       System.out.println("a4r.getMetodoPagamentoAdapter()" + a4r.getMetodoPagamentoAdapter());
        
         System.out.println(" PREZZO FINALE" + VN.getNoleggio().getPrezzoFinale());
        
        a4r.effettuaPagamentoNoleggio( VN.getNoleggio().getPrezzoFinale());
        
        Noleggio noleggio = a4r.getRicevutaNoleggio();
        System.out.println(noleggio);
        
        System.out.println(a4r.getOrdiniErogati());
        //controllo se sono presenti 2 noleggi
        assertEquals(2, a4r.getOrdiniErogati().size());
        //controllo se l'ultimo noleggio inserito è quello che ho appena pagato
        assertEquals(noleggio, a4r.getOrdiniErogati().get(1));
        
        a4r.effettuaPagamentoNoleggio(0);
        //controllo se i noleggi  sono rimasti 2, e quindi l'ultimo (errato) non  è stato inserito
        assertEquals(2, a4r.getOrdiniErogati().size());
        
        a4r.effettuaPagamentoNoleggio(-1);
        //controllo se i noleggi  sono rimasti 2, e quindi l'ultimo (errato) non  è stato inserito
        assertEquals(2, a4r.getOrdiniErogati().size());
       System.out.println("\n");
    }
    
}
