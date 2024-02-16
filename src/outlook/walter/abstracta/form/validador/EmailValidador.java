package outlook.walter.abstracta.form.validador;

public class EmailValidador extends Validador{
    protected String mensaje = "El formato del email es invalido";
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAIL_REGEX);  //Lo más recomendable es usar Expresiones Regulares
    }
}
