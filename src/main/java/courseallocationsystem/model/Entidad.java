package courseallocationsystem.model;

/**
 *
 * @param <I>
 * @date 29/04/2021
 * @time 04:12:33
 * @author asael
 */
public abstract class Entidad<I> {

    private I id;

    public Entidad(I id) {
        this.id = id;
    }

    public Entidad() {
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
    
    public abstract String[] toArray();
}
