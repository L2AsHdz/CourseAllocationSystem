package courseallocationsystem.model;

import courseallocationsystem.edd.list.List;

/**
 *
 * @date 29/04/2021
 * @time 04:43:39
 * @author asael
 */
public class Edificio extends Entidad<String>{
    
    private List<Salon, Integer> salones;


    public Edificio() {
        salones = new List();
    }

    public Edificio(String nombre) {
        super(nombre);
        salones = new List();
    }

    public List<Salon, Integer> getSalones() {
        return salones;
    }

    public void setSalones(List<Salon, Integer> salones) {
        this.salones = salones;
    }

    @Override
    public String[] toArray() {
        return new String[]{super.getId()};
    }
}
