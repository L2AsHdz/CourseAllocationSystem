package courseallocationsystem.edd.table;

import courseallocationsystem.comparator.IdentifierComparator;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 19/05/2021
 * @time 21:02:52
 * @author asael
 */
public class HashTable<T extends Entidad, I> {

    private final IdentifierComparator<I> comparator;
    private final float maxLoadFactor;
    private int numDatos;
    private Object[] datos;

    public HashTable(int initSize, float maxLoadFactor) {
        this.maxLoadFactor = maxLoadFactor;
        comparator = new IdentifierComparator();
        numDatos = 0;
        datos = new Object[initSize];
    }
    
    public void add(T t) {
        int index = generateIndex((I)t.getId(), 0);
        add(t, index, 0);
    }
    
    private void add(T t, int index, int increase) {
        
        if (datos[index] == null) {
            datos[index] = t;
            numDatos++;
            verifyLoadFactor();
        } else {
            increase++;
            index = generateIndex((I)t.getId(), increase);
            add(t, index, increase);
        }
    }
    
    public T get(I id) {
        Integer index = get(id, generateIndex(id, 0), 0);
        
        if (index == null) {
            return null;
        } else {
            return (T) datos[index];
        }
    }
    
    public T remove(I id) {
        Integer index = get(id, generateIndex(id, 0), 0);
        
        if (index == null) {
            return null;
        } else {
            T temp = (T) datos[index];
            datos[index] = null;
            numDatos--;
            return temp;
        }
    }
    
    public void print() {
        for (int i = 0; i < datos.length; i++) {
            T dato = (T) datos[i];
            if (dato != null) {
                System.out.println("[" + i + "][" + dato.getId() + "]");
            } else {
                System.out.println("[" + i + "][----------]");
            }
        }
    }
    
    private Integer get(I id, int index, int increase) {
        
        if (datos[index] == null) {
            return null;
        }else if (comparator.compare((T)datos[index], id) == 0) {
            return index;
        } else {
            increase++;
            index = generateIndex(id, increase);
            return get(id, index, increase);
        }
    }

    private int generateIndex(I id, int i) {
        if (id instanceof Integer idI) {
            return Math.abs((idI + i) % datos.length);
        }else if (id instanceof String idS) {
            return Math.abs((idS.hashCode() + i) % datos.length);
        }
        return -1;
    }

    private void verifyLoadFactor() {
        float factor = (float) numDatos / datos.length;
        if (factor >= maxLoadFactor) {
            HashTable<T,I> newHashTable = new HashTable(datos.length + 15, maxLoadFactor);
            
            for (Object d : datos) {
                if (d != null) {
                    newHashTable.add((T)d);
                }
            }
            datos = newHashTable.datos;
        }
    }
}