package com.example.second_task

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

class Data {
    companion object{
        var LoggedInUser =user(0,"","","","","")
    }
}

@Entity(tableName = "user")
 class user(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name:String,
    var email:String,
    var password:String,
    var country:String,
    var role:String
)

@Dao
interface appDao{

    @Insert
    fun addUser(user: user)

    @Query("select * from user ")
    fun getUsers():MutableList<user>
}

@Database([user::class], version = 1)
abstract class appDb : RoomDatabase(){

    abstract fun getDaoFun():appDao

    companion object {

        @Volatile
        var instance: appDb? = null
        @Synchronized
        fun getRoomDb(context: Context): appDb {
            return if (instance == null) {
                val db = Room
                    .databaseBuilder(context, appDb::class.java, "RoomDb")
                    .allowMainThreadQueries()
                    .build()
                instance = db
                instance!!
            } else
                instance!!
        }
    }
}