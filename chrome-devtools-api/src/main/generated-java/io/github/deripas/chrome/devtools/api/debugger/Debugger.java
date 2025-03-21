package io.github.deripas.chrome.devtools.api.debugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.runtime.CallArgument;
import io.github.deripas.chrome.devtools.api.runtime.ExceptionDetails;
import io.github.deripas.chrome.devtools.api.runtime.ExecutionContextId;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObjectId;
import io.github.deripas.chrome.devtools.api.runtime.ScriptId;
import io.github.deripas.chrome.devtools.api.runtime.StackTrace;
import io.github.deripas.chrome.devtools.api.runtime.StackTraceId;
import io.github.deripas.chrome.devtools.api.runtime.TimeDelta;
import io.github.deripas.chrome.devtools.api.runtime.UniqueDebuggerId;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * Debugger domain exposes JavaScript debugging capabilities. It allows setting and removing
 * breakpoints, stepping through execution, exploring stack traces, etc.
 */
@RequiredArgsConstructor
@Generated
public class Debugger {
  private final Session session;

  /**
   * Continues execution until specific location is reached.
   */
  public CompletableFuture<Void> continueToLocation(ContinueToLocationRequest request) {
    return session.send("Debugger.continueToLocation", request, Void.class);
  }

  /**
   * Disables debugger for given page.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Debugger.disable", null, Void.class);
  }

  /**
   * Enables debugger for the given page. Clients should not assume that the debugging has been
   * enabled until the result for this command is received.
   */
  public CompletableFuture<EnableResponse> enable(EnableRequest request) {
    return session.send("Debugger.enable", request, EnableResponse.class);
  }

  /**
   * Evaluates expression on a given call frame.
   */
  public CompletableFuture<EvaluateOnCallFrameResponse> evaluateOnCallFrame(
      EvaluateOnCallFrameRequest request) {
    return session.send("Debugger.evaluateOnCallFrame", request, EvaluateOnCallFrameResponse.class);
  }

  /**
   * Returns possible locations for breakpoint. scriptId in start and end range locations should be
   * the same.
   */
  public CompletableFuture<GetPossibleBreakpointsResponse> getPossibleBreakpoints(
      GetPossibleBreakpointsRequest request) {
    return session.send("Debugger.getPossibleBreakpoints", request, GetPossibleBreakpointsResponse.class);
  }

  /**
   * Returns source for the script with given id.
   */
  public CompletableFuture<GetScriptSourceResponse> getScriptSource(
      GetScriptSourceRequest request) {
    return session.send("Debugger.getScriptSource", request, GetScriptSourceResponse.class);
  }

  public CompletableFuture<DisassembleWasmModuleResponse> disassembleWasmModule(
      DisassembleWasmModuleRequest request) {
    return session.send("Debugger.disassembleWasmModule", request, DisassembleWasmModuleResponse.class);
  }

  /**
   * Disassemble the next chunk of lines for the module corresponding to the
   * stream. If disassembly is complete, this API will invalidate the streamId
   * and return an empty chunk. Any subsequent calls for the now invalid stream
   * will return errors.
   */
  public CompletableFuture<NextWasmDisassemblyChunkResponse> nextWasmDisassemblyChunk(
      NextWasmDisassemblyChunkRequest request) {
    return session.send("Debugger.nextWasmDisassemblyChunk", request, NextWasmDisassemblyChunkResponse.class);
  }

  /**
   * This command is deprecated. Use getScriptSource instead.
   */
  @Deprecated
  public CompletableFuture<GetWasmBytecodeResponse> getWasmBytecode(
      GetWasmBytecodeRequest request) {
    return session.send("Debugger.getWasmBytecode", request, GetWasmBytecodeResponse.class);
  }

  /**
   * Returns stack trace with given `stackTraceId`.
   */
  public CompletableFuture<GetStackTraceResponse> getStackTrace(GetStackTraceRequest request) {
    return session.send("Debugger.getStackTrace", request, GetStackTraceResponse.class);
  }

