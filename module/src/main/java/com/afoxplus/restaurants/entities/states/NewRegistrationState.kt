package com.afoxplus.restaurants.entities.states

import com.afoxplus.restaurants.entities.RegistrationState
import kotlinx.parcelize.Parcelize

interface NewRegistrationState : RegistrationState {
    @Parcelize
    private class NewRegistrationStateImpl(override val code: String, override val state: String) :
        NewRegistrationState

    companion object {
        fun build(code: String, state: String): NewRegistrationState =
            NewRegistrationStateImpl(code, state)
    }
}