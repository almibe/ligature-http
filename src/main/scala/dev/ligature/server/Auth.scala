/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package dev.ligature.server

import scala.collection.mutable

private object Auth {
  sealed trait AuthType
  object LocalDevNoAuth extends AuthType
  object BasicAuth extends AuthType
  object JwtAuth extends AuthType

  val localDevNoAuth = "--local-dev-no-auth"
  val basicAuth = "--basic-auth"
  val jwtAuth = "--jwt-auth"

  def readAuthType(args: List[String]): Set[AuthType] = {
    val authTypes = mutable.HashSet[AuthType]()
    if (args.contains(localDevNoAuth)) {
      authTypes += LocalDevNoAuth
    }
    if (args.contains(basicAuth)) {
      authTypes += BasicAuth
    }
    if (args.contains(jwtAuth)) {
      authTypes += JwtAuth
    }
    authTypes.toSet
  }
}