  /**
   * Stops on the next JavaScript statement.
   */
  public CompletableFuture<Void> pause() {
    return session.send("Debugger.pause", null, Void.class);
  }

  @Deprecated
  public CompletableFuture<Void> pauseOnAsyncCall(PauseOnAsyncCallRequest request) {
    return session.send("Debugger.pauseOnAsyncCall", request, Void.class);
  }

  /**
   * Removes JavaScript breakpoint.
   */
  public CompletableFuture<Void> removeBreakpoint(RemoveBreakpointRequest request) {
    return session.send("Debugger.removeBreakpoint", request, Void.class);
  }

  /**
   * Restarts particular call frame from the beginning. The old, deprecated
   * behavior of `restartFrame` is to stay paused and allow further CDP commands
   * after a restart was scheduled. This can cause problems with restarting, so
   * we now continue execution immediatly after it has been scheduled until we
   * reach the beginning of the restarted frame.
   *
   * To stay back-wards compatible, `restartFrame` now expects a `mode`
   * parameter to be present. If the `mode` parameter is missing, `restartFrame`
   * errors out.
   *
   * The various return values are deprecated and `callFrames` is always empty.
   * Use the call frames from the `Debugger#paused` events instead, that fires
   * once V8 pauses at the beginning of the restarted function.
   */
  public CompletableFuture<RestartFrameResponse> restartFrame(RestartFrameRequest request) {
    return session.send("Debugger.restartFrame", request, RestartFrameResponse.class);
  }

  /**
   * Resumes JavaScript execution.
   */
  public CompletableFuture<Void> resume(ResumeRequest request) {
    return session.send("Debugger.resume", request, Void.class);
  }

  /**
   * Searches for given string in script content.
   */
  public CompletableFuture<SearchInContentResponse> searchInContent(
      SearchInContentRequest request) {
    return session.send("Debugger.searchInContent", request, SearchInContentResponse.class);
  }

  /**
   * Enables or disables async call stacks tracking.
   */
  public CompletableFuture<Void> setAsyncCallStackDepth(SetAsyncCallStackDepthRequest request) {
    return session.send("Debugger.setAsyncCallStackDepth", request, Void.class);
  }

  /**
   * Replace previous blackbox execution contexts with passed ones. Forces backend to skip
   * stepping/pausing in scripts in these execution contexts. VM will try to leave blackboxed script by
   * performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
   */
  public CompletableFuture<Void> setBlackboxExecutionContexts(
      SetBlackboxExecutionContextsRequest request) {
    return session.send("Debugger.setBlackboxExecutionContexts", request, Void.class);
  }

  /**
   * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in
   * scripts with url matching one of the patterns. VM will try to leave blackboxed script by
   * performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
   */
  public CompletableFuture<Void> setBlackboxPatterns(SetBlackboxPatternsRequest request) {
    return session.send("Debugger.setBlackboxPatterns", request, Void.class);
  }

  /**
   * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted
   * scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
   * Positions array contains positions where blackbox state is changed. First interval isn't
   * blackboxed. Array should be sorted.
   */
  public CompletableFuture<Void> setBlackboxedRanges(SetBlackboxedRangesRequest request) {
    return session.send("Debugger.setBlackboxedRanges", request, Void.class);
  }

  /**
   * Sets JavaScript breakpoint at a given location.
   */
  public CompletableFuture<SetBreakpointResponse> setBreakpoint(SetBreakpointRequest request) {
    return session.send("Debugger.setBreakpoint", request, SetBreakpointResponse.class);
  }

  /**
   * Sets instrumentation breakpoint.
   */
  public CompletableFuture<SetInstrumentationBreakpointResponse> setInstrumentationBreakpoint(
      SetInstrumentationBreakpointRequest request) {
    return session.send("Debugger.setInstrumentationBreakpoint", request, SetInstrumentationBreakpointResponse.class);
  }

