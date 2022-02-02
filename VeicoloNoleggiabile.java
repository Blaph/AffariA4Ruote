/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Phoenix
 */
public class VeicoloNoleggiabile extends VeicoloPersonalizzato {

    public VeicoloNoleggiabile(int codice, Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo,  HashMap<String, DescrizioneOptional> mappaDO, ArrayList<Foto> listaFoto) {
        super(codice, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo, mappaDO, listaFoto);
        this.C = concessionario;
    }

    private int prezzoGiornaliero;
    private Concessionario C;
    private Noleggio noleggio = null;
    private boolean inNoleggio = false;

    public String recuperaLuogo() {
        return C.getLuogo();
    }

    //Getter/Setter
   public int getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(int prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public Concessionario getC() {
        return C;
    }

    public void setC(Concessionario C) {
        this.C = C;
    }

    public Noleggio getNoleggio() {
        return noleggio;
    }

    public void setNoleggio(Noleggio noleggio) {
        this.noleggio = noleggio;
    }

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
    
    public boolean getInNoleggio(){
        return inNoleggio;
    }
}
