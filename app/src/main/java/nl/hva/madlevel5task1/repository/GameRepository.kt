package nl.hva.madlevel5task1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import nl.hva.madlevel5task1.dao.GameDao
import nl.hva.madlevel5task1.db.GameRoomDatabase
import nl.hva.madlevel5task1.model.Game

class GameRepository(context: Context) {
    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Game?> {
        return gameDao.getGame()
    }

    suspend fun updateNotepad(note: Game) {
        gameDao.updateGame(note)
    }
}