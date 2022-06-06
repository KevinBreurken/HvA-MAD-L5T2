package nl.hva.madlevel5task1.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nl.hva.madlevel5task1.model.Game
import nl.hva.madlevel5task1.repository.GameRepository
import java.util.*


class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    var games: LiveData<List<Game>> = gameRepository.getGames();

    fun insertGame(game: Game) {
        mainScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        mainScope.launch {
            gameRepository.deleteGame(game)
        }
    }

    fun deleteGames() {
        mainScope.launch {
            gameRepository.deleteGames()
        }
    }
}