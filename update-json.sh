#!/bin/sh
GITHUB="https://github.com"
GITHUB_RAW="https://raw.githubusercontent.com"
REPO_NAME="/ChromeDevTools/devtools-protocol"
REPO_REF="/refs/heads/master"

curl "$GITHUB_RAW$REPO_NAME$REPO_REF/json/browser_protocol.json" -o protocol/browser_protocol.json
curl "$GITHUB_RAW$REPO_NAME$REPO_REF/json/js_protocol.json" -o protocol/js_protocol.json
