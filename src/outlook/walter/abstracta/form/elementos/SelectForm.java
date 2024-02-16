package outlook.walter.abstracta.form.elementos;

import java.util.ArrayList;
import java.util.List;
import outlook.walter.abstracta.form.elementos.select.Opcion;

public class SelectForm extends ElementoForm{
    private List<Opcion> opciones;

    //CONSTRUCTOR
    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<Opcion>();
    }
    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    //METODOS
    //El metodo addOpçion() es del tipo de la clase a la que pertenece, por es returna this.
    public SelectForm addOpcion(Opcion opcion){
        this.opciones.add(opcion);
        return this;
    }
    @Override
    public String dibujarHTML() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name = '")
                .append(this.nombre)
                .append("'>");

        for(Opcion opcion: this.opciones){
            sb.append("\n<opcion value='")
                    .append(opcion.getValor())
                    .append("'");
            if(opcion.isSelected()){
                sb.append(" selected");
                this.valor = opcion.getValor();
            }
            sb.append(">")
                    .append(opcion.getNombre())
                    .append("</opcion>");
        }
        sb.append("</select>");
        return sb.toString();
    }

}
