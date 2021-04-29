package courseallocationsystem.edd.list;

import courseallocationsystem.edd.Nodo;
import courseallocationsystem.model.Objeto;

/**
 *
 * 
 * @date 5/04/2021
 * @time 11:38:47
 * @author asael
 */
public class CircularList {

    private Nodo<Objeto> primero;
    private Nodo<Objeto> ultimo;
    private int size;

    public CircularList() {
        this.size = 0;
    }

    public void add(Objeto i) {
        Nodo<Objeto> nuevo = new Nodo(i);

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
    
    public Objeto get(int id) {
        Nodo<Objeto> actual = primero;

        do {
            if (actual.getDato().getId() == id) {
                return actual.getDato();
            }
            actual = actual.getNext();
        } while (actual != primero);

        return null;
    }

    public Objeto remove(int id) {
        Nodo<Objeto> actual = primero;

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
        Nodo<Objeto> actual = primero;

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
        Nodo<Objeto> actual;
        Nodo<Objeto> next;
        Objeto temp;
        
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

    public Nodo<Objeto> getPrimero() {
        return primero;
    }
}
