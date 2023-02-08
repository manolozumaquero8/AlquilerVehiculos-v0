package org.iesalandalus.programacion.alquilervehiculos;

import java.util.regex.Pattern;

public class Turismo {
    private static final Pattern MARCA_PATTERN = Pattern.compile("(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)");
    private static final Pattern MODELO_PATTERN = Pattern.compile(".+");
    private static final Pattern CILINDRADA_PATTERN = Pattern.compile("[1-4][0-9]{3}");
    private static final Pattern MATRICULA_PATTERN = Pattern.compile("[0-9]{4}[A-Z]{3}");
    
    private String marca;
    private String modelo;
    private String cilindrada;
    private String matricula;
    
    public Turismo(String marca, String modelo, String cilindrada, String matricula) {
        setMarca(marca);
        setModelo(modelo);
        setCilindrada(cilindrada);
        setMatricula(matricula);
    }
    
    public Turismo(Turismo turismo) {
        this(turismo.getMarca(), turismo.getModelo(), turismo.getCilindrada(), turismo.getMatricula());
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        if (!MARCA_PATTERN.matcher(marca).matches()) {
            throw new IllegalArgumentException("Marca no válida");
        }
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        if (!MODELO_PATTERN.matcher(modelo).matches()) {
            throw new IllegalArgumentException("Modelo no válido");
        }
        this.modelo = modelo;
    }
    
    public String getCilindrada() {
        return cilindrada;
    }
    
    public void setCilindrada(String cilindrada) {
        if (!CILINDRADA_PATTERN.matcher(cilindrada).matches()) {
            throw new IllegalArgumentException("Cilindrada no válida");
        }
        this.cilindrada = cilindrada;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        if (!MATRICULA_PATTERN.matcher(matricula).matches()) {
            throw new IllegalArgumentException("Matrícula no válida");
        }
        this.matricula = matricula;
    }
    
    public static Turismo getTurismo(String matricula) {
        if (!MATRICULA_PATTERN.matcher(matricula).matches()) {
        	throw new IllegalArgumentException("Matrícula no válida");
        }
        return new Turismo("", "", "", matricula);
        }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turismo turismo = (Turismo) o;
        return matricula.equals(turismo.matricula);
        }

        @Override
        public int hashCode() {
        return matricula.hashCode();
        }

        @Override
        public String toString() {
        return String.format("Turismo{marca='%s', modelo='%s', cilindrada='%s', matricula='%s'}",
        marca, modelo, cilindrada, matricula);
        }
        }
        