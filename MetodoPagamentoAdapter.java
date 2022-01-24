/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
public class MetodoPagamentoAdapter implements MetodoPagamento {

    private int codice;
    private int commissioniPagamento;

    @Override
    public String effettuaPagamento(float prezzoTotale, String tipologiaOrdine) {
        return "OK";
    }

// Getter/Setter
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getCommissioniPagamento() {
        return commissioniPagamento;
    }

    public void setCommissioniPagamento(int commissioniPagamento) {
        this.commissioniPagamento = commissioniPagamento;
    }

}
