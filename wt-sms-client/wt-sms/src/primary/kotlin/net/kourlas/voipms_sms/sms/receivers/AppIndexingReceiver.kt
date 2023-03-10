/*
 * VoIP.ms SMS
 * Copyright (C) 2018-2021 Michael Kourlas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.kourlas.voipms_sms.sms.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import net.kourlas.voipms_sms.sms.workers.AppIndexingWorker
import net.kourlas.voipms_sms.utils.logException

/**
 * Broadcast receiver used to forward Firebase app indexing requests to the
 * AppIndexingService.
 */
class AppIndexingReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            AppIndexingWorker.performIndexing(
                context ?: throw Exception("No context provided")
            )
        } catch (e: Exception) {
            logException(e)
        }
    }
}