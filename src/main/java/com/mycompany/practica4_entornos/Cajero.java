/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4_entornos;



import java.util.ArrayList;





/**
 *
 * @author loren
 */
public class Cajero {

    String nombre;
    int contador;
    double total;
    ArrayList<Producto> productos;

    public Cajero(String nombre) {
        this.nombre = nombre;
        this.contador = 0;
        this.total = 0;
        this.productos = new ArrayList<>();
    }

    public void ANADIRPRODUCTO(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProDUCTO(Producto producto) {
        productos.remove(producto);
    }

    public void cobrar() {
        double subtotal = calcularSubtotal();
        double iva = subtotal * 0.21;
        double total = subtotal + iva;

        imprimirTicket(subtotal, iva, total);

        registrarVenta(total);
    }

    private void registrarVenta(double total1) {
        contador = contador + 1;
        total1 = total1 + total1;
        productos.clear();
    }

    private void imprimirTicket(double subtotal, double iva, double total1) {
        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + nombre);
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subtotal) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", total1) + " EUR");
        System.out.println("==================");
    }

    private double calcularSubtotal() {
        double subtotal = 0;
        for (Producto p : productos) {
            subtotal = subtotal + p.calcularImporte();
        }
        return subtotal;
    }

    public void cierreCaja() {
        double ivaRecaudado = total - (total / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + nombre);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + contador);
        System.out.println("Total facturado:  " + String.format("%.2f", total) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRecaudado) + " EUR");
        System.out.println("==========================");
    }

    public boolean ticketVacio() {
        return productos.isEmpty();
    }

    public int getTicketsEmitidos() {
        return contador;
    }

    public double getTotalDia() {
        return total;
    }
}
