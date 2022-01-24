/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
import java.util.HashMap;

public class Parco {

    private HashMap<Integer, Veicolo> mappaVeicoli;
    private HashMap<Integer, VeicoloPersonalizzato> mappaVeicoliPersonalizzati;
    private HashMap<Integer, VeicoloNoleggiabile> mappaVeicoliNoleggiabili;
    private Veicolo veicolo;
    private VeicoloPersonalizzato VPcorrente;
    private int counter = 0;
    private Noleggio noleggio;

    private static Parco instance;

    private void Parco() {
    }

    public static Parco getInstance() {
        if (instance == null) {
            System.err.println("Istanza creata");
            instance = new Parco();
        }
        return instance;
    }

    public void mostraAcquista() {
        for (int codice : mappaVeicoliPersonalizzati.keySet()) {
            System.out.println(mappaVeicoliPersonalizzati.get(codice));
        }
    }

    public void mostraNoleggia() {
        for (int codice : mappaVeicoliNoleggiabili.keySet()) {
            noleggio = mappaVeicoliNoleggiabili.get(codice).getNoleggio();
            //Stampa solo i veicoli che non sono ancora stati noleggiati
            if (noleggio == null) {
                System.out.println(mappaVeicoliNoleggiabili.get(codice));
            }
        }
    }

    public void filtraVeicoliAcquisto(String produttore, String modello, String tipoVeicolo) {
        for (int codice : mappaVeicoliPersonalizzati.keySet()) {
            if ((mappaVeicoliPersonalizzati.get(codice).getProduttore()).equals(produttore) && (mappaVeicoliPersonalizzati.get(codice).getModello()).equals(modello) && (mappaVeicoliPersonalizzati.get(codice).getTipoVeicolo()).equals(tipoVeicolo)) {
                System.out.println(mappaVeicoliPersonalizzati.get(codice));
            }
        }
    }

    public void filtraVeicoliNoleggio(String produttore, String modello, String tipoVeicolo) {
        for (int codice : mappaVeicoliNoleggiabili.keySet()) {
            //Se il veicolo non è stato noleggiato, esegui
            if (mappaVeicoliNoleggiabili.get(codice).getNoleggio().equals(null)) {
                if ((mappaVeicoliNoleggiabili.get(codice).getProduttore()).equals(produttore) && (mappaVeicoliNoleggiabili.get(codice).getModello()).equals(modello) && (mappaVeicoliNoleggiabili.get(codice).getTipoVeicolo()).equals(tipoVeicolo)) {
                    System.out.println(mappaVeicoliPersonalizzati.get(codice));
                }
            }
        }
    }

    public String recuperaLuogo(VeicoloNoleggiabile veicoloNoleggiabile) {
        return veicoloNoleggiabile.recuperaLuogo();
    }

    public void mostraDescrizioniOptional() {
        VPcorrente.mostraDescrizioniOptional();
    }

    public void aggiungiOptional(String nomeOptional) {
        VPcorrente.aggiungiOptional(nomeOptional);

    }

    public VeicoloPersonalizzato creaVeicoloPersonalizzato(Veicolo veicolo) {
        return VPcorrente = veicolo.creaVeicoloPersonalizzato();
    }

    public void terminaPersonalizzazione(VeicoloPersonalizzato veicoloPersonalizzato) {
        mappaVeicoliPersonalizzati.put(counter, veicoloPersonalizzato);
    }

    public void caricaMezzo(Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo) {
        counter++;
        veicolo = new Veicolo(counter, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo);
        mappaVeicoli.put(counter, veicolo);
    }

    public void aggiungiFoto(Foto foto) {
        veicolo.aggiungiFoto(foto);
    }

    // Getter/Setter
    public HashMap<Integer, VeicoloPersonalizzato> getMappaVeicoliPersonalizzati() {
        return mappaVeicoliPersonalizzati;
    }

    public void setMappaVeicoliPersonalizzati(HashMap<Integer, VeicoloPersonalizzato> mappaVeicoliPersonalizzati) {
        this.mappaVeicoliPersonalizzati = mappaVeicoliPersonalizzati;
    }

    public HashMap<Integer, VeicoloNoleggiabile> getMappaVeicoliNoleggiabili() {
        return mappaVeicoliNoleggiabili;
    }

    public void setMappaVeicoliNoleggiabili(HashMap<Integer, VeicoloNoleggiabile> mappaVeicoliNoleggiabili) {
        this.mappaVeicoliNoleggiabili = mappaVeicoliNoleggiabili;
    }

    public VeicoloPersonalizzato getVPcorrente() {
        return VPcorrente;
    }

    public void setVPcorrente(VeicoloPersonalizzato VPcorrente) {
        this.VPcorrente = VPcorrente;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Noleggio getNoleggio() {
        return noleggio;
    }

    public void setNoleggio(Noleggio noleggio) {
        this.noleggio = noleggio;
    }

    public HashMap<Integer, Veicolo> getMappaVeicoli() {
        return mappaVeicoli;
    }

    public void setMappaVeicoli(HashMap<Integer, Veicolo> mappaVeicoli) {
        this.mappaVeicoli = mappaVeicoli;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
}
