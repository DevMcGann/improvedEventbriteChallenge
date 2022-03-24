package com.gsoft.improvedeventbritechallenge.data.repository

import com.gsoft.improvedeventbritechallenge.data.model.Event

interface EventRepository {
    suspend fun getOrganizerEvents(): List<Event>
}