@file:JsQualifier("isc")
package isc

/**
 *  Represents a native DOM element used by the browser.
 * 
 *   For example, you can retrieve the DOM element representing the "Set Data" button from
 *   "Empty Grid" Sample
 *   in the SmartClient Feature Explorer using AutoTest.getElement:
 * 
 *   var buttonElement = isc.AutoTest.getElement("scLocator=//testRoot[]/child[Class=IButton||index=1||length=3||classIndex=0||classLength=2||roleIndex=0||roleLength=2||title=Set%20Data||scRole=button]/");
 *   This is a more robust way to obtain a DOM element than retreiving it by ID:
 * 
 *   var buttonElement = document.getElementById("isc_FZ")
 */
open external class DOMElement {
}