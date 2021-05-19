package courseallocationsystem.comparator;

import courseallocationsystem.model.Entidad;
import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @param <I>
 * @date 19/05/2021
 * @time 00:44:21
 * @author asael
 */
public class IdentifierComparator<I> implements Comparator<I> {

    private final Collator collator = Collator.getInstance(); 

    public IdentifierComparator() {
        collator.setStrength(Collator.TERTIARY);
    }
    
    @Override
    public int compare(I i, I i2) {
        
        if (i instanceof Integer entero && i2 instanceof Integer entero2) {
            return Integer.compare(entero, entero2);
        } else if (i instanceof String string && i2 instanceof String string2) {
            return collator.compare(string, string2);
        }
        return 0;
    }
    
    public int compare(Entidad<I> entidad, I id) {
        return compare(entidad.getId(), id);
    }
    
    public int compare(Entidad<I> e1, Entidad<I> e2) {
        return compare(e1.getId(), e2.getId());
    }

}