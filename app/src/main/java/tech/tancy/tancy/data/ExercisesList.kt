package tech.tancy.tancy.data

import android.icu.util.Calendar

class ExercisesList {
    companion object{
        fun calcularReajuste(salario: Double, reajuste: Double): Double {
            return (salario * reajuste / 100)
        }

        fun calcularVolume(largura: Double, comprimento: Double, altura: Double): Double {
            return largura * comprimento * altura
        }

        // Retorna um inteiro com a idade
        fun calcularIdade(anoNascimento: Int): String {
            val anoAtual = Calendar.getInstance().get(Calendar.YEAR)

            // verifica se o ano é maior que o atual e maior que 1900
            if (anoNascimento >= anoAtual || anoNascimento < 1900) {
                return "Ano inválido, digite um ano entre 1900 e $anoAtual"
            } else{
                return "Você tem ${anoAtual - anoNascimento} anos."
            }

        }

        fun calcularConsumoPorLitro(distancia: Double, combustivel: Double): Double {
            return distancia / combustivel
        }

        fun calcularMediaFinal(nota1: Double, nota2: Double, nota3: Double, nota4: Double): String {
            // Não permitir notas negativas, ou acima de 10 em cada bimestre.

            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10 || nota4 < 0 || nota4 > 10) {
                return "Digite notas válidas"
            } else {
                val media = (nota1 + nota2 + nota3 + nota4) / 4
                return "A média final é $media"
            }

        }

        fun converterCelsiusParaFahrenheit(celsius: Double): Double {
            return (celsius * 9 / 5) + 32
        }

        /*
        * 7. Calcular e apresentar o volume de uma lata de óleo cilíndrica, a partir da leitura do raio da base e da altura. A fórmula: pi * raio² * altura.
        * */

        fun calcularVolumeLata(raio: Double, altura: Double): Double {
            return Math.PI * Math.pow(raio, 2.0) * altura
        }
    }
}