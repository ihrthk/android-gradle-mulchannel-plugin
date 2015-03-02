package org.gradle

class ConfigExtension {
    /**
     * source apk file
     */
    File inputFile
    /**
     * decompress dir
     */
    File tempDir
    /**
     * output dir
     */
    File outputDir
    /**
     * multiple channel
     */
    List<String> channels
}
