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

        fun calcularIdade(anoNascimento: Int){

            val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
            val idade = anoAtual - anoNascimento
            println("Sua idade é $idade")
        }

        fun calcularConsumoPorLitro(distancia: Double, combustivel: Double): Double {
            return distancia / combustivel
        }

        fun calcularMediaFinal(nota1: Double, nota2: Double, nota3: Double, nota4: Double): Double {
            return (nota1 + nota2 + nota3 + nota4) / 4
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