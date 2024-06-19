package aed;
import java.util.ArrayList;

public class Trie<T>{

    private Nodo root;
    private int size;


    private class Nodo {
        ArrayList<Nodo> next;
        T definicion;
        public Nodo(){
            next = new ArrayList();
            for(int i = 0; i < 256; i++){
                next.add(null);
            }
        }

       
    }

   
    // Constructor
    public Trie() {
        this.size = 0;
    }

    //Método para insertar una palabra en el trie
    public void insert(String key, T value) {
   
        if(root == null){root = new Nodo();}
        Nodo nodo = root;
        for (int i = 0; i < key.length(); i++) {
            char index = key.charAt(i);
        
            if (nodo.next.get(index) == null) {
                nodo.next.set(index, new Nodo());
            }   
            nodo = nodo.next.get(index); 
        }
        nodo.definicion = value;
        
        size += 1;

       
    }

    public T get(String key){
        if(root ==null) return null;
        Nodo nodo = root;
        for(int i = 0; i < key.length(); i++){
            char index = key.charAt(i);
            if(nodo.next.get(index) == null){
                return null;
            }
            nodo = nodo.next.get(index);
        }
        if(nodo.definicion != null){
            return  nodo.definicion;
        } else {
            return null;
        }
    }

   
    // public void delete(String key) { 
    //     root = delete(root, key, 0); 
    //     size -= 1;
   
    // }
    // private Nodo delete(Nodo x, String key, int d) {
    //     Nodo nodo;
    //     if (x == null) return null;
    //     if (d == key.length())
    //         x.definicion = null;
    //     else {
    //         char c = key.charAt(d);
    //         nodo =  x.children.get(c);
    //         nodo = delete(nodo, key, d+1);
    //     }
    //     if (x.definicion != null) return x;
    //     for (char c = 0; c < 256; c++)
    //         if (x.children.get(c) != null) return x;
    //     return null;
    // }

    

}