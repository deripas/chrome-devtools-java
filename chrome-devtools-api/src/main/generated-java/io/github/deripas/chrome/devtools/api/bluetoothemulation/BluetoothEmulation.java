package io.github.deripas.chrome.devtools.api.bluetoothemulation;

import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * This domain allows configuring virtual Bluetooth devices to test
 * the web-bluetooth API.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class BluetoothEmulation {
  private final Session session;

  /**
   * Enable the BluetoothEmulation domain.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("BluetoothEmulation.enable", request, Void.class);
  }

  /**
   * Set the state of the simulated central.
   */
  public CompletableFuture<Void> setSimulatedCentralState(SetSimulatedCentralStateRequest request) {
    return session.send("BluetoothEmulation.setSimulatedCentralState", request, Void.class);
  }

  /**
   * Disable the BluetoothEmulation domain.
   */
  public CompletableFuture<Void> disable() {
    return session.send("BluetoothEmulation.disable", null, Void.class);
  }

  /**
   * Simulates a peripheral with |address|, |name| and |knownServiceUuids|
   * that has already been connected to the system.
   */
  public CompletableFuture<Void> simulatePreconnectedPeripheral(
      SimulatePreconnectedPeripheralRequest request) {
    return session.send("BluetoothEmulation.simulatePreconnectedPeripheral", request, Void.class);
  }

  /**
   * Simulates an advertisement packet described in |entry| being received by
   * the central.
   */
  public CompletableFuture<Void> simulateAdvertisement(SimulateAdvertisementRequest request) {
    return session.send("BluetoothEmulation.simulateAdvertisement", request, Void.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
    /**
     * State of the simulated central.
     */
    private final CentralState state;

    /**
     * If the simulated central supports low-energy.
     */
    private final Boolean leSupported;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSimulatedCentralStateRequest {
    /**
     * State of the simulated central.
     */
    private final CentralState state;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SimulatePreconnectedPeripheralRequest {
    private final String address;

    private final String name;

    private final List<ManufacturerData> manufacturerData;

    private final List<String> knownServiceUuids;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SimulateAdvertisementRequest {
    private final ScanEntry entry;
  }
}
