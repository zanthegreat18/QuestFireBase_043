package com.tugas.firebass15.ui.home.viewmodel

import com.tugas.firebass15.model.Mahasiswa

sealed class DetailUiState {
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    data class Error(val message: Throwable) : DetailUiState()
    object Loading : DetailUiState()
}

