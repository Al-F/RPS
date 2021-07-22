package com.alf_here.rpc

import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

const val AMOUNT_OF_WEAPONS_IN_GAME = 3

class SharedViewModel : ViewModel() {
    private val randomWeapon: Int
        get(): Int {
            return Random.nextInt(0, AMOUNT_OF_WEAPONS_IN_GAME)
        }

    var gamerScore = 0
    var enemyScore = 0
    var message = "Didn't initialized"
    var enemyWeaponDrawable = R.drawable.ic_dog_128
    var gamerWeaponDrawable = R.drawable.ic_dog_128

    fun onWeaponChosen(weapon: Weapon) {
        val enemyWeapon = Weapon.values()[randomWeapon]
        val roundResult = weapon.isStrongerThen(enemyWeapon)
        message = getResultMessage(roundResult)
        enemyWeaponDrawable = enemyWeapon.image
        gamerWeaponDrawable = weapon.image
        when (roundResult) {
            FightResult.WIN -> gamerScore++
            FightResult.LOOSE -> enemyScore++
            FightResult.TIE -> {
                gamerScore++
                enemyScore++
            }
        }
    }

    private fun getResultMessage(fightResult: FightResult): String {
        return when (fightResult) {
            FightResult.TIE -> "You think as a machine!"
            FightResult.WIN -> "You beat it!"
            FightResult.LOOSE -> "Ouch! You lost..."
        }
    }
}

fun Weapon.isStrongerThen(enemyWeapon: Weapon): FightResult {
    val d = (Weapon.values().size + this.ordinal - enemyWeapon.ordinal) % Weapon.values().size

    return when {
        d == 0 -> FightResult.TIE
        d % 2 == 1 -> FightResult.WIN
        else -> FightResult.LOOSE
    }
}

enum class Weapon(@DrawableRes val image: Int) {
    ROCK(R.drawable.ic_rock_64),
    PAPER(R.drawable.ic_paper_plane_64),
    SCISSORS(R.drawable.ic_scissors_64)
}

enum class FightResult {
    TIE, WIN, LOOSE
}
