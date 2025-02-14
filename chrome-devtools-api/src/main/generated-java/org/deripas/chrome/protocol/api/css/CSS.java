package org.deripas.chrome.protocol.api.css;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.NodeId;
import org.deripas.chrome.protocol.api.dom.PseudoType;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles)
 * have an associated `id` used in subsequent operations on the related object. Each object type has
 * a specific `id` structure, and those are not interchangeable between objects of different kinds.
 * CSS objects can be loaded using the `get*ForNode()` calls (which accept a DOM node id). A client
 * can also keep track of stylesheets via the `styleSheetAdded`/`styleSheetRemoved` events and
 * subsequently load the required stylesheet contents using the `getStyleSheet[Text]()` methods.
 */
@Experimental
@Generated
public interface CSS {
  /**
   * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
   * position specified by `location`.
   */
  CompletableFuture<AddRuleResponse> addRule(AddRuleRequest request);

  /**
   * Returns all class names from specified stylesheet.
   */
  CompletableFuture<CollectClassNamesResponse> collectClassNames(CollectClassNamesRequest request);

  /**
   * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
   */
  CompletableFuture<CreateStyleSheetResponse> createStyleSheet(CreateStyleSheetRequest request);

  /**
   * Disables the CSS agent for the given page.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been
   * enabled until the result of this command is received.
   */
  CompletableFuture<Void> enable();

  /**
   * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
   * the browser.
   */
  CompletableFuture<Void> forcePseudoState(ForcePseudoStateRequest request);

  /**
   * Ensures that the given node is in its starting-style state.
   */
  CompletableFuture<Void> forceStartingStyle(ForceStartingStyleRequest request);

  CompletableFuture<GetBackgroundColorsResponse> getBackgroundColors(
      GetBackgroundColorsRequest request);

  /**
   * Returns the computed style for a DOM node identified by `nodeId`.
   */
  CompletableFuture<GetComputedStyleForNodeResponse> getComputedStyleForNode(
      GetComputedStyleForNodeRequest request);

  /**
   * Resolve the specified values in the context of the provided element.
   * For example, a value of '1em' is evaluated according to the computed
   * 'font-size' of the element and a value 'calc(1px + 2px)' will be
   * resolved to '3px'.
   */
  CompletableFuture<ResolveValuesResponse> resolveValues(ResolveValuesRequest request);

  CompletableFuture<GetLonghandPropertiesResponse> getLonghandProperties(
      GetLonghandPropertiesRequest request);

  /**
   * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
   * attributes) for a DOM node identified by `nodeId`.
   */
  CompletableFuture<GetInlineStylesForNodeResponse> getInlineStylesForNode(
      GetInlineStylesForNodeRequest request);

  /**
   * Returns the styles coming from animations & transitions
   * including the animation & transition styles coming from inheritance chain.
   */
  CompletableFuture<GetAnimatedStylesForNodeResponse> getAnimatedStylesForNode(
      GetAnimatedStylesForNodeRequest request);

  /**
   * Returns requested styles for a DOM node identified by `nodeId`.
   */
  CompletableFuture<GetMatchedStylesForNodeResponse> getMatchedStylesForNode(
      GetMatchedStylesForNodeRequest request);

  /**
   * Returns all media queries parsed by the rendering engine.
   */
  CompletableFuture<GetMediaQueriesResponse> getMediaQueries();

  /**
   * Requests information about platform fonts which we used to render child TextNodes in the given
   * node.
   */
  CompletableFuture<GetPlatformFontsForNodeResponse> getPlatformFontsForNode(
      GetPlatformFontsForNodeRequest request);

  /**
   * Returns the current textual content for a stylesheet.
   */
  CompletableFuture<GetStyleSheetTextResponse> getStyleSheetText(GetStyleSheetTextRequest request);

  /**
   * Returns all layers parsed by the rendering engine for the tree scope of a node.
   * Given a DOM element identified by nodeId, getLayersForNode returns the root
   * layer for the nearest ancestor document or shadow root. The layer root contains
   * the full layer tree for the tree scope and their ordering.
   */
  CompletableFuture<GetLayersForNodeResponse> getLayersForNode(GetLayersForNodeRequest request);

  /**
   * Given a CSS selector text and a style sheet ID, getLocationForSelector
   * returns an array of locations of the CSS selector in the style sheet.
   */
  CompletableFuture<GetLocationForSelectorResponse> getLocationForSelector(
      GetLocationForSelectorRequest request);

