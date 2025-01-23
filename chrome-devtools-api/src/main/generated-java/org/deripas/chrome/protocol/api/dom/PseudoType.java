package org.deripas.chrome.protocol.api.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Pseudo element type.
 */
@Generated
public enum PseudoType {
  @JsonProperty("first-line")
  FIRST_LINE,

  @JsonProperty("first-letter")
  FIRST_LETTER,

  @JsonProperty("checkmark")
  CHECKMARK,

  @JsonProperty("before")
  BEFORE,

  @JsonProperty("after")
  AFTER,

  @JsonProperty("picker-icon")
  PICKER_ICON,

  @JsonProperty("marker")
  MARKER,

  @JsonProperty("backdrop")
  BACKDROP,

  @JsonProperty("column")
  COLUMN,

  @JsonProperty("selection")
  SELECTION,

  @JsonProperty("search-text")
  SEARCH_TEXT,

  @JsonProperty("target-text")
  TARGET_TEXT,

  @JsonProperty("spelling-error")
  SPELLING_ERROR,

  @JsonProperty("grammar-error")
  GRAMMAR_ERROR,

  @JsonProperty("highlight")
  HIGHLIGHT,

  @JsonProperty("first-line-inherited")
  FIRST_LINE_INHERITED,

  @JsonProperty("scroll-marker")
  SCROLL_MARKER,

  @JsonProperty("scroll-marker-group")
  SCROLL_MARKER_GROUP,

  @JsonProperty("scroll-button")
  SCROLL_BUTTON,

  @JsonProperty("scrollbar")
  SCROLLBAR,

  @JsonProperty("scrollbar-thumb")
  SCROLLBAR_THUMB,

  @JsonProperty("scrollbar-button")
  SCROLLBAR_BUTTON,

  @JsonProperty("scrollbar-track")
  SCROLLBAR_TRACK,

  @JsonProperty("scrollbar-track-piece")
  SCROLLBAR_TRACK_PIECE,

  @JsonProperty("scrollbar-corner")
  SCROLLBAR_CORNER,

  @JsonProperty("resizer")
  RESIZER,

  @JsonProperty("input-list-button")
  INPUT_LIST_BUTTON,

  @JsonProperty("view-transition")
  VIEW_TRANSITION,

  @JsonProperty("view-transition-group")
  VIEW_TRANSITION_GROUP,

  @JsonProperty("view-transition-image-pair")
  VIEW_TRANSITION_IMAGE_PAIR,

  @JsonProperty("view-transition-old")
  VIEW_TRANSITION_OLD,

  @JsonProperty("view-transition-new")
  VIEW_TRANSITION_NEW,

  @JsonProperty("placeholder")
  PLACEHOLDER,

  @JsonProperty("file-selector-button")
  FILE_SELECTOR_BUTTON,

  @JsonProperty("details-content")
  DETAILS_CONTENT,

  @JsonProperty("picker")
  PICKER
}
