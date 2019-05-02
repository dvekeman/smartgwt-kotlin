@file:JsQualifier("isc")
package isc

/**
 *  Singleton class with static APIs for managing automatically assigned tab order for
 *   SmartClient components and other focusable elements.
 * 
 *   The TabIndexManager separates the logic required to maintain a sensible tab-order for
 *   a page's components from the logic to handle allocation of actual tab index values.
 *   It is common to have non-focusable components with an implied position in the page's
 *   tab order - for example Layouts containing focusable buttons, or DynamicForms containing
 *   focusable items, and this class handles maintaining relative tab order within such
 *   groups, and supplying explicit TabIndex values for the items which actually need them.
 * 
 *   Entries are registered with the TabIndexManager via the TabIndexManager.addTarget
 *   API. A
 *   numeric tab index for each entry will be lazily generated when requested via
 *   TabIndexManager.getTabIndex. The class provides APIs to modify the position of entries
 *   in the tab tree. When a target is registered, a couple of custom callback functions
 *   can be provided. The first is a notification method for the tab index being updated
 *   (due to, for example, a parent being repositioned and all its children having new
 *   tab indices assigned), and can be used to take an appropriate action such as updating
 *   the tab index of an element in the DOM. The second callback will be fired when a
 *   call to the special TabIndexManager.focusInTarget or
 *   TabIndexManager.shiftFocus API requests focus be passed to an entry. This
 *   allows a developer to take an appropriate action (such as programmatically focussing
 *   in some DOM element).
 * 
 *   See the tabOrderOverview topic for more information on
 *   tab order management for components in SmartClient.
 */
