/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.utils

import android.content.Context
import mozilla.components.service.fretboard.ExperimentDescriptor
import org.mozilla.focus.FocusApplication
import org.mozilla.focus.web.Config

const val EXPERIMENTS_JSON_FILENAME = "experiments.json"
const val EXPERIMENTS_BASE_URL = "https://settings.prod.mozaws.net/v1"
const val EXPERIMENTS_BUCKET_NAME = "main"
const val EXPERIMENTS_COLLECTION_NAME = "focus-experiments"

val experimentDescriptor = ExperimentDescriptor(Config.EXPERIMENT_DESCRIPTOR_GECKOVIEW_ENGINE)

val Context.application: FocusApplication
    get() = applicationContext as FocusApplication

fun Context.isInExperiment(descriptor: ExperimentDescriptor): Boolean =
        application.fretboard.isInExperiment(this, descriptor)

val Context.activeExperimentIds: List<String>
    get() = application.fretboard.getActiveExperiments(this).map { it.id }
