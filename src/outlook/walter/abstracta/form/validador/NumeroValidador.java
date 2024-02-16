package outlook.walter.abstracta.form.validador;

public class NumeroValidador extends Validador{
    protected String mensaje = "El campo debe ser un numero";


    @Override
    public String getMensaje() {
        return null;
    }

    @Override
    public void setMensaje(String mensaje) {

    }

    @Override
    public boolean esValido(String valor) {
        try{
            Integer.parseInt(valor);
            return true;
        }catch(NumberFormatException e){
            return false;
        }

    }
}
