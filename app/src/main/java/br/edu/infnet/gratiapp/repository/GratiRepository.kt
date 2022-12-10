package br.edu.infnet.gratiapp.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GratiRepository private constructor() {

    companion object {

        lateinit var auth: FirebaseAuth
        private var INSTANCE: GratiRepository? = null

        fun initialize(){
            if(INSTANCE == null){
                INSTANCE = GratiRepository()
            }
            auth = Firebase.auth
        }

        fun get(): GratiRepository {
            return INSTANCE
                ?: throw IllegalStateException("GratiRepository deve ser iniciado.")
        }
    }

    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean{
        if(getCurrentUser()!=null){
            return true
        }
        return false
    }

    fun registerUserWithPassword(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    fun login(email: String, password: String): Task<AuthResult>{
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun logout(){
        auth.signOut()
    }

}