/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.util.Scanner;

/**
 *
 * @author Phoenix
 */
public class UI {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        A4R system = A4R.getInstance();

        system.startup();

        //Il menù viene stampato ogni volta che si torna indietro
        while(true){
            // Menù di benvenuto
            System.out.println("  ______");
            System.out.println(" /|_||_\\`.__");
            System.out.println("(   _    _ _\\");
            System.out.println("=`-(_)--(_)-'");
            System.out.println("..::~~~ BENVENUTO SU 'AFFARI A 4 RUOTE' ~~~::..");
            System.out.println("1. Acquista un veicolo");
            System.out.println("2. Noleggia veicolo");
            System.out.println("3. Carica nuovo mezzo (devi prima autenticarti)");
            System.out.println("-----------------------------------------------");
            System.out.println("Per favore, scegli l'attività da eseguire: inserisci un numero.");

            // Casi d'uso
            int num = input.nextInt();
            switch (num) {
                case 1:
                    system.opzione1();  // UC5 e UC11
                    break;
                case 2:
                    system.opzione2();  // UC8
                    break;
                case 3:
                    system.opzione4();  // UC3
                    break;
                default:
                System.out.println("Opzione non valida.");
            }
        }
    }
}
