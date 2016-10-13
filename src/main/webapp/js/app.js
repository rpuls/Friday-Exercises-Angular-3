var carApp = angular.module('DemoApp', ['ngRoute']);
carApp.$inject = ['ngRoute', 'CarFactory'];

carApp.config(function ($routeProvider) {
    $routeProvider
            .when("/addcar", {
                templateUrl: "views/addcar.html",
                controller: "ViewCarController"
            })
            .otherwise({
                templateUrl: "views/carlist.html",
                controller: "ViewCarController"
            })
});

carApp.controller('AddEditCarController', ["CarFactory", function (CarFactory) {
        var self = this;
        self.newcar = {};

        self.editCar = function (car) {
            self.newcar = car;

        }

    }]);

var newcar = {};

carApp.controller('ViewCarController', ["$scope", "CarFactory", function ($scope, CarFactory) {
        var self = this;
        self.cars = CarFactory.getCars();
        self.title = "Cars Demo App"
        self.predicate = "year"
        self.reverse = false;
        self.deleteCar = function (car) {
            CarFactory.deleteCar(car.id);
        }
        self.editCar = function (car) {
            newcar = car;
        }
        self.resetCar = function(){
            newcar = {};
        }
        
    }]);

carApp.controller('AddCarController', ["$scope", "CarFactory", function ($scope, CarFactory) {
        var self = this;
        self.newcar = newcar;

        self.addEditCar = function () {
            CarFactory.addEditCar(newcar);
        }
        self.resetCar = function(){
            newcar = {};
        }
    }]);



carApp.factory('CarFactory', function () {
    var cars = [
        {id: 1, year: 1997, registered: new Date(1999, 3, 15), make: 'Ford', model: 'E350', description: 'ac, abs, moon', price: 3000}
        , {id: 2, year: 1999, registered: new Date(1996, 3, 12), make: 'Chevy', model: 'Venture', description: 'None', price: 4900}
        , {id: 3, year: 2000, registered: new Date(199, 12, 22), make: 'Chevy', model: 'Venture', description: '', price: 5000}
        , {id: 4, year: 1996, registered: new Date(2002, 3, 15), make: 'Jeep', model: 'Grand Cherokee', description: 'Moon roof', price: 4799}]
    var nextId = 5;
    var getCars = function () {
        return cars;
    }
    var deleteCar = function (id) {
        for (var i = 0; i < cars.length; i++) {
            if (cars[i].id === id) {
                cars.splice(i, 1);
                return;
            }
        }
    }
    var addEditCar = function (newcar) {
        if (newcar.id == null) {
            newcar.id = nextId++;
            cars.push(newcar);
        } else {
            for (var i = 0; i < cars.length; i++) {
                if (cars[i].id === newcar.id) {
                    cars[i] = newcar;
                    break;
                }
            }
        }
    }
    return {
        getCars: getCars,
        deleteCar: deleteCar,
        addEditCar: addEditCar
    };
});


