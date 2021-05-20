package courseallocationsystem.edd.list;

import courseallocationsystem.comparator.IdentifierComparator;
import courseallocationsystem.edd.Nodo;
import courseallocationsystem.model.Entidad;

/**
 *
 *
 * @param <T>
 * @param <I>
 * @date 5/04/2021
 * @time 11:38:47
 * @author asael
 */
public class CircularList<T extends Entidad, I> {

    IdentifierComparator<I> comparator;

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public CircularList() {
        this.size = 0;
        comparator = new IdentifierComparator();
    }

    public void add(T i) {
        Nodo<T> nuevo = new Nodo(i);

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

    public T get(I id) {
        Nodo<T> actual = primero;

        if (actual != null) {
            do {
                if (comparator.compare(actual.getDato(), id) == 0) {
                    return actual.getDato();
                }
                actual = actual.getNext();
            } while (actual != primero);
        }

        return null;
    }

    public T remove(I id) {
        Nodo<T> actual = primero;

        if (comparator.compare(actual.getDato(), id) == 0) {
            primero = actual.getNext();
            primero.setPrev(ultimo);
            ultimo.setNext(primero);
            size--;

            if (actual == actual.getNext()) {
                primero = null;
            }

            return actual.getDato();
        } else {
            do {
                if (comparator.compare(actual.getDato(), id) == 0) {
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
        Nodo<T> actual = primero;

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
        Nodo<T> actual;
        Nodo<T> next;
        T temp;

        if (size > 1) {
            for (int i = 0; i < size; i++) {
                actual = primero;
                next = actual.getNext();
                for (int j = 0; j < (size - 1); j++) {
                    if (comparator.compare(actual.getDato(), next.getDato()) > 0) {
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

    public Nodo<T> getPrimero() {
        return primero;
    }
}
