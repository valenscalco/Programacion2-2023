package ejercicio2;

import java.util.ArrayList;
import java.util.Collection;

public class ListaGenerica<T> {
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
    public int tamanio() {
        return lista.size();
    }
    public void agregarFirst(T elemento) {
        lista.add(0,elemento);
    }
    public void ordenar() {
        lista.Collection.sort(elemento);
    }
    public void desordenar(T elemento) {
        lista.Collections.shuffle(elemento);
    }
    public void addPosition(T elemento, Integer position) {
        lista.add(position, elemento);
    }
    public T obtener(int indice) {
        return lista.get(indice);
    }
    public T obtenerFirst() {
        return lista.get(0);
    }
    public T obtenerLast() {
        int tam = lista.size();
        return lista.get(tam);
    }
    public void delete(int position) {
        lista.remove(position);
    }
}
