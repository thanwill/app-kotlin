package tech.tancy.tancy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Carro (var marca: String, var modelo: String, var ano: Int, var cor: String, var preco: Double){
    override fun toString(): String {
        return "Carro(marca='$marca', modelo='$modelo', ano=$ano, cor='$cor', preco=$preco)"
    }
}

class ListaCarros private constructor(){

    companion object {

        private val listaCarros = mutableListOf<Carro>()

        init {
            listaCarros.add(Carro("Fiat", "Uno", 2010, "Branco", 20000.0))
            listaCarros.add(Carro("Fiat", "Palio", 2012, "Preto", 25000.0))
            listaCarros.add(Carro("Fiat", "Punto", 2015, "Vermelho", 30000.0))
        }

        fun getTamanhoLista() : Int {
            return listaCarros.size
        }

        fun adicionarCarro(carro: Carro) {
            listaCarros.add(carro)
        }

        fun getCarro(index: Int) : Carro {
            return listaCarros[index]
        }

        fun removerCarro(index: Int) {
            listaCarros.removeAt(index)
        }
    }

}
class CarroViewHolder( layoutCarro: View): RecyclerView.ViewHolder(layoutCarro){

    // procura o elemento que será utilizado para exibir os dados do objeto
    var description = layoutCarro.findViewById<TextView>(R.id.textViewDescription)

}

class CarroAdapter(context: Context) : RecyclerView.Adapter<CarroViewHolder>() {

    // onCreateViewHolder é chamado para criar a view de cada item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        var layoutCarro = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_carro, parent, false)
        return CarroViewHolder(layoutCarro)
    }

    // onBindViewHolder é chamado para cada item da lista
    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carroAtualDaLista = ListaCarros.getCarro(position)
        // marca e modelo
        holder.description.text = "${carroAtualDaLista.marca}, ${carroAtualDaLista.modelo}"

        holder.description.setOnLongClickListener(){
            // aciona a tela de detalhes
            val intent = Intent(holder.description.context, DetalhesActivity::class.java)
            intent.putExtra("index", position)
            holder.description.context.startActivity(intent)
            notifyDataSetChanged()
            true

        }
    }

    override fun getItemCount(): Int {
        return ListaCarros.getTamanhoLista()
    }
}