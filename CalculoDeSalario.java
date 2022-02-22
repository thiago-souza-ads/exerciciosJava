import java.util.Scanner;

class CalculoDeSalario {
    /**
     * Programa criado com o intuito de calcular o salario de um vendedor de veiculos
     *
     * @return void apenas apresenta Informações textuais sobre o valor do salario do vendedor
     * @throws IllegalArgumentException, {@link NumberFormatException}
     * @Author Thiago Rodrigues de Souza
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            //Leitura das informaçoes do cliente:
            System.out.print("Digite a quantidade de vendas de veiculos realizadas pelo funcionario =>:");
            Integer numeroDeCarrosVendidos = entrada.nextInt();
            System.out.print("Digite o valor total das vendas realizadas pelo funcionario =>R$:");
            Double valorTotalVendas = entrada.nextDouble();
            System.out.print("Digite o valor do salario fixo do funcionario =>R$:");
            Double valorSalarioFixo = entrada.nextDouble();
            System.out.print("Digite o valor pago ao funcionario por carro vendido =>R$:");
            Double comissaoPorCarro = entrada.nextDouble();

            Double salario = calcularSalario(numeroDeCarrosVendidos, valorTotalVendas, valorSalarioFixo, comissaoPorCarro);
            // retorne o salario (salarioFixo+comissaoDeCadaCarro+5%da venda por ele efetuada+ )
            System.out.print("O salario final do vendedor será de R$:" + salario);

        } catch(IllegalArgumentException e) {
            new NumberFormatException("Formato de numero invalido.");
            new IllegalArgumentException("Campo numérico, texto incorreto.");
        } finally {
            entrada.close();
        }
    }

    /**
     * Método que retorna o valor de um funcionario de acordo com as regras estipuladas!
     *
     * @param "numeroDeCarrosVendidos" Integer
     * @param "valorTotalVendas" Double
     * @param "valorSalarioFixo" Double
     * @param "comissaoPorCarro" Double
     * @return "salario do funcionario calculado" Double
     */

    private static Double calcularSalario(Integer numeroDeCarrosVendidos, Double valorTotalVendas, Double valorSalarioFixo, Double comissaoPorCarro) {
        // No momento a comissão é 5% do valor vendido por ele
        int porcentagem = 5;
        Double salarioFinal = valorSalarioFixo + (comissaoPorCarro * numeroDeCarrosVendidos) + ((valorTotalVendas / 100) * porcentagem);
        return salarioFinal;
    }
}
