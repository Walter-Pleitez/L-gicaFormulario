package outlook.walter.abstracta.form;

import outlook.walter.abstracta.form.elementos.ElementoForm;
import outlook.walter.abstracta.form.elementos.InputForm;
import outlook.walter.abstracta.form.elementos.SelectForm;
import outlook.walter.abstracta.form.elementos.TextAreaForm;
import outlook.walter.abstracta.form.elementos.select.Opcion;
import outlook.walter.abstracta.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class MainForm {
    public static void main(String[] args) {

        InputForm userName = new InputForm("username");
        userName.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                 .addValidador(new LargoValidador(6,12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        //Se agregan las opciones (se usan dos formas)
        Opcion java = new Opcion("1", "java"); //SelectForm lleva dentro de si la clase Opcion
        lenguaje.addOpcion(java)
        .addOpcion(new Opcion("2", "python"))
        .addOpcion(new Opcion("3", "JavaScript"))
        .addOpcion(new Opcion("4", "TypeScript"))
        .addOpcion(new Opcion("5", "Go"));

        //AGREGAR VALORES AL FORMULARIO
        userName.setValor("Walter");
        password.setValor("12345");
        email.setValor("walter53torrez@outlook.com");
        edad.setValor("28");
        experiencia.setValor("...mas de 10 years de experiencia");
        java.setSelected(true);

        List<ElementoForm> elementos= Arrays.asList(userName,
                password,
                email,
                edad,
                experiencia,
                lenguaje);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHTML());
            System.out.println("<br>");
        }
        elementos.forEach(elem -> {
            if(!elem.esValido()){
                elem.getErrores().forEach(System.out::println);
            }
        });
    }
}
