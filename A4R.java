/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Phoenix
 */
public class A4R {

    private Parco P;
    private Concessionario concessionario = null;
    private Utente utente = null;
    private HashMap<Integer, Utente> mappaUtenti;
    private HashMap<Integer, Concessionario> mappaConcessionari;
    private Veicolo veicolo;
    private VeicoloPersonalizzato VPcorrente;
    private VeicoloNoleggiabile veicoloNoleggiabile;
    private MetodoPagamentoAdapter metodoPagamentoAdapter;
    private HashMap<Integer, MetodoPagamentoAdapter> mappaMetodoPagamento;
    private Acquisto ricevutaAcquisto;
    private Noleggio ricevutaNoleggio;
    private ArrayList<Ordine> ordiniErogati;
    private Ordine ordineCorrente;
    private Foto F;
    private String esitoControllo;
    private String esitoPagamento;
    private float prezzoFinale;
    private int durataNoleggio;
    private GregorianCalendar inizio = new GregorianCalendar();
    private GregorianCalendar fine = new GregorianCalendar();
    private int giornoInizio;
    private int meseInizio;
    private int annoInizio;
    private int giornoFine;
    private int meseFine;
    private int annoFine;
    private String luogoRitiro;
    private int counterFoto = 1;
    private Veicolo V;
    private ArrayList<String> elencoLuoghi;

    private Scanner input;

    private static A4R instance;

    private void A4R() {
    }

    public static A4R getInstance() {
        if (instance == null) {
            System.err.println("Istanza creata");
            instance = new A4R();
        }
        return instance;
    }

    public void startup(Parco P) {
        this.P = P;
        input = new Scanner(System.in);

        // Utenti
        Utente riccardo = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Utente philip = new Utente(2, "Philip", "Tambe'", "Corso Italia", 5, true);
        Utente orazio = new Utente(3, "Orazio", "Tomarchio", "Cittadella Universitaria", 20, false);

        this.utente = riccardo;

        // Concessionari
        Concessionario mucarauto = new Concessionario(1, "Mu.Car.Auto", "Aci San Filippo", 0);
        Concessionario virauto = new Concessionario(2, "Virauto", "Catania", 10);
        Concessionario cundari = new Concessionario(3, "Cundari", "Piazza Roma", 30);

        // Veicoli
        Veicolo panda = new Veicolo(1, mucarauto, 1000, "FIAT", "Panda", 1000, "Automobile");   // Veicolo base
        Veicolo punto = new Veicolo(2, virauto, 1000, "FIAT", "Punto", 1300, "Automobile");   // Veicolo base
        Veicolo modelX = new Veicolo(3, virauto, 1000, "Tesla", "Model X", 30000, "Automobile");   // Veicolo base
        Veicolo f8 = new Veicolo(4, cundari, 1000, "Ferrari", "F8", 1000, "Automobile");   // Veicolo base
        Veicolo tmax = new Veicolo(5, cundari, 1000, "Yamaha", "T-MAX", 1000, "Motoveicolo");   // Veicolo base
        Veicolo zip = new Veicolo(6, virauto, 20, "Piaggio", "ZIP", 125, "Motoveicolo");
        Veicolo scania = new Veicolo(7, mucarauto, 20, "IVECO", "Scania", 2000, "Automobile");
        Veicolo ninja = new Veicolo(8, cundari, 2000, "Kawasaki", "Ninja", 600, "Motoveicolo");
        Veicolo fiorino = new Veicolo(9, cundari, 1700, "FIAT", "Fiorino", 1200, "Automobile");
        Veicolo a1 = new Veicolo(10, virauto, 5000, "Audi", "A1", 1600, "Automobile");
        Veicolo ypsilon = new Veicolo(4, virauto, 7000, "Lancia", "Ypsilon", 1300, "Automobile");
        Veicolo giulietta = new Veicolo(5, mucarauto, 9000, "Alpha-Romeo", "Giulietta", 2000, "Automobile");
        Veicolo v7 = new Veicolo(6, mucarauto, 4000, "Moto-Guzzi", "V7", 700, "Motoveicolo");

        // Descrizioni optional
        DescrizioneOptional specchietti = new DescrizioneOptional("Specchietti", 20, "Rossi");
        DescrizioneOptional verniceGialla = new DescrizioneOptional("Vernice gialla", 50, "Giallo");
        DescrizioneOptional marmittaNuova = new DescrizioneOptional("Marmitta nuova", 100, "Nero");
        DescrizioneOptional vetriOscurati = new DescrizioneOptional("Vetri oscurati", 150, "Nero");
        DescrizioneOptional alettone = new DescrizioneOptional("Alettone", 1000, "Nero");

        //DescrizioneOptional su Veicolo
        panda.getMappaDO().put(specchietti.getNome(), specchietti);
        panda.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        panda.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        panda.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        panda.getMappaDO().put(alettone.getNome(), alettone);
        punto.getMappaDO().put(specchietti.getNome(), specchietti);
        punto.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        punto.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        punto.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        punto.getMappaDO().put(alettone.getNome(), alettone);
        modelX.getMappaDO().put(specchietti.getNome(), specchietti);
        modelX.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        modelX.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        modelX.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        modelX.getMappaDO().put(alettone.getNome(), alettone);
        f8.getMappaDO().put(specchietti.getNome(), specchietti);
        f8.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        f8.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        f8.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        f8.getMappaDO().put(alettone.getNome(), alettone);
        tmax.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        tmax.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);

