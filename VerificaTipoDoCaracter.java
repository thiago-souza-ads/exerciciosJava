import java.util.Scanner;

class VerificaTipoDoCaracter {
    /**
     * Programa criado com o intuito de analisar um caracter informado pelo User
     *
     * @return void apenas apresenta Informações ao usuario sobre o caractere
     * @throws IllegalArgumentException
     * @Author Thiago Rodrigues de Souza
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Digite um caractere:");
            Character caracterDigitado = entrada.next().charAt(0);
            System.out.println("Voce digitou " + verificaTipo(caracterDigitado));
        } catch (IllegalArgumentException exception) {
            System.err.println("Caractere informado inválido!");
        } finally {
            entrada.close();
        }
    }

    /**
     * Método que avalia o Character informado pelo usuario e devolve informações visuais!
     *
     * @param "caracterDigitado" Character
     * @return "informaçoes de resultado" String
     * @throws "caso seja um caracter ilegal" IllegalArgumentException
     */
    private static String verificaTipo(Character caracterDigitado) {
        // Inicialmente verifico se o caracter informado possui validade, verificando apenas se valido
        if (caracterDigitado.toString().isBlank() || caracterDigitado.toString().isEmpty() || caracterDigitado == null) {
            throw new IllegalArgumentException();
        } else {
            //Match com numeros
            if (caracterDigitado.toString().matches("^[0-9]")) {
                return "um numero, o numero " + caracterDigitado + ". Obrigado";
            }
            // Match com letras
            else if (caracterDigitado.toString().toUpperCase().matches("[A-Z]*")) {
                String vogais = "AEIOU";
                // Se vogal
                if (vogais.contains(caracterDigitado.toString().toUpperCase())) {
                    return "uma letra, a letra " + caracterDigitado + ", uma vogal. Obrigado";
                }
                // Se consoante
                return "uma letra, a letra " + caracterDigitado + ", uma consoante. Obrigado";
            }
            // Default Match com digito
            return "um digito, o digito " + caracterDigitado + ". Obrigado";
        }
    }
}
