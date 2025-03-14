package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * List of not restored reasons for back-forward cache.
 */
@Experimental
@Generated
public enum BackForwardCacheNotRestoredReason {
  @JsonProperty("NotPrimaryMainFrame")
  NOT_PRIMARY_MAIN_FRAME,

  @JsonProperty("BackForwardCacheDisabled")
  BACK_FORWARD_CACHE_DISABLED,

  @JsonProperty("RelatedActiveContentsExist")
  RELATED_ACTIVE_CONTENTS_EXIST,

  @JsonProperty("HTTPStatusNotOK")
  H_T_T_P_STATUS_NOT_O_K,

  @JsonProperty("SchemeNotHTTPOrHTTPS")
  SCHEME_NOT_H_T_T_P_OR_H_T_T_P_S,

  @JsonProperty("Loading")
  LOADING,

  @JsonProperty("WasGrantedMediaAccess")
  WAS_GRANTED_MEDIA_ACCESS,

  @JsonProperty("DisableForRenderFrameHostCalled")
  DISABLE_FOR_RENDER_FRAME_HOST_CALLED,

  @JsonProperty("DomainNotAllowed")
  DOMAIN_NOT_ALLOWED,

  @JsonProperty("HTTPMethodNotGET")
  H_T_T_P_METHOD_NOT_G_E_T,

  @JsonProperty("SubframeIsNavigating")
  SUBFRAME_IS_NAVIGATING,

  @JsonProperty("Timeout")
  TIMEOUT,

  @JsonProperty("CacheLimit")
  CACHE_LIMIT,

  @JsonProperty("JavaScriptExecution")
  JAVA_SCRIPT_EXECUTION,

  @JsonProperty("RendererProcessKilled")
  RENDERER_PROCESS_KILLED,

  @JsonProperty("RendererProcessCrashed")
  RENDERER_PROCESS_CRASHED,

  @JsonProperty("SchedulerTrackedFeatureUsed")
  SCHEDULER_TRACKED_FEATURE_USED,

  @JsonProperty("ConflictingBrowsingInstance")
  CONFLICTING_BROWSING_INSTANCE,

  @JsonProperty("CacheFlushed")
  CACHE_FLUSHED,

  @JsonProperty("ServiceWorkerVersionActivation")
  SERVICE_WORKER_VERSION_ACTIVATION,

  @JsonProperty("SessionRestored")
  SESSION_RESTORED,

  @JsonProperty("ServiceWorkerPostMessage")
  SERVICE_WORKER_POST_MESSAGE,

  @JsonProperty("EnteredBackForwardCacheBeforeServiceWorkerHostAdded")
  ENTERED_BACK_FORWARD_CACHE_BEFORE_SERVICE_WORKER_HOST_ADDED,

  @JsonProperty("RenderFrameHostReused_SameSite")
  RENDER_FRAME_HOST_REUSED__SAME_SITE,

  @JsonProperty("RenderFrameHostReused_CrossSite")
  RENDER_FRAME_HOST_REUSED__CROSS_SITE,

  @JsonProperty("ServiceWorkerClaim")
  SERVICE_WORKER_CLAIM,

  @JsonProperty("IgnoreEventAndEvict")
  IGNORE_EVENT_AND_EVICT,

  @JsonProperty("HaveInnerContents")
  HAVE_INNER_CONTENTS,

  @JsonProperty("TimeoutPuttingInCache")
  TIMEOUT_PUTTING_IN_CACHE,

  @JsonProperty("BackForwardCacheDisabledByLowMemory")
  BACK_FORWARD_CACHE_DISABLED_BY_LOW_MEMORY,

  @JsonProperty("BackForwardCacheDisabledByCommandLine")
  BACK_FORWARD_CACHE_DISABLED_BY_COMMAND_LINE,

  @JsonProperty("NetworkRequestDatapipeDrainedAsBytesConsumer")
  NETWORK_REQUEST_DATAPIPE_DRAINED_AS_BYTES_CONSUMER,

  @JsonProperty("NetworkRequestRedirected")
  NETWORK_REQUEST_REDIRECTED,

  @JsonProperty("NetworkRequestTimeout")
  NETWORK_REQUEST_TIMEOUT,

