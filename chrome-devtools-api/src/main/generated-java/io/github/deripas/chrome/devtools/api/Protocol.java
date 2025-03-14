package io.github.deripas.chrome.devtools.api;

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
import java.lang.String;
import lombok.Generated;
import lombok.Getter;

@Getter
@Generated
public class Protocol {
  private final Session session;

  private final BackgroundService backgroundService;

  private final SystemInfo systemInfo;

  private final HeadlessExperimental headlessExperimental;

  private final Memory memory;

  private final HeapProfiler heapProfiler;

  private final Schema schema;

  private final Page page;

  private final Security security;

  private final Fetch fetch;

  private final Audits audits;

  private final Input input;

  private final Runtime runtime;

  private final WebAuthn webAuthn;

  private final Profiler profiler;

  private final Emulation emulation;

  private final FileSystem fileSystem;

  private final Network network;

  private final BluetoothEmulation bluetoothEmulation;

  private final PWA pWA;

  private final Overlay overlay;

  private final CacheStorage cacheStorage;

  private final DOM dOM;

  private final Log log;

  private final IO iO;

  private final FedCm fedCm;

  private final Media media;

  private final Tethering tethering;

  private final EventBreakpoints eventBreakpoints;

  private final Storage storage;

  private final DeviceAccess deviceAccess;

  private final DOMStorage dOMStorage;

  private final Tracing tracing;

  private final Performance performance;

  private final Browser browser;

  private final PerformanceTimeline performanceTimeline;

  private final Cast cast;

  private final Debugger debugger;

  private final Accessibility accessibility;

  private final Extensions extensions;

  private final DOMSnapshot dOMSnapshot;

  private final Target target;

  private final LayerTree layerTree;

  private final Preload preload;

  private final IndexedDB indexedDB;

  private final Console console;

  private final Inspector inspector;

  private final DeviceOrientation deviceOrientation;

  private final CSS cSS;

  private final DOMDebugger dOMDebugger;

  private final WebAudio webAudio;

  private final Autofill autofill;

  private final ServiceWorker serviceWorker;

  private final Animation animation;

  public Protocol(Session session) {
    this.session = session;
    this.backgroundService = new BackgroundService(session);
    this.systemInfo = new SystemInfo(session);
    this.headlessExperimental = new HeadlessExperimental(session);
    this.memory = new Memory(session);
    this.heapProfiler = new HeapProfiler(session);
    this.schema = new Schema(session);
    this.page = new Page(session);
    this.security = new Security(session);
    this.fetch = new Fetch(session);
    this.audits = new Audits(session);
    this.input = new Input(session);
    this.runtime = new Runtime(session);
    this.webAuthn = new WebAuthn(session);
    this.profiler = new Profiler(session);
    this.emulation = new Emulation(session);
    this.fileSystem = new FileSystem(session);
    this.network = new Network(session);
    this.bluetoothEmulation = new BluetoothEmulation(session);
    this.pWA = new PWA(session);
    this.overlay = new Overlay(session);
    this.cacheStorage = new CacheStorage(session);
    this.dOM = new DOM(session);
    this.log = new Log(session);
    this.iO = new IO(session);
    this.fedCm = new FedCm(session);
    this.media = new Media(session);
    this.tethering = new Tethering(session);
    this.eventBreakpoints = new EventBreakpoints(session);
    this.storage = new Storage(session);
    this.deviceAccess = new DeviceAccess(session);
    this.dOMStorage = new DOMStorage(session);
    this.tracing = new Tracing(session);
    this.performance = new Performance(session);
    this.browser = new Browser(session);
    this.performanceTimeline = new PerformanceTimeline(session);
    this.cast = new Cast(session);
    this.debugger = new Debugger(session);
    this.accessibility = new Accessibility(session);
    this.extensions = new Extensions(session);
    this.dOMSnapshot = new DOMSnapshot(session);
    this.target = new Target(session);
    this.layerTree = new LayerTree(session);
    this.preload = new Preload(session);
    this.indexedDB = new IndexedDB(session);
    this.console = new Console(session);
    this.inspector = new Inspector(session);
    this.deviceOrientation = new DeviceOrientation(session);
    this.cSS = new CSS(session);
    this.dOMDebugger = new DOMDebugger(session);
    this.webAudio = new WebAudio(session);
    this.autofill = new Autofill(session);
    this.serviceWorker = new ServiceWorker(session);
    this.animation = new Animation(session);
  }

  public Protocol withSessionId(String sessionId) {
    return new Protocol(session.withSessionId(sessionId));
  }

  public void close() {
    session.close();
  }
}
