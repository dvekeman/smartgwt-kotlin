package sample

import redux.RAction

data class AppEvent(val text: String, var completed: Boolean = false)

data class MainState(val dsName: String?, val isDirty: Boolean = false)

data class AppState(
        val visibilityFilter: VisibilityFilter = VisibilityFilter.SHOW_ALL,
        val appEvents: List<AppEvent> = emptyList(),
        val mainState: MainState = MainState(dsName = null)
)

/** ACTIONS >>> **/
data class AddAppEvent(val appEvent: String) : RAction
data class SetVisibilityFilter(val filter: VisibilityFilter) : RAction

data class MainChangeDataSource(val dsName: String): RAction
class MainStartEdit: RAction
class MainFinishEdit: RAction
/** <<< ACTIONS **/

enum class VisibilityFilter {
    SHOW_ALL
}

// TODO: use combine reducers
fun mainReducer(state: AppState = AppState(), action: RAction): AppState {
    println("mainReducer: Received action '$action'")
    
    return when (action) {

        is SetVisibilityFilter ->
            state.copy(visibilityFilter = action.filter)

        is AddAppEvent ->
            state.copy(appEvents = listOf(AppEvent(action.appEvent)) + state.appEvents)

        is MainChangeDataSource -> 
            state.copy(mainState = state.mainState.copy( dsName = action.dsName ))

        is MainStartEdit ->
            state.copy(mainState = state.mainState.copy( isDirty = true ))

        is MainFinishEdit ->
            state.copy(mainState = state.mainState.copy( isDirty = false ))
        
        // Required for the INIT action ('undefined' :(((((( )
        else -> state
    }
}

