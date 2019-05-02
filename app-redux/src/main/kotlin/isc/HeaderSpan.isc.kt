@file:JsQualifier("isc")
package isc

/**
 *  A header span appears as a second level of headers in a ListGrid, spanning one or more
 *   ListGrid columns and their associated headers.
 * 
 *   See ListGrid.headerSpans.
 * 
 *   In addition to the properties documented here, all other properties specified on the
 *   headerSpan object will be passed to the Class.create method of the
 *   ListGrid.headerSpanConstructor. This allows you to set properties such as
 *   Button.baseStyle or StretchImgButton.src directly in a
 *   headerSpan.
 */
open external class HeaderSpan {
    /**
     *  Name for this headerSpan, for use in APIs like ListGrid.setHeaderSpanTitle.
     * 
     *   Name is optional, but if specified, must be unique for this ListGrid (but not globally
     *   unique) as well as a valid JavaScript identifier, as specified by ECMA-262 Section 7.6
     *   (the String.isValidID function can be used to test whether a name is a valid JavaScript
     *   identifier).
     *  @type {Identifier}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  List of fields that this header spans. Fields should be identified by their value for
     *   ListGridField.name.
     * 
     *   Developers may define multiple levels of header-spans by specifying HeaderSpan.spans
     *   however a span cannot be specified with both fields and spans.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var fields: Array<dynamic> = definedExternally
    /**
     *  This property allows developer to "nest" header spans, grouping fields together by
     *   multiple layers of granularity.
     * 
     *   For example a group of fields could be nested within two layers of header spans as follows:
     * 
     * 
     *   { title:"Europe", spans:[
     *     {title:"France", fields:["Paris", "Lyon"]},
     *     {title:"UK", fields:["London", "Glasgow"]},
     *     {title:"Spain", fields:["Barcelona"]}
     *   ]
     *   }
     * 
     * 
     * 
     *   Note that a span definition can not include both spans
     *   and HeaderSpan.fields.
     *  @type {Array<Partial<HeaderSpan>>}
     *  @default null
     */
    open var spans: Array<dynamic> = definedExternally
    /**
     *  A title for this headerSpan, to display in the headerSpan button for this headerSpan
     *   and in other contexts such as the ListGrid.canPickFields.
     * 
     *   Note: if you want to use HTML tags to affect the display of the header, you should do so
     *   via HeaderSpan.headerTitle instead so that other places where the title
     *   appears in the UI are not affected. Refer to discussion at ListGridField.title.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Optional title for the headerSpan button for this headerSpan. If specified this will be
     *   displayed in the headerSpan button instead of HeaderSpan.title. Set to an empty
     *   string to suppress the title in the header button entirely.
     *  @type {string}
     *  @default null
     */
    open var headerTitle: String = definedExternally
    /**
     *  Custom base style to apply to the header button created for this span instead
     *   of ListGrid.headerBaseStyle.
     * 
     *   Note that depending on the header button constructor, you may have to specify
     *   HeaderSpan.headerTitleStyle as well.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerBaseStyle: String = definedExternally
    /**
     *  Custom titleStyle to apply to the header button created for this span instead of
     *   ListGrid.headerTitleStyle.
     * 
     *   Note that this will typically only have an effect if
     *   ListGrid.headerButtonConstructor is set to StretchImgButton or a subclass
     *   thereof.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerTitleStyle: String = definedExternally
    /**
     *  Height of this headerSpan. Defaults to ListGrid.headerSpanHeight.
     *  @type {Integer}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  Vertical alignment of the title of this headerSpan.
     * 
     *   Defaults to listGrid.headerSpanVAlign if unset.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var valign: 
                     /**
                      *  At the top of the container
                      *  Center within container.
                      *  At the bottom of the container
                      */
                     String /* top |  center |  bottom */ = definedExternally
    /**
     *  Horizontal alignment of the title of this headerSpan.
     *  @type {Alignment}
     *  @default "center"
     */
    open var align: 
                    /**
                     *  Center within container.
                     *  Stick to left side of container.
                     *  Stick to right side of container.
                     */
                    String /* center |  left |  right */ = definedExternally
    /**
     *  Should the span title wrap if there is not enough space horizontally to accommodate it.
     *   If unset, default behavior is derived from ListGrid.wrapHeaderSpanTitles. (This
     *   is a soft-wrap - if set the title will wrap at word boundaries.)
     *  @type {boolean}
     *  @default null
     */
    open var wrap: Boolean = definedExternally
}