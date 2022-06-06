package nl.hva.madlevel5task1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task1.R
import com.example.madlevel5task1.databinding.ItemGameBinding
import nl.hva.madlevel5task1.model.Game

class GameAdapter(private val movies: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemGameBinding.bind(itemView)

        fun bind(movieItem: Game) {
            binding.gameTitle.text = movieItem.title
            binding.releaseDate.text = movieItem.releaseDate.toString()
            binding.platform.text = movieItem.platform
        }
    }

}
