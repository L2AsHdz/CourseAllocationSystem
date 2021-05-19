package courseallocationsystem.edd.list;

import courseallocationsystem.comparator.IdentifierComparator;
import courseallocationsystem.edd.Nodo;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 4/04/2021
 * @time 13:27:55
 * @author asael
 */
public class List<T extends Entidad, I> {
    
    IdentifierComparator<I> comparator;
    
    private Nodo<T> inicio;
    private int size;

    public List() {
        this.size = 0;
        comparator = new IdentifierComparator();
    }
    
    public void add(T t) {
        Nodo<T> nuevo = new Nodo(t);
        
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo<T> temp = inicio;
            
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            
            temp.setNext(nuevo);
        }
        size++;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return inicio == null;
    }
    
    public T get(I id) {
        Nodo<T>actual = inicio;
        
        while (actual != null) {
            if (comparator.compare(actual.getDato(), id) == 0) {
                return actual.getDato();
            }
            actual = actual.getNext();
        }
        
        return null;
    }
    
    public T remove(I id) {
        Nodo<T> actual = inicio;
        
        if (comparator.compare(actual.getDato(), id) == 0) {
            inicio = actual.getNext();
            size--;
            return actual.getDato();
        } else {
            Nodo<T> temp;
            while (actual.getNext() != null) {
                if (comparator.compare(actual.getNext().getDato(), id) == 0) {
                    temp = actual.getNext();
                    actual.setNext(temp.getNext());
                    size--;
                    return temp.getDato();
                }
                actual = actual.getNext();
            }
        }
        
        return null;
    }
    
    public void sort() {
        Nodo<T> actual;
        Nodo<T> next;
        T temp;
        
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                actual = inicio;
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
    
    public void show() {
        Nodo<T>actual = inicio;
        
        if (actual == null) {
            System.out.println("Lista vacia");
        } else {
            while (actual != null) {
                if (actual.getNext() != null) {
                    System.out.print((actual.getDato()).getId() + "->");
                } else {
                    System.out.print((actual.getDato()).getId());
                }
                actual = actual.getNext();
            }
        }
    }

    public Nodo<T> getInicio() {
        return inicio;
    }
}
