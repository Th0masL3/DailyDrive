//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import com.example.dailydrive.Database.Car
//
//class CarDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//
//    companion object {
//        private const val DATABASE_VERSION = 1
//        private const val DATABASE_NAME = "CarDatabase.db"
//        private const val TABLE_NAME = "Cars"
//        private const val COLUMN_CAR_ID = "carId"
//        private const val COLUMN_CAR_IMAGE = "carImage"
//        private const val COLUMN_CAR_COMPANY = "carCompany"
//        private const val COLUMN_RELEASE_YEAR = "releaseYear"
//        private const val COLUMN_CAR_TOP_SPEED = "carTopSpeed"
//        private const val COLUMN_ACCELERATION_0_TO_100 = "acceleration0To100Kmh"
//        private const val COLUMN_CAR_MSRP = "carMsrp"
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//        val createTableQuery = ("CREATE TABLE $TABLE_NAME " +
//                "($COLUMN_CAR_ID INTEGER PRIMARY KEY, " +
//                "$COLUMN_CAR_IMAGE TEXT, " +
//                "$COLUMN_CAR_COMPANY TEXT, " +
//                "$COLUMN_RELEASE_YEAR INTEGER, " +
//                "$COLUMN_CAR_TOP_SPEED INTEGER, " +
//                "$COLUMN_ACCELERATION_0_TO_100 REAL, " +
//                "$COLUMN_CAR_MSRP REAL)")
//        db.execSQL(createTableQuery)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
//    }
//
//    fun addCar(car: Car) {
//        val values = ContentValues()
//        values.put(COLUMN_CAR_ID, car.carId)
//        values.put(COLUMN_CAR_IMAGE, car.carImage)
//        values.put(COLUMN_CAR_COMPANY, car.carCompany)
//        values.put(COLUMN_RELEASE_YEAR, car.releaseYear)
//        values.put(COLUMN_CAR_TOP_SPEED, car.carTopSpeed)
//        values.put(COLUMN_ACCELERATION_0_TO_100, car.acceleration0To100Kmh)
//        values.put(COLUMN_CAR_MSRP, car.carMsrp)
//
//        val db = this.writableDatabase
//        db.insert(TABLE_NAME, null, values)
//        db.close()
//    }
//}