@file:JsQualifier("isc")
package isc

/**
 *  Metadata about a DataSourceField, including its type and validators.
 */
open external class DataSourceField {
    /**
     *  See DataSource.tableCode.
     *  @type {string}
     *  @default null
     */
    open var fkTableCode: String = definedExternally
    /**
     *  See DataSource.tableCode.
     *  @type {string}
     *  @default null
     */
    open var fkColumnCode: String = definedExternally
    /**
     *  See DataSource.tableCode.
     *  @type {string}
     *  @default null
     */
    open var columnCode: String = definedExternally
    /**
     *  Name for this field.
     * 
     *   Must be unique across all fields within the DataSource as well as a valid JavaScript
     *   identifier - see FieldName for details and how to check for validity.
     * 
     *   The field name is also the property in each DataSource record which holds the value for this
     *   field.
     *  @type {FieldName}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  Type of this field. Required for all DataSource fields.
     * 
     *   Field type may imply automatic validators (for example, an integer field cannot accept the
     *   value "foo"). Field type also affects the default behaviors of DataBound components, for
     *   example, if a field is declared as type "date", components that edit that field will
     *   automatically choose a date-editing interface with pop-up date picker.
     *  @type {FieldType}
     *  @default null
     */
    open var type: 
                   /**
                    *  Generic text, e.g. "John Doe". This is the default field type.          Use field.length to set length.
                    *  A boolean value, e.g. true
                    *  A whole number, e.g. 123
                    *  A floating point (decimal) number, e.g. 1.23
                    *  A logical date, with no time value (such as a holiday or birthday).          Represented on the client as a JavaScript Date object where
                    *            time values are ignored. See dateFormatAndStorage for more
                    *            information on date display and serialization formats.
                    *  A time of day, with no date. Represented on the client as a JavaScript          Date object in UTC/GMT by default (see also
                    *            dateFormatAndStorage and the Time class).
                    *  A date and time, accurate to the second. Represented on the client as a           JavaScript Date object. See also
                    *            dateFormatAndStorage.
                    *  A text value constrained to a set of legal values specified by the          field's DataSourceField.valueMap, as though a
                    *            ValidatorType of "isOneOf" had been declared.
                    *  An enum whose values are numeric.
                    *  If you are using the SmartClient SQL datasource connector, a          sequence is a unique, increasing whole number, incremented
                    *            whenever a new record is added. Otherwise, sequence behaves
                    *            identically to integer. This type is typically used with
                    *            field.primaryKey to auto-generate unique primary keys.
                    *            See also DataSourceField.sequenceName and
                    *            DataSource.sequenceMode
                    *  A string representing a well-formed URL. Some components          will render this as an HTML link (using an anchor tag for example).
                    *  A string representing a well-formed URL that points to an          image. Some components will render an IMG tag with the value of this field
                    *            as the 'src' attribute to render the image.
                    *  Arbitrary binary data. When this field type is present, three additional fields are automatically generated. They are: &lt;fieldName&gt;_filename, &lt;fieldName&gt;_filesize, and
                    *   &lt;fieldName&gt;_date_created where &lt;fieldName&gt; is the value of the name
                    *   attribute of this field. These fields are marked as
                    *   DataSourceField.hidden:true to suppress their rendering by default. You
                    *   can show one or more of these fields by specifying the field with a hidden:false
                    *   override in the fields array of the databound component.
                    *   Stream / view file support for custom DataSources: a custom DataSource or DMI
                    *   must implement the "viewFile" and "downloadFile" operationTypes and return a single Record
                    *   with a byte[] as the field value for the binary field. For more detail see
                    *   the overview of binaryFields.
                    *  Binary data comprising an image. Causes ViewFileItem to be used          when the field is displayed in a form, allowing the image to optionally
                    *            be displayed inline.
                    *  Fields of this type can contain any data value and have no default           formatting or validation behavior. This is useful as the
                    *            SimpleType.inheritsFrom for SimpleTypes
                    *            where you do not want any of the standard validation or formatting logic
                    *            to be inherited from the standard built-in types.
                    *  Synonymous with "any".
                    *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" and "update"
                    *            operations. By default, fields of this type are hidden and not editable;
                    *            the server ignores any value that the client sends in a field of this type.
                    *            Note that the "authenticated user" can be set explicitly on the server-side
                    *            RPCManager using the setUserId() method, or it can come from
                    *            the servlet API if you are using its built-in authentication scheme. See
                    *            the server-side Javadocs for RPCManager.
                    *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of "add" and "update"
                    *            operations. By default, fields of this type are hidden and not editable;
                    *            the server ignores any value that the client sends in a field of this type.
                    *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" operations.
                    *            By default, fields of this type are hidden and not editable;
                    *            the server ignores any value that the client sends in a field of this type.
                    *            The notes about type "modifier" also apply to fields of this type.
                    *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of an "add" operation (when
                    *            the record is first created). By default, fields of this type are hidden
                    *            and not editable; the server ignores any value that the client sends in a
                    *            field of this type.
                    *  Same as "text", but causes PasswordItem to be used by default for          editing (hides typed-in value).
                    *  A special field type specifically for use with Unicode data in conjunction          with the Microsoft SQL Server database. Field type "ntext" implies the
                    *            use of DataSourceField.sqlStorageStrategy "ntext";
                    *            other than that, this type is identical to "text"
                    *  An integer number with locale-based formatting, e.g. 12,345,678.          See localizedNumberFormatting
                    *            for more info.
                    *  A float number with locale-based formatting, e.g. 12,345.67.          See localizedNumberFormatting
                    *            for more info.
                    *  A float number with locale-based formatting and using currency          symbol, e.g. $12,345.67.
                    *            See localizedNumberFormatting
                    *            for more info.
                    *  A telephone number. Uses FormItem.browserInputType "tel" to          hint to the device to restrict input. On most mobile devices that have
                    *            software keyboards, this cause a specialized keyboard to appear which
                    *            only allows entry of normal phone numbers. When displayed read-only,
                    *            a "phoneNumber" renders as an HTML link with the "tel:" URL scheme,
                    *            which will invoke the native phone dialing interface on most mobile
                    *            devices. In addition, the CSS style "sc_phoneNumber" is applied.
                    * 
                    *            By default, "phoneNumber" fields do not include validators, however the
                    *            following validator definition would limit to digits, dashes and the
                    *            "+" character:
                    *            xml:
                    * 
                    *            &lt;validator type="regexp" expression="^(\(?\+?[0-9]\*\)?)?[0-9_\- \(\)]\*$"
                    *              errorMessage="Phone number should be in the correct format e.g. +#(###)###-##-##" /&gt;
                    * 
                    * 
                    *              or directly in JavaScript:
                    * 
                    * 
                    *   {type:"regexp", expression:"^(\\(?\\+?[0-9]\*\\)?)?[0-9_\\- \\(\\)]\*$", 
                    *     errorMessage:"Phone number should be in the correct format e.g. +#(###)###-##-##"}
                    * 
                    * 
                    * 
                    *            and adding "#" and "\*" to the regular expressions above would allow for
                    *            users to enter special keys sometimes used for extension numbers or
                    *            pauses
                    */
                   String /* text |  boolean |  integer |  float |  date |  time |  datetime |  enum |  intEnum |  sequence |  link |  image |  binary |  imageFile |  any |  custom |  modifier |  modifierTimestamp |  creator |  creatorTimestamp |  password |  ntext |  localeInt |  localeFloat |  localeCurrency |  phoneNumber */ = definedExternally
    /**
     *  For a binaryFields, sets a fixed mime type for all files stored
     *   to this field. Should be set to a standard mime type string, for example, "text/plain" for
     *   a .txt file.
     * 
     *   This is useful if a binary field only stored one type of file and you chose not to store
     *   filenames, since the extension of the file name is normally used to determine the mime type.
     *  @type {string}
     *  @default null
     */
    open var mimeType: String = definedExternally
    /**
     *  Indicates this field must be non-null in order for a record to pass validation. Or, in the
     *   case of a "binary" field, a non-empty file must be uploaded. Setting this property has the
     *   same effect as giving the field a ValidatorType.
     * 
     *   Note that required should not be set for a server-generated field, such as a
     *   sequence, or validation will fail on the client.
     *   Conditionally required fields
     *   Adding an Validator.applyWhen condition to a required
     *   validator introduces subtle complexities to the process of validating an existing record.
     *   The client is not guaranteed to know the the full and complete state of the record it is
     *   editing because it is common for a DynamicForm to be editing a subset of
     *   fields. When a field is unconditionally required, things are simple: if the
     *   DynamicForm has a FormItem for that field, then the required validation
     *   passes if that FormItem has a value, and fails if it does not. If the form has no FormItem
     *   for the field, it can assume that the field has a value because otherwise it would have
     *   failed validation when we attempted to add it (when we are adding a record, we of course do
     *   know the full and complete state of the record - it is whatever we are about to add).
     * 
     *   When a field is conditionally required, the client can no longer assume that all
     *   required fields will have a value. It may be the case that the condition of requirement
     *   was not met when the record was added, but now it is. For example, consider these field
     *   definitions:
     *    &lt;field name="yearsAtCurrentAddress" type="integer" /&gt;
     *    &lt;field name="previousAddress" type="text" &gt;
     *     &lt;validator type="required" errorMessage="Previous address is required if you have been at your current address less than three years"&gt;
     *      &lt;applyWhen operator="and"&gt;
     *       &lt;criteria&gt;
     *        &lt;criterion fieldName="yearsAtCurrentAddress" operator="lessThan" value="3" /&gt;
     *       &lt;/criteria&gt;
     *      &lt;/applyWhen&gt;
     *     &lt;/validator&gt;
     *    &lt;/field&gt;
     * 
     *   Imagine a record for this DataSource is added where the user has entered a value of "3" for
     *   "yearsAtCurrentAddress", and no previous address. Later, the value of that field is
     *   changed to "2". If this is done using a form that is also showing the "previousAddress"
     *   field, we will know that "previousAddress" has not been provided, so we can fail the
     *   validation and the user will get a helpful error message explaining what the problem is.
     * 
     *   However, if the form does not also show the "previousAddress" field, we may choose to use an
     *   OperationBinding that uses OperationBinding.outputs to trim the
     *   record down to just the fields the form does contain, in the interests of avoiding
     *   information leakage. Or perhaps that value is automatically culled from the record before
     *   the client sees it by the application of a DataSourceField.viewRequires.
     *   Whatever the reason, if the client does not have the complete record, it is not possible
     *   for the client to sensibly apply this validation. And because the client has no way of
     *   knowing if a value is missing because it is genuinely null, or because it has been trimmed
     *   away by the server, we must treat any null value with suspicion (unless it has a matching
     *   FormItem - the presence of the FormItem means that the user can edit the value, so it
     *   would make no sense to pair it with a trimmed record that excludes that field value).
     * 
     *   When this happens, we mark the validation as having passed on the client, but in need of
     *   running on the server. The server validation makes use of the "storedRecord" facility
     *   (look for the description of $storedRecord in the
     *   velocitySupport) to overlay the changed record on
     *   top of the existing record as it currently exists in the database. This gives the validator
     *   the complete record including both changed and unchanged values, so it is able to carry
     *   out the required check in a meaningful way. However, you should be aware that the
     *   combination of conditional "required" validators and DynamicForms that edit partial
     *   records can result in a validation that cannot run on the client and must do both a server
     *   roundtrip and a database fetch.
     *  @type {boolean}
     *  @default null
     */
    open var required: Boolean = definedExternally
    /**
     *  The required message when a field that has been marked as
     *   DataSourceField.required is not filled in by the user.
     * 
     *   Note that this setting wins over DataSource.requiredMessage if both are set.
     *  @type {string}
     *  @default null
     */
    open var requiredMessage: String = definedExternally
    /**
     *  Indicates that values for this field are automatically generated by the database or ORM
     *   provider. Setting this flag makes the field behave somewhat like a
     *   DataSourceField.sequenceName, in that server-side logic does not expect client code
     *   to provide values for the field on "add" operations. However, it is not entirely the same
     *   as a sequence:
     * 
     *  - Sequences must be integers, whereas autoGenerated fields can be of any type
     * 
     *  - SmartClient Server's DataSource implementations are capable of discovering the value
     *     that was generated by the database for sequence fields, which may not be possible
     *     with an autoGenerated field. See the docs for
     *     DataSourceField.customInsertExpression for a discussion
     *     of this
     * 
     *   Unrelated to the autoGenerated flag, you have a general ability for field
     *   values to be generated by application code (as opposed to being generated by the database
     *   or ORM provider). For example, you can use dmiOverview,
     *   serverScript, or customQuerying. (Note,
     *   if you want to have application code generate values for primaryKey fields, you may need to
     *   use an OperationBinding that specifies
     *   OperationBinding.providesMissingKeys).
     *  @type {boolean}
     *  @default null
     */
    open var autoGenerated: Boolean = definedExternally
    /**
     *  Controls whether an explicit null-valued Record attribute for this field
     *   should result in xsi:nil being used to transmit the value when serializing
     *   to XML, like so:
     * 
     *   &lt;book&gt;
     *     &lt;title&gt;Beowulf&lt;/title&gt;
     *     &lt;author xsi:nil="true"/&gt;
     *   &lt;/book&gt;
     * 
     *   If nillable is not set, no XML element will be generated for
     *   the explicit null value.
     *  @type {boolean}
     *  @default null
     */
    open var nillable: Boolean = definedExternally
    /**
     *  A ValueMap is a set of legal values for a field.
     * 
     *   The valueMap can be specified as either an Array of legal values, or as an
     *   Object where each property maps a stored value to a user-displayable value.
     * 
     *   To enforce that a field should be constrained to only the values in the valueMap, either
     *   declare DataSourceField.type as "enum", or use a
     *   ValidatorType of "isOneOf" with explicitly listed values. Otherwise,
     *   although a normal SelectItem control will only allow values from the valueMap to be
     *   entered, other controls such as a ComboBoxItem will allow other values
     *   to be entered.
     * 
     *   In XML, a valueMap that specifies only a list of legal values is specified as follows:
     * 
     *    &lt;valueMap&gt;
     *    &lt;value&gt;Pens &amp; Pencils&lt;/value&gt;
     *    &lt;value&gt;Stationery&lt;/value&gt;
     *    &lt;value&gt;Computer Products&lt;/value&gt;
     *    &lt;value&gt;Furniture&lt;/value&gt;
     *    &lt;value&gt;Misc&lt;/value&gt;
     *    &lt;/valueMap&gt;
     * 
     *   A ValueMap that specifies stored values mapped to user-visible values is specified as
     *   follows:
     * 
     *    &lt;valueMap&gt;
     *    &lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;
     *    &lt;value ID="2"&gt;Stationery&lt;/value&gt;
     *    &lt;value ID="3"&gt;Computer Products&lt;/value&gt;
     *    &lt;value ID="4"&gt;Furniture&lt;/value&gt;
     *    &lt;value ID="5"&gt;Misc&lt;/value&gt;
     *    &lt;/valueMap&gt;
     * 
     *  @type {ValueMap}
     *  @default null
     */
    open var valueMap: dynamic = definedExternally
    /**
     *  Fully qualified Java className of an Enum that should be used to derive this field's
     *   ValueMap.
     * 
     *   This has the same behavior of auto-deriving a valueMap from a Java Enum as
     *   DataSource.autoDeriveSchema except it applies only to one field.
     * 
     *   If you enable autoDeriveSchema there is no need to set
     *   valueMapEnum for Enum fields unless you want to actually override the
     *   behavior to use a different Enum for the field (eg, a superclass Enum that is more
     *   restrictive).
     *  @type {string}
     *  @default null
     */
    open var valueMapEnum: String = definedExternally
    /**
     *  Validators to be applied to this field.
     * 
     *   Validators are applied whenever there is an attempt to save changes to a field.
     * 
     *   For the available set of built-in validators, and how to define a custom validator, see the
     *   Validator class.
     *  @type {Array<Partial<Validator>>}
     *  @default null
     */
    open var validators: Array<dynamic> = definedExternally
    /**
     *  Maximum number of characters allowed. Applicable only to fields of text type.
     *   For fields of this type a ValidatorType will be automatically
     *   generated on both the client and server side to enforce this maximum length
     *   (unless such a validator is explicitly present for the field already).
     * 
     *   The TextItem.enforceLength attribute can also
     *   explicitly limit user input for freeform text items editing fields with an explicit
     *   length specified.
     * 
     *   NOTE: For DataSources of type "sql", this property has a bearing on the type of
     *   column we use when the underlying table is created by a DataSource
     *   sqlDataSource in the adminConsole. Below
     *   a certain length (which is database-specific, see below), we use standard VARCHAR
     *   columns; above that length, we use an alternate strategy (again, database-specific). For
     *   these long fields, we sometimes also generate different SQL for "update" and "add"
     *   operations, using JDBC "?" replacement parameters rather than embedding values directly in
     *   the generated SQL; whether or not this is done depends entirely on what the underlying
     *   database product and/or JDBC driver will allow.
     * 
     *   Table of field length limits for supported databases:
     * 
     *   Database product
     *     VARCHAR limit \*
     *     Type used above limit
     *   HSQLDBNone-
     *   IBM DB24000CLOB
     *   Firebird32767BLOB with subtype 1
     *   Informix255 / 32739LVARCHAR / TEXT \*\*
     *   Microsoft SQL Server 8000TEXT
     *   MySQL 255 / 65535 / 16M TEXT / MEDIUMTEXT / LONGTEXT \*\*\*
     *   Oracle4000CLOB
     *   PostgreSQL4000TEXT
     * 
     *   \* The "VARCHAR limit" referred to here is a limit used by the SmartClient Server; it
     *   is not necessarily imposed by the database. For example, DB2's VARCHAR limit is not 4000
     *   characters; it actually varies from about 4K to about 32K, depending on how the server has
     *   been configured.
     *   \*\* Informix has a limit of just 255 characters for VARCHAR, but has a native LVARCHAR
     *   type which supports nearly 32K characters without needing to fall back on long datatypes.
     *   Therefore, with that one product, we have two thresholds for a change in storage type.
     *   \*\*\* MySQL has a limit of 255 characters for VARCHAR, 65,535 characters for TEXT and
     *   16,777,215 for MEDIUMTEXT; therefore, with that one product, we have three thresholds for a
     *   change in storage type.
     *  @type {number}
     *  @default null
     */
    open var length: Number = definedExternally
    /**
     *  XPath expression used to retrieve the field's value.
     * 
     *   This XPath expression will be evaluated in the scope of the record objects selected by
     *   the DataSource.recordXPath. For XML data
     *   (DataSource.dataFormat) this means a call to
     *   XMLTools.selectString passing the selected XML element. For JSON data
     *   (DataSource.dataFormat), this means a call to
     *   XMLTools.selectObjects passing the selected JSON object.
     * 
     *   In the absence of a valueXPath, for JSON data the value for the field will
     *   be the value of the same-named property in the record object selected by
     *   DataSource.recordXPath.
     * 
     *   For XML data, the value will be the attribute or subelement named after the field name.
     *   For example, for a field "author" on a record element &lt;book&gt;, the following structures
     *   require no valueXPath:
     * 
     *    &lt;book author="Mark Jones"/&gt;
     * 
     *    &lt;book&gt;
     *      &lt;author&gt;Mark Jones&lt;/author&gt;
     *    &lt;/book&gt;
     * 
     * 
     *   If valueXPath is not required for your field because of the default handling
     *   described above, don't specify it, as it's slightly slower.
     * 
     *   To learn about XPath, try the following search:
     *   http://www.google.com/search?q=xpath+tutorial
     * 
     *   Using valueXPath with the SmartClient server
     * 
     *   If you're using the SmartClient server to return data via the DSResponse object (or
     *   indirectly doing so using DataSource DMI), the valueXPath you specify on the DataSource
     *   fields will be applied to the data you return via the
     *   JXPath library.
     * 
     *   If you are returning Java Beans as your DSResponse data, normally each dataSource field
     *   receives the value of the same-named Java Bean property, that is, a field "zipCode" is
     *   populated by looking for "getZipCode()" on the objects passed as DSResponse data. You can
     *   use valueXPath to retrieve properties from subobjects, so long as a chain of
     *   getter methods exists that corresponds to the valueXPath. For example, a valueXPath of
     *   "address/zipCode" expects to call "getAddress()" on the bean(s) passed to
     *   DSResponse.setData(), followed by "getZipCode()" on whatever object "getAddress()" returns.
     * 
     *   When you are saving data, the inbound DSRequest values, available as a Java Map, will use
     *   just dataSource field names as Map keys, not the valueXPath used to derive them. However,
     *   to achieve bidirectional valueXPath binding, you can use the server-side method
     *   dataSource.setProperties() to use the valueXPath when setting properties on your server
     *   object model. When applied as a setter, an XPath like "address/zipCode" attempts
     *   "getAddress()" followed by "setZipCode()" on the returned object. JXPath also has some
     *   ability to auto-create intervening objects if they are missing, such as auto-creating an
     *   "address" subobject when applying "address/zipCode" as a valueXPath.
     * 
     *   See the
     *   JXPath library documentation for
     *   complete details, including other types of server object models supported, such as
     *   server-side XML.
     *  @type {XPathExpression}
     *  @default null
     */
    open var valueXPath: String = definedExternally
    /**
     *  Alternative XPath expression used to set the field's value.
     * 
     *   If is not set, then DataSourceField.valueXPath is
     *   used, see its description for details.
     *  @type {XPathExpression}
     *  @default null
     */
    open var valueWriteXPath: String = definedExternally
    /**
     *  A Callback, function, or JavaScript expression used to retrieve the field's value from
     *   the XML element or JSON record returned from a web service.
     * 
     *   This is an advanced attribute for use when a DataSourceField.valueXPath
     *   setting is insufficient to derive a field's value, yet an implementation of
     *   DataSource.transformResponse is overkill.
     * 
     *   For the required parameters, see the documentation for
     *   Callbacks.GetFieldValueCallback.
     *  @type {GetFieldValueCallback}
     *  @default null
     */
    open var getFieldValue: ((record: dynamic, value: dynamic, field: DataSourceField, fieldName: String) -> Unit) = definedExternally
    /**
     *  Indicates that getting DataSourceField.valueXPath for this field should
     *   not perform any validation at all and will return null for non existing XPaths.
     *   Otherwise warning message will be logged for non-existing XPath or with null objects
     *   in the middle of XPath.
     * 
     *   NOTE: this applies to server-side processing of valueXPath only.
     *  @deprecated \* No longer needs to be set since the framework now defaults to suppressing errors for null values in the middle of Xpath, and only invalid XPath will cause warning be logged.
     *  @type {boolean}
     *  @default null
     */
    open var lenientXPath: Boolean = definedExternally
    /**
     *  Default user-visible title for this field.
     * 
     *   This will be picked up by DataBound components and other views over this DataSource.
     * 
     *   Note this property frequently does not need to be set since DataSource.autoDeriveTitles (on by
     *   default) usually picks an appropriate user-visible title if you have a reasonable naming convention
     *   for your field names.
     * 
     *   Note that if this field is being displayed in a ListGrid bound to this dataSource,
     *   the ListGridField.headerTitle attribute may be used to specify a
     *   different string for display in the listGrid column header.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  When data values are displayed in DataBound components, by default strings will be interpreted
     *   as HTML by the browser in most cases.
     * 
     *   If set, this property will be picked up by components bound to this dataSource, notifying them
     *   that any HTML characters should be escaped when displaying values for this field.
     *  @type {boolean}
     *  @default null
     */
    open var escapeHTML: Boolean = definedExternally
    /**
     *  If false, this property indicates that this field is considered "server only". This means:
     * 
     * 
     *  - Components cannot bind to the field; even if you explicitly add a field with the same
     *     name to your DataBoundComponent, it will be dropped
     * 
     *  - If you are using SmartClient Server, the client will never be sent a value for the
     *     field
     * 
     *  - If you are using SmartClient Server, then similar to DataSourceField.canEdit, no updates
     *     to the field are allowed from the client. If you explicitly add a value for the field
     *     to, eg, a record you are passing to DataSource.updateData, the server will strip
     *     the value out of the record before processing the update request.
     * 
     *   canView:false is not the same thing as DataSourceField.hidden. Use
     *   canView:false when you want to prevent the client from ever seeing a field's
     *   definition or values; use hidden:true if it is fine from a security perspective
     *   that a field's definition and values are sent to the browser, but the field should not by
     *   default appear in user interface elements (but could do in some cases, like a special screen
     *   for advanced users or administrators, for example).
     * 
     *   Note that this property must be set explicitly to false to have an effect; a null or
     *   undefined setting is treated the same as true.
     * 
     *   This property is used to implement field-level view security: failing a
     *   DataSourceField.viewRequiresAuthentication,
     *   DataSourceField.viewRequiresRole or DataSourceField.viewRequires test is
     *   equivalent to setting canView:false on the field (and, indeed, from the
     *   client's perspective, the field has had canView:false set).
     *  @type {boolean}
     *  @default null
     */
    open var canView: Boolean = definedExternally
    /**
     *  Controls whether, by default, DataBoundComponents consider this field editable.
     *   Set to false to draw this field read-only.
     * 
     *   For a field that should never be changed from the UI, consider using DataSourceField.canSave instead,
     *   which will both mark a field as non-editable and reject any attempt to programmatically
     *   change the value on the server (when using the SmartClient Server).
     * 
     *   This attribute may not effect all dataBoundComponents - the
     *   DataBoundComponent.canEditFieldAttribute may be set at the component level to look
     *   for a different attribute on the dataSourceField, and components allow developers to explicitly
     *   override this default (see ListGridField.canEdit. FormItem.canEdit for example).
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  Whether values in this field can be updated and saved to the dataSource.
     * 
     *   If set to false, this field will default to being non-editable in standard editing
     *   components (DynamicForm, editable ListGrid), but will be editable when displayed
     *   for filtering purposes only (in a SearchForm or ListGrid.showFilterEditor. If DataSourceField.canEdit is explicitly specified it will take
     *   precedence over this client-side behavior, but the server will still enforce the no-save
     *   policy (described below).
     * 
     *   NOTE: If you are using SmartClient Server and have specified canSave: false
     *   for a field in a DataSource definition (.ds.xml file), this is enforced on
     *   the server. This means that we will strip out any attempt to set the value of such a
     *   field before trying to process any update or add request, similar to what happens when
     *   a DataSourceField.editRequiresAuthentication fails.
     *  @type {boolean}
     *  @default null
     */
    open var canSave: Boolean = definedExternally
    /**
     *  Should the user be able to filter data by this field?
     *   Affects whether this field will show up in dataBoundComponents with UI for filtering data.
     * 
     *  @type {boolean}
     *  @default null
     */
    open var canFilter: Boolean = definedExternally
    /**
     *  Sets the default FormItem to be used whenever this field is edited (whether in a grid, form,
     *   or other component).
     * 
     *   If unset, a FormItem will be automatically chosen based on the type of the field, by the
     *   rules explained FormItemType.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var editorType: String = definedExternally
    /**
     *  Sets the default FormItem to be used if this field is marked as
     *   DataSourceField.canEdit and displayed in an editor component such
     *   as a DynamicForm.
     * 
     *   This property may also be specified at the type level by specifying
     *   SimpleType.readOnlyEditorType.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var readOnlyEditorType: String = definedExternally
    /**
     *  Sets the default FormItem to be used for this field if it appears in a filter row,
     *   and DataSourceField.canFilter is not false.
     * 
     *   Note: If this is not specified, the edit-formItem type may be derived from the
     *   DataSourceField.editorType property, or from the field's DataSourceField.type.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var filterEditorType: String = definedExternally
    /**
     *  The default date formatter to use for displaying this field. Only applicable to fields of
     *   type "date" and "datetime". Note that this property is honored when exporting directly to
     *   Excel spreadsheets (ie, when using XLS or XLSX/OOXML form, not CSV); "date" and
     *   "datetime" fields with this property set will deliver real dates and formatting information
     *   to Excel, rather than formatted strings or unformatted dates.
     *  @deprecated \* Use DataSourceField.dateFormatter or DataSourceField.timeFormatter  instead.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var displayFormat: 
                            /**
                             *  Default native browser 'toString()' implementation. May vary by browser.
                             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
                             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
                             *   Example: Friday, November 04, 2005 11:03:00 AM
                             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
                             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
                             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
                             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
                             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
                             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
                             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
                             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
                             * 
                             * 
                             *   Note: In addition to these standard formats, custom formatting can be set by passing
                             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
                             *   function will then be executed whenever the appropriate formatter method is called [eg
                             *   Date.toNormalDate], in the scope of the date instance in question.
                             * 
                             *   Custom formatting can also be applied by passing a FormatString instead of a
                             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
                             *   the FormatString docs for details.
                             */
                            String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = definedExternally
    /**
     *  Preferred display format to use for date type values within this field.
     *   If this property is set on a field displayed in a databound component such as a
     *   DynamicForm or ListGrid it will be respected (See FormItem.dateFormatter and
     *   ListGridField.dateFormatter).
     * 
     *   Note that this property is also honored when exporting directly to
     *   Excel spreadsheets (ie, when using XLS or XLSX/OOXML form, not CSV); "date" and
     *   "datetime" fields with this property set will deliver real dates and formatting information
     *   to Excel, rather than formatted strings or unformatted dates.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateFormatter: 
                            /**
                             *  Default native browser 'toString()' implementation. May vary by browser.
                             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
                             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
                             *   Example: Friday, November 04, 2005 11:03:00 AM
                             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
                             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
                             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
                             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
                             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
                             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
                             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
                             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
                             * 
                             * 
                             *   Note: In addition to these standard formats, custom formatting can be set by passing
                             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
                             *   function will then be executed whenever the appropriate formatter method is called [eg
                             *   Date.toNormalDate], in the scope of the date instance in question.
                             * 
                             *   Custom formatting can also be applied by passing a FormatString instead of a
                             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
                             *   the FormatString docs for details.
                             */
                            String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = definedExternally
    /**
     *  Preferred time-format to apply to date type values within this field. If this property is
     *   specified on a field displayed within a dataBound component such as a ListGrid or
     *   DynamicForm, any dates displayed in this field will be formatted as times using the
     *   appropriate format.
     * 
     *   This is most commonly only applied to fields specified as type "time" though
     *   if no explicit FormItem.dateFormatter is specified it will be respected for other
     *   fields as well.
     * 
     *   See ListGridField.timeFormatter and FormItem.timeFormatter for more information.
     *  @type {TimeDisplayFormat}
     *  @default null
     */
    open var timeFormatter: 
                            /**
                             *  String will display with seconds and am/pm indicator:[H]H:MM:SS am|pm.
                             *   Example: 3:25:15 pm
                             *  String will display with seconds in 24 hour time: [H]H:MM:SS.
                             *   Example: 15:25:15
                             *  String will display with seconds, with a 2 digit hour and am/pm indicator:
                             *   HH:MM:SS am|pm
                             *   Example: 03:25:15 pm
                             *  String will display with seconds, with a 2 digit hour in 24 hour format:
                             *   HH:MM:SS
                             *   Examples: 15:25:15, 03:16:45
                             *  String will have no seconds and be in 12 hour format:[H]H:MM am|pm
                             *   Example: 3:25 pm
                             *  String will have no seconds and be in 24 hour format: [H]H:MM
                             *   Example:15:25
                             *  String will have no seconds and will display a 2 digit hour, in 12 hour clock format:
                             *   HH:MM am|pm
                             *   Example: 03:25 pm
                             *  String will have no seconds and will display with a 2 digit hour in 24 hour clock format:
                             *   HH:MM
                             *   Examples: 15:25, 03:16
                             */
                            String /* toTime |  to24HourTime |  toPaddedTime |  toPadded24HourTime |  toShortTime |  toShort24HourTime |  toShortPaddedTime |  toShortPadded24HourTime */ = definedExternally
    /**
     *  Applies only to fields of type "float" and affects how many significant digits are shown.
     * 
     *   For example, with decimalPrecision 3, if the field value is 343.672677, 343.673 is shown.
     * 
     *   If the value is 125.2, 125.2 is shown - decimalPrecision will not cause extra zeros to be
     *   added. Use DataSourceField.decimalPad for this.
     * 
     *   A number is always shown with its original precision when edited.
     *  @type {number}
     *  @default null
     */
    open var decimalPrecision: Number = definedExternally
    /**
     *  Applies only to fields of type "float" and enforces a minimum number of digits shown after
     *   the decimal point.
     * 
     *   For example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10
     *   if decimalPad is 2.
     * 
     *   The original unpadded value is always shown when the value is edited.
     *  @type {number}
     *  @default null
     */
    open var decimalPad: Number = definedExternally
    /**
     *  Applies only to fields of type "float" or "integer" and affects how many significant
     *   digits are shown.
     * 
     *   For example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10
     *   if precision is 5.
     * 
     *   The original value is always shown when the value is edited.
     *  @type {number}
     *  @default null
     */
    open var precision: Number = definedExternally
    /**
     *  Whether this field should be hidden from users by default within a DataBound component.
     *   This is generally used for internal IDs and other fields not meaningful to users.
     * 
     *   See DataSourceField.detail for fields that should be hidden in a summary view such as
     *   a ListGrid, but still available to the user.
     * 
     *   NOTE: This property is not a security setting - data for hidden fields is
     *   still delivered to the client, it just isn't shown to the user. If you wish to make sure
     *   that only appropriate data reaches the client, use OperationBinding.outputs,
     *   DataSourceField.canView:false on the field, or a field-level declarative security setting like
     *   DataSourceField.viewRequiresRole.
     *  @type {boolean}
     *  @default false
     */
    open var hidden: Boolean = definedExternally
    /**
     *  Whether this field should be completely excluded from this dataSource, as if it had never been
     *   defined.
     * 
     *   If set to true, the field will be entirely omitted when serving a DataSource derived
     *   from a server-side definition (typically a .ds.xml file) to the client.
     *  @type {boolean}
     *  @default false
     */
    open var ignore: Boolean = definedExternally
    /**
     *  Whether this field should be considered a "detail" field by a DataBoundComponent.
     * 
     *   Detail fields won't be shown by default in a DataBoundComponent where
     *   DataBoundComponent.showDetailFields is false. This allows for some DataBound
     *   components, like a ListGrid, to show a summary view of records which displays only
     *   the most commonly viewed fields by default, while other DataBoundComponents, like a
     *   DetailViewer, show all fields by default.
     * 
     *   In addition, the FormItem.showIf property is supported in multiple
     *   components for conditional visibility - see for example ListGridField.showIf and
     *   FormItem.showIf).
     *  @type {boolean}
     *  @default false
     */
    open var detail: Boolean = definedExternally
    /**
     *  If true, then this field is excluded from the bound component's view state. In addition,
     *   the field will not be selected as the default title field
     *   by DataBoundComponent.getTitleField
     *   if DataBoundComponent.titleField is not provided.
     *  @type {boolean}
     *  @default null
     */
    open var excludeFromState: Boolean = definedExternally
    /**
     *  Text to be used for display by client-side components when this field has a null or
     *   undefined value. This value will be overridden by a component's emptyCellValue, if set.
     *  @type {HTMLString}
     *  @default null
     */
    open var emptyDisplayValue: String = definedExternally
    /**
     *  Indicates either that this field holds a value unique across all records in this
     *   DataSource, or that it is one of a number of fields marked as primary keys, and the
     *   combination of the values held in all of those fields is unique across all records in the
     *   DataSource. Note that the latter usage - so-called "composite" or "multipart" keys - is
     *   intended for support of legacy databases only: if you are able to choose an approach,
     *   Isomorphic recommends the use of one primaryKey field per DataSource, and
     *   ideally this field should be of DataSourceField.type "sequence". If you have
     *   control of the underlying tables, there is nothing to stop you from adding a field like
     *   this (a so-called "synthetic" or "surrogate" key), even for tables that already have a set
     *   of columns that could combine to make a composite key (a so-called "natural" key). Also,
     *   it is neither necessary nor correct to use a composite primaryKey because you want to
     *   enforce uniqueness across that combination of fields. You can achieve that by declaring
     *   a unique constraint in the table schema, or use an ValidatorType
     *   validator with validator.criteriaFields, or both; there is no need to use a
     *   composite key to enforce uniqueness
     * 
     *   Note that composite primaryKeys are not supported in tree-structured datasets
     *   (Tree and ResultTree) or components (TreeGrid,
     *   ColumnTree). Tree-structured data requires that nodes have a unique
     *   Tree.idField, with the parent/child relationship expressed through the
     *   Tree.parentIdField. This implies that binding a Tree to a DataSource
     *   requires that the DataSource have a singular primaryKey, and that the primaryKey field is
     *   also the idField, as described in the treeDataBinding
     * 
     *   A DataSource that can only perform the "fetch" operation does not require a
     *   primaryKey unless it contains binaryFields. If a DataSource
     *   allows modification of DataSource records through add, update and remove DataSource
     *   operations, or it contains one or more binary fields, one or more fields must be marked as
     *   the primary key.
     * 
     *   SmartClient requires a primary key value to uniquely identify records when communicating
     *   updates or deletions to the server. There is no requirement that the primaryKey field be
     *   mapped to an actual "primary key" in your object model, web service, or database (though
     *   this is the most obvious and natural thing to do, of course). The only requirement is
     *   that the combined values of the primaryKey fields be unique for a given browser instance
     *   for the lifetime of the page.
     * 
     *   If using SmartClient's sqlDataSource and generating SQL tables using
     *   the dbConfigTool, the table column generated from a
     *   primaryKey field will have a unique constraint applied in the database table and, if the field
     *   is of type "sequence", the database column will also be created as an "identity column" in those
     *   databases that implement sequence-type handling with identity columns.
     *  @type {boolean}
     *  @default false
     */
    open var primaryKey: Boolean = definedExternally
    /**
     *  Declares that this field holds values that can be matched to values from another DataSource
     *   field, to create a relationship between records from different DataSources or even records
     *   within the same DataSource.
     * 
     *   The format of foreignKey is
     *   dataSourceId.fieldName.
     * 
     *   For a foreignKey within the same dataSource, you can omit the dataSourceId
     *   and just specify fieldName. For example, to create a tree relationship
     *   within a DataSource:
     * 
     *    isc.DataSource.create({
     *     ID:"supplyItem",
     *     fields : [
     *      {name:"itemId", type:"sequence", primaryKey:true},
     *      {name:"parentId", type:"integer", foreignKey:"itemId"},
     *      ...
     *     ]
     *    });
     * 
     * 
     *   foreignKey declarations also allow other automatic behaviors by
     *   DataBoundComponent, such as ListGrid.fetchRelatedData.
     * 
     *   For SQLDataSources foreign keys can be automatically discovered from SQL tables if
     *   DataSource.autoDeriveSchema is set.
     *  @type {string}
     *  @default false
     */
    open var foreignKey: String = definedExternally
    /**
     *  If true, this property indicates that this field will hold an explicit array of child nodes
     *   for the current node.
     *   This has the same effect as specifying DataSource.childrenField to this field's
     *   name.
     *  @type {boolean}
     *  @default false
     */
    open var childrenProperty: Boolean = definedExternally
    /**
     *  For a field that is a foreignKey establishing a tree relationship, what value indicates a
     *   root-level node. Defaults to null.
     * 
     *   Note that the rootValue may be overridden on a specific ResultTree instance by setting
     *   ResultTree.rootNode, or if the ResultTree is auto-generated by a TreeGrid,
     *   by setting TreeGrid.treeRootValue. This allows a component to navigate a subtree of
     *   the hierarchical data from this dataSource starting at a particular node.
     *  @type {any}
     *  @default null
     */
    open var rootValue: dynamic = definedExternally
    /**
     *  For a DataSource with DataSource.serverType with a field of type
     *   "sequence", the name of the SQL sequence that should be used when inserting new records into
     *   this table.
     * 
     *   Note that this is never required for SQL tables that are generated from SmartClient
     *   DataSources (a default sequence name of tableName + "_" + columnName is chosen, but see the
     *   notes below regarding this), and is never required for databases where inserting null into a
     *   sequence column is sufficient (MySQL, SQL Server, DB2 and others).
     * 
     *   You would only need to set sequenceName if you are integrating with a pre-existing table
     *   stored in a database where the sequence must be named for insertion to work (Oracle,
     *   Postgres, Firebird) OR you are trying to use the same sequence across multiple DataSources.
     * 
     *   Note: If you specify the sql.{database type}.sequence.name.prefix and/or
     *   sql.{database type}.sequence.name.suffix properties in your
     *   server_properties file,the generated sequence name will include the prefix and/or
     *   suffix. For example, with a prefix of "order_system_" and a suffix of "_seq", the sequence
     *   generated for column "orderNumber" on table "orders" would be:
     *     order_system_orders_orderNumber_seq
     * 
     *  @type {string}
     *  @default null
     */
    open var sequenceName: String = definedExternally
    /**
     *  For a field of FieldType "sequence" on a DataSource with
     *   DataSource.serverType, this flag indicates that the field is
     *   implicitly bound to a sequence. This setting means that SmartClient does not expect to
     *   find a value for the field in "add" operations, even if it is marked as a
     *   DataSourceField.primaryKey, as such fields usually are. It also means that SmartClient
     *   does not attempt to retrieve the field value from an actual database sequence, instead
     *   relying on the JDBC driver to return the generated value (see the note on
     *   sequenceMode below).
     * 
     *   Implicitly bound columns are a syntactic convenience provided by some databases to simulate
     *   the "auto-increment" or "identity" columns available natively in other products, without
     *   the underlying sequence having to be explicitly referenced in SQL queries. Currently, these
     *   database products support this idea:
     * 
     *  - PostgreSQL has had a "serial" column type for a long time -
     * 
     *   http://www.postgresql.org/docs/9.3/static/datatype-numeric.html#DATATYPE-SERIAL
     * 
     *  - DB2 has long supported a "GENERATED AS IDENTITY" notation for numeric fields. This may
     *   or may not be implemented with a sequence - the documentation does not specify - but we
     *   support it via the implicitSequence mechanism because it is so similar to the implicit
     *   sequence approach in Oracle.
     * 
     *   http://publib.boulder.ibm.com/infocenter/dzichelp/v2r2/index.jsp?topic=%2Fcom.ibm.db2z10.doc.apsg%2Fsrc%2Ftpc%2Fdb2z_identitycols.htm
     * 
     *  - Oracle introduced a "GENERATED AS IDENTITY" notation for numeric fields in version 12c -
     * 
     *   http://www.oracle-base.com/articles/12c/identity-columns-in-oracle-12cr1.php
     * 
     *   If you have columns like these in your database, declare them as type "sequence" and mark
     *   them with the implicitSequence flag.
     * 
     *   NOTE: If you use this property, you should also set the
     *   DataSource.sequenceMode to "jdbcDriver". This is necessary
     *   because SmartClient cannot directly query the implicit sequence that is being used behind the
     *   scenes, so we must rely on the JDBC driver to do that.
     * 
     *   If you use DataSource.autoDeriveSchema to automatically derive a
     *   dataSource from table metadata, SmartClient attempts to identify these special Oracle and
     *   Postgres columns by heuristic examination of the metadata. When it identifies such a
     *   column, it marks the corresponding dataSourceField implicitSequence: true,
     *   and changes the sequenceMode on the DataSource to "jdbcDriver". If your table contains
     *   one of these columns and SmartClient does not automatically identify it, bear in mind that
     *   you can always set this flag manually, even if you are using autoDeriveSchema.
     * 
     *   This setting has no effect for non-SQL dataSources, or for databases other than those
     *   mentioned above.
     *  @type {boolean}
     *  @default null
     */
    open var implicitSequence: Boolean = definedExternally
    /**
     *  Indicates this field should be fetched from another, related DataSource.
     * 
     *   The incluedFrom attribute should be of the form
     *   "dataSourceId.fieldName", for example:
     * 
     *    &lt;field includeFrom="supplyItem.itemName"/&gt;
     * 
     * 
     *   A DataSourceField.foreignKey declaration must exist between the two DataSources, establishing either
     *   a 1-to-1 relationship or a many-to-1 relationship from this DataSource to the related
     *   DataSource. The inclusion can be indirect (traverse multiple DataSources) so long as there
     *   is a chain of foreignKey declarations from the target DataSource to the
     *   DataSource where the includeFrom field is declared. For including from a
     *   related DataSource where there are multiple related records, see
     *   DataSourceField.includeSummaryFunction.
     * 
     *   DataSourceField.name will default to the name of the included field, or you can
     *   specify a different name.
     * 
     *   If both DataSources are SQLDataSources, HibernateDataSources or JPADataSources (with
     *   Hibernate as the provider) the related data will be retrieved via a SQL join and criteria
     *   and sort directions applied to the field work normally (they become part of the generated
     *   SQL query).
     * 
     *   Otherwise, the related data will be retrieved via performing a DSRequest against
     *   the related DataSource once the data from the primary DataSource has been retrieved. In
     *   this case, criteria or sorting directions applied to the included field are only allowed if
     *   data paging is not in use (for example ListGrid.dataFetchMode:"basic"); otherwise,
     *   criteria and sort direction are ignored for the included field and a warning is logged on
     *   the server.
     * 
     *   Editing included fields
     * 
     *   An included field is DataSourceField.canEdit by default. Note that
     *   included fields are not updatable, even if you set canEdit:true; the server will simply drop
     *   values for included fields if client code sends them.
     * 
     *   When thinking about editing an included field value, typically what is really intended is to
     *   edit the value of the foreignKey field. For example, take the scenario of a
     *   system that tracks accounts and the employees assigned to manage them. Given a DataSource
     *   "account" related one-to-one with DataSource "employee" by a "managerId" foreignKey field,
     *   we might declare an includeFrom so that the name of the account manager can
     *   be shown with each "account" record.
     * 
     *   Editing the manager's name while viewing the account would be intended to pick a new account
     *   manager, and not to change the legal name of the employee who happens to be the
     *   current account manager.
     * 
     *   To correctly set up this scenario, declare an includeFrom field that is hidden,
     *   but is used as the DataSourceField.displayField for the foreign key
     *   field:
     * 
     *   &lt;field name="managerId" foreignKey="employee.id" displayField="managerName" /&gt;
     *   &lt;field name="managerName" includeFrom="employee.name" hidden="true"/&gt;
     * 
     *   Now:
     * 
     * 
     *  - the "managerId" foreignKey field is shown in grids and forms, but takes its displayed
     *   value from the hidden includeFrom field. Note that when the
     *   foreignKey and displayField are specified, the
     *   framework automatically defaults DataSourceField.useLocalDisplayFieldValue to
     *   true to ensure the displayed value is picked up from the record being edited.
     * 
     *  - the automatically chosen editor will be a SelectItem with
     *   SelectItem.optionDataSource set to "employees": it will allow
     *   picking a different "employee" record from the "employee" DataSource.
     * 
     *  - saving will save the ID of a new "employee" record to the "managerId" foreign key
     *   field, as intended
     * 
     * 
     *   You can alternatively set editorType="ComboBoxItem" on the
     *   "managerId" field to allow typeahead search of the "employee" DataSource.
     * 
     *   Note that the DataSourceField.foreignDisplayField attribute allows developers to have a different
     *   fieldName be used locally as a displayField from the field name for the display field
     *   in the foreign dataSource.
     *  @type {string}
     *  @default null
     */
    open var includeFrom: String = definedExternally
    /**
     *  For a field that uses DataSourceField.includeFrom, specifies which
     *   DataSourceField.foreignKey field should be used to find records in the
     *   related DataSource.
     * 
     *   includeVia only needs to be set when you have more than one
     *   foreignKey to the same related DataSource. If you have multiple
     *   foreignKeys to multiple different DataSources, there is no need to set
     *   includeVia.
     * 
     *   For example, perhaps you have a DataSource "moneyTransfer" where each record represents a
     *   money transfer, where the source and payment currencies are different, and the list of
     *   currencies is stored in a related DataSource "currency". Each "moneyTransfer" record is
     *   linked to 2 "currency" records, through two different foreignKey fields,
     *   "sourceCurrencyId" and "paymentCurrencyId".
     * 
     *   The following declarations would be required to use includeFrom to get a
     *   include the field "currencySymbol" from each of the two related "currency" records.
     * 
     *    &lt;field name="sourceCurrencyId" foreignKey="currency.id"/&gt;
     *    &lt;field name="paymentCurrencyId" foreignKey="currency.id"/&gt;
     *    &lt;field name="sourceCurrencySymbol" includeFrom="currency.currencySymbol" includeVia="sourceCurrencyId"/&gt;
     *    &lt;field name="paymentCurrencySymbol" includeFrom="currency.currencySymbol" includeVia="paymentCurrencyId"/&gt;
     * 
     * 
     *   SQL Templating and includeVia
     * 
     *   The includeVia feature uses SQL table aliases in the generated SQL when generating multiple SQL joins
     *   to the same SQL table. When using customQuerying, it's sometimes necessary to know
     *   the names of the aliases in the generated SQL. The table alias used can be configured via
     *   setting DataSourceField.relatedTableAlias on the foreignKey field, for
     *   example, using the declarations below, aliases "source" and "payment" would be used for the
     *   two "currency" tables.
     * 
     *    &lt;field name="sourceCurrencyId" foreignKey="currency.id" relatedTableAlias="source"/&gt;
     *    &lt;field name="paymentCurrencyId" foreignKey="currency.id" relatedTableAlias="payment"/&gt;
     *    &lt;field name="sourceCurrencySymbol" includeFrom="currency.currencySymbol" includeVia="sourceCurrencyId"/&gt;
     *    &lt;field name="paymentCurrencySymbol" includeFrom="currency.currencySymbol" includeVia="paymentCurrencyId"/&gt;
     * 
     * 
     *   Multiple indirection and relatedTableAlias
     * 
     *   Sometimes you may have two includeFrom fields that include a field which is itself included from
     *   another DataSource, for example:
     * 
     *    &lt;field name="sourceCurId" nativeName="sourceCurrencyId" foreignKey="currency.id" relatedTableAlias="source"/&gt;
     *    &lt;field name="sourceCurrencySymbol" includeFrom="currency.currencySymbol" includeVia="sourceCurId"/&gt;
     *    &lt;field name="sourceCurrencyGroup" includeFrom="currency.groupName" includeVia="sourceCurId"/&gt;
     *    &lt;field name="paymentCurId" nativeName="paymentCurrencyId" foreignKey="currency.id" relatedTableAlias="payment"/&gt;
     *    &lt;field name="paymentCurrencySymbol" includeFrom="currency.currencySymbol" includeVia="paymentCurId"/&gt;
     *    &lt;field name="paymentCurrencyGroup" includeFrom="currency.groupName" includeVia="paymentCurId"/&gt;
     * 
     *   .. where the "currency" DataSource used above is related to the "currencyGroup" DataSource via fields:
     * 
     *    &lt;field name="groupId" type="integer" foreignKey="currencyGroup.id" relatedTableAlias="group"/&gt;
     *    &lt;field name="groupName" type="text" includeFrom="currencyGroup.groupName"/&gt;
     * 
     *   Fields "sourceCurrencyGroup" and "paymentCurrencyGroup" include a field that is itself an included field.
     *   In this case "currencyGroup" table will be referenced two times, and its relatedTableAlias defined in
     *   "currency" DataSource will be prefixed with the includeVia value to make
     *   aliases unique in generated SQL: "sourceCurId_group" and "paymentCurId_group".
     * 
     *   The same aliases would be used if "sourceCurrencyGroup" and "paymentCurrencyGroup" fields
     *   were to include "currencyGroup.groupName" indirectly:
     * 
     *    &lt;field name="sourceCurrencyGroup" includeFrom="currency.currencyGroup.groupName" includeVia="sourceCurId"/&gt;
     *    &lt;field name="paymentCurrencyGroup" includeFrom="currency.currencyGroup.groupName" includeVia="paymentCurId"/&gt;
     * 
     * 
     *   This works the same for more complex relationships. If we add a "moneyTransferDetail"
     *   DataSource to the sample above which has multiple references to "moneyTransfer"
     *   DataSource and would include fields from "currency" and "currencyGroup" DataSources:
     * 
     *    &lt;field name="mtId" nativeName="moneyTransferId" type="integer" foreignKey="moneyTransfer.id" relatedTableAlias="main" /&gt;
     *    &lt;field name="mainTransferName" includeFrom="moneyTransfer.name" includeVia="mtId" /&gt;
     *    &lt;field name="mainSourceSymbol" includeFrom="moneyTransfer.sourceCurrencySymbol" includeVia="mtId" /&gt;
     *    &lt;field name="mainSourceGroup" includeFrom="moneyTransfer.sourceCurrencyGroup" includeVia="mtId" /&gt;
     *    &lt;field name="mainPaymentSymbol" includeFrom="moneyTransfer.paymentCurrencySymbol" includeVia="mtId" /&gt;
     *    &lt;field name="mainPaymentGroup" includeFrom="moneyTransfer.paymentCurrencyGroup" includeVia="mtId" /&gt;
     *    &lt;field name="mtPrevId" nativeName="moneyTransferPreviousId" type="integer" foreignKey="moneyTransfer.id" relatedTableAlias="prev" /&gt;
     *    &lt;field name="previousTransferName" includeFrom="moneyTransfer.name" includeVia="mtPrevId" /&gt;
     *    &lt;field name="previousSourceSymbol" includeFrom="moneyTransfer.sourceCurrencySymbol" includeVia="mtPrevId" /&gt;
     *    &lt;field name="previousSourceGroup" includeFrom="moneyTransfer.sourceCurrencyGroup" includeVia="mtPrevId" /&gt;
     *    &lt;field name="previousPaymentSymbol" includeFrom="moneyTransfer.paymentCurrencySymbol" includeVia="mtPrevId" /&gt;
     *    &lt;field name="previousPaymentGroup" includeFrom="moneyTransfer.paymentCurrencyGroup" includeVia="mtPrevId" /&gt;
     * 
     *   In this scenario the "currencyGroup" table will be joined 4 times - for all main/prev transfer
     *   and payment/source currency combinations. So, aliases will be prefixed with both
     *   intermediate includeVia values: "mtId_sourceCurId_group",
     *   "mtId_paymentCurId_group", "mtPrevId_sourceCurId_group", "mtPrevId_paymentCurId_group".
     * 
     *   It is also allowed to specify a series of FK fields in includeVia, for example
     *   "moneyTransferDetail" could declare:
     * 
     *    &lt;field name="mainSourceCurrencyGroup" includeFrom="moneyTransfer.currency.currencyGroup.groupName" includeVia="mtId.sourceCurId"/&gt;
     *    &lt;field name="mainPaymentCurrencyGroup" includeFrom="moneyTransfer.currency.currencyGroup.groupName" includeVia="mtId.paymentCurId"/&gt;
     * 
     *   In this case the prefix used for table aliases will be the includeVia value
     *   with "_" substituted for ".", so the table aliases will be "mtId_sourceCurId_group" and "mtId_paymentCurId_group".
     * 
     *   Note that if DataSourceField.relatedTableAlias is not
     *   specified, then we don't make any guarantees what alias will be generated.
     * 
     *   Note that Oracle has a limit of 30 characters on identifier names. We limit table
     *   aliases to 30 characters all databases despite actual database in use to support
     *   portability across databases. If the generated table alias would exceed 30 chars,
     *   we instead use a generated and unpredictable value like "a123". To avoid hitting this limit
     *   for the advanced cases discussed above:
     * 
     * 
     *  - use relatively short strings for relatedTableAlias
     * 
     *  - for rare, multi-step inclusion scenarios where multiple field names are used as a
     *     prefix, if field names are very long in order to match database column names, you can
     *     use a shorter field name and use DataSourceField.nativeName to specify the
     *     underlying column name (this is demonstrated in samples above - note field "mtPrevId")
     * 
     *  @type {string}
     *  @default null
     */
    open var includeVia: String = definedExternally
    /**
     *  For a sqlDataSource field that specifies a
     *   DataSourceField.foreignKey, this property defines the table alias name to
     *   use in generated SQL.
     * 
     *   Aliasing is necessary when the same table appears more than once in a query. This can
     *   happen when using DataSourceField.includeVia. It can also happen when a
     *   DataSourceField.foreignKey definition references the same dataSource
     *   that the field is defined in; this happens with hierarchical structures, for example where
     *   every Employee reports to another Employee. This is a so-called "self join", and it
     *   always requires relatedTableAlias to be specified; failure to do so
     *   will result in invalid SQL.
     *  @type {string}
     *  @default null
     */
    open var relatedTableAlias: String = definedExternally
    /**
     *  When records from this dataSource are displayed in a dataBoundComponent such as a
     *   ListGrid, the displayField attribute may be used to cause some
     *   field to display a value from another field in the record.
     * 
     *   This is typically used for editable DataSourceField.foreignKey fields.
     *   In this scenario, a dataSource
     *   field has a foreignKey field which stores an ID value used to identify records in another,
     *   related dataSource. Rather than display this ID to users, developers may wish to display
     *   another, user-friendly field from the related record. This is easy to achieve by
     *   having a second field on the dataSource which will be populated with the "display value"
     *   from this related dataSource, and using dataSourceField.displayField
     *   to show this value. The DataSourceField.includeFrom feature handles populating
     *   this field automatically for dataSources backed by the
     *   serverDataIntegration. See the "Editing included fields"
     *   section of the DataSourceField.includeFrom documentation
     *   for more on editing included foreignKey fields.
     * 
     *   Editable dataSourceFields with a specified displayField and
     *   foreignKey will typically be edited using a SelectItem
     *   or ComboBoxItem. In this case, in addition to identifying the field to use as a
     *   static display value within the record being edited, displayField
     *   will also identify which field on the related dataSource
     *   to use as a display field when showing a set of options to the user. This behavior may
     *   be modified in a couple of ways:
     * 
     * 
     *  - A separate field name can be specified to identify the display field on the
     *     related dataSource using the DataSourceField.foreignDisplayField attribute
     * 
     *  - The DataSourceField.useLocalDisplayFieldValue attribute may be explicitly
     *     set to false to avoid picking up a display value from the local record altogether.
     *     Instead the displayField will be used only to derive the display value from
     *     a related record from the optionDataSource
     * 
     *   For more on how FormItems use the displayField property, see FormItem.displayField.
     *  @type {string}
     *  @default null
     */
    open var displayField: String = definedExternally
    /**
     *  The FormItem.useLocalDisplayFieldValue attribute may be specified
     *   within a dataSource configuration.
     * 
     *   This property governs whether, when displaying a record in an editor component,
     *   the displayField value for this field should be picked up directly from
     *   the record value (as opposed to being retrieved via an explicit fetch operation against
     *   the FormItem.optionDataSource). See FormItem.useLocalDisplayFieldValue
     *   for further details.
     * 
     *   If not explicitly set, dataSources backed by the
     *   serverDataIntegration will set this property to true
     *   automatically for fields where the specified DataSourceField.displayField values
     *   are retrieved from another dataSource using the DataSourceField.includeFrom
     *   feature.
     *  @type {boolean}
     *  @default null
     */
    open var useLocalDisplayFieldValue: Boolean = definedExternally
    /**
     *  Name of another field in a separate dataSource that should be used as the display
     *   value for this field in the case where a foreignKey relationship
     *   exists.
     * 
     *   For a general overview on picking up display values from a separate field,
     *   see DataSourceField.displayField property.
     * 
     *   The foreignDisplayField property is useful for editable fields, where the
     *   name of the display field within the record being edited differs from the display field
     *   for related records in the option dataSource.
     *   For example consider a "countryDS" dataSource with the following fields:
     * 
     *   &lt;field name="id"   type="sequence"  hidden="true"   primaryKey="true" /&gt;
     *   &lt;field name="name"  type="text"    title="Country"  required="true" /&gt;
     * 
     *   ...and a "city" dataSource which uses a foreignKey relationship identify associated
     *   country records:
     * 
     *   &lt;field name="id"    type="sequence" hidden="true"  primaryKey="true" /&gt;
     *   &lt;field name="name"   type="text"   title="City"  required="true" /&gt;
     *   &lt;field name="countryId" type="integer" editorType="SelectItem"
     *         foreignKey="countryDS.id"
     *         displayField="countryName" foreignDisplayField="name" title="Country" /&gt;
     *   &lt;field name="countryName" includeFrom="countryDS.name" hidden="true"  /&gt;
     * 
     *   A DynamicForm bound to this "city" dataSource would display a SelectItem editor by
     *   default for the country field. The initial display value would be the local value from
     *   the "countryName" field, populated from the related countryDS automatically via the
     *   DataSourceField.includeFrom feature.
     *   If the user showed the drop-down list of options for this field, the display values
     *   within that list would be picked up from the "name" field values for the related
     *   "countryDS" records.
     *  @type {string}
     *  @default null
     */
    open var foreignDisplayField: String = definedExternally
    /**
     *  This property is only applicable to fields of SQL DataSources that also specify a
     *   DataSourceField.foreignKey property; it is ignored for all other fields. Indicates the
     *   type of join to make between the tables underlying this DataSource and the other DataSource
     *   referred to in the foreignKey property, when resolving DataSourceField.includeFrom
     *   fields. The default value of null is the same as specifying "inner".
     * 
     *   Note, outer joins are allowed for all supported database products only if you are using
     *   DataSource.useAnsiJoins, which is not the case by default. If you
     *   are using the older strategy of additional join expressions in the WHERE clause, outer
     *   joins are only supported for database products that provide a proprietary native syntax for
     *   expressing outer joins. Those products are:
     * 
     *  - Oracle
     * 
     *  - Versions of Microsoft SQL Server earlier than 2012, and running in compatibility mode 80
     * 
     *  @type {JoinType}
     *  @default null
     */
    open var joinType: 
                       /**
                        *  A regular inner join, whereby rows are only included in the resultset          where the join can be satisified, so a missing row in the table being
                        *            joined to results in the entire row being omitted.
                        *  An outer join. All outer joins generated by SmartClient's SQL subsystem          are left outer joins, meaning that every row in the join-from (or "left")
                        *            table that matches the criteria is included, and missing rows in the
                        *            join-to (or "right") table cause columns to be set to null.
                        */
                       String /* inner |  outer */ = definedExternally
    /**
     *  If ListGrid.showGridSummary or ListGrid.showGroupSummary is true,
     *   this attribute can be used to specify
     *   an explicit SummaryFunction for calculating the summary value to
     *   display.
     * 
     *   If an array of summaryFunctions is specified, they will be executed in turn and the
     *   grid will show multiple summary rows at the grid or group level (or both)
     *   containing the resulting values.
     *  @type {SummaryFunction}
     *  @default null
     */
    open var summaryFunction: 
                              /**
                               *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                               *   any non numeric field values are encountered.
                               *   Server: acts exactly like SQL SUM function.
                               *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                               *   summary value if any non numeric field values are encountered.
                               *   Server: acts exactly like SQL AVG function.
                               *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                               *   date type fields only. Returns null to indicate invalid
                               *   summary value if any non numeric/date field values are encountered.
                               *   Server: acts exactly like SQL MAX function.
                               *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                               *   date type fields only. Returns null to indicate invalid summary value if
                               *   any non numeric field values are encountered.
                               *   Server: acts exactly like SQL MIN function.
                               *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                               *   Returns null to indicate invalid summary value if
                               *   any non numeric field values are encountered.
                               *   Server: not supported.
                               *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                               *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                               *   Server: not supported.
                               *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                               *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                               *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                               *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                               *   values for concatenation. See also DataSourceField.joinPrefix,
                               *   DataSourceField.joinString and DataSourceField.joinSuffix
                               *   related datasource field attributes.
                               */
                              String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */ = definedExternally
    /**
     *  Title to show in a SummaryFunction for this field. If unspecified
     *   title summaries will show the DataSourceField.title for the field.
     *  @type {string}
     *  @default null
     */
    open var summaryValueTitle: String = definedExternally
    /**
     *  Indicates that DataSource.xmlSerialize should serialize this value as an XML
     *   attribute.
     * 
     *   Note this does not need to be declared in order for DataSource records to be derived from
     *   XML data: a field will be populated with either an attribute or subelement with matching
     *   name.
     *  @type {boolean}
     *  @default null
     */
    open var xmlAttribute: Boolean = definedExternally
    /**
     *  For a field that is DataSourceField.multiple, controls the name of the XML tag used for each
     *   subelement during DataSource.xmlSerialize.
     * 
     *   If unset, the default tag name is "value" for a field of simple type, and for a field of
     *   DataSource type, is the tagName or ID of the DataSource (as though
     *   xmlSerialize() were called on the child DataSource).
     *  @type {string}
     *  @default null
     */
    open var childTagName: String = definedExternally
    /**
     *  For use in componentSchema for fields that contain other components, this flag
     *   suppresses auto-construction for subcomponents that appear under this field.
     * 
     *   For example, the VLayout schema sets this for its Layout.members
     *   property, so that when a VLayout is constructed via XML as follows:
     * 
     *   &lt;VLayout&gt;
     *     &lt;members&gt;
     *       &lt;ListGrid ID="myGrid" .../&gt;
     *       &lt;Toolstrip ID="myToolStrip" ... /&gt;
     *     &lt;/members&gt;
     *   &lt;/VLayout&gt;
     * 
     *   The ListGrid and ToolStrip do not construct themselves automatically. Instead, the VLayout
     *   receives the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with
     *   the special property _constructor set to the name of the class that should be
     *   constructed.
     *  @type {boolean}
     *  @default null
     */
    open var propertiesOnly: Boolean = definedExternally
    /**
     *  For use in componentSchema, a field DataSource.inheritsFrom from
     *   another schema can be redeclared with this property set in order to indicate that the
     *   property should not be used.
     * 
     *   This is primarily used to influence visualBuilder. For simple type properties,
     *   this avoids the property appearing in the Component Editor.
     * 
     *   For fields that hold subcomponents, this prevents inappropriate drag and drop. For example,
     *   a custom class called MyDialog may automatically create a series of children,
     *   and not allow arbitrary other children to be added. In this case, the inherited property
     *   Canvas.children should be marked inapplicable in order to prevent arbitrary
     *   components being dropped onto a MyDialog instance.
     *  @type {boolean}
     *  @default null
     */
    open var inapplicable: Boolean = definedExternally
    /**
     *  For use in componentSchema, indicates what group to place the property in when
     *   editing in Visual Builder.
     *  @type {string}
     *  @default null
     */
    open var group: String = definedExternally
    /**
     *  Indicates that this field should always be Array-valued. If the value derived from
     *   DataSource.dataFormat is singular, it will be wrapped in an Array.
     * 
     *   JPA and Hibernate DataSources use multiple:true as part of the declaration of
     *   One-To-Many and Many-to-Many relations - see jpaHibernateRelations for details.
     * 
     *   Criteria on multiple:true fields: client-side filtering
     * 
     *   For simple Criteria, the criteria value is compared to each field value in the
     *   multiple:true field, according to the
     *   DSRequest.textMatchStyle. If any field value matches the
     *   filter value, the field is considered to match the criteria.
     * 
     *   For AdvancedCriteria, for normal OperatorId the field
     *   value is considered as matching the Criterion if any of the field values
     *   match the Criterion. Specifically, this is true of all operators that have an
     *   OperatorValueType of "fieldType" or "valueRange".
     * 
     *   For operators that compare against other fields in same record, such as "equalsField",
     *   if the other field is not multiple:true, matching works the same as for
     *   normal operators, that is, as if criterion.value directly contained the value
     *   rather than the name of another field.
     * 
     *   If the other field is also multiple:true, only "equalsField", "notEqualsField",
     *   "iEqualsField" and "iNotEqualsField" are allowed (any other operator will
     *   cause a warning and be ignored) and the set of values in the field must be identical (aside
     *   from case, for operators prefixed with "i") and in identical order to match.
     * 
     *   For the inSet operator, the field matches if there is any intersection between
     *   the field values and the array of values provided in criterion.value.
     *   notInSet is the reverse.
     * 
     *   Finally, for "isBlank", "notBlank", "isNull" and "notNull", an empty Array is considered non-null. For example,
     *   if you use dataFormat:"json" and the field value is provided to the browser as
     *   [] (JSON for an empty Array), the field is considered non-null.
     * 
     *   Server-side Representation and Storage
     * 
     *   Values for multiple:true fields appear as Java Lists when received in server code such as a
     *   DMI. The SmartClient Server supports simple storage of values that are multiple:true, controlled
     *   via the DataSourceField.multipleStorage setting.
     * 
     *   For server-side behavior of JPA and Hibernate relation fields that are multiple:true, see
     *   jpaHibernateRelations.
     * 
     *   For non-relation fields, the SmartClient Server supports simple storage of values that are
     *   multiple:true, controlled via the DataSourceField.multipleStorage setting, with some limited support
     *   for server-side filtering, as described in the DataSourceField.multipleStorage docs.
     * 
     *   For the built-in SQL, Hibernate and JPA connectors, if criteria are specified for a
     *   multiple:true field where multipleStorage is null or "none", the SmartClient
     *   server knows nothing about how the multiple values are stored, so as a fallback the criteria
     *   will operate as though the field were a normal, non-multiple "text" field. This will
     *   generally not match the client-side filtering behavior described above, so filtering
     *   should either be performed entirely on the client (for example, via
     *   ListGrid.dataFetchMode or entirely on the server (via
     *   ResultSet.useClientFiltering:"false")
     * 
     *   The server-side filtering is done through a criteria transform which happens with
     *   DataSource.transformMultipleFields.
     * 
     *   XML Serialization
     * 
     *   Specifically for XML serialization and deserialization, multiple:true behaves
     *   similarly to the
     *   SOAP array idiom, that is,
     *   there will be a "wrapper element" named after the field name, whose contents will be several
     *   elements of the specified DataSourceField.type.
     * 
     *   For example, Layout.members is declared with type:"Canvas",
     *   multiple:true. The correct XML format is thus:
     * 
     *   &lt;VLayout&gt;
     *     &lt;members&gt;
     *       &lt;Canvas ID="myCanvas" ... /&gt;
     *       &lt;ListGrid ID="myGrid" .../&gt;
     *       &lt;Toolstrip ID="myToolStrip" ... /&gt;
     *     &lt;/members&gt;
     *   &lt;/VLayout&gt;
     * 
     * 
     *   See DataSourceField.childTagName for customizing the tagName used for subelements.
     *  @type {boolean}
     *  @default null
     */
    open var multiple: Boolean = definedExternally
    /**
     *  For fields that are DataSourceField.multiple, the separator used
     *   between values when they are displayed.
     *  @type {string}
     *  @default ", "
     */
    open var multipleValueSeparator: String = definedExternally
    /**
     *  How values for a DataSourceField.multiple field should be stored.
     * 
     *   On the server, field values for multiple:true fields are represented as Java
     *   Lists in DSRequest and DSResponse objects, but when multipleStorage is used,
     *   are ultimately stored as Strings.
     * 
     *   This storage mechanism is "denormalized" in the sense of
     *   database normalization
     *   because the field contains a compound value rather than an atomic value. Specifically, this
     *   makes the field harder to use with database features like SQL joins, since its value cannot
     *   be directly compared to other, singular fields. For this reason, there's really only a
     *   narrow set of cases where it makes sense to use this storage mechanism, consider it if:
     * 
     * 
     *  - the values don't appear in any other tables or columns elsewhere in your database (so
     *     joins and other comparisons wouldn't be possible anyway)
     * 
     *  - there is no authoritative list of all possible values, or even of popular values; it's
     *     basically freeform, like arbitrary, uncurated "tags" applied to photos or links
     * 
     * 
     *   A multiple:true field can be of any SimpleType, including "date",
     *   "time", "datetime", "float", "int" etc. Type will be preserved across a store and reload
     *   cycle, so for example a List of values for a field of type "int" will arrive at the server
     *   in a DSRequest as a List of Integer, be stored as a String, but appear again as a List of
     *   Integer inside a DSResponse. When storing "date", "time" or "datetime" values as Strings,
     *   XML schema formats are used - the same that are used for transmission in XML or JSON (see
     *   dateFormatAndStorage for details).
     * 
     *   The multipleStorage feature works by transforming from List to String and back
     *   inside the server-side DataSource.execute() method. Specifically, inbound DSRequests are
     *   transformed before methods that perform actual storage are called (executeUpdate() et al),
     *   and DSResponses received from these methods have multiple:true field values
     *   transformed back into Lists before DataSource.execute() returns the DSResponse.
     * 
     *   This transformation approach means that the built-in SQL, JPA and Hibernate connectors all
     *   support multipleStorage, and multipleStorage is also automatically
     *   available for any custom DataSource that is capable of storing String values, and implements
     *   its storage methods via overrides of executeUpdate(), executeAdd() et al as described in the
     *   writeCustomDataSource.
     * 
     *   Note that when using the built-in SQL, JPA and Hibernate connectors, the underlying SQL
     *   column should be of 'text' type. The dbConfigTool will
     *   automatically generate columns of the correct type for a SQLDataSource. For JPA or
     *   Hibernate DataSources, just ensure the type of the Java bean property on your Java object is
     *   String.
     * 
     *   The default multipleStorage setting of null means that the "simpleString"
     *   MultipleFieldStorage approach will be used if:
     * 
     * 
     *  - the field is of a known SimpleType
     * 
     *  - the field is not a DataSourceField.foreignKey
     * 
     *   Otherwise, MultipleFieldStorage "none" will be used.
     * 
     *   Criteria and AdvancedCriteria handling
     * 
     *   For the built-in SQL, JPA and Hibernate connectors, when
     *   multipleStorage:"simpleString" or "json" is used, criteria are transformed to
     *   replicate the client-side filtering behavior for multiple:true fields, where possible.
     *   The following operators are supported with the same behavior as client-side filtering:
     * 
     * 
     *  - all String-oriented operators including patternOperators,
     *   but not regexp/iRegexp
     * 
     *  - isBlank / notBlank
     * 
     *  - isNull / notNull
     * 
     *  - inSet / notInSet
     * 
     *  - equalsField / notEqualsField / iEqualsField / iNotEqualsField
     * 
     *   The following operators, which are supported for client-side filtering of multiple:true
     *   fields, are not supported for server filtering when using multipleStorage:
     * 
     * 
     *  - greaterThan/lessThan(OrEqual)
     * 
     *  - "between" and all other operators with OperatorValueType of "valueRange"
     * 
     *  - regexp / iRegexp as noted above
     * 
     *   Note that for string-based filtering operators such as "equals", no characters which are
     *   part of the DataSourceField.multipleStorageSeparator may be used in the filter string. If any
     *   characters from the multipleStorageSeparator are present in the filter value,
     *   it will always fail to match. For "json" mode, the multipleStorageSeparator is
     *   effectively the String '","'.
     *  @type {MultipleFieldStorage}
     *  @default null
     */
    open var multipleStorage: 
                              /**
                               *  values are saved as a simple delimeter-separated string. Delimeter    can be configured via DataSourceField.multipleStorageSeparator. An empty
                               *      array is stored as "", and null as the database null value.
                               *  values are serialized to JSON. Empty array as a distinct value     from null (it appears as the text "[]").
                               *  no transformation is applied to values; server-side field value remains a Java    List when passed to the execute(Fetch|Add|Update|Remove) method of the server-side
                               *      DataSource class
                               */
                              String /* simpleString |  json |  none */ = definedExternally
    /**
     *  For fields that are DataSourceField.multiple and use DataSourceField.multipleStorage, the
     *   separator used in the "simpleString" MultipleFieldStorage mode.
     * 
     *   Default value of null means the DataSourceField.multipleValueSeparator is used instead.
     *  @type {string}
     *  @default null
     */
    open var multipleStorageSeparator: String = definedExternally
    /**
     *  Explicitly declares the Java class that should be used when data from the client is
     *   validated by the SmartClient server and/or applied to Java Beans / POJOs via the server-side
     *   API com.isomorphic.datasource.DataSource.setProperties(). This includes
     *   auto-populating POJO arguments of a dmiOverview method, or populating
     *   JPA/Hibernate beans with data when using the built-in JPA and Hibernate DataSources.
     * 
     *   For DataSources that do not use Java Beans, fields declared to be of type "integer" or
     *   "float" can use javaClass to force a particular numeric representation for
     *   validated DSRequest data (e.g. data passed to a DMI). Valid settings include "BigInteger",
     *   "Long", "Integer", "Short", "Byte", "AtomicInteger", "AtomicLong", "BigDecimal", "Double", "Float".
     * 
     *   When populating Java Beans/ POJOs, javaClass does not normally have to
     *   specified: SmartClient will use Java reflection to inspect the type of argument expected by
     *   a setter method and will attempt conversion of inbound data to that type. As described in
     *   the documentation for DataTools.setProperties(), this works for almost all
     *   typical cases. However field.javaClass is useful for:
     * 
     * 
     *  - subobject of abstract or interface type: in this case Java Reflection is not sufficient
     *   to discover the concrete type that should be instantiated, and javaClass should be
     *   set instead.
     * 
     *  - subobject of Collection or Map type, when Java generics are not used or the Collection
     *   member type or Map value type is abstract. When Java generics are used (for example the
     *   setter takes an argument is of type Collection&lt;SomePOJO&gt; or Map&lt;KeyType,SomePOJO&gt;,
     *   SmartClient will automatically attempt to convert inbound data to the type of the members of
     *   the Collection or values of the Map. Without generics, javaClass needs to be
     *   specified. Note that javaClass will take precedence over generics if both
     *   are used. Also note that DataSourceField.javaCollectionClass can be specified if a
     *   particular Collection or Map type is needed, and DataSourceField.javaKeyClass can be
     *   specified for a field of type java.util.Map.
     * 
     *   NOTE: It is also possible to make SmartClient Server determine the javaClass to use
     *   dynamically at runtime. See the description of DataSource.getPropertyJavaClass()
     *   in the server documentation for details.
     *  @type {string}
     *  @default null
     */
    open var javaClass: String = definedExternally
    /**
     *  See DataSourceField.javaClass - when auto-populating of Java Beans / POJOs based on
     *   inbound DSRequest data, for a field of type Collection or Map,
     *   javaCollectionClass can
     *   be used to specify a particular concrete class to use. If not specified, and a concrete
     *   Collection or Map class cannot be discovered using Java Reflection, the following concrete
     *   classes are used:
     * 
     * 
     *  - java.util.ArrayList is used for fields of type List
     * 
     *  - java.util.HashSet is used for fields of type Set
     * 
     *  - java.util.LinkedList is used for fields of type Queue
     * 
     *  - java.util.LinkedHashMap is used for fields of type Map
     * 
     *  - java.util.ArrayList is used for fields that are otherwise of type Collection
     * 
     *   Note that this value is used even if the target Collection or Map is declared as a concrete
     *   class. So, for example, if you set javaCollectionClass to
     *   java.util.LinkedList but your setter method accepts a
     *   java.util.ArrayList, you will get a ClassCastException.
     *  @type {string}
     *  @default null
     */
    open var javaCollectionClass: String = definedExternally
    /**
     *  See DataSourceField.javaClass - when auto-populating of Java Beans / POJOs based on
     *   inbound DSRequest data, for a field of Map type, javaKeyClass can be used to
     *   specify a particular concrete class for the map keys. If not specified, and a concrete
     *   type cannot be discovered using Java Reflection, java.lang.Object is used.
     * 
     *   Note that javaKeyClass take precedence over generics if both are used.
     *  @type {string}
     *  @default null
     */
    open var javaKeyClass: String = definedExternally
    /**
     *  Optional different field-title used for exports.
     *  @type {string}
     *  @default null
     */
    open var exportTitle: String = definedExternally
    /**
     *  Dictates whether the data in this field be exported. Explicitly setting
     *   canExport to false overrides the setting on any component-fields, such
     *   as ListGridField.canExport.
     *  @type {boolean}
     *  @default null
     */
    open var canExport: Boolean = definedExternally
    /**
     *  Used by the BatchUploader to map a field in an upload file to this
     *   dataSourceField. This is only necessary if the dataSourceField's name and title differ
     *   from the name of the field in the upload file (SmartClient will automatically map upload
     *   fields using the dataSourceField's title, if possible, if it does not get a direct match
     *   on field name).
     *  @type {string}
     *  @default null
     */
    open var uploadFieldName: String = definedExternally
    /**
     *  For a field of type:"imageFile", indicates whether to stream the image and display it
     *   inline or to display the View and Download icons.
     *  @type {boolean}
     *  @default null
     */
    open var showFileInline: Boolean = definedExternally
    /**
     *  Width of the image-content of this field. If set as a string, represents the name of
     *   another field in the record that holds the imageWidth. Applicable only to fields of image
     *   type or fields that use a ViewFileItem as an editor.
     *  @type {number | string}
     *  @default null
     */
    open var imageWidth: dynamic = definedExternally
    /**
     *  Height of the image-content of this field. If set as a string, represents the name of
     *   another field in the record that holds the imageHeight. Applicable only to fields of image
     *   type or fields that use a ViewFileItem as an editor.
     *  @type {number | string}
     *  @default null
     */
    open var imageHeight: dynamic = definedExternally
    /**
     *  Width and height of the image-content of this field. If set as a string, represents the
     *   name of another field in the record that holds the imageSize. Applicable only to fields
     *   of image type or fields that use a ViewFileItem as an editor.
     *  @type {number | string}
     *  @default null
     */
    open var imageSize: dynamic = definedExternally
    /**
     *  Whether a user must be authenticated in order to fetch this field. If this property is
     *   set and the user is not authenticated, SmartClient Server will not return values for this
     *   field to the client.
     * 
     *   The way this behavior works is to remove the field from the expressed or implied list of
     *   fields to return. A list of fields can be expressed using OperationBinding.outputs
     *   or DSRequest.outputs; in the absence of those, the entire set of fields defined in
     *   the DataSource is implied. You can override this behavior on a per-request basis by
     *   providing a DMI that just re-adds the names of the fields you want for that particular
     *   request to the "consolidated outputs". See the server-side Javadoc for
     *   DSRequest.getConsolidatedOutputs().
     * 
     *   In addition to this behavior of trimming off values in fetched records, a field that fails
     *   a field-level security check (either this one or one of the two more specific checks,
     *   DataSourceField.viewRequiresRole and DataSourceField.viewRequires) will be
     *   altered in the version of the dataSource returned to the client by the
     *   loadDSTag or
     *   dataSourceDeclaration.
     * 
     * 
     *  - If the field is also not editable (see the discussion of this below), it will be marked
     *   DataSourceField.canView:false, and thus effectively be inert and unusable on the client
     * 
     *  - If the field is editable, it will be marked DataSourceField.hidden. By default, this means
     *   that DataBoundComponents will not show the field, though this can be overridden for
     *   individual components. If you do choose to unhide the field, bear in mind that it will
     *   never actually show any data, because the underlying security test has still failed
     * 
     *   By default, view constraints automatically imply edit constraints - almost all of the time,
     *   if a user is not allowed to view a field, he should not be allowed to update it either. If
     *   you specify a view constraint, the system behaves as if you had also specified the
     *   corresponding edit constraint - so viewRequiresAuthentication on a field
     *   implies DataSourceField.editRequiresAuthentication.
     *   You override this behavior simply by specifying some kind of edit constraint for the field,
     *   either a different one (eg, "users" can view a field, but only "managers" can update it) or
     *   a blank one (if you have some unusual requirement whereby users are not allowed to view a
     *   field, but they can update it).
     *  @type {boolean}
     *  @default null
     */
    open var viewRequiresAuthentication: Boolean = definedExternally
    /**
     *  Whether a user must be authenticated in order to write to this field. If this property is
     *   set and the user is not authenticated, the SmartClient Server will not allow this field to
     *   be updated or initialized.
     * 
     *   This property affects two things. Firstly, the server determines when the DataSource is
     *   first loaded if we have an authenticated user; if we don't, the field is marked
     *   canEdit: false. Secondly, when an insert or update request is received from
     *   the client, the server removes the field from the values clause before the
     *   request is processed.
     * 
     *   Note that you can override this behavior. The canEdit setting can be overridden
     *   on the the client-side DataSource like any other client-side property. The value-removing
     *   behavior can be overridden on a per-request basis by providing a DMI that re-adds values for
     *   the fields you want for that particular request to the values object (the values originally
     *   sent up by the client are available on the DSRequest). See the server-side Javadocs for
     *   DSRequest.getValues() and DSRequest.getClientSuppliedValues().
     *  @type {boolean}
     *  @default null
     */
    open var editRequiresAuthentication: Boolean = definedExternally
    /**
     *  Whether a user must be authenticated in order to initialize to this field. If this property is
     *   set and the user is not authenticated, the SmartClient Server will not allow this field to
     *   be initialized.
     *  @type {boolean}
     *  @default null
     */
    open var initRequiresAuthentication: Boolean = definedExternally
    /**
     *  Whether a user must be authenticated in order to update to this field. If this property is
     *   set and the user is not authenticated, the SmartClient Server will not allow this field to
     *   be updated.
     *  @type {boolean}
     *  @default null
     */
    open var updateRequiresAuthentication: Boolean = definedExternally
    /**
     *  Comma-separated list of user roles that are allowed to fetch this field. If the current user
     *   has any of the roles listed, values for the field will be fetched. Please see
     *   OperationBinding.requiresRole for further details of SmartClient's declarative
     *   role-based security. Please also see
     *   DataSourceField.viewRequiresAuthentication for details
     *   of how declarative field-level security settings can be overridden per-request.
     *  @type {string}
     *  @default null
     */
    open var viewRequiresRole: String = definedExternally
    /**
     *  Comma-separated list of user roles that are allowed to write to this field. If the current
     *   user does not have any of the roles listed, the system will not allow this field to be
     *   initialized or updated. Please see OperationBinding.requiresRole for further
     *   details of SmartClient's declarative role-based security. Please also see
     *   DataSourceField.editRequiresAuthentication for details
     *   of how declarative field-level security settings can be overridden per-request.
     * 
     *   NOTE: This property prevents both initialization and updates for a field. If you
     *   have a need to prevent just initialization or just updates, you can use
     *   DataSourceField.initRequiresRole or DataSourceField.updateRequiresRole.
     *  @type {string}
     *  @default null
     */
    open var editRequiresRole: String = definedExternally
    /**
     *  Comma-separated list of user roles that are allowed to initialize this field. If the current
     *   user does not have any of the roles listed, the system will not allow this field to be
     *   initialized.
     * 
     *   NOTE: This property only prevents initialization of a field; updates will still be
     *   allowed. You should only use this property if you have a special requirement; ordinarily,
     *   use DataSourceField.editRequiresRole, which applies security for both types of write.
     *  @type {string}
     *  @default null
     */
    open var initRequiresRole: String = definedExternally
    /**
     *  Comma-separated list of user roles that are allowed to update this field. If the current
     *   user does not have any of the roles listed, the system will not allow this field to be
     *   updated.
     * 
     *   NOTE: This property only prevents a field from being updated; initialization will
     *   still be allowed. You should only use this property if you have a special requirement;
     *   ordinarily, use DataSourceField.editRequiresRole, which applies security for both
     *   types of write.
     *  @type {string}
     *  @default null
     */
    open var updateRequiresRole: String = definedExternally
    /**
     *  Indicates that the specified VelocityExpression must evaluate to true if
     *   values for the field are to be fetched. If the specified expression does not evaluate
     *   to true, the field will be dropped as described for
     *   DataSourceField.viewRequiresAuthentication.
     * 
     *   In addition to the normal context variables available to Velocity expressions in SmartClient,
     *   expressions you write for field-level requires clauses - viewRequires,
     *   DataSourceField.editRequires, DataSourceField.initRequires and
     *   DataSourceField.updateRequires - can reference two additional variables:
     *   $fieldName and $dsName. These are the names of the dataSource and
     *   field currently undergoing requires checks. They are helpful because they allow
     *   you to write a generic checker function that can be used to handle requires
     *   checks for multiple fields and dataSources.
     *  @type {VelocityExpression}
     *  @default null
     */
    open var viewRequires: String = definedExternally
    /**
     *  Indicates that the specified VelocityExpression must evaluate to true if
     *   writes to this field are to be allowed. If the specified expression does not evaluate
     *   to true, the field will be removed from the request as described for
     *   DataSourceField.editRequiresAuthentication.
     * 
     *   In addition to the normal context variables available to Velocity expressions in SmartClient,
     *   expressions you write for field-level requires clauses - editRequires,
     *   DataSourceField.viewRequires, DataSourceField.initRequires and
     *   DataSourceField.updateRequires - can reference two additional variables:
     *   $fieldName and $dsName. These are the names of the dataSource and
     *   field currently undergoing requires checks. They are helpful because they allow
     *   you to write a generic checker function that can be used to handle requires
     *   checks for multiple fields and dataSources.
     * 
     *   NOTE: This property prevents both initialization and updates for a field. If you
     *   have a need to prevent just initialization or just updates, you can use
     *   DataSourceField.initRequires or DataSourceField.updateRequires.
     *  @type {VelocityExpression}
     *  @default null
     */
    open var editRequires: String = definedExternally
    /**
     *  Indicates that the specified VelocityExpression must evaluate to true if
     *   initializations of this field are to be allowed. If the specified expression does not
     *   evaluate to true, the field will be removed from the request as described for
     *   DataSourceField.editRequiresAuthentication.
     * 
     *   In addition to the normal context variables available to Velocity expressions in SmartClient,
     *   expressions you write for field-level requires clauses - initRequires,
     *   DataSourceField.viewRequires, DataSourceField.editRequires and
     *   DataSourceField.updateRequires - can reference two additional variables:
     *   $fieldName and $dsName. These are the names of the dataSource and
     *   field currently undergoing requires checks. They are helpful because they allow
     *   you to write a generic checker function that can be used to handle requires
     *   checks for multiple fields and dataSources.
     * 
     *   NOTE: This property only prevents initialization of a field; updates will still be
     *   allowed. You should only use this property if you have a special requirement; ordinarily,
     *   use DataSourceField.editRequires, which applies security for both types of write.
     *  @type {VelocityExpression}
     *  @default null
     */
    open var initRequires: String = definedExternally
    /**
     *  Indicates that the specified VelocityExpression must evaluate to true if
     *   updates to this field are to be allowed. If the specified expression does not
     *   evaluate to true, the field will be removed from the request as described for
     *   DataSourceField.editRequiresAuthentication.
     * 
     *   In addition to the normal context variables available to Velocity expressions in SmartClient,
     *   expressions you write for field-level requires clauses - updateRequires,
     *   DataSourceField.viewRequires, DataSourceField.editRequires and
     *   DataSourceField.initRequires - can reference two additional variables:
     *   $fieldName and $dsName. These are the names of the dataSource and
     *   field currently undergoing requires checks. They are helpful because they allow
     *   you to write a generic checker function that can be used to handle requires
     *   checks for multiple fields and dataSources.
     * 
     *   NOTE: This property only prevents update of a field; initialization will still be
     *   allowed. You should only use this property if you have a special requirement; ordinarily,
     *   use DataSourceField.editRequires, which applies security for both types of write.
     *  @type {VelocityExpression}
     *  @default null
     */
    open var updateRequires: String = definedExternally
    /**
     *  Indicates that normal declarative security rules specified on this field are waived for
     *   rows that were created by the current user, as described in the discussion of
     *   DataSource.creatorOverrides. This setting overrides
     *   dataSource.creatorOverrides, for this field only.
     * 
     *   Note that field-level creatorOverrides is conceptually slightly different to
     *   the setting at DataSource and OperationBinding levels. To give the example of a fetch
     *   operation, at the other two levels, it results in a limited set of rows being returned,
     *   rather than a security exception being thrown. At the field-level, it results in values
     *   for individual fields being present in those rows, rather than them being stripped out on
     *   the server.
     *  @type {boolean}
     *  @default null
     */
    open var creatorOverrides: Boolean = definedExternally
    /**
     *  Setting audit to false explicitly indicates that this field will
     *   not be saved to the audit DataSource when DataSource.audit is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var audit: Boolean = definedExternally
    /**
     *  For a DataSource with DataSource.serverType "sql" or "hibernate",
     *   indicates that this field should be omitted by default from all SQL or Hibernate operations,
     *   and will only be used with customQuerying.
     * 
     *   Having marked a field as customSQL you can refer to it via
     *   $criteria.fieldName or $values.fieldName in customized queries.
     * 
     *   The following are situations where you would not use customSQL:
     * 
     * 
     *  - simple joins where you want to enable users to see and search on a field from another
     *   table; consider DataSourceField.includeFrom instead
     * 
     *  - fields where you want to calculate or transform values in SQL on load or save, but
     *   always perform the same calculation for each operationType; consider instead
     *   DataSourceField.sqlStorageStrategy for some common cases, or
     *   DataSourceField.customSelectExpression, DataSourceField.customUpdateExpression and
     *   DataSourceField.customInsertExpression for full customization
     * 
     *  - a special fetch is needed where the field needs to be excluded from the
     *   $defaultWhereClause so that it can be used in a custom &lt;whereClause&gt; - consider
     *   OperationBinding.excludeCriteriaFields instead
     * 
     * 
     *   Use customSQL in situations like:
     * 
     * 
     *  - there are multiple variations of the "fetch" operation with different
     *   OperationBinding.operationId, and the field is only used in some of them;
     *   in that case, consider using OperationBinding.customFields to selectively re-introduce
     *   SQL generation for the field only in operations where it's used.
     * 
     *  - the field represents hidden criteria on a field in another table where the field is
     *   never shown to the user
     * 
     *  - the field is a write-only value only saved in some operations
     * 
     *  - more than one data access strategy is in use (eg direct SQL for fetch and bean-based
     *   persistence accessed via DMI for saves) and certain fields are not available in SQL
     * 
     *  @type {boolean}
     *  @default null
     */
    open var customSQL: Boolean = definedExternally
    /**
     *  This property indicates that this field represents a custom expression that should be
     *   embedded in the generated SQL instead of a reference to this field. For example, if
     *   you have a field partialName where this value is set to
     *   SUBSTR(surname, 2), the generated SQL would look similar to this:
     * 
     *    SELECT ... SUBSTR(surname, 2) AS partialName ...
     * 
     *   Note that adding "AS partialName" as shown above is required - this is how the framework
     *   identifies the expression as producing a value for this particular DataSourceField when
     *   results are received from the database.
     * 
     *   Fields with customSelectExpression set can be used for sorting and filtering in
     *   the normal way, but they are only applicable to update-type operations if you also provide a
     *   corresponding DataSourceField.customUpdateExpression and/or
     *   DataSourceField.customInsertExpression. See the documentation
     *   for those methods for the rules of how they are applied.
     * 
     *   You can use Velocity expressions in your customSelectExpressions, and the
     *   velocitySupport are available. Note that the results
     *   of Velocity evaluations are automatically quoted and escaped by default; this behavior can
     *   be switched off - see DataSourceField.autoQuoteCustomExpressions, and
     *   particularly note the warnings about its use.
     * 
     *   Note that this property only applies to users of the SmartClient server using dataSources of
     *   type "sql".
     *  @type {VelocityExpression}
     *  @default null
     */
    open var customSelectExpression: String = definedExternally
    /**
     *  This property specifies the value to use to update this column on "update" operations.
     *   The value of this property will be passed through Velocity evaluation and then embedded
     *   directly in the SQL generated to perform the update. It can be used in conjunction with
     *   DataSourceField.customSelectExpression to provide bi-directional mapping
     *   between application data formats and persisted data formats. Or, it can be used
     *   unilaterally as a means of silently enforcing data rules - for example, ensuring that all
     *   values for a given field are in upper case.
     * 
     *   You can use Velocity expressions in your customUpdateExpressions, and the
     *   velocitySupport are available. Note that the results
     *   of Velocity evaluations are automatically quoted and escaped by default; this behavior can
     *   be switched off - see DataSourceField.autoQuoteCustomExpressions, and
     *   particularly note the warnings about its use.
     * 
     *   The value must be a string that will end up as a valid SQL snippet after Velocity
     *   evaluation. The following examples are valid:
     * 
     * 
     *  - "SUBSTR(ANOTHER_COLUMN, 1, 10)"
     * 
     *  - "SUBSTR($values.someTextField.toUpperCase(), 1, 10)"
     * 
     *  - "SOME_NUMERIC_COLUMN \* 1000"
     * 
     *  - "$values.someTextField.toUpperCase()" (this is a technically valid but
     *   incorrect usage - see below)
     * 
     *   NOTE: although all these examples are valid, customUpdateExpression is
     *   intended to be used when you have a need to customize the actual SQL. If you simply want
     *   to use a server-derived value in the query (as is the case with the last of these
     *   examples), you should use transactionChaining,
     *   dmiOverview, or a serverScript instead.
     * 
     *   In the examples above, the first is an actual SQL snippet and must not be enclosed
     *   in quotes. The second shows an SQL snippet containing a literal - because the literal is
     *   the result of a Velocity evaluation, it will be automatically quoted so there is no need
     *   to do so manually. The third example yields a number, so it must not be quoted.
     *   The last example is also the result of a Velocity evaluation and thus does not need to
     *   be quoted. Note, however, that this example involves no SQL customization - this kind of
     *   usage should be avoided, as noted above.
     * 
     *   When an "update" operation runs, any fields that specify
     *   DataSourceField.customSelectExpression but do not specify
     *   customUpdateExpression will be ignored. When an "add" operation runs, this property acts
     *   as a default for any fields that do not specify a
     *   DataSourceField.customInsertExpression; similar to update, any fields that
     *   specify a customSelectExpression but do not specify either a customUpdateExpression or
     *   customInsertExpression, will be ignored when "add" operations run.
     * 
     *   Note that this property only applies to users of the SmartClient server using dataSources of
     *   type "sql".
     *  @type {VelocityExpression}
     *  @default null
     */
    open var customUpdateExpression: String = definedExternally
    /**
     *  This property is similar to DataSourceField.customUpdateExpression; its value
     *   is used during "add" operations. If you do not specify this property, but do specify a
     *   customUpdateExpression, the customUpdateExpression is used instead.
     * 
     *   Everything that applies to customUpdateExpression also applies to this property,
     *   including the observation that fields which specify a
     *   DataSourceField.customSelectExpression but no corresponding
     *   customUpdateExpression or customInsertExpression, will be ignored
     *   when adding new records.
     * 
     *   As with customUpdateExpression, this property is only intended to be used when
     *   you have a need to customize the actual SQL. If you simply want to use a server-derived
     *   value in the query, you should use transactionChaining,
     *   dmiOverview, or a serverScript instead.
     * 
     *   customInsertExpression with primaryKey fields
     * 
     *   if you use customInsertExpression to derive a value for a
     *   DataSourceField.primaryKey field, the key value will not by default be
     *   available to the framework, so the built-in cache synchronization system will not work.
     *   It may be possible to to work around this with the
     *   DataSourceField.autoGenerated flag, as described below, but otherwise
     *   you must also create a OperationBinding.cacheSyncOperation which
     *   can retrieve the record just added to the database. Please also see the documentation for
     *   SequenceMode, which talks further about cacheSyncOperation.
     * 
     *   Typically, primaryKey fields that need to be auto-generated are implemented
     *   using a sequence field, which at the database level translates to either an actual sequence,
     *   or an auto-increment or "identity" column. JDBC drivers have special support for such
     *   columns, so we are able to determine the generated value. This is important for primaryKey
     *   fields because, without it, we cannot re-fetch the record just inserted for cache
     *   synchronization purposes, as described above. Where a value is generated by something other
     *   than a sequence field, this special ability is lost - or at least, it is no longer
     *   guaranteed to be present.
     * 
     *   There are use cases where this may seem to be a restriction. A common case would be where
     *   you wish to use a generated UUID as primaryKey value, rather than an ordinary ascending
     *   sequence. If you had intended to do this using the database itself - for example,
     *   specifying a customInsertExpression that calls something like MySQL's
     *   UUID() built-in function - this is potentially a problem. What we
     *   would recommend in this case and anything similar, is to use the general ability for field
     *   values to be generated by application code, as described above. (Note, if you want to have
     *   application code generate values for primaryKey fields, you may need to use an
     *   OperationBinding that specifies
     *   OperationBinding.providesMissingKeys).
     * 
     *   That said, different database vendors implement their JDBC drivers in different ways, and
     *   with the SQLDataSource and certain database products it is possible to retrieve
     *   values that were generated at the database level by a customInsertExpression
     *   that expresses either a user-defined function call or an inline subselect, as long as the
     *   field is marked with the autoGenerated flag. Because this behavior
     *   is potentially useful, we do not inhibit it; however, we also do not recommend that you make
     *   use of it, because the behavior is not portable across databases, and may also not be
     *   portable across JDBC driver versions (because the behavior is unspecified and undocumented,
     *   and relies on implementation details that may change). Databases where this behavior has
     *   been observed to work include Oracle, Postgres and HSQLDB; databases where this behavior is
     *   known not to work include MySQL, SQL Server, DB2 and Firebird (the latter because its JDBC
     *   driver does not support the getGeneratedKeys() API)
     * 
     *   Note that this property only applies to users of the SmartClient server using dataSources of
     *   type "sql".
     *  @type {VelocityExpression}
     *  @default null
     */
    open var customInsertExpression: String = definedExternally
    /**
     *  This property indicates that this field should be represented by a custom expression
     *   embedded in the WHERE clause of the generated SQL, instead of the generated expression
     *   containing this field name that would ordinarily be used. You use this property when
     *   you have to accomodate some special way of using a field's value in criteria, other than by
     *   directly comparing it to the criteria. For example, if you have a column that contains
     *   bit-packed information you will generally need to perform a bitwise AND to filter on that
     *   column, rather than an equality check. In this case, you would use a
     *   customCriteriaExpression something like this (in Oracle):
     * 
     *   &nbsp;&nbsp;&nbsp;BITAND(myField, $criteria.myField)+0 = $criteria.myField
     * 
     *   Or this (in MySQL or SQL Server):
     * 
     *   &nbsp;&nbsp;&nbsp;myField & $criteria.myField = $criteria.myField
     * 
     *   As this example shows, a customCriteriaExpression is expected to be a complete
     *   logical expression that provides both sides of the comparison. After Velocity processing,
     *   this example would result in SQL similar to this (for the MySQL case); the colored part
     *   comes entirely from the customCriteriaExpression:
     * 
     *   SELECT myField, myOtherField FROM myTable WHERE myField & 32 = 32
     * 
     *   customCriteriaExpression can also be used with AdvancedCriteria.
     *   Note that the point mentioned above, about a customCriteriaExpression being a
     *   complete logical expression that provides both sides of the comparison still applies. This
     *   means that when you use customCriteriaExpression in conjunction with
     *   AdvancedCriteria, you effectively switch off support for different
     *   OperatorIds to be used on that field, unless you use Velocity expressions
     *   containing the special $criteriaOperator variable (see below).
     * 
     *   When you use customCriteriaExpression with AdvancedCriteria, the
     *   way you access criteria values differs slightly. One option is to use the
     *   $advancedCriteria Velocity variable, as described in the "Using AdvancedCriteria"
     *   section of the customQuerying. However, this
     *   variable only returns the value from the first Criterion that uses the field,
     *   as found by depth-first search. If your AdvancedCriteria contains multiple
     *   references to this field, this will not be satisfactory. Therefore, specifically for
     *   customCriteriaExpression, we provide another Velocity variable,
     *   $criteriaValue. This variable means "the value on a Criterion referencing
     *   this field". An example may serve to clarify this:
     * 
     *   Assume you need to extend the above example to filter records where a certain bit is set
     *   OR a certain other bit is set. An AdvancedCriteria like this would be
     *   required (note that the choice of "equals" as the operator in these clauses is completely
     *   arbitrary - as discussed above, the operator is ignored when we have a
     *   customCriteriaExpression, so it would make no difference to the end product
     *   if we had used different operators here):
     *    { _constructor: "AdvancedCriteria", operator: "or", criteria: [
     *      { fieldName: "myField", operator: "equals", value: 32 },
     *      { fieldName: "myField", operator: "equals", value: 64 },
     *     ]
     *    }
     * 
     *   If you used the customCriteriaExpression from above unchanged with this criteria,
     *   the following SQL would be generated (in the MySQL case):
     * 
     *   SELECT myField, myOtherField FROM myTable WHERE myField & null = null OR myField & null = null
     * 
     *   This is because $criteria is a variable that only works correctly with simple
     *   criteria. If you changed the $criteria references in the expression to
     *   $advancedCriteria, the generated SQL would be:
     * 
     *   SELECT myField, myOtherField FROM myTable WHERE myField & 32 = 32 OR myField & 32 = 32
     * 
     *   This is because $advancedCriteria always returns the first value it finds for
     *   a particular field, as described above. However, if you change the expression so it reads:
     * 
     *   &nbsp;&nbsp;&nbsp;myField & $criteriaValue = $criteriaValue
     * 
     *   you will now get the correct SQL generated:
     * 
     *   SELECT myField, myOtherField FROM myTable WHERE myField & 32 = 32 OR myField & 64 = 64
     * 
     *   Similar to $criteriaValue, we provide a special variable,
     *   $criteriaOperator. This is intended for use in Velocity expressions, so that
     *   your customCriteriaExpression can process different operators in different ways.
     *   How you choose to interpret an operator is entirely up to you; this variable is both
     *   advanced and rarely used. This example is contrived and does not show a usage that would be
     *   remotely likely in a real application, but it does show how to use the variable in a Velocity
     *   expression:
     * 
     *   &nbsp;&nbsp;&nbsp;myField #if ($criteriaOperator == "greaterThan") & #else | #end $criteriaValue = $criteriaValue
     * 
     *   For simple criteria, note that $criteriaOperator will vary depending on field
     *   type and the TextMatchStyle in force, as follows:
     * 
     *  - Text fields with textMatchStyle "substring" - "iContains"
     * 
     *  - Text fields with textMatchStyle "startsWith" - "iStartsWith"
     * 
     *  - Text fields with textMatchStyle "exact" - "iEquals"
     * 
     *  - All other cases (including text fields with textMatchStyle "exactCase") - "equals"
     * 
     *   You can use Velocity expressions in your customCriteriaExpressions, and the
     *   velocitySupport are available. Note that the results
     *   of Velocity evaluations are automatically quoted and escaped by default; this behavior can
     *   be switched off - see DataSourceField.autoQuoteCustomExpressions, and
     *   particularly note the warnings about its use.
     * 
     *   Note that this property only applies to users of the SmartClient server using dataSources of
     *   type "sql".
     *  @type {VelocityExpression}
     *  @default null
     */
    open var customCriteriaExpression: String = definedExternally
    /**
     *  If explicitly set to false, switches off automatic quoting and escaping of values in
     *   custom expressions that are derived from Velocity evaluations.
     * 
     *   By default, any part of a DataSourceField.customSelectExpression,
     *   DataSourceField.customCriteriaExpression,
     *   DataSourceField.customUpdateExpression or
     *   DataSourceField.customInsertExpression that comes ultimately from evaluating
     *   a Velocity expression, will be automatically quoted and escaped according to the syntax
     *   of the underlying database. We do this because "raw" values are vulnerable to
     *   SQL injection attacks.
     * 
     *   However, it is possible that the exact SQL logic you desire for a custom expression cannot
     *   be expressed without access to the raw, unquoted value. To work around this, you can either
     *   use the special velocitySupport context variable, or you can set this
     *   property to false to switch off auto-quoting completely for all custom expressions on this
     *   field.
     * 
     *   Warning: Bear in mind that it is dangerous to use raw values. There are some
     *   cases where using the raw value is necessary, but even so, all such cases are likely to be
     *   vulnerable to injection attacks. Generally, the presence of $rawValue in a
     *   custom expression, or any fields with autoQuoteCustomExpressions: false
     *   specified, should be viewed as a red flag.
     *  @type {boolean}
     *  @default true
     */
    open var autoQuoteCustomExpressions: Boolean = definedExternally
    /**
     *  Only applicable to "sql" dataSources. If set, this property indicates that the field is
     *   bound to the column named in the property. It is used to bind a DataSourceField to a
     *   database column with a different name.
     * 
     *   nativeName is useful for disambiguating in cases where you have customized
     *   SQL. For example, assume you are joining two tables - call them product and
     *   supplier - that both contain a column called "name". Only one field in the
     *   DataSource can be called "name"; to disambiguate, we need to specify both
     *   DataSourceField.tableName and nativeName. A field declaration
     *   like this would be needed:
     *     &lt;field name="supplierName" type="text" tableName="supplier" nativeName="name" />
     * 
     *   You may also wish to use this property to map legacy column names to more meaningful field
     *   names in the DataSource. For example:
     *     &lt;field name="productName" type="text" nativeName="PRDNM" />
     * 
     *   Note that it is not allowed to have multiple fields with the same nativeName
     *   bound to the same database table.
     *  @type {string}
     *  @default null
     */
    open var nativeName: String = definedExternally
    /**
     *  Only applicable to "sql" dataSources, setting tableName indicates that this
     *   field will be coming from another table by way of a
     *   customQuerying.
     * 
     *   By default, the SQL generator will not include this field in generated SQL for "add"
     *   or "update" operations. It will include the field in the SELECT clause and WHERE clause of
     *   customized "fetch" operations, where it is expected that you will make the table available
     *   via a custom &lt;tableClause&gt; as shown in ${isc.DocUtils.linkForExampleId('largeValueMapSQL', 'this sample')}.
     * 
     *   The table name will also be used to qualifying the column name unless
     *   DataSource.qualifyColumnNames or OperationBinding.qualifyColumnNames has been
     *   disabled.
     * 
     *   Note: This property is only required when including fields from tables other than the
     *   default table specified by DataSource.tableName.
     *  @type {string}
     *  @default null
     */
    open var tableName: String = definedExternally
    /**
     *  When using DataSource.recordsAsText, determines what approach (if any) should be used
     *   to force values to be intepreted as text instead of heuristically parsed as dates, times or
     *   other structured types.
     *  @type {boolean}
     *  @default false
     */
    open var exportForceText: Boolean = definedExternally
    /**
     *  Declares the FieldImportStrategy for this field. The default setting of null
     *   has the same meaning as "auto". Note, this attribute only has an effect if all of the
     *   following are true:
     * 
     *  - The field declares a DataSourceField.foreignKey
     * 
     *  - The field declares a DataSourceField.displayField
     * 
     *  - The displayField so declared is DataSourceField.includeFrom the
     *   same DataSource that the foreignKey declaration refers to
     * 
     *   In any other circumstances, this attribute is ignored.
     * 
     *   importStrategy is applied by the server-side
     *   DataImport.importToRows() method, which is in turn used by
     *   BatchUploader and several other DataImport APIs such as
     *   importToDataSource(), importDataSourceRecords() and
     *   importAndValidateDSRows(). See the server-side documentation for
     *   details of these APIs. The actual data transformation is carried out by the
     *   server-side API DataSource.transformImportValue(); this method can
     *   be overridden to carry out any other transformation you may require.
     *  @type {FieldImportStrategy}
     *  @default null
     */
    open var importStrategy: 
                             /**
                              *  The import process expects values in the import dataset to be the real     underlying key values, and performs no transformation
                              *  The import process expects values in the import dataset to be display     values, and it will transform them to the corresponding underlying keys
                              *  The import process will attempt to discover the best setting to use, based    on the values in the first record, and use that setting for every remaining record
                              *      in the import dataset
                              */
                             String /* key |  display |  auto */ = definedExternally
    /**
     *  For certain field types, indicates the strategy to be used to store values to the underlying
     *   SQL column.
     * 
     *   Fields of type "boolean"
     *   The default strategy for boolean fields is to assume the underlying type of the field is
     *   text and store boolean true and false values as the character strings "true" and "false".
     *   The following additional strategies are available:
     * 
     * 
     *  - "number" or "integer": store true as 1, false as 0
     * 
     *  - "singleChar10": store true as "1", false as "0"
     * 
     *  - "singleCharYN": store true as "Y", false as "N"
     * 
     *  - "singleCharTF": store true as "T", false as "F"
     * 
     *  - "singleChar": store as a single character, using the values defined by
     *   DataSourceField.sqlTrueValue and
     *   DataSourceField.sqlFalseValue
     * 
     *  - "string": store the entire values defined by
     *   DataSourceField.sqlTrueValue and
     *   DataSourceField.sqlFalseValue
     * 
     * 
     *   Fields of type "date", "time", and "datetime"
     *   The default strategy for these types is to use a native type that supports date and
     *   time values to the nearest second; the actual type used varies by database. The following
     *   additional strategies are available:
     * 
     * 
     *  - "nativeDate": Use a native SQL DATE type
     * 
     *  - "number" or "integer": Store the value as a plain numeric value
     * 
     *  - "text": Store the value as a plain text value
     * 
     *   The "number" and "text" strategies for date/time/datetime fields are provided to allow transparent
     *   two-way mapping of legacy date values; you would not ordinarily use them in the absence of a
     *   legacy database. In both cases, the actual format of the number or text string is determined
     *   by specifying a DataSourceField.sqlDateFormat on the field; if no
     *   format is specified, the framework defaults to "yyyyMMdd".
     * 
     * 
     *   Fields of type "text"
     *   NOTE: This section is only applicable for users of Microsoft SQL Server. The "ntext"
     *   strategy is ignored for all other databases.
     *   If you are integrating with Microsoft SQL Server, you may run into an issue with that database
     *   and double-byte character sets. Although the documentation indicates that string values are
     *   sent to the database as Unicode by default, they may undergo conversion at the database end,
     *   depending on the collation settings of the database.
     *   This Microsoft support article describes
     *   the situation, which is that Unicode is converted to the code page of the database before
     *   being used, in order to "provide backward compatibility with existing applications".
     * 
     *   To work around this, we provide an sqlStorageStrategy of "ntext". Fields that
     *   declare this strategy are inserted into queries using the "N syntax", like so:
     *   &nbsp;&nbsp;&nbsp;UPDATE MyTable SET MyTextColumn = N'some text' WHERE MyPK = N'some key'
     * 
     *   This syntax overrides defaults and forces the database to treat strings as Unicode.
     * 
     *   Note that declaring a field to be of FieldType "ntext" is exactly
     *   equivalent to specifying type "text" and an sqlStorageStrategy of "ntext".
     *   If you declare a field of type "ntext" when the back-end database is something other than
     *   SQL Server, it will be treated as a normal field of type "text".
     * 
     *   This property only applies to users of the SmartClient server using dataSources of
     *   type "sql".
     *  @type {string}
     *  @default null
     */
    open var sqlStorageStrategy: String = definedExternally
    /**
     *  For fields of type "date", "time", and "datetime" that specify an
     *   DataSourceField.sqlStorageStrategy of "number" or "text", this
     *   property allows you to specify the format SmartClient should use to map to/from the
     *   underlying value stored in the database. The string provided must be a valid
     * 
     *   SimpleDateFormat pattern string.
     * 
     *   For fields of type "datetime" and "time" that specify an
     *   DataSourceField.sqlStorageStrategy of "number", two special
     *   sqlDateFormat values are supported:
     * 
     * 
     *  - "epoch" - The datetime or time value is stored as the number of full seconds that have
     *      elapsed since January 1, 1970, 00:00:00 GMT.
     * 
     *  - "epochms" - The datetime or time value is stored as the number of milliseconds that
     *      have elapsed since January 1, 1970, 00:00:00 GMT. Millisecond precision is preserved
     *      through database roundtrips with this setting
     * 
     * 
     *   This property and the "number" and "text" strategies for date/datetime fields are provided
     *   to allow transparent two-way mapping of legacy date values that are stored in numeric or
     *   text columns respectively rather than a true "date" column. You would not ordinarily use them
     *   in the absence of a legacy database.
     * 
     *   Note that this property only applies to users of SmartClient server and data sources of
     *   type "sql".
     *  @type {string}
     *  @default null
     */
    open var sqlDateFormat: String = definedExternally
    /**
     *  For fields of type "datetime", indicates whether the framework should attempt to preserve
     *   the millisecond part when persisting to native SQL datetime-type columns. Whether this
     *   is possible depends on the type and version of the underlying database product; some
     *   databases - for example SQL Server earlier than 2008 and MySQL versions earlier than
     *   5.6 - do not provide fractional seconds support. If you set this flag when your underlying
     *   database cannot support fractional seconds, it will be ignored.
     * 
     *   Other than the two cases just mentioned which are known to fail, storeMilliseconds
     *   has been tested and is officially supported with the following products and minimum
     *   versions:
     * 
     *  - Oracle 10g
     * 
     *  - Microsoft SQL Server 2008
     * 
     *  - MySQL 5.6
     * 
     *  - PostgreSQL 9.1
     * 
     *  - HSQLDB 2.2
     * 
     *  - DB2 for Unix/Linux 9.7
     * 
     *  - Firebird 11.2
     * 
     *  - Informix IDS 11.5
     * 
     *   Note that you can use DataSourceField.sqlStorageStrategy to store a datetime
     *   value with sub-second precision in any database - see below.
     * 
     *   When the system generates SQL to insert or update datetime values including a millisecond
     *   element, it does so using a database-specific format string specified in property
     *   defaultDateTimeFormatWithMilliseconds in your server.properties
     *   file. These format strings should conform to the rules of the
     * 
     *   Java SimpleDateFormat class. Suitable format strings are provided for all default
     *   databases out of the box; if you need to override one or provide a new one, you do so as
     *   shown in this example:
     *    sql.MyNewDatabase.defaultDateTimeFormatWithMilliseconds: yy-MM-dd'T'hh.mm.ss.SSS
     * 
     *   Note that this property only controls the persistence of milliseconds into the database;
     *   there is no built-in support for sub-second elements of datetimes in any SmartClient visual
     *   components. See also the documentation for DataSource.trimMilliseconds for more
     *   details of how sub-second datetime elements are handled in the client-server flow.
     * 
     *   This property is only applicable to DataSources of DSServerType
     *   "sql" and fields of FieldType "datetime". It is ignored in all other
     *   cases. However, note that the built-in JPA and Hibernate dataSources will always persist
     *   millisecond values automatically if the underlying Java type, database and column support
     *   it.
     * 
     *   Finally, note that this property only has an effect on native datetime-type fields.
     *   When you use DataSourceField.sqlStorageStrategy to store a temporal value in a
     *   text or number column, it is the DataSourceField.sqlDateFormat you use that dictates
     *   the precision. For example, a field with sqlStorageStrategy:"text" and
     *   sqlDateFormat:"yyyy-MM-dd hh:mm:ss.SSS" would store and retrieve with millisecond
     *   precsion; the same field with sqlDateFormat:"yyyy-MM-dd hh:mm" would store
     *   and retrieve with precision to the nearest minute only.
     *  @type {boolean}
     *  @default null
     */
    open var storeMilliseconds: Boolean = definedExternally
    /**
     *  For fields of type "boolean" that specify a
     *   DataSourceField.sqlStorageStrategy of "singleChar", this is the
     *   value to persist for true values. Note that the common use cases of storing booleans as
     *   T/F, Y/N and 1/0 are already catered for without the need for this property.
     *   For fields of type "boolean" that specify a
     *   DataSourceField.sqlStorageStrategy of "string", this is the value
     *   to persist for true values that require using the entire value.
     *  @type {string}
     *  @default null
     */
    open var sqlTrueValue: String = definedExternally
    /**
     *  For fields of type "boolean" that specify a
     *   DataSourceField.sqlStorageStrategy of "singleChar", this is the
     *   value to persist for false values. Note that the common use cases of storing booleans as
     *   T/F, Y/N and 1/0 are already catered for without the need for this property.
     *   For fields of type "boolean" that specify a
     *   DataSourceField.sqlStorageStrategy of "string", this is the value
     *   to persist for false values that require using the entire value.
     * 
     *   You can specify NULL as a valid value for sqlFalseValue, using this XML notation:
     * 
     *   &lt;sqlFalseValue xsi:nil="true"&gt;&lt;/sqlFalseValue&gt;
     * 
     *  @type {string}
     *  @default null
     */
    open var sqlFalseValue: String = definedExternally
    /**
     *  If DataSource.noNullUpdates is set, the value to use for this field when a null
     *   value is assigned to it on an update operation. This property overrides the DataSource-level
     *   properties DataSource.nullStringValue,
     *   DataSource.nullIntegerValue,
     *   DataSource.nullFloatValue and
     *   DataSource.nullDateValue, for this field only.
     * 
     *   NOTE: If you use this property, you are responsible for ensuring that the replacement value
     *   is appropriate and valid.
     *  @type {any}
     *  @default null
     */
    open var nullReplacementValue: dynamic = definedExternally
    /**
     *  Server-side setting that causes values for fields of type "integer" or "float" to be represented
     *   as Strings when delivered to a web browser, in order to avoid mangling values which cannot be
     *   represented faithfully in JavaScript.
     * 
     *   JavaScript has a single "Number" type which internally stores numbers in a format equivalent to
     *   Java's "Double" - double-precision floating point. This means it cannot represent the full
     *   range of Java's Long type: Java Longs can represent integral values between -2^63 to 2^63-1,
     *   whereas JavaScript Number can only represent exact integer values between -2^53 and 2^53.
     *   Similarly, JavaScript's Number type cannot represent Java's unlimited-size BigInteger or
     *   unlimited-precision BigDecimal objects at all.
     * 
     *   The stringInBrowser setting can be used to deliver numeric values as Strings to the
     *   browser. This is intended to allow read-only display and successful round-tripping of the
     *   numeric value, however, it will not cause number-oriented features such as SpinnerItem,
     *   Slider, ListGrid.showGridSummary or range-checking
     *   Validator or AdvancedCriteria to actually work.
     * 
     *   If stringInBrowser is not set, the default behavior is configured by the
     *   server.properties setting datasource.defaultStringInBrowser. If
     *   this flag is false, numeric values are delivered to the client as numbers, even where
     *   this will lead to a loss of precision. If the flag is true (which is the the default),
     *   the behavior is to prevent range overflow for numeric values:
     * 
     * 
     *  - Java values of type Long, BigInteger and BigDecimal will be delivered as
     *     String only if they exceed JavaScript's number range.
     * 
     *  - Client-side validation will allow inputs that are outside of JavaScript's normal
     *     integer range, and such numbers will remain as Strings after validation, instead of being
     *     converted to Numbers
     * 
     *  - Values submitted to the server will be converted to BigInteger if they exceed the range
     *     of Java's Long type. This happens during DSRequest validation, before any defined
     *     dmiOverview are called.
     * 
     * 
     *   This default set of behaviors is intended to automatically deal with cases like numeric
     *   DataSourceField.primaryKey or DataSourceField.foreignKey values that are never used as numbers, but happen to use
     *   the full Java Long range. To disable the above behaviors, set stringInBrowser="false".
     * 
     *   If stringInBrowser is explicitly set to true:
     * 
     * 
     *  - the value for the field will always be delivered to the browser as a String (no
     *     attempt is made to detect the value as out of range / too high precision)
     * 
     *  - client-side validation will do a check for valid format only, and always leave the value
     *     as a String. Numeric range validators are ignored client-side (always pass), but are
     *     still active server-side.
     * 
     *  - AdvancedCriteria OperatorId that check if values are in a particular
     *     range will always pass
     * 
     *  - the field is treated as though DataSourceField.canFilter were set, to avoid showing
     *     non-functional search interfaces to the user. Set canFilter="true" to avoid
     *     this effect
     * 
     * 
     *   This setting is recommended for presenting out-of-range issues or precision loss on fields that
     *   represent actual quantities (as opposed to primaryKey or foreignKey fields, which really
     *   represent IDs). To ensure unlimited-precision BigDecimal values are preserved, you should also
     *   set DataSourceField.javaClass.
     * 
     *   Note that responses delivered as JSON or XML, such as responses from the
     *   servletDetails, are not affected. This setting applies only
     *   to responses delivered to a web browser.
     * 
     *   The entirety of stringInBrowser processing can be completely disabled by setting
     *   server.properties flag datasource.disableStringInBrowser to true.
     *   This will cause all numeric values to be delivered as numbers without even attempting to
     *   detect if this will lead to a loss of precision. This setting overrides both the
     *   stringInBrowser field setting and the
     *   datasource.defaultStringInBrowser server.properties flag.
     * 
     *   stringInBrowser and client-side DataSources
     * 
     *   For DataSources that are not based on the SmartClient Server, the client-side behaviors described above (such as leaving
     *   user input in string form if precision would be lost) are active by default.
     * 
     *   In addition, if DataSource.dataFormat is used, values that would lose precision remain as strings. For JSON,
     *   if behavior similar to stringInBrowser is desired, your server response must send the values as JSON strings
     *   rather than JSON numeric literals.
     * 
     *   You can use DataSource.defaultStringInBrowser to disable these behaviors. NOTE: don't use this setting if
     *   you are using the SmartClient Server, use the server.properties approach described above instead.
     *  @type {boolean}
     *  @default null
     */
    open var stringInBrowser: Boolean = definedExternally
    /**
     *  Causes values for this field to be sorted according to values for another field, for
     *   both client- and server-side sorting.
     * 
     *   This can be used to establish a sort order for a field that is not the normal sorting
     *   order indicated by the field value, typically by having the sortByField as
     *   a DataSourceField.hidden.
     * 
     *   If using SQLDataSource, consider using a DataSourceField.customSelectExpression as an efficient
     *   way to populate the sortByField with the results of a SQL expression.
     *  @type {string}
     *  @default null
     */
    open var sortByField: String = definedExternally
    /**
     *  NOTE: Only applicable to DataSource.clientOnly DataSources and the
     *   built-in sqlDataSource, jpaIntegration and
     *   hibernateIntegration DataSources available in Pro, Power and
     *   Enterprise versions of SmartClient.
     * 
     *   Use this flag to inhibit the normal use of TextMatchStyle for this field. A
     *   field with this flag set will always be tested for exact equality in generated queries,
     *   even for filter-style queries where normal behavior would be to use a substring match or
     *   similar.
     * 
     *   Whether or not the exact match is case-sensitive is determined by the DataSource's
     *   DataSource.ignoreTextMatchStyleCaseSensitive
     *   setting.
     *  @type {boolean}
     *  @default null
     */
    open var ignoreTextMatchStyle: Boolean = definedExternally
    /**
     *  When true, this field can only be used for sorting if the data is entirely client-side.
     *  @type {boolean}
     *  @default false
     */
    open var canSortClientOnly: Boolean = definedExternally
    /**
     *  If set, causes the field to be securely hashed before saving on an "add" or "update"
     *   operation.
     *  @type {HashAlgorithm}
     *  @default null
     */
    open var storeWithHash: 
                            /**
                             *  Message Digest algorithm 5
                             *  Secure Hashing Algorithm (SHA-1)
                             *  bcrypt is a password hashing function designed by Niels Provos and David MaziÃ¨res, based on the Blowfish cipher
                             */
                            String /* MD5 |  SHA |  bcrypt */ = definedExternally
    /**
     *  For fields of a type that are represented by binary data initially uploaded from a file
     *   (currently "binary" and "imageFile", see FieldType), this sets the maximum
     *   file size allowed, in bytes.
     *  @type {Integer}
     *  @default null
     */
    open var maxFileSize: Number = definedExternally
    /**
     *  When set for a field with binary data, binary data will be delivered as a Base64 encoded
     *   string.
     * 
     *   When encodeInResponse is not set normal responses will not contain values for
     *   binary fields at all. Instead, UI components, such as TileGrid issue a second
     *   binary fetch for binary data when appropriate, and APIs such as DataSource.downloadFile and
     *   DataSource.viewFile can be used to programmatically trigger downloads.
     * 
     *   Only applicable to fields of a type that are represented by binary data (currently "binary"
     *   and "imageFile", see FieldType).
     *  @type {boolean}
     *  @default null
     */
    open var encodeInResponse: Boolean = definedExternally
    /**
     *  Format string to use when rendering the value in any DataBoundComponent or when
     *   exporting via DataSource.exportData or ListGrid.exportData or
     *   ListGrid.exportClientData.
     * 
     *   Supported for fields of type "date", "time", "datetime", "int", "float" or any derived
     *   SimpleType.
     * 
     *   To configure a different format for export, use DataSourceField.exportFormat.
     * 
     *   This is a per-field setting; you can alternatively set a default format for all "date",
     *   "time" or "datetime" fields via
     * 
     *   DateUtil.setNormalDatetimeDisplayFormat and related methods on Date.
     * 
     * 
     *   See also localizedNumberFormatting for built-in FieldType
     *   that handle localized currency formatting.
     * 
     *   Also note, this property takes precedence over any specified
     *   DataSourceField.dateFormatter, but can be overridden on a per-component
     *   basis by providing a formatter directly on the component, for example, via
     *   ListGrid.formatCellValue or FormItem.formatValue.
     *  @type {FormatString}
     *  @default null
     */
    open var format: String = definedExternally
    /**
     *  An optional FormatString for this field, for use when
     *   DataBoundComponent.exportData data to spreadsheet formats (XLS and
     *   OOXML/XLSX), XML, JSON or CSV.  You can use this property to override the normal
     *   DataSourceField.format of this field, if any, specifically for exports.
     * 
     *   Note, for server-driven exports you can specify default formats for date, time and
     *   datetime fields by specifying properties export.format.default.date,
     *   export.format.default.time and export.format.default.datetime
     *   in your server.properties file. These formats will be used for fields
     *   that do not have a "format" or "exportFormat" property specified in the
     *   .ds.xml file.
     * 
     *   Specifically when exporting to spreadsheet formats, the FormatString is
     *   translated to the type of format string used by spreadsheet programs like Excel. A handful
     *   of features are not present in Excel format strings, and some features behave slightly
     *   differently. These differences are explained below.
     * 
     *   Excel cannot handle dates prior to January 1st 1900
     *   This is a well-known limitation of Excel dates; it is not a formatting issue as such.
     * 
     *   Currency symbols become fixed to the current locale at export time
     *   The placeholder currency symbol "&#x00A4" (\u00A4) in a numeric
     *   format string is rendered as the
     * 
     *   NumberUtil.currencySymbol.
     * 
     * 
     *   When exporting, the format string provided to Excel contains the currency symbol for the
     *   current locale of the SmartClient application, and not a placeholder currency symbol that
     *   would make Excel pick up a currency symbol based on the operating system locale. We do this
     *   to ensure that the spreadsheet reflects the application's localization, rather than
     *   the localization of the current user's computer, because they may be different.
     * 
     *   Rounding differences
     *   The approach to rounding a positive number to a set number of decimal places is fairly
     *   universally agreed upon for non-specialized requirements: add 0.5 (or 0.05, or 0.005, or
     *   whatever) to the number and then truncate. This leads to the well understood convention
     *   that numbers exactly halfway between two possible rounding outcomes, go to the larger one.
     *   So 7.5 becomes 8 and 7.15 becomes 7.2.
     * 
     *   However, there is no such universal agreement when it come to rounding negative numbers.
     *   Some take the view that you should round by taking the number to the larger absolute value,
     *   so -7.15 becomes -7.2. Others feel that you should round by taking the number to the larger
     *   value in the sense of it being "less negative", so -7.15 becomes -7.1.
     * 
     *   SmartClient formatting takes the first approach and rounds negative numbers away from zero.
     *   We do this simply because that is what Java DecimalFormat does. Unfortunately, Excel does
     *   the opposite. Therefore, you will see rounding differences on negative numbers on exact
     *   50% boundaries: SmartClient will format -7.15 as -7.2, while Excel will format the same
     *   value as -7.1.
     * 
     *   Different treatment of '#'
     *   Both SmartClient and Excel use '#' to mean "digit, do not show zeroes". However, Excel
     *   does not implement this strictly in the integer part when the number it is formatting has
     *   a value of 0 in the integer part. So, with a format of "#.##", the value 0.25 is formatted
     *   as "0.25". SmartClient (like Java DecimalFormat) is strict: with that format, 0.25 is
     *   formatted as ".25"; if you want to match Excel's output, you must use the format "0.##".
     * 
     *   Miscellaneous edge cases
     *   There is quite a lot of variation in behavior between Java DecimalFormat and Excel around
     *   the edges. For actual error cases - for example, a format string that just contains
     *   nonsense - it is normal and expected that the SmartClient behavior and the Excel behavior
     *   do not match - this is just two systems producing different garbage out for the same
     *   garbage in, which is to be expected. For valid but weird usages - for example, a format
     *   with multiple percent signs - SmartClient's formatting is in line with what DecimalFormat
     *   does, unless DecimalFormat throws an Exception, in which case we just do the thing that
     *   seems most sensible, or the thing that was easiest to implement.
     * 
     *   Known differences in behavior in edge cases include:
     * 
     *  - SmartClient ignores formatting characters in the number part of the format string,
     *   whereas Excel rejects the format (this behavior may vary with different releases of Excel
     *   and supposedly compatible libraries: POI, for example, will accept such format strings).
     *   If you attempt to format 5.175 with the format string "#b0.#a#", SmartClient will return
     *   "5.72", and Excel will reject the format
     * 
     *  - SmartClient ignores quoted characters in the number part of the format string,
     *   whereas Excel preserves them. If you attempt to format 5.175 with the format string
     *   "#'b'0.#'a'#", SmartClient will return "5.72", and Excel will return "b5.7a2"
     * 
     *  - If you specify the empty string as a format string, SmartClient returns the result of
     *   calling toString() on the number; Excel uses the built-in "General" format. These two
     *   approaches will generally give the same or very similar results, but that is really a
     *   coincidence: the correct way to obtain matching results in the browser and the spreadsheet
     *   is to specify a valid format string
     * 
     *  - If you specify a format string that contains no number part (ie, no '#' or '0'
     *   characters), SmartClient does what DecimalFormat does, which is to output the integer part
     *   of the number alongside the fixed part of the format. Excel just outputs the fixed part.
     *   So, if you attempt to format -5.3 with the format string "'Hello world'", SmartClient will
     *   output "-Hello world5", whereas Excel will output just "Hello world"
     * 
     *  - If you specify multiple percent signs in the format, SmartClient treats all but the
     *   first one as static text, so 0.5 formatted with "#%%%" is "50%%%" (ie, all the signs are
     *   preserved but there is only one multiplcation by 100). Excel multiplies for each percent
     *   sign, so 0.5 formatted with "#%%%" is "500000%%%"
     * 
     * 
     *   Date format functionality not supported by Excel
     *   The following date/time/datetime functionality is not supported by Excel; if you use
     *   formatters that use any of this functionality, your values will be exported to Excel
     *   incorrectly formatted. In cases like this, we recommend that you use a separate
     *   exportFormat, with the intent of exporting your values in a way that is
     *   similar to your application formatting (which would be specified with the
     *   DataSourceField.format property), but within the confines of what Excel
     *   supports.
     * 
     * 
     *  - Fiscal year, week and day (LL, LLLL, C, CC, c, cc)
     * 
     *  - Week in year (w, ww)
     * 
     *  - Day in year (D, DD)
     * 
     *  - Day number in week (u)
     * 
     *  - Explicit control over whether to use 12- or 24-hour notation. In Excel, this is
     *   implied by the presence or absence of the AM/PM designator
     * 
     *  - If the user's operating system locale is different to the locale in use in the
     *   SmartClient application, day and month names may be different in the spreadsheet
     * 
     *   Number format functionality not supported by Excel
     *   The only SmartClient number-formatting functionality not supported for
     *   export to Excel is "multiply by 1000 and show as per mille".
     * 
     *   Limit on number of custom Excel formats
     *   Excel limits the number of custom format strings in a single spreadsheet to somewhere
     *   between 200 and 250, depending on your locale and language. Hitting this limit in an export
     *   would require hundreds of field definitions, each defining unique
     *   FormatStrings. If you do hit the limit, the only workaround is to use fewer
     *   unique FormatStrings.
     *  @type {FormatString}
     *  @default null
     */
    open var exportFormat: String = definedExternally
    /**
     *  When DataSourceField.includeFrom is specified and multiple records
     *   exist in the related DataSource per record in the including DataSource,
     *   includeSummaryFunction indicates which SummaryFunction is used to
     *   produce the field value.
     * 
     *   This feature is available with Power or better licenses only.
     *   See smartclient.com/product for details.
     * 
     *   For example, give a DataSource "order" and related DataSource "orderItem", the "itemCount"
     *   field below will show the total number of items in each order.
     * 
     *   &lt;DataSource ID="order"&gt;
     *     &lt;fields&gt;
     *      &lt;field name="orderID" type="integer" primaryKey="true" foreignKey="orderItem.orderID" /&gt;
     *      &lt;field name="customerName" type="text" /&gt;
     *      &lt;field name="orderDate" type="date" /&gt;
     *      &lt;field name="itemsCount" includeFrom="orderItem.quantity" includeSummaryFunction="sum" /&gt;
     *     &lt;/fields&gt;
     *   &lt;/DataSource&gt;
     * 
     *   This is analogous to the following SQL statement:
     * 
     *   SELECT
     *     order.orderID,
     *     order.customerName,
     *     order.orderDate,
     *     (select sum(orderItem.quantity)
     *       from orderItem
     *       where orderItem.orderID = order.orderID) as itemsCount
     *   FROM
     *     order
     * 
     *   Some other common uses:
     * 
     * 
     *  - using "max" to show the most recent "order" for a "customer"
     * 
     *  - using "avg" to show the average order size for a "customer"
     * 
     *  - using "concat" to show the names of all "salesReps" involved in an "order" (note:
     *     "concat" has limited support - see SummaryFunction).
     * 
     * 
     *   NOTE: includeSummaryFunction and
     *   serverSummaries cannot be used in the same DSRequest.
     *   If both configurations are present, Server Summaries settings always take priority.
     *  @type {SummaryFunction}
     *  @default null
     */
    open var includeSummaryFunction: 
                                     /**
                                      *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                                      *   any non numeric field values are encountered.
                                      *   Server: acts exactly like SQL SUM function.
                                      *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                                      *   summary value if any non numeric field values are encountered.
                                      *   Server: acts exactly like SQL AVG function.
                                      *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                                      *   date type fields only. Returns null to indicate invalid
                                      *   summary value if any non numeric/date field values are encountered.
                                      *   Server: acts exactly like SQL MAX function.
                                      *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                                      *   date type fields only. Returns null to indicate invalid summary value if
                                      *   any non numeric field values are encountered.
                                      *   Server: acts exactly like SQL MIN function.
                                      *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                                      *   Returns null to indicate invalid summary value if
                                      *   any non numeric field values are encountered.
                                      *   Server: not supported.
                                      *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                                      *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                                      *   Server: not supported.
                                      *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                                      *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                                      *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                                      *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                                      *   values for concatenation. See also DataSourceField.joinPrefix,
                                      *   DataSourceField.joinString and DataSourceField.joinSuffix
                                      *   related datasource field attributes.
                                      */
                                     String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */ = definedExternally
    /**
     *  Defines prefix before concatenated values if field is used with
     *   serverSummaries feature and the
     *   SummaryFunction is "concat".
     *  @type {string}
     *  @default null
     */
    open var joinPrefix: String = definedExternally
    /**
     *  Defines the delimiter between concatenated values if field is used with
     *   serverSummaries feature and the
     *   SummaryFunction is "concat". The default
     *   value is ", ".
     *  @type {string}
     *  @default null
     */
    open var joinString: String = definedExternally
    /**
     *  Defines suffix after concatenated values if field is used with
     *   serverSummaries feature and the
     *   SummaryFunction is "concat".
     *  @type {string}
     *  @default null
     */
    open var joinSuffix: String = definedExternally
    /**
     *  Affects whether client dsRequests can request summaries for this field.
     * 
     *   Default setting of null means that the DataSource-wide default setting
     *   DataSource.allowClientRequestedSummaries is used for this field.
     *  @type {boolean}
     *  @default null
     */
    open var allowClientRequestedSummaries: Boolean = definedExternally
    /**
     *  Before we start editing this field in a DataBoundComponent, should we perform a deep clone
     *   of the underlying field value. See DataSource.deepCloneOnEdit for details of what
     *   this means.
     * 
     *   If this value is not explicitly set, it defaults first to the value of
     *   DataBoundComponent.deepCloneOnEdit, then to the value of DataSource.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    open var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  List of operators valid on this field.
     * 
     *   If not specified, all operators that are valid for the field type are allowed.
     *  @type {Array<Partial<OperatorId>>}
     *  @default null
     */
    open var validOperators: Array<dynamic> = definedExternally
}