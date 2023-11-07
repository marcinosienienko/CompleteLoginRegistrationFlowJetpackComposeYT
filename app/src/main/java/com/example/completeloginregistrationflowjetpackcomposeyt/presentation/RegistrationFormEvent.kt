package com.example.completeloginregistrationflowjetpackcomposeyt.presentation

sealed class RegistrationFormEvent {
    data class EmailChanged(val email: String): RegistrationFormEvent()
    data class PasswordChanged(val password: String): RegistrationFormEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String): RegistrationFormEvent()
    data class AcceptTerms(val isAccepted: Boolean): RegistrationFormEvent()   /// może być błąd (val isAccepted: String)

    object Submit: RegistrationFormEvent()
}
