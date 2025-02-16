# Chrome DevTools Protocol JSON Files

This directory contains the JSON files that define the **Chrome DevTools Protocol**. These files describe the methods, events, and types used to interact with Chrome's debugging, profiling, and browser automation capabilities.

### Source

The JSON files are sourced from the official [Chrome DevTools Protocol repository](https://github.com/ChromeDevTools/devtools-protocol/tree/master/json).

---

## 💡 Purpose

These files serve as a base for generating the Java API in this project. They describe the structure of the protocol and are used to automate the creation of client libraries for interacting with the Chrome DevTools Protocol.

### How It Works:

1. **Protocol Definition:** Each JSON file defines a specific domain like "Page" or "Network," outlining the commands and events available.
2. **Automation:** The Java API generator utilizes these files to produce strongly typed interfaces and classes that mirror the protocol's structure.

---

## 🌐 Learn More

To learn more about the Chrome DevTools Protocol, visit the [official documentation](https://chromedevtools.github.io/devtools-protocol/).

---

## 📄 License

The JSON files provided here are part of the Chrome DevTools Protocol, which is distributed under a [BSD-style license](https://github.com/ChromeDevTools/devtools-protocol#license).