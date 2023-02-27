package com.example.audiorecorder.playback

import java.io.File

interface AudioPlayer {
    //Play the audio file which was recorded by user
    fun playFile(file: File)

    // Stop the player
    fun stop()
}