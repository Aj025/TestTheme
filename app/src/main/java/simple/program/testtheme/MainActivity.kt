package simple.program.testtheme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.AdapterView
import android.view.View
import android.widget.Button
import simple.program.testtheme.Utils.changeToTheme


class MainActivity : AppCompatActivity() {
    private var spThemes: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MUST BE SET BEFORE setContentView
        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_main)
        setupSpinnerItemSelection()

        val navigateButton = findViewById<Button>(R.id.btnNavigateActivity)
        navigateButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityTwo::class.java)
            startActivity(intent)
        }
    }

    private fun setupSpinnerItemSelection() {
        spThemes = findViewById<View>(R.id.spThemes) as Spinner
        val app  = application as ThemeApplication
        spThemes?.setSelection(app.currentPosition)
        app.currentPosition = spThemes?.selectedItemPosition ?: 0
        spThemes?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?,
                position: Int, id: Long
            ) {
                if (app.currentPosition != position) {
                    changeToTheme(this@MainActivity, position)
                }
                app.currentPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}