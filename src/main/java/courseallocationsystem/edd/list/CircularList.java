package courseallocationsystem.edd.list;

import courseallocationsystem.edd.Nodo;
import courseallocationsystem.model.Entidad;

/**
 *
 * 
 * @date 5/04/2021
 * @time 11:38:47
 * @author asael
 */
public class CircularList {

    private Nodo<Entidad> primero;
    private Nodo<Entidad> ultimo;
    private int size;

    public CircularList() {
        this.size = 0;
    }

    public void add(Entidad i) {
        Nodo<Entidad> nuevo = new Nodo(i);

        if (primero == null) {
            nuevo.setNext(nuevo);
            nuevo.setPrev(nuevo);
            primero = nuevo;
        } else {
            ultimo.setNext(nuevo);
            nuevo.setPrev(ultimo);

            primero.setPrev(nuevo);
            nuevo.setNext(primero);
        }
        size++;
        ultimo = nuevo;
    }
    /*
    public Entidad get(int id) {
        Nodo<Entidad> actual = primero;

        do {
            if (actual.getDato().getId() == id) {
                return actual.getDato();
            }
            actual = actual.getNext();
        } while (actual != primero);

        return null;
    }

    public Entidad remove(int id) {
        Nodo<Entidad> actual = primero;

        if (actual.getDato().getId() == id) {
            primero = actual.getNext();
            primero.setPrev(ultimo);
            ultimo.setNext(primero);
            size--;

            if (actual == actual.getNext()) primero = null;

            return actual.getDato();
        } else {
            do {
                if (actual.getDato().getId() == id) {
                    if (actual == ultimo) {
                        ultimo = actual.getPrev();
                        primero.setPrev(ultimo);
                        ultimo.setNext(primero);
                    } else {
                        actual.getPrev().setNext(actual.getNext());
                        actual.getNext().setPrev(actual.getPrev());
                    }

                    size--;
                    return actual.getDato();
                }
                actual = actual.getNext();
            } while (actual != primero);
        }
        return null;
    }

    public void show() {
        Nodo<Entidad> actual = primero;

        if (actual == null) {
            System.out.println("Lista vacia");
        } else {
            do {
                System.out.println(actual.getPrev().getDato().getId() + "<-" + actual.getDato().getId() + "->" + actual.getNext().getDato().getId());
                actual = actual.getNext();
            } while (actual != primero);

        }
    }

    public void sort() {
        Nodo<Entidad> actual;
        Nodo<Entidad> next;
        Entidad temp;
        
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                actual = primero;
                next = actual.getNext();
                for (int j = 0; j < (size - 1); j++) {
                    if (actual.getDato().getId() > next.getDato().getId()) {
                        temp = actual.getDato();
                        actual.setDato(next.getDato());
                        next.setDato(temp);
                    }
                    actual = next;
                    next = next.getNext();
                }
            }
            System.out.println("Lista ordenada");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public Nodo<Entidad> getPrimero() {
        return primero;
    }*/
}
