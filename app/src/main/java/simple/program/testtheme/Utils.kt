package simple.program.testtheme

import android.app.Activity

import android.content.Intent

object Utils {
    private var sTheme = 0

    val THEME_MATERIAL_LIGHT = 0
    val THEME_YOUR_CUSTOM_THEME = 1

    fun changeToTheme(activity: Activity, theme: Int) {
        sTheme = theme
        activity.finish()
        activity.startActivity(Intent(activity, activity.javaClass))
//        activity.overridePendingTransition(
//            R.anim.fade_in,
//            R.anim.fade_out
//        )
    }

    fun onActivityCreateSetTheme(activity: Activity) {
        when (sTheme) {
            THEME_MATERIAL_LIGHT -> activity.setTheme(R.style.Theme_Material_Light)
            THEME_YOUR_CUSTOM_THEME -> activity.setTheme(R.style.Theme_YOUR_CUSTOM_THEME)
            else -> activity.setTheme(R.style.Theme_Material_Light)
        }
    }
}