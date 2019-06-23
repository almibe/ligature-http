/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel

import com.google.inject.AbstractModule
import com.google.inject.Guice
import org.libraryweasel.web.Server

fun main() {
    val injector = Guice.createInjector(LibraryWeaselModule())
    val server = injector.getInstance(Server::class.java)
    server.start()
}

class LibraryWeaselModule : AbstractModule() {
    override fun configure() {
        bind(Server::class.java)
    }
}
