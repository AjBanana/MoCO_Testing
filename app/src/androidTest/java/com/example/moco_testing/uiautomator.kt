package com.example.moco_testing

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


private const val BASIC_SAMPLE_PACKAGE = "com.example.moco_testing"
private const val LAUNCH_TIMEOUT = 5000L


@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 23)
class uiautomator {



    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        // Start from the home screen
        device.pressHome()
        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )
        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE
        ).apply {
            // Clear out any previous instances
            this?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    @Test
    fun test() {

        ////sucht eine TextView mit dem Text "HINZUFÜGEN" und speicher ihn in hinzufuegen
        val hinzufuegen: UiObject = device.findObject(
            UiSelector().className("android.widget.TextView").text("HINZUFÜGEN")
        )

        //Schaltet das Gerät aus und macht es nach 5 sekunden wieder an. kein sleep buffer würde die Kammera öffnen

        device.sleep()
        sleep(2000)
        device.wakeUp()



        //click auf hinzugügen um den frame zu welcheln
        hinzufuegen.click()


        //schreibt MoCo2020 in das Feld Meodell
         var modell = device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/TextFeldModell")
        )
        modell.text = "MoCo2020"

        //schreibt Th-Köln in das Feld Hersteller
        device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/textFeldHersteller").text("Hersteller"
            )
        ).text="TH-Köln"

        //schreibt 12 in das Feld Verbrauch
        device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/textFeldVerbauch").text("Verbauch"
            )
        ).text = "12"

        //schreibt 230 in das Feld PS
        device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/textFeldPS").text("PS"
            )
        ).text = "10"

        //sucht den Button Sumbit und speicher ihn in submit
       val submit : UiObject = device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/buttonSubmit").text("SUBMIT")
        )

        //klickt 3x auf submit (erstellt somit 3 einträge)
        submit.click()
        modell.text = "MoCo2021"
        submit.click()
        modell.text = "MoCo2022"
        submit.click()
        modell.text = "MoCo2023"
        submit.click()
        modell.text = "MoCo2024"
        submit.click()
        modell.text = "MoCo2025"

        //das feld PS bekommt einen neuen wert "250"
        device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/textFeldPS")
        ).text = "250"

        //ein weiterer eintrag wird hinzugefuegt
        submit.click()

        //sucht liste und clickt auf liste um den frame zu welcheln
        val liste: UiObject = device.findObject(
            UiSelector().className("android.widget.TextView").text("LISTE")
        )
        liste.click()

        //sucht den button "ButtonRe" und klickt ihn an, dies läd die RecyclerView neu
        val rebutton: UiObject = device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/ButtonRe")
        )
        rebutton.click()

        //sucht ein scrollable View und sucht in dieser nach einem passenden eintrag, beim finden bleibt er an dieser stelle stehen
        val recyclerView = UiScrollable(UiSelector().scrollable(true))
        recyclerView.scrollIntoView(UiSelector().text("PS: 250"))

        //sucht ein UiObject mit "PS: 250" und überprüft ob dieses da ist
        val zutesten: UiObject = device.findObject(
            UiSelector().resourceId("com.example.moco_testing:id/row_ps").text("PS: 250"))

        assertEquals("PS: 250", zutesten.text)


    }

}



