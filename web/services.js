//  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet

angular.module('monApp').factory('Patients', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/patients/:id?', { id : '@id'} );
}]);

angular.module('monApp').factory('Modalites', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/modalites/:id?', { id : '@id'} );
}])

angular.module('monApp').factory('ccam', ['$resource', function($resource) {
            return $resource('/radiologie/webresources/ccam/:id?', { id : '@id'} );
}])

//OLD
angular.module('monApp').factory('Crayons', ['$resource', function($resource) {
    return $resource('/bureau/webresources/generic/crayons/:id?', { id : '@id'} );
}]);

angular.module('monApp').factory('Boites', ['$resource', function($resource) {
    return $resource('/bureau/webresources/generic/boites/:id', { id : '@id'} );
}]);

