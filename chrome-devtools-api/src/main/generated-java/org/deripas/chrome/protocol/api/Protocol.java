package org.deripas.chrome.protocol.api;

import lombok.Generated;
import org.deripas.chrome.protocol.api.accessibility.Accessibility;
import org.deripas.chrome.protocol.api.animation.Animation;
import org.deripas.chrome.protocol.api.audits.Audits;
import org.deripas.chrome.protocol.api.autofill.Autofill;
import org.deripas.chrome.protocol.api.backgroundservice.BackgroundService;
import org.deripas.chrome.protocol.api.bluetoothemulation.BluetoothEmulation;
import org.deripas.chrome.protocol.api.browser.Browser;
import org.deripas.chrome.protocol.api.cachestorage.CacheStorage;
import org.deripas.chrome.protocol.api.cast.Cast;
import org.deripas.chrome.protocol.api.console.Console;
import org.deripas.chrome.protocol.api.css.CSS;
import org.deripas.chrome.protocol.api.debugger.Debugger;
import org.deripas.chrome.protocol.api.deviceaccess.DeviceAccess;
import org.deripas.chrome.protocol.api.deviceorientation.DeviceOrientation;
import org.deripas.chrome.protocol.api.dom.DOM;
import org.deripas.chrome.protocol.api.domdebugger.DOMDebugger;
import org.deripas.chrome.protocol.api.domsnapshot.DOMSnapshot;
import org.deripas.chrome.protocol.api.domstorage.DOMStorage;
import org.deripas.chrome.protocol.api.emulation.Emulation;
import org.deripas.chrome.protocol.api.eventbreakpoints.EventBreakpoints;
import org.deripas.chrome.protocol.api.extensions.Extensions;
import org.deripas.chrome.protocol.api.fedcm.FedCm;
import org.deripas.chrome.protocol.api.fetch.Fetch;
import org.deripas.chrome.protocol.api.filesystem.FileSystem;
import org.deripas.chrome.protocol.api.headlessexperimental.HeadlessExperimental;
import org.deripas.chrome.protocol.api.heapprofiler.HeapProfiler;
import org.deripas.chrome.protocol.api.indexeddb.IndexedDB;
import org.deripas.chrome.protocol.api.input.Input;
import org.deripas.chrome.protocol.api.inspector.Inspector;
import org.deripas.chrome.protocol.api.io.IO;
import org.deripas.chrome.protocol.api.layertree.LayerTree;
import org.deripas.chrome.protocol.api.log.Log;
import org.deripas.chrome.protocol.api.media.Media;
import org.deripas.chrome.protocol.api.memory.Memory;
import org.deripas.chrome.protocol.api.network.Network;
import org.deripas.chrome.protocol.api.overlay.Overlay;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.performance.Performance;
import org.deripas.chrome.protocol.api.performancetimeline.PerformanceTimeline;
import org.deripas.chrome.protocol.api.preload.Preload;
import org.deripas.chrome.protocol.api.profiler.Profiler;
import org.deripas.chrome.protocol.api.pwa.PWA;
import org.deripas.chrome.protocol.api.runtime.Runtime;
import org.deripas.chrome.protocol.api.schema.Schema;
import org.deripas.chrome.protocol.api.security.Security;
import org.deripas.chrome.protocol.api.serviceworker.ServiceWorker;
import org.deripas.chrome.protocol.api.storage.Storage;
import org.deripas.chrome.protocol.api.systeminfo.SystemInfo;
import org.deripas.chrome.protocol.api.target.Target;
import org.deripas.chrome.protocol.api.tethering.Tethering;
import org.deripas.chrome.protocol.api.tracing.Tracing;
import org.deripas.chrome.protocol.api.webaudio.WebAudio;
import org.deripas.chrome.protocol.api.webauthn.WebAuthn;

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
