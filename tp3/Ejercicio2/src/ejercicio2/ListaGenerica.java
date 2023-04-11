package ejercicio2;

import java.util.ArrayList;
import java.util.Collections;


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
        Collections.sort(lista);
    }
    public void desordenar() {
        Collections.shuffle(lista);
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
        return lista.get(tam-1);
    }
    public void delete(int position) {
        lista.remove(position);
    }
}