open external class TabIndexManager : Class {
    companion object {
        /**
         *  Creates a new TabIndexManager
         * 
         *  @param typeCheckedProperties {Partial<TabIndexManager>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TabIndexManager} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TabIndexManager = definedExternally
        /**
         *   Register a target to have its tab order position managed by the TabIndexManager.
         * 
         *  @param {string} Unique ID to associate with a tab position. For a Canvas this  would typically be the Canvas.ID but any unique string is valid.
         *  @param {boolean} Is this target directly focusable? Governs whether an   explicit tabIndex will be created for this target. This parameter should be   passed as false for targets which do not require an explicit tabIndex   as they are not focusable, or not explicit tab-stops for the user tabbing through the   page. They will still have an implicit tab order position which   governs where descendants appear, and would be used to generate a tabIndex if   canFocus is subsequently updated via TabIndexManager.setCanFocus.
         *  @param {string=} For cases where the tab position should be treated part of a   group to be moved together, the ID of the parent target containing all members of this   group. An example of this would be a Layout managing the tab order of all its members.   If present, the passed parentID must already be being managed by this TabIndexManager.   May be updated for registered targets via TabIndexManager.moveTarget.
         *  @param {Integer=} Position in the tab-order within the specified parent [or  within top level widgets]. Omitting this parameter will add the target to the end of   the specified parent's tab group.   May be updated for registered targets via TabIndexManager.moveTarget.
         *  @param {TabIndexUpdatedCallback=} This notification method will   be fired when the tabIndex is actually updated, typically due to the target, or some   parent of it being re-positioned in the managed Tab order. In some cases tab indices   may also be updated to make space for unrelated entries being added to the   TabIndexManager. This notification is typically used to update the appropriate element   in the DOM to reflect a new tab index.
         *  @param {ShiftFocusCallback=} This notification method will be   when the special TabIndexManager.shiftFocus method is called to   programmatically move focus through the registered targets (simulating the user tabbing   through elements in the tab index chain). The implementation should attempt to update   the UI state by focusing in the appropriate UI for this target -- typically this means   putting browser focus into a DOM element, and return true to indicate success.   Returning false indicates the element is currently not focusable (disabled, masked, etc),   and cause the TabIndexManager to call the shiftFocusCallback on the next registered   entry (skipping over this entry).   If this method was not supplied, calls to TabIndexManager.shiftFocus will simply skip   this entry.
         */
        fun addTarget(ID: String, canFocus: Boolean, parentID: String?, position: Number?, tabIndexUpdatedCallback: ((ID: String) -> Unit?), shiftFocusCallback: ((ID: String) -> Unit?)): Unit = definedExternally
        /**
         *   Has the specified target been added to this TabIndexManager via
         *   TabIndexManager.addTarget?
         * 
         *  @param {string} Unique ID to test for.
         */
        fun hasTarget(ID: String): Boolean = definedExternally
        /**
         *   Move a target to the newly specified parent / position. This method may change the
         *   calculated tab index for this entry, or other canFocus:true entries which already
         *   have a calculated tabIndex. The registered tabIndexUpdated notification method will
         *   for for any entry where this occurs.
         * 
         * 
         *  @param {string} ID of the target to move
         *  @param {string=} ID of the new parent (if null, will move to the top level)
         *  @param {Integer=} Position within the specified parent. If null will be the  last entry.
         */
        fun moveTarget(ID: String, parentID: String?, position: Number?): Unit = definedExternally
        /**
         *   Move a list of targets to the newly specified parent / position. This method may change the
         *   calculated tab index for these entries, or other canFocus:true entries which already
         *   have a calculated tabIndex. The registered tabIndexUpdated notification method will
         *   for for any entry where this occurs.
         * 
         * 
         *  @param {Array<Partial<string>>} IDs of the targets to move
         *  @param {string=} ID of the new parent (if null, will move to the top level)
         *  @param {Integer=} Position within the specified parent. If null will be added at the end
         */
        fun moveTargets(IDs: Array<dynamic>, parentID: String?, position: Number?): Unit = definedExternally
        /**
         *   Temporarily suppress firing any tabIndexChanged callback passed into
         *   TabIndexManager.addTarget for the
         *   specified targets should their tab index change.
         * 
         *   This is useful for cases where a developer is managing a list of items and wants to
         *   avoid any potential for multiple notifications until the entire list has been managed
         * 
         *  @param {Array<Partial<string>>} targets for which callbacks should be suppressed
         */
        fun suppressCallbacks(targets: Array<dynamic>): Unit = definedExternally
        /**
         *   Resume firing any callbacks suppressed by TabIndexManager.suppressCallbacks
         * 
         *  @param {Array<Partial<string>>} targets for which callbacks should be resumed
         */
        fun resumeCallbacks(targets: Array<dynamic>): Unit = definedExternally
        /**
         *   Removes a target from this TabIndexManager.
         *   Any children of this target will also be removed - developers wishing to preserve
         *   children should first call TabIndexManager.moveTarget to move the children out of this parent
         * 
         *  @param {string} target to remove
         */
        fun removeTarget(ID: String): Unit = definedExternally
        /**
         *   Modifies whether or not some specified target should be treated as focusable and
         *   provide a meaningful TabIndex on a call to TabIndexManager.getTabIndex.
         * 
         *  @param {string} target ID
         *  @param {boolean} new value for canFocus
         */
        fun setCanFocus(ID: String, canFocus: Boolean): Unit = definedExternally
        /**
         *   Returns a tabIndex number for some target ID registered via TabIndexManager.addTarget.
         *   Generated tab indices are guaranteed to be in order.
         * 
         *   As targets are added to, or moved within the TabIndexManager, their tab index may become invalid.
         *   The tabIndexUpdated notification will be fired when this occurs, giving developers
         *   a way to pick up the new tab index, and assign it to the appropriate DOM element if appropriate.
         * 
         *  @param {string} ID of the target for which you want to get a numeric tabIndex.
         */
        fun getTabIndex(ID: String): Number = definedExternally
        /**
         *   Request the TabIndexManager shift focus to a registered focus target.
         * 
         *   This method does not directly change the focus within the DOM - instead it invokes the
         *   shiftFocusCallback registered for the specified target if it is marked as
         *   canFocus:true.
         * 
         *   Returns false if the target had no no shiftFocusCallback,
         *   the shiftFocusCallback returned false, or if the target is marked
         *   as not canFocus:true
         * 
         *  @param {string} target to shift focus to
         */
        fun focusInTarget(ID: String): Boolean = definedExternally
        /**
         *   Method to shift focus to the next registered focusable target.
         * 
         *   This method does not directly change the focus within the DOM - instead it finds the
         *   next target marked as canFocus:true, and invokes the
         *   shiftFocusCallback registered for that target.
         *   This callback is expected to take the appropriate action (typically shifting native
         *   focus to an element in the DOM), and return true (or return false, if the target
         *   could not receieve focus for some reason, in which case we'll find the next
         *   canFocus:true target and repeat the action there.
         * 
         *   Targets with no shiftFocusCallback will be skipped entirely in this process.
         * 
         * 
         *  @param {string} current focus target. If null, focus will be applied to the first  focusable target (or the last if the forward parameter is false).
         *  @param {boolean} should focus move forward to the next focusable target, or  backward to the previous focusable target.
         */
        fun shiftFocus(ID: String, forward: Boolean): Boolean = definedExternally
        /**
         *   Method to shift focus to the next registered focusable target within some group.
         *   This method will move focus forward or backward, considering only the specified
         *   target and any targets within its group (registered as children of the target via
         *   TabIndexManager.addTarget or TabIndexManager.moveTarget).
         * 
         *   The second parameter can be passed to specify an explicit starting position to
         *   shift focus from. If this is not present, this method will attempt to focus into the
         *   group target itself if moving forward (or its last child, if moving backward) and
         *   failing that, shift focus from there.
         * 
         *   This method does not directly change the focus within the DOM - instead it finds the
         *   next target marked as canFocus:true, and invokes the
         *   shiftFocusCallback registered for that target.
         *   This callback is expected to take the appropriate action (typically shifting native
         *   focus to an element in the DOM), and return true (or return false, if the target
         *   could not receieve focus for some reason, in which case we'll find the next
         *   canFocus:true target and repeat the action there.
         * 
         *   Targets with no shiftFocusCallback will be skipped entirely in this process.
         * 
         *   A return value of false indicates that this method was unable to shift focus to a new
         *   target.
         * 
         * 
         *  @param {string} ID of registered target. Focus will be shifted within  this target and its descendants only.
         *  @param {string} Optional ID of current focus target within the group  focus will be shifted in the specified direction from this node.
         *  @param {boolean} should focus move forward to the next focusable target, or  backward to the previous focusable target.
         */
        fun shiftFocusWithinGroup(targetGroup: String, currentTarget: String, forward: Boolean): Boolean = definedExternally
        /**
         *   Method to shift focus to the next registered focusable target beyond some registered
         *   target and any targets registered as children within its group via
         *   TabIndexManager.addTarget or TabIndexManager.moveTarget.
         * 
         *   This method does not directly change the focus within the DOM - instead it finds the
         *   next target marked as canFocus:true, and invokes the
         *   shiftFocusCallback registered for that target.
         *   This callback is expected to take the appropriate action (typically shifting native
         *   focus to an element in the DOM), and return true (or return false, if the target
         *   could not receieve focus for some reason, in which case we'll find the next
         *   canFocus:true target and repeat the action there.
         * 
         *   Targets with no shiftFocusCallback will be skipped entirely in this process.
         * 
         *   A return value of false indicates that this method was unable to shift focus to a new
         *   target.
         * 
         * 
         *  @param {string} ID of registered target. Focus will be shifted to the  next registered focusable element, skipping this group and its descendants.
         *  @param {boolean} should focus move forward to the next focusable target, or  backward to the previous focusable target.
         */
        fun shiftFocusAfterGroup(targetGroup: String, forward: Boolean): Boolean = definedExternally
        /**
         *   Show the current hierarchy of targets passed to TabIndexManager.addTarget together with
         *   current canFocus state and tabIndex (if assigned). Results are output to the developer console.
         * 
         */
        fun showAllocatedTabChain(): Unit = definedExternally
        /**
         *   Get a report of the current hierarchy of targets passed to TabIndexManager.addTarget
         *   together with current canFocus state and tabIndex (if assigned).
         * 
         */
        fun getAllocatedTabChain(): String = definedExternally
    }
}