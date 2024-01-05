package io.shogun.model.entities.tickets

import zio.json.{DeriveJsonCodec, JsonCodec}

import java.time.LocalDateTime

case class Ticket(
                   uuid: String,
                   name: String,
                   project: String,
                   reason: String,
                 )

object TicketCompanyRequest {
  given codec: JsonCodec[Ticket] = DeriveJsonCodec.gen[Ticket]
}