/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.utils

import org.mozilla.focus.BuildConfig
import org.mozilla.focus.web.Config
import org.mozilla.focus.web.GeckoWebViewProvider
import org.mozilla.focus.web.WebViewProvider

object AppConstants {
    private const val BUILD_TYPE_RELEASE = "release"
    private const val PRODUCT_FLAVOR_KLAR = "klar"

    val isKlarBuild: Boolean
        get() = PRODUCT_FLAVOR_KLAR == BuildConfig.FLAVOR_product

    val isReleaseBuild: Boolean
        get() = BUILD_TYPE_RELEASE == BuildConfig.BUILD_TYPE

    val isGeckoBuild: Boolean
        get() = (WebViewProvider.engine == null && Config.DEFAULT_NEW_RENDERER) ||
                (WebViewProvider.engine?.javaClass?.simpleName == GeckoWebViewProvider::class.java.simpleName)

    val isDevBuild: Boolean
        get() = !isReleaseBuild

    fun supportsDownloadingFiles(): Boolean {
        return true
    }
}
