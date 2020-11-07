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
        val authType = Auth.readAuthType(args)
        setupServer(authType, store)
      }
    }.as(ExitCode.Success)

  private def setupServer(authTypes: Set[Auth.AuthType], ligatureInstance: LigatureInstance): Unit = {
    if (authTypes.isEmpty) {
      throw new RuntimeException(s"Must pass auth type.\n\t${Auth.localDevNoAuth}\n\t${Auth.basicAuth}\n\t${Auth.jwtAuth}")
    }

    val vertx = Vertx.factory.vertx()
    val server = vertx.createHttpServer()
    val router = Router.router(vertx)

    //get all collections
    router.get("/").handler { ctx =>
      ligatureInstance.read.use { tx =>
        IO {
          tx.collections
        }
      }.unsafeRunAsync { cb =>
        ctx.response().end("")
        ???
      }
    }

    //add collection
    router.put("/*").handler { ctx =>
      ligatureInstance.write.use { tx =>
        ???
      }
    }

    //delete collection
    router.delete("/*").handler { ctx =>
      ligatureInstance.write.use { tx =>
        ???
      }
    }

    //add statements
    router.post("/*").handler { ctx =>
      ligatureInstance.write.use { tx =>
        ???
      }
    }

    //delete statements
    router.delete("/*").handler { ctx =>
      ligatureInstance.write.use { tx =>
        ???
      }
    }

    //get all statements
    router.get("/*").handler { ctx =>
      ligatureInstance.read.use { tx =>
        ???
      }
    }

    //query statements
    router.get("/*").handler { ctx =>
      ligatureInstance.read.use { tx =>
        ???
      }
    }

    server.requestHandler(router).listen(8080)
    ()
  }
}
