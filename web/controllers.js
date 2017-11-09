
angular.module('monApp')

        .controller('PatientController', ['Patients',
            function (Patients) {
                this.p = Patients.query();
                this.delete = function (b) {
                    Patients.delete(b);
                    this.p.splice(this.p.indexOf(b), 1);
                };
            }
        ])

        .controller('PatientVenueController', ['Patients',
            function (Patients) {
                this.pv = Patients.query();
                this.delete = function (b) {
                    Patients.delete(b);
                    this.pv.splice(this.pv.indexOf(b), 1);
                };
            }
        ])

        .controller('ModaliteController', ['Modalites',
            function (Modalites) {
                this.m = Modalites.query();
                this.delete = function (b) {
                    Modalites.delete(b);
                    this.m.splice(this.m.indexOf(b), 1);
                };
            }
        ])

        .controller('ModaliteNewController', ['Modalites',
            function (Modalites) {
                this.m = new Modalites();
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons
                    this.m.$save();
                };
            }])

        .controller('ModaliteEditController', ['$routeParams', 'Modalites', '$location',
            function ($routeParams, Modalites, $location) {
                this.m = Modalites.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons/{id} 
                    this.m.$save();
//                    $location.path("/modalites")
                };
            }
        ])

        .controller('CcamController', ['Ccams',
            function (Ccams) {
                this.c = Ccams.query();
                this.delete = function (b) {
                    // appel DELETE asynchrone au service web sur /boites/{id}
                    Ccams.delete(b);
                    // remet à jour le tableau local des boites en suprimant l'élément effacé
                    this.c.splice(this.c.indexOf(b), 1);
                };
            }
        ])

        .controller('CcamNewController', ['ccam',
            function (Ccam) {
                this.c = new Ccam();
                this.update = function () {
                    this.c.$save();
                };
            }]);
