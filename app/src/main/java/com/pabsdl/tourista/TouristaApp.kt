package com.pabsdl.tourista

import android.app.Application
import androidx.annotation.WorkerThread
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.pabsdl.tourista.data.AppDatabase
import com.pabsdl.tourista.data.entities.VisaInformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.nio.charset.Charset

class TouristaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Job() + Dispatchers.Main).
            launch(Dispatchers.IO) {
            seedData()
        }
    }

    @WorkerThread
    private fun seedData() {
        try {
            val dao = AppDatabase
                .getDatabase(applicationContext)
                .visaInformationDao()

            val count = dao.count()
            if (count == Constants.VISA_INFORMATION_COUNT)
                return
            if (count > 0)
                dao.clear()

            val gson = GsonBuilder().create()
            val inputStream =
                applicationContext.assets.open(Constants.VISA_INFORMATION_JSON)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val charset = Charset.availableCharsets()["UTF-8"]!!
            val passportJson = String(buffer, charset)
            val listType = object: TypeToken<ArrayList<VisaInformation>>(){}.type
            val data =
                gson.fromJson<ArrayList<VisaInformation>>(passportJson, listType)

            dao.insert(data)

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}