  /**
   * Starts tracking the given node for the computed style updates
   * and whenever the computed style is updated for node, it queues
   * a `computedStyleUpdated` event with throttling.
   * There can only be 1 node tracked for computed style updates
   * so passing a new node id removes tracking from the previous node.
   * Pass `undefined` to disable tracking.
   */
  CompletableFuture<Void> trackComputedStyleUpdatesForNode(
      TrackComputedStyleUpdatesForNodeRequest request);

  /**
   * Starts tracking the given computed styles for updates. The specified array of properties
   * replaces the one previously specified. Pass empty array to disable tracking.
   * Use takeComputedStyleUpdates to retrieve the list of nodes that had properties modified.
   * The changes to computed style properties are only tracked for nodes pushed to the front-end
   * by the DOM agent. If no changes to the tracked properties occur after the node has been pushed
   * to the front-end, no updates will be issued for the node.
   */
  CompletableFuture<Void> trackComputedStyleUpdates(TrackComputedStyleUpdatesRequest request);

  /**
   * Polls the next batch of computed style updates.
   */
  CompletableFuture<TakeComputedStyleUpdatesResponse> takeComputedStyleUpdates();

  /**
   * Find a rule with the given active property for the given node and set the new value for this
   * property
   */
  CompletableFuture<Void> setEffectivePropertyValueForNode(
      SetEffectivePropertyValueForNodeRequest request);

  /**
   * Modifies the property rule property name.
   */
  CompletableFuture<SetPropertyRulePropertyNameResponse> setPropertyRulePropertyName(
      SetPropertyRulePropertyNameRequest request);

  /**
   * Modifies the keyframe rule key text.
   */
  CompletableFuture<SetKeyframeKeyResponse> setKeyframeKey(SetKeyframeKeyRequest request);

  /**
   * Modifies the rule selector.
   */
  CompletableFuture<SetMediaTextResponse> setMediaText(SetMediaTextRequest request);

  /**
   * Modifies the expression of a container query.
   */
  CompletableFuture<SetContainerQueryTextResponse> setContainerQueryText(
      SetContainerQueryTextRequest request);

  /**
   * Modifies the expression of a supports at-rule.
   */
  CompletableFuture<SetSupportsTextResponse> setSupportsText(SetSupportsTextRequest request);

  /**
   * Modifies the expression of a scope at-rule.
   */
  CompletableFuture<SetScopeTextResponse> setScopeText(SetScopeTextRequest request);

  /**
   * Modifies the rule selector.
   */
  CompletableFuture<SetRuleSelectorResponse> setRuleSelector(SetRuleSelectorRequest request);

  /**
   * Sets the new stylesheet text.
   */
  CompletableFuture<SetStyleSheetTextResponse> setStyleSheetText(SetStyleSheetTextRequest request);

  /**
   * Applies specified style edits one after another in the given order.
   */
  CompletableFuture<SetStyleTextsResponse> setStyleTexts(SetStyleTextsRequest request);

  /**
   * Enables the selector recording.
   */
  CompletableFuture<Void> startRuleUsageTracking();

  /**
   * Stop tracking rule usage and return the list of rules that were used since last call to
   * `takeCoverageDelta` (or since start of coverage instrumentation).
   */
  CompletableFuture<StopRuleUsageTrackingResponse> stopRuleUsageTracking();

  /**
   * Obtain list of rules that became used since last call to this method (or since start of coverage
   * instrumentation).
   */
  CompletableFuture<TakeCoverageDeltaResponse> takeCoverageDelta();

