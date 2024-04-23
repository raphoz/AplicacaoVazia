package br.com.fiap.aplicacaovazia

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CadastroActivity : AppCompatActivity() {
    private var dtNascEditText: EditText? = null
    private var myCalendar: Calendar? = null

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro)

        dtNascEditText = findViewById(R.id.dt_nasc_edit_text)
        myCalendar = Calendar.getInstance()

        // Listener para exibir o DatePickerDialog ao clicar no EditText
        dtNascEditText!!.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun updateLabel() {
        val myFormat = "dd/MM/yyyy" // Formato da data
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        dtNascEditText!!.setText(sdf.format(myCalendar!!.time))
    }

    private fun showDatePickerDialog() {
        val dialog = createDatePickerDialog()
        dialog.show()
    }


    private fun createDatePickerDialog(): DatePickerDialog {
        val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar?.apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, monthOfYear)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLabel()
            }
        }
        val year = myCalendar?.get(Calendar.YEAR) ?: Calendar.getInstance().get(Calendar.YEAR)
        val month = myCalendar?.get(Calendar.MONTH) ?: Calendar.getInstance().get(Calendar.MONTH)
        val dayOfMonth = myCalendar?.get(Calendar.DAY_OF_MONTH) ?: Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            this@CadastroActivity,
            date,
            year,
            month,
            dayOfMonth
        )
    }
    }
    fun DatePickerDialog(
        cadastroAct: CadastroActivity,
        date: DatePickerDialog.OnDateSetListener,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ): DatePickerDialog {
        return DatePickerDialog(
            cadastroAct,
            date,
            year,
            month,
            dayOfMonth
        )
    }
}