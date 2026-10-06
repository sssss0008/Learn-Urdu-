package com.example.data.repository

import com.example.data.model.*

object UrduRepository {

    val alphabetList = listOf(
        UrduLetter("ا", "الف", "अलिफ", "Alif", "अ / आ", "Initial vowel or long /aː/", "ا", "ـا", "ـا", "انار", "अनार", "Anaar", "अनार (Pomegranate)", "Pomegranate"),
        UrduLetter("آ", "الف مد", "अलिफ मद", "Alif Madda", "आ", "Long open vowel /aː/", "آ", "—", "ـآ", "آم", "आम", "Aam", "आँप (Mango)", "Mango"),
        UrduLetter("ب", "بے", "बे", "Bay", "ब", "Voiced bilabial plosive /b/", "بـ", "ـبـ", "ـب", "بلی", "बिल्ली", "Billi", "बिरालो (Cat)", "Cat"),
        UrduLetter("پ", "پے", "पे", "Pay", "प", "Voiceless bilabial plosive /p/", "پـ", "ـپـ", "ـپ", "پانی", "पानी", "Paani", "पानी (Water)", "Water"),
        UrduLetter("ت", "تے", "ते", "Tay", "त", "Soft dental voiceless plosive /t̪/", "تـ", "ـتـ", "ـت", "تارا", "तारा", "Taara", "तारा (Star)", "Star"),
        UrduLetter("ٹ", "ٹے", "टे", "Te", "ट", "Retroflex plosive /ʈ/ (curled tongue)", "ٹـ", "ـٹـ", "ـٹ", "ٹماٹر", "टमाटर", "Tamaatar", "गोलभेंडा (Tomato)", "Tomato"),
        UrduLetter("ث", "ثے", "से", "Say", "स", "Voiceless alveolar fricative /s/", "ثـ", "ـثـ", "ـث", "ثمر", "समर", "Samar", "फल / परिणाम (Fruit/Result)", "Fruit / Reward"),
        UrduLetter("ج", "جیم", "जीम", "Jeem", "ज", "Voiced postalveolar affricate /d͡ʒ/", "جـ", "ـجـ", "ـج", "چائے", "चाए", "Chaye", "चिया (Tea)", "Tea"),
        UrduLetter("چ", "چے", "चे", "Che", "च", "Voiceless postalveolar affricate /t͡ʃ/", "چـ", "ـچـ", "ـچ", "چاند", "चाँद", "Chaand", "चन्द्रमा (Moon)", "Moon"),
        UrduLetter("ح", "حے", "हे (बडी)", "Bari Hay", "ह", "Voiceless pharyngeal/glottal /h/", "حـ", "ـحـ", "ـح", "حلوہ", "हलवा", "Halwa", "हलुवा (Sweet dish)", "Sweet dish"),
        UrduLetter("خ", "خے", "खे", "Khay", "ख़", "Voiceless uvular fricative /x/ (deep kh)", "خـ", "ـخـ", "ـخ", "خواب", "ख्वाब", "Khwaab", "सपना (Dream)", "Dream"),
        UrduLetter("د", "دال", "दाल", "Daal", "द", "Dental voiced plosive /d̪/", "د", "ـد", "ـد", "دوست", "दोस्त", "Dost", "साथी (Friend)", "Friend"),
        UrduLetter("ڈ", "ڈال", "डाल", "Daal (Retroflex)", "ड", "Retroflex voiced plosive /ɖ/", "ڈ", "ـڈ", "ـڈ", "ڈاکٹر", "डाक्टर", "Doctor", "चिकित्सक (Doctor)", "Doctor"),
        UrduLetter("ذ", "ذال", "जाल", "Zaal", "ज़", "Voiced alveolar fricative /z/", "ذ", "ـذ", "ـذ", "ذائقہ", "जायका", "Zaiqa", "स्वाद (Taste/Flavor)", "Taste"),
        UrduLetter("ر", "رے", "रे", "Ray", "र", "Alveolar trill /r/", "ر", "ـر", "ـر", "رات", "रात", "Raat", "रात (Night)", "Night"),
        UrduLetter("ڑ", "ڑے", "डे", "Rray (Flap)", "ड़", "Retroflex flap /ɽ/ (deep r sound)", "ڑ", "ـڑ", "ـڑ", "پہاڑ", "पहाड़", "Pahaar", "पहाड (Mountain)", "Mountain"),
        UrduLetter("ز", "زے", "जे", "Zay", "ज़", "Voiced alveolar fricative /z/", "ز", "ـز", "ـز", "زندگی", "जिन्दगी", "Zindagi", "जीवन / जिन्दगी (Life)", "Life"),
        UrduLetter("ژ", "ژے", "झे", "Zhay", "झ़", "Voiced postalveolar fricative /ʒ/", "ژ", "ـژ", "ـژ", "ژالہ باری", "झालाबारी", "Zhalabari", "असिना पर्नु (Hailstorm)", "Hailstorm"),
        UrduLetter("س", "سین", "सीन", "Seen", "स", "Voiceless alveolar fricative /s/", "سـ", "ـسـ", "ـس", "سورج", "सूरज", "Sooraj", "सूर्य (Sun)", "Sun"),
        UrduLetter("ش", "شین", "शीन", "Sheen", "श", "Voiceless postalveolar fricative /ʃ/", "شـ", "ـشـ", "ـش", "شعر", "शेर", "Sher", "कविताको दुई पङ्क्ति (Couplet)", "Poetic Couplet"),
        UrduLetter("ص", "صاد", "स्वाद", "Swaad", "स", "Emphatic /sˠ/ (heavy s)", "صـ", "ـصـ", "ـص", "صبح", "सुबह", "Subah", "बिहान (Morning)", "Morning"),
        UrduLetter("ض", "ضاد", "ज्वाद", "Zwaad", "ज़", "Emphatic /zˠ/ (heavy z)", "ضـ", "ـضـ", "ـض", "ضرورت", "जरूरत", "Zaroorat", "आवश्यकता (Necessity)", "Need / Necessity"),
        UrduLetter("ط", "طوئے", "तोए", "Toey", "त", "Emphatic dental /tˠ/", "طـ", "ـطـ", "ـط", "طوطا", "तोता", "Tota", "सुगा (Parrot)", "Parrot"),
        UrduLetter("ظ", "ظوئے", "जोए", "Zoey", "ज़", "Emphatic /zˠ/", "ظـ", "ـظـ", "ـظ", "ظلم", "जुल्म", "Zulm", "अन्याय (Cruelty/Injustice)", "Cruelty"),
        UrduLetter("ع", "عین", "ऐन", "Ain", "अ / '", "Voiced pharyngeal fricative /ʕ/", "عـ", "ـعـ", "ـع", "عشق", "इश्क", "Ishq", "गहिरो प्रेम (Love)", "Passionate Love"),
        UrduLetter("غ", "غین", "गैन", "Ghain", "ग़", "Voiced uvular fricative /ɣ/ (deep gh)", "غـ", "ـغـ", "ـغ", "غزل", "ग़ज़ल", "Ghazal", "गजल (Ghazal poem)", "Ghazal"),
        UrduLetter("ف", "فے", "फे", "Fay", "फ़", "Voiceless labiodental fricative /f/", "فـ", "ـفـ", "ـف", "फूल", "फूल", "Phool", "फूल (Flower)", "Flower"),
        UrduLetter("ق", "قاف", "काफ (गहिरो)", "Qaaf", "क़", "Voiceless uvular plosive /q/ (throat k)", "قـ", "ـقـ", "ـق", "قلم", "कलम", "Qalam", "कलम (Pen)", "Reed Pen"),
        UrduLetter("ک", "کاف", "काफ", "Kaaf", "क", "Voiceless velar plosive /k/", "کـ", "ـکـ", "ـک", "کتاب", "किताब", "Kitaab", "पुस्तक / किताब (Book)", "Book"),
        UrduLetter("گ", "گاف", "गाफ", "Gaaf", "ग", "Voiced velar plosive /g/", "گـ", "ـگـ", "ـگ", "گلاب", "गुलाब", "Gulaab", "गुलाब (Rose)", "Rose"),
        UrduLetter("ل", "لام", "लाम", "Laam", "ल", "Alveolar lateral approximant /l/", "لـ", "ـلـ", "ـل", "دل", "दिल", "Dil", "मुटु / मन (Heart)", "Heart"),
        UrduLetter("م", "میم", "मीम", "Meem", "म", "Bilabial nasal /m/", "مـ", "ـمـ", "ـم", "محبت", "मोहब्बत", "Mohabbat", "माया / प्रेम (Love)", "Affection / Love"),
        UrduLetter("ن", "نون", "नून", "Noon", "न", "Alveolar nasal /n/", "نـ", "ـنـ", "ـن", "نور", "नूर", "Noor", "प्रकाश / चमक (Light/Glow)", "Divine Light"),
        UrduLetter("و", "واؤ", "वाओ", "Wao", "व / ओ / ऊ", "Labial-velar /w/ or vowel /oː/, /uː/", "و", "ـو", "ـو", "وقت", "वक्त", "Waqt", "समय / बेला (Time)", "Time"),
        UrduLetter("ہ", "چھوٹی ہے", "छोटी हे", "Chhoti Hay", "ह", "Glottal fricative /h/", "ہـ", "ـہـ", "ـہ", "ہوا", "हवा", "Hawa", "हावा (Breeze/Air)", "Wind / Air"),
        UrduLetter("ھ", "دو چشمی ہے", "दो चश्मी हे", "Do-chashmi Hay", "ह्", "Aspiration marker (bh, ph, th...)", "ھـ", "ـھـ", "ـھ", "گھر", "घर", "Ghar", "घर (Home)", "Home"),
        UrduLetter("ء", "ہمزہ", "हमज़ा", "Hamza", "अ' (विराम)", "Glottal stop /ʔ/ or vowel transition", "ء", "ء", "ء", "چائے", "चाए", "Chaye", "चिया (Tea transition)", "Vowel glide"),
        UrduLetter("ی", "چھوٹی یے", "छोटी ये", "Chhoti Ye", "य / ई", "Palatal approximant /j/ or vowel /iː/", "یـ", "ـیـ", "ـی", "یاد", "याद", "Yaad", "सम्झना (Memory)", "Memory"),
        UrduLetter("ے", "بڑی یے", "बडी ये", "Bari Ye", "ए / ऐ", "Long vowel /eː/ or /ɛː/ (end only)", "—", "—", "ـے", "لڑکے", "लड़के", "Larke", "केटाहरू (Boys)", "Boys")
    )

