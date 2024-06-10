package org.d3if0025.mobpro01.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.d3if0025.mobpro01.model.Satria
import org.d3if0025.mobpro01.network.ApiStatus
import org.d3if0025.mobpro01.network.SatriaApi


class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Satria>())
        private set
    var status = MutableStateFlow(ApiStatus.LOADING)
        private set
    init {
        retrieveData()
    }
    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.value = ApiStatus.LOADING
            try {
                data.value = SatriaApi.service.getSatria()
                status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }
}