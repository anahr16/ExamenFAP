/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.model;

public class Ejecutivo {
    private String rutEjecutivo;
    private String nombre;
    private String departamento;
    private String contrasena; 

    public Ejecutivo() {
    }

    public Ejecutivo(String rutEjecutivo, String nombre, String departamento, String contrasena) {
        this.rutEjecutivo = rutEjecutivo;
        this.nombre = nombre;
        this.departamento = departamento;
        this.contrasena = contrasena;
    }

    public String getRutEjecutivo() {
        return rutEjecutivo;
    }

    public void setRutEjecutivo(String rutEjecutivo) {
        this.rutEjecutivo = rutEjecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
