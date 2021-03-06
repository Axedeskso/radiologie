//  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet

angular.module('monApp').factory('Patients', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/patients/:ipp?', { ipp : '@ipp'} );
}]);

angular.module('monApp').factory('Venues', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/patients/:ipp?/:iep?/', { iep : '@iep'} );
}]);

angular.module('monApp').factory('Actes', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/patients/:ipp?/:iep?/actes/:idActe', { idActe : '@idActe'} );
}]);

angular.module('monApp').factory('Modalites', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/modalites/:id?', { id : '@id'} );
}]);

angular.module('monApp').factory('Ccams', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/ccam/:id?', { id : '@id'} );
}]);