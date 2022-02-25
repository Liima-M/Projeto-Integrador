package com.example.appdereservas.entities;

import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.DATE)
    private Date hora;

    @Transient
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm");
    @Transient
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");


    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private Carrinho carrinho;

    public Reserva() {
    }

    public Reserva(String data, String hora) {
        setData(data);
        setHora(hora);
    }

    public String getData(){
        return DATE_FORMAT.format(data);
    }

    public void setData(String data){
        try {
            this.data = DATE_FORMAT.parse(data);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public String getHora(){
        return TIME_FORMAT.format(hora);
    }

    public void setHora(String hora){
        try {
            this.hora = TIME_FORMAT.parse(hora);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

}
