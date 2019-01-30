package main

import redux.*

data class AppEvent(val text: String, var completed: Boolean = false)

data class AppState(
        val appEvents: List<AppEvent> = emptyList(), 
        val mainState: MainState = MainState(visibleModule = Section.NONE)
)

/** ACTIONS >>> **/
data class AddAppEvent(val appEvent: String) : RAction
/** <<< ACTIONS **/

fun mainEnhancer(): Enhancer<AppState, Action, Action, RAction, WrapperAction> {
    return rEnhancer()
}

fun createMainStore() = createStore(
        reducer = combineReducers(
                mapOf(
                        "appEvents" to { state: List<AppEvent>, action: RAction -> 
                            appEvents(state, action) 
                        }
                        , "mainState" to { state: MainState, action: RAction ->
                            mainReducer(state, action)
                        }
                )
        ),
        preloadedState = AppState(),
        enhancer = mainEnhancer()
)

fun appEvents(appEvents: List<AppEvent> = emptyList(), action: RAction) = when (action) {

    is AddAppEvent ->
        listOf(AppEvent(action.appEvent)) + appEvents

    else -> appEvents

}

