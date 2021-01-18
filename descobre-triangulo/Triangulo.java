public class Triangulo
{
    double lado1, lado2, lado3;
    
    public Triangulo(){
    }

    public void setLado1(double lado1){
        this.lado1 = lado1;
    }

    public double getLado1(){
        return lado1;
    }

    public void setLado2(double lado2){
        this.lado2 = lado2;
    }

    public double getLado2(){
        return lado2;
    }

    public void setLado3(double lado3){
        this.lado3 = lado3;
    }

    public double getLado3(){
        return lado3;
    }

    public void verificaTriangulo(){

        if (lado1 == 0 || lado2 == 0 || lado3 == 0){
            System.out.println("Valor não permitido. Foi informado um valor 0.");
        }
        else if(lado1> lado2+lado3 || lado2> lado1+lado3 || lado3> lado1+lado2){
            System.out.println("Valor não permitido. Um lado não pode ser maior do que a soma dos outros dois.");
        }

        else if (lado1 == lado2 && lado1 == lado2 && lado2 == lado3){
            System.out.println("Triângulo Equilátero( possui 3 lados iguais).");
        }

        else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3){
            System.out.println("Triângulo Isóceles( possui 2 lados iguais).");
        }

        else{
            System.out.println("Triângulo Escaleno( possui 3 lados diferentes).");
        }
    }

}

