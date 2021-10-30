package com.challange.kotlinapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryTest {
    @Test
    fun testRepositoryGetData() {
        val repo = Repository()
        val data = repo.getData()

        val want = 15
        val got = data.size
        Assert.assertEquals(got, want)
    }
}