package org.example.invitation.controller

import org.example.invitation.dao.InvitationFakeDao
import org.example.invitation.model.Invitation.Invitee
import play.api.libs.json._
import play.api.mvc._


object InvitationController extends Controller {

    val inviteeDao = InvitationFakeDao

    def list = Action {
      Ok(Json.toJson(inviteeDao.findAll()))
    }

    def save = Action(BodyParsers.parse.json) {
      request =>
        request.body.validate[Invitee].fold(
          errors => {
            BadRequest(Json.obj("message" -> JsError.toFlatJson(errors)))
          },
          invitee => {
            inviteeDao.add(invitee)
            Created
          }
        )
    }
  }
