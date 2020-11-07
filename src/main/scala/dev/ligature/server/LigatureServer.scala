/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package dev.ligature.server

import cats.effect.{ExitCode, IO, IOApp}
import dev.ligature.LigatureInstance
import dev.ligature.store.mock.LigatureMock
import io.vertx.core.Vertx
import io.vertx.ext.web.Router

object LigatureServer extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
     LigatureMock.instance.use { store =>
       IO {
         setupServer(store)
       }
    }.as(ExitCode.Success)

  private def setupServer(ligatureInstance: LigatureInstance): Unit = {
    ligatureInstance.hashCode()
    val vertx = Vertx.factory.vertx()
    val server = vertx.createHttpServer()
    val router = Router.router(vertx)
    //TODO setup router
    server.requestHandler(router).listen(8080)
    ()
  }
}