    val numbersList = listOf(
        UrduNumber("۰", 0, "صفر", "सिफर", "Sifar", "शून्य", "Zero"),
        UrduNumber("۱", 1, "ایک", "एक", "Aik", "एक", "One"),
        UrduNumber("۲", 2, "دو", "दो", "Do", "दुई", "Two"),
        UrduNumber("۳", 3, "تین", "तीन", "Teen", "तीन", "Three"),
        UrduNumber("۴", 4, "چار", "चार", "Chaar", "चार", "Four"),
        UrduNumber("۵", 5, "پانچ", "पाँच", "Paanch", "पाँच", "Five"),
        UrduNumber("۶", 6, "چھ", "छ", "Chhay", "छ", "Six"),
        UrduNumber("۷", 7, "سات", "सात", "Saat", "सात", "Seven"),
        UrduNumber("۸", 8, "آٹھ", "आठ", "Aath", "आठ", "Eight"),
        UrduNumber("۹", 9, "نو", "नौ", "Nau", "नौ", "Nine"),
        UrduNumber("۱۰", 10, "دس", "दस", "Das", "दस", "Ten"),
        UrduNumber("۱۱", 11, "گیارہ", "ग्यारह", "Gyaarah", "एघार", "Eleven"),
        UrduNumber("۱۲", 12, "بارہ", "बारह", "Baarah", "बाह्र", "Twelve"),
        UrduNumber("۱۳", 13, "تیرہ", "तेरह", "Teerah", "तेह्र", "Thirteen"),
        UrduNumber("۱۴", 14, "چودہ", "चौदह", "Chaudah", "चौध", "Fourteen"),
        UrduNumber("۱۵", 15, "پندرہ", "पन्द्रह", "Pandrah", "पन्ध्र", "Fifteen"),
        UrduNumber("۱۶", 16, "سولہ", "सोलह", "Solah", "सोह्र", "Sixteen"),
        UrduNumber("۱۷", 17, "سترہ", "सत्रह", "Satrah", "सत्र", "Seventeen"),
        UrduNumber("۱۸", 18, "اٹھارہ", "अठारह", "Athaarah", "अठार", "Eighteen"),
        UrduNumber("۱۹", 19, "انیس", "उन्नाइस / उन्नीस", "Unnees", "उन्नाइस", "Nineteen"),
        UrduNumber("۲۰", 20, "بیس", "बीस", "Bees", "बीस", "Twenty"),
        UrduNumber("۵۰", 50, "پچاس", "पचास", "Pachaas", "पचास", "Fifty"),
        UrduNumber("۱۰۰", 100, "سو", "सय / सौ", "Sau", "सय", "Hundred")
    )

    val vocabCategories = listOf(
        VocabCategory("greetings", "آداب و تسلیمات", "आदर र अभिवादन", "Greetings & Etiquette", "handshake", "नमस्ते र शिष्टाचारका शब्दहरू", "Polite greetings & respects"),
        VocabCategory("conversation", "روزمرہ گفتگو", "दैनिक कुराकानी", "Daily Conversation", "chat", "दैनिक जीवनमा प्रयोग हुने वाक्यहरू", "Everyday conversational sentences"),
        VocabCategory("family", "خاندان اور رشتے", "परिवार र सम्बन्ध", "Family & Relations", "family", "नातागोता र सम्बन्धका नामहरू", "Kinship and family words"),
        VocabCategory("food", "کھانا اور مشروبات", "खाना र परिकार", "Food & Dining", "restaurant", "स्वादिष्ट परिकार र भोजन सम्बन्धी शब्द", "Delicious dishes & dining terms"),
        VocabCategory("travel", "سفر اور راستے", "यात्रा र दिशाहरू", "Travel & Directions", "navigation", "यात्रा गर्दा चाहिने उपयोगी शब्दहरू", "Directions and travel essentials"),
        VocabCategory("market", "بازار اور خریداری", "बजार र किनमेल", "Market & Shopping", "shopping_bag", "मोलतोल र किनमेलका वाक्यांश", "Bargaining and shopping phrases"),
        VocabCategory("emotions", "جذبات اور احساسات", "भावना र अनुभूति", "Feelings & Emotions", "favorite", "मनका भावना र संवेगहरू", "Expressions of love, joy and sorrow"),
        VocabCategory("time", "وقت اور موسم", "समय र मौसम", "Time & Weather", "schedule", "समय, ऋतु र प्राकृतिक अवस्था", "Calendar, hours and climate")
    )

