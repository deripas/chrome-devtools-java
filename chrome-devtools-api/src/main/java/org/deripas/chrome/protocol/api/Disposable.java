package org.deripas.chrome.protocol.api;

/**
 * Functional interface for releasing resources or performing cleanup.
 */
@FunctionalInterface
public interface Disposable {
    void dispose();
}