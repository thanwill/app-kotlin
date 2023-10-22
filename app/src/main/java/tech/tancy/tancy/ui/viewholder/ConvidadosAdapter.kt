package tech.tancy.tancy.ui.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.tancy.tancy.R
import tech.tancy.tancy.model.Convidado


class ConvidadosAdapter (val context: Context): RecyclerView.Adapter<ConvidadoViewHolder>(){

    lateinit var listaConvidados : List<Convidado>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvidadoViewHolder {
        val tarefaLayout = LayoutInflater.from(context)
            .inflate(R.layout.layout_convidados, parent, false)
        return ConvidadoViewHolder(tarefaLayout)

    }

    override fun onBindViewHolder(holder: ConvidadoViewHolder, position: Int) {
        val convidado = listaConvidados[position]
        holder.nome.text = convidado.nome
        holder.email.text = convidado.email
    }

    override fun getItemCount(): Int {
        return listaConvidados.size
    }

    // método para atualizar a lista de tarefas local
    fun atualizaLista(lista: List<Convidado>){
        listaConvidados = lista
        notifyDataSetChanged()
    }
}