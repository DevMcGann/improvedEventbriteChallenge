package com.gsoft.improvedeventbritechallenge.network

import com.gsoft.improvedeventbritechallenge.data.model.Events
import retrofit2.http.GET

interface EventService {

    @GET("destination/organizers/22699500963/events/?expand=image&token=QGSCFRJYOKAA7IDDPMON")
    suspend fun listOrganizerEvents(): Events
}