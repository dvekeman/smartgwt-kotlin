@file:JsQualifier("isc")
package isc

/**
 *  SmartClient class for loading and playing audio files using the HTML5 &lt;AUDIO&gt;
 *   element.
 */
open external class Sound : BaseWidget {
    /**
     *  URL of the audio file to be played by this sound instance. If multiple file URLs are
     *   supplied, the browser will make use of the first file type for which it has support.
     *  @type {string | Array<Partial<string>>}
     *  @default null
     */
    open var src: dynamic = definedExternally
    /**
     *  Should the specified Sound.src be loaded automatically.
     * 
     *   If set to false developers may load the audio explicitly via
     *   Sound.load
     *  @type {boolean}
     *  @default false
     */
    open var autoLoad: Boolean = definedExternally
    /**
     *  Should the specified Sound.src be played automatically?
     * 
     *   If set to false developers may play the audio explicitly via
     *   Sound.play.
     *  @type {boolean}
     *  @default false
     */
    open var autoPlay: Boolean = definedExternally
    /**
     *   Update the Sound.src of this sound instance at runtime. Note that
     *   Sound.autoLoad and Sound.autoPlay govern whether this media will
     *   be loaded or played immediately when the src value is changed.
     * 
     *  @param {string | Array<Partial<string>>} URL of new audio file to be played by this sound instance.
     */
    open fun setSrc(src: dynamic): Unit = definedExternally
    /**
     *   This method will cause the Sound.src to be loaded
     * 
     *  @param {CanPlayCallback=} notification to fire when the file is ready to play
     */
    open fun load(canPlayCallback: (() -> Unit?)): Unit = definedExternally
    /**
     *   Play the audio file.
     *   If necessary the file will be loaded first.
     * 
     *  @param {PlaybackCompleteCallback=} notification fired when playback completes
     */
    open fun play(playbackCompleteCallback: (() -> Unit?)): Unit = definedExternally
    /**
     *   Pause playback of the audio file.
     * 
     */
    open fun pause(): Unit = definedExternally
    /**
     *   If playback is currently paused, reset the playback position to the start of the audio
     *   file so a call to Sound.play will play from the start, rather than resuming
     *   playback from the current position.
     * 
     */
    open fun reset(): Unit = definedExternally
    /**
     *   Notification method fired repeatedly to indicate a change in currentTime
     *   value while an audio file is playing.
     * 
     *  @param {Float} Current playback position in seconds.
     */
    open fun timeChanged(currentTime: Number): Unit = definedExternally
    /**
     *   Retrieves the duration of the current audio file in seconds.
     * 
     */
    open fun getDuration(): Number = definedExternally
    /**
     *   Retrieves the current playback time of a playing or paused audio file in seconds.
     * 
     */
    open fun getCurrentTime(): Number = definedExternally
    /**
     *   Move playback to a particular time in a loaded audio file.
     * 
     *  @param {Float} time to move to. This method will have no effect if the file has not been loaded or no Sound.src element is defined.
     */
    open fun setCurrentTime(time: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Sound
         * 
         *  @param typeCheckedProperties {Partial<Sound>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Sound} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Sound = definedExternally
        /**
         *   Returns true for browsers which natively support HTML5 Audio, used by the
         *   Sound class
         * 
         */
        fun isSupported(): Boolean = definedExternally
        /**
         *   Convenience method to load and play a specified audio file.
         * 
         *   For more explicit control over loading and playback of audio files, developers may
         *   create an instance of Sound and call methods directly on that object.
         * 
         *  @param {string} URL of the audio clip to play
         *  @param {PlaybackCompleteCallback=} callback to execute when the clip playback completes
         */
        fun play(src: String, playbackCompleteCallback: (() -> Unit?)): Unit = definedExternally
    }
}