# Atividade de Programação

## Introdução

Esta atividade consiste em 7 exercícios de programação. Cada exercício é projetado para testar uma habilidade específica, como a capacidade de escrever código claro e conciso, ou a capacidade de usar uma biblioteca ou framework específico.

## Exercícios

Os exercícios são os seguintes:

1. Calcular o aumento que será dado a um funcionário, obtendo do usuário as
seguintes informações: salário atual e a porcentagem de aumento. Apresentar
o novo valor do salário e o valor do aumento.
2. Calcular o volume de uma caixa (largura * altura * comprimento).
3. Calcular a idade de uma pessoa, tendo em vista que ela irá digitar o ano do
seu nascimento. Evitar que o ano informado seja maior que o ano atual, ou
menor que 1900.
4. Calcular o consumo por litro de um carro, sendo que será informada a
quantidade de quilômetros percorrido e a quantidade de litros abastecido.
5. Calcular a média final de um aluno com base nas suas 4 notas bimestrais. Não
permitir notas negativas, ou acima de 10 em cada bimestre.

6. Ler uma temperatura em graus Celsius e apresentá-la convertida em graus
Fahrenheit. A fórmula de conversão: F ← (9*C+160)/5
7. Calcular e apresentar o volume de uma lata de óleo cilíndrica, a partir da leitura
do raio da base e da altura. A fórmula: pi * raio2 * altura.

## Como usar

Para usar esta atividade, você precisará da IDE Android Studio ou qualquer outra de sua preferência que suporte aplicações Android utilizando Kotlin. Um APK também é disponibilizado para facilitar o uso do app.

1. Baixe o código da atividade para o seu computador.
2. Abra o código no seu editor de texto.
3. Compilar ou interpretar o código.
4. Execute o código para testar os exercícios.

## Sobre o código

Aqui está um exemplo de parte do código para os exercícios:

```kotlin
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

        fun calcularVolumeLata(raio: Double, altura: Double): Double {
            return Math.PI * Math.pow(raio, 2.0) * altura
        }
    }
}
```

Por razões didáticas, o companion object em Kotlin foi abordado. Todas as Activitys podem ser encontradas no arquivo ProfileActiviy, conforme imagem abaixo.

<img width="794" alt="image" src="https://github.com/thanwill/app-kotlin/assets/62673590/a58e8eaa-547c-487d-a3d2-3b07077ac4e9">

Como melhoria futura, o estudo da implantação da <code>FragmentActivity</code> está sendo estudado.

A estrutura foi baseada nas experiências em sala e pesquisas pessoais, como por exemplo, o uso do viewBinding, a prática de clean code, funcionalidades do Firebase e características de UI/UX. 

## Telas de uso

Abaixo, algumas intruções para o uso:

### Cadastro de usuário

É necessário realizar um cadastro para acessar a Activity Profile, que contém os acessos a lista de exercícios.

<img width="364" alt="image" src="https://github.com/thanwill/app-kotlin/assets/62673590/c46dc3c0-e42f-4395-b9f3-e1b22df442b1">

### Tela de login

Depois de realizar o cadastro, utilize o e-mail e a senha criada. Até o presente momento, a função para restaurar senha ainda não encontra-se disponível na aplicação. Caso esqueça, uma nova conta deve ser criada. Não se preocupe, a validação de e-mail ainda não é considerada nessa etapa.

O modelo de autenticação é uma implementação dos serviços oferecido pelo Firebase Authentication. 

<img width="364" alt="image" src="https://github.com/thanwill/app-kotlin/assets/62673590/32228fa2-1e6a-43c7-ab21-ff7f63a32eb1">

### Perfil e atividades

Depois de efetuar o login com sucesso, você será direcionado para a tela de perfil. Uma confirmação sobre o e-mail utilizado será realizada no canto superior da tela. Ao rolar a página, será possível visualizar a lista de exercícios.

<img width="364" alt="image" src="https://github.com/thanwill/app-kotlin/assets/62673590/eb0673ce-17a3-4431-9625-a8e46959c1b1">

No canto inferior da tela é possível visualizar o botão "SAIR". Ele realizará o logout dos dados atrelados a aplicação.

### Atividades

Cada atividade usa uma Activity exclusiva, como é requerido nas exigências do exercício valendo XP. Para voltar a tela de Perfil, utiliza o botão voltar na barra de navegação do sistema operacional. 

<img width="364" alt="image" src="https://github.com/thanwill/app-kotlin/assets/62673590/d29814fc-2cb7-4c15-b7d8-3ce573c2956b">

Dependendo da versão Android utilizada em seu disponsitivo, é possível delizar o dedo no canto esquerdo para o centro da tela.

## Conclusão

As bibliotecas utilizadas ainda não aderem as políticas de mercado e podem sofrer alteracões a qualquer instante. Tem alguma sugestão? Deixe-a nos comentários.

Espero que isso ajude! 

Converse comigo em https://wa.me/5541987233861

✌🏻👨🏼‍💻
