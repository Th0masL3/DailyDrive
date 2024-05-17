//import android.content.ContentValues
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import com.example.dailydrive.Database.Car
//
//class CarDAO(private val database: SQLiteDatabase) {
//
//    fun insertCar(car: Car) {
//        val values = ContentValues().apply {
//            put("carId", car.carId)
//            put("carImage", car.carImage)
//            put("carCompany", car.carCompany)
//            put("carModel", car.carModel)
//            put("releaseYear", car.releaseYear)
//            put("carTopSpeed", car.carTopSpeed)
//            put("acceleration0To100Kmh", car.acceleration0To100Kmh)
//            put("carMsrp", car.carMsrp)
//        }
//        database.insert("cars", null, values)
//    }
//
//    fun getAllCars(): List<Car> {
//        val cars = mutableListOf<Car>()
//        val cursor = database.query("cars", null, null, null, null, null, null)
//        cursor.use {
//            while (it.moveToNext()) {
//                cars.add(cursorToCar(it))
//            }
//        }
//        return cars
//    }
//
//    fun getCarById(id: Long): Car? {
//        val selection = "id = ?"
//        val selectionArgs = arrayOf(id.toString())
//
//        val cursor = database.query("cars", null, selection, selectionArgs, null, null, null)
//        cursor.use {
//            if (it.moveToFirst()) {
//                return cursorToCar(it)
//            }
//        }
//        return null
//    }
//
//    fun getRandomCar(): Car? {
//        val cursor = database.rawQuery("SELECT * FROM cars ORDER BY RANDOM() LIMIT 1", null)
//        cursor.use {
//            if (it.moveToFirst()) {
//                return cursorToCar(it)
//            }
//        }
//        return null
//    }
///*
//    private fun cursorToCar(cursor: Cursor): Car {
//        return Car(
//            id = cursor.getLong(cursor.getColumnIndex("id")),
//            carId = cursor.getString(cursor.getColumnIndex("carId")),
//            carImage = cursor.getString(cursor.getColumnIndex("carImage")),
//            carCompany = cursor.getString(cursor.getColumnIndex("carCompany")),
//            carModel = cursor.getString(cursor.getColumnIndex("carModel")),
//            releaseYear = cursor.getInt(cursor.getColumnIndex("releaseYear")),
//            carTopSpeed = cursor.getInt(cursor.getColumnIndex("carTopSpeed")),
//            acceleration0To100Kmh = cursor.getDouble(cursor.getColumnIndex("acceleration0To100Kmh")),
//            carMsrp = cursor.getDouble(cursor.getColumnIndex("carMsrp"))
//        )
//    }*/
//}
