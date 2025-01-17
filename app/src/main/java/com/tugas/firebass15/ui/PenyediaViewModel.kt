package com.tugas.firebass15.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tugas.firebass15.MahasiswaApplications
import com.tugas.firebass15.ui.home.viewmodel.DetailViewModel
import com.tugas.firebass15.ui.home.viewmodel.HomeViewModel
import com.tugas.firebass15.ui.home.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(MahasiswaApplications().container.repositoryMhs)
        }
        initializer {
            InsertViewModel(MahasiswaApplications().container.repositoryMhs)
        }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                MahasiswaApplications().container.repositoryMhs
            )
        }
    }

}


fun CreationExtras.MahasiswaApplications(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)