package io.github.deripas.chrome.devtools.api.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
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

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects.
 * Evaluation results are returned as mirror object that expose object type, string representation
 * and unique identifier that can be used for further object reference. Original objects are
 * maintained in memory unless they are either explicitly released or are released along with the
 * other objects in their object group.
 */
@Generated
public interface Runtime {
  /**
   * Add handler to promise with given promise object id.
   */
  CompletableFuture<AwaitPromiseResponse> awaitPromise(AwaitPromiseRequest request);

  /**
   * Calls function with given declaration on the given object. Object group of the result is
   * inherited from the target object.
   */
  CompletableFuture<CallFunctionOnResponse> callFunctionOn(CallFunctionOnRequest request);

  /**
   * Compiles expression.
   */
  CompletableFuture<CompileScriptResponse> compileScript(CompileScriptRequest request);

  /**
   * Disables reporting of execution contexts creation.
   */
  CompletableFuture<Void> disable();

  /**
   * Discards collected exceptions and console API calls.
   */
  CompletableFuture<Void> discardConsoleEntries();

  /**
   * Enables reporting of execution contexts creation by means of `executionContextCreated` event.
   * When the reporting gets enabled the event will be sent immediately for each existing execution
   * context.
   */
  CompletableFuture<Void> enable();

  /**
   * Evaluates expression on global object.
   */
  CompletableFuture<EvaluateResponse> evaluate(EvaluateRequest request);

  /**
   * Returns the isolate id.
   */
  CompletableFuture<GetIsolateIdResponse> getIsolateId();

  /**
   * Returns the JavaScript heap usage.
   * It is the total usage of the corresponding isolate not scoped to a particular Runtime.
   */
  CompletableFuture<GetHeapUsageResponse> getHeapUsage();

  /**
   * Returns properties of a given object. Object group of the result is inherited from the target
   * object.
   */
  CompletableFuture<GetPropertiesResponse> getProperties(GetPropertiesRequest request);

  /**
   * Returns all let, const and class variables from global scope.
   */
  CompletableFuture<GlobalLexicalScopeNamesResponse> globalLexicalScopeNames(
      GlobalLexicalScopeNamesRequest request);

  CompletableFuture<QueryObjectsResponse> queryObjects(QueryObjectsRequest request);

  /**
   * Releases remote object with given id.
   */
  CompletableFuture<Void> releaseObject(ReleaseObjectRequest request);

  /**
   * Releases all remote objects that belong to a given group.
   */
  CompletableFuture<Void> releaseObjectGroup(ReleaseObjectGroupRequest request);

  /**
   * Tells inspected instance to run if it was waiting for debugger to attach.
   */
  CompletableFuture<Void> runIfWaitingForDebugger();

  /**
   * Runs script with given id in a given context.
   */
  CompletableFuture<RunScriptResponse> runScript(RunScriptRequest request);

  /**
   * Enables or disables async call stacks tracking.
   */
  CompletableFuture<Void> setAsyncCallStackDepth(SetAsyncCallStackDepthRequest request);

  CompletableFuture<Void> setCustomObjectFormatterEnabled(
      SetCustomObjectFormatterEnabledRequest request);

  CompletableFuture<Void> setMaxCallStackSizeToCapture(SetMaxCallStackSizeToCaptureRequest request);

  /**
   * Terminate current or next JavaScript execution.
   * Will cancel the termination when the outer-most script execution ends.
   */
  CompletableFuture<Void> terminateExecution();

  /**
   * If executionContextId is empty, adds binding with the given name on the
   * global objects of all inspected contexts, including those created later,
   * bindings survive reloads.
   * Binding function takes exactly one argument, this argument should be string,
   * in case of any other input, function throws an exception.
   * Each binding function call produces Runtime.bindingCalled notification.
   */
  CompletableFuture<Void> addBinding(AddBindingRequest request);

  /**
   * This method does not remove binding function from global object but
   * unsubscribes current runtime agent from Runtime.bindingCalled notifications.
   */
  CompletableFuture<Void> removeBinding(RemoveBindingRequest request);

