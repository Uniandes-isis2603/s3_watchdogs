(function (ng) {
    
    var mod = ng.module("opinionesModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/opiniones/';
            
            $urlRouterProvider.otherwise("/opinionesList");
            
            $stateProvider.state('opinionesList', {
                
                url: '/opiniones/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'opiniones.list.html',
                        controller: 'opinionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);