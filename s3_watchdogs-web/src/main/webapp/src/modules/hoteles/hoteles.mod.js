/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule", ['ui.router']);
    mod.constant("hotelesContext", "api/hoteles");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hoteles/';
            $urlRouterProvider.otherwise("/hotelDetail");
            
            $stateProvider.state('hotelDetail', {
                url: '/hoteles/{hotelId:int}/detail',
                param: {
                    hotelId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'hoteles.view.html',
                        controller: 'hotelDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('hotelesCreate', {
                url: '/hoteles/create',
                //parent: 'hotelDetail',
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/hoteles.new.html',
                        controller: 'hotelNewCtrl'
                    }
                }
                }).state('hotelDelete', {
                url: '/hoteles/{hotelId:int}/delete',
                //parent: 'hotelDetail',
                param: {
                    hotelId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/delete/hoteles.delete.html',
                        controller: 'hotelDeleteCtrl'
                    }
                }
                });
        }]);
})(window.angular);