  /**
   * This method tries to lookup and populate exception details for a
   * JavaScript Error object.
   * Note that the stackTrace portion of the resulting exceptionDetails will
   * only be populated if the Runtime domain was enabled at the time when the
   * Error was thrown.
   */
  CompletableFuture<GetExceptionDetailsResponse> getExceptionDetails(
      GetExceptionDetailsRequest request);

  Disposable onBindingCalled(Consumer<BindingCalledEvent> listener);

  Disposable onConsoleAPICalled(Consumer<ConsoleAPICalledEvent> listener);

  Disposable onExceptionRevoked(Consumer<ExceptionRevokedEvent> listener);

  Disposable onExceptionThrown(Consumer<ExceptionThrownEvent> listener);

  Disposable onExecutionContextCreated(Consumer<ExecutionContextCreatedEvent> listener);

  Disposable onExecutionContextDestroyed(Consumer<ExecutionContextDestroyedEvent> listener);

  Disposable onExecutionContextsCleared(Consumer<ExecutionContextsClearedEvent> listener);

  Disposable onInspectRequested(Consumer<InspectRequestedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class AwaitPromiseRequest {
    /**
     * Identifier of the promise.
     */
    private final RemoteObjectId promiseObjectId;

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    @Nullable
    private final Boolean returnByValue;

    /**
     * Whether preview should be generated for the result.
     */
    @Nullable
    private final Boolean generatePreview;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AwaitPromiseResponse {
    /**
     * Promise result. Will contain rejected value if promise was rejected.
     */
    private final RemoteObject result;

    /**
     * Exception details if stack strace is available.
     */
    @Nullable
    private final ExceptionDetails exceptionDetails;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CallFunctionOnRequest {
    /**
     * Declaration of the function to call.
     */
    private final String functionDeclaration;

    /**
     * Identifier of the object to call function on. Either objectId or executionContextId should
     * be specified.
     */
    @Nullable
    private final RemoteObjectId objectId;

    /**
     * Call arguments. All call arguments must belong to the same JavaScript world as the target
     * object.
     */
    @Nullable
    private final List<CallArgument> arguments;

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
     * execution. Overrides `setPauseOnException` state.
     */
    @Nullable
    private final Boolean silent;

    /**
     * Whether the result is expected to be a JSON object which should be sent by value.
     * Can be overriden by `serializationOptions`.
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
     * Whether execution should be treated as initiated by user in the UI.
     */
    @Nullable
    private final Boolean userGesture;

    /**
     * Whether execution should `await` for resulting value and return once awaited promise is
     * resolved.
     */
    @Nullable
    private final Boolean awaitPromise;

    /**
     * Specifies execution context which global object will be used to call function on. Either
     * executionContextId or objectId should be specified.
     */
    @Nullable
    private final ExecutionContextId executionContextId;

    /**
     * Symbolic group name that can be used to release multiple objects. If objectGroup is not
     * specified and objectId is, objectGroup will be inherited from object.
     */
    @Nullable
    private final String objectGroup;

    /**
     * Whether to throw an exception if side effect cannot be ruled out during evaluation.
     */
    @Nullable
    @Experimental
    private final Boolean throwOnSideEffect;

    /**
     * An alternative way to specify the execution context to call function on.
     * Compared to contextId that may be reused across processes, this is guaranteed to be
     * system-unique, so it can be used to prevent accidental function call
     * in context different than intended (e.g. as a result of navigation across process
     * boundaries).
     * This is mutually exclusive with `executionContextId`.
     */
    @Nullable
    @Experimental
    private final String uniqueContextId;

    /**
     * Specifies the result serialization. If provided, overrides
     * `generatePreview` and `returnByValue`.
     */
    @Nullable
    @Experimental
    private final SerializationOptions serializationOptions;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CallFunctionOnResponse {
    /**
     * Call result.
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
  class CompileScriptRequest {
    /**
     * Expression to compile.
     */
    private final String expression;

    /**
     * Source url to be set for the script.
     */
    private final String sourceURL;

    /**
     * Specifies whether the compiled script should be persisted.
     */
    private final Boolean persistScript;

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the
     * evaluation will be performed in the context of the inspected page.
     */
    @Nullable
    private final ExecutionContextId executionContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CompileScriptResponse {
    /**
     * Id of the script.
     */
    @Nullable
    private final ScriptId scriptId;

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
  class EvaluateRequest {
    /**
     * Expression to evaluate.
     */
    private final String expression;

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    @Nullable
    private final String objectGroup;

    /**
     * Determines whether Command Line API should be available during the evaluation.
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
     * Specifies in which execution context to perform evaluation. If the parameter is omitted the
     * evaluation will be performed in the context of the inspected page.
     * This is mutually exclusive with `uniqueContextId`, which offers an
     * alternative way to identify the execution context that is more reliable
     * in a multi-process environment.
     */
    @Nullable
    private final ExecutionContextId contextId;

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
     * Whether execution should be treated as initiated by user in the UI.
     */
    @Nullable
    private final Boolean userGesture;

    /**
     * Whether execution should `await` for resulting value and return once awaited promise is
     * resolved.
     */
    @Nullable
    private final Boolean awaitPromise;

    /**
     * Whether to throw an exception if side effect cannot be ruled out during evaluation.
     * This implies `disableBreaks` below.
     */
    @Nullable
    @Experimental
    private final Boolean throwOnSideEffect;

    /**
     * Terminate execution after timing out (number of milliseconds).
     */
    @Nullable
    @Experimental
    private final TimeDelta timeout;

    /**
     * Disable breakpoints during execution.
     */
    @Nullable
    @Experimental
    private final Boolean disableBreaks;

    /**
     * Setting this flag to true enables `let` re-declaration and top-level `await`.
     * Note that `let` variables can only be re-declared if they originate from
     * `replMode` themselves.
     */
    @Nullable
    @Experimental
    private final Boolean replMode;

    /**
     * The Content Security Policy (CSP) for the target might block 'unsafe-eval'
     * which includes eval(), Function(), setTimeout() and setInterval()
     * when called with non-callable arguments. This flag bypasses CSP for this
     * evaluation and allows unsafe-eval. Defaults to true.
     */
    @Nullable
    @Experimental
    private final Boolean allowUnsafeEvalBlockedByCSP;

    /**
     * An alternative way to specify the execution context to evaluate in.
     * Compared to contextId that may be reused across processes, this is guaranteed to be
     * system-unique, so it can be used to prevent accidental evaluation of the expression
     * in context different than intended (e.g. as a result of navigation across process
     * boundaries).
     * This is mutually exclusive with `contextId`.
     */
    @Nullable
    @Experimental
    private final String uniqueContextId;

    /**
     * Specifies the result serialization. If provided, overrides
     * `generatePreview` and `returnByValue`.
     */
    @Nullable
    @Experimental
    private final SerializationOptions serializationOptions;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class EvaluateResponse {
    /**
     * Evaluation result.
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
  class GetIsolateIdResponse {
    /**
     * The isolate id.
     */
    private final String id;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHeapUsageResponse {
    /**
     * Used JavaScript heap size in bytes.
     */
    private final Double usedSize;

    /**
     * Allocated JavaScript heap size in bytes.
     */
    private final Double totalSize;

    /**
     * Used size in bytes in the embedder's garbage-collected heap.
     */
    private final Double embedderHeapUsedSize;

    /**
     * Size in bytes of backing storage for array buffers and external strings.
     */
    private final Double backingStorageSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPropertiesRequest {
    /**
     * Identifier of the object to return properties for.
     */
    private final RemoteObjectId objectId;

    /**
     * If true, returns properties belonging only to the element itself, not to its prototype
     * chain.
     */
    @Nullable
    private final Boolean ownProperties;

    /**
     * If true, returns accessor properties (with getter/setter) only; internal properties are not
     * returned either.
     */
    @Nullable
    @Experimental
    private final Boolean accessorPropertiesOnly;

    /**
     * Whether preview should be generated for the results.
     */
    @Nullable
    @Experimental
    private final Boolean generatePreview;

    /**
     * If true, returns non-indexed properties only.
     */
    @Nullable
    @Experimental
    private final Boolean nonIndexedPropertiesOnly;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPropertiesResponse {
    /**
     * Object properties.
     */
    private final List<PropertyDescriptor> result;

    /**
     * Internal object properties (only of the element itself).
     */
    @Nullable
    private final List<InternalPropertyDescriptor> internalProperties;

    /**
     * Object private properties.
     */
    @Nullable
    @Experimental
    private final List<PrivatePropertyDescriptor> privateProperties;

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
  class GlobalLexicalScopeNamesRequest {
    /**
     * Specifies in which execution context to lookup global scope variables.
     */
    @Nullable
    private final ExecutionContextId executionContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GlobalLexicalScopeNamesResponse {
    private final List<String> names;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QueryObjectsRequest {
    /**
     * Identifier of the prototype to return objects for.
     */
    private final RemoteObjectId prototypeObjectId;

    /**
     * Symbolic group name that can be used to release the results.
     */
    @Nullable
    private final String objectGroup;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QueryObjectsResponse {
    /**
     * Array with objects.
     */
    private final RemoteObject objects;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReleaseObjectRequest {
    /**
     * Identifier of the object to release.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReleaseObjectGroupRequest {
    /**
     * Symbolic object group name.
     */
    private final String objectGroup;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RunScriptRequest {
    /**
     * Id of the script to run.
     */
    private final ScriptId scriptId;

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the
     * evaluation will be performed in the context of the inspected page.
     */
    @Nullable
    private final ExecutionContextId executionContextId;

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    @Nullable
    private final String objectGroup;

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
     * execution. Overrides `setPauseOnException` state.
     */
    @Nullable
    private final Boolean silent;

    /**
     * Determines whether Command Line API should be available during the evaluation.
     */
    @Nullable
    private final Boolean includeCommandLineAPI;

    /**
     * Whether the result is expected to be a JSON object which should be sent by value.
     */
    @Nullable
    private final Boolean returnByValue;

    /**
     * Whether preview should be generated for the result.
     */
    @Nullable
    private final Boolean generatePreview;

    /**
     * Whether execution should `await` for resulting value and return once awaited promise is
     * resolved.
     */
    @Nullable
    private final Boolean awaitPromise;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RunScriptResponse {
    /**
     * Run result.
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
  class SetAsyncCallStackDepthRequest {
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
  class SetCustomObjectFormatterEnabledRequest {
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetMaxCallStackSizeToCaptureRequest {
    private final Integer size;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddBindingRequest {
    private final String name;

    /**
     * If specified, the binding would only be exposed to the specified
     * execution context. If omitted and `executionContextName` is not set,
     * the binding is exposed to all execution contexts of the target.
     * This parameter is mutually exclusive with `executionContextName`.
     * Deprecated in favor of `executionContextName` due to an unclear use case
     * and bugs in implementation (crbug.com/1169639). `executionContextId` will be
     * removed in the future.
     */
    @Nullable
    @Experimental
    @Deprecated
    private final ExecutionContextId executionContextId;

    /**
     * If specified, the binding is exposed to the executionContext with
     * matching name, even for contexts created after the binding is added.
     * See also `ExecutionContext.name` and `worldName` parameter to
     * `Page.addScriptToEvaluateOnNewDocument`.
     * This parameter is mutually exclusive with `executionContextId`.
     */
    @Nullable
    private final String executionContextName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveBindingRequest {
    private final String name;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetExceptionDetailsRequest {
    /**
     * The error object for which to resolve the exception details.
     */
    private final RemoteObjectId errorObjectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetExceptionDetailsResponse {
    @Nullable
    private final ExceptionDetails exceptionDetails;
  }

  /**
   * Notification is issued every time when binding is called.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("bindingCalled")
  class BindingCalledEvent {
    private final String name;

    private final String payload;

    /**
     * Identifier of the context where the call was made.
     */
    private final ExecutionContextId executionContextId;
  }

  /**
   * Issued when console API was called.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("consoleAPICalled")
  class ConsoleAPICalledEvent {
    /**
     * Type of the call.
     */
    private final Type type;

    /**
     * Call arguments.
     */
    private final List<RemoteObject> args;

    /**
     * Identifier of the context where the call was made.
     */
    private final ExecutionContextId executionContextId;

    /**
     * Call timestamp.
     */
    private final Timestamp timestamp;

    /**
     * Stack trace captured when the call was made. The async stack chain is automatically reported for
     * the following call types: `assert`, `error`, `trace`, `warning`. For other types the async call
     * chain can be retrieved using `Debugger.getStackTrace` and `stackTrace.parentId` field.
     */
    @Nullable
    private final StackTrace stackTrace;

    /**
     * Console context descriptor for calls on non-default console context (not console.*):
     * 'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call
     * on named context.
     */
    @Nullable
    @Experimental
    private final String context;

    public enum Type {
      @JsonProperty("log")
      LOG,

      @JsonProperty("debug")
      DEBUG,

      @JsonProperty("info")
      INFO,

      @JsonProperty("error")
      ERROR,

      @JsonProperty("warning")
      WARNING,

      @JsonProperty("dir")
      DIR,

      @JsonProperty("dirxml")
      DIRXML,

      @JsonProperty("table")
      TABLE,

      @JsonProperty("trace")
      TRACE,

      @JsonProperty("clear")
      CLEAR,

      @JsonProperty("startGroup")
      START_GROUP,

      @JsonProperty("startGroupCollapsed")
      START_GROUP_COLLAPSED,

      @JsonProperty("endGroup")
      END_GROUP,

      @JsonProperty("assert")
      ASSERT,

      @JsonProperty("profile")
      PROFILE,

      @JsonProperty("profileEnd")
      PROFILE_END,

      @JsonProperty("count")
      COUNT,

      @JsonProperty("timeEnd")
      TIME_END
    }
  }

  /**
   * Issued when unhandled exception was revoked.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("exceptionRevoked")
  class ExceptionRevokedEvent {
    /**
     * Reason describing why exception was revoked.
     */
    private final String reason;

    /**
     * The id of revoked exception, as reported in `exceptionThrown`.
     */
    private final Integer exceptionId;
  }

  /**
   * Issued when exception was thrown and unhandled.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("exceptionThrown")
  class ExceptionThrownEvent {
    /**
     * Timestamp of the exception.
     */
    private final Timestamp timestamp;

    private final ExceptionDetails exceptionDetails;
  }

  /**
   * Issued when new execution context is created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("executionContextCreated")
  class ExecutionContextCreatedEvent {
    /**
     * A newly created execution context.
     */
    private final ExecutionContextDescription context;
  }

  /**
   * Issued when execution context is destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("executionContextDestroyed")
  class ExecutionContextDestroyedEvent {
    /**
     * Id of the destroyed context
     */
    @Deprecated
    private final ExecutionContextId executionContextId;

    /**
     * Unique Id of the destroyed context
     */
    @Experimental
    private final String executionContextUniqueId;
  }

  /**
   * Issued when all executionContexts were cleared in browser
   */
  @JsonTypeName("executionContextsCleared")
  class ExecutionContextsClearedEvent {
  }

  /**
   * Issued when object should be inspected (for example, as a result of inspect() command line API
   * call).
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("inspectRequested")
  class InspectRequestedEvent {
    private final RemoteObject object;

    private final Map hints;

    /**
     * Identifier of the context where the call was made.
     */
    @Nullable
    @Experimental
    private final ExecutionContextId executionContextId;
  }
}
