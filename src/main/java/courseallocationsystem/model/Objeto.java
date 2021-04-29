package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:12:33
 * @author asael
 */
public abstract class Objeto {

    private int id;

    public Objeto(int id) {
        this.id = id;
    }

    public Objeto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
