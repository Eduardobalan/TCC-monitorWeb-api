package br.com.webmonitor.enumeration;

/**
 * Created by Eduardo Balan on 13/09/2017.
 */
public enum EnumSexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String sexo;

    private EnumSexo(String sexo) {
        this.sexo = sexo;
    }

    public String toString() {
        return this.sexo;
    }


}
