/**
 * Created by Sriya on 6/22/16.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('RecordingsController',RecordingsController);

    RecordingsController.$inject=['$http'];
    function RecordingsController($http){
        var vm = this;
        vm.recordings=[];
        vm.getAll=getAll;
        vm.getRecordings=getRecordings;
        vm.deleteRecording=deleteRecording;
        //vm.downloadRecording=downloadRecording;

        init();

        function init(){
            getAll();
        }
        function getAll(){
            var url="/audio/all/";
            var recordingPromise=$http.get(url);
            recordingPromise.then(function(response){
                vm.recordings=response.data;
            });
        }
        function getRecordings(){
            var url="/audio/getRecording/"+10;
            var recordingPromise=$http.get(url);
            recordingPromise.then(function(response){
                vm.recordings=response.data;
            });
        }

        function deleteRecording(recordId){
            var url="/audio/delete/"+recordId;
            $http.post(url).then(function(response){
                vm.recordings=response.data;
            });

        }
        /*function downloadRecording(recordId){
         var url="/audio/download/"+recordId;
         $http.post(url).then(function (response){
         var blob=new Blob([response]);
         var link=document.createElement('a');
         link.href=window.URL.createObjectURL(blob);
         link.download="myFileName.txt";
         link.click();
         });
         }*/

    }


})();