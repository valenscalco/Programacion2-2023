package ejercicio3;

import java.util.ArrayList;
import java.util.Collections;


public class ListaGenerica<T extends Comparable <T>>{
    private ArrayList<T> lista;
    public ListaGenerica() {
        lista = new ArrayList<T>();
    }
    public void agregar(T elemento) {
        lista.add(elemento);
    }
    public  ArrayList<T> getList() {
        return lista;
    }
    public int getSize() {
        return lista.size();
    }
    public void agregarFirst(T elemento) {
        lista.add(0,elemento);
    }
    public void ordenar() {
        Collections.sort(lista);
    }
    public void desordenar() {
        Collections.shuffle(lista);
    }

    //Agregar exception si es mas grande que la cant de elementos
    public void addPosition(T elemento, Integer position) {
        lista.add(position, elemento);
    }

    //Agregar exception si es mas grande que la cant de elementos
    public T obtener(int indice) {
        return lista.get(indice);
    }

    //Agregar exception si la lista esta vacia
    public T obtenerFirst() {
        return lista.get(0);
    }

    //Agregar exception si la lista esta vacia
    public T obtenerLast() {
        int tam = lista.size();
        return lista.get(tam-1);
    }

    //Agregar exception si el elemento no existe
    public void delete(int position) {
        lista.remove(position);
    }
}