package tech.tancy.tancy.data

// PrimaryKey Entity
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "usuarios")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "nome")
    val nome: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "senha")
    val senha: String

){
    override fun toString(): String {
        return "$id - $nome - $email - $senha"
    }
}
@Dao
interface UserDAO {
    @Query("SELECT * FROM usuarios")
    fun getAll(): List<User>

    @Query("SELECT * FROM usuarios WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM usuarios WHERE nome LIKE :nome LIMIT 1")
    fun findByName(nome: String): User

    @Insert
    fun insertAll(vararg users: User) // insertAll recebe um array de users

    @Insert
    fun insert(user: User) : Long

    @Delete
    fun delete(user: User)
}