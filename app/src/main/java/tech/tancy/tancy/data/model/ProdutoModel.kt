package tech.tancy.tancy.data.model

class ProdutoModel {

    fun validarProduto (produto: String, descricao: String, preco: String, quantidade: String): String{

        try {
            val precoDouble = preco.toDouble()
            val quantidadeInt = quantidade.toInt()

            // verifica se os campos estão vazios
            if (produto.isEmpty() || descricao.isEmpty() || preco.isEmpty() || quantidade.isEmpty()){
                return "Preencha todos os campos"
            }

            // verifica se o preço é maior que zero
            if (precoDouble <= 0){
                return "O preço deve ser maior que zero"
            }

            // verifica se a quantidade é maior que zero e menor que 10
            if (quantidadeInt <= 0 || quantidadeInt > 10){
                return "A quantidade deve ser maior que zero e menor que 10"
            }
            // retorna mensagem de sucesso
            return "Produto cadastrado com sucesso"
        } catch (e: Exception){
            return "Erro ao cadastrar produto"
        }
    }

}