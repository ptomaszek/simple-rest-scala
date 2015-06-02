package org.example.invitation.model

import play.api.libs.json.Json


object Invitation {
  case class Invitee(invitee: String, email: String)

  implicit val inviteeJson = Json.format[Invitee]
}
