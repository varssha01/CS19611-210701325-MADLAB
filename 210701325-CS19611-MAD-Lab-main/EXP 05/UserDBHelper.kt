import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper(context: Context) : SQLiteOpenHelper(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_STUDENT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${DBContract.TABLE_STUDENT}")
        onCreate(db)
    }

    companion object {
        private const val CREATE_TABLE_STUDENT = "CREATE TABLE ${DBContract.TABLE_STUDENT} (" +
                "${DBContract.COLUMN_REGISTER_NUMBER} INTEGER PRIMARY KEY," +
                "${DBContract.COLUMN_NAME} TEXT," +
                "${DBContract.COLUMN_CGPA} REAL)"
    }
}
