package ciagi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Filip
 */
public class Tree { //Klasa drzewa
    public ArrayList<Tree> nodes; //tu trzymane są węzły
    public int a; //a tu wartość
    
    public Tree(){ //konstruktor bezargumentowy - przypisuje węzłowi wartość domyślną 0
        nodes = new ArrayList();
        a = 0;
    }
    public Tree(int i){ //konstruktor argumentowy
        nodes = new ArrayList();
        a = i;
    }
    
    public void addNode(int i){ //dodaje nowy węzeł bez podwęzłów
        nodes.add(new Tree(i));
    }
    public void addNode(Tree t){ //dodaje uprzednio utworzone drzewo jako węzeł
        nodes.add(t);
    }
    
    public int nodesCount(){ //podaje ile podwęzłów ma dane drzewo
        return nodes.size();
    }
    
    public void delNode(int i){ //usuwa konkretne drzewo będące podwęzłem
        nodes.remove(i);
    }
    public Tree getNode(int i){ //zwraca konkretne drzewo będące podwęzłem
        return nodes.get(i);
    }
}
