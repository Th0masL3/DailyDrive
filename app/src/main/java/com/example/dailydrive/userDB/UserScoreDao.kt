//package com.example.dailydrive.Database.user
//
//import android.content.ContentValues
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//
//class UserScoreDao(private val database: SQLiteDatabase) {
//
//    fun insertUserScore(userScore: UserScore) {
//        val values = ContentValues().apply {
//            put("userId", userScore.userId)
//            put("gameMode", userScore.gameMode)
//            put("highScore", userScore.highScore)
//            put("date", userScore.date)
//        }
//        database.insert("user_scores", null, values)
//    }
//
//    fun getAllUserScores(): List<UserScore> {
//        val userScores = mutableListOf<UserScore>()
//        val cursor = database.query("user_scores", null, null, null, null, null, null)
//        cursor.use {
//            while (it.moveToNext()) {
//                userScores.add(cursorToUserScore(it))
//            }
//        }
//        return userScores
//    }
//
//    private fun cursorToUserScore(cursor: Cursor): UserScore {
//        return UserScore(
//            userId = cursor.getInt(cursor.getColumnIndex("userId")),
//            gameMode = cursor.getString(cursor.getColumnIndex("gameMode")),
//            highScore = cursor.getInt(cursor.getColumnIndex("highScore")),
//            date = cursor.getString(cursor.getColumnIndex("date"))
//        )
//    }
//}