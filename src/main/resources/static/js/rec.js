/**
 * Created by Sriya on 6/23/16.
 */
'use strict';

// Create an instance
var wavesurfer = Object.create(WaveSurfer);

// Init & load
document.addEventListener('DOMContentLoaded', function () {
    var options = {
        container     : '#waveform',
        waveColor     : 'black',
        interact      : false,
        cursorWidth   : 0
    };
    var micBtn = document.querySelector('#micBtn');

    // Init wavesurfer
    wavesurfer.init(options);

    // Init Microphone plugin
    var microphone = Object.create(WaveSurfer.Microphone);
    microphone.init({
        wavesurfer: wavesurfer
    });
    microphone.on('deviceReady', function() {
        console.info('Device ready!');
    });
    microphone.on('deviceError', function(code) {
        console.warn('Device error: ' + code);
    });

    // start/stop mic on button click
    micBtn.onclick = function() {
        if (microphone.active) {
            microphone.stop();
        } else {
            microphone.start();
        }
    };
    // playbtn.onclick = function() {
    //     wavesurfer.load('http://ia902606.us.archive.org/35/items/shortpoetry_047_librivox/song_cjrg_teasdale_64kb.mp3');
    //     wavesurfer.playPause();
    // };
    
});