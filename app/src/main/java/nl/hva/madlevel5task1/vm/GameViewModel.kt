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

    var games = gameRepository.getGames()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun getUsers(): LiveData<List<Game?>> {
        if (games == null) {
            games = gameRepository.getGames()
        }
        return games;
    }

    fun updateGame(title: String, platform: String, releaseDate: Date) {

        //if there is an existing note, take that id to update it instead of adding a new one
//        val newGame = gameRepository.getGameById();
        val newGame = Game(
            title = title,
            releaseDate = releaseDate,
            platform = platform,
            id = 1
        )

        if(isGameValid(newGame)) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    gameRepository.updateGame(newGame)
                }
                success.value = true
            }
        }
    }

    private fun isGameValid(game: Game): Boolean {
        return when {
            game.title.isBlank() -> {
                error.value = "Title must not be empty"
                false
            }
            game.platform.isBlank() -> {
                error.value = "Platform must not be empty"
                false
            }
            else -> true
        }
    }

}