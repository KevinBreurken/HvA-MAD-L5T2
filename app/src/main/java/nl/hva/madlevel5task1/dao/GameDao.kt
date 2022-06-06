package nl.hva.madlevel5task1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import nl.hva.madlevel5task1.model.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(note: Game)

    @Query("SELECT * FROM gameTable ORDER BY releaseDate DESC")
    fun getGames(): LiveData<List<Game>>

    @Update
    suspend fun updateGame(note: Game)

    @Update
    suspend fun deleteGame(note: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteGames()

}
