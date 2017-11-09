angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
                .when('/patients', {
                    controller: "PatientController as ctrl",
                    templateUrl: 'listePatients.html'
                })
                .when('/patients/:ipp/', {
                    controller: "VenuesController as ctrl",
                    templateUrl: 'listeVenues.html'
                })
//                .when('/patients/:ipp/:iep/actes', {
//                    controller: "ActesController as ctrl",
//                    templateUrl: 'listeActes.html'
//                })
                ////////////////////////////////////////////////
                .when('/modalites', {
                    controller: "ModaliteController as ctrl",
                    templateUrl: 'listeModalites.html'
                })
//                .when('/modalites/new', {
//                    controller: "ModaliteNewController as ctrl",
//                    templateUrl: 'newModalite.html'
//                })
//                .when('/modalites/edit/:id', {
//                    controller: "ModaliteEditController as ctrl",
//                    templateUrl: 'editModalite.html'
//                })
                /////////////////////////////////////////////////
                .when('/ccam', {
                    controller: "CcamController as ctrl",
                    templateUrl: 'listeCcam.html'
                })
//                .when('/ccam/new', {
//                    controller: "CcamNewController as ctrl",
//                    templateUrl: 'newCcam.html'
//                })
//                .when('/ccam/edit/:id', {
//                    controller: "CcamEditController as ctrl",
//                    templateUrl: 'editCcam.html'
//                })
                .otherwise({redirectTo: '/'});

    }]);