  @JsonProperty("NetworkExceedsBufferLimit")
  NETWORK_EXCEEDS_BUFFER_LIMIT,

  @JsonProperty("NavigationCancelledWhileRestoring")
  NAVIGATION_CANCELLED_WHILE_RESTORING,

  @JsonProperty("NotMostRecentNavigationEntry")
  NOT_MOST_RECENT_NAVIGATION_ENTRY,

  @JsonProperty("BackForwardCacheDisabledForPrerender")
  BACK_FORWARD_CACHE_DISABLED_FOR_PRERENDER,

  @JsonProperty("UserAgentOverrideDiffers")
  USER_AGENT_OVERRIDE_DIFFERS,

  @JsonProperty("ForegroundCacheLimit")
  FOREGROUND_CACHE_LIMIT,

  @JsonProperty("BrowsingInstanceNotSwapped")
  BROWSING_INSTANCE_NOT_SWAPPED,

  @JsonProperty("BackForwardCacheDisabledForDelegate")
  BACK_FORWARD_CACHE_DISABLED_FOR_DELEGATE,

  @JsonProperty("UnloadHandlerExistsInMainFrame")
  UNLOAD_HANDLER_EXISTS_IN_MAIN_FRAME,

  @JsonProperty("UnloadHandlerExistsInSubFrame")
  UNLOAD_HANDLER_EXISTS_IN_SUB_FRAME,

  @JsonProperty("ServiceWorkerUnregistration")
  SERVICE_WORKER_UNREGISTRATION,

  @JsonProperty("CacheControlNoStore")
  CACHE_CONTROL_NO_STORE,

  @JsonProperty("CacheControlNoStoreCookieModified")
  CACHE_CONTROL_NO_STORE_COOKIE_MODIFIED,

  @JsonProperty("CacheControlNoStoreHTTPOnlyCookieModified")
  CACHE_CONTROL_NO_STORE_H_T_T_P_ONLY_COOKIE_MODIFIED,

  @JsonProperty("NoResponseHead")
  NO_RESPONSE_HEAD,

  @JsonProperty("Unknown")
  UNKNOWN,

  @JsonProperty("ActivationNavigationsDisallowedForBug1234857")
  ACTIVATION_NAVIGATIONS_DISALLOWED_FOR_BUG1234857,

  @JsonProperty("ErrorDocument")
  ERROR_DOCUMENT,

  @JsonProperty("FencedFramesEmbedder")
  FENCED_FRAMES_EMBEDDER,

  @JsonProperty("CookieDisabled")
  COOKIE_DISABLED,

  @JsonProperty("HTTPAuthRequired")
  H_T_T_P_AUTH_REQUIRED,

  @JsonProperty("CookieFlushed")
  COOKIE_FLUSHED,

  @JsonProperty("BroadcastChannelOnMessage")
  BROADCAST_CHANNEL_ON_MESSAGE,

  @JsonProperty("WebViewSettingsChanged")
  WEB_VIEW_SETTINGS_CHANGED,

  @JsonProperty("WebViewJavaScriptObjectChanged")
  WEB_VIEW_JAVA_SCRIPT_OBJECT_CHANGED,

  @JsonProperty("WebViewMessageListenerInjected")
  WEB_VIEW_MESSAGE_LISTENER_INJECTED,

  @JsonProperty("WebViewSafeBrowsingAllowlistChanged")
  WEB_VIEW_SAFE_BROWSING_ALLOWLIST_CHANGED,

  @JsonProperty("WebViewDocumentStartJavascriptChanged")
  WEB_VIEW_DOCUMENT_START_JAVASCRIPT_CHANGED,

  @JsonProperty("WebSocket")
  WEB_SOCKET,

  @JsonProperty("WebTransport")
  WEB_TRANSPORT,

  @JsonProperty("WebRTC")
  WEB_R_T_C,

  @JsonProperty("MainResourceHasCacheControlNoStore")
  MAIN_RESOURCE_HAS_CACHE_CONTROL_NO_STORE,

  @JsonProperty("MainResourceHasCacheControlNoCache")
  MAIN_RESOURCE_HAS_CACHE_CONTROL_NO_CACHE,

