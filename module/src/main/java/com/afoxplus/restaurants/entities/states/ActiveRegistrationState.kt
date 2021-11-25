package com.afoxplus.restaurants.entities.states

import com.afoxplus.restaurants.entities.RegistrationState
import kotlinx.parcelize.Parcelize

interface ActiveRegistrationState : RegistrationState {
    @Parcelize
    private class ActiveRegistrationStateImpl(
        override val code: String,
        override val state: String
    ) : ActiveRegistrationState

    companion object {
        fun build(code: String, state: String): ActiveRegistrationState =
            ActiveRegistrationStateImpl(code, state)
    }
}