package sample.containers

import react.*
import react.redux.rConnect
import redux.RAction
import redux.WrapperAction
import sample.AppState
import sample.MainChangeDataSource
import sample.components.MainListGrid
import sample.components.MainListGridProps

interface MainListGridStateProps : RProps {
    var dsName: String?
}

interface MainListGridDispatchProps : RProps {
    var onChangeDataSource: (String) -> Unit
}

private val mapStateToProps: MainListGridProps.(AppState, MainListGridStateProps) -> Unit = { state, props ->
    dsName = state.mainState.dsName
}

private val mapDispatchToProps: MainListGridDispatchProps.((RAction) -> WrapperAction, MainListGridStateProps) -> Unit = { dispatch, props ->
    onChangeDataSource = { ds -> (dispatch.invoke(MainChangeDataSource(ds))) }
}

private val c = rConnect<AppState, RAction, WrapperAction, MainListGridStateProps, MainListGridProps, MainListGridDispatchProps, MainListGridProps>(mapStateToProps, mapDispatchToProps)(MainListGrid::class.js as RClass<MainListGridProps>)

class VisibleMainListGrid(props: MainListGridStateProps) : RComponent<MainListGridStateProps, RState>(props) {
    override fun RBuilder.render() {
        c {
            attrs.dsName = props.dsName
        }
    }
}

fun RBuilder.visibleMainListGrid() = child(VisibleMainListGrid::class) {

}