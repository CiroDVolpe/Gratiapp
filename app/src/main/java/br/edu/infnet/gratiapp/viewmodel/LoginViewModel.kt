package br.edu.infnet.gratiapp.viewmodel

import androidx.lifecycle.ViewModel
import br.edu.infnet.gratiapp.repository.GratiRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class LoginViewModel: ViewModel() {

    val repository = GratiRepository.get()

    fun isLoggedIn(): Boolean{
        return repository.isLoggedIn()
    }

    fun login(
        email: String,
        password: String
    ): Task<AuthResult> {
        return GratiRepository.auth.signInWithEmailAndPassword(email, password)
    }

    fun signOn(
        email: String,
        password: String
    ):Task<AuthResult>{
        return repository.registerUserWithPassword(email, password)
    }

}