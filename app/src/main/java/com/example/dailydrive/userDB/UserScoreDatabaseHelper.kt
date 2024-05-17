//package com.example.dailydrive.Database.user
//
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//
//class UserScoreDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//
//    companion object {
//        private const val DATABASE_NAME = "user_score_database"
//        private const val DATABASE_VERSION = 1
//
//        private const val TABLE_NAME = "user_scores"
//        private const val COLUMN_USER_ID = "userId"
//        private const val COLUMN_GAME_MODE = "gameMode"
//        private const val COLUMN_HIGH_SCORE = "highScore"
//        private const val COLUMN_DATE = "date"
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
//                "$COLUMN_USER_ID INTEGER," +
//                "$COLUMN_GAME_MODE TEXT," +
//                "$COLUMN_HIGH_SCORE INTEGER," +
//                "$COLUMN_DATE TEXT," +
//                "PRIMARY KEY ($COLUMN_USER_ID, $COLUMN_GAME_MODE)" +
//                ")"
//        db.execSQL(createTableQuery)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
//    }
//}