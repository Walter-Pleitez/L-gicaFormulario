package outlook.walter.abstracta.form.elementos;

public class InputForm extends ElementoForm{
    private String tipo = "text";

    //CONSTRUCTOR
    public InputForm(String nombre) {
        super(nombre);
    }
    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    //METODOS
    @Override
    public String dibujarHTML() {
        return "<input type=\"" + this.tipo
                + "\" name=\"" + this.nombre
                + "\" value=\"" + this.valor
                + "\">";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