        zip.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        zip.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        scania.getMappaDO().put(specchietti.getNome(), specchietti);
        scania.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        scania.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        scania.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        scania.getMappaDO().put(alettone.getNome(), alettone);

        ninja.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        ninja.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        fiorino.getMappaDO().put(specchietti.getNome(), specchietti);
        fiorino.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        fiorino.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        fiorino.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        fiorino.getMappaDO().put(alettone.getNome(), alettone);
        a1.getMappaDO().put(specchietti.getNome(), specchietti);
        a1.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        a1.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        a1.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        a1.getMappaDO().put(alettone.getNome(), alettone);
        scania.getMappaDO().put(specchietti.getNome(), specchietti);
        scania.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        scania.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        scania.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        scania.getMappaDO().put(alettone.getNome(), alettone);
        ypsilon.getMappaDO().put(specchietti.getNome(), specchietti);
        ypsilon.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        ypsilon.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        ypsilon.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        ypsilon.getMappaDO().put(alettone.getNome(), alettone);
        giulietta.getMappaDO().put(specchietti.getNome(), specchietti);
        giulietta.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        giulietta.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        giulietta.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        giulietta.getMappaDO().put(alettone.getNome(), alettone);
        v7.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        v7.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);

        // Salvataggio optional -> veicoli
        panda.getMappaDO().put("Vetri Oscurati", vetriOscurati);
        panda.getMappaDO().put("Specchietti", specchietti);
        panda.getMappaDO().put("Vernice gialla", verniceGialla);

        zip.getMappaDO().put("Specchietti", specchietti);
        zip.getMappaDO().put("Vernice gialla", verniceGialla);
        zip.getMappaDO().put("Marmitta nuova", marmittaNuova);

        // Optional
        Optional specchiettiOP = new Optional(specchietti);
        Optional verniceGiallaOP = new Optional(verniceGialla);
        Optional marmittaNuovaOP = new Optional(marmittaNuova);
        Optional vetriOscuratiOP = new Optional(vetriOscurati);
        Optional alettoneOP = new Optional(alettone);

        //Salva Veicoli 
        P.getMappaVeicoli().put(panda.getCodice(), panda);
        P.getMappaVeicoli().put(punto.getCodice(), punto);
        P.getMappaVeicoli().put(modelX.getCodice(), modelX);
        P.getMappaVeicoli().put(f8.getCodice(), f8);
        P.getMappaVeicoli().put(tmax.getCodice(), tmax);
        P.getMappaVeicoli().put(zip.getCodice(), zip);
        P.getMappaVeicoli().put(scania.getCodice(), scania);
        P.getMappaVeicoli().put(ninja.getCodice(), ninja);
        P.getMappaVeicoli().put(fiorino.getCodice(), fiorino);
        P.getMappaVeicoli().put(a1.getCodice(), a1);
        P.getMappaVeicoli().put(ypsilon.getCodice(), ypsilon);
        P.getMappaVeicoli().put(giulietta.getCodice(), giulietta);
        P.getMappaVeicoli().put(v7.getCodice(), v7);

        // Salvataggio utenti
        mappaUtenti = new HashMap<>();
        mappaUtenti.put(riccardo.getCodice(), riccardo);
        mappaUtenti.put(philip.getCodice(), philip);
        mappaUtenti.put(orazio.getCodice(), orazio);

        // Salvataggio concessionari
        mappaConcessionari = new HashMap<>();
        mappaConcessionari.put(mucarauto.getCodice(), mucarauto);
        mappaConcessionari.put(virauto.getCodice(), virauto);
        mappaConcessionari.put(cundari.getCodice(), cundari);

        //MetodiPagamento
        MetodoPagamentoAdapter contoCorrente = new MetodoPagamentoAdapter("ContoCorrente", 2, 5);
        MetodoPagamentoAdapter payPal = new MetodoPagamentoAdapter("PayPal", 1, 5);

        //Salvataggio MetodoPagamento
        mappaMetodoPagamento = new HashMap<>();
        mappaMetodoPagamento.put(contoCorrente.getCodice(), contoCorrente);
        mappaMetodoPagamento.put(payPal.getCodice(), payPal);

        // Foto
        Foto f1 = new Foto("Avanti");
        Foto f2 = new Foto("Dietro");
        Foto f3 = new Foto("Sinistra");
        Foto f4 = new Foto("Destra");

        // Inserimento foto --> Veicoli
        panda.getListaFoto().add(f1);
        panda.getListaFoto().add(f2);
        panda.getListaFoto().add(f3);
        panda.getListaFoto().add(f4);
        zip.getListaFoto().add(f1);
        zip.getListaFoto().add(f2);
        zip.getListaFoto().add(f3);
        zip.getListaFoto().add(f4);
        ninja.getListaFoto().add(f1);
        ninja.getListaFoto().add(f2);
        ninja.getListaFoto().add(f3);
        ninja.getListaFoto().add(f4);
        fiorino.getListaFoto().add(f1);
        fiorino.getListaFoto().add(f2);
        fiorino.getListaFoto().add(f3);
        fiorino.getListaFoto().add(f4);

        punto.getListaFoto().add(f1);
        punto.getListaFoto().add(f2);
        punto.getListaFoto().add(f3);
        punto.getListaFoto().add(f4);

        modelX.getListaFoto().add(f1);
        modelX.getListaFoto().add(f2);
        modelX.getListaFoto().add(f3);
        modelX.getListaFoto().add(f4);

        f8.getListaFoto().add(f1);
        f8.getListaFoto().add(f2);
        f8.getListaFoto().add(f3);
        f8.getListaFoto().add(f4);

        tmax.getListaFoto().add(f1);
        tmax.getListaFoto().add(f2);
        tmax.getListaFoto().add(f3);
        tmax.getListaFoto().add(f4);

        scania.getListaFoto().add(f1);
        scania.getListaFoto().add(f2);
        scania.getListaFoto().add(f3);
        scania.getListaFoto().add(f4);

        a1.getListaFoto().add(f1);
        a1.getListaFoto().add(f2);
        a1.getListaFoto().add(f3);
        a1.getListaFoto().add(f4);

        ypsilon.getListaFoto().add(f1);
        ypsilon.getListaFoto().add(f2);
        ypsilon.getListaFoto().add(f3);
        ypsilon.getListaFoto().add(f4);

        giulietta.getListaFoto().add(f1);
        giulietta.getListaFoto().add(f2);
        giulietta.getListaFoto().add(f3);
        giulietta.getListaFoto().add(f4);

        v7.getListaFoto().add(f1);
        v7.getListaFoto().add(f2);
        v7.getListaFoto().add(f3);
        v7.getListaFoto().add(f4);
