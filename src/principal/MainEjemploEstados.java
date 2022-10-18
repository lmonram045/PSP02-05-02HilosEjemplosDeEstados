package principal;

import hilos.HiloAuxiliar;


public class MainEjemploEstados {

    private static void imprimirEstado(HiloAuxiliar hilo1) {
        System.out.println("Hilo Auxiliar Nuevo: Estado = " + hilo1.getState() + ", Vivo?? isAlive() = " + hilo1.isAlive());
    }

    public static void main(String[] args) {
        // Creamos un nuevo hilo (estaria en estado NEW)
        HiloAuxiliar hilo1 = new HiloAuxiliar();
        // Obtenemos el estado del hilo, y si está vivo o no
        imprimirEstado(hilo1);
        // Iniciamos el hilo1 y pasaria al estado ejecutable
        hilo1.start();
        // Comprobamos que se ha pasado a ejecutable
        imprimirEstado(hilo1);
        // Esperamos a que el hilo1 muera
        try {
            hilo1.join(); // El meetodo join espera a que muera el hilo
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        // Volvemos a comprobar que se ha cambiado el estado
        imprimirEstado(hilo1);
    }
}