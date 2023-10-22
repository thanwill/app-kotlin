package tech.tancy.tancy.ui.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.tancy.tancy.R

class ConvidadoViewHolder(tarefaView: View) : RecyclerView.ViewHolder(tarefaView){

    var nome = tarefaView.findViewById<TextView>(R.id.textViewNome)
    var email = tarefaView.findViewById<TextView>(R.id.textViewEmail)
}