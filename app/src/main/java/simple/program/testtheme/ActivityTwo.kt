package simple.program.testtheme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.AdapterView
import android.view.View
import android.widget.Button
import simple.program.testtheme.Utils.changeToTheme


class ActivityTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MUST BE SET BEFORE setContentView
        Utils.onActivityCreateSetTheme(this)

        setContentView(R.layout.activity_two)
        val button = findViewById<Button>(R.id.backButton)
        button.setOnClickListener {
            finish()
        }
    }
}