    val vocabItems = listOf(
        // Greetings
        VocabItem("g1", "السلام علیکم", "अस्सलाम अलैकुम", "Assalamu Alaikum", "तपाईंलाई शान्ति मिलोस् (नमस्ते)", "Peace be upon you (Hello)", "greetings", "وعلیکم السلام", "वालेकुम अस्सलाम", "तपाईंलाई पनि शान्ति मिलोस्", "And unto you peace"),
        VocabItem("g2", "آداب", "आदाब", "Aadaab", "अभिवादन / नमस्कार", "Respectful greeting / Salutations", "greetings", "جناب آداب عرض ہے", "जनाब आदाब अर्ज है", "हजुरलाई नमस्कार छ", "Greetings, respected sir"),
        VocabItem("g3", "شکریہ", "शुक्रिया", "Shukriya", "धन्यवाद", "Thank you", "greetings", "آپ کا بہت شکریہ", "आप का बहुत शुक्रिया", "तपाईंलाई धेरै धन्यवाद", "Thank you very much"),
        VocabItem("g4", "خدا حافظ", "खुदा हाफिज़", "Khuda Hafiz", "भगवानले रक्षा गरून् (अलविदा)", "May God protect you (Goodbye)", "greetings", "اب میں چلتا ہوں، خدا حافظ", "अब मैं चलता हूँ, खुदा हाफिज़", "अब म लाग्छु, अलविदा", "I shall take leave now, goodbye"),
        VocabItem("g5", "خوش آمدید", "खुश आमदीद", "Khush Aamdeed", "स्वागत छ", "Welcome", "greetings", "ہمارے گھر میں خوش آمدید", "हमारे घर में खुश आमदीद", "हाम्रो घरमा स्वागत छ", "Welcome to our home"),
        VocabItem("g6", "معاف کیجیئے گا", "माफ कीजिएगा", "Maaf kijiye ga", "माफ गर्नुहोस्", "Excuse me / Please forgive me", "greetings", "معاف کیجیئے گا، کیا وقت ہوا ہے؟", "माफ कीजिएगा, क्या वक्त हुआ है?", "माफ गर्नुहोस्, कति बज्यो होला?", "Excuse me, what time is it?"),

        // Conversation
        VocabItem("c1", "آپ کیسے ہیں؟", "आप कैसे हैं?", "Aap kaise hain?", "तपाईंलाई कस्तो छ?", "How are you? (Polite)", "conversation", "میں بالکل ٹھیک ہوں", "मैं बिल्कुल ठीक हूँ", "म एकदम सञ्चै छु", "I am completely fine"),
        VocabItem("c2", "آپ کا نام کیا ہے؟", "आप का नाम क्या है?", "Aap ka naam kya hai?", "तपाईंको नाम के हो?", "What is your name?", "conversation", "میरा نام اوشکار ہے", "मेरा नाम अविष्कार है", "मेरो नाम अविष्कार हो", "My name is Awiskar"),
        VocabItem("c3", "آپ سے مل کر خوشی ہوئی", "आप से मिलकर खुशी हुई", "Aap se mil kar khushi hui", "तपाईंलाई भेटेर खुसी लाग्यो", "Pleased to meet you", "conversation", "مجھے بھی آپ سے مل کر خوشی ہوئی", "मुझे भी आप से मिलकर खुशी हुई", "मलाई पनि खुसी लाग्यो", "Glad to meet you too"),
        VocabItem("c4", "کیا آپ اردو بولتے ہیں؟", "क्या आप उर्दू बोलते हैं?", "Kya aap Urdu boltay hain?", "के तपाईं उर्दू बोल्नुहुन्छ?", "Do you speak Urdu?", "conversation", "ہاں، میں تھوڑی اردو بولتا ہوں", "हाँ, मैं थोड़ी उर्दू बोलता हूँ", "हो, म अलिअलि उर्दू बोल्छु", "Yes, I speak a little Urdu"),
        VocabItem("c5", "مجھے اردو سیکھنے کا شوق ہے", "मुझे उर्दू सीखने का शौक है", "Mujhe Urdu seekhne ka shauq hai", "मलाई उर्दू सिक्ने रहर छ", "I have a passion to learn Urdu", "conversation", "اردو ایک نہایت شیریں زبان ہے", "उर्दू एक निहायत शीरीं जुबान है", "उर्दू एकदमै मिठासपूर्ण भाषा हो", "Urdu is an extremely sweet language"),

        // Family
        VocabItem("f1", "والد / ابا", "वालिद / अब्बा", "Walid / Abba", "बुबा / पिता", "Father", "family"),
        VocabItem("f2", "والدہ / امی", "वालिदा / अम्मी", "Walida / Ammi", "आमा / माता", "Mother", "family"),
        VocabItem("f3", "بھائی", "भाई", "Bhai", "दाजु / भाइ", "Brother", "family"),
        VocabItem("f4", "بہن", "बहन", "Behen", "दिदी / बहिनी", "Sister", "family"),
        VocabItem("f5", "دوست", "दोस्त", "Dost", "साथी / मित्र", "Friend", "family"),
        VocabItem("f6", "بچے", "बच्चे", "Bachay", "बालबच्चाहरू", "Children", "family"),

        // Food
        VocabItem("fd1", "بریانی", "बिरयानी", "Biryani", "बिरयानी (मसलेदार चामल र मासु)", "Spiced aromatic rice dish", "food"),
        VocabItem("fd2", "چائے", "चाए", "Chaye", "चिया", "Tea", "food", "ایک کپ گرما گرم چائے پلائیے", "एक कप गरमा गरम चाए पिलाइए", "एक कप तातो चिया दिनुहोस्", "Serve a cup of piping hot tea"),
        VocabItem("fd3", "روٹی / نان", "रोटी / नान", "Roti / Naan", "रोटी / नान", "Flatbread", "food"),
        VocabItem("fd4", "نہاری", "निहारी", "Nihari", "निहारी (धीमी आगोमा पाकेको मासुको झोल)", "Slow-cooked savory meat stew", "food"),
        VocabItem("fd5", "شیر خرما", "शीर खुरमा", "Sheer Khurma", "शीर खुरमा (चाडपर्वको खिर)", "Sweet festive vermicelli milk pudding", "food"),
        VocabItem("fd6", "پانی", "पानी", "Paani", "पानी", "Water", "food"),

        // Travel
        VocabItem("t1", "راستہ", "रास्ता", "Raasta", "बाटो / मार्ग", "Way / Path", "travel", "کیا یہ راستہ لاہور جاتا ہے؟", "क्या यह रास्ता लाहौर जाता है?", "के यो बाटो लाहोर जान्छ?", "Does this path lead to Lahore?"),
        VocabItem("t2", "کہاں", "कहाँ", "Kahan", "कहाँ", "Where", "travel", "بس اسٹینڈ کہاں ہے؟", "बस स्ट्यान्ड कहाँ है?", "बस स्टेसन कहाँ छ?", "Where is the bus stand?"),
        VocabItem("t3", "دائیں", "दाएं", "Daayein", "दायाँ", "Right side", "travel"),
        VocabItem("t4", "بائیں", "बाएं", "Baayein", "बायाँ", "Left side", "travel"),
        VocabItem("t5", "سیدھا", "सीधा", "Seedha", "सिधा अगाडि", "Straight ahead", "travel"),

        // Market
        VocabItem("m1", "اس کی قیمت کیا ہے؟", "इसकी कीमत क्या है?", "Iski qeemat kya hai?", "यसको मूल्य कति हो?", "What is the price of this?", "market"),
        VocabItem("m2", "یہ بہت مہنگا ہے", "यह बहुत महंगा है", "Yeh bohot mehnga hai", "यो धेरै महँगो छ", "This is very expensive", "market"),
        VocabItem("m3", "تھوڑی رعایت کیجیئے", "थोड़ी रिआयत कीजिए", "Thori riaayat kijiye", "अलिकति छुट दिनुहोस् न", "Please give some discount", "market"),
        VocabItem("m4", "پیسے", "पैसे", "Paisa / Paisay", "रुपैयाँ / पैसा", "Money", "market"),

        // Emotions
        VocabItem("e1", "محبت", "मोहब्बत", "Mohabbat", "प्रेम / माया", "Love / Affection", "emotions"),
        VocabItem("e2", "عشق", "इश्क", "Ishq", "गहिरो प्रेम / आशिकी", "Passionate love", "emotions"),
        VocabItem("e3", "خوشی", "खुशी", "Khushi", "खुसी / आनन्द", "Happiness / Joy", "emotions"),
        VocabItem("e4", "غم / اداسی", "गम / उदासी", "Gham / Udaasi", "दुःख / उदासी", "Sorrow / Sadness", "emotions"),
        VocabItem("e5", "شوق", "शौक", "Shauq", "रुचि / रहर", "Enthusiasm / Passion", "emotions"),

        // Time
        VocabItem("tm1", "آج", "आज", "Aaj", "आज", "Today", "time"),
        VocabItem("tm2", "کل", "कल", "Kal", "भोलि वा हिजो", "Tomorrow or Yesterday", "time"),
        VocabItem("tm3", "صبح", "सुबह", "Subah", "बिहान", "Morning", "time"),
        VocabItem("tm4", "شام", "शाम", "Shaam", "साँझ", "Evening", "time"),
        VocabItem("tm5", "موسم", "मौसम", "Mausam", "मौसम", "Weather / Climate", "time", "آج کا موسم بہت سہانا ہے", "आज का मौसम बहुत सुहाना है", "आजको मौसम ज्यादै मनमोहक छ", "Today's weather is very pleasant")
    )

