/**
 * Created by Sriya on 6/24/16.
 */
// for golobal delclaration
/* global GLOBAL:true */
var b = document.documentElement;
b.setAttribute('data-useragent', navigator.userAgent);
b.setAttribute('data-platform', navigator.platform);

// HTML5 audio player + playlist controls...
// Inspiration: http://jonhall.info/how_to/create_a_playlist_for_html5_audio
// Mythium Archive: https://archive.org/details/mythium/
jQuery(function ($) {
    var supportsAudio = !!document.createElement('audio').canPlayType;
    if (supportsAudio) {
        var index = 0,
            playing = false,
            mediaPath = '',
            extension = '',
            tracks = $.ajax({
                type: 'GET',
                url: "http://localhost:8080/audio/all",
                dataType: 'json',
            }).then(function (data) {
                var trackCount = (data.length),
                    npAction = $('#npAction'),
                    npTitle = $('#npTitle'),
                    npLength = $('#npLength'),
                    npReference = $('#npReference'),
                    npComment = $('#npComment'),
                    npSource = $('#npSource'),
                    audio = $('#audio1').bind('play', function () {
                        playing = true;
                        npAction.text('Now Playing...');
                    }).bind('pause', function () {
                        playing = false;
                        npAction.text('Paused...1');

                    }).bind('ended', function () {
                        npAction.text('Paused...2');
                        if ((index + 1) < trackCount) {
                            index++;
                            loadTrack(index);
                            audio.play();
                            console.log(index);
                        } else {
                            audio.pause();
                            index = 0;
                            loadTrack(index);
                        }
                    }).get(0),
                    btnPrev = $('#btnPrev').click(function () {
                        if ((index - 1) > -1) {
                            index--;
                            loadTrack(index);
                            if (playing) {
                                audio.play();
                                console.log(index);
                            }
                        } else {
                            audio.pause();
                            index = 0;
                            loadTrack(index);
                        }
                    }),
                    btnNext = $('#btnNext').click(function () {
                        if ((index + 1) < trackCount) {
                            index++;
                            loadTrack(index);
                            if (playing) {
                                audio.play();
                                console.log(index);
                            }
                        } else {
                            audio.pause();
                            index = 0;
                            loadTrack(index);
                        }
                    }),
                    li = $('#plList tr').click(function () {
                        var id = parseInt($(this).index());
                        //if (id !== index) {
                            playTrack(id);
                        // console.log(id);
                        //}
                    }),
                    loadTrack = function (id) {
                        $('.plSel').removeClass('plSel');
                        $('#plList li:eq(' + id + ')').addClass('plSel');
                        npTitle.text(data[id].topicName);
                        npLength.text(data[id].numberOfRecordings);
                        npReference.text(data[id].reference);
                        npComment.text(data[id].comments);
                        npSource.text(data[id].source);
                        index = id;
                        audio.src = mediaPath + data[id].userRecording;
                    },
                    playTrack = function (id) {
                        loadTrack(id);
                        audio.play();
                    }
            });
    }
})