  @JsonProperty("SubresourceHasCacheControlNoStore")
  SUBRESOURCE_HAS_CACHE_CONTROL_NO_STORE,

  @JsonProperty("SubresourceHasCacheControlNoCache")
  SUBRESOURCE_HAS_CACHE_CONTROL_NO_CACHE,

  @JsonProperty("ContainsPlugins")
  CONTAINS_PLUGINS,

  @JsonProperty("DocumentLoaded")
  DOCUMENT_LOADED,

  @JsonProperty("OutstandingNetworkRequestOthers")
  OUTSTANDING_NETWORK_REQUEST_OTHERS,

  @JsonProperty("RequestedMIDIPermission")
  REQUESTED_M_I_D_I_PERMISSION,

  @JsonProperty("RequestedAudioCapturePermission")
  REQUESTED_AUDIO_CAPTURE_PERMISSION,

  @JsonProperty("RequestedVideoCapturePermission")
  REQUESTED_VIDEO_CAPTURE_PERMISSION,

  @JsonProperty("RequestedBackForwardCacheBlockedSensors")
  REQUESTED_BACK_FORWARD_CACHE_BLOCKED_SENSORS,

  @JsonProperty("RequestedBackgroundWorkPermission")
  REQUESTED_BACKGROUND_WORK_PERMISSION,

  @JsonProperty("BroadcastChannel")
  BROADCAST_CHANNEL,

  @JsonProperty("WebXR")
  WEB_X_R,

  @JsonProperty("SharedWorker")
  SHARED_WORKER,

  @JsonProperty("WebLocks")
  WEB_LOCKS,

  @JsonProperty("WebHID")
  WEB_H_I_D,

  @JsonProperty("WebShare")
  WEB_SHARE,

  @JsonProperty("RequestedStorageAccessGrant")
  REQUESTED_STORAGE_ACCESS_GRANT,

  @JsonProperty("WebNfc")
  WEB_NFC,

  @JsonProperty("OutstandingNetworkRequestFetch")
  OUTSTANDING_NETWORK_REQUEST_FETCH,

  @JsonProperty("OutstandingNetworkRequestXHR")
  OUTSTANDING_NETWORK_REQUEST_X_H_R,

  @JsonProperty("AppBanner")
  APP_BANNER,

  @JsonProperty("Printing")
  PRINTING,

  @JsonProperty("WebDatabase")
  WEB_DATABASE,

  @JsonProperty("PictureInPicture")
  PICTURE_IN_PICTURE,

  @JsonProperty("SpeechRecognizer")
  SPEECH_RECOGNIZER,

  @JsonProperty("IdleManager")
  IDLE_MANAGER,

  @JsonProperty("PaymentManager")
  PAYMENT_MANAGER,

  @JsonProperty("SpeechSynthesis")
  SPEECH_SYNTHESIS,

  @JsonProperty("KeyboardLock")
  KEYBOARD_LOCK,

  @JsonProperty("WebOTPService")
  WEB_O_T_P_SERVICE,

  @JsonProperty("OutstandingNetworkRequestDirectSocket")
  OUTSTANDING_NETWORK_REQUEST_DIRECT_SOCKET,

  @JsonProperty("InjectedJavascript")
  INJECTED_JAVASCRIPT,

  @JsonProperty("InjectedStyleSheet")
  INJECTED_STYLE_SHEET,

  @JsonProperty("KeepaliveRequest")
  KEEPALIVE_REQUEST,

  @JsonProperty("IndexedDBEvent")
  INDEXED_D_B_EVENT,

  @JsonProperty("Dummy")
  DUMMY,

  @JsonProperty("JsNetworkRequestReceivedCacheControlNoStoreResource")
  JS_NETWORK_REQUEST_RECEIVED_CACHE_CONTROL_NO_STORE_RESOURCE,

  @JsonProperty("WebRTCSticky")
  WEB_R_T_C_STICKY,

  @JsonProperty("WebTransportSticky")
  WEB_TRANSPORT_STICKY,

  @JsonProperty("WebSocketSticky")
  WEB_SOCKET_STICKY,

  @JsonProperty("SmartCard")
  SMART_CARD,

  @JsonProperty("LiveMediaStreamTrack")
  LIVE_MEDIA_STREAM_TRACK,