    val poetrySherList = listOf(
        PoetrySher(
            id = "p1",
            poetNameUrdu = "مرزا اسد اللہ خاں غالب",
            poetNameNepali = "मिर्जा असदुल्लाह खाँ गालिब",
            poetNameEnglish = "Mirza Asadullah Khan Ghalib",
            poetEra = "1797 – 1869 (Delhi, Mughal Era)",
            misra1Urdu = "ہزاروں خواہشیں ایسی کہ ہر خواہش پہ دم نکلے",
            misra2Urdu = "بہت نکلے مرے ارمان لیکن پھر بھی کم نکلے",
            devanagariTransliteration = "हज़ारों ख्वाहिशें ऐसी कि हर ख्वाहिश पे दम निकले\nबहुत निकले मेरे अरमान लेकिन फिर भी कम निकले",
            translationNepali = "हजारौँ इच्छाहरू यस्ता कि प्रत्येक इच्छामा प्राण जाओस्,\nमेरा धेरै सपना पूरा भए तर पनि कम नै सावित भए।",
            translationEnglish = "Thousands of desires, each one worth dying for,\nMany of my aspirations were fulfilled, yet so few they seemed.",
            explanationNepali = "गालिबको यो अमर शेर मानव मनको असीम तृष्णा र जीवनको अतृप्त यथार्थलाई अभिव्यक्त गर्दछ।",
            explanationEnglish = "Ghalib's most iconic verse on the infinite and insatiable nature of human desire."
        ),
        PoetrySher(
            id = "p2",
            poetNameUrdu = "علامہ محمد اقبال",
            poetNameNepali = "अल्लामा मुहम्मद इकबाल",
            poetNameEnglish = "Allama Muhammad Iqbal",
            poetEra = "1877 – 1938 (Poet of the East)",
            misra1Urdu = "خودی کو کر بلند اتنا کہ ہر تقدیر سے پہلے",
            misra2Urdu = "خدا بندے سے خود پوچھے بتا تیری رضا کیا ہے",
            devanagariTransliteration = "खुदी को कर बुलंद इतना कि हर तक़दीर से पहले\nखुदा बन्दे से खुद पूछे बता तेरी रज़ा क्या है",
            translationNepali = "आफ्नो आत्मबललाई यति उच्च बनाऊ कि हरेक भाग्य लेख्नुपूर्व,\nईश्वरले स्वयम् भक्तसँग सोधोस्— 'भन्, तेरो चाहना के छ?'",
            translationEnglish = "Elevate your self-hood to such height that before decreeing destiny,\nGod Himself shall ask you: 'Tell me, what is your desire?'",
            explanationNepali = "आत्मविश्वास, संकल्प र कर्मको शक्तिले भाग्यलाई समेत बदल्न सकिन्छ भन्ने प्रेरणादायी सन्देश।",
            explanationEnglish = "Iqbal's philosophical call for supreme self-realization, inner will, and destiny creation."
        ),
        PoetrySher(
            id = "p3",
            poetNameUrdu = "فیض احمد فیض",
            poetNameNepali = "फैज अहमद फैज",
            poetNameEnglish = "Faiz Ahmed Faiz",
            poetEra = "1911 – 1984 (Revolutionary & Romantic)",
            misra1Urdu = "گلوں میں رنگ بھرے بادِ نوبہار چلے",
            misra2Urdu = "چلے بھی آؤ کہ گلشن کا کاروبار چلے",
            devanagariTransliteration = "गुलों में रंग भरे बाद-ए-नौबहार चले\nचले भी आओ कि गुलशन का कारोबार चले",
            translationNepali = "फूलहरूमा रङ्ग भरियोस् र वसन्तको ताजा हावा चलोस्,\nअब आइदेऊ प्रिय, ताकि बगैँचाको जीवन र चहलपहल फेरि सुरु होस्।",
            translationEnglish = "Let the flowers be filled with colors, let the spring breeze blow;\nDo come back, my love, so the garden can resume its lively bloom.",
            explanationNepali = "प्रेम र आशाको प्रतीक। विरहपछि पुनर्मिलन र नयाँ बिहानीको सुन्दर आह्वान।",
            explanationEnglish = "Faiz blends lyrical romantic longing with hope for political and cultural spring renewal."
        ),
        PoetrySher(
            id = "p4",
            poetNameUrdu = "میر تقی میر",
            poetNameNepali = "मीर तकी मीर",
            poetNameEnglish = "Mir Taqi Mir",
            poetEra = "1723 – 1810 (Khuda-e-Sukhan / God of Poetry)",
            misra1Urdu = "نازکی اس کے لب کی کیا کہئے",
            misra2Urdu = "پنکھڑی اک گلاب کی سی ہے",
            devanagariTransliteration = "नाज़ुकी उसके लब की क्या कहिए\nपंखुड़ी इक गुलाब की सी है",
            translationNepali = "उसको ओठको कोमलताको के बयान गरूँ,\nमानौँ रातो गुलाबको एउटा कोमल पात जस्तो छ।",
            translationEnglish = "How do I describe the delicacy of her tender lips?\nThey are just like the delicate petal of a fresh rose.",
            explanationNepali = "उर्दू गजलको सादगी र अतुलनीय सौन्दर्य चित्रणको सर्वोत्कृष्ट नमुना।",
            explanationEnglish = "The pinnacle of classical simplicity and romantic metaphor in Urdu poetry."
        )
    )

