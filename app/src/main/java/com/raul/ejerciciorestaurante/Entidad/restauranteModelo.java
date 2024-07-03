package com.raul.ejerciciorestaurante.Entidad;

public class restauranteModelo {

    private int Foto;
    private String Titulo;
    private String Direccion;
    private String Telefono;
    private String Comentario;

    public restauranteModelo() {

    }

    public restauranteModelo(int foto, String titulo, String direccion, String telefono, String comentario) {
        Foto = foto;
        Titulo = titulo;
        Direccion = direccion;
        Telefono = telefono;
        Comentario = comentario;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
