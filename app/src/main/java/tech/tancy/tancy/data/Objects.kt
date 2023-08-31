package tech.tancy.tancy.data

class Pessoa  {

    // email, telefone, nome, senha, checkWhats

    // Atributos
    var nome : String
    var telefone : String
    var email : String
    var senha : String
    var checkWhats : Boolean

    // Init
    init {
        nome = ""
        telefone = ""
        email = ""
        senha = ""
        checkWhats = true
    }

    // Construtor primário
    constructor(nome: String, telefone: String, email: String, senha: String, checkWhats: Boolean) {
        this.nome = nome
        this.telefone = telefone
        this.email = email
        this.senha = senha
        this.checkWhats = checkWhats
    }

    constructor()

    override fun toString(): String {
        return "Seja bem vindo(a) ${this.nome}!"
    }
}

class Carro{

    var marca : String
    var modelo : String
    var ano : Int

    init {
        marca = "Mercedes"
        modelo = "Classe A"
        ano = 2023
    }

    override fun toString(): String {
        return "O carro da marca: ${this.marca} é do modelo ${this.modelo}, ano ${this.ano}."
    }
}

class Heroi{

        var nome : String
            set(value) {
                if(value.length >= 3){
                    field = value
                }else{
                    // cria um nome padrão random
                    field = "Heroi ${Math.random()}"
                }
            }

        var poder : String
        var nivel : Int = 1


        constructor(nome: String, poder: String, idade: Int) {
            this.nome = nome
            this.poder = poder
        }

        override fun toString(): String {
            return "O herói ${this.nome} tem ${this.poder} e é do nível ${this.nivel}."
        }
}

class Funcionario (var nome: String, var valorHora: Double, var horasTrabalhadas: Int){



        val salario : Double
            get() = this.valorHora * this.horasTrabalhadas



        fun bonificacao() : Double{
            return this.salario * 0.1
        }

        override fun toString(): String {
            return "O funcionário ${this.nome} tem o salário de ${this.salario} e a bonificação de ${this.bonificacao()}."
        }
}