    val culturalArticles = listOf(
        CulturalArticle(
            id = "c_history",
            titleUrdu = "اردو زبان کی تاریخ اور ارتقاء",
            titleNepali = "उर्दू भाषाको ऐतिहासिक विकासक्रम",
            titleEnglish = "History & Genesis of Urdu Language",
            tag = "History (تاریخ)",
            summaryNepali = "उर्दू कसरी सैन्य शिविर (लश्कर) बाट सुरु भएर राजदरबार र विश्वकै मिठासपूर्ण साहित्यिक भाषा बन्यो।",
            summaryEnglish = "How Urdu evolved from military camps into imperial courts and one of the world's most poetic languages.",
            fullContentNepali = """
                उर्दू भाषाको उत्पत्ति करिब १२ औँ-१३ औँ शताब्दीमा भारतीय उपमहाद्वीपको दिल्ली र वरपरको क्षेत्रमा भएको हो।
                
                'उर्दू' शब्द तुर्की भाषाको 'ओर्दु' (Ordu) बाट आएको हो, जसको अर्थ 'सेनाको छाउनी' वा 'शिविर' (Lashkar) हुन्छ। दिल्ली सल्तनत र मुगल कालमा विभिन्न क्षेत्रका सैनिक, व्यापारी र विद्वानहरू (फारसी, तुर्की, अरबी र स्थानीय खडीबोली/शौरसेनी अपभ्रंश बोल्नेहरू) बीच संवादका क्रममा यो मिश्रित भाषा जन्मियो।
                
                यसकारण सुरुमा यसलाई 'जबाने-उर्दू-ए-मुअल्ला' (شاہی لشکر کی زبان - शाही छाउनीको भाषा) भनिन्थ्यो। पछि आमिर खुसरोले यसलाई 'हिन्दवी' भनेर पहिलो पटक कवितामा ढाले। त्यसपछि दक्कन (दक्षिण भारत), दिल्ली र लखनउका नवाबहरूको संरक्षणमा यो भाषा परिष्कृत भई नस्तालिक लिपिमा लेखिन थाल्यो।
                
                आज उर्दू आफ्नो शिष्टता, उच्च तहजीब (सभ्यता) र गहिरो गजल साहित्यका लागि विश्वभर प्रख्यात छ।
            """.trimIndent(),
            fullContentEnglish = """
                The Urdu language emerged around the 12th-13th centuries in and around Delhi in the South Asian subcontinent.
                
                The word 'Urdu' originates from the Turkic word 'Ordu', meaning 'army camp'. During the Delhi Sultanate and the Mughal era, soldiers, artisans, traders, and scholars from Persian, Turkish, Arabic, and local Khari Boli (Sanskrit-derived) backgrounds interacted daily.
                
                Out of this rich cultural crucible arose a lingua franca initially dubbed 'Zaban-e-Urdu-e-Mu'alla' (Language of the Exalted Camp). Great polymath Amir Khusrau pioneered its poetic voice under the name 'Hindavi'. Over centuries in the Deccan, Delhi, and the courtly circles of Lucknow, Urdu was polished into an exquisite medium of diplomacy, philosophy, and sublime romance.
                
                Today, Urdu is globally celebrated for its elegance, ethical etiquette (Adab), and incomparable Ghazal literature.
            """.trimIndent(),
            fullContentUrdu = """
                اردو کا لفظ ترکی زبان کے لفظ "اوردو" سے نکلا ہے جس کے معنی لشکر یا چھاؤنی کے ہیں۔ بارہویں اور تیرہویں صدی میں جب مختلف زبانیں بولنے والے اکٹھے ہوئے تو یہ شیریں زبان پروان چڑھی۔ امیر خسرو سے لے کر میر و غالب تک اردو نے بے مثال ادبی مقام حاصل کیا۔
            """.trimIndent(),
            keyPoints = listOf(
                "Root word 'Ordu' means camp/army",
                "Synthesizes Arabic/Persian vocabulary with Indo-Aryan grammar",
                "Pioneered poetically by Amir Khusrau as 'Hindavi'",
                "Golden eras flourished in Delhi, Deccan, and Lucknow"
            )
        ),
        CulturalArticle(
            id = "c_nepali_connection",
            titleUrdu = "اردو اور نیپالی زبان کے لسانی روابط",
            titleNepali = "उर्दू र नेपाली भाषाको गहिरो सम्बन्ध",
            titleEnglish = "Linguistic Affinity: Urdu & Nepali",
            tag = "Linguistics (لسانیات)",
            summaryNepali = "दुवै भाषा भारोपेली (Indo-European) परिवारका हुन् र दुवैमा समान वाक्य संरचना तथा साझा शब्द भण्डार छन्।",
            summaryEnglish = "Both languages share Indo-Aryan syntax (SOV) and hundreds of mutual loanwords in administration and poetry.",
            fullContentNepali = """
                धेरैलाई थाहा नहुन सक्छ कि नेपाली र उर्दू भाषाको व्याकरण र वाक्य संरचना झन्डै एउटै ढाँचामा आधारित छ।
                
                १. समान वाक्य संरचना (SOV):
                दुवै भाषामा कर्ता + कर्म + क्रिया (Subject + Object + Verb) को क्रम हुन्छ।
                उदाहरण:
                - उर्दू: मैं किताब पढ़ता हूँ (Main kitaab parhta hoon)
                - नेपाली: म किताब पढ्छु
                
                २. प्रशासनिक र कानुनी साझा शब्दहरू:
                नेपाली कानुन, मालपोत र प्रशासनमा सयौँ फारसी/उर्दू शब्दहरू सदियौँदेखि नेपालीमै घुलमिल भएका छन्:
                - सरकार (Sarkar)
                - अदालत (Adaalat)
                - कानुन (Qanoon)
                - तारिख (Taareekh)
                - दस्तखत (Dastakhat - हस्ताक्षर)
                - कागज (Kaaghaz)
                - हाजिर (Haazir)
                - फैसला (Faisla)
                - दर्खास्त (Darkhaast)
                
                ३. शिष्टाचार र आदरार्थी तह:
                नेपालीमा जस्तै (हजुर / तपाईं / तिमी / तँ), उर्दूमा पनि सम्मानका तहहरू (Aap / Tum / Tu) ठ्याक्कै मिल्दोजुल्दो हुन्छन्। यसैले नेपाली भाषीका लागि उर्दू सिक्न संसारकै सबैभन्दा सजिलो हुन्छ!
            """.trimIndent(),
            fullContentEnglish = """
                Urdu and Nepali both descend from the Indo-Aryan branch of the Indo-European language family. Because of this shared ancestry:
                
                1. Identical Sentence Structure (SOV):
                Both languages construct thoughts in Subject + Object + Verb order.
                Example:
                - Urdu: Main kitaab parhta hoon
                - Nepali: Ma kitaab padhchhu
                
                2. Shared Administrative & Everyday Vocabulary:
                Historical ties and regional governance introduced hundreds of Perso-Arabic / Urdu terms into standard Nepali:
                - Sarkar (Government), Adaalat (Court), Qanoon (Law), Taareekh (Date/Hearing), Dastakhat (Signature), Kaaghaz (Paper), Faisla (Verdict), Darkhaast (Application).
                
                3. Mirror Politeness Tiers:
                Urdu's levels of honorific address ('Aap' for respect, 'Tum' for peers, 'Tu' for intimate/children) parallel Nepali's 'Hajur/Tapai', 'Timi', and 'Ta'.
                This makes Nepali speakers naturally gifted at mastering Urdu pronunciation and grammar!
            """.trimIndent(),
            fullContentUrdu = """
                اردو اور نیپالی دونوں زبانیں ہند-آریائی خاندان سے تعلق رکھتی ہیں۔ جملوں کی ساخت (فاعل، مفعول، فعل) بالکل ایک جیسی ہے، اور نیپالی عدالتی و دفتری زبان میں بے شمار اردو الفاظ مستعمل ہیں۔
            """.trimIndent(),
            keyPoints = listOf(
                "Identical SOV (Subject-Object-Verb) grammar structure",
                "Shared official words: Sarkar, Adaalat, Qanoon, Kaaghaz, Dastakhat",
                "Parallel 3-tier politeness system (Aap / Tum / Tu)",
                "Easy learning curve for Nepali and Devanagari readers"
            )
        ),
        CulturalArticle(
            id = "c_mushaira",
            titleUrdu = "مشاعرے اور داستان گوئی کی روایت",
            titleNepali = "मुसायरा र दास्तानगोईको परम्परा",
            titleEnglish = "The Tradition of Mushaira & Dastangoi",
            tag = "Tradition (روایت)",
            summaryNepali = "उर्दू कविता वाचनको भव्य महफिल 'मुसायरा' र मुखले कथा भन्ने कला 'दास्तानगोई' को सांस्कृतिक महत्व।",
            summaryEnglish = "The poetic symposium of Mushaira and the medieval oral storytelling art of Dastangoi.",
            fullContentNepali = """
                मुसायरा (Mushaira) उर्दू संस्कृतिको आत्मा मानिन्छ। यो एउटा यस्तो साहित्यिक भेला हो जहाँ कविहरू (शायर) आफ्ना ताजा गजल र नज्महरू श्रोतामाझ वाचन गर्दछन्।
                
                मुसायरामा परम्परागत रूपमा 'शमा' (मैनबत्ती वा दीप) जुन शायरको अगाडि राखिन्छ, उसैले आफ्नो कला प्रस्तुत गर्दथ्यो। श्रोताहरूले राम्रो शेर सुन्दा "वाह-वाह!", "सुभानअल्लाह!", "मुकर्रर इरशाद!" (फेरि सुनाउनुहोस्) भनेर दाद दिने विशेष शिष्टाचार हुन्छ।
                
                त्यस्तै, 'दास्तानगोई' (Dastangoi) मध्यकालीन मौखिक कथा वाचनको कला हो जसमा सेतो पोसाक लगाएका कलाकारहरूले तिलिस्म, जादु र वीरताका कथाहरू (जस्तै दास्तान-ए-अमीर हम्जा) घण्टौँसम्म सम्मोहित पारेर सुनाउँथे।
            """.trimIndent(),
            fullContentEnglish = """
                Mushaira is the beating heart of Urdu literary culture. It is a traditional gathering where poets assemble to recite their latest ghazals before an appreciative audience.
                
                Historically, an ornate burning candle ('Shama') was moved sequentially across the floor; whichever poet the Shama was placed before had the floor to recite. Listeners express profound delight with traditional responses such as "Waah! Waah!", "SubhanAllah!", and "Mukarrar Irshad!" (Encore!).
                
                Parallel to Mushaira is Dastangoi, the 16th-century art of oral epic storytelling. Dressed in pristine white cotton Angarkhas, master storytellers mesmerized gatherings with tales of fantasy, chivalry, and magic.
            """.trimIndent(),
            fullContentUrdu = """
                مشاعرہ اردو ادب کا لازوال جزو ہے۔ محفل میں شمع گردش کرتی تھی اور ہر شاعر کو کلام سنانے کا موقع ملتا تھا۔ داد دینے کے مخصوص آداب جیسے 'واہ واہ' اور 'مکرر ارشاد' مشاعرے کا حسن ہیں۔
            """.trimIndent(),
            keyPoints = listOf(
                "Traditional recitation with the travelling 'Shama' candle",
                "Formal appreciation etiquette: 'Waah Waah', 'SubhanAllah', 'Mukarrar'",
                "Dastangoi: Classical oral storytelling of epic legends",
                "Fosters deep community appreciation for poetry and eloquence"
            )
        ),
        CulturalArticle(
            id = "c_nastaliq",
            titleUrdu = "خطِ نستعلیق اور خوش نویسی کا فن",
            titleNepali = "नस्तालिक लिपि र सुलेखन (क्यालिग्राफी)",
            titleEnglish = "Nastaliq Script & Calligraphic Art",
            tag = "Art & Calligraphy (خطاطی)",
            summaryNepali = "उर्दू लेखिने छड्के, घुमाउरो र सुन्दर नस्तालिक लिपिको इतिहास र बाँसको कलम (कलम-ए-सरकन्डा) को जादु।",
            summaryEnglish = "The fluid, cascading Nastaliq script and the timeless mastery of the reed pen (Qalam).",
            fullContentNepali = """
                उर्दू भाषा मुख्यतया 'नस्तालिक' (Nastaliq) लिपिमा लेखिन्छ, जुन दायाँबाट बायाँतर्फ बग्दछ।
                
                'नस्तालिक' शब्द 'नस्ख' (Naskh) र 'तालिक' (Ta'liq) दुई प्राचीन अरबी-फारसी लिपिहरूको संयोजनबाट बनेको हो। यसको आविष्कार १४ औँ शताब्दीका महान सुलेखक मीर अली तब्रेजीले गरेका थिए।
                
                नस्तालिक लिपिको विशेषता यसको छड्के (diagonal) झुकाव, शब्दहरू एकमाथि अर्को खप्टिने कलात्मकता, र घुमाउरो आकर्षण हो। यसलाई बाँस वा नर्कटको कलम (Qalam) लाई छड्के काटेर मसी (Siyahi) मा चोपेर लेखिन्छ। सुलेखन (Khushnavisi) लाई केवल लेखाइ मात्र नभई आध्यात्मिक ध्यान र सौन्दर्यको चरम अभिव्यक्ति मानिन्छ।
            """.trimIndent(),
            fullContentEnglish = """
                Urdu is written in the fluid and majestic Nastaliq script, flowing gracefully from right to left.
                
                The term Nastaliq is a portmanteau of two classical scripts: 'Naskh' (structured, legible) and 'Ta'liq' (hanging, cursive). Invented in 14th-century Persia by calligrapher Mir Ali Tabrizi, it was refined into perfection across the Indian subcontinent.
                
                Nastaliq is distinguished by its cascading diagonal downward flow, delicate ligatures, and proportional balance measured in 'Nuqtas' (rhombic dots). Master scribes craft reed pens (Qalam) cut at precise angles, dipping them in rich lampblack ink.
            """.trimIndent(),
            fullContentUrdu = """
                خطِ نستعلیق کو خطاطی کی دنیا میں عروس الخطوط (خطوں کی دلہن) کہا جاتا ہے۔ یہ نسخ اور تعلیق کا حسین امتزاج ہے جو دائیں سے بائیں خوبصورت ڈھلوان میں بہتا ہے۔
            """.trimIndent(),
            keyPoints = listOf(
                "Invented by Mir Ali Tabrizi combining Naskh and Ta'liq",
                "Flows right-to-left with elegant cascading ligatures",
                "Written traditionally with hand-carved reed pen (Qalam)",
                "Nuqtas (rhombic dots) define letter identification and proportions"
            )
        ),
        CulturalArticle(
            id = "c_cuisine_adab",
            titleUrdu = "تہذیب، اخلاق اور روایتی کھانے",
            titleNepali = "उर्दू तहजीब, शिष्टाचार र भोजन संस्कृति",
            titleEnglish = "Tehzeeb (Etiquette) & Royal Cuisine",
            tag = "Lifestyle (تہذیب)",
            summaryNepali = "उर्दू सभ्यताको जग मानिने 'अदब' (नम्रता र शिष्टाचार) तथा शाही मुगलई/अवधी भोजनका परिकार।",
            summaryEnglish = "The refined culture of Adab (politeness) and the sensory journey of Mughlai and Awadhi gastronomy.",
            fullContentNepali = """
                उर्दू केवल एउटा भाषा मात्र होइन, यो एउटा संस्कार र जीवनशैली हो जसलाई 'तहजीब' (Tehzeeb) भनिन्छ।
                
                १. अदब (Adab):
                अरूलाई सधैँ 'पहले आप' (पहिले हजुर) भन्ने, ठूलालाई आदरपूर्वक 'किबला' वा 'जनाब' सम्बोधन गर्ने, र बोल्दा कहिल्यै कर्कश नहुने यसको पहिचान हो।
                
                २. पोसाक:
                परम्परागत रूपमा पुरुषहरूले सेतो वा कालो शेरवानी, कुर्ता-पाजामा र टोपी लगाउँछन् भने महिलाहरूले सुती वा रेशमी घराना, सलवार-कमिज र दुपट्टा प्रयोग गर्छन्।
                
                ३. खानपान:
                उर्दू भाषी संस्कृतिको भोजन (दस्तरख्वान) मा दम पुख्त बिर्यानी, लामो समय पाकेको निहारी, रेशमी कबाब, शीरमाल रोटी, र ईदको दिन तयार गरिने खिर शीर खुरमा अत्यन्त लोकप्रिय छन्।
            """.trimIndent(),
            fullContentEnglish = """
                To understand Urdu is to appreciate 'Tehzeeb'—a philosophy of gracious living, dignified speech, and hospitality.
                
                1. Adab (Courtesy):
                The celebrated ethos of "Pehle Aap" (After you, sir), addressing companions with honorifics like 'Janab' and 'Hazrat', and cultivating a gentle, humble tone.
                
                2. Regal Attire:
                Elegant black or ivory Sherwanis paired with churidar pajamas for gentlemen, and exquisite Gharaaras or Pashmina shawls for ladies.
                
                3. The Feast of the Dastarkhwan:
                Slow-dum cooked Biryanis, melting Galouti kebabs, velvety Nihari stew, saffron Sheermal bread, and Eid's delicate Sheer Khurma pudding.
            """.trimIndent(),
            fullContentUrdu = """
                اردو تہذیب کا طرہ امتیاز اس کے آداب و اخلاق ہیں۔ "پہلے آپ" کا فلسفہ، دسرخوان کی وسعت، نہاری، بریانی اور کبابوں کا ذائقہ اس کی پہچان ہیں۔
            """.trimIndent(),
            keyPoints = listOf(
                "Culture of 'Pehle Aap' (Respect and prioritizing others)",
                "Dressing: Bespoke Sherwanis, Kurta-Pajamas, and Ghararas",
                "Grand dining traditions: Biryani, Nihari, Kebabs, and Sheer Khurma",
                "Hospitality (Mehmaan-nawazi) treated as a sacred duty"
            )
        )
    )

