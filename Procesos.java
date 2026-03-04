package Clases;
public class Procesos {

public double calcularPromedio(double n1,double n2,double n3) {
System.out.println("Estamos en Procesos");
double prom=-1;
if(validar(n1,n2,n3)==true) {
prom=(n1+n2+n3)/3;
}
return prom;
}
public boolean validar(double n1,double n2,double n3) {
if (n1>=0 && n1<=5 && n2>=0 && n2<=5 && n3>=0 && n3<=5) {
return true;
}
return false;
}
}