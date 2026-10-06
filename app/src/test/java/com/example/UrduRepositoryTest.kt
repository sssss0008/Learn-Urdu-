package com.example

import com.example.data.repository.UrduRepository
import org.junit.Assert.*
import org.junit.Test

class UrduRepositoryTest {

    @Test
    fun testAlphabetContains39Letters() {
        assertEquals(39, UrduRepository.alphabetList.size)
        assertEquals("ا", UrduRepository.alphabetList.first().char)
        assertEquals("ے", UrduRepository.alphabetList.last().char)
    }

    @Test
    fun testVocabHasCategoriesAndItems() {
        assertTrue(UrduRepository.vocabCategories.isNotEmpty())
        assertTrue(UrduRepository.vocabItems.size >= 20)
    }

    @Test
    fun testPoetryAndCultureLoaded() {
        assertTrue(UrduRepository.poetrySherList.size >= 4)
        assertTrue(UrduRepository.culturalArticles.size >= 4)
        assertTrue(UrduRepository.grammarRules.size >= 4)
        assertTrue(UrduRepository.quizQuestions.size >= 8)
    }

    @Test
    fun testDailyItemsNotNull() {
        assertNotNull(UrduRepository.getWordOfTheDay())
        assertNotNull(UrduRepository.getSherOfTheDay())
    }
}
