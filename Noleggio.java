/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
import java.time.LocalDate;

public class Noleggio extends Ordine {

    public Noleggio(Utente utente, VeicoloNoleggiabile veicoloNoleggiabile, String luogoRitiro) {
        super();
        this.utente = utente;
        this.veicoloNoleggiabile = veicoloNoleggiabile;
        this.luogoRitiro = luogoRitiro;
    }

    private LocalDate inizio;
    private LocalDate fine;
    private int durataNoleggio;
    private Utente utente;
    private Concessionario concessionario;
    private MetodoPagamentoAdapter metodoPagamentoAdapter;
    private int scontoPremium;
    private int prezzoGiornaliero;
    private int scontoConcessionario;
    private int prezzoBase;

    public int calcolaDurata(LocalDate inizio, LocalDate fine) {
        //Ritorna > 0 se fine è cronologicamente successivo a inizio
        return (fine.compareTo(inizio));
    }

    public float calcoloTotaleNoleggio(int prezzoGiornaliero, int durataNoleggio, int IVA, int commissioneA4R, float commissionePagamento, int scontoPremium, int scontoA4R, int scontoConcessionario) {
        prezzoBase = veicoloNoleggiabile.getPrezzoBase();
        return ((prezzoGiornaliero * durataNoleggio) + ((prezzoBase * IVA) / 100) + commissioneA4R + commissionePagamento - ((prezzoBase * scontoPremium) / 100) - ((prezzoBase * scontoA4R) / 100) - ((prezzoBase * scontoConcessionario) / 100));
    }

    @Override
    public void aggiornaAcquisto(LocalDate dataAcquisto) {
    }

    @Override
    public void aggiornaCostoSpedizione(String luogoRitiro) {
        this.costoSpedizione = 0;
    }

    @Override
    public float impostaOrdine(MetodoPagamento metodoPagamento) {
        scontoPremium = utente.getScontoPremium();
        prezzoGiornaliero = veicoloNoleggiabile.getPrezzoGiornaliero();
        scontoConcessionario = concessionario.getScontoConcessionario();
        commissionePagamento = metodoPagamentoAdapter.getCommissioniPagamento();
        return prezzoFinale = calcoloTotaleNoleggio(prezzoGiornaliero, durataNoleggio, IVA, commissioneA4R, commissionePagamento, scontoPremium, scontoA4R, scontoConcessionario);
    }

    @Override
    public float calcoloTotaleAcquisto(int prezzoBase, int IVA, float tasseDogane, int commissioneA4R, float commissionePagamento, float costoSpedizione, int scontoPremium, int scontoA4R, int scontoConcessionario, int prezzoOptional) {
        return 0;
    }

    @Override
    public void aggiornaTasseDogane(String luogoRitiro) {
        this.tasseDogane = 0;
    }

    @Override
    public void scegliLuogoRitiro(String luogoRitiro) {
        this.luogoRitiro = luogoRitiro;
    }
    
    public int getPrezzoGiornaliero(){
     return prezzoGiornaliero;
    }
    //Getter/Setter
    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }
    
    public int getPrezzoBase(){
        return prezzoBase;
    }
    
    public int getIva(){
        return IVA;
    }
    
     public float getCommissionePagamento(){
    return commissionePagamento;
    }

    public float getCostoSpedizione(){
        return costoSpedizione;
    }
    
    public int getScontoPremium(){
        return scontoPremium;
    }
    
        public int getScontoA4R(){
        return scontoA4R;
    }

    public int getScontoConcessionario(){
        return scontoConcessionario;
    }
  
    public int getCommissioneA4R(){
        return commissioneA4R;
    }
    
    public int getDurataNoleggio(){
        return durataNoleggio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public void setDurataNoleggio(int durataNoleggio) {
        this.durataNoleggio = durataNoleggio;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getTipologiaOrdine() {
        return tipologiaOrdine;
    }

    public void setTipologiaOrdine(String tipologiaOrdine) {
        this.tipologiaOrdine = tipologiaOrdine;
    }

    public String getLuogoRitiro() {
        return luogoRitiro;
    }

    public void setLuogoRitiro(String luogoRitiro) {
        this.luogoRitiro = luogoRitiro;
    }

    public float getTasseDogane() {
        return tasseDogane;
    }

    public void setTasseDogane(float tasseDogane) {
        this.tasseDogane = tasseDogane;
    }



    public void setCommissionePagamento(float commissionePagamento) {
        this.commissionePagamento = commissionePagamento;
    }



    public void setCostoSpedizione(float costoSpedizione) {
        this.costoSpedizione = costoSpedizione;
    }



    public void setScontoA4R(int scontoA4R) {
        this.scontoA4R = scontoA4R;
    }

    public float getPrezzoFinale() {
        return prezzoFinale;
    }

    public void setPrezzoFinale(float prezzoFinale) {
        this.prezzoFinale = prezzoFinale;
    }

    public VeicoloNoleggiabile getVeicoloNoleggiabile() {
        return veicoloNoleggiabile;
    }

    public void setVeicoloNoleggiabile(VeicoloNoleggiabile veicoloNoleggiabile) {
        this.veicoloNoleggiabile = veicoloNoleggiabile;
    }
}