    val grammarRules = listOf(
        GrammarRule(
            id = "g_sov",
            titleUrdu = "جملے کی ساخت (فاعل، مفعول، فعل)",
            titleNepali = "वाक्य संरचना (कर्ता + कर्म + क्रिया)",
            titleEnglish = "Sentence Structure (SOV Order)",
            explanationNepali = "उर्दू र नेपाली दुवै भाषामा वाक्यको ढाँचा कर्ता (Subject) + कर्म (Object) + क्रिया (Verb) हुन्छ। अङ्ग्रेजीमा जस्तो क्रिया बीचमा आउँदैन।",
            explanationEnglish = "Just like Nepali, Urdu follows the Subject + Object + Verb (SOV) sentence pattern, unlike English (SVO).",
            comparisonWithNepali = "नेपाली जस्तै ठ्याक्कै एउटै क्रम: [म] [पानी] [पिउँछु] = [मैं] [पानी] [पीता हूँ]।",
            examples = listOf(
                GrammarExample("احمد کتاب پڑھتا ہے", "अहमद किताब पढ़ता है", "अहमद किताब पढ्छ", "Ahmad reads a book", "Subject: Ahmad, Object: Kitaab, Verb: Parhta hai"),
                GrammarExample("ہم چائے پیتے ہیں", "हम चाए पीते हैं", "हामी चिया पिउँछौँ", "We drink tea", "Subject: Hum (हामी), Object: Chaye, Verb: Peetay hain")
            )
        ),
        GrammarRule(
            id = "g_politeness",
            titleUrdu = "احترام کے درجات (آپ، تم، تو)",
            titleNepali = "आदरार्थी तहहरू (तपाईं, तिमी, तँ)",
            titleEnglish = "Honorifics & Politeness (Aap, Tum, Tu)",
            explanationNepali = "उर्दूमा तीन प्रकारका सर्वनाम हुन्छन्: १. 'آپ' (Aap - तपाईं/हजुर), २. 'تم' (Tum - तिमी), ३. 'تو' (Tu - तँ)। नयाँ वा ठूला व्यक्तिसँग सधैँ 'آپ' प्रयोग गर्नुपर्छ।",
            explanationEnglish = "Urdu uses three registers of address: 'Aap' (formal/polite, like Nepali 'Tapai/Hajur'), 'Tum' (informal/peer, like Nepali 'Timi'), and 'Tu' (very intimate/poetic or rude, like Nepali 'Ta').",
            comparisonWithNepali = "Aap = तपाईं / हजुर, Tum = तिमी, Tu = तँ।",
            examples = listOf(
                GrammarExample("آپ تشریف رکھیئے", "आप तशरीफ रखिए", "हजुर बस्नुहोस्", "Please have a seat (Very polite)", "Formal honorific with 'Aap'"),
                GrammarExample("تم کہاں جا رہے ہو؟", "तुम कहाँ जा रहे हो?", "तिमी कहाँ गइरहेका छौ?", "Where are you going? (Peer)", "Casual peer address with 'Tum'")
            )
        ),
        GrammarRule(
            id = "g_gender",
            titleUrdu = "تذکیر و تانیث (مذکر اور مونث)",
            titleNepali = "लिङ्ग भेद (पुल्लिङ्ग र स्त्रीलिङ्ग)",
            titleEnglish = "Gender in Nouns & Verbs",
            explanationNepali = "उर्दूमा हरेक नाम (Noun) या त पुल्लिङ्ग (Muzakkar) हुन्छ या स्त्रीलिङ्ग (Mu'annas)। क्रिया पनि लिङ्ग अनुसार बदलिन्छ: केटाका लागि 'ता ہے' (ta hai) र केटीका लागि 'تی ہے' (ti hai)।",
            explanationEnglish = "Every noun in Urdu is masculine or feminine. Verbs reflect the subject's gender: '-ta hai' for masculine singular, '-ti hai' for feminine singular.",
            comparisonWithNepali = "नेपालीमा जस्तै: केटा पढ्छ (Parhta hai) / केटी पढ्छे (Parhti hai)।",
            examples = listOf(
                GrammarExample("لڑکا دوڑتا ہے", "लड़का दौड़ता है", "केटो कुद्छ", "The boy runs", "Masculine marker -ta"),
                GrammarExample("لڑکی دوڑتی ہے", "लड़की दौड़ती है", "केटी कुद्छे", "The girl runs", "Feminine marker -ti")
            )
        ),
        GrammarRule(
            id = "g_postposition",
            titleUrdu = "حروفِ ربط (کا، کے، کی)",
            titleNepali = "सम्बन्धकारक विभक्ति (को, का, की)",
            titleEnglish = "Possessive Postpositions (Ka, Ke, Ki)",
            explanationNepali = "स्वामित्व देखाउन 'کا' (Ka - पुल्लिङ्ग एकवचन), 'کے' (Ke - पुल्लिङ्ग बहुवचन/आदरार्थी), र 'کی' (Ki - स्त्रीलिङ्ग) प्रयोग गरिन्छ।",
            explanationEnglish = "'Ka', 'Ke', and 'Ki' correspond to the apostrophe-s ('s) or 'of'. They agree with the gender and number of the POSSESSED object.",
            comparisonWithNepali = "नेपालीको 'को' (Ka), 'का' (Ke), 'की' (Ki) सँग ठ्याक्कै समान।",
            examples = listOf(
                GrammarExample("اس کا گھر", "उसका घर", "उसको घर", "His/Her house", "Ghar is masculine singular -> Ka"),
                GrammarExample("اس کی کتاب", "उसकी किताब", "उसको किताब", "His/Her book", "Kitaab is feminine -> Ki")
            )
        )
    )