  /**
   * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this
   * command is issued, all existing parsed scripts will have breakpoints resolved and returned in
   * `locations` property. Further matching script parsing will result in subsequent
   * `breakpointResolved` events issued. This logical breakpoint will survive page reloads.
   */
  public CompletableFuture<SetBreakpointByUrlResponse> setBreakpointByUrl(
      SetBreakpointByUrlRequest request) {
    return session.send("Debugger.setBreakpointByUrl", request, SetBreakpointByUrlResponse.class);
  }

  /**
   * Sets JavaScript breakpoint before each call to the given function.
   * If another function was created from the same source as a given one,
   * calling it will also trigger the breakpoint.
   */
  public CompletableFuture<SetBreakpointOnFunctionCallResponse> setBreakpointOnFunctionCall(
      SetBreakpointOnFunctionCallRequest request) {
    return session.send("Debugger.setBreakpointOnFunctionCall", request, SetBreakpointOnFunctionCallResponse.class);
  }

  /**
   * Activates / deactivates all breakpoints on the page.
   */
  public CompletableFuture<Void> setBreakpointsActive(SetBreakpointsActiveRequest request) {
    return session.send("Debugger.setBreakpointsActive", request, Void.class);
  }

  /**
   * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions,
   * or caught exceptions, no exceptions. Initial pause on exceptions state is `none`.
   */
  public CompletableFuture<Void> setPauseOnExceptions(SetPauseOnExceptionsRequest request) {
    return session.send("Debugger.setPauseOnExceptions", request, Void.class);
  }

  /**
   * Changes return value in top frame. Available only at return break position.
   */
  public CompletableFuture<Void> setReturnValue(SetReturnValueRequest request) {
    return session.send("Debugger.setReturnValue", request, Void.class);
  }

  /**
   * Edits JavaScript source live.
   *
   * In general, functions that are currently on the stack can not be edited with
   * a single exception: If the edited function is the top-most stack frame and
   * that is the only activation of that function on the stack. In this case
   * the live edit will be successful and a `Debugger.restartFrame` for the
   * top-most function is automatically triggered.
   */
  public CompletableFuture<SetScriptSourceResponse> setScriptSource(
      SetScriptSourceRequest request) {
    return session.send("Debugger.setScriptSource", request, SetScriptSourceResponse.class);
  }

  /**
   * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
   */
  public CompletableFuture<Void> setSkipAllPauses(SetSkipAllPausesRequest request) {
    return session.send("Debugger.setSkipAllPauses", request, Void.class);
  }

  /**
   * Changes value of variable in a callframe. Object-based scopes are not supported and must be
   * mutated manually.
   */
  public CompletableFuture<Void> setVariableValue(SetVariableValueRequest request) {
    return session.send("Debugger.setVariableValue", request, Void.class);
  }

  /**
   * Steps into the function call.
   */
  public CompletableFuture<Void> stepInto(StepIntoRequest request) {
    return session.send("Debugger.stepInto", request, Void.class);
  }

  /**
   * Steps out of the function call.
   */
  public CompletableFuture<Void> stepOut() {
    return session.send("Debugger.stepOut", null, Void.class);
  }

  /**
   * Steps over the statement.
   */
  public CompletableFuture<Void> stepOver(StepOverRequest request) {
    return session.send("Debugger.stepOver", request, Void.class);
  }

  public Disposable onBreakpointResolved(Consumer<BreakpointResolvedEvent> listener) {
    return session.subscribe("Debugger.breakpointResolved", listener, BreakpointResolvedEvent.class);
  }

  public Disposable onPaused(Consumer<PausedEvent> listener) {
    return session.subscribe("Debugger.paused", listener, PausedEvent.class);
  }

  public Disposable onResumed(Consumer<ResumedEvent> listener) {
    return session.subscribe("Debugger.resumed", listener, ResumedEvent.class);
  }

  public Disposable onScriptFailedToParse(Consumer<ScriptFailedToParseEvent> listener) {
    return session.subscribe("Debugger.scriptFailedToParse", listener, ScriptFailedToParseEvent.class);
  }

