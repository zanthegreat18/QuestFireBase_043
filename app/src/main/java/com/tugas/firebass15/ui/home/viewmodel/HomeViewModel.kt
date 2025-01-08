package com.tugas.firebass15.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugas.firebass15.model.Mahasiswa
import com.tugas.firebass15.repository.RepositoryMhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

sealed class HomeuiState{
    object Loading: HomeuiState()

    data class Success(val data: List<Mahasiswa>): HomeuiState()

    data class Error(val exception: Throwable): HomeuiState()

}

class HomeViewModel(
    private val repositoryMhs: RepositoryMhs
) : ViewModel(){
    var mhsUiState: HomeuiState by mutableStateOf(HomeuiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs(){
        viewModelScope.launch {
           repositoryMhs.getAllMhs()
               .onStart {
                   mhsUiState = HomeuiState.Loading
               }
               .catch {
                   mhsUiState = HomeuiState.Error(exception = it)
               }
               .collect{
                   mhsUiState = if(it.isEmpty()){
                       HomeuiState.Error(Exception("Data Tidak Ditemukan"))
                   }else{
                       HomeuiState.Success(it)
                   }
               }
        }
    }
}