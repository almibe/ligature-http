/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package dev.ligature.server

import cats.effect.{ExitCode, IO, IOApp}

object LigatureServer extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = IO {
    println("hello")
  }.as(ExitCode.Success)
}
