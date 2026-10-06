package com.example.data.model

enum class AppLanguage(val code: String, val displayName: String, val scriptName: String) {
    ENGLISH("en", "English", "English"),
    NEPALI("ne", "नेपाली", "Nepali (देवनागरी)"),
    URDU("ur", "اردو", "Urdu (اردو)")
}

data class UrduLetter(
    val char: String,
    val nameUrdu: String,
    val nameDevanagari: String,
    val nameEnglish: String,
    val devanagariEquivalent: String,
    val soundDescription: String,
    val initialForm: String,
    val medialForm: String,
    val finalForm: String,
    val exampleWordUrdu: String,
    val exampleWordDevanagari: String,
    val exampleWordEnglish: String,
    val exampleMeaningNepali: String,
    val exampleMeaningEnglish: String
)

data class UrduNumber(
    val digitUrdu: String,
    val digitArabic: Int,
    val nameUrdu: String,
    val nameDevanagari: String,
    val nameEnglish: String,
    val nepaliMeaning: String,
    val englishMeaning: String
)

data class VocabItem(
    val id: String,
    val urdu: String,
    val devanagari: String,
    val romanUrdu: String,
    val nepali: String,
    val english: String,
    val categoryId: String,
    val exampleUrdu: String? = null,
    val exampleDevanagari: String? = null,
    val exampleNepali: String? = null,
    val exampleEnglish: String? = null
)

data class VocabCategory(
    val id: String,
    val titleUrdu: String,
    val titleNepali: String,
    val titleEnglish: String,
    val iconName: String,
    val descriptionNepali: String,
    val descriptionEnglish: String
)

data class PoetrySher(
    val id: String,
    val poetNameUrdu: String,
    val poetNameNepali: String,
    val poetNameEnglish: String,
    val poetEra: String,
    val misra1Urdu: String,
    val misra2Urdu: String,
    val devanagariTransliteration: String,
    val translationNepali: String,
    val translationEnglish: String,
    val explanationNepali: String,
    val explanationEnglish: String
)

data class CulturalArticle(
    val id: String,
    val titleUrdu: String,
    val titleNepali: String,
    val titleEnglish: String,
    val tag: String,
    val summaryNepali: String,
    val summaryEnglish: String,
    val fullContentNepali: String,
    val fullContentEnglish: String,
    val fullContentUrdu: String,
    val keyPoints: List<String>
)

data class GrammarRule(
    val id: String,
    val titleUrdu: String,
    val titleNepali: String,
    val titleEnglish: String,
    val explanationNepali: String,
    val explanationEnglish: String,
    val comparisonWithNepali: String,
    val examples: List<GrammarExample>
)

data class GrammarExample(
    val urdu: String,
    val devanagari: String,
    val nepali: String,
    val english: String,
    val breakdown: String
)

data class QuizQuestion(
    val id: String,
    val promptUrdu: String,
    val promptNepali: String,
    val promptEnglish: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanationNepali: String,
    val explanationEnglish: String,
    val spokenText: String
)
