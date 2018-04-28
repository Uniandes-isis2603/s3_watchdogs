/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("entrenamientosModule");
            mod.constant("entrenamientosContext", "api/entrenamientos");
            mod.controller('entrenamientoUpdateCtrl', ['$scope', '$http', 'entrenamientosContext', '$state', '$rootScope',
                function ($scope, $http, entrenamientosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};

                    var identrenamiento = $state.params.entrenamientoId;

                    $http.get(entrenamientosContext + '/' + identrenamiento).then(function (response) {
                        var entrenamiento = response.data;
                        $scope.data.name = entrenamiento.name;
                    });


                    $scope.createentrenamiento = function () {
                        $http.put(entrenamientosContext + "/" + identrenamiento, $scope.data).then(function (response) {
                            $state.go('serviciosList', {entrenamientoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);
