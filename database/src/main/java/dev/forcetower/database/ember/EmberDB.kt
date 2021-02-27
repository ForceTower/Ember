package dev.forcetower.database.ember

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.forcetower.database.ember.dao.AccessDao
import dev.forcetower.model.unes.Access

@Database(entities = [
    Access::class
], version = 1)
abstract class EmberDB : RoomDatabase() {
    abstract val access: AccessDao

    companion object {
        fun create(context: Context): EmberDB {
            return Room.databaseBuilder(context, EmberDB::class.java, "ember.db")
                .enableMultiInstanceInvalidation()
                .build()
        }
    }
}