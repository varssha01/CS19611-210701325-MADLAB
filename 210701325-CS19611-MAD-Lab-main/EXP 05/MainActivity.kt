import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: UserDBHelper
    private lateinit var editTextRegisterNumber: EditText
    private lateinit var editTextName: EditText
    private lateinit var editTextCGPA: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = UserDBHelper(this)
        editTextRegisterNumber = findViewById(R.id.editTextRegisterNumber)
        editTextName = findViewById(R.id.editTextName)
        editTextCGPA = findViewById(R.id.editTextCGPA)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonModify: Button = findViewById(R.id.buttonModify)
        val buttonView: Button = findViewById(R.id.buttonView)
        val buttonDelete: Button = findViewById(R.id.buttonDelete)
        val buttonClear: Button = findViewById(R.id.buttonClear)

        buttonAdd.setOnClickListener { addStudent() }
        buttonModify.setOnClickListener { modifyStudent() }
        buttonView.setOnClickListener { viewStudents() }
        buttonDelete.setOnClickListener { deleteStudent() }
        buttonClear.setOnClickListener { clearFields() }
    }

    private fun addStudent() {
        val registerNumber = editTextRegisterNumber.text.toString().toInt()
        val name = editTextName.text.toString()
        val cgpa = editTextCGPA.text.toString().toDouble()

        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DBContract.COLUMN_REGISTER_NUMBER, registerNumber)
            put(DBContract.COLUMN_NAME, name)
            put(DBContract.COLUMN_CGPA, cgpa)
        }

        val newRowId = db.insert(DBContract.TABLE_STUDENT, null, values)
        if (newRowId != -1L) {
            Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error adding student", Toast.LENGTH_SHORT).show()
        }
    }

    private fun modifyStudent() {
        val registerNumber = editTextRegisterNumber.text.toString().toInt()
        val name = editTextName.text.toString()
        val cgpa = editTextCGPA.text.toString().toDouble()

        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DBContract.COLUMN_NAME, name)
            put(DBContract.COLUMN_CGPA, cgpa)
        }

        val rowsAffected = db.update(
            DBContract.TABLE_STUDENT, values,
            "${DBContract.COLUMN_REGISTER_NUMBER} = ?", arrayOf(registerNumber.toString())
        )

        if (rowsAffected > 0) {
            Toast.makeText(this, "Student modified successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No student found with the given register number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewStudents() {
        val db = dbHelper.readableDatabase
        val projection = arrayOf(
            DBContract.COLUMN_REGISTER_NUMBER,
            DBContract.COLUMN_NAME,
            DBContract.COLUMN_CGPA
        )
        val sortOrder = "${DBContract.COLUMN_REGISTER_NUMBER} ASC"
        val cursor: Cursor = db.query(
            DBContract.TABLE_STUDENT,
            projection,
            null,
            null,
            null,
            null,
            sortOrder
        )

        val stringBuilder = StringBuilder()
        with(cursor) {
            while (moveToNext()) {
                val registerNumber = getInt(getColumnIndexOrThrow(DBContract.COLUMN_REGISTER_NUMBER))
                val name = getString(getColumnIndexOrThrow(DBContract.COLUMN_NAME))
                val cgpa = getDouble(getColumnIndexOrThrow(DBContract.COLUMN_CGPA))
                stringBuilder.append("Register Number: $registerNumber, Name: $name, CGPA: $cgpa\n")
            }
        }
        cursor.close()

        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_LONG).show()
    }

    private fun deleteStudent() {
        val registerNumber = editTextRegisterNumber.text.toString().toInt()
        val db = dbHelper.writableDatabase
        val rowsDeleted = db.delete(
            DBContract.TABLE_STUDENT,
            "${DBContract.COLUMN_REGISTER_NUMBER} = ?",
            arrayOf(registerNumber.toString())
        )

        if (rowsDeleted > 0) {
            Toast.makeText(this, "Student deleted successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No student found with the given register number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearFields() {
        editTextRegisterNumber.text.clear()
        editTextName.text.clear()
        editTextCGPA.text.clear()
    }
}
