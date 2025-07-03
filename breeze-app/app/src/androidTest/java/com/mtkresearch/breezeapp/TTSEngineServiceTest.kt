package com.mtkresearch.breezeapp

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ServiceTestRule
import com.mtkresearch.breezeapp.service.TTSEngineService
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TTSEngineServiceTest {

    @get:Rule
    val serviceRule = ServiceTestRule()

    companion object {
        const val TAG = "TTSEngineServiceTest"
    }

    @Test
    fun testServiceActivation() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = Intent(context, TTSEngineService::class.java)

        // start TTSEngineService
        val componentName = context.startService(intent)
        assertTrue("start TTSEngineService failed.", componentName.toString().isNotEmpty())

        // bind TTSEngineService
        val binder = serviceRule.bindService(intent)
        val service = (binder as TTSEngineService.LocalBinder).service
        assertTrue("bind TTSEngineService failed.", service != null)

    }


}