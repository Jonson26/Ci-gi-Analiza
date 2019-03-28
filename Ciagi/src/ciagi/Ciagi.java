/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciagi;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Filip
 */
public class Ciagi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(); //tutaj wprowadzamy ciąg do analizy
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(4);
        a.add(4);
        a.add(3);
        a.add(5);
        a.add(4);
        Ciagi c = new Ciagi();
        c.analizuj(a);
    }
    
    public void analizuj(ArrayList<Integer> ciag){ //rozpoczynamy analizę
        Tree t = new Tree(-51); //pierwszy węzeł musi mieć wartość mniejszą od najmniejszej występującej w ciągu
        analizujDalej(t, ciag, 0); //tworzymy drzewo
        System.out.println(longestBranch(t)-1); //wywalamy długość najdłuższej gałęzi -1 (patrz wyżej)
    }
    
    public void analizujDalej(Tree t, ArrayList<Integer> ciag, int j){ //kod tworzący drzewo
        for(int i=j; i<ciag.size(); i++){
            if(ciag.get(i)>t.a){
                t.addNode(ciag.get(i));
                analizujDalej(t.getNode(t.nodesCount()-1), ciag, i+1);
            }
        }
    }
    
    public int longestBranch(Tree t){ //ten kod liczy najdłuższą gałąź drzewa. niestety liczy też pierwszą, której akurat nie potrzebujemy od wyniku będzie trzebna odjąć 1. rekurencyjna natura metody uniemozliwia wykonanie tego od środka.
        int x = 1;
        ArrayList<Integer> branchlengths = new ArrayList<>();
        for(int i=0; i<t.nodesCount(); i++){
            if(t.nodesCount()>0){
                branchlengths.add(longestBranch(t.getNode(i)));
            }
        }
        Collections.sort(branchlengths, Collections.reverseOrder());
        if(branchlengths.size()>0){
            x += branchlengths.get(0);
        }
        return x;
    }
}
