package br.edu.infnet.gratiapp.application

import android.app.Application
import br.edu.infnet.gratiapp.repository.GratiRepository

class GratiappApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GratiRepository.initialize()
    }
}