    val quizQuestions = listOf(
        QuizQuestion(
            id = "q1",
            promptUrdu = "اردو میں 'شکریہ' کا کیا مطلب ہے؟",
            promptNepali = "उर्दूमा 'شکریہ' (शुक्रिया) को अर्थ के हो?",
            promptEnglish = "What does the Urdu word 'شکریہ' (Shukriya) mean?",
            options = listOf("माफ गर्नुहोस् (Sorry)", "धन्यवाद (Thank you)", "स्वागत छ (Welcome)", "अलविदा (Goodbye)"),
            correctOptionIndex = 1,
            explanationNepali = "'شکریہ' (Shukriya) को अर्थ 'धन्यवाद' (Thank you) हुन्छ।",
            explanationEnglish = "'Shukriya' means 'Thank you' in Urdu.",
            spokenText = "شکریہ"
        ),
        QuizQuestion(
            id = "q2",
            promptUrdu = "اردو زبان کس طرف سے لکھی جاتی ہے؟",
            promptNepali = "उर्दू भाषा कुन दिशाबाट लेखिन्छ?",
            promptEnglish = "In which direction is the Urdu script written?",
            options = listOf("बायाँबाट दायाँतर्फ (Left to Right)", "दायाँबाट बायाँतर्फ (Right to Left)", "माथिबाट तलतिर (Top to Bottom)", "तलबाट माथितिर (Bottom to Top)"),
            correctOptionIndex = 1,
            explanationNepali = "उर्दू नस्तालिक लिपि दायाँबाट बायाँतर्फ (Right to Left) लेखिन्छ।",
            explanationEnglish = "Urdu is written in the Nastaliq script from Right to Left.",
            spokenText = "دائیں سے بائیں"
        ),
        QuizQuestion(
            id = "q3",
            promptUrdu = "لفظ 'اردو' کا تاریخی معنی کیا ہے؟",
            promptNepali = "'उर्दू' शब्दको ऐतिहासिक अर्थ के हो?",
            promptEnglish = "What is the historical meaning of the word 'Urdu'?",
            options = listOf("दरबार (Royal Court)", "छाउनी वा सैन्य शिविर (Army Camp)", "बगैँचा (Garden)", "किताब (Book)"),
            correctOptionIndex = 1,
            explanationNepali = "तुर्की भाषामा 'उर्दू' को अर्थ 'सेनाको छाउनी' (Army Camp) हुन्छ।",
            explanationEnglish = "'Urdu' originates from the Turkic word for 'army camp' or 'camp language'.",
            spokenText = "لشکر یا چھاؤنی"
        ),
        QuizQuestion(
            id = "q4",
            promptUrdu = "اردو عدد 'پانچ' (۵) کو انگریزی میں کیا کہتے ہیں؟",
            promptNepali = "उर्दू अङ्क 'پانچ' (५) लाई अङ्ग्रेजीमा के भनिन्छ?",
            promptEnglish = "What is the Urdu number 'پانچ' (५) in English?",
            options = listOf("Three (3)", "Four (4)", "Five (5)", "Seven (7)"),
            correctOptionIndex = 2,
            explanationNepali = "'پانچ' (Paanch) को अर्थ पाँच (Five - 5) हो।",
            explanationEnglish = "'Paanch' means the number Five (5).",
            spokenText = "پانچ"
        ),
        QuizQuestion(
            id = "q5",
            promptUrdu = "'آپ کیسے ہیں؟' کا صحیح جواب کیا ہے؟",
            promptNepali = "'آپ کیسے ہیں؟' (Aap kaise hain?) को सही उत्तर के हो?",
            promptEnglish = "What is the natural response to 'آپ کیسے ہیں؟' (How are you)?",
            options = listOf("میرا نام علی ہے (मेरो नाम अली हो)", "میں ٹھیک ہوں (म सञ्चै छु)", "یہ کتاب ہے (यो किताब हो)", "خدا حافظ (अलविदा)"),
            correctOptionIndex = 1,
            explanationNepali = "तपाईंलाई कस्तो छ भन्दा 'म सञ्चै छु' (मैं ठीक हूँ - Main theek hoon) भनिन्छ।",
            explanationEnglish = "The natural reply to 'How are you?' is 'Main theek hoon' (I am fine).",
            spokenText = "میں ٹھیک ہوں"
        ),
        QuizQuestion(
            id = "q6",
            promptUrdu = "شاعرِ مشرق کس عظیم شاعر کو کہا جاتا ہے؟",
            promptNepali = "'शायर-ए-मशरिक' (पूर्वका कवि) कुन महान् शायरलाई भनिन्छ?",
            promptEnglish = "Which legendary poet is honored with the title 'Shaair-e-Mashriq' (Poet of the East)?",
            options = listOf("मिर्जा गालिब (Mirza Ghalib)", "अल्लामा मुहम्मद इकबाल (Allama Iqbal)", "फैज अहमद फैज (Faiz)", "मीर तकी मीर (Mir Taqi Mir)"),
            correctOptionIndex = 1,
            explanationNepali = "अल्लामा मुहम्मद इकबाललाई 'शायर-ए-मशरिक' (पूर्वका कवि) मानिन्छ।",
            explanationEnglish = "Allama Muhammad Iqbal is renowned as 'Shaair-e-Mashriq' (Poet of the East).",
            spokenText = "علامہ محمد اقبال"
        ),
        QuizQuestion(
            id = "q7",
            promptUrdu = "اردو میں 'کتاب' مذکر ہے یا مونث؟",
            promptNepali = "उर्दूमा 'کتاب' (किताब) पुल्लिङ्ग हो कि स्त्रीलिङ्ग?",
            promptEnglish = "Is the noun 'کتاب' (Kitaab) masculine or feminine in Urdu?",
            options = listOf("पुल्लिङ्ग (Masculine)", "स्त्रीलिङ्ग (Feminine)", "दुवै हुनसक्छ", "कुनै पनि होइन"),
            correctOptionIndex = 1,
            explanationNepali = "उर्दूमा किताब स्त्रीलिङ्ग (Mu'annas) हो, त्यसैले 'मेरी किताब' (मेरो किताब) भनिन्छ।",
            explanationEnglish = "'Kitaab' is feminine in Urdu, as in 'Meri kitaab' (My book).",
            spokenText = "کتاب مونث ہے"
        ),
        QuizQuestion(
            id = "q8",
            promptUrdu = "اردو حروف تہجی کا پہلا حرف کون سا ہے؟",
            promptNepali = "उर्दू वर्णमालाको पहिलो अक्षर कुन हो?",
            promptEnglish = "What is the first letter of the Urdu alphabet?",
            options = listOf("بے (Bay)", "الف (Alif)", "جیم (Jeem)", "دال (Daal)"),
            correctOptionIndex = 1,
            explanationNepali = "उर्दू वर्णमालाको पहिलो अक्षर 'الف' (Alif) हो।",
            explanationEnglish = "The first letter of the Urdu alphabet is 'Alif' (ا).",
            spokenText = "الف"
        )
    )

    fun getWordOfTheDay(): VocabItem {
        val todayIndex = (System.currentTimeMillis() / (1000 * 60 * 60 * 24) % vocabItems.size).toInt()
        return vocabItems[todayIndex]
    }

    fun getSherOfTheDay(): PoetrySher {
        val todayIndex = (System.currentTimeMillis() / (1000 * 60 * 60 * 24) % poetrySherList.size).toInt()
        return poetrySherList[todayIndex]
    }
}
