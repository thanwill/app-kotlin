package tech.tancy.tancy

class Funcionario(var nome: String, var cargo: String, var horas_trabalhadas: Double, var valor_hora: Double) {


        var salario_bruto : Double
        var salario_liquido : Double
        var abono : Double
        var inss : Double
        var imposto_renda : Double
        var fgts : Double

        init {
            // bruto = horas trabalhadas * valor da hora
            salario_bruto = horas_trabalhadas * valor_hora
            abono = calcularAbono(salario_bruto)
            salario_liquido = calcularSalarioLiquido()
            inss = calcularInss(salario_bruto)
            imposto_renda = calcularImpostoRenda(salario_bruto)
            fgts = calcularFgts(salario_bruto)
        }


        fun calcularSalarioLiquido(): Double {
            return salario_bruto - abono
        }

        fun calcularAbono( salario_bruto : Double ): Double {
            // até 1500,00 -> 20%
            // entre 1500,00 e 3000,00 -> 15%
            // acima de 3000,00 -> 10%

            if(salario_bruto <= 1500.00){
                return salario_bruto * 0.2
            }else if(salario_bruto > 1500.00 && salario_bruto <= 3000.00){
                return salario_bruto * 0.15
            }else{
                return salario_bruto * 0.1
            }
        }

        fun calcularInss( salario_bruto : Double ): Double {
            // até 868,29 -> 8%
            // entre 868,30 e R$ 1.447,14 -> 9%
            // entre 1.447,15 até R$ 2.894,28 -> 11%

            if(salario_bruto <= 868.29){
                return salario_bruto * 0.08
            }else if(salario_bruto > 868.30 && salario_bruto <= 1447.14){
                return salario_bruto * 0.09
            }else if(salario_bruto > 1447.14 && salario_bruto <= 2894.28){
                return salario_bruto * 0.11
            }else{
                return 318.37
            }
        }

        fun calcularImpostoRenda( salario_bruto : Double ): Double {
            // até 1.372,81 -> isento
            // entre 1.372,82 até 2.743,25 -> 8%
            // acima de 2000,00 -> 15%

            if(salario_bruto <= 1372.81){
                return 0.0
            }else if(salario_bruto > 1372.82 && salario_bruto <= 2743.25){
                return salario_bruto * 0.08
            }else{
                return salario_bruto * 0.15
            }
        }

        fun calcularFgts( salario_bruto : Double ): Double {
            // 8% do salário bruto
            return salario_bruto * 0.08
        }

        override fun toString(): String {
            return "O funcionário ${this.nome} tem o salário bruto de ${this.salario_bruto}, o salário líquido de ${this.salario_liquido}, o abono de ${this.abono}, o INSS de ${this.inss}, o imposto de renda de ${this.imposto_renda} e o FGTS de ${this.fgts}."
        }


}