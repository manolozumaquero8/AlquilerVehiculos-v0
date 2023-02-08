package org.iesalandalus.programacion.alquilervehiculos;

public class Cliente {
    private static final String ER_NOMBRE = "^[A-Z][a-z]+(([ ][A-Z][a-z]+)*)$";
    private static final String ER_DNI = "^[0-9]{8}[A-Z]$";
    private static final String ER_TELEFONO = "^[6-9][0-9]{8}$";

    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(String nombre, String dni, String telefono) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
    }

    public Cliente(Cliente cliente) {
        this(cliente.nombre, cliente.dni, cliente.telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.matches(ER_NOMBRE)) {
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!dni.matches(ER_DNI) || !comprobarLetraDni(dni)) {
            throw new IllegalArgumentException("El DNI es incorrecto");
        }
        this.dni = dni;
    }

    public boolean comprobarLetraDni(String dni) {
        int numDni = Integer.parseInt(dni.substring(0, 8));
        char letraDni = dni.charAt(8);
        return letraDni == "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numDni % 23);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("El teléfono es incorrecto");
        }
        this.telefono = telefono;
    }

    public static Cliente getClienteConDni(String dni) {
		return null;
        // aquí debería implementarse una búsqueda en una base de datos o en una lista de clientes previamente cargada
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

 @Override
 public String toString() {
    return "Cliente [nombre=" + ER_NOMBRE + ", dni=" + ER_DNI + ", telefono=" + ER_TELEFONO + "]";
}
}
