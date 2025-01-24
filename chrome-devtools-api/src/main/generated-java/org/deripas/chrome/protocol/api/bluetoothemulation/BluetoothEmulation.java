package org.deripas.chrome.protocol.api.bluetoothemulation;

import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain allows configuring virtual Bluetooth devices to test
 * the web-bluetooth API.
 */
@Experimental
@Generated
public interface BluetoothEmulation {
  /**
   * Enable the BluetoothEmulation domain.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Disable the BluetoothEmulation domain.
   */
  CompletableFuture<Void> disable();

  /**
   * Simulates a peripheral with |address|, |name| and |knownServiceUuids|
   * that has already been connected to the system.
   */
  CompletableFuture<Void> simulatePreconnectedPeripheral(
      SimulatePreconnectedPeripheralRequest request);

  /**
   * Simulates an advertisement packet described in |entry| being received by
   * the central.
   */
  CompletableFuture<Void> simulateAdvertisement(SimulateAdvertisementRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    /**
     * State of the simulated central.
     */
    private final CentralState state;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SimulatePreconnectedPeripheralRequest {
    private final String address;

    private final String name;

    private final List<ManufacturerData> manufacturerData;

    private final List<String> knownServiceUuids;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SimulateAdvertisementRequest {
    private final ScanEntry entry;
  }
}
