package io.shogun.http.endpoints

import io.shogun.http.requests.TicketCreateRequest
import io.shogun.model.entities.tickets.Ticket
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import sttp.tapir.json.zio.*

trait TicketEndpoints {
  val createEndpoint =
    endpoint
      .tag("Ticket")
      .name("create ticket")
      .description("create a new ticket")
      .post
      .in("ticket")
      .in(jsonBody[TicketCreateRequest])
      .out(jsonBody[Ticket])

  val getAllEndpoint =
    endpoint
      .tag("ticket")
      .name("get all tickets")
      .description("get all tickets")
      .get
      .in("tickets")
      .out(jsonBody[List[Ticket]])

  val getByIdEndpoint =
    endpoint
      .tag("tickets")
      .name("get ticket by id")
      .description("get a ticket by its id")
      .get
      .in("tickets" / path[String]("id"))
      .out(jsonBody[Option[Ticket]])
}

