package io.shogun.http.requests

import io.shogun.model.valueobjects.ACLProperties
import zio.json.{DeriveJsonCodec, JsonCodec}


import java.time.LocalDateTime

case class TicketCreateRequest(
                                      name: String,
                                      project: String,
                                      reason: String,
                                      acls: Seq[ACLRequest],
                                      //fulfillment: Fulfillment,
                                      //followers: Option[Seq[TicketUpdateFollower]]
                                    )

case class ACLRequest(
                             properties: ACLProperties,
                             expectedStartAt: Option[LocalDateTime],
                             expiredAt: Option[LocalDateTime] = Some(LocalDateTime.of(1970, 1, 1, 0, 0, 0))
                           )

object TicketCompanyRequest {
  given codec: JsonCodec[TicketCreateRequest] = DeriveJsonCodec.gen[TicketCreateRequest]
}