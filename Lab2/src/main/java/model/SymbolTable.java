package model;

import com.sun.tools.javac.util.Pair;

public class SymbolTable {
    private MyHashTable hashTable;

    public SymbolTable(Integer m){
        hashTable = new MyHashTable(m);
    }

    public Pair<Integer, Integer>  add(String identifier){
        return hashTable.addElement(identifier);
    }

    public Pair<Integer, Integer>  add(Integer constant){
        return hashTable.addElement(constant.toString());
    }

    public Pair<Integer, Integer> search(String identifier){
        return hashTable.search(identifier);
    }

    public Pair<Integer, Integer> search(Integer constant){
        return hashTable.search(constant.toString());
    }

}