  public Disposable onScriptParsed(Consumer<ScriptParsedEvent> listener) {
    return session.subscribe("Debugger.scriptParsed", listener, ScriptParsedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContinueToLocationRequest {
    /**
     * Location to continue to.
     */
    private final Location location;

    @Nullable
    private final TargetCallFrames targetCallFrames;

    public enum TargetCallFrames {
      @JsonProperty("any")
      ANY,

      @JsonProperty("current")
      CURRENT
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
    /**
     * The maximum size in bytes of collected scripts (not referenced by other heap objects)
     * the debugger can hold. Puts no limit if parameter is omitted.
     */
    @Nullable
    @Experimental
    private final Double maxScriptsCacheSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableResponse {
    /**
     * Unique identifier of the debugger.
     */
    @Experimental
    private final UniqueDebuggerId debuggerId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EvaluateOnCallFrameRequest {
    /**
     * Call frame identifier to evaluate on.
     */
    private final CallFrameId callFrameId;

    /**
     * Expression to evaluate.
     */
    private final String expression;

    /**
     * String object group name to put result into (allows rapid releasing resulting object handles
     * using `releaseObjectGroup`).
     */
    @Nullable
    private final String objectGroup;

    /**
     * Specifies whether command line API should be available to the evaluated expression, defaults
     * to false.
     */
    @Nullable
    private final Boolean includeCommandLineAPI;

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
     * execution. Overrides `setPauseOnException` state.
     */
    @Nullable
    private final Boolean silent;

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    @Nullable
    private final Boolean returnByValue;

    /**
     * Whether preview should be generated for the result.
     */
    @Nullable
    @Experimental
    private final Boolean generatePreview;

    /**
     * Whether to throw an exception if side effect cannot be ruled out during evaluation.
     */
    @Nullable
    private final Boolean throwOnSideEffect;

    /**
     * Terminate execution after timing out (number of milliseconds).
     */
    @Nullable
    @Experimental
    private final TimeDelta timeout;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EvaluateOnCallFrameResponse {
    /**
     * Object wrapper for the evaluation result.
     */
    private final RemoteObject result;

    /**
     * Exception details.
     */
    @Nullable
    private final ExceptionDetails exceptionDetails;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetPossibleBreakpointsRequest {
    /**
     * Start of range to search possible breakpoint locations in.
     */
    private final Location start;

    /**
     * End of range to search possible breakpoint locations in (excluding). When not specified, end
     * of scripts is used as end of range.
     */
    @Nullable
    private final Location end;

    /**
     * Only consider locations which are in the same (non-nested) function as start.
     */
    @Nullable
    private final Boolean restrictToFunction;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetPossibleBreakpointsResponse {
    /**
     * List of the possible breakpoint locations.
     */
    private final List<BreakLocation> locations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetScriptSourceRequest {
    /**
     * Id of the script to get source for.
     */
    private final ScriptId scriptId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetScriptSourceResponse {
    /**
     * Script source (empty in case of Wasm bytecode).
     */
    private final String scriptSource;

    /**
     * Wasm bytecode. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String bytecode;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DisassembleWasmModuleRequest {
    /**
     * Id of the script to disassemble
     */
    private final ScriptId scriptId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DisassembleWasmModuleResponse {
    /**
     * For large modules, return a stream from which additional chunks of
     * disassembly can be read successively.
     */
    @Nullable
    private final String streamId;

    /**
     * The total number of lines in the disassembly text.
     */
    private final Integer totalNumberOfLines;

    /**
     * The offsets of all function bodies, in the format [start1, end1,
     * start2, end2, ...] where all ends are exclusive.
     */
    private final List<Integer> functionBodyOffsets;

    /**
     * The first chunk of disassembly.
     */
    private final WasmDisassemblyChunk chunk;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class NextWasmDisassemblyChunkRequest {
    private final String streamId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class NextWasmDisassemblyChunkResponse {
    /**
     * The next chunk of disassembly.
     */
    private final WasmDisassemblyChunk chunk;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetWasmBytecodeRequest {
    /**
     * Id of the Wasm script to get source for.
     */
    private final ScriptId scriptId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetWasmBytecodeResponse {
    /**
     * Script source. (Encoded as a base64 string when passed over JSON)
     */
    private final String bytecode;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetStackTraceRequest {
    private final StackTraceId stackTraceId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetStackTraceResponse {
    private final StackTrace stackTrace;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PauseOnAsyncCallRequest {
    /**
     * Debugger will pause when async call with given stack trace is started.
     */
    private final StackTraceId parentStackTraceId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveBreakpointRequest {
    private final BreakpointId breakpointId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RestartFrameRequest {
    /**
     * Call frame identifier to evaluate on.
     */
    private final CallFrameId callFrameId;

    /**
     * The `mode` parameter must be present and set to 'StepInto', otherwise
     * `restartFrame` will error out.
     */
    @Nullable
    @Experimental
    private final Mode mode;

    public enum Mode {
      @JsonProperty("StepInto")
      STEP_INTO
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RestartFrameResponse {
    /**
     * New stack trace.
     */
    @Deprecated
    private final List<CallFrame> callFrames;

    /**
     * Async stack trace, if any.
     */
    @Nullable
    @Deprecated
    private final StackTrace asyncStackTrace;

    /**
     * Async stack trace, if any.
     */
    @Nullable
    @Deprecated
    private final StackTraceId asyncStackTraceId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResumeRequest {
    /**
     * Set to true to terminate execution upon resuming execution. In contrast
     * to Runtime.terminateExecution, this will allows to execute further
     * JavaScript (i.e. via evaluation) until execution of the paused code
     * is actually resumed, at which point termination is triggered.
     * If execution is currently not paused, this parameter has no effect.
     */
    @Nullable
    private final Boolean terminateOnResume;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SearchInContentRequest {
    /**
     * Id of the script to search in.
     */
    private final ScriptId scriptId;

    /**
     * String to search for.
     */
    private final String query;

    /**
     * If true, search is case sensitive.
     */
    @Nullable
    private final Boolean caseSensitive;

    /**
     * If true, treats string parameter as regex.
     */
    @Nullable
    private final Boolean isRegex;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SearchInContentResponse {
    /**
     * List of search matches.
     */
    private final List<SearchMatch> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAsyncCallStackDepthRequest {
    /**
     * Maximum depth of async call stacks. Setting to `0` will effectively disable collecting async
     * call stacks (default).
     */
    private final Integer maxDepth;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBlackboxExecutionContextsRequest {
    /**
     * Array of execution context unique ids for the debugger to ignore.
     */
    private final List<String> uniqueIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBlackboxPatternsRequest {
    /**
     * Array of regexps that will be used to check script url for blackbox state.
     */
    private final List<String> patterns;

    /**
     * If true, also ignore scripts with no source url.
     */
    @Nullable
    private final Boolean skipAnonymous;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBlackboxedRangesRequest {
    /**
     * Id of the script.
     */
    private final ScriptId scriptId;

    private final List<ScriptPosition> positions;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointRequest {
    /**
     * Location to set breakpoint in.
     */
    private final Location location;

    /**
     * Expression to use as a breakpoint condition. When specified, debugger will only stop on the
     * breakpoint if this expression evaluates to true.
     */
    @Nullable
    private final String condition;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointResponse {
    /**
     * Id of the created breakpoint for further reference.
     */
    private final BreakpointId breakpointId;

    /**
     * Location this breakpoint resolved into.
     */
    private final Location actualLocation;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInstrumentationBreakpointRequest {
    /**
     * Instrumentation name.
     */
    private final Instrumentation instrumentation;

    public enum Instrumentation {
      @JsonProperty("beforeScriptExecution")
      BEFORE_SCRIPT_EXECUTION,

      @JsonProperty("beforeScriptWithSourceMapExecution")
      BEFORE_SCRIPT_WITH_SOURCE_MAP_EXECUTION
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInstrumentationBreakpointResponse {
    /**
     * Id of the created breakpoint for further reference.
     */
    private final BreakpointId breakpointId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointByUrlRequest {
    /**
     * Line number to set breakpoint at.
     */
    private final Integer lineNumber;

    /**
     * URL of the resources to set breakpoint on.
     */
    @Nullable
    private final String url;

    /**
     * Regex pattern for the URLs of the resources to set breakpoints on. Either `url` or
     * `urlRegex` must be specified.
     */
    @Nullable
    private final String urlRegex;

    /**
     * Script hash of the resources to set breakpoint on.
     */
    @Nullable
    private final String scriptHash;

    /**
     * Offset in the line to set breakpoint at.
     */
    @Nullable
    private final Integer columnNumber;

    /**
     * Expression to use as a breakpoint condition. When specified, debugger will only stop on the
     * breakpoint if this expression evaluates to true.
     */
    @Nullable
    private final String condition;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointByUrlResponse {
    /**
     * Id of the created breakpoint for further reference.
     */
    private final BreakpointId breakpointId;

    /**
     * List of the locations this breakpoint resolved into upon addition.
     */
    private final List<Location> locations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointOnFunctionCallRequest {
    /**
     * Function object id.
     */
    private final RemoteObjectId objectId;

    /**
     * Expression to use as a breakpoint condition. When specified, debugger will
     * stop on the breakpoint if this expression evaluates to true.
     */
    @Nullable
    private final String condition;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointOnFunctionCallResponse {
    /**
     * Id of the created breakpoint for further reference.
     */
    private final BreakpointId breakpointId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakpointsActiveRequest {
    /**
     * New value for breakpoints active state.
     */
    private final Boolean active;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetPauseOnExceptionsRequest {
    /**
     * Pause on exceptions mode.
     */
    private final State state;

    public enum State {
      @JsonProperty("none")
      NONE,

      @JsonProperty("caught")
      CAUGHT,

      @JsonProperty("uncaught")
      UNCAUGHT,

      @JsonProperty("all")
      ALL
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetReturnValueRequest {
    /**
     * New return value.
     */
    private final CallArgument newValue;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetScriptSourceRequest {
    /**
     * Id of the script to edit.
     */
    private final ScriptId scriptId;

    /**
     * New content of the script.
     */
    private final String scriptSource;

    /**
     * If true the change will not actually be applied. Dry run may be used to get result
     * description without actually modifying the code.
     */
    @Nullable
    private final Boolean dryRun;

    /**
     * If true, then `scriptSource` is allowed to change the function on top of the stack
     * as long as the top-most stack frame is the only activation of that function.
     */
    @Nullable
    @Experimental
    private final Boolean allowTopFrameEditing;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetScriptSourceResponse {
    /**
     * New stack trace in case editing has happened while VM was stopped.
     */
    @Nullable
    @Deprecated
    private final List<CallFrame> callFrames;

    /**
     * Whether current call stack  was modified after applying the changes.
     */
    @Nullable
    @Deprecated
    private final Boolean stackChanged;

    /**
     * Async stack trace, if any.
     */
    @Nullable
    @Deprecated
    private final StackTrace asyncStackTrace;

    /**
     * Async stack trace, if any.
     */
    @Nullable
    @Deprecated
    private final StackTraceId asyncStackTraceId;

    /**
     * Whether the operation was successful or not. Only `Ok` denotes a
     * successful live edit while the other enum variants denote why
     * the live edit failed.
     */
    @Experimental
    private final Status status;

    /**
     * Exception details if any. Only present when `status` is `CompileError`.
     */
    @Nullable
    private final ExceptionDetails exceptionDetails;

    public enum Status {
      @JsonProperty("Ok")
      OK,

      @JsonProperty("CompileError")
      COMPILE_ERROR,

      @JsonProperty("BlockedByActiveGenerator")
      BLOCKED_BY_ACTIVE_GENERATOR,

      @JsonProperty("BlockedByActiveFunction")
      BLOCKED_BY_ACTIVE_FUNCTION,

      @JsonProperty("BlockedByTopLevelEsModuleChange")
      BLOCKED_BY_TOP_LEVEL_ES_MODULE_CHANGE
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSkipAllPausesRequest {
    /**
     * New value for skip pauses state.
     */
    private final Boolean skip;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetVariableValueRequest {
    /**
     * 0-based number of scope as was listed in scope chain. Only 'local', 'closure' and 'catch'
     * scope types are allowed. Other scopes could be manipulated manually.
     */
    private final Integer scopeNumber;

    /**
     * Variable name.
     */
    private final String variableName;

    /**
     * New variable value.
     */
    private final CallArgument newValue;

    /**
     * Id of callframe that holds variable.
     */
    private final CallFrameId callFrameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StepIntoRequest {
    /**
     * Debugger will pause on the execution of the first async task which was scheduled
     * before next pause.
     */
    @Nullable
    @Experimental
    private final Boolean breakOnAsyncCall;

    /**
     * The skipList specifies location ranges that should be skipped on step into.
     */
    @Nullable
    @Experimental
    private final List<LocationRange> skipList;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StepOverRequest {
    /**
     * The skipList specifies location ranges that should be skipped on step over.
     */
    @Nullable
    @Experimental
    private final List<LocationRange> skipList;
  }

  /**
   * Fired when breakpoint is resolved to an actual script and location.
   * Deprecated in favor of `resolvedBreakpoints` in the `scriptParsed` event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class BreakpointResolvedEvent {
    /**
     * Breakpoint unique identifier.
     */
    private final BreakpointId breakpointId;

    /**
     * Actual breakpoint location.
     */
    private final Location location;
  }

  /**
   * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class PausedEvent {
    /**
     * Call stack the virtual machine stopped on.
     */
    private final List<CallFrame> callFrames;

    /**
     * Pause reason.
     */
    private final Reason reason;

    /**
     * Object containing break-specific auxiliary properties.
     */
    @Nullable
    private final Map data;

    /**
     * Hit breakpoints IDs
     */
    @Nullable
    private final List<String> hitBreakpoints;

    /**
     * Async stack trace, if any.
     */
    @Nullable
    private final StackTrace asyncStackTrace;

    /**
     * Async stack trace, if any.
     */
    @Nullable
    @Experimental
    private final StackTraceId asyncStackTraceId;

    /**
     * Never present, will be removed.
     */
    @Nullable
    @Experimental
    @Deprecated
    private final StackTraceId asyncCallStackTraceId;

    public enum Reason {
      @JsonProperty("ambiguous")
      AMBIGUOUS,

      @JsonProperty("assert")
      ASSERT,

      @JsonProperty("CSPViolation")
      C_S_P_VIOLATION,

      @JsonProperty("debugCommand")
      DEBUG_COMMAND,

      @JsonProperty("DOM")
      D_O_M,

      @JsonProperty("EventListener")
      EVENT_LISTENER,

      @JsonProperty("exception")
      EXCEPTION,

      @JsonProperty("instrumentation")
      INSTRUMENTATION,

      @JsonProperty("OOM")
      O_O_M,

      @JsonProperty("other")
      OTHER,

      @JsonProperty("promiseRejection")
      PROMISE_REJECTION,

      @JsonProperty("XHR")
      X_H_R,

      @JsonProperty("step")
      STEP
    }
  }

  /**
   * Fired when the virtual machine resumed execution.
   */
  public static class ResumedEvent {
  }

  /**
   * Fired when virtual machine fails to parse the script.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScriptFailedToParseEvent {
    /**
     * Identifier of the script parsed.
     */
    private final ScriptId scriptId;

    /**
     * URL or name of the script parsed (if any).
     */
    private final String url;

    /**
     * Line offset of the script within the resource with given URL (for script tags).
     */
    private final Integer startLine;

    /**
     * Column offset of the script within the resource with given URL.
     */
    private final Integer startColumn;

    /**
     * Last line of the script.
     */
    private final Integer endLine;

    /**
     * Length of the last line of the script.
     */
    private final Integer endColumn;

    /**
     * Specifies script creation context.
     */
    private final ExecutionContextId executionContextId;

    /**
     * Content hash of the script, SHA-256.
     */
    private final String hash;

    /**
     * For Wasm modules, the content of the `build_id` custom section.
     */
    private final String buildId;

    /**
     * Embedder-specific auxiliary data likely matching {isDefault: boolean, type: 'default'|'isolated'|'worker', frameId: string}
     */
    @Nullable
    private final Map executionContextAuxData;

    /**
     * URL of source map associated with script (if any).
     */
    @Nullable
    private final String sourceMapURL;

    /**
     * True, if this script has sourceURL.
     */
    @Nullable
    private final Boolean hasSourceURL;

    /**
     * True, if this script is ES6 module.
     */
    @Nullable
    private final Boolean isModule;

    /**
     * This script length.
     */
    @Nullable
    private final Integer length;

    /**
     * JavaScript top stack frame of where the script parsed event was triggered if available.
     */
    @Nullable
    @Experimental
    private final StackTrace stackTrace;

    /**
     * If the scriptLanguage is WebAssembly, the code section offset in the module.
     */
    @Nullable
    @Experimental
    private final Integer codeOffset;

    /**
     * The language of the script.
     */
    @Nullable
    @Experimental
    private final ScriptLanguage scriptLanguage;

    /**
     * The name the embedder supplied for this script.
     */
    @Nullable
    @Experimental
    private final String embedderName;
  }

  /**
   * Fired when virtual machine parses script. This event is also fired for all known and uncollected
   * scripts upon enabling debugger.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScriptParsedEvent {
    /**
     * Identifier of the script parsed.
     */
    private final ScriptId scriptId;

    /**
     * URL or name of the script parsed (if any).
     */
    private final String url;

    /**
     * Line offset of the script within the resource with given URL (for script tags).
     */
    private final Integer startLine;

    /**
     * Column offset of the script within the resource with given URL.
     */
    private final Integer startColumn;

    /**
     * Last line of the script.
     */
    private final Integer endLine;

    /**
     * Length of the last line of the script.
     */
    private final Integer endColumn;

    /**
     * Specifies script creation context.
     */
    private final ExecutionContextId executionContextId;

    /**
     * Content hash of the script, SHA-256.
     */
    private final String hash;

    /**
     * For Wasm modules, the content of the `build_id` custom section.
     */
    private final String buildId;

    /**
     * Embedder-specific auxiliary data likely matching {isDefault: boolean, type: 'default'|'isolated'|'worker', frameId: string}
     */
    @Nullable
    private final Map executionContextAuxData;

    /**
     * True, if this script is generated as a result of the live edit operation.
     */
    @Nullable
    @Experimental
    private final Boolean isLiveEdit;

    /**
     * URL of source map associated with script (if any).
     */
    @Nullable
    private final String sourceMapURL;

    /**
     * True, if this script has sourceURL.
     */
    @Nullable
    private final Boolean hasSourceURL;

    /**
     * True, if this script is ES6 module.
     */
    @Nullable
    private final Boolean isModule;

    /**
     * This script length.
     */
    @Nullable
    private final Integer length;

    /**
     * JavaScript top stack frame of where the script parsed event was triggered if available.
     */
    @Nullable
    @Experimental
    private final StackTrace stackTrace;

    /**
     * If the scriptLanguage is WebAssembly, the code section offset in the module.
     */
    @Nullable
    @Experimental
    private final Integer codeOffset;

    /**
     * The language of the script.
     */
    @Nullable
    @Experimental
    private final ScriptLanguage scriptLanguage;

    /**
     * If the scriptLanguage is WebAssembly, the source of debug symbols for the module.
     */
    @Nullable
    @Experimental
    private final List<DebugSymbols> debugSymbols;

    /**
     * The name the embedder supplied for this script.
     */
    @Nullable
    @Experimental
    private final String embedderName;

    /**
     * The list of set breakpoints in this script if calls to `setBreakpointByUrl`
     * matches this script's URL or hash. Clients that use this list can ignore the
     * `breakpointResolved` event. They are equivalent.
     */
    @Nullable
    @Experimental
    private final List<ResolvedBreakpoint> resolvedBreakpoints;
  }
}
