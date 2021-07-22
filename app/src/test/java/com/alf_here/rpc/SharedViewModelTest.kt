package com.alf_here.rpc

import org.junit.Test

import org.junit.Assert.*

class SharedViewModelTest {
    @Test
    fun isStrongerThan_correct() {
        assertEquals(FightResult.LOOSE, Weapon.PAPER.isStrongerThen(Weapon.SCISSORS))
        assertEquals(FightResult.WIN, Weapon.PAPER.isStrongerThen(Weapon.ROCK))
        assertEquals(FightResult.TIE, Weapon.PAPER.isStrongerThen(Weapon.PAPER))
        assertEquals(FightResult.LOOSE, Weapon.ROCK.isStrongerThen(Weapon.PAPER))
        assertEquals(FightResult.TIE, Weapon.ROCK.isStrongerThen(Weapon.ROCK))
        assertEquals(FightResult.WIN, Weapon.ROCK.isStrongerThen(Weapon.SCISSORS))
        assertEquals(FightResult.TIE, Weapon.SCISSORS.isStrongerThen(Weapon.SCISSORS))
        assertEquals(FightResult.LOOSE, Weapon.SCISSORS.isStrongerThen(Weapon.ROCK))
        assertEquals(FightResult.WIN, Weapon.SCISSORS.isStrongerThen(Weapon.PAPER))
    }
}