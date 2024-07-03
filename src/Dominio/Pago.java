/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 *
 * @author Jhampool
 */
public class Pago {
    private int idPago;
    private LocalDate fechaPago;
    private double monto;
    private String estado;

    public Pago(LocalDate fechaPago, String estado, double monto) {
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.monto = monto;
    }

    public Pago(int idPago) {
        this.idPago = idPago;
    }

    public Pago() {
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   


   
//    public double PagoxHorasExtras(int horasTrabajadas){
//        double PagoxHoras=4.27;
//        int horasextras= horasTrabajadas-8;
//        double PagoxHorasExtras=0;
//        if(PagoxHorasExtras!=0){
//            PagoxHorasExtras= horasextras*PagoxHoras;
//        }else{
//            PagoxHoras= 0;            
//        }
//        return PagoxHoras;
//    }
//    
//    
//    public  double calcularSueldo() {
//        double sueldo = 0;
//        double salarioxHora= 0;
//        int horasDiariasTrabajadas=8;
//        double horasNotrabajadas = 8 - horasDiariasTrabajadas;
//        if(horasDiariasTrabajadas==8){
//            sueldo = 1025;
//        }else{
//            sueldo= 1025 -(horasNotrabajadas);
//        }
//        return sueldo+PagoxHorasExtras(horasDiariasTrabajadas);
//    }
    
   
//    public static double CalcularPagoxHorasExtras(double salarioHora, int horasTrabajadas){
//    // Calculamos el pago por horas extras (suponemos que se pagan al mismo precio que las horas normales)          
//        return  salarioHora * horasTrabajadas;
//    }
//    public static double CAlcularDescuentoxTardanza(double salarioHora,int tardanzasTotales){
//        // Calculamos el descuento por tardanzas (suponiendo un descuento por minuto)
//        double salarioPorMinuto = salarioHora / 60.0;  // Suponiendo salario por hora dividido entre 60 minutos        
//        return  salarioPorMinuto * tardanzasTotales;
//    }
//    public static double calcularSueldoBase(double salarioHora, int horasTrabajadas){
//        // Calculamos el sueldo base
//        return salarioHora * horasTrabajadas; 
//    }
//    public static double CalcularSalarioPorDia(){
//        // Calculamos el salario por día para el descuento por ausencias
//        return  calcularSueldoBase(0, 0) / diasTrabajadosEnMes;
//    }
//    
//    
//    
//    // Método para calcular el sueldo de un empleado
//    public static void calcularSueldoEmpleado(double salarioHora, int horasTrabajadas,
//                                              int horasContratadasAlMes, int tardanzasTotales,
//                                              int ausencias, double adelantoSueldo, int horasExtrasTrabajadas) {
//        // Obtenemos el mes actual y calculamos la cantidad de días trabajados
//        LocalDate fechaActual = LocalDate.now();
//        YearMonth mesActual = YearMonth.from(fechaActual);
//
//        int diasTrabajadosEnMes = mesActual.lengthOfMonth(); // Cantidad de días en el mes actual
////
//           
//               
//        // Calculamos el salario por día para el descuento por ausencias
//        double salarioPorDia = sueldoBase / diasTrabajadosEnMes;
//
//        // Calculamos el descuento por ausencias
//        double descuentoPorAusencias = salarioPorDia * ausencias;
//
//        // Calculamos el total de ingresos sumando sueldo base y pagos extras
//        double totalIngresos = sueldoBase + pagoxHorasExtras(salarioHora, horasTrabajadas);
//
//        // Calculamos el total de descuentos sumando descuentos por tardanzas, ausencias y adelanto de sueldo
//        double totalDescuentos = descuentoxTardanza(salarioHora, tardanzasTotales) + descuentoPorAusencias + adelantoSueldo;
//
//        // Calculamos el pago total restando total de descuentos a total de ingresos
//        double pagoTotal = totalIngresos - totalDescuentos;
//
//        // Imprimimos los resultados
//        System.out.println("Sueldo Base: " + sueldoBase);
//        System.out.println("Pago por Horas Extra: " + pagoHorasExtra);
//        System.out.println("Descuento por Tardanzas: " + descuentoPorTardanza);
//        System.out.println("Descuento por Ausencias: " + descuentoPorAusencias);
//        System.out.println("Total de Ingresos: " + totalIngresos);
//        System.out.println("Total de Descuentos: " + totalDescuentos);
//        System.out.println("Pago Total: " + pagoTotal);
//    }
//public static double calcularSueldoBase(double salarioHora, int horasTrabajadas) {
//    return salarioHora * horasTrabajadas;
//}
//
//public static double calcularPagoHorasExtras(double salarioHora, int horasExtrasTrabajadas) {
//    return salarioHora * horasExtrasTrabajadas;
//}
//
//public static double calcularDescuentoPorTardanzas(double salarioHora, int tardanzasTotales) {
//    double salarioPorMinuto = salarioHora / 60.0;
//    return salarioPorMinuto * tardanzasTotales;
//}
//
//public static double calcularDescuentoPorAusencias(double sueldoBase, int diasTrabajadosEnMes, int ausencias) {
//    double salarioPorDia = sueldoBase / diasTrabajadosEnMes;
//    return salarioPorDia * ausencias;
//}
//
//public static double calcularTotalIngresos(double sueldoBase, double pagoHorasExtra) {
//    return sueldoBase + pagoHorasExtra;
//}
//
//public static double calcularTotalDescuentos(double descuentoPorTardanzas, double descuentoPorAusencias, double adelantoSueldo) {
//    return descuentoPorTardanzas + descuentoPorAusencias + adelantoSueldo;
//}
}
