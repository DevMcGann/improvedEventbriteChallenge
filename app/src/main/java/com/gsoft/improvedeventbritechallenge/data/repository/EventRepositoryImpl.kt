package com.gsoft.improvedeventbritechallenge.data.repository

import com.gsoft.improvedeventbritechallenge.data.model.Event
import com.gsoft.improvedeventbritechallenge.network.EventService

class EventRepositoryImpl (
    val apiService: EventService
        )  : EventRepository {

    override suspend fun getOrganizerEvents(): List<Event> {
        return apiService.listOrganizerEvents().events
    }
}