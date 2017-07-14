package com.efisys.quienmepresta.data;

import com.efisys.quienmepresta.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListCredito implements Serializable {


    public static List<ListCredito> getListCreditos() {

        return new ArrayList<ListCredito>() {
            {
                add(new ListCredito(R.drawable.banco1,"Banco Palmas", "56.00%", "Sin Avales y sin Garantias", "Depositamos a tu Banco", "Oficinas en tu Ciudad"));
                add(new ListCredito(R.drawable.banco2,"Simple Bank", "67.00%", "Con Aval y sin Garantias", "No Depositamos a tu Banco", "Oficinas en tu Ciudad"));
                add(new ListCredito(R.drawable.banco3,"NU Bank", "70.00%","Con Aval y Garantia","Depositamos a tu Banco","Oficinas en tu Ciudad"));
                add(new ListCredito(R.drawable.banco4,"Banco Justo", "75.00%","Sin Avales y con Garantia","Depositamos a tu Banco","Oficinas en tu Ciudad"));
                add(new ListCredito(R.drawable.banco5,"Moven", "83.00%","Sin Avales y sin Garantias","No depositamos a tu Banco","Oficanas en tu Ciudad"));

            }};
    }
    private String gestorID;
    private int imagen;
    private String nombreBanco;
    private String cat;
    private String avalesGarantias;
    private String deposito;
    private String OficinaCiudad;

    public ListCredito(int imagen, String nombreBanco, String cat, String avalesGarantias, String deposito, String oficinaCiudad) {
        this.imagen = imagen;
        this.nombreBanco = nombreBanco;
        this.cat = cat;
        this.avalesGarantias = avalesGarantias;
        this.deposito = deposito;
        this.OficinaCiudad = oficinaCiudad;

    }

    public String getGestorID() {
        return gestorID;
    }

    public void setGestorID(String gestorID) {
        this.gestorID = gestorID;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
    public String getAvalesGarantias() {
        return avalesGarantias;
    }

    public void setAvalesGarantias(String avalesGarantias) {
        this.avalesGarantias = avalesGarantias;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public String getOficinaCiudad() {
        return OficinaCiudad;
    }

    public void setOficinaCiudad(String oficinaCiudad) {
        OficinaCiudad = oficinaCiudad;
    }

}
