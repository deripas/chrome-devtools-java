package io.github.deripas.chrome.devtools.api;

import lombok.Generated;
import io.github.deripas.chrome.devtools.api.accessibility.Accessibility;
import io.github.deripas.chrome.devtools.api.animation.Animation;
import io.github.deripas.chrome.devtools.api.audits.Audits;
import io.github.deripas.chrome.devtools.api.autofill.Autofill;
import io.github.deripas.chrome.devtools.api.backgroundservice.BackgroundService;
import io.github.deripas.chrome.devtools.api.bluetoothemulation.BluetoothEmulation;
import io.github.deripas.chrome.devtools.api.browser.Browser;
import io.github.deripas.chrome.devtools.api.cachestorage.CacheStorage;
import io.github.deripas.chrome.devtools.api.cast.Cast;
import io.github.deripas.chrome.devtools.api.console.Console;
import io.github.deripas.chrome.devtools.api.css.CSS;
import io.github.deripas.chrome.devtools.api.debugger.Debugger;
import io.github.deripas.chrome.devtools.api.deviceaccess.DeviceAccess;
import io.github.deripas.chrome.devtools.api.deviceorientation.DeviceOrientation;
import io.github.deripas.chrome.devtools.api.dom.DOM;
import io.github.deripas.chrome.devtools.api.domdebugger.DOMDebugger;
import io.github.deripas.chrome.devtools.api.domsnapshot.DOMSnapshot;
import io.github.deripas.chrome.devtools.api.domstorage.DOMStorage;
import io.github.deripas.chrome.devtools.api.emulation.Emulation;
import io.github.deripas.chrome.devtools.api.eventbreakpoints.EventBreakpoints;
import io.github.deripas.chrome.devtools.api.extensions.Extensions;
import io.github.deripas.chrome.devtools.api.fedcm.FedCm;
import io.github.deripas.chrome.devtools.api.fetch.Fetch;
import io.github.deripas.chrome.devtools.api.filesystem.FileSystem;
import io.github.deripas.chrome.devtools.api.headlessexperimental.HeadlessExperimental;
import io.github.deripas.chrome.devtools.api.heapprofiler.HeapProfiler;
import io.github.deripas.chrome.devtools.api.indexeddb.IndexedDB;
import io.github.deripas.chrome.devtools.api.input.Input;
import io.github.deripas.chrome.devtools.api.inspector.Inspector;
import io.github.deripas.chrome.devtools.api.io.IO;
import io.github.deripas.chrome.devtools.api.layertree.LayerTree;
import io.github.deripas.chrome.devtools.api.log.Log;
import io.github.deripas.chrome.devtools.api.media.Media;
import io.github.deripas.chrome.devtools.api.memory.Memory;
import io.github.deripas.chrome.devtools.api.network.Network;
import io.github.deripas.chrome.devtools.api.overlay.Overlay;
import io.github.deripas.chrome.devtools.api.page.Page;
import io.github.deripas.chrome.devtools.api.performance.Performance;
import io.github.deripas.chrome.devtools.api.performancetimeline.PerformanceTimeline;
import io.github.deripas.chrome.devtools.api.preload.Preload;
import io.github.deripas.chrome.devtools.api.profiler.Profiler;
import io.github.deripas.chrome.devtools.api.pwa.PWA;
import io.github.deripas.chrome.devtools.api.runtime.Runtime;
import io.github.deripas.chrome.devtools.api.schema.Schema;
import io.github.deripas.chrome.devtools.api.security.Security;
import io.github.deripas.chrome.devtools.api.serviceworker.ServiceWorker;
import io.github.deripas.chrome.devtools.api.storage.Storage;
import io.github.deripas.chrome.devtools.api.systeminfo.SystemInfo;
import io.github.deripas.chrome.devtools.api.target.Target;
import io.github.deripas.chrome.devtools.api.tethering.Tethering;
import io.github.deripas.chrome.devtools.api.tracing.Tracing;
import io.github.deripas.chrome.devtools.api.webaudio.WebAudio;
import io.github.deripas.chrome.devtools.api.webauthn.WebAuthn;

@Generated
public interface Protocol {
  BackgroundService getBackgroundService();

  SystemInfo getSystemInfo();

  HeadlessExperimental getHeadlessExperimental();

  Memory getMemory();

  HeapProfiler getHeapProfiler();

  Schema getSchema();

  Page getPage();

  Security getSecurity();

  Fetch getFetch();

  Audits getAudits();

  Input getInput();

  Runtime getRuntime();

  WebAuthn getWebAuthn();

  Profiler getProfiler();

  Emulation getEmulation();

  FileSystem getFileSystem();

  Network getNetwork();

  BluetoothEmulation getBluetoothEmulation();

  PWA getPWA();

  Overlay getOverlay();

  CacheStorage getCacheStorage();

  DOM getDOM();

  Log getLog();

  IO getIO();

  FedCm getFedCm();

  Media getMedia();

  Tethering getTethering();

  EventBreakpoints getEventBreakpoints();

  Storage getStorage();

  DeviceAccess getDeviceAccess();

  DOMStorage getDOMStorage();

  Tracing getTracing();

  Performance getPerformance();

  Browser getBrowser();

  PerformanceTimeline getPerformanceTimeline();

  Cast getCast();

  Debugger getDebugger();

  Accessibility getAccessibility();

  Extensions getExtensions();

  DOMSnapshot getDOMSnapshot();

  Target getTarget();

  LayerTree getLayerTree();

  Preload getPreload();

  IndexedDB getIndexedDB();

  Console getConsole();

  Inspector getInspector();

  DeviceOrientation getDeviceOrientation();

  CSS getCSS();

  DOMDebugger getDOMDebugger();

  WebAudio getWebAudio();

  Autofill getAutofill();

  ServiceWorker getServiceWorker();

  Animation getAnimation();
}
