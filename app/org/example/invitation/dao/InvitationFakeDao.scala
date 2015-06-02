package org.example.invitation.dao


import org.example.invitation.model.Invitation.Invitee

import scala.collection.mutable.ListBuffer


object InvitationFakeDao {

  private var inviteesDatastore: ListBuffer[Invitee] = ListBuffer[Invitee]()

  def add(invitee: Invitee) = {
    inviteesDatastore += invitee
  }

  def findAll(): List[Invitee] = {
    inviteesDatastore.toList
  }
}
