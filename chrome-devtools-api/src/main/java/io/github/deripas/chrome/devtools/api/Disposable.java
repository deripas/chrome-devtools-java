package io.github.deripas.chrome.devtools.api;

/**
 * Functional interface for releasing resources or performing cleanup.
 */
@FunctionalInterface
public interface Disposable {
    void dispose();
}