package main

import redux.RAction
import redux.combineReducers
import redux.createStore
import redux.rEnhancer

data class AppState(
        val mainState: MainState = MainState(visibleModule = Section.NONE)
)

fun createMainStore() = createStore(
        reducer = combineReducers(
                mapOf(
                        "mainState" to { state: MainState, action: RAction ->
                            mainReducer(state, action)
                        }
                )
        ),
        preloadedState = AppState(),
        enhancer = rEnhancer()
)

