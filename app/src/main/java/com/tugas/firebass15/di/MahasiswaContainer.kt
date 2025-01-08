package com.tugas.firebass15.di

import com.google.firebase.firestore.FirebaseFirestore
import com.tugas.firebass15.repository.NetworkRepositoryMhs
import com.tugas.firebass15.repository.RepositoryMhs


interface AppContainer{
    val repositoryMhs: RepositoryMhs
}

class MahasiswaContainer : AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}