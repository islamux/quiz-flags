package com.islamux.quizflags

object Constants {
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<QuestionModule>{
        val questionsList = ArrayList<QuestionModule>()

        // Question 1
        val questionOne = QuestionModule(
            1,
            "كم يعبد المسيحي ؟",
            R.drawable.ic_flag_of_argentina,
            "إله واحد ",
            "الهين ",
            "ثلاثة آلهة",
            "اكثر من ذالك",
            4)

        questionsList.add(questionOne)

        // Question 2
        val  questionTwo = QuestionModule(
            2,
            "كم عدد الكتب التي يؤمن بها المسيحي ؟",
            R.drawable.ic_flag_of_australia,
            "واحد ",
            "إثنين ",
            "ثلاثة ",
            "أكثر من ذالك",
            4)
        questionsList.add(questionTwo)

        // Question 3
        val questionThree = QuestionModule( 3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4)
        questionsList.add(questionThree)

        // Question 4
        val questionFour = QuestionModule( 4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2)
        questionsList.add(questionFour)

        // Question 5
        val questionFive = QuestionModule(  5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3)
        questionsList.add(questionFive)

        // Question 6
        val questionSix = QuestionModule( 6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1)
        questionsList.add(questionSix)

        // Question 7
        val questionSeven = QuestionModule(  7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3)
        questionsList.add(questionSeven)

        // Question 8
        val questionEight = QuestionModule(  7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3)
        questionsList.add(questionEight)

        // Question 9
        val questionNine = QuestionModule( 9,
            "What country does this flag belong",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2)
        questionsList.add(questionNine)

        // Question 10
        val questionTen = QuestionModule( 10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1)
        questionsList.add(questionTen)

        return questionsList;
    }
}