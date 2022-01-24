/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
public class DescrizioneOptional {

    public DescrizioneOptional(String nome, float prezzo, String colore){
        this.nome = nome;
        this.prezzo = prezzo;
        this.colore = colore;
    }

    private String nome;
    private float prezzo;
    private String colore;


    //Getter/Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
    
}
