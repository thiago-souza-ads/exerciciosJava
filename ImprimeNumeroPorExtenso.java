import java.util.Scanner;

class ImprimeNumeroPorExtenso {
    /**
     * Programa criado com o intuito de ler uma entrada do usuario entre 0 e 100 e escrever o valor por extenso
     *
     * @return void apenas apresenta Informações textuais sobre o valor digitado
     * @throws IllegalArgumentException
     * @Author Thiago Rodrigues de Souza
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Digite um numero entre zero [0] e cem [100]:");
            int numero = entrada.nextInt();
            if (numero >= 0 && numero <= 100) {
                String numeroPorExtenso = retornaStringDoNumero(numero);
                System.out.println("Voce digitou:" + numero);
                System.out.println("O numero por extenso é : " + numeroPorExtenso);
            } else {
                System.out.println("Voce digitou um numero fora dos limites definido!");
            }
        } catch (IllegalArgumentException exception) {
            System.err.println("Palavra ou expressão inválida!");
        } finally {
            entrada.close();
        }
    }

    /**
     * Método que retorna um numero por extenso entre zero e cem!
     *
     * @param "numero entre 0 - 100" Integer
     * @return "informaçoes de resultado" String
     */
    private static String retornaStringDoNumero(int numero) {
        StringBuilder sb = new StringBuilder();

        String[] unidades = {"Zero", "Um", "Dois", "Tres", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove"};
        String[] dezenas = {"Zero", "Dez", "Vinte", "Trinta", "Quarenta", "Cinquenta", "Sessenta", "Setenta", "Oitenta", "Noventa", "Cem"};
        String[] numerosEspeciais = {"Onze", "Doze", "Treze", "Quatorze", "Quinze", "Dezesseis", "Dezessete", "Dezoito", "Dezenove"};

        int dezena = (int) (numero / 10);
        int unidade = numero % 10;
        // Caso seja um numero unico entre 11 e 19
        if (numero > 10 && numero < 20) {
            sb.append(numerosEspeciais[numero - 11]);
        }
        // Caso seja outro numero o algoritimo abaixo se aplica
        else {
            if (dezena >= 1) {
                sb.append(dezenas[dezena]);
            }

            if (unidade != 0) {
                sb.append(dezena < 1 ? unidades[unidade] : " e " + unidades[unidade]);
            }

            if (dezena == 0 && unidade == 0) {
                sb.append(unidades[unidade]);
            }
        }
        return sb.toString();
    }
}
