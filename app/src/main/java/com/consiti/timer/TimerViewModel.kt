package com.consiti.timer

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel:ViewModel() {
    companion object{
        private const val ONE_SECOND = 1000L

        // this is the total time of the game
        private const val RANGODETIEMPO = 60000L
    }
    private val timer: CountDownTimer
    private val _timeLeft = MutableLiveData<Long>()
    val timeLeft : LiveData<Long>
        get() = _timeLeft


    init {
        timer = object : CountDownTimer(RANGODETIEMPO, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                _timeLeft.value = millisUntilFinished / ONE_SECOND
            }

            override fun onFinish() {
                _timeLeft.value = 0
            }
        }
        timer.start()
    }



    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}