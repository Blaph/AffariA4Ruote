/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.DescrizioneOptional;
import A4R.Foto;
import A4R.MetodoPagamento;
import A4R.Noleggio;
import A4R.Utente;
import A4R.Veicolo;
import A4R.VeicoloNoleggiabile;
import A4R.VeicoloPersonalizzato;
import java.time.LocalDate;
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
public class NoleggioIT {
    
    public NoleggioIT() {
    }
    
    @Test
    public void Noleggia(){
        Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        DescrizioneOptional alettone = new DescrizioneOptional("Alettone", 1000, "Nero");
        Veicolo v7 = new Veicolo(6, C, 4000, "Moto-Guzzi", "V7", 700, "Motoveicolo");
        DescrizioneOptional verniceGialla = new DescrizioneOptional("Vernice gialla", 50, "Giallo");
        DescrizioneOptional marmittaNuova = new DescrizioneOptional("Marmitta nuova", 100, "Nero");
        v7.getMappaDO().put(verniceGialla.getNome(),verniceGialla);
        v7.getMappaDO().put(marmittaNuova.getNome(),marmittaNuova);
       // P.getMappaVeicoli().put(v7.getCodice(), v7);
        Foto f1 = new Foto("Avanti");
        Foto f2 = new Foto("Dietro");
        Foto f3 = new Foto("Sinistra");
        Foto f4 = new Foto("Destra");
        v7.getListaFoto().add(f1);
        v7.getListaFoto().add(f2);
        v7.getListaFoto().add(f3);
        v7.getListaFoto().add(f4);
        VeicoloPersonalizzato v7P = new VeicoloPersonalizzato(6, C, 4000, "Moto-Guzzi", "V7", 700, "Motoveicolo",v7.getMappaDO(), v7.getListaFoto()); 
        VeicoloNoleggiabile v7N = new VeicoloNoleggiabile(6, C, 4000, "Moto-Guzzi", "V7", 700, "Motoveicolo",v7.getMappaDO(), v7.getListaFoto());
        Noleggio N = new Noleggio(U, v7N,"Catania");
        Assert.assertNotNull(N);
       
        float totale = ((N.getPrezzoGiornaliero() * N.getDurataNoleggio()) + ((N.getPrezzoBase() * N.getIva()) / 100) + N.getCommissioneA4R() + N.getCommissionePagamento() - ((N.getPrezzoBase() * N.getScontoPremium()) / 100) - ((N.getPrezzoBase() * N.getScontoA4R()) / 100) - ((N.getPrezzoBase() * N.getScontoConcessionario()) / 100));
        float calcoloNoleggio = N.calcoloTotaleNoleggio( N.getPrezzoGiornaliero(), N.getDurataNoleggio(), N.getIva(), N.getCommissioneA4R(), N.getCommissionePagamento(), N.getScontoPremium(), N.getScontoA4R(), N.getScontoConcessionario());
        Assert.assertEquals(totale, calcoloNoleggio);
    }
    
}
