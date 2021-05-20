package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:43:39
 * @author asael
 */
public class Edificio extends Entidad<String>{


    public Edificio() {
    }

    public Edificio(String nombre) {
        super(nombre);
    }

    @Override
    public String[] toArray() {
        return new String[]{super.getId()};
    }
}
