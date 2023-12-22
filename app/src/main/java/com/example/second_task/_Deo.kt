package com.example.second_task

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface _Deo {

    @Insert
    fun insert(p:user)

    @Query("select * from user")
    fun getallusers():MutableList<user>

}