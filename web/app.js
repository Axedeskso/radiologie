angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
        
                .when('/patients', {
                    controller: "PatientController as ctrl",
                    templateUrl: 'listePatients.html'
                })
                .when('/patients/new', {
                    controller: "PatientNewController as ctrl",
                    templateUrl: 'newPatient.html'
                })
                .when('/modalites/edit/:id', {
                    controller: "ModaliteEditController as ctrl",
                    templateUrl: 'editModalite.html'
                })
                .when('/modalites', {
                    controller: "ModaliteController as ctrl",
                    templateUrl: 'listeModalites.html'
                })
                .when('/modalites/new', {
                    controller: "ModaliteNewController as ctrl",
//                    templateUrl: 'newModalite.html'
                })
                .when('/modalites/edit/:id', {
                    controller: "ModaliteEditController as ctrl",
                    templateUrl: 'editModalite.html'
                })
                .when('/ccam', {
                    controller: "CCAMController as ctrl",
                    templateUrl: 'listeCcam.html'
                })
                .when('/ccam/new', {
                    controller: "CCAMNewController as ctrl",
//                    templateUrl: 'newCcam.html'
                })
                .when('/ccam/edit/:id', {
                    controller: "CCAMEditController as ctrl",
//                    templateUrl: 'editModalite.html'
                })
        
                ///OLD
                
                .when('/crayons', {
                    controller: "CrayonsController as ctrl",
                    templateUrl: 'listeCrayon.html'
                })
                .when('/crayon/edit/:id', {
                    controller: "CrayonEditController as ctrl",
                    templateUrl: 'editCrayon.html'
                })
                .when('/crayon/new', {
                    controller: "CrayonNewController as ctrl",
                    templateUrl: 'newCrayon.html'
                })
                .when('/boites', {
                    controller: "BoitesController as ctrl",
                    templateUrl: 'listeBoites.html'
                })
                .when('/boite/edit/:id', {
                    controller: "BoiteEditController as ctrl",
                    templateUrl: 'editBoite.html'
                })
                .when('/boite/new', {
                    controller: "BoiteNewController as ctrl",
                    templateUrl: 'newBoite.html'
                })
                
                //
                
                .otherwise({redirectTo: '/'});
                
    }]);

