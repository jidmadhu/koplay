package com.koplay.util

import org.apache.commons.lang3.ObjectUtils
import org.slf4j.LoggerFactory
import java.io.FileNotFoundException
import java.io.FileReader
import java.net.URI
import java.nio.file.Paths
import java.util.*

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
object PropertyReader : Properties() {

    private val log = LoggerFactory.getLogger(PropertyReader::class.java)
    private val listOfTarget = listOf<String>("LOCALHOST", "DEV", "UAT", "PRD")

    init {
        val targetEnv = try {
            ObjectUtils.firstNonNull(System.getProperty("env"), System.getProperty("<ci-var-env>"), "DEV")
        } catch (e: NullPointerException) {
            log.warn("Target not specified so taking Default env as UAT")
            "DEV"
        }

        val fileName = "$targetEnv.properties"

        try {
            load(FileReader(Paths.get(URI(this::class.java.classLoader.getResource(fileName)!!.toString())).toFile()))
            log.info("Starting the Test on Environment: $targetEnv")
            setProperty("env", targetEnv.uppercase())
        } catch (e: FileNotFoundException) {
            log.error("File Not Found! Please check the location for your configuration File: $fileName")
        }

    }
}