//VeicoloPersonalizzato(int codice, Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo, HashMap<String, DescrizioneOptional> mappaDO, ArrayList<Foto> listaFoto)
        VeicoloPersonalizzato zipP = new VeicoloPersonalizzato(1, virauto, 20, "Piaggio", "ZIP", 125, "Motoveicolo", zip.getMappaDO(), zip.getListaFoto());    // Veicolo personalizzato
        VeicoloPersonalizzato scaniaP = new VeicoloPersonalizzato(2, mucarauto, 20, "IVECO", "Scania", 2000, "Automobile", scania.getMappaDO(), scania.getListaFoto());    // Veicolo personalizzato
        VeicoloPersonalizzato ninjaP = new VeicoloPersonalizzato(1, cundari, 2000, "Kawasaki", "Ninja", 600, "Motoveicolo", ninja.getMappaDO(), ninja.getListaFoto()); // Veicolo noleggiabile
        VeicoloPersonalizzato fiorinoP = new VeicoloPersonalizzato(2, cundari, 1700, "FIAT", "Fiorino", 1200, "Automobile", fiorino.getMappaDO(), fiorino.getListaFoto()); // Veicolo noleggiabile (già noleggiato)
        VeicoloPersonalizzato a1P = new VeicoloPersonalizzato(3, virauto, 5000, "Audi", "A1", 1600, "Automobile", a1.getMappaDO(), a1.getListaFoto()); // Veicolo noleggiabile
        VeicoloPersonalizzato ypsilonP = new VeicoloPersonalizzato(4, virauto, 7000, "Lancia", "Ypsilon", 1300, "Automobile", ypsilon.getMappaDO(), ypsilon.getListaFoto()); // Veicolo noleggiabile
        VeicoloPersonalizzato giuliettaP = new VeicoloPersonalizzato(5, mucarauto, 9000, "Alpha-Romeo", "Giulietta", 2000, "Automobile", giulietta.getMappaDO(), giulietta.getListaFoto()); // Veicolo noleggiabile
        VeicoloPersonalizzato v7P = new VeicoloPersonalizzato(6, mucarauto, 4000, "Moto-Guzzi", "V7", 700, "Motoveicolo", v7.getMappaDO(), v7.getListaFoto()); // Veicolo noleggiabile

        VeicoloNoleggiabile ninjaN = new VeicoloNoleggiabile(1, cundari, 2000, "Kawasaki", "Ninja", 600, "Motoveicolo", ninja.getMappaDO(), ninja.getListaFoto()); // Veicolo noleggiabile
        VeicoloNoleggiabile fiorinoN = new VeicoloNoleggiabile(2, cundari, 1700, "FIAT", "Fiorino", 1200, "Automobile", fiorino.getMappaDO(), fiorino.getListaFoto()); // Veicolo noleggiabile (già noleggiato)
        VeicoloNoleggiabile a1N = new VeicoloNoleggiabile(3, virauto, 5000, "Audi", "A1", 1600, "Automobile", a1.getMappaDO(), a1.getListaFoto()); // Veicolo noleggiabile
        VeicoloNoleggiabile ypsilonN = new VeicoloNoleggiabile(4, virauto, 7000, "Lancia", "Ypsilon", 1300, "Automobile", ypsilon.getMappaDO(), ypsilon.getListaFoto()); // Veicolo noleggiabile
        VeicoloNoleggiabile giuliettaN = new VeicoloNoleggiabile(5, mucarauto, 9000, "Alpha-Romeo", "Giulietta", 2000, "Automobile", giulietta.getMappaDO(), giulietta.getListaFoto()); // Veicolo noleggiabile
        VeicoloNoleggiabile v7N = new VeicoloNoleggiabile(6, mucarauto, 4000, "Moto-Guzzi", "V7", 700, "Motoveicolo", v7.getMappaDO(), v7.getListaFoto()); // Veicolo noleggiabile

        //Optional su VeicoloPersonalizzato
        zipP.getListaOptional().add(marmittaNuovaOP);
        zipP.getListaOptional().add(verniceGiallaOP);
        scaniaP.getListaOptional().add(specchiettiOP);
        scaniaP.getListaOptional().add(verniceGiallaOP);
        scaniaP.getListaOptional().add(marmittaNuovaOP);
        scaniaP.getListaOptional().add(vetriOscuratiOP);
        scaniaP.getListaOptional().add(alettoneOP);
        ninjaP.getListaOptional().add(marmittaNuovaOP);
        ninjaP.getListaOptional().add(verniceGiallaOP);

        fiorinoP.getListaOptional().add(specchiettiOP);
        fiorinoP.getListaOptional().add(verniceGiallaOP);
        fiorinoP.getListaOptional().add(marmittaNuovaOP);
        fiorinoP.getListaOptional().add(vetriOscuratiOP);
        fiorinoP.getListaOptional().add(alettoneOP);

        a1P.getListaOptional().add(specchiettiOP);
        a1P.getListaOptional().add(verniceGiallaOP);
        a1P.getListaOptional().add(marmittaNuovaOP);
        a1P.getListaOptional().add(vetriOscuratiOP);
        a1P.getListaOptional().add(alettoneOP);

        ypsilonP.getListaOptional().add(specchiettiOP);
        ypsilonP.getListaOptional().add(verniceGiallaOP);
        ypsilonP.getListaOptional().add(marmittaNuovaOP);
        ypsilonP.getListaOptional().add(vetriOscuratiOP);
        ypsilonP.getListaOptional().add(alettoneOP);

        giuliettaP.getListaOptional().add(specchiettiOP);
        giuliettaP.getListaOptional().add(verniceGiallaOP);
        giuliettaP.getListaOptional().add(marmittaNuovaOP);
        giuliettaP.getListaOptional().add(vetriOscuratiOP);
        giuliettaP.getListaOptional().add(alettoneOP);

        v7P.getListaOptional().add(marmittaNuovaOP);
        v7P.getListaOptional().add(verniceGiallaOP);

        // Noleggio
        Noleggio noleggioFiorino = new Noleggio(riccardo, fiorinoN, "Catania");

        //Salva VeicoliPersonalizzati
        P.getMappaVeicoliPersonalizzati().put(zip.codice, zipP);
        P.getMappaVeicoliPersonalizzati().put(scania.codice, scaniaP);

        //Salva VeicoliNoleggiabili
        P.getMappaVeicoliNoleggiabili().put(ninjaN.getCodice(), ninjaN);
        P.getMappaVeicoliNoleggiabili().put(fiorinoN.getCodice(), fiorinoN);
        P.getMappaVeicoliNoleggiabili().put(a1N.getCodice(), a1N);
        P.getMappaVeicoliNoleggiabili().put(ypsilonN.getCodice(), ypsilonN);
        P.getMappaVeicoliNoleggiabili().put(giuliettaN.getCodice(), giuliettaN);
        P.getMappaVeicoliNoleggiabili().put(v7N.getCodice(), v7N);

        // Inserimento noleggio
        ordiniErogati = new ArrayList<>();
        ordiniErogati.add(noleggioFiorino);
        fiorino.setNoleggio(noleggioFiorino);

        // Inserimento veicoli
        P = P.getInstance();

        // Inserimento luoghi disponibili per il ritiro
        elencoLuoghi = new ArrayList<>();
        elencoLuoghi.add("Catania");
        elencoLuoghi.add("London");
        elencoLuoghi.add("Sapporo");
    }

    public void mostraAcquista() {
        P.mostraAcquista();
    }

    public void mostraNoleggia() {
        P.mostraNoleggia();
    }

    public void filtraVeicoliAcquisto(String produttore, String modello, String tipoVeicolo) {
        P.filtraVeicoliAcquisto(produttore, modello, tipoVeicolo);
    }

    public void filtraVeicoliNoleggio(String produttore, String modello, String tipoVeicolo) {
        P.filtraVeicoliNoleggio(produttore, modello, tipoVeicolo);
    }

    public VeicoloPersonalizzato scegliVeicoloAcquisto(int codice) {
        veicolo = P.getMappaVeicoli().get(codice);
        try {
            VPcorrente = P.creaVeicoloPersonalizzato(veicolo);
        } catch (NullPointerException e) {
            System.err.println("!!!!!");
            System.err.println("NUMERO NON VALIDO. Ritorno al menu' in corso...");
            System.err.println("!!!!!");
            return null;
        }
        ricevutaAcquisto = new Acquisto(utente, VPcorrente);
        ordineCorrente = ricevutaAcquisto;
        return VPcorrente;
    }

    public VeicoloNoleggiabile scegliVeicoloNoleggio(int codice) {
        veicoloNoleggiabile = P.getMappaVeicoliNoleggiabili().get(codice);
        luogoRitiro = veicoloNoleggiabile.recuperaLuogo();
        ricevutaNoleggio = new Noleggio(utente, veicoloNoleggiabile, luogoRitiro);
        return veicoloNoleggiabile;
    }

    public void aggiungiOptional(String nomeOptional) {
        P.aggiungiOptional(nomeOptional);
    }

    public void terminaPersonalizzazione(VeicoloPersonalizzato veicoloPersonalizzato) {
        P.terminaPersonalizzazione(veicoloPersonalizzato);
    }

    public void scegliLuogoRitiro(String luogoRitiro) {
        ricevutaAcquisto.scegliLuogoRitiro(luogoRitiro);

        //Mostra una lista di metodi di pagamento disponibili
        for (int codice : mappaMetodoPagamento.keySet()) {
            System.out.println("Codice: " + mappaMetodoPagamento.get(codice).getCodice() + ", Nome: " + mappaMetodoPagamento.get(codice).getNome());
        }
    }

    public void periodoNoleggio(GregorianCalendar inizio, GregorianCalendar fine) {
        ricevutaNoleggio.setInizio(inizio);
        ricevutaNoleggio.setFine(fine);
        durataNoleggio = ricevutaNoleggio.calcolaDurata(inizio, fine);
        for (int codice : mappaMetodoPagamento.keySet()) {
            System.out.println(mappaMetodoPagamento.get(codice));
        }
    }

    public void scegliPagamento(int codicePagamento) {
        metodoPagamentoAdapter = mappaMetodoPagamento.get(codicePagamento);
        System.out.println("Pagamento con: " + metodoPagamentoAdapter.getNome() + ", codice: " + metodoPagamentoAdapter.getCodice() + ", commissione: " + metodoPagamentoAdapter.getCommissioniPagamento());
        setPrezzoFinale(ordineCorrente.impostaOrdine(metodoPagamentoAdapter));
    }

    public void effettuaPagamentoAcquisto(float prezzoTotale) {
        esitoPagamento = metodoPagamentoAdapter.effettuaPagamento(prezzoTotale, ordineCorrente.tipologiaOrdine);
        if (esitoPagamento.equals("ok")) {
            GregorianCalendar dataAcquisto = new GregorianCalendar();
            System.out.println("Data suddivisa, in formato Gregorian Calendar:\n" + dataAcquisto.get(Calendar.DAY_OF_MONTH) + "/" + (dataAcquisto.get(Calendar.MONTH) + 1) + "/" + dataAcquisto.get(Calendar.YEAR) + ", " + "the n " + (dataAcquisto.get(Calendar.DAY_OF_WEEK) - 1) + " of the week" + ", the " + dataAcquisto.get(Calendar.DAY_OF_YEAR) + " day of the year. \n");

            ricevutaAcquisto.aggiornaAcquisto(dataAcquisto);
            ordiniErogati.add(ricevutaAcquisto);
        } else {
            for (int codice : mappaMetodoPagamento.keySet()) {
                System.out.println(mappaMetodoPagamento.get(codice));
            }
        }
    }

    public void effettuaPagamentoNoleggio(float prezzoTotale) {
        esitoPagamento = metodoPagamentoAdapter.effettuaPagamento(prezzoTotale, ordineCorrente.tipologiaOrdine);
        if (esitoPagamento.equals("ok")) {
            veicoloNoleggiabile.setNoleggio(ricevutaNoleggio);
            ordiniErogati.add(ricevutaNoleggio);
        } else {
            for (int codice : mappaMetodoPagamento.keySet()) {
                System.out.println(mappaMetodoPagamento.get(codice));
            }
        }
    }

    public void caricaMezzo(int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo) {
        P.caricaMezzo(concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo);
    }

    public void caricaFoto(Foto foto) {
        F = new Foto("foto" + counterFoto++);
        esitoControllo = controllaFoto(F);
        if (esitoControllo.equals("ok")) {
            P.aggiungiFoto(F);
        }
    }

    public void terminaCaricamento() {
        setF(null);
        setCounterFoto(0);
    }

    public String controllaFoto(Foto foto) {
        return "ok";
    }

    public void mostraDescrizioniOptional() {
        P.mostraDescrizioniOptional();
    }

    // L'utente ha scelto di visualizzare i veicoli in vendita
    public void opzione1() {

        //Mostra acquista
        mostraAcquista();

        //Filtra veicoli
        System.out.println("Desideri filtrare la lista? (s/n)");
        String risposta = input.next(); // Variabile usata per l'input letterale
        if (risposta.equals("s") || risposta.equals("S")) {
            System.out.println("Inserisci il produttore: ");
            String produttore = input.next();
            System.out.println("Inserisci il modello del veicolo");
            String modello = input.next();
            System.out.println("Inserisci il tipo del veicolo (Automobile/Motoveicolo)");
            String tipoVeicolo = input.next();
            filtraVeicoliAcquisto(produttore, modello, tipoVeicolo);
            System.out.println("Hai inserito:");
            System.out.println("PRODUTTORE: " + produttore);
            System.out.println("MODELLO: " + modello);
            System.out.println("TIPO VEICOLO: " + tipoVeicolo);
        }

        // Scegli Veicolo Acquisto
        System.out.println();
        System.out.println("Inserici il codice corrispondente al veicolo che hai scelto (0 per tornare indietro)");
        int codiceV = input.nextInt();
        if (codiceV == 0) {
            System.err.println("Ritorno al menu' in corso...");
            return;
        }
        VPcorrente = scegliVeicoloAcquisto(codiceV);
        if (VPcorrente == null) {
            return; //Se c'è stato un errore in "scegliVeicoloAcquisto", viene restituito null -> si torna al menu'
        }
        System.out.println("Ecco la lista di optional disponibili per il veicolo scelto: ");
        mostraDescrizioniOptional();

        // Personalizza veicolo
        System.out.println("Per favore, scegli l'optional da aggiungere inserendo il rispettivo nome ('esci' per tornare al menù principale): ");
        if (input.hasNextLine()) // Se è rimasto qualcosa nel buffer, gettalo
        {
            input.nextLine();
        }
        risposta = input.nextLine();
        if (risposta.equals("esci")) {
            System.err.println("Ritorno al menu' in corso...");
            return;
        }

        // Aggiungi optional
        aggiungiOptional(risposta);
        if (VPcorrente.getDescrizioneOptional() == null) // Se è stato lanciato un "NullPointerException", ritorna al menu'
        {
            return;
        }

        // Termina personalizzazione
        terminaPersonalizzazione(VPcorrente);

        // Scegli Luogo Ritiro
        System.out.println("Scegli il luogo di ritiro (attualmente disponibili solo 'Catania', 'London' e 'Sapporo'):");
        risposta = input.next();
        if (!elencoLuoghi.contains(risposta)) {
            System.err.println("Scelta non valida! Attualmente disponibili solo 'Catania', 'London' e 'Sapporo'");
            return;
        }
        scegliLuogoRitiro(risposta);

        // Scegli pagamento
        try {
            System.out.println("Scegli un metodo di pagamento digitando il codice corrispondente. '0' per tornare al menù principale.");
            codiceV = input.nextInt();
            if (codiceV == 0) {
                System.out.println("Ritorno al menu' in corso...");
                return;
            }
            scegliPagamento(codiceV);
        } catch (InputMismatchException | NullPointerException e) {
            System.err.println("Per favore, inserisci il numero del codice corrispondente.");
            System.err.println("Ritorno al menu' in corso...");
            return;
        }

        // Conferma dell'acquisto
        System.out.println("--- PREZZO FINALE: " + prezzoFinale + " ---");
        System.out.println("Per confermare il pagamento digita 'ok'. 'esci' per ritornare al menu' principale ed annullare l'acquisto.");
        risposta = input.next();
        if (risposta.equals("esci")) {
            System.out.println("Ritorno al menu' in corso...");
            return;
        }

        // Effettua Pagamento Acquisto
        effettuaPagamentoAcquisto(prezzoFinale);
        System.out.println("GRAZIE PER AVER ACQUISTATO CON NOI!");
        System.out.println("---- Riepilogo dell'acquisto ----");
        System.out.println(ricevutaAcquisto);
        System.out.println("Email inviata.");
        System.out.println("Ritorno al menu' in corso...");
    }

    // L'utente ha scelto di visualizzare i veicoli in vendita
    public void opzione2() {
        int codiceV = 0;

        mostraNoleggia();
        System.out.println("Desideri filtrare la lista? (s/n)");
        String risposta = input.next();
        if (risposta.equals("s") || risposta.equals("S")) {
            System.out.println("Inserisci il produttore: ");
            String produttore = input.next();
            System.out.println("Inserisci il modello dell'auto");
            String modello = input.next();
            System.out.println("Inserisci il tipo del veicolo (Automobile/Motoveicolo)");
            String tipoVeicolo = input.next();
            filtraVeicoliNoleggio(produttore, modello, tipoVeicolo);
        }
        System.out.println("Inserici il codice corrispondente al veicolo che hai scelto (0 per tornare indietro)");
        codiceV = input.nextInt();
        System.out.println(codiceV);
        if (codiceV == 0) {
            System.err.println("Ritorno al menu' in corso...");
            return;
        }
        veicoloNoleggiabile = scegliVeicoloNoleggio(codiceV);
        System.out.println("Per quale data vuoi noleggiare il veicolo?");
        System.out.println("Inserisci la data di INIZIO del noleggio:");
        System.out.println("GIORNO: ");
        giornoInizio = input.nextInt();
        System.out.println("Hai inserito il giorno: " + giornoInizio);
        System.out.println("MESE");
        meseInizio = input.nextInt();
        System.out.println("Hai inserito il mese: " + meseInizio);
        System.out.println("ANNO");
        annoInizio = input.nextInt();
        System.out.println("Hai inserito l'anno: " + annoInizio);
        inizio.set(annoInizio, meseInizio, giornoInizio);

        System.out.println("Inserisci la data di FINE del noleggio:");
        System.out.println("GIORNO: ");
        giornoFine = input.nextInt();
        System.out.println("Hai inserito il giorno: " + giornoFine);
        System.out.println("MESE");
        meseFine = input.nextInt();
        System.out.println("Hai inserito il mese: " + meseFine);
        System.out.println("ANNO");
        annoFine = input.nextInt();
        System.out.println("Hai inserito l'anno: " + annoFine);
        fine.set(annoFine, meseFine, giornoFine);
        System.out.println(fine.get(Calendar.DAY_OF_MONTH));
        System.out.println(fine.get(Calendar.MONTH));
        System.out.println(fine.get(Calendar.YEAR));
        try {
            if (inizio.after(fine)) {
                System.err.println("ERRORE, inserimento invalido");
            }

            System.out.println("Data di inizio noleggio (gg/MM/yyyy): " + inizio.get(Calendar.DAY_OF_MONTH) + "/" + inizio.get(Calendar.MONTH) + "/" + inizio.get(Calendar.YEAR));
            System.out.println("Data di fine noleggio (gg/MM/yyyy): " + fine.get(Calendar.DAY_OF_MONTH) + "/" + fine.get(Calendar.MONTH) + "/" + fine.get(Calendar.YEAR));

        } catch (IllegalArgumentException e) {
            System.out.println("Inserire la data in un formato valido: " + e);
            System.out.println("Ritorno al menu' in corso...");
            return;
        }
        System.out.println("Scegli un metodo di pagamento digitando il codice corrispondente. '0' per tornare al menù principale.");
        codiceV = input.nextInt();
        if (codiceV == 0) {
            System.out.println("Ritorno al menu' in corso...");
            return;
        }
        scegliPagamento(codiceV);
        System.out.println("Per confermare il pagamento digita 'ok'. 'esci' per ritornare al menu' principale ed annullare l'acquisto.");
        risposta = input.next();
        if (risposta.equals("esci")) {
            System.out.println("Ritorno al menu' in corso...");
            return;
        }
        effettuaPagamentoNoleggio(prezzoFinale);
        System.out.println("GRAZIE PER AVER NOLEGGIATO CON NOI!");
        System.out.println("---- Riepilogo del noleggio ----");
        System.out.println(ricevutaNoleggio);
        System.out.println("Email inviata.");
        risposta = input.next();
        System.out.println("Ritorno al menu' in corso...");
    }

    public void opzione3() {
        System.out.println("Inserisci il prezzo base del veicolo:");
        int prezzoBase = input.nextInt();
        System.out.println("Inserisci il produttore del veicolo:");
        String produttore = input.next();
        System.out.println("Inserisci il modello del veicolo:");
        String modello = input.next();
        System.out.println("Inserisci la cilindrata del veicolo:");
        int cilindrata = input.nextInt();
        System.out.println("Inserisci il tipo del veicolo: (autoveicolo, motoveicolo)");
        String tipoVeicolo = input.next();
        caricaMezzo(prezzoBase, produttore, modello, cilindrata, tipoVeicolo);




        ///////// gestire caricamento vuoto
        


        System.out.println("Inserisci le foto del veicolo (max 4)");
        for (int i = 0; i < 4; i++) {
            System.out.println("Foto" + i);
            caricaFoto(F);
        }
        terminaCaricamento();
        System.out.println("Veicolo caricato con successo!");
    }

    // Getter/Setter
    public Parco getP() {
        return P;
    }

    public void setP(Parco P) {
        this.P = P;
    }

    public Concessionario getConcessionario() {
        return concessionario;
    }

    public void setConcessionario(Concessionario concessionario) {
        this.concessionario = concessionario;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public HashMap<Integer, Utente> getMappaUtenti() {
        return mappaUtenti;
    }

    public void setMappaUtenti(HashMap<Integer, Utente> mappaUtenti) {
        this.mappaUtenti = mappaUtenti;
    }

    public HashMap<Integer, Concessionario> getMappaConcessionari() {
        return mappaConcessionari;
    }

    public void setMappaConcessionari(HashMap<Integer, Concessionario> mappaConcessionari) {
        this.mappaConcessionari = mappaConcessionari;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public VeicoloPersonalizzato getVPcorrente() {
        return VPcorrente;
    }

    public void setVPcorrente(VeicoloPersonalizzato VPcorrente) {
        this.VPcorrente = VPcorrente;
    }

    public VeicoloNoleggiabile getVeicoloNoleggiabile() {
        return veicoloNoleggiabile;
    }

    public void setVeicoloNoleggiabile(VeicoloNoleggiabile veicoloNoleggiabile) {
        this.veicoloNoleggiabile = veicoloNoleggiabile;
    }

    public MetodoPagamentoAdapter getMetodoPagamentoAdapter() {
        return metodoPagamentoAdapter;
    }

    public void setMetodoPagamentoAdapter(MetodoPagamentoAdapter metodoPagamentoAdapter) {
        this.metodoPagamentoAdapter = metodoPagamentoAdapter;
    }

    public HashMap<Integer, MetodoPagamentoAdapter> getMappaMetodoPagamento() {
        return mappaMetodoPagamento;
    }

    public void setMappaMetodoPagamento(HashMap<Integer, MetodoPagamentoAdapter> mappaMetodoPagamento) {
        this.mappaMetodoPagamento = mappaMetodoPagamento;
    }

    public Acquisto getRicevutaAcquisto() {
        return ricevutaAcquisto;
    }

    public void setRicevutaAcquisto(Acquisto ricevutaAcquisto) {
        this.ricevutaAcquisto = ricevutaAcquisto;
    }

    public Noleggio getRicevutaNoleggio() {
        return ricevutaNoleggio;
    }

    public void setRicevutaNoleggio(Noleggio ricevutaNoleggio) {
        this.ricevutaNoleggio = ricevutaNoleggio;
    }

    public ArrayList<Ordine> getOrdiniErogati() {
        return ordiniErogati;
    }

    public void setOrdiniErogati(ArrayList<Ordine> ordiniErogati) {
        this.ordiniErogati = ordiniErogati;
    }

    public Ordine getOrdineCorrente() {
        return ordineCorrente;
    }

    public void setOrdineCorrente(Ordine ordineCorrente) {
        this.ordineCorrente = ordineCorrente;
    }

    public Foto getF() {
        return F;
    }

    public void setF(Foto F) {
        this.F = F;
    }

    public String getEsitoControllo() {
        return esitoControllo;
    }

    public void setEsitoControllo(String esitoControllo) {
        this.esitoControllo = esitoControllo;
    }

    public String getEsitoPagamento() {
        return esitoPagamento;
    }

    public void setEsitoPagamento(String esitoPagamento) {
        this.esitoPagamento = esitoPagamento;
    }

    public float getPrezzoFinale() {
        return prezzoFinale;
    }

    public void setPrezzoFinale(float prezzoFinale) {
        this.prezzoFinale = prezzoFinale;
    }

    public int getDurataNoleggio() {
        return durataNoleggio;
    }

    public void setDurataNoleggio(int durataNoleggio) {
        this.durataNoleggio = durataNoleggio;
    }

    public String getLuogoRitiro() {
        return luogoRitiro;
    }

    public void setLuogoRitiro(String luogoRitiro) {
        this.luogoRitiro = luogoRitiro;
    }

    public int getCounterFoto() {
        return counterFoto;
    }

    public void setCounterFoto(int counterFoto) {
        this.counterFoto = counterFoto;
    }

}
