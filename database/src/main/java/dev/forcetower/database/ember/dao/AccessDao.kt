package dev.forcetower.database.ember.dao

import androidx.room.Dao
import androidx.room.Query
import dev.forcetower.model.unes.Access
import dev.forcetower.toolkit.database.dao.BaseDao

@Dao
abstract class AccessDao : BaseDao<Access>() {
    @Query("SELECT * FROM Access WHERE username = :username")
    abstract suspend fun getAccessByUsername(username: String): Access?

    override suspend fun getValueByIDDirect(value: Access): Access? {
        return getAccessByUsername(value.username)
    }
}