/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
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
    private String luogoRitiro;
    private int counterFoto = 1;

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

    public void startup() {
        input = new Scanner(System.in);

        // Utenti
        Utente riccardo = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Utente philip = new Utente(2, "Philip", "Tambe'", "Corso Italia", 5, true);
        Utente orazio = new Utente(3, "Orazio", "Tomarchio", "Cittadella Universitaria", 20, false);

        // Concessionari
        Concessionario mucarauto = new Concessionario(1, "Mu.Car.Auto", "Aci San Filippo", 0);
        Concessionario virauto = new Concessionario(2, "Virauto", "Catania", 10);
        Concessionario cundari = new Concessionario(3, "Cundari", "Piazza Roma", 30);

        // Veicoli
        Veicolo panda = new Veicolo(1, mucarauto, 1000, "FIAT", "Panda", 1000, "Automobile");   // Veicolo base
        VeicoloPersonalizzato zip = new VeicoloPersonalizzato(2, virauto, 20, "Piaggio", "ZIP", 125, "Motoveicolo");    // Veicolo personalizzato
        VeicoloNoleggiabile ninja = new VeicoloNoleggiabile(3, cundari, 2000, "Kawasaki", "Ninja", 600, "Motoveicolo"); // Veicolo noleggiabile
        VeicoloNoleggiabile fiorino = new VeicoloNoleggiabile(4, cundari, 1700, "FIAT", "Fiorino", 1200, "Autoveicolo"); // Veicolo noleggiabile (già noleggiato)

        // Descrizioni optional
        DescrizioneOptional specchietti = new DescrizioneOptional("Specchietti", 20, "Rossi");
        DescrizioneOptional verniceGialla = new DescrizioneOptional("Vernice gialla", 50, "Giallo");
        DescrizioneOptional marmittaNuova = new DescrizioneOptional("Marmitta nuova", 100, "Nero");
        DescrizioneOptional vetriOscurati = new DescrizioneOptional("Vetri oscurati", 150, "Nero");

        // Optional
        Optional specchiettiOP = new Optional(specchietti);
        Optional verniceGiallaOP = new Optional(verniceGialla);
        Optional marmittaNuovaOP = new Optional(marmittaNuova);

        // Noleggio
        Noleggio noleggioFiorino = new Noleggio(riccardo, fiorino, "Catania");

        // Foto
        Foto f1 = new Foto("Avanti");
        Foto f2 = new Foto("Dietro");
        Foto f3 = new Foto("Sinistra");
        Foto f4 = new Foto("Destra");

        // Salvataggio utenti
        mappaUtenti.put(riccardo.getCodice(), riccardo);
        mappaUtenti.put(philip.getCodice(), philip);
        mappaUtenti.put(orazio.getCodice(), orazio);

        // Salvataggio concessionari
        mappaConcessionari.put(mucarauto.getCodice(), mucarauto);
        mappaConcessionari.put(virauto.getCodice(), virauto);
        mappaConcessionari.put(cundari.getCodice(), cundari);

        // Salvataggio optional -> veicoli
        panda.getMappaDO().put("Vetri Oscurati", vetriOscurati);
        panda.getMappaDO().put("Specchietti", specchietti);
        panda.getMappaDO().put("Vernice gialla", verniceGialla);
        zip.getMappaDO().put("Specchietti", specchietti);
        zip.getMappaDO().put("Vernice gialla", verniceGialla);
        zip.getMappaDO().put("Marmitta nuova", marmittaNuova);
        zip.getListaOptional().add(specchiettiOP);
        zip.getListaOptional().add(verniceGiallaOP);
        zip.getListaOptional().add(marmittaNuovaOP);
        ninja.getListaOptional().add(marmittaNuovaOP);
        ninja.getListaOptional().add(specchiettiOP);
        fiorino.getListaOptional().add(specchiettiOP);

        // Inserimento noleggio
        fiorino.setNoleggio(noleggioFiorino);

        // Inserimento foto
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

        // Inserimento veicoli
        P = P.getInstance();
        P.getMappaVeicoli().put(panda.getCodice(), panda);
        P.getMappaVeicoliPersonalizzati().put(zip.getCodice(), zip);
        P.getMappaVeicoliNoleggiabili().put(ninja.getCodice(), ninja);
        P.getMappaVeicoliNoleggiabili().put(fiorino.getCodice(), fiorino);
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
        VPcorrente = P.creaVeicoloPersonalizzato(veicolo);
        ricevutaAcquisto = new Acquisto(utente, VPcorrente);
        return VPcorrente;
    }

    public void scegliVeicoloNoleggio(int codice) {
        veicoloNoleggiabile = P.getMappaVeicoliNoleggiabili().get(codice);
        luogoRitiro = veicoloNoleggiabile.recuperaLuogo();
        ricevutaNoleggio = new Noleggio(utente, veicoloNoleggiabile, luogoRitiro);
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
            System.out.println(mappaMetodoPagamento.get(codice));
        }
    }

    public void periodoNoleggio(LocalDate inizio, LocalDate fine) {
        ricevutaNoleggio.setInizio(inizio);
        ricevutaNoleggio.setFine(fine);
        durataNoleggio = ricevutaNoleggio.calcolaDurata(inizio, fine);
        for (int codice : mappaMetodoPagamento.keySet()) {
            System.out.println(mappaMetodoPagamento.get(codice));
        }
    }

    public void scegliPagamento(int codicePagamento) {
        metodoPagamentoAdapter = mappaMetodoPagamento.get(codicePagamento);
        prezzoFinale = ordineCorrente.impostaOrdine(metodoPagamentoAdapter);
    }

    public void effettuaPagamentoAcquisto(float prezzoTotale) {
        esitoPagamento = metodoPagamentoAdapter.effettuaPagamento(prezzoTotale, ordineCorrente.tipologiaOrdine);
        if (esitoPagamento.equals("ok")) {
            ricevutaAcquisto.aggiornaAcquisto(LocalDate.now());
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

    public void mostraDescrizioniOptional(VeicoloPersonalizzato veicoloPersonalizzato) {
        P.mostraDescrizioniOptional();
    }

    // L'utente ha scelto di visualizzare i veicoli in vendita
    public void opzione1() {
        int codiceV = 0;
        mostraAcquista();
        System.out.println("Desideri filtrare la lista? (s/n)");
        String risposta = input.nextLine();
        if (risposta.equals("s") || risposta.equals("S")) {
            System.out.println("Inserisci il produttore: ");
            String produttore = input.nextLine();
            System.out.println("Inserisci il modello dell'auto");
            String modello = input.nextLine();
            System.out.println("Inserisci il tipo del veicolo (Autoveicolo/Motoveicolo)");
            String tipoVeicolo = input.nextLine();
            filtraVeicoliAcquisto(produttore, modello, tipoVeicolo);
        }
        System.out.println("Inserici il codice corrispondente al veicolo che hai scelto (0 per tornare indietro)");
        codiceV = input.nextInt();
        if (codiceV == 0) {
            System.err.println("Ritorno al menu' in corso...");
            return;
        }
        VPcorrente = scegliVeicoloAcquisto(codiceV);
        System.out.println("Ecco la lista di optional disponibili per il veicolo scelto: ");
        mostraDescrizioniOptional(VPcorrente);
        System.out.println("Per favore, scegli l'optional da aggiungere inserendo il rispettivo nome ('esci' per uscire): ");
        risposta = input.nextLine();
        if (risposta.equals("esci")) {
            (risposta.equals("esci"))
        }
            aggiungiOptional(risposta);
        terminaPersonalizzazione(VPcorrente);
        System.out.println("Scegli il luogo di ritiro (attualmente disponibili solo 'Catania', 'London' e 'Sapporo'):");
        risposta = input.nextLine();
        scegliLuogoRitiro(risposta);
        System.out.println("Scegli un metodo di pagamento digitando il codice corrispondente. '0' per tornare al menù principale.");
        codiceV = input.nextInt();
        if(codiceV == 0)
            return;
        scegliPagamento(codiceV);
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
