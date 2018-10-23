/*
 *
 *
 *
 *      Codice scritto da Guido Gonnella il 23 Ottobre 2018 per la verifica di Laboratorio
 *      di informatica.
 *
 *
 *
 */

package compitogonnella23ottobre2018;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class CompitoGonnella23ottobre2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader FileIN = new BufferedReader(new FileReader("PROVA.txt"));
        String s=FileIN.readLine(), Arr[];
        Vector SaldoPositivo=new Vector(1, 1), SaldoNegativo=new Vector(1, 1);
        s=FileIN.readLine();
        double tmp=0;

        try{
            while(s!=null){
                Arr=s.split(";", 5);

                if((Float.valueOf(Arr[3])+Float.valueOf(Arr[4]))>0){
                  tmp=Float.valueOf(Arr[3])+Float.valueOf(Arr[4]);

                   SaldoPositivo.add(Arr[0]+"  "+Arr[1]+"  "+Arr[2]+"  "+tmp);       //Se il saldo è positivo aggiungo al vettore dinamico dei saldi positivi le informazioni
                }
                else{
                  tmp=Float.valueOf(Arr[3])+Float.valueOf(Arr[4]);

                    SaldoNegativo.add(Arr[0]+"  "+Arr[1]+"  "+Arr[2]+"  "+tmp);      //Se il saldo è negativo aggiungo al vettore dinamico dei saldi negativi le informazioni
                }

                s=FileIN.readLine();
            }

            MyFrame MyFrame=new MyFrame(SaldoPositivo, SaldoNegativo);                          //Richiamo nel main un oggetto di classe MyFrame con dentro la mia interfaccia grafica
        }
        catch(Exception e ){
            System.out.println("Error: " + e);
        }
    }

    public static class MyFrame{                                                                //Classe MyFrame Con dentro la mia GUI
        public JFrame f;
        public JPanel p1;
        public JTextArea jta1, jta2;
        public JLabel l1, l2;
        private int i=0;
        private String STR=new String();


        public MyFrame(Vector a, Vector b){
            this.f=new JFrame("Saldi Positivi e Negativi");
            this.p1=new JPanel();

            this.jta1=new JTextArea();
            this.jta2=new JTextArea();
            this.l1=new JLabel("CLIENTI CON SALDO POSITIVO");
            this.l2=new JLabel("CLIENTI CON SALDO NEGATIVO");

            f.setSize(600, 339);
            p1.setSize(600, 300);
            f.add(p1);
            p1.setBackground(Color.LIGHT_GRAY);
            p1.setLayout(new GridLayout(2, 2, 5, 5));

            for(i=0; i<a.size(); i++){
                jta1.append((String) a.elementAt(i)+"\n");
            }

            for(i=0; i<b.size(); i++){
                jta2.append((String) b.elementAt(i)+"\n");
            }

            p1.add(l1);
            p1.add(l2);
            p1.add(jta1);
            p1.add(jta2);

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.pack();
        }
    }
}
