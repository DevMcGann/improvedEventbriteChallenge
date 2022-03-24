package com.gsoft.improvedeventbritechallenge.ui.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gsoft.improvedeventbritechallenge.data.repository.EventRepository
import com.gsoft.improvedeventbritechallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsRepository: EventRepository,
) : ViewModel() {

    fun fetchEvents() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(eventsRepository.getOrganizerEvents()))
        }catch(e:Exception){
            emit(Resource.Failure(e))
        }
    }

}
