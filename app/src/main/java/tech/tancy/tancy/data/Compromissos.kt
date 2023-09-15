package tech.tancy.tancy.data

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.tancy.tancy.DetalhesActivity
import tech.tancy.tancy.R

class Compromissos (var titulo: String, var descricao: String, var data: String, var horaInicio: String, var horaFim: String){
    override fun toString(): String {
        return "Compromissos(titulo='$titulo', descricao='$descricao', data='$data', horaInicio='$horaInicio', horaFim='$horaFim')"
    }
}

class ListaCompromissos private constructor(){

        companion object {

            private val listaCompromissos = mutableListOf<Compromissos>()

            init {
                listaCompromissos.add(Compromissos("Concluir o projeto", "Concluir o projeto de programação para dispositivos móveis", "10/10/2021", "14:00", "16:00"))
                listaCompromissos.add(Compromissos("Estudar", "Estudar para a prova de programação para dispositivos móveis", "11/10/2021", "14:00", "16:00"))
                listaCompromissos.add(Compromissos("Agendar viagem", "Agendar viagem para o final de semana", "12/10/2021", "14:00", "16:00"))
            }

            fun getTamanhoLista() : Int {
                return listaCompromissos.size
            }

            fun adicionarCompromisso(compromisso: Compromissos) {
                listaCompromissos.add(compromisso)
            }

            fun editarCompromisso(index: Int, compromisso: Compromissos) {
                listaCompromissos[index] = compromisso
            }

            fun getCompromisso(index: Int) : Compromissos {
                return listaCompromissos[index]
            }

            fun removerCompromisso(index: Int) {
                listaCompromissos.removeAt(index)
            }
        }
}


class CompromissoViewHolder (layoutCompromisso: View): RecyclerView.ViewHolder(layoutCompromisso){

    // procura o elemento que será utilizado para exibir os dados do objeto
    var description = layoutCompromisso.findViewById<TextView>(R.id.textViewComprimisso)

}

class CompromissoAdapter(context: Context) : RecyclerView.Adapter<CompromissoViewHolder>() {



    // onCreateViewHolder é chamado para criar a view de cada item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompromissoViewHolder {
        val layoutCompromisso = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_compromisso, parent, false)
        return CompromissoViewHolder(layoutCompromisso)
    }

    // onBindViewHolder é chamado para exibir os dados de cada item da lista
    override fun onBindViewHolder(holder: CompromissoViewHolder, position: Int) {
        val compromissoAtualdaLista = ListaCompromissos.getCompromisso(position)
        holder.description.text = "Título: ${compromissoAtualdaLista.titulo}\nData: ${compromissoAtualdaLista.data}"

        holder.description.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetalhesActivity::class.java)
            intent.putExtra("index", position)
            holder.description.context.startActivity(intent)
            notifyDataSetChanged()
            true
        }


    }

    // getItemCount é chamado para obter o número de itens da lista
    override fun getItemCount(): Int {
        return ListaCompromissos.getTamanhoLista()
    }

}