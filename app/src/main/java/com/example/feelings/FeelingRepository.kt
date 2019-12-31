package com.example.feelings

import androidx.lifecycle.LiveData

class FeelingRepository (private val feelingDao: FeelingDao) {
    val allFeelings: LiveData<List<Feeling>> = feelingDao.getFeelings()

    //do this in the background = suspend
    suspend fun insert(feeling: Feeling){
        feelingDao.insertFeeling(feeling)
    }
}