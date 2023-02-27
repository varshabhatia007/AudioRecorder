package com.example.audiorecorder.record

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File
import java.io.FileOutputStream

class AndroidAudioRecorder(private val context: Context) : AudioRecorder {
    private var recorder: MediaRecorder? = null

    private fun createRecorder(): MediaRecorder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else MediaRecorder()
    }

    override fun start(outputFile: File) {
        createRecorder().apply {
            // MIC source = Passing source where we actually want to record
            setAudioSource(MediaRecorder.AudioSource.MIC)
            // Set format for the Media file, Quality of the media
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            // Output of Encoder = AAC Low Complexity (AAC-LC) audio codec
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            // Set FileDescriptor
            setOutputFile(FileOutputStream(outputFile).fd)

            // Prepare the Record
            prepare()
            // Start recording
            start()

            recorder = this
        }
    }

    override fun stop() {
        recorder?.apply {
            stop()
            reset()
        }
        recorder = null
    }
}