  @JsonProperty("UnloadHandler")
  UNLOAD_HANDLER,

  @JsonProperty("ParserAborted")
  PARSER_ABORTED,

  @JsonProperty("ContentSecurityHandler")
  CONTENT_SECURITY_HANDLER,

  @JsonProperty("ContentWebAuthenticationAPI")
  CONTENT_WEB_AUTHENTICATION_A_P_I,

  @JsonProperty("ContentFileChooser")
  CONTENT_FILE_CHOOSER,

  @JsonProperty("ContentSerial")
  CONTENT_SERIAL,

  @JsonProperty("ContentFileSystemAccess")
  CONTENT_FILE_SYSTEM_ACCESS,

  @JsonProperty("ContentMediaDevicesDispatcherHost")
  CONTENT_MEDIA_DEVICES_DISPATCHER_HOST,

  @JsonProperty("ContentWebBluetooth")
  CONTENT_WEB_BLUETOOTH,

  @JsonProperty("ContentWebUSB")
  CONTENT_WEB_U_S_B,

  @JsonProperty("ContentMediaSessionService")
  CONTENT_MEDIA_SESSION_SERVICE,

  @JsonProperty("ContentScreenReader")
  CONTENT_SCREEN_READER,

  @JsonProperty("ContentDiscarded")
  CONTENT_DISCARDED,

  @JsonProperty("EmbedderPopupBlockerTabHelper")
  EMBEDDER_POPUP_BLOCKER_TAB_HELPER,

  @JsonProperty("EmbedderSafeBrowsingTriggeredPopupBlocker")
  EMBEDDER_SAFE_BROWSING_TRIGGERED_POPUP_BLOCKER,

  @JsonProperty("EmbedderSafeBrowsingThreatDetails")
  EMBEDDER_SAFE_BROWSING_THREAT_DETAILS,

  @JsonProperty("EmbedderAppBannerManager")
  EMBEDDER_APP_BANNER_MANAGER,

  @JsonProperty("EmbedderDomDistillerViewerSource")
  EMBEDDER_DOM_DISTILLER_VIEWER_SOURCE,

  @JsonProperty("EmbedderDomDistillerSelfDeletingRequestDelegate")
  EMBEDDER_DOM_DISTILLER_SELF_DELETING_REQUEST_DELEGATE,

  @JsonProperty("EmbedderOomInterventionTabHelper")
  EMBEDDER_OOM_INTERVENTION_TAB_HELPER,

  @JsonProperty("EmbedderOfflinePage")
  EMBEDDER_OFFLINE_PAGE,

  @JsonProperty("EmbedderChromePasswordManagerClientBindCredentialManager")
  EMBEDDER_CHROME_PASSWORD_MANAGER_CLIENT_BIND_CREDENTIAL_MANAGER,

  @JsonProperty("EmbedderPermissionRequestManager")
  EMBEDDER_PERMISSION_REQUEST_MANAGER,

  @JsonProperty("EmbedderModalDialog")
  EMBEDDER_MODAL_DIALOG,

  @JsonProperty("EmbedderExtensions")
  EMBEDDER_EXTENSIONS,

  @JsonProperty("EmbedderExtensionMessaging")
  EMBEDDER_EXTENSION_MESSAGING,

  @JsonProperty("EmbedderExtensionMessagingForOpenPort")
  EMBEDDER_EXTENSION_MESSAGING_FOR_OPEN_PORT,

  @JsonProperty("EmbedderExtensionSentMessageToCachedFrame")
  EMBEDDER_EXTENSION_SENT_MESSAGE_TO_CACHED_FRAME,

  @JsonProperty("RequestedByWebViewClient")
  REQUESTED_BY_WEB_VIEW_CLIENT,

  @JsonProperty("PostMessageByWebViewClient")
  POST_MESSAGE_BY_WEB_VIEW_CLIENT,

  @JsonProperty("CacheControlNoStoreDeviceBoundSessionTerminated")
  CACHE_CONTROL_NO_STORE_DEVICE_BOUND_SESSION_TERMINATED,

  @JsonProperty("CacheLimitPruned")
  CACHE_LIMIT_PRUNED
}
