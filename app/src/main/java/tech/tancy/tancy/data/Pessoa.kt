package tech.tancy.tancy.data

class Pessoa  {

    // Orientação a objeto
    // è possível definir um construtor padrão para intanciamento
    private var nome : String = ""
    private var idade : Int = 0

    // Atributos precisam ter a criação dos getters e setters

    // Criando construtor secundário : this()
    constructor(nome: String, idade: Int) : this(){
        this.nome = nome
        this.idade = idade
    }

    constructor()

    override fun toString(): String {
        return "O nome da pessoa é ${this.nome} e a idade é ${this.idade}."
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
        var idade : Int
        var nivel : Int = 1


        constructor(nome: String, poder: String, idade: Int) {
            this.nome = nome
            this.poder = poder
            this.idade = idade
        }

        override fun toString(): String {
            return "O herói ${this.nome} tem o poder ${this.poder} e tem ${this.idade} anos do nível ${this.nivel}."
        }
}