  /**
   * Enables/disables rendering of local CSS fonts (enabled by default).
   */
  CompletableFuture<Void> setLocalFontsEnabled(SetLocalFontsEnabledRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class AddRuleRequest {
    /**
     * The css style sheet identifier where a new rule should be inserted.
     */
    private final StyleSheetId styleSheetId;

    /**
     * The text of a new rule.
     */
    private final String ruleText;

    /**
     * Text position of a new rule in the target style sheet.
     */
    private final SourceRange location;

    /**
     * NodeId for the DOM node in whose context custom property declarations for registered properties should be
     * validated. If omitted, declarations in the new rule text can only be validated statically, which may produce
     * incorrect results if the declaration contains a var() for example.
     */
    @Nullable
    @Experimental
    private final NodeId nodeForPropertySyntaxValidation;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddRuleResponse {
    /**
     * The newly created rule.
     */
    private final CSSRule rule;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CollectClassNamesRequest {
    private final StyleSheetId styleSheetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CollectClassNamesResponse {
    /**
     * Class name list.
     */
    private final List<String> classNames;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateStyleSheetRequest {
    /**
     * Identifier of the frame where "via-inspector" stylesheet should be created.
     */
    private final FrameId frameId;

    /**
     * If true, creates a new stylesheet for every call. If false,
     * returns a stylesheet previously created by a call with force=false
     * for the frame's document if it exists or creates a new stylesheet
     * (default: false).
     */
    @Nullable
    private final Boolean force;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateStyleSheetResponse {
    /**
     * Identifier of the created "via-inspector" stylesheet.
     */
    private final StyleSheetId styleSheetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ForcePseudoStateRequest {
    /**
     * The element id for which to force the pseudo state.
     */
    private final NodeId nodeId;

    /**
     * Element pseudo classes to force when computing the element's style.
     */
    private final List<String> forcedPseudoClasses;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ForceStartingStyleRequest {
    /**
     * The element id for which to force the starting-style state.
     */
    private final NodeId nodeId;

    /**
     * Boolean indicating if this is on or off.
     */
    private final Boolean forced;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBackgroundColorsRequest {
    /**
     * Id of the node to get background colors for.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBackgroundColorsResponse {
    /**
     * The range of background colors behind this element, if it contains any visible text. If no
     * visible text is present, this will be undefined. In the case of a flat background color,
     * this will consist of simply that color. In the case of a gradient, this will consist of each
     * of the color stops. For anything more complicated, this will be an empty array. Images will
     * be ignored (as if the image had failed to load).
     */
    @Nullable
    private final List<String> backgroundColors;

    /**
     * The computed font size for this node, as a CSS computed value string (e.g. '12px').
     */
    @Nullable
    private final String computedFontSize;

    /**
     * The computed font weight for this node, as a CSS computed value string (e.g. 'normal' or
     * '100').
     */
    @Nullable
    private final String computedFontWeight;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetComputedStyleForNodeRequest {
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetComputedStyleForNodeResponse {
    /**
     * Computed style for the specified DOM node.
     */
    private final List<CSSComputedStyleProperty> computedStyle;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveValuesRequest {
    /**
     * Substitution functions (var()/env()/attr()) and cascade-dependent
     * keywords (revert/revert-layer) do not work.
     */
    private final List<String> values;

    /**
     * Id of the node in whose context the expression is evaluated
     */
    private final NodeId nodeId;

    /**
     * Only longhands and custom property names are accepted.
     */
    @Nullable
    private final String propertyName;

    /**
     * Pseudo element type, only works for pseudo elements that generate
     * elements in the tree, such as ::before and ::after.
     */
    @Nullable
    @Experimental
    private final PseudoType pseudoType;

    /**
     * Pseudo element custom ident.
     */
    @Nullable
    @Experimental
    private final String pseudoIdentifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveValuesResponse {
    private final List<String> results;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLonghandPropertiesRequest {
    private final String shorthandName;

    private final String value;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLonghandPropertiesResponse {
    private final List<CSSProperty> longhandProperties;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetInlineStylesForNodeRequest {
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetInlineStylesForNodeResponse {
    /**
     * Inline style for the specified DOM node.
     */
    @Nullable
    private final CSSStyle inlineStyle;

    /**
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
     */
    @Nullable
    private final CSSStyle attributesStyle;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAnimatedStylesForNodeRequest {
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAnimatedStylesForNodeResponse {
    /**
     * Styles coming from animations.
     */
    @Nullable
    private final List<CSSAnimationStyle> animationStyles;

    /**
     * Style coming from transitions.
     */
    @Nullable
    private final CSSStyle transitionsStyle;

    /**
     * Inherited style entries for animationsStyle and transitionsStyle from
     * the inheritance chain of the element.
     */
    @Nullable
    private final List<InheritedAnimatedStyleEntry> inherited;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetMatchedStylesForNodeRequest {
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetMatchedStylesForNodeResponse {
    /**
     * Inline style for the specified DOM node.
     */
    @Nullable
    private final CSSStyle inlineStyle;

    /**
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
     */
    @Nullable
    private final CSSStyle attributesStyle;

    /**
     * CSS rules matching this node, from all applicable stylesheets.
     */
    @Nullable
    private final List<RuleMatch> matchedCSSRules;

    /**
     * Pseudo style matches for this node.
     */
    @Nullable
    private final List<PseudoElementMatches> pseudoElements;

    /**
     * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
     */
    @Nullable
    private final List<InheritedStyleEntry> inherited;

    /**
     * A chain of inherited pseudo element styles (from the immediate node parent up to the DOM tree root).
     */
    @Nullable
    private final List<InheritedPseudoElementMatches> inheritedPseudoElements;

    /**
     * A list of CSS keyframed animations matching this node.
     */
    @Nullable
    private final List<CSSKeyframesRule> cssKeyframesRules;

    /**
     * A list of CSS @position-try rules matching this node, based on the position-try-fallbacks property.
     */
    @Nullable
    private final List<CSSPositionTryRule> cssPositionTryRules;

    /**
     * Index of the active fallback in the applied position-try-fallback property,
     * will not be set if there is no active position-try fallback.
     */
    @Nullable
    private final Integer activePositionFallbackIndex;

    /**
     * A list of CSS at-property rules matching this node.
     */
    @Nullable
    private final List<CSSPropertyRule> cssPropertyRules;

    /**
     * A list of CSS property registrations matching this node.
     */
    @Nullable
    private final List<CSSPropertyRegistration> cssPropertyRegistrations;

    /**
     * A font-palette-values rule matching this node.
     */
    @Nullable
    private final CSSFontPaletteValuesRule cssFontPaletteValuesRule;

    /**
     * Id of the first parent element that does not have display: contents.
     */
    @Nullable
    @Experimental
    private final NodeId parentLayoutNodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetMediaQueriesResponse {
    private final List<CSSMedia> medias;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPlatformFontsForNodeRequest {
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPlatformFontsForNodeResponse {
    /**
     * Usage statistics for every employed platform font.
     */
    private final List<PlatformFontUsage> fonts;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetStyleSheetTextRequest {
    private final StyleSheetId styleSheetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetStyleSheetTextResponse {
    /**
     * The stylesheet text.
     */
    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLayersForNodeRequest {
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLayersForNodeResponse {
    private final CSSLayerData rootLayer;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLocationForSelectorRequest {
    private final StyleSheetId styleSheetId;

    private final String selectorText;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLocationForSelectorResponse {
    private final List<SourceRange> ranges;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TrackComputedStyleUpdatesForNodeRequest {
    @Nullable
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TrackComputedStyleUpdatesRequest {
    private final List<CSSComputedStyleProperty> propertiesToTrack;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TakeComputedStyleUpdatesResponse {
    /**
     * The list of node Ids that have their tracked computed styles updated.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetEffectivePropertyValueForNodeRequest {
    /**
     * The element id for which to set property.
     */
    private final NodeId nodeId;

    private final String propertyName;

    private final String value;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPropertyRulePropertyNameRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String propertyName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPropertyRulePropertyNameResponse {
    /**
     * The resulting key text after modification.
     */
    private final Value propertyName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetKeyframeKeyRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String keyText;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetKeyframeKeyResponse {
    /**
     * The resulting key text after modification.
     */
    private final Value keyText;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetMediaTextRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetMediaTextResponse {
    /**
     * The resulting CSS media rule after modification.
     */
    private final CSSMedia media;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetContainerQueryTextRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetContainerQueryTextResponse {
    /**
     * The resulting CSS container query rule after modification.
     */
    private final CSSContainerQuery containerQuery;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSupportsTextRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSupportsTextResponse {
    /**
     * The resulting CSS Supports rule after modification.
     */
    private final CSSSupports supports;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetScopeTextRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetScopeTextResponse {
    /**
     * The resulting CSS Scope rule after modification.
     */
    private final CSSScope scope;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetRuleSelectorRequest {
    private final StyleSheetId styleSheetId;

    private final SourceRange range;

    private final String selector;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetRuleSelectorResponse {
    /**
     * The resulting selector list after modification.
     */
    private final SelectorList selectorList;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetStyleSheetTextRequest {
    private final StyleSheetId styleSheetId;

    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetStyleSheetTextResponse {
    /**
     * URL of source map associated with script (if any).
     */
    @Nullable
    private final String sourceMapURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetStyleTextsRequest {
    private final List<StyleDeclarationEdit> edits;

    /**
     * NodeId for the DOM node in whose context custom property declarations for registered properties should be
     * validated. If omitted, declarations in the new rule text can only be validated statically, which may produce
     * incorrect results if the declaration contains a var() for example.
     */
    @Nullable
    @Experimental
    private final NodeId nodeForPropertySyntaxValidation;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetStyleTextsResponse {
    /**
     * The resulting styles after modification.
     */
    private final List<CSSStyle> styles;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopRuleUsageTrackingResponse {
    private final List<RuleUsage> ruleUsage;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TakeCoverageDeltaResponse {
    private final List<RuleUsage> coverage;

    /**
     * Monotonically increasing time, in seconds.
     */
    private final Double timestamp;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetLocalFontsEnabledRequest {
    /**
     * Whether rendering of local fonts is enabled.
     */
    private final Boolean enabled;
  }
}
