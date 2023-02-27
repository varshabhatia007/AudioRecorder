package com.example.audiorecorder.record

import java.io.File

interface AudioRecorder {
    // Start the file which was added by user
    fun start(outputFile: File)

    // Stop the audio file
    fun stop()
}