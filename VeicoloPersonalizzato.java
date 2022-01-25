/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Phoenix
 */

public class VeicoloPersonalizzato extends Veicolo {

    public VeicoloPersonalizzato(int codice, Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo, HashMap<String, DescrizioneOptional> mappaDO, ArrayList<Foto> listaFoto) {
        super(codice, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo);
         this.mappaDO =  mappaDO;
         this.listaFoto = listaFoto;
        listaOptional = new ArrayList<Optional>();
    }

    private Optional optional;
    private ArrayList<Optional> listaOptional;
    private Concessionario C;
    private DescrizioneOptional descrizioneOptional;
    protected int prezzoOptional = 0;

    public void aggiungiOptional(String nomeOptional) {
        descrizioneOptional = mappaDO.get(nomeOptional);
        optional = new Optional(descrizioneOptional);
        listaOptional.add(optional);
        // Prezzo totale + prezzo dell'optional appena aggiunto
        setPrezzoOptional(prezzoOptional + descrizioneOptional.getPrezzo());
    }

    // Stampa elenco degli optional
    public void mostraDescrizioniOptional() {
        for (String nome : mappaDO.keySet()) {
            System.out.println("Codice: " + nome + ", Optional: " + mappaDO.get(codice).getNome());
        }
    }

    public int recuperaScontoConcessionario() {
        return concessionario.getScontoConcessionario();
    }

// Getter/Setter
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(int prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getTipoVeicolo() {
        return tipoVeicolo;
    }

    public void setTipoVeicolo(String tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }

    public Noleggio getNoleggio() {
        return noleggio;
    }

    public void setNoleggio(Noleggio noleggio) {
        this.noleggio = noleggio;
    }

    public HashMap<Integer, VeicoloPersonalizzato> getMappaVeicoliPersonalizzati() {
        return mappaVeicoliPersonalizzati;
    }

    public void setMappaVeicoliPersonalizzati(HashMap<Integer, VeicoloPersonalizzato> mappaVeicoliPersonalizzati) {
        this.mappaVeicoliPersonalizzati = mappaVeicoliPersonalizzati;
    }

    public ArrayList<Foto> getListaFoto() {
        return listaFoto;
    }

    public void setListaFoto(ArrayList<Foto> listaFoto) {
        this.listaFoto = listaFoto;
    }

    public Concessionario getConcessionario() {
        return concessionario;
    }

    public void setConcessionario(Concessionario concessionario) {
        this.concessionario = concessionario;
    }

    public int getPrezzoOptional() {
        return prezzoOptional;
    }

    public void setPrezzoOptional(int prezzoOptional) {
        this.prezzoOptional = prezzoOptional;
    }

    public HashMap<String, DescrizioneOptional> getMappaDO() {
        return mappaDO;
    }

    public void setMappaDO(HashMap<String, DescrizioneOptional> mappaDO) {
        this.mappaDO = mappaDO;
    }

    public DescrizioneOptional getDescrizioneOptional() {
        return descrizioneOptional;
    }

    public void setDescrizioneOptional(DescrizioneOptional descrizioneOptional) {
        this.descrizioneOptional = descrizioneOptional;
    }

    public Optional getOptional() {
        return optional;
    }

    public void setOptional(Optional optional) {
        this.optional = optional;
    }

    public ArrayList<Optional> getListaOptional() {
        return listaOptional;
    }

    public void setListaOptional(ArrayList<Optional> listaOptional) {
        this.listaOptional = listaOptional;
    }

    public Concessionario getC() {
        return C;
    }

    public void setC(Concessionario C) {
        this.C = C;
    }
}
