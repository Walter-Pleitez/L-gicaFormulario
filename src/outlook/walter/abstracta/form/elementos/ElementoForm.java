package outlook.walter.abstracta.form.elementos;
import outlook.walter.abstracta.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {
    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    //CONSTRUCTOR
    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }
    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    //METODOS
    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public boolean esValido(){
        for(Validador v: validadores){
            if(!v.esValido(this.valor)){
                this.errores.add(v.getMensaje());
            }
        }
        return this.errores.isEmpty();
    }

    public List<String> getErrores() {
        return errores;
    }

    abstract public String dibujarHTML();
}
