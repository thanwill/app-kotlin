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

class Livro (var titulo: String, var autor: String, var editora: String, var ano: String, var genero: String, var sinopse: String) {


    // to string
    override fun toString(): String {
        return "Livro(titulo='$titulo', autor='$autor', editora='$editora', ano='$ano', genero='$genero', sinopse='$sinopse')"
    }

}

class ListaLivros private constructor(){

    companion object{
        private val listaLivros = mutableListOf<Livro>()

        init {
            listaLivros.add(Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "Martins Fontes", "1954", "Fantasia", "O Senhor dos Anéis é um romance de fantasia criado pelo escritor, professor e filólogo britânico J. R. R. Tolkien. A história começa como sequência de um livro anterior de Tolkien, O Hobbit, e logo se desenvolve numa história muito maior."))
            listaLivros.add(Livro("O Hobbit", "J. R. R. Tolkien", "Martins Fontes", "1937", "Fantasia", "O Hobbit é uma história sobre o hobbit Bilbo Bolseiro, que é contratado pelo mago Gandalf para ajudar Thorin Escudo de Carvalho e sua companhia de anões a reconquistar a Montanha Solitária e seu tesouro de um dragão chamado Smaug."))
            listaLivros.add(Livro("O Silmarillion", "J. R. R. Tolkien", "Martins Fontes", "1977", "Fantasia", "O Silmarillion é uma coletânea de mitos do escritor britânico J. R. R. Tolkien, editada e publicada postumamente em 1977 por seu filho, Christopher Tolkien, com a ajuda de Guy Gavriel Kay, que também colaborou na escrita do apêndice."))
        }

        fun addLivro(livro: Livro) {
            listaLivros.add(livro)
        }

        fun getLivro(index: Int): Livro {
            return listaLivros[index]
        }

        fun getListaLivros(): List<Livro> {
            return listaLivros
        }

        fun size(): Int {
            return listaLivros.size
        }
    }


}

// livroViewHoler
class LivroViewHolder( livroLayout : View) : RecyclerView.ViewHolder( livroLayout ) {
    val titulo = livroLayout.findViewById<TextView>(R.id.textViewTitulo)
    val autor = livroLayout.findViewById<TextView>(R.id.textViewAutor)
    val genero = livroLayout.findViewById<TextView>(R.id.textViewGenero)
}

class LivroAdapter(context : Context) : RecyclerView.Adapter<LivroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val livroLayout = LayoutInflater.from(parent.context).inflate(R.layout.layout_livro, parent, false)
        return LivroViewHolder(livroLayout)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = ListaLivros.getLivro(position)
        holder.titulo.text = livro.titulo
        holder.autor.text = livro.autor
        holder.genero.text = livro.genero

        // click longo para acessar a tela de detalhes
        holder.itemView.setOnLongClickListener {
            val intent = Intent(holder.itemView.context, DetalhesActivity::class.java)
            intent.putExtra("index", position)
            holder.itemView.context.startActivity(intent)
            notifyDataSetChanged()
            true
        }

    }

    override fun getItemCount(): Int {
        return ListaLivros.